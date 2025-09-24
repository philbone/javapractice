package juego;

// Clase Memento: guarda el estado del Personaje
public class Memento
{
    private final int vida;
    private final int nivel;
    private final int posX;
    private final int posY;

    public Memento(int vida, int nivel, int posX, int posY) {
        this.vida = vida;
        this.nivel = nivel;
        this.posX = posX;
        this.posY = posY;
    }

    public int getVida() {
        return vida;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
