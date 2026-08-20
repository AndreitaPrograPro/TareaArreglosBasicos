import java.util.Scanner;

public class VistaAtleta {

    private Scanner scanner;

    public VistaAtleta() {
        scanner = new Scanner(System.in);
    }

    //Menú
    public void mostrarMenu() {
    System.out.println("\n===== TORNEO DE ATLETISMO =====");
    System.out.println("1. Nuevo atleta");
    System.out.println("2. Registrar nuevo intento");
    System.out.println("3. Consultar tiempos");
    System.out.println("4. Consultar un intento");
    System.out.println("5. Modificar tiempo");
    System.out.println("6. Mostrar promedio");
    System.out.println("7. Mostrar mejor y mayor tiempo");
    System.out.println("8. Consultar intentos disponibles");
    System.out.println("9. Salir");
    System.out.print("Seleccione una opcion: ");
    }

    public Atleta registrarAtleta() {

    System.out.println("\n--- Nuevo Atleta ---");

    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();

    System.out.print("Numero de participante: ");
    int numeroParticipante = scanner.nextInt();

    System.out.print("Edad: ");
    int edad = scanner.nextInt();

    scanner.nextLine();

    return new Atleta(nombre, numeroParticipante, edad); //Devuelve al atleta recién creado
    }

    public double solicitarTiempo() {
    System.out.print("Ingrese el tiempo en segundos: ");
    return scanner.nextDouble();
    }

    public int solicitarNumeroIntento() {
    System.out.print("Ingrese el numero de intento: ");
    return scanner.nextInt();
    }

    public void mostrarTiempos(double[] tiempos, int cantidadIntentos) {

    System.out.println("\n--- Tiempos Registrados ---");
    //recorre tiempos y muestra los intentos registrados únicamente. 
    for (int i = 0; i < cantidadIntentos; i++) { //continúa mientras i sea menor que la cantidad de intentos registrados
        System.out.println("Intento " + (i + 1) + ": " + tiempos[i] + " segundos"); //i accede al arreglo y suma 1 para evitar el intento 0
        }
    }
    public void mostrarIntento(int numeroIntento, double tiempo) {
    System.out.println("Intento " + numeroIntento + ": " + tiempo + " segundos");
    }

    public void mostrarPromedio(double promedio) {
        System.out.println("Tiempo promedio: " + promedio + " segundos");
    }

    public void mostrarMejorYMayor(double mejor, double mayor) {
        System.out.println("Mejor tiempo: " + mejor + " segundos");
        System.out.println("Mayor tiempo: " + mayor + " segundos");
    }

    public void mostrarIntentos(int registrados, int disponibles) {
        System.out.println("Intentos realizados: " + registrados);
        System.out.println("Intentos disponibles: " + disponibles);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}