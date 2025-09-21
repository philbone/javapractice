package calculadorasimple.comandos;

import terminalmenu.Comando;
import calculadorasimple.parser.*;

import java.util.List;
import java.util.Scanner;

/**
 * @author Felipe M. philbone@focused.cl
 * 
 * Comando que permite al usuario ingresar una expresión matemática en formato
 * infijo (ejemplo: {@code 3+4*2/(1-5)}) y obtener su resultado evaluado.
 *
 * <p>
 * Este comando es parte de la capa de interacción con el usuario y se ejecuta
 * desde el menú principal. Internamente delega toda la lógica de parsing y
 * evaluación al paquete {@code parser}, que implementa el algoritmo de
 * Shunting-yard de Dijkstra para convertir expresiones a notación polaca
 * inversa (RPN), seguido de un evaluador basado en pila.
 * </p>
 *
 * <p>
 * Flujo de ejecución:
 * <ol>
 *   <li>Lee la entrada del usuario como cadena.</li>
 *   <li>Convierte la entrada en tokens con {@link Tokenizer}.</li>
 *   <li>Transforma los tokens en RPN con {@link ShuntingYardParser}.</li>
 *   <li>Evalúa la RPN con {@link RpnEvaluator} y muestra el resultado.</li>
 * </ol>
 * </p>
 *
 * <p>
 * Ejemplo de uso interactivo:
 * <pre>
 * Ingresa una expresión (ej: 3+4*2/(1-5)): 3+4*2/(1-5)
 *
 * 3+4*2/(1-5) = 1.0
 * </pre>
 * </p>
 */
public class ComandoResolverExpresion implements Comando
{

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa una expresión (ej: 3+4*2/(1-5)): ");
        String input = sc.nextLine().trim();

        try {
            // 1. Tokenizar la expresión
            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = tokenizer.tokenize();

            // 2. Convertir a RPN con Shunting-yard
            ShuntingYardParser parser = new ShuntingYardParser();
            List<Token> rpn = parser.toRPN(input);
            // Nota: usa tokens internamente, si tu implementación expone
            // toRPN(List<Token>) puedes pasar directamente "tokens".

            // 3. Evaluar la expresión en notación polaca inversa
            RpnEvaluator evaluator = new RpnEvaluator();
            double resultado = evaluator.evaluate(rpn);
            
            // 4. Mostrar el resultado al usuario
            System.out.println("\n" + input + " = " + resultado);

        } catch (Exception e) {
            // Captura cualquier error de parsing o evaluación
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
