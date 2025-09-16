package pizzerialuccini.decorator;

import java.util.ArrayList;
import java.util.List;

public class BasePizza implements PizzaComponent
{
    private String nombre;
    private String tamaño;
    private String masa;
    private List<String> ingredientes = new ArrayList<>();
    private double precio;

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    
    public void setMasa(String masa) {
        this.masa = masa;
    }
    
    public void addIngrediente(String ingrediente) {
        ingredientes.add(ingrediente);
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Getters 
    public String getNombre() {
        return nombre;
    }
    
    public String getTamaño() {
        return tamaño;
    }
    
    public String getMasa() {
        return masa;
    }
    
    public List<String> getIngredientes() {
        return ingredientes;
    }

    // acceso al valor actual (antes de decoradores)
    public double getPrecioBase() {
        return precio;
    }

    @Override
    public String getDescripcion() {
        return "Pizza " + nombre + " (" + tamaño + ", Masa " + masa + ") " + ingredientes;
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}
