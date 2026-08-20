import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VistaAtleta vista = new VistaAtleta();
        Atleta atleta = vista.registrarAtleta(); // Registra al atleta inicial

        Controlador controlador = new Controlador(atleta, vista);

        int opcion = 0;

        do {
            System.out.println("\n--- TORNEO UNIVERSITARIO DE ATLETISMO (UVG) ---");
            System.out.println("1. Nuevo atleta");
            System.out.println("2. Registrar nuevo intento");
            System.out.println("3. Consultar tiempos");
            System.out.println("4. Consultar un intento");
            System.out.println("5. Modificar tiempo");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mostrar mejor y mayor tiempo");
            System.out.println("8. Consultar intentos disponibles");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; // Valor inválido para ir al default
            }

            switch (opcion) {
                case 1:
                    controlador.registrarAtleta();
                    break;
                case 2:
                    controlador.registarTiempo();
                    break;
                case 3:
                    controlador.consultarTiempos();
                    break;
                case 4:
                    controlador.consultarIntento();
                    break;
                case 5:
                    controlador.modificarTiempo();
                    break;
                case 6:
                    controlador.mostrarPromedio();
                    break;
                case 7:
                    controlador.mostrarMejoryMayor();
                    break;
                case 8:
                    controlador.mostrarIntentosDisponibles();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 9);

        scanner.close();
    }
}