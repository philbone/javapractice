package juego;

// Clase Originator: Personaje
public class Personaje
{
    private int vida;
    private int nivel;
    private int posX;
    private int posY;

    public Personaje(int vida, int nivel, int posX, int posY) {
        this.vida = vida;
        this.nivel = nivel;
        this.posX = posX;
        this.posY = posY;
    }

    public void mostrarEstado() {
        System.out.println("Personaje => Vida: " + vida +
                            ", Nivel: " + nivel +
                            ", Posición: (" + posX + ", " + posY + ")"
                            );
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    // Crea un Memento con el estado actual
    public Memento crearMemento() {
        return new Memento(vida, nivel, posX, posY);
    }

    // Restaura estado desde un Memento
    public void restaurarDesdeMemento(Memento memento) {
        this.vida = memento.getVida();
        this.nivel = memento.getNivel();
        this.posX = memento.getPosX();
        this.posY = memento.getPosY();
    }
}