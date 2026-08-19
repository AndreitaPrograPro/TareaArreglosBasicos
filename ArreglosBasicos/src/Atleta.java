public class Atleta {
    // Datos del atleta
    private String nombre;
    private int numeroParticipante;
    private int edad;

    // Intentos del atleta
    private double[] tiempos;
    private int cantidadIntentos;


    //Constructor   
    public Atleta(String nombre, int numeroParticipante, int edad) {

    this.nombre = nombre;
    this.numeroParticipante = numeroParticipante;
    this.edad = edad;

    this.tiempos = new double[10];
    this.cantidadIntentos = 0;
    }
    //getters
    public String getNombre() {
    return nombre;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public int getEdad() {
        return edad;
    }

    public double[] getTiempos() {
        return tiempos;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    //Setter aparte para cantidad de intentos
    public void setCantidadIntentos(int cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos; //Actualiza la cantidad de intentos
    }

}
