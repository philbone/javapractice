package editor;

/**
 * Caretaker que maneja el último estado guardado.
 */
public class Historial
{
    private EditorMemento memento;

    public void guardar(EditorMemento memento) {
        this.memento = memento;
    }

    public EditorMemento deshacer() {
        return memento;
    }
}