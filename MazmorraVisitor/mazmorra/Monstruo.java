package mazmorra;

public class Monstruo implements Habitacion
{
    private String nombre;
    private int fuerza;

    public Monstruo(String nombre, int fuerza) {
        this.nombre = nombre;
        this.fuerza = fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarMonstruo(this);
    }
}
