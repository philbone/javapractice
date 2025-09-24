package mazmorra;

public class Contador implements Visitante
{
    private int tesoros = 0;
    private int trampas = 0;
    private int monstruos = 0;

    @Override
    public void visitarTesoro(Tesoro tesoro) {
        tesoros++;
    }

    @Override
    public void visitarTrampa(Trampa trampa) {
        trampas++;
    }

    @Override
    public void visitarMonstruo(Monstruo monstruo) {
        monstruos++;
    }

    public void mostrarResumen() {
        System.out.println("Resumen de la mazmorra:");
        System.out.println("- Tesoros: " + tesoros);
        System.out.println("- Trampas: " + trampas);
        System.out.println("- Monstruos: " + monstruos);
    }    
}