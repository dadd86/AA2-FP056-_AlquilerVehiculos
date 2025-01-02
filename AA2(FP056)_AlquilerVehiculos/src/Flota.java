/*
 * crear una Flota sin necesidad de proporcionar una lista de vehículos desde el principio, 
 * lo que te da la flexibilidad de añadir vehículos más tarde con el método addVehiculo(Vehiculo vehiculo). 
 * Además, el método getVehiculos() proporciona una forma segura de acceder a la lista de vehículos sin riesgo de que se modifique externamente, 
 * ya que devuelve una copia de la lista.
 * @author Diego Armando Diaz Devia
 * @fecha 22 de marzo de 2024
 * */
import java.util.ArrayList;

/**
 * Clase Flota para gestionar un conjunto de vehículos.
 * Permite añadir y quitar vehículos, listarlos y obtener detalles de la flota.
 */
public class Flota {
    private String nombreZona; // Nombre de la zona donde opera la flota.
    private ArrayList<Vehiculo> vehiculos; // Lista de vehículos en la flota.

    /**
     * Constructor que inicializa una flota con un nombre de zona
     * y una lista preexistente de vehículos.
     *
     * @param nombreZona Nombre de la zona de operación de la flota.
     * @param vehiculos Lista inicial de vehículos pertenecientes a la flota.
     */
    public Flota(String nombreZona, ArrayList<Vehiculo> vehiculos) {
        this.nombreZona = nombreZona;
        this.vehiculos = vehiculos;
    }

    /**
     * Constructor sobrecargado que inicializa una flota solo con un nombre de zona.
     * La lista de vehículos se inicia vacía.
     *
     * @param nombreZona Nombre de la zona de operación de la flota.
     */
    public Flota(String nombreZona) {
        this.nombreZona = nombreZona;
        this.vehiculos = new ArrayList<>(); // Inicia una lista vacía de vehículos.
    }

    /**
     * Agrega un vehículo a la flota.
     *
     * @param vehiculo El vehículo a agregar a la flota.
     */
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Intenta eliminar un vehículo de la flota basado en su matrícula.
     * Imprime un mensaje indicando el resultado de la operación.
     *
     * @param matricula La matrícula del vehículo a eliminar.
     * @return true si el vehículo fue eliminado con éxito, false de lo contrario.
     */
    public boolean removeVehiculo(String matricula) {
        boolean resultado = vehiculos.removeIf(v -> v.getMatricula().equals(matricula));
        if (!resultado) {
            System.out.println("No se encontró un vehículo con la matrícula: " + matricula + " en la flota.");
        } else {
            System.out.println("Vehículo con matrícula " + matricula + " eliminado con éxito de la flota.");
        }
        return resultado;
    }

    /**
     * Lista todos los vehículos en la flota.
     * Utiliza el método toString de cada vehículo para imprimir sus detalles.
     */
    public void listVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("La flota está actualmente vacía.");
        } else {
            System.out.println("Vehículos en la flota '" + nombreZona + "':");
            vehiculos.forEach(System.out::println);
        }
    }

    /**
     * Devuelve una copia de la lista de vehículos de la flota.
     * Esto evita la modificación directa de la lista interna de vehículos.
     *
     * @return Una copia de la lista de vehículos.
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    /**
     * Obtiene el nombre de la zona de operación de la flota.
     * 
     * @return El nombre de la zona asignada a la flota.
     */
    public String getNombreZona() {
        return nombreZona;
    }
    /**
     * Establece o actualiza el nombre de la zona de operación de la flota.
     * 
     * @param nombreZona El nuevo nombre para la zona de la flota.
     */
    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }
}
