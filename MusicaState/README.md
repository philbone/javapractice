# 🎶 Ejercicio: Reproductor de Música con Patrón State 🎶
Este proyecto demuestra el patrón de diseño State en Java usando un reproductor de música como ejemplo.

La idea es que las acciones (play, pause, stop) cambien su comportamiento dependiendo del estado actual del reproductor:

  * Playing → la música ya está sonando.
  * Paused → la música está pausada.
  * Stopped → la música está detenida.

En lugar de usar `if/else` o `switch`, cada estado se implementa como una clase que define cómo reaccionar a las acciones.

## Objetivo didáctico

  * Entender cómo el patrón State evita la proliferación de condicionales (`if/else` o `switch`).
  * Aprender a delegar comportamiento en objetos de estado.
  * Practicar interfaces, polimorfismo y composición en Java.
  * Usar una librería externa para crear un menú interactivo en consola.

## Escenario

Se quiere modelar una máquina de música (reproductor). El reproductor tiene tres estados principales:

  * Reproduciendo (Playing)
  * Pausado (Paused)
  * Detenido (Stopped)

El usuario puede presionar los botones:

  * `play()` → inicia o reanuda reproducción.
  * `pause()` → pausa si está reproduciendo.
  * `stop()` → detiene siempre, reseteando la canción.

El comportamiento de estos botones depende del estado actual. Ejemplo:

  * Si está detenido y presionas `pause()`, no tiene sentido (puede mostrar un mensaje de error).
  * Si está reproduciendo y presionas `play()`, también no hace nada (ya está reproduciendo).

## Diseño del ejercicio

1. Interfaz `State`.
    - Define los métodos: `play(), pause(), stop()`.
1. Clases de estados
    - `PlayingState`
    - `PausedState`
    - `StoppedState`
    - Cada una implementa la interfaz y define qué pasa en ese estado.
1. Clase `MusicPlayer` (Contexto)
    - Mantiene una referencia al estado actual (`private State state`).
    - Métodos públicos (`play(), pause(), stop()`) que delegan al estado.
    - Métodos `setState(State s)` para cambiar el estado actual.
1. Programa principal (`Main`)
    - Simula interacción: crear reproductor, probar secuencia de botones y mostrar mensajes por consola.

## 📦 Dependencias
Este proyecto usa [java-terminal-menu](https://github.com/philbone/java-terminal-menu), que simplifica la creación de menús interactivos. Descarga el jar(recomendado) desde el repo oficial, o descarga el proyecto, compila y crea tu propio ejecutable. Luego incluye el jar como una librería en tu proyecto/entorno de desarrollo.

## ✅ Ejemplo de ejecución
Al correr el programa, se verá un menú en la consola:

    🎶 Reproductor de Música 🎶
    1) Play
    2) Pause
    3) Stop
    4) Salir

Y las salidas cambian según el estado del reproductor:

    Iniciando reproducción ▶️
    La música ya está reproduciéndose 🎵
    Pausando la música ⏸️
    Deteniendo la música desde pausa ⏹️
