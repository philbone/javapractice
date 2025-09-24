# 🏰 Ejercicio de Programación Orientada a Objetos con Patrón Visitor  
Proyecto de ejemplo en **Java** para aprender y practicar el patrón de diseño **Visitor** en el contexto de una mazmorra de videojuego.

---

## 🎯 Objetivo del ejercicio
El propósito es entender cómo el patrón **Visitor** permite **separar las operaciones de los objetos** sobre los que actúan.  
En lugar de que cada clase (`Tesoro`, `Trampa`, `Monstruo`) tenga toda la lógica, definimos visitantes que encapsulan comportamientos distintos.

De esta forma:

- Es **fácil agregar nuevos visitantes** (funcionalidades) sin modificar las clases existentes.
- Los alumnos ven un caso **creativo y cercano a videojuegos**, en lugar de ejemplos teóricos aburridos.

---

## 📂 Estructura del proyecto
    src/
    └── MainMazmorra.java # Clase principal con ejemplo de uso
    └── mazmorra/
        ├── Habitacion.java # Interfaz común para todos los tipos de habitaciones
        ├── Tesoro.java # Representa un tesoro en la mazmorra
        ├── Trampa.java # Representa una trampa peligrosa
        ├── Monstruo.java # Representa un monstruo enemigo
        ├── Visitante.java # Interfaz Visitor (visitantes concretos implementan este contrato)
        ├── Jugador.java # Visitante: simula al jugador explorando la mazmorra
        ├── Mapa.java # Visitante: imprime una descripción textual de las habitaciones
        ├── Contador.java # Visitante: cuenta cuántos tesoros, trampas y monstruos existen
        └── ExportadorJson.java # Visitante: exporta la mazmorra en formato JSON
### El programa


  * Simula un jugador explorando la mazmorra.
  * Muestra un mapa con las descripciones.
  * Cuenta cuántos elementos hay.
  * Exporta la mazmorra a un archivo JSON en la ruta indicada por el usuario.

## 🧩 Ejemplo de salida JSON
    [
      {
        "tipo": "Tesoro",
        "nombre": "Cofre de oro",
        "valor": 100
      },
      {
        "tipo": "Trampa",
        "descripcion": "Pozo con pinchos",
        "danio": 30
      },
      {
        "tipo": "Monstruo",
        "nombre": "Orco",
        "fuerza": 40
      },
      {
        "tipo": "Tesoro",
        "nombre": "Gema mágica",
        "valor": 200
      },
      {
        "tipo": "Monstruo",
        "nombre": "Dragón pequeño",
        "fuerza": 70
      }
    ]
