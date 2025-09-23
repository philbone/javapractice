package editor;

/**
 * Representa un editor de texto simple (Originator).
 */
public class Editor
{
    private String texto = "";

    public void escribir(String nuevoTexto) {
        this.texto = nuevoTexto;
    }

    public String getTexto() {
        return texto;
    }

    /**
     * Crea un memento con el estado actual del texto.
     */
    public EditorMemento guardar() {
        return new EditorMemento(texto);
    }

    /**
     * Restaura el estado desde un memento.
     */
    public void restaurar(EditorMemento memento) {
        this.texto = memento.getEstado();
    }
}