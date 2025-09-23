package editor;

import java.util.Stack;

/**
 * Caretaker que maneja múltiples estados usando una pila.
 */
public class Historial
{
    private final Stack<EditorMemento> pila = new Stack<>();

    public void guardar(EditorMemento memento) {
        pila.push(memento);
    }

    public EditorMemento deshacer() {
        if (!pila.isEmpty()) {
            return pila.pop();
        }
        return null;
    }

    public boolean tieneHistorial() {
        return !pila.isEmpty();
    }
}