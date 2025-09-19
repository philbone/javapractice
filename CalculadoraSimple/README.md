# 📘 Ejercicio de Programación – Calculadora con Patrón Command (Incremento 1)

## 1. Contexto del Ejercicio
El objetivo es desarrollar una calculadora simple de consola en Java utilizando el patrón Command implementado como interfaz funcional junto con expresiones lambda.
La calculadora permitirá al usuario ejecutar operaciones matemáticas básicas con un número variable de operandos (N operandos).
Este ejercicio busca reforzar conceptos de patrones de diseño, programación funcional en Java y extensibilidad del software.

## 2. Requerimientos del Sistema
 1. La calculadora debe ejecutarse en consola.
 1. El usuario podrá seleccionar una operación (ej. sumar, restar, multiplicar, dividir).
 1. El usuario podrá ingresar N operandos (no solo dos).
 1. El sistema debe ejecutar el comando correspondiente y mostrar el resultado.
 1. Debe ser posible agregar nuevas operaciones sin modificar el núcleo de la calculadora, solo registrándolas en un mapa de comandos.
 1. El programa debe seguir en ejecución hasta que el usuario decida salir.

## 3. Patrón de Diseño Utilizado
  * **Command Pattern** en una versión funcional:
    * Command se define como interfaz funcional con un único método `execute(double... args)`.
    * Las operaciones se implementan mediante **expresiones lambda** y se registran en un `Map<String, Command>`.
  * Este diseño permite:
    * Desacoplar la invocación de la operación de su implementación.
    * Facilitar la extensibilidad del sistema sin tocar el código base.

## 4. Clases de Negocio y Responsabilidades
### 4.1 Command (Interfaz funcional)
    @FunctionalInterface
        interface Command {
        double execute(double... args);
    }

  * Define la acción común que todos los comandos deben cumplir.
  * Utiliza varargs para soportar N operandos.

### 4.2 ConcreteCommands (definidos como lambdas)
  * **Suma:** `(args) -> Arrays.stream(args).sum()`

  * **Resta:** `(args) -> { double r = args[0]; for (int i=1; i<args.length; i++) r -= args[i]; return r; }`

  * **Multiplicación:** `(args) -> Arrays.stream(args).reduce(1, (a,b) -> a*b)`

  * **División:** `(args) -> { double r = args[0]; for (int i=1; i<args.length; i++) { if(args[i]==0) throw new IllegalArgumentException("División por cero"); r /= args[i]; } return r; }`

### 4.3 Command Registry
  * `Map<String, Command> comandos`
  * Contiene el registro de operaciones disponibles.
  * Permite agregar nuevas operaciones fácilmente.

### 4.4 Invoker (Consola / UI)
  * Encargado de:
  * Pedir al usuario el nombre de la operación.
  * Leer los operandos.
  * Buscar el comando correspondiente en el mapa.
  * Ejecutar el comando y mostrar el resultado.

### 4.5 Client (Main)
  * Configura el `Map<String, Command>` inicial con las operaciones básicas.
  * Inicia el ciclo de interacción con el usuario.

### 5. Reglas de Negocio
1. **Suma:** admite cualquier cantidad de operandos; si no hay operandos → resultado = `0`.
1. **Multiplicación:** admite cualquier cantidad de operandos; si no hay operandos → resultado = `1`.
1. **Resta:** requiere al menos un operando; si hay más de uno → aplica de izquierda a derecha.
1. **División:** requiere al menos un operando; si hay más de uno → aplica de izquierda a derecha.
    1. **Prohibido dividir por cero:** lanzar excepción o mostrar mensaje de error.
1. **Entrada inválida:** si el usuario ingresa un comando inexistente o valores no numéricos, se debe mostrar un mensaje de error y solicitar nuevamente la entrada.

### 6. Validaciones

  * Validar que los operandos sean números válidos `(double)`.
  * Validar número mínimo de operandos según la operación.
  * Validar división por cero.
  * Validar que el comando solicitado exista en el registro.

### 7. Extensiones Futuras (Incremento 2)
  * Implementar historial de operaciones.
  * Soporte para undo/redo.
  * Pasar de lambdas a clases concretas que puedan mantener estado interno.
  * Agregar operaciones más avanzadas (potencia, raíz cuadrada, logaritmos, etc.).

