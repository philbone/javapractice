import mazmorra.*;

public class MainMazmorra
{
    public static void main(String[] args)
    {
        Habitacion[] habitaciones = new Habitacion[]
        {
            new Tesoro("Cofre de oro", 100),
            new Trampa("Pozo con pinchos", 30),
            new Monstruo("Orco", 40),
            new Tesoro("Gema mágica", 200),
            new Monstruo("Dragón pequeño", 70)
        };

        Jugador jugador = new Jugador();
        Mapa mapa = new Mapa();
        Contador contador = new Contador();

        System.out.println("=== Jugador explora la mazmorra ===");
        for (Habitacion h : habitaciones)
        {
            h.aceptar(jugador);
        }
        System.out.println("Jugador terminó con " + jugador.getVida() + " de vida y " + jugador.getOro() + " de oro");

        System.out.println("\n=== El mapa describe la mazmorra ===");
        for (Habitacion h : habitaciones)
        {
            h.aceptar(mapa);
        }

        System.out.println("\n=== Contador analiza la mazmorra ===");
        for (Habitacion h : habitaciones)
        {
            h.aceptar(contador);
        }
        contador.mostrarResumen();
    }
}
