/**
 * Representa a un cliente con su información personal básica como el NIF y el nombre.
 * Esta clase es útil para gestionar datos de clientes en sistemas de alquiler de vehículos
 * o cualquier sistema que requiera mantener un registro de clientes.
 * @author: Diego Armando Diaz Devia
 * @fecha: 15 de marzo de 2024
 */
public class Cliente {

    // Atributos privados para almacenar el NIF y el nombre del cliente.
    private String nif;
    private String nombre;

    /**
     * Constructor para crear una instancia de Cliente.
     * @param nif El NIF del cliente.
     * @param nombre El nombre del cliente.
     */
    public Cliente(String nif, String nombre) {
        // Inicializa los atributos de la clase con los valores proporcionados.
        this.nif = nif;
        this.nombre = nombre;
    }

    /**
     * Obtiene el NIF del cliente.
     * @return El NIF del cliente.
     */
    public String getNif() {
        return nif; // Retorna el valor actual del atributo nif.
    }

    /**
     * Establece o actualiza el NIF del cliente.
     * @param nif El nuevo NIF del cliente.
     */
    public void setNif(String nif) {
        this.nif = nif; // Actualiza el atributo nif con el nuevo valor proporcionado.
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre; // Retorna el valor actual del atributo nombre.
    }

    /**
     * Establece o actualiza el nombre del cliente.
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre; // Actualiza el atributo nombre con el nuevo valor proporcionado.
    }

    /**
     * Genera una representación en cadena de texto de la instancia de Cliente.
     * @return Una cadena de texto que representa al cliente, incluyendo su NIF y nombre.
     */
    @Override
    public String toString() {
        // Retorna una cadena de texto que incluye el NIF y el nombre del cliente.
        return "NIF: " + nif + " Nombre: " + nombre;
    }

}
