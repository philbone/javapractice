package mazmorra;

public class Mapa implements Visitante
{
    @Override
    public void visitarTesoro(Tesoro tesoro) {
        System.out.println("Mapa: Tesoro llamado '" + tesoro.getNombre() + "' de valor " + tesoro.getValor());
    }

    @Override
    public void visitarTrampa(Trampa trampa) {
        System.out.println("Mapa: Trampa descrita como '" + trampa.getDescripcion() + "' que causa " + trampa.getDanio() + " de daño");
    }

    @Override
    public void visitarMonstruo(Monstruo monstruo) {
        System.out.println("Mapa: Monstruo '" + monstruo.getNombre() + "' con fuerza " + monstruo.getFuerza());
    }
}
