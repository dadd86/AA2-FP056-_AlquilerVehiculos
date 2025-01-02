/**
 * La clase Agencia representa una entidad que gestiona una flota de vehículos. Cada agencia tiene un nombre único
 * y está asociada con una flota específica de vehículos, lo que permite una organización eficiente y la gestión
 * de los vehículos disponibles para alquiler o cualquier otro propósito definido por la agencia.
 *
 * Esta clase es fundamental en el contexto de una aplicación de gestión de flotas de vehículos, ofreciendo
 * funcionalidades básicas para el manejo de la información de la agencia y su flota asociada.
 *
 * @author: Diego Armando Diaz Devia
 * @fecha: 16 de marzo de 2024
 */
public class Agencia {
    // Atributo para almacenar el nombre de la agencia.
    private String nombre;
    // Atributo para referenciar la Flota asociada con esta agencia.
    private Flota flota;
    
    /**
     * Constructor de la clase Agencia.
     * Inicializa una nueva instancia de la Agencia con un nombre y una Flota.
     * @param nombre El nombre de la agencia.
     * @param flota La flota de vehículos asociada a la agencia.
     */
    public Agencia(String nombre, Flota flota) {
        this.nombre = nombre; // Asigna el nombre proporcionado al atributo 'nombre'.
        this.flota = flota; // Asigna la flota proporcionada al atributo 'flota'.
    }
    
    /**
     * Obtiene el nombre de la agencia.
     * @return El nombre de la agencia.
     */
    public String getNombre() {
        return nombre; // Devuelve el nombre de la agencia.
    }
    
    /**
     * Establece o cambia el nombre de la agencia.
     * @param nombre El nuevo nombre para la agencia.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre; // Actualiza el nombre de la agencia con el valor proporcionado.
    }
    
    /**
     * Obtiene la flota de vehículos asociada a la agencia.
     * @return La flota de vehículos.
     */
    public Flota getFlota() {
        return flota; // Devuelve la flota asociada a la agencia.
    }
    
    /**
     * Establece o cambia la flota de vehículos asociada a la agencia.
     * @param flota La nueva flota de vehículos para la agencia.
     */
    public void setFlota(Flota flota) {
        this.flota = flota; // Actualiza la flota asociada a la agencia con la nueva flota proporcionada.
    }
}
