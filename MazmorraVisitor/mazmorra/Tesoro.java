package mazmorra;

public class Tesoro implements Habitacion
{
    private String nombre;
    private int valor;

    public Tesoro(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarTesoro(this);
    }
}
