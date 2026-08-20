public class Controlador{
    private Atleta atleta;
    private VistaAtleta vista;

    public Controlador(Atleta atleta, VistaAtleta vista){
        this.atleta = atleta;
        this.vista = vista;
    }

    //registrar atleta
    public void registrarAtleta(){
        atleta = vista.registrarAtleta();
        vista.mostrarMensaje("ATLETA REGISTRADO");
    }

    //registra el tiempo nuevo
    public void registarTiempo(){

        if (atleta.getCantidadIntentos() >=10){
            vista.mostrarMensaje("No hay intentos disponibles.");
            return;
        }

        double tiempo = vista.solicitarTiempo();

        // es if no se puede evalidar el tiempo 
        if (!validarTiempo(tiempo)){
            vista.mostrarMensaje("El tiempo debe ser mayor a 0.");
            return;
        }

        int posicion = atleta.getCantidadIntentos();

        atleta.getTiempos()[posicion] = tiempo;

        atleta.setCantidadIntentos(atleta.getCantidadIntentos() + 1);
        vista.mostrarMensaje("Tiempo registrado correctamente.");

    }

    public void consultarTiempos(){

        if (atleta.getCantidadIntentos()==0){
            vista.mostrarMensaje("No hay tiempos registrados en este atleta");
            return ;
        }
        vista.mostrarTiempos(atleta.getTiempos(),atleta.getCantidadIntentos());
    }

    public void consultarIntento(){
        int numeroIntento = vista.solicitarNumeroIntento();
        if (!validarIntento(numeroIntento)) {
            vista.mostrarMensaje("Numero de intento invalido.");
            return;
        }

        double tiempo = atleta.getTiempos()[numeroIntento-1];

        vista.mostrarIntento(numeroIntento, tiempo);
    }

    //modificar un intento ya hecho que sea mayor a 0, :0
    public void modificarTiempo(){
        int numeroIntento = vista.solicitarNumeroIntento();
        if (!validarIntento(numeroIntento)) {
            vista.mostrarMensaje("Numero de intento no es valido");
            return;
        }

        double nuevoTiempo = vista.solicitarTiempo();

        if (!validarTiempo(nuevoTiempo)){
            vista.mostrarMensaje("El tiempo debe de ser mayor a 0 para que se pueda modificar");
        }

        atleta.getTiempos()[numeroIntento - 1] = nuevoTiempo;

        vista.mostrarMensaje("Se logró modificar el tiempo correctamente :)");
    }

    public double calcularPromedio(){
        if (atleta.getCantidadIntentos()==0){
            return 0;
        }

        double suma=0;
        //se va sumando por cada iteracion
        for (int i = 0;i<atleta.getCantidadIntentos();i++){
            suma += atleta.getTiempos()[i];
        }

        return suma/atleta.getCantidadIntentos();
    }

    //encontrar el mejor tiempo
    public double mejorTiempo(){
        if(atleta.getCantidadIntentos()==0){
            return 0 ;
        }
        double mejor = atleta.getTiempos()[0];

        for (int i = 1; i < atleta.getCantidadIntentos(); i++) {

            if (atleta.getTiempos()[i] < mejor) {
                mejor = atleta.getTiempos()[i];
            }

        }
        return mejor;
    }
    
    public double peorTiempo(){
        if(atleta.getTiempos()[0]==0){
            return 0;
        }
        double mayor = atleta.getTiempos()[0];
        for (int i = 0;i< atleta.getCantidadIntentos();i++){
            if (atleta.getTiempos()[i] > mayor) {
                mayor = atleta.getTiempos()[i];
            }
        }
        return mayor;
    }

    public boolean validarTiempo(double tiempo){
        return tiempo>0;
    }

    private boolean validarIntento(int numeroIntento){
        return numeroIntento >=1 && numeroIntento <= atleta.getCantidadIntentos();
    }

    public void mostrarPromedio(){
        if (atleta.getCantidadIntentos()==0){
            vista.mostrarMensaje("No hay tiempos registrados.");
            return;
        }
        vista.mostrarPromedio(calcularPromedio());  
    }

    public void mostrarMejoryMayor(){
        if(atleta.getCantidadIntentos()==0){
            vista.mostrarMensaje("No hay tiempos registrados :(");
            return;
        }
        vista.mostrarMejorYMayor(mejorTiempo(),peorTiempo());
    }

    public void mostrarIntentosDisponibles(){
        int registrados = atleta.getCantidadIntentos();
        int disponibles = 10 - registrados;

        vista.mostrarIntentos(registrados, disponibles);
    }

}