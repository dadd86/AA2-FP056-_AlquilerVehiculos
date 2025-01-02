/**
 * Clase abstracta Vehiculo que define las propiedades y comportamientos comunes de los vehículos.
 * Esta clase sirve como base para la creación de diferentes tipos de vehículos, como coches, motos y camiones,
 * permitiendo la reutilización de código y la implementación de lógica específica para cada tipo de vehículo en clases derivadas.
 * Cada vehículo tiene asociados una matrícula, marca, modelo y precio de alquiler diario.
 *
 * @author: Diego Armando Diaz Devia
 * @fecha: 15 de marzo de 2024
 */
public abstract class Vehiculo {
    // Atributos de la clase que representan características comunes de los vehículos.
    private String matricula; // Número de matrícula del vehículo.
    private String marca; // Marca del fabricante del vehículo.
    private String modelo; // Modelo específico del vehículo.
    private float precioDia; // Precio de alquiler del vehículo por día.
    
    /**
     * Constructor que inicializa un nuevo vehículo con los valores proporcionados.
     * Establece las características básicas del vehículo que son comunes a todos los tipos de vehículos.
     *
     * @param matricula Matrícula del vehículo, que debe ser única.
     * @param marca Marca del fabricante del vehículo.
     * @param modelo Modelo específico del vehículo proporcionado por el fabricante.
     * @param precioDia Precio de alquiler del vehículo por día.
     */
    public Vehiculo(String matricula, String marca, String modelo, float precioDia) {
        this.matricula = matricula; // Asigna la matrícula.
        this.marca = marca; // Asigna la marca.
        this.modelo = modelo; // Asigna el modelo.
        this.precioDia = precioDia; // Asigna el precio por día.
    }
    
    // Métodos getter y setter ofrecen acceso controlado a las propiedades del vehículo,
    // permitiendo su consulta y actualización de manera segura.

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula; // Actualiza la matrícula.
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca; // Actualiza la marca.
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo; // Actualiza el modelo.
    }

    public float getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(float precioDia) {
        this.precioDia = precioDia; // Actualiza el precio por día.
    }

    /**
     * Sobrescribe el método toString() para proporcionar una representación en cadena de texto
     * de la instancia de Vehiculo, mostrando sus atributos principales.
     * Esto facilita la visualización rápida de la información esencial del vehículo.
     *
     * @return Una cadena de texto que representa el vehículo, incluyendo su matrícula, marca, modelo y precio por día.
     */
    @Override
    public String toString() {
        // Devuelve una cadena formateada con los detalles del vehículo.
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", Precio por dia=" + precioDia + '}';
    }
}
