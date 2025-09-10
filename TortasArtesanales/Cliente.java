
public class Cliente
{
    private String rut;
    private String nombre;
    private int edad;
    private String email;

    public Cliente(String rut, String nombre, int edad, String email) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public boolean esValido() {
        return nombre != null && !nombre.isEmpty() && (edad >= 18 && edad <= 80);
    }

    public int getEdad() {
        return edad; 
    }
    
    public String getNombre() {
        return nombre;
    }
}
