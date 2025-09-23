package editor;

/**
 * Memento que guarda el estado del editor.
 */
public class EditorMemento
{
    private final String estado;

    public EditorMemento(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}