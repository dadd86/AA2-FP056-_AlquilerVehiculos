/**
 * La clase Moto extiende la clase abstracta Vehiculo y añade un atributo específico para motos: cc (cilindrada).
 * @author: Diego Armando Diaz Devia
 * @fecha: 15 de marzo de 2024
 */
public class Moto extends Vehiculo {

    private int cc; // Cilindrada de la moto.

    /**
     * Constructor para crear una instancia de Moto.
     * 
     * @param matricula La matrícula de la moto.
     * @param marca La marca de la moto.
     * @param modelo El modelo de la moto.
     * @param precioDia El precio de alquiler por día de la moto.
     * @param cc La cilindrada de la moto.
     */
    public Moto(String matricula, String marca, String modelo, float precioDia, int cc) {
        super(matricula, marca, modelo, precioDia); // Llama al constructor de la clase base (Vehiculo).
        this.cc = cc; // Inicializa la cilindrada de la moto.
    }

    /**
     * Obtiene la cilindrada de la moto.
     * 
     * @return La cilindrada de la moto.
     */
    public int getCc() {
        return cc;
    }

    /**
     * Establece la cilindrada de la moto.
     * 
     * @param cc La cilindrada a establecer.
     */
    public void setCc(int cc) {
        this.cc = cc; // Actualiza la cilindrada de la moto.
    }

    /**
     * Genera una representación en cadena de la moto, incluyendo la información de la clase base (Vehiculo)
     * y añadiendo la cilindrada específica de la moto.
     * 
     * @return Una cadena que representa la moto con su cilindrada.
     */
    @Override
    public String toString() {
        // Usa el método toString de la clase base (Vehiculo) y añade la cilindrada de la moto.
        return super.toString() + " Moto{" + "cc=" + cc + '}';
    }

}
