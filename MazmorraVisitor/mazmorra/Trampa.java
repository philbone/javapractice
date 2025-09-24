package mazmorra;

public class Trampa implements Habitacion
{
    private String descripcion;
    private int danio;

    public Trampa(String descripcion, int danio)
    {
        this.descripcion = descripcion;
        this.danio = danio;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public int getDanio()
    {
        return danio;
    }

    @Override
    public void aceptar(Visitante visitante)
    {
        visitante.visitarTrampa(this);
    }
}