package pizzerialuccini.model;

/**
 *
 * @author felipe
 */
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

    public String getNombre() {
        return nombre;
    }
    
    public byte getEdad() {
        return edad;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getRut() {
        return rut;
    }
}
