package mazmorra;

public interface Visitante
{
    void visitarTesoro(Tesoro tesoro);
    void visitarTrampa(Trampa trampa);
    void visitarMonstruo(Monstruo monstruo);
}
