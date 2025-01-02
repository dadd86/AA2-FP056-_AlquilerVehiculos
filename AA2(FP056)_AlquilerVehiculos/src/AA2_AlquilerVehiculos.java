/**
 * Clase AA2_AlquilerVehiculos: Sirve como el núcleo para la gestión de flotas y el alquiler de vehículos.
 * Esta clase permite realizar operaciones fundamentales tales como crear flotas, añadir o quitar vehículos de estas,
 * mostrar los vehículos disponibles en cada flota y gestionar ejemplos de contratos de alquiler. Está diseñada para ser
 * el punto de entrada para la administración de un negocio de alquiler de vehículos, proporcionando una interfaz interactiva
 * a través de la consola para facilitar estas operaciones.
 * @author: Diego Armando Diaz Devia
 * @fecha: 25 de marzo de 2024
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Clase principal para la gestión de flotas y alquiler de vehículos.
 * Permite crear flotas, añadir vehículos a flotas, mostrar vehículos en flotas,
 * quitar vehículos de flotas y mostrar ejemplos de contratos de alquiler.
 */
public class AA2_AlquilerVehiculos {
	// Almacena las flotas creadas para su gestión en una lista
	private ArrayList<Flota> flotas = new ArrayList<>(); 
	// Herramienta para leer la entrada del usuario desde la consola.
    Scanner teclado = new Scanner(System.in);
    /**
     * Punto de entrada principal del programa.
     * @param args Argumentos de línea de comando (no utilizados).
     */
    // El método principal que se llama cuando se ejecuta la clase.
    public static void main(String[] args) {
        // Crea una instancia de la clase y comienza el proceso.
        AA2_AlquilerVehiculos prg = new AA2_AlquilerVehiculos();
        prg.inicio();// Iniciar el programa
    }
    /**
     * Muestra el menú principal y maneja la selección de opciones por el usuario.
     */
    // Ciclo principal de la aplicación, muestra el menú y procesa la selección del usuario.
    void inicio() {
        // Variable para controlar si el usuario desea salir de la aplicación.
        boolean salir = false;
        // Variable para almacenar la opción del usuario.
        char opcio;
        do {
            // Imprime las opciones del menú.
        	System.out.println("\nMenú Principal:");
            System.out.println("1. Crear nueva flota");
            System.out.println("2. Añadir vehículos en una flota");
            System.out.println("3. Mostrar vehículos de una flota");
            System.out.println("4. Quitar un vehículo de una flota");
            System.out.println("5. Ejemplo solución AA1");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Solicita al usuario que elija una opción y guarda la respuesta.
            opcio = demanarOpcioMenu();
            
            // Switch para manejar la opción elegida por el usuario.
            switch (opcio) {
	            case '1':
	                crearFlota();
	                break;
	            case '2':
	                addVehiculoFlota();
	                break;
	            case '3':
	                mostrarVehiculosFlota();
	                break;
	            case '4':
	                quitarVehiculosFlota();
	                break;
	            case '5':
	                ejemploAA1();
	                break;
	            case '0':
	                salir = true;// Termina el bucle y sale del programa.
	                System.out.println("Saliendo del programa...");
	                break;
	            default:
	                System.out.println("Opción no válida, por favor intente nuevamente.");
	        }
        } while (!salir); // Continuar mostrando el menú hasta que salir sea true.
    }
    
    /**
     * Solicita al usuario una opción del menú y la devuelve.
     * @return La opción seleccionada por el usuario como un carácter.
     */
    // Solicita la elección de una opción del menú al usuario.
    char demanarOpcioMenu() {
        String resp;
        System.out.print("Elige una opción (1,2,3,4 o 0): ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " "; // Si no hay entrada, devolver un espacio en blanco.
        }
        return resp.charAt(0); // Devuelve el primer carácter de la entrada del usuario.
    }
    /**
     * Permite al usuario crear una nueva flota especificando un nombre.
     */
    // Crea una nueva flota con el nombre proporcionado por el usuario.
    private void crearFlota() {
    	System.out.println("\n--- Creación de Nueva Flota ---");
        System.out.print("Introduce el nombre de la nueva flota: ");
        String nombre = teclado.nextLine(); // Leer el nombre de la flota
        Flota flota = new Flota(nombre); // Crear nueva flota con el nombre proporcionado
        flotas.add(flota); // Añadir la nueva flota a la lista de flotas
        System.out.println("Flota '" + nombre + "' creada exitosamente.");
    }

    /**
     * Añade un vehículo a una flota seleccionada por el usuario.
     * El usuario puede especificar detalles del vehículo, incluyendo tipo, matrícula, marca, modelo y precio por día.
     */
    // Añade un vehículo a la flota seleccionada, solicitando los detalles necesarios al usuario.
    void addVehiculoFlota() {
        // Verificar si hay flotas disponibles
        if (flotas.isEmpty()) {
            System.out.println("No hay flotas disponibles. Por favor, cree una flota primero.");
            return;
        }

        // Listar flotas disponibles
        System.out.println("Seleccione una flota por su número:");
        for (int i = 0; i < flotas.size(); i++) {
            System.out.println((i + 1) + ". " + flotas.get(i).getNombreZona()); // Enumerar flotas
        }

        // Solicitar al usuario que elija una flota
        System.out.print("Introduce el número de la flota a la cual agregar vehículos: ");
        int indiceFlota = pedirNumeroEntero("Introduce el número de la flota a la cual agregar vehículos: ") - 1;
        
        // Validar la selección de la flota
        if (indiceFlota < 0 || indiceFlota >= flotas.size()) {
            System.out.println("Selección de flota inválida.");
            return;
        }

        // Seleccionar la flota basada en la entrada del usuario
        Flota flotaSeleccionada = flotas.get(indiceFlota);

        // Mientras el usuario desee agregar más vehículos, repetir este bucle
        boolean agregarMas = true;// Controla si el usuario desea agregar más vehículos.
        while (agregarMas) {
            
            int seleccionTipoVehiculo = pedirNumeroEntero("Seleccione el tipo de vehículo para agregar:\n1. Coche\n2. Moto\n3. Camion\n"); // Usar el método de ayuda para obtener un entero

            String tipoVehiculo;     
            // Asignar el tipo de vehículo según la elección del usuario
            switch (seleccionTipoVehiculo) {
                case 1:
                    tipoVehiculo = "coche";
                    break;
                case 2:
                    tipoVehiculo = "moto";
                    break;
                case 3:
                    tipoVehiculo = "camion";
                    break;
                default:
                    // Si la selección no es válida, informar al usuario y continuar con el próximo ciclo
                    System.out.println("Selección no válida. Vehículo no añadido.");
                    continue;
            }

            // Solicitar información común a todos los vehículos
            System.out.println("Ingrese la matrícula:");
            String matricula = teclado.nextLine();
            System.out.println("Ingrese la marca:");
            String marca = teclado.nextLine();
            System.out.println("Ingrese el modelo:");
            String modelo = teclado.nextLine();
            float precioDia = pedirNumeroFlotante("Ingrese el precio por día: "); // Usar el método de ayuda para obtener un flotante


            // Crear y añadir el vehículo a la flota seleccionada, según el tipo
            switch (tipoVehiculo) {
                case "coche":
                    int puertas = pedirNumeroEntero("Ingrese el número de puertas:");
                    int plazas = pedirNumeroEntero("Ingrese el número de plazas:");
                    flotaSeleccionada.addVehiculo(new Coche(matricula, marca, modelo, precioDia, puertas, plazas));
                    break;
                case "moto":
                    int cc = pedirNumeroEntero("Ingrese los cc:");
                    flotaSeleccionada.addVehiculo(new Moto(matricula, marca, modelo, precioDia, cc));
                    break;
                case "camion":
                    int kg = pedirNumeroEntero("Ingrese el peso en kg:");
                    flotaSeleccionada.addVehiculo(new Camion(matricula, marca, modelo, precioDia, kg));
                    break;
            }

            // Preguntar al usuario si desea continuar agregando vehículos
            agregarMas = solicitarConfirmacion("¿Desea agregar otro vehículo a esta flota? (s/n):");
    		}

	    }
    /**
     * Método para solicitar al usuario un número entero y manejar las excepciones que pueden ocurrir durante la entrada.
     */
    private int pedirNumeroEntero(String mensaje) {
        while (true) {
            try {
            	System.out.print(mensaje);
                return Integer.parseInt(teclado.nextLine());// Usa parseInt y maneja la excepción
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }
    }

    /**
     * Método para solicitar al usuario un número flotante y manejar las excepciones relacionadas.
     */
    private float pedirNumeroFlotante(String mensaje) {
        while (true) {
            try {
            	System.out.print(mensaje);
                return Float.parseFloat(teclado.nextLine());// Usa parseFloat y maneja la excepción
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
    }
    /**
     * Solicita confirmación del usuario para una acción, esperando una respuesta de 's' o 'n'.
     */
    private boolean solicitarConfirmacion(String mensaje) {
        String respuesta;
        do {
            System.out.print(mensaje);
            respuesta = teclado.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("n")) {
                return respuesta.equals("s"); // Retorna true si la respuesta es "s", false si es "n"
            } else {
                System.out.println("Por favor, responda con 's' para sí o 'n' para no.");
            }
        } while (true); // Repite hasta que se obtenga una respuesta válida
    }
    /**
     * Muestra los vehículos presentes en una flota seleccionada por el usuario.
     */
    void mostrarVehiculosFlota() {
        // Verificar si hay flotas disponibles
        if (flotas.isEmpty()) {
            System.out.println("Actualmente no hay flotas disponibles.");
            return;
        }
        int indiceFlota = -1; // Inicializar con un valor fuera del rango de índices válidos.
        Flota flotaSeleccionada = null;

        // Listar las flotas disponibles para que el usuario elija
        System.out.println("Seleccione la flota de la cual desea ver los vehículos:");
        for (int i = 0; i < flotas.size(); i++) {
            System.out.println((i + 1) + ". " + flotas.get(i).getNombreZona()); // Enumerar flotas
        }

     // Ciclo do-while para validar la selección de la flota
        do {
            indiceFlota = pedirNumeroEntero("Introduce el número de la flota: ") - 1;
            
            // Validar selección de la flota
            if (indiceFlota >= 0 && indiceFlota < flotas.size()) {
                flotaSeleccionada = flotas.get(indiceFlota);
            } else {
                System.out.println("Selección inválida. Por favor, seleccione una flota de la lista.");
            }
        } while (flotaSeleccionada == null); // Repetir hasta que se haga una selección válida

        // Mostrar los vehículos de la flota seleccionada
        mostrarVehiculosDeFlota(flotaSeleccionada);
	}
    /**
     * Muestra los vehículos de la flota seleccionada.
     * @param flotaSeleccionada La flota de la cual mostrar vehículos.
     */
    private void mostrarVehiculosDeFlota(Flota flotaSeleccionada) {
        // Verificar si la flota seleccionada tiene vehículos
        if (flotaSeleccionada.getVehiculos().isEmpty()) {
            System.out.println("La flota seleccionada no tiene vehículos.");
            return;
        }
        // Mostrar los vehículos de la flota seleccionada
        System.out.println("Vehículos en la flota '" + flotaSeleccionada.getNombreZona() + "':");
        for (Vehiculo vehiculo : flotaSeleccionada.getVehiculos()) {
            System.out.println(vehiculo);
        }
    }


    /**
     * Permite al usuario quitar un vehículo de una flota seleccionada mediante la matrícula del vehículo.
     */
    void quitarVehiculosFlota() {
        // Verificar si hay flotas disponibles
        if (flotas.isEmpty()) {
            System.out.println("Actualmente no hay flotas disponibles.");
            return;
        }
        int indiceFlota = -1; // Inicializar con un valor fuera del rango de índices válidos.
        Flota flotaSeleccionada = null;

        // Listar las flotas disponibles para que el usuario elija
        System.out.println("Seleccione la flota de la cual desea ver los vehículos:");
        for (int i = 0; i < flotas.size(); i++) {
            System.out.println((i + 1) + ". " + flotas.get(i).getNombreZona()); // Enumerar flotas
        }

     // Ciclo do-while para validar la selección de la flota
        do {
            indiceFlota = pedirNumeroEntero("Introduce el número de la flota: ") - 1;
            
            // Validar selección de la flota
            if (indiceFlota >= 0 && indiceFlota < flotas.size()) {
                flotaSeleccionada = flotas.get(indiceFlota);
            } else {
                System.out.println("Selección inválida. Por favor, seleccione una flota de la lista.");
            }
        } while (flotaSeleccionada == null); // Repetir hasta que se haga una selección válida

        // Mostrar los vehículos de la flota seleccionada
        mostrarVehiculosDeFlota(flotaSeleccionada);

        // Solicita la matrícula del vehículo a quitar.
        System.out.print("Introduce la matrícula del vehículo a quitar: ");
        String matriculaAQuitar = teclado.nextLine();

        flotaSeleccionada.removeVehiculo(matriculaAQuitar);
    }
    /**
     * Muestra un ejemplo de cómo crear y gestionar un contrato de alquiler utilizando vehículos, clientes y flotas.
     */
    void ejemploAA1() {
        // Indica el formato de fecha para la conversión.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        // Crea objetos de Coche, Moto y Camión.
        Coche coche1 = new Coche("1122ABC", "Audi", "TT", (float) 1000.0, 2, 4);
        Moto moto1 = new Moto("2233LML", "Piaggio", "Liberty", (float) 550.0, 125);
        Camion camion1 = new Camion("3344HJK", "Renault", "Jumpy", (float) 2500.85, 560);

        // Crea objetos de Cliente.
        Cliente cliente1 = new Cliente("11222333A", "Ana");
        //Cliente cliente2 = new Cliente("22333444B", "Josep");

        // Crea una lista para añadir vehículos y luego crear un contrato de alquiler con ellos.
        ArrayList<Vehiculo> vehiculosParaAlquilar = new ArrayList<>();
        vehiculosParaAlquilar.add(coche1);
        vehiculosParaAlquilar.add(moto1);
        vehiculosParaAlquilar.add(camion1);

        // Crea un contrato de alquiler con la lista de vehículos y el cliente.
        ContratoAlquiler contrato = new ContratoAlquiler(LocalDate.parse("15/11/2022", formatter),
                                                          LocalDate.parse("25/11/2022", formatter),
                                                          cliente1,
                                                          vehiculosParaAlquilar);

        // Utiliza el método toString del contrato para mostrar su información por pantalla.
        System.out.println("\nCONTRATO DE ALQUILER: \n" + contrato);
    }
}