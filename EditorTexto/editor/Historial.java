package editor;

import java.util.Stack;

/**
 * Caretaker que maneja múltiples estados con soporte de undo/redo.
 */
public class Historial {
    private final Stack<EditorMemento> pilaUndo = new Stack<>();
    private final Stack<EditorMemento> pilaRedo = new Stack<>();

    public void guardar(EditorMemento memento) {
        pilaUndo.push(memento);
        pilaRedo.clear(); // al guardar, invalidamos posibles "redos"
    }

    public EditorMemento deshacer(EditorMemento estadoActual) {
        if (!pilaUndo.isEmpty()) {
            pilaRedo.push(estadoActual);
            return pilaUndo.pop();
        }
        return null;
    }

    public EditorMemento rehacer(EditorMemento estadoActual) {
        if (!pilaRedo.isEmpty()) {
            pilaUndo.push(estadoActual);
            return pilaRedo.pop();
        }
        return null;
    }

    public boolean puedeDeshacer() {
        return !pilaUndo.isEmpty();
    }

    public boolean puedeRehacer() {
        return !pilaRedo.isEmpty();
    }
}