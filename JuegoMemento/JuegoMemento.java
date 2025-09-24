import juego.Caretaker;
import juego.Personaje;

public class JuegoMemento
{
    public static void main(String[] args) {
        Personaje heroe = new Personaje(100, 1, 0, 0);
        Caretaker caretaker = new Caretaker();

        System.out.println("Estado inicial del personaje:");
        heroe.mostrarEstado();

        // Guardamos checkpoint 1
        caretaker.guardarMemento(heroe.crearMemento());

        // Simulamos avance
        heroe.setPosicion(10, 5);
        heroe.setVida(80);
        caretaker.guardarMemento(heroe.crearMemento());

        // Simulamos batalla más difícil
        heroe.setPosicion(20, 15);
        heroe.setVida(0);  // muere
        System.out.println("\nDespués de la batalla final:");
        heroe.mostrarEstado();

        // Restauramos al checkpoint 1
        heroe.restaurarDesdeMemento(caretaker.recuperarMemento(0));
        System.out.println("\nRestaurado al Checkpoint 1:");
        heroe.mostrarEstado();

        // Restauramos al checkpoint 2
        heroe.restaurarDesdeMemento(caretaker.recuperarMemento(1));
        System.out.println("\nRestaurado al Checkpoint 2:");
        heroe.mostrarEstado();
    }
}