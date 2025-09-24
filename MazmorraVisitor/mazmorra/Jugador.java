package mazmorra;

public class Jugador implements Visitante
{
    private int vida = 100;
    private int oro = 0;

    @Override
    public void visitarTesoro(Tesoro tesoro) {
        oro += tesoro.getValor();
        System.out.println("Jugador recoge el tesoro " + tesoro.getNombre() + " con valor " + tesoro.getValor());
    }

    @Override
    public void visitarTrampa(Trampa trampa) {
        vida -= trampa.getDanio();
        System.out.println("Jugador cayó en una trampa: " + trampa.getDescripcion() + " y perdió " + trampa.getDanio() + " de vida");
    }

    @Override
    public void visitarMonstruo(Monstruo monstruo) {
        vida -= monstruo.getFuerza();
        System.out.println("Jugador lucha contra el monstruo " + monstruo.getNombre() + " y pierde " + monstruo.getFuerza() + " de vida");
    }

    public int getVida() {
        return vida;
    }

    public int getOro() {
        return oro;
    }
}
