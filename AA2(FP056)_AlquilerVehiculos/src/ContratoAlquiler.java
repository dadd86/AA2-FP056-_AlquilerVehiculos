/*
 * Clase ContratoAlquiler para gestionar contratos de alquiler de vehículos.
 * Permite crear contratos que especifican el cliente, los vehículos alquilados, y las fechas de inicio y fin del alquiler.
 * Incluye métodos para añadir o quitar vehículos del contrato, listar los vehículos, calcular el número de días de alquiler
 * y el costo total del alquiler basado en el precio diario de los vehículos y la duración del alquiler.
 *
 * @author Diego Armando Diaz Devia
 * @fecha 20 de marzo de 2024
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * La clase ContratoAlquiler se utiliza para crear y gestionar contratos de alquiler de vehículos.
 * Contiene información sobre el cliente, la lista de vehículos alquilados, y las fechas de inicio y fin del alquiler.
 */
public class ContratoAlquiler {
	 // Atributos de la clase.
    private LocalDate fechaInicio; // Almacena la fecha de inicio del contrato.
    private LocalDate fechaFin; // Almacena la fecha de finalización del contrato.
    private ArrayList<Vehiculo> vehiculos; // Lista para almacenar los vehículos incluidos en el contrato.
    private Cliente cliente; // Almacena la referencia al cliente que realiza el alquiler.

    /**
     * Constructor de la clase ContratoAlquiler.
     * @param fechaInicio Fecha de inicio del contrato.
     * @param fechaFin Fecha de finalización del contrato.
     * @param cliente Cliente que realiza el alquiler.
     * @param vehiculos Lista de vehículos alquilados.
     */
    public ContratoAlquiler(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, ArrayList<Vehiculo> vehiculos) {
        this.fechaInicio = fechaInicio; // Asigna la fecha de inicio del alquiler.
        this.fechaFin = fechaFin; // Asigna la fecha de finalización del alquiler.
        this.cliente = cliente; // Asigna el cliente del contrato.
        this.vehiculos = vehiculos; // Inicializa la lista de vehículos 
    }

    /**
     * Método para añadir un vehículo a la lista de vehículos del contrato.
     * @param vehiculo El vehículo a añadir.
     */
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Método para eliminar un vehículo de la lista basándose en su matrícula.
     * @param matricula Matrícula del vehículo a eliminar.
     */
    public void removeVehiculo(String matricula) {
        vehiculos.removeIf(v -> v.getMatricula().equals(matricula));
    }

    /**
     * Método para obtener la lista de vehículos del contrato.
     * @return Lista de vehículos.
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Imprime la información de todos los vehículos incluidos en el contrato.
     */
    public void listVehiculos() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v); // Usa el método toString de Vehiculo para imprimir detalles.
        }
    }

    /**
     * Calcula el número de días de duración del alquiler.
     * @return Número de días entre la fecha de inicio y la fecha de fin.
     */
    public int nDias() {
        return (int) ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFin);
    }

    /**
     * Calcula el costo total del alquiler, sumando el precio diario de cada vehículo multiplicado por el número de días del alquiler.
     * @return Costo total del alquiler.
     */
    public float calculateTotal() {
        float total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.getPrecioDia() * nDias(); // Calcula y suma el costo de cada vehículo.
        }
        return total; // Retorna el costo total del alquiler.
    }
    
    // Métodos getter y setter para los atributos de la clase.
    // Devuelve la fecha de inicio del contrato.
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    // Permite establecer la fecha de inicio del contrato.
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    // Devuelve la fecha de finalización del contrato.
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    // Permite establecer la fecha de finalización del contrato.
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Devuelve el cliente asociado al contrato.
    public Cliente getCliente() {
        return cliente;
    }

    // Permite cambiar el cliente asociado al contrato.
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Genera y retorna una representación en cadena del contrato, incluyendo la información del cliente, la lista de vehículos, y el costo total.
     * @return Representación textual del contrato.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFecha de Inicio: ").append(fechaInicio)
          .append("\nFecha Final: ").append(fechaFin)
          .append("\nNúmero de Días: ").append(this.nDias())
          .append("\nCliente: ").append(cliente.toString()) // Añadir la información del cliente
          .append("\n\nVehículos Alquilados:\n");
        // Añade los detalles de cada vehículo alquilado a la representación textual.
        for (Vehiculo v : vehiculos) {
            sb.append("Matrícula: ").append(v.getMatricula())
              .append(", Marca: ").append(v.getMarca())
              .append(", Modelo: ").append(v.getModelo())
              .append(", Precio por Día: ").append(v.getPrecioDia()).append(" €\n"); // Detalla cada vehículo.
        }
        // Calcula y añade el costo total del alquiler al final del resumen.
        sb.append("\nPrecio Total del Alquiler: ").append(this.calculateTotal()).append(" €") // Añade el costo total.
          .append("\n\n---------------------------\n");

        return sb.toString(); // Convierte el StringBuilder a String y lo retorna.
    }
}
