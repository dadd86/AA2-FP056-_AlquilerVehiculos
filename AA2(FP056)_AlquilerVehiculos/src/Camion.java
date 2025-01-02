/**
 * Representa una clase Camion que hereda de Vehiculo, especializada para manejar propiedades
 * y comportamientos específicos de camiones, como el peso.
 * @author: Diego Armando Diaz Devia
 * @fecha: 15 de marzo de 2024
 */

public class Camion extends Vehiculo {

    // Atributo privado para almacenar el peso en kilogramos del camión.
    private int kg;

    /**
     * Constructor para crear una instancia de Camion.
     * @param matricula La matrícula del camión.
     * @param marca La marca del camión.
     * @param modelo El modelo del camión.
     * @param precioDia El precio por día de alquiler del camión.
     * @param kg El peso del camión en kilogramos.
     */
    public Camion(String matricula, String marca, String modelo, float precioDia, int kg) {
        // Llama al constructor de la clase padre (Vehiculo) para inicializar los atributos comunes.
        super(matricula, marca, modelo, precioDia);
        // Inicializa el atributo específico de esta clase con el valor proporcionado.
        this.kg = kg;
    }

    /**
     * Obtiene el peso del camión en kilogramos.
     * @return El peso del camión en kilogramos.
     */
    public int getKg() {
        return kg; // Retorna el valor actual del atributo kg.
    }

    /**
     * Establece el peso del camión en kilogramos.
     * @param kg El nuevo peso del camión en kilogramos.
     */
    public void setKg(int kg) {
        this.kg = kg; // Actualiza el atributo kg con el nuevo valor proporcionado.
    }

    /**
     * Genera una representación en cadena de texto de la instancia de Camion.
     * @return Una cadena de texto que representa al camión, incluyendo sus atributos heredados y específicos.
     */
    @Override
    public String toString() {
        // Usa el método toString de la clase padre y añade la información específica de esta clase.
        return super.toString() + " Camion{" + "kg=" + kg + '}';
    }
}
