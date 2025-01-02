/**
 * Clase VehiculosRent representa una empresa de alquiler de vehículos. Esta clase gestiona las interacciones entre
 * clientes, agencias y flotas de vehículos, ofreciendo un punto centralizado para la administración de los recursos
 * de alquiler. Permite la adición y eliminación de clientes, agencias y flotas, y facilita la consulta de estos elementos.
 * Esta implementación asegura una gestión eficiente y organizada de los componentes clave de una empresa de alquiler de vehículos.
 *
 * @author: Diego Armando Diaz Devia
 * @fecha: 25 de marzo de 2024
 */

import java.util.ArrayList;

/**
 * Clase VehiculosRent representa una empresa de alquiler de vehículos, incluyendo su gestión de clientes, agencias y flotas.
 */
public class VehiculosRent {
    private String nif; // Número de Identificación Fiscal de la empresa.
    private String nombre; // Nombre de la empresa.
    private ArrayList<Cliente> clientes; // Lista para almacenar los clientes de la empresa.
    private ArrayList<Agencia> agencias; // Lista para almacenar las agencias asociadas a la empresa.
    private ArrayList<Flota> flotas; // Lista para almacenar las flotas de vehículos disponibles.

    /**
     * Constructor de VehiculosRent que inicializa una nueva empresa de alquiler con un NIF y nombre específicos.
     * También inicializa listas vacías para clientes, agencias y flotas.
     *
     * @param nif El Número de Identificación Fiscal de la empresa.
     * @param nombre El nombre de la empresa.
     */
    public VehiculosRent(String nif, String nombre) {
        this.nif = nif; // Asigna el NIF proporcionado.
        this.nombre = nombre; // Asigna el nombre proporcionado.
        // Inicializa las listas de clientes, agencias y flotas como listas vacías.
        this.clientes = new ArrayList<>();
        this.agencias = new ArrayList<>();
        this.flotas = new ArrayList<>();
    }

    // Métodos para la gestión de clientes, agencias y flotas.

    /**
     * Añade un cliente a la lista de clientes de la empresa.
     *
     * @param cliente El cliente a añadir.
     */
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Elimina un cliente de la lista de clientes de la empresa.
     *
     * @param cliente El cliente a eliminar.
     */
    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    /**
     * Añade una agencia a la lista de agencias asociadas a la empresa.
     *
     * @param agencia La agencia a añadir.
     */
    public void addAgencia(Agencia agencia) {
        agencias.add(agencia);
    }

    /**
     * Elimina una agencia de la lista de agencias asociadas a la empresa.
     *
     * @param agencia La agencia a eliminar.
     */
    public void removeAgencia(Agencia agencia) {
        agencias.remove(agencia);
    }

    /**
     * Añade una flota a la lista de flotas disponibles de la empresa.
     *
     * @param flota La flota a añadir.
     */
    public void addFlota(Flota flota) {
        flotas.add(flota);
    }

    /**
     * Elimina una flota de la lista de flotas disponibles de la empresa.
     *
     * @param flota La flota a eliminar.
     */
    public void removeFlota(Flota flota) {
        flotas.remove(flota);
    }

    // Getters y Setters para nif, nombre y listas de clientes, agencias y flotas.

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return new ArrayList<>(clientes); // Devuelve una copia de la lista de clientes.
    }

    public ArrayList<Agencia> getAgencias() {
        return new ArrayList<>(agencias); // Devuelve una copia de la lista de agencias.
    }

    public ArrayList<Flota> getFlotas() {
        return new ArrayList<>(flotas); // Devuelve una copia de la lista de flotas.
    }
}
