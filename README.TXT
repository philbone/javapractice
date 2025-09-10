# Gestión de Ventas de Tortas Artesanales

## Contexto del ejercicio:

Una pastelería artesanal desea modernizar la gestión de sus ventas. Necesita un sistema que
permita almacenar información de clientes, pasteleros, tortas y ventas. El sistema debe
calcular el precio unitario según tamaño y recargos (sabor/ decoración), aplicar descuentos bajo ciertas condiciones y determinar el monto final a pagar.

Para registrar una venta se requiere la información básica del cliente, la torta solicitada y el pastelero responsable de la
elaboración.

**Esta solución aplica al menos 2 principios SOLID:**

- SRP → cada clase tiene su rol claro.
- OCP → se puede agregar más descuentos sin tocar la clase Venta.

**Además se apoya en 2 patrones de diseño clásicos:**

- Strategy → descuentos son intercambiables.
- Factory Method → encapsula la lógica de precio de tortas.

## Requerimientos
1. Clase Cliente
    - rut (string)
    - nombre (string)
    - edad (byte)
    - email(string)

2. Clase Pastelero
    - rut (string)
    - nroPastelero (int)
    - nombre (string)
    - fechaIngreso (string)
    - especialidad (string) — p. ej. “decoración temática”, “rellenos”

3. Clase Torta
    - codigo (int único)
    - nombre (string)
    - tamano (string): “8 porciones” / “12 porciones” / “20 porciones”
    - sabor (string): “Vainilla” / “Chocolate” / “Pistacho” / “Tres Leches”
    - decoracion (string): “Simple” / “Personalizada” / “Temática”
    - precioUnitario (float): (asignado automáticamente según tablas y recargos)

4. Clase Venta
    - cliente (referencia a Cliente)
    - torta (referencia a Torta)
    - pastelero (referencia a Pastelero)
    - cantidad (int)
    - fechaVenta (string)

## Precios y Recargos

### Tabla de precio base por tamaño y precio base (CLP):

- 8 porciones $12.000
- 12 porciones $18.000
- 20 porciones $30.000

#### Recargos por sabor (sobre el precio base):
- Vainilla: +0%
- Chocolate: +10%
- Tres Leches: +15%
- Pistacho: +20%

### Recargos por decoración (monto fijo):
- Simple: +$0
- Personalizada: +$5.000
- Temática: +$10.000
  
### Cálculo del precioUnitario de la Torta:
`precioUnitario = precioBase(tamaño) * (1+recargoSabor) + recargoDecoracion`

## Reglas de Negocio
1. **Total bruto de la venta** se calcula como: `totalBruto = cantidad * precioUnitario`
    - el precioUnitario proviene del cálculo automático en Torta)

2. **Descuentos aplicables**, en este orden (Solo uno de estos dos descuentos por monto aplica):
    - Si el cliente tiene más de 65 años, aplicar 15% primero sobre el totalBruto.
    - Luego, según el monto restante:
        - Si supera $50.000, aplicar 10% adicional.
        - Si es $120.000 o más, aplicar 20% (en vez del 10%).

3. **Total neto** se calcula como: `totalNeto = totalBruto – descuentosAcumulados`

4. **Confirmación de la venta**
    - Una venta queda confirmada si:
        - edad del cliente está entre 18 y 80 (inclusive),
        - Existen cliente, torta, pastelero válidos,
        - cantidad > 0,
        - pasan todas las validaciones.

## Validaciones
- Cliente
    - nombre, no puede estar vacío
    - edad, entre 18 y 80 (inclusive) para confirmar venta.
- Pastelero
    - nombre, no puede estar vacío
    - fechaIngreso, Largo de 8 caracteres
- Torta
    - tamaño, ingresos a validar: “8 porciones”, “12 porciones”, “20 porciones”.
    - sabor, ingresos a validad: “Vainilla”, “Chocolate”, “Pistacho”, “Tres
Leches”.
    - decoracion, ingresos a validar: “Simple”, “Personalizada”, “Temática”.
    - precioUnitario, se asigna automáticamente según tablas/recargos; no se
ingresa manualmente.
- Venta
-   - cantidad > 0
    - Debe existir cliente, torta y pastelero previamente registrados.
    - Las validaciones se ejecutan al momento del ingreso y antes de confirmar.

