package juego;

import java.util.ArrayList;
import java.util.List;

// Clase Caretaker: administra múltiples Mementos
public class Caretaker
{
    private final List<Memento> checkpoints = new ArrayList<>();

    public void guardarMemento(Memento m) {
        checkpoints.add(m);
    }

    public Memento recuperarMemento(int indice) {
        if (indice >= 0 && indice < checkpoints.size()) {
            return checkpoints.get(indice);
        }
        return null;
    }

    public int cantidadCheckpoints() {
        return checkpoints.size();
    }
}