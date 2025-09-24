# 🎮 Ejercicio POO en Java - Patrón Memento

Este proyecto implementa un pequeño ejemplo de **Programación Orientada a Objetos (POO)** en **Java**, utilizando el **Patrón de Diseño Memento**.  
El escenario planteado es el de un **juego** donde un personaje tiene puntos de vida, nivel y posición. Antes de entrar a una batalla, se guarda un **checkpoint** (estado).  
Si el personaje muere, puede **restaurar** su estado anterior desde dicho checkpoint.

---

## 🧩 Patrón Memento

El **patrón Memento** permite **guardar y restaurar el estado interno de un objeto sin violar su encapsulación**.  
Consta de tres participantes principales:

- **Originator (Personaje)**  
  *El objeto que genera y restaura estados.*  
    - Puede crear un `Memento` con su estado actual.  
    - Puede restaurar su estado a partir de un `Memento`.
- **Memento**  
    - Contiene el estado guardado del `Originator`.  
    - Es inmutable: solo expone getters, sin setters.  
- **Caretaker**  
    - Administra los Mementos (checkpoints).  
    - Decide cuándo guardar o restaurar estados, pero **no conoce los detalles internos** del `Personaje`.

---

## 📂 Estructura del Proyecto
    src/
    ├── juego/
    │ ├── Memento.java
    │ ├── Personaje.java
    │ └── Caretaker.java
    └── JuegoMemento.java


---

## 🔎 Flujo del Ejemplo

1. Se crea un `Personaje` con un estado inicial.
2. Se guarda un **checkpoint** antes de una batalla.
3. El personaje avanza, pierde vida o incluso muere (vida = 0).
4. Desde el `Caretaker`, se restaura un estado anterior.

---

## 📌 Ejemplo de Ejecución
    Estado inicial del personaje:
    Personaje => Vida: 100, Nivel: 1, Posición: (0, 0)
    
    Después de la batalla final:
    Personaje => Vida: 0, Nivel: 1, Posición: (20, 15)
    
    Restaurado al Checkpoint 1:
    Personaje => Vida: 100, Nivel: 1, Posición: (0, 0)
    
    Restaurado al Checkpoint 2:
    Personaje => Vida: 80, Nivel: 1, Posición: (10, 5)


---

## ✅ Beneficios del Patrón Memento
- Mantiene la **encapsulación**: solo el `Personaje` sabe cómo guardar/restaurar su estado.  
- Permite múltiples **checkpoints** (como "guardar partida" en un videojuego).  
- Separa responsabilidades:  
    - El `Personaje` maneja su lógica.  
    - El `Memento` protege el estado.  
    - El `Caretaker` administra los checkpoints.  
---

## 🚀 Cómo ejecutar

**Compilar las clases:**

    bash
    javac juego/*.java JuegoMemento.java

**Ejecutar el programa:**

`java JuegoMemento`

