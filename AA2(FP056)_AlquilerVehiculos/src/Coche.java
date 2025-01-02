/**
 * Clase que representa un coche, extendiendo la funcionalidad de la clase Vehiculo
 * con características específicas como el número de puertas y plazas. Esta clase permite
 * crear objetos de tipo Coche con atributos y comportamientos detallados para el manejo
 * de coches en un sistema de alquiler de vehículos o gestión de flotas.
 * @author: Diego Armando Diaz Devia
 * @fecha: 15 de marzo de 2024
 */
public class Coche extends Vehiculo {
    // Atributos privados para almacenar el número de puertas y plazas del coche.
    private int puertas;
    // Atributo para almacenar el número de plazas disponibles en el coche.
    private int plazas;

    /**
     * Constructor que inicializa un nuevo coche con información específica,
     * incluyendo los atributos heredados de Vehiculo y los propios de Coche.
     * 
     * @param matricula La matrícula del coche.
     * @param marca La marca del coche.
     * @param modelo El modelo del coche.
     * @param precioDia El precio de alquiler por día del coche.
     * @param puertas El número de puertas del coche.
     * @param plazas El número de plazas para pasajeros del coche.
     */
    public Coche(String matricula, String marca, String modelo, float precioDia, int puertas, int plazas) {
        // Llama al constructor de la clase padre (Vehiculo) para inicializar los atributos heredados.
        super(matricula, marca, modelo, precioDia);
        // Inicializa los atributos específicos de Coche con los valores proporcionados.
        this.puertas = puertas;
        this.plazas = plazas;
    }
    
    /**
     * Obtiene el número de puertas del coche.
     * @return El número de puertas del coche.
     */
    public int getPuertas() {
        return puertas; // Retorna el valor actual del atributo puertas.
    }

    /**
     * Establece o actualiza el número de puertas del coche.
     * @param puertas El nuevo número de puertas del coche.
     */
    public void setPuertas(int puertas) {
        this.puertas = puertas; // Actualiza el atributo puertas con el nuevo valor proporcionado.
    }

    /**
     * Obtiene el número de plazas del coche.
     * @return El número de plazas del coche.
     */
    public int getPlazas() {
        return plazas; // Retorna el valor actual del atributo plazas.
    }

    /**
     * Establece o actualiza el número de plazas del coche.
     * @param plazas El nuevo número de plazas del coche.
     */
    public void setPlazas(int plazas) {
        this.plazas = plazas; // Actualiza el atributo plazas con el nuevo valor proporcionado.
    }

    /**
     * Proporciona una representación en forma de cadena de texto del coche,
     * incluyendo su matrícula, marca, modelo, precio por día, número de puertas y plazas.
     * 
     * @return Una cadena de texto que representa al coche.
     */
    @Override
    public String toString() {
        // Combina la representación de la clase padre (Vehiculo) con los atributos específicos de Coche.
        return super.toString() + " Coche{" + "puertas=" + puertas + ", plazas=" + plazas + '}';
    }   
}
