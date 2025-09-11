
public class Cliente
{
    private String rut;
    private String nombre;
    private byte edad;
    private String email;

    public Cliente(String rut, String nombre, byte edad, String email) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public boolean esValido() {
        return nombre != null && !nombre.isEmpty() && (edad >= 18 && edad <= 80);
    }

    public byte getEdad() {
        return edad; 
    }
    
    public String getNombre() {
        return nombre;
    }
}
