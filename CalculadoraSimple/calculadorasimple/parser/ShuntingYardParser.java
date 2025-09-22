package calculadorasimple.parser;

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Implementación del algoritmo Shunting-yard de Dijkstra.
 *
 * <p>
 * Convierte una lista de tokens en notación infija a una lista de tokens en
 * notación polaca inversa (RPN), lista para ser evaluada.
 * </p>
 *
 * <p>
 * Reglas principales:
 * <ul>
 *   <li>Los números se envían directamente a la salida.</li>
 *   <li>Los operadores se apilan respetando precedencia y asociatividad.</li>
 *   <li>Los paréntesis controlan la agrupación y se eliminan en el proceso.</li>
 *   <li>Las funciones se tratan como operadores unarios y se apilan hasta
 *       encontrar el paréntesis derecho correspondiente.</li>
 * </ul>
 * </p>
 */
public class ShuntingYardParser
{
    /**
     * Convierte una expresión en notación infija a notación polaca inversa (RPN).
     *
     * @param expression cadena de la expresión original
     * @return lista de tokens en orden RPN
     */
    public List<Token> toRPN(String expression) {
        Tokenizer tokenizer = new Tokenizer(expression);
        List<Token> tokens = tokenizer.tokenize();

        List<Token> output = new ArrayList<>();
        Deque<Token> stack = new ArrayDeque<>();

        for (Token token : tokens) {
            switch (token.getType()) {
                case NUMBER -> output.add(token);

                case FUNCTION -> {
                    // Las funciones se apilan
                    stack.push(token);
                }

                case OPERATOR -> {
                    Operator o1 = OperatorRegistry.get(token.getValue());

                    while (!stack.isEmpty() && stack.peek().getType() == Token.Type.OPERATOR) {
                        Operator o2 = OperatorRegistry.get(stack.peek().getValue());
                        if ((o1.associativity == Associativity.LEFT && o1.precedence <= o2.precedence) ||
                            (o1.associativity == Associativity.RIGHT && o1.precedence < o2.precedence)) {
                            output.add(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.push(token);
                }

                case PARENTHESIS -> {
                    if (token.getValue().equals("(")) {
                        stack.push(token);
                    } else {
                        // Procesar hasta encontrar "("
                        while (!stack.isEmpty() && !stack.peek().getValue().equals("(")) {
                            output.add(stack.pop());
                        }
                        if (stack.isEmpty()) {
                            throw new IllegalArgumentException("Paréntesis desbalanceados");
                        }
                        stack.pop(); // descartar "("

                        // Si lo siguiente en la pila es una función, moverla a salida
                        if (!stack.isEmpty() && stack.peek().getType() == Token.Type.FUNCTION) {
                            output.add(stack.pop());
                        }
                    }
                }
            }
        }

        // Desapilar lo que quede
        while (!stack.isEmpty()) {
            Token t = stack.pop();
            if (t.getType() == Token.Type.PARENTHESIS) {
                throw new IllegalArgumentException("Paréntesis desbalanceados en la expresión");
            }
            output.add(t);
        }

        return output;
    }
}