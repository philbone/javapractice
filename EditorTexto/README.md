# 📝 Editor de Texto con Patrón Memento (Java)
## Introducción
El patrón Memento permite capturar y restaurar el estado interno de un objeto sin violar su encapsulación.
Es útil en casos donde necesitamos funcionalidades como deshacer (undo), rehacer (redo), o versionado.

En este ejercicio implementamos un editor de texto en consola que soporta:

  * Escribir texto.
  * Guardar estados (mementos).
  * Deshacer (undo).
  * Rehacer (redo).

## 🏗️ Estructura del patrón Memento
  * **Originator (Editor)** Contiene el estado actual (el texto). Puede crear y restaurar Mementos.
  * **Memento (EditorMemento)** Objeto inmutable que almacena un estado del Editor.
  * **Caretaker (Historial)** Administra los mementos. En esta versión usamos dos pilas para soportar undo y redo.

## Notas de interés
  * El patrón Memento permite implementar undo/redo de manera limpia, sin exponer los detalles internos del objeto (Editor).
  * Usar dos pilas simplifica mucho la lógica de undo y redo.
  * Este mismo enfoque puede aplicarse en editores de texto, herramientas gráficas, juegos, configuraciones, etc.

## Flujo de Ejemplo

    1. Escribir texto
    2. Guardar estado
    3. Deshacer
    4. Rehacer
    5. Mostrar texto
    6. Salir

    Opción: 1
    Escribe tu texto: Hola
    Opción: 2
    [Estado guardado]

    Opción: 1
    Escribe tu texto: Hola mundo
    Opción: 2
    [Estado guardado]

    Opción: 1
    Escribe tu texto: Hola mundo con Memento

    Opción: 3
    [Deshacer realizado]
    Opción: 5
    Texto actual: Hola mundo

    Opción: 4
    [Rehacer realizado]
    Opción: 5
    Texto actual: Hola mundo con Memento

