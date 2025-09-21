package calculadorasimple.parser;

import java.util.*;

/**
 * Evalúa una expresión en notación polaca inversa (RPN).
 *
 * <p>
 * Utiliza una pila para procesar tokens en orden:
 * <ul>
 *   <li>Los números se apilan directamente.</li>
 *   <li>Cuando se encuentra un operador, se desapilan los operandos
 *       requeridos (1 o 2) y se aplica la operación correspondiente
 *       usando la definición en {@link OperatorRegistry}.</li>
 *   <li>El resultado de la operación se vuelve a apilar.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Al final del proceso, la pila debe contener exactamente un valor,
 * que corresponde al resultado de la expresión.
 * </p>
 */
public class RpnEvaluator
{
    /**
     * Evalúa una lista de tokens en notación polaca inversa.
     *
     * @param rpnTokens lista de tokens ya convertidos a RPN
     * @return resultado de la evaluación
     * @throws IllegalArgumentException si hay operadores desconocidos
     * @throws IllegalStateException    si la expresión es inválida
     */
    public double evaluate(List<Token> rpnTokens) {
        Deque<Double> stack = new ArrayDeque<>();

        for (Token token : rpnTokens) {
            switch (token.getType()) {
                // Los números se convierten a double y se apilan.
                case NUMBER -> stack.push(Double.parseDouble(token.getValue()));

                case OPERATOR -> {
                    // Obtener el operador desde el registro global.
                    Operator op = OperatorRegistry.get(token.getValue());
                    if (op == null) {
                        throw new IllegalArgumentException("Operador desconocido: " + token.getValue());
                    }

                    double result;
                    if (op.operands == 2) {
                        // Operador binario: requiere dos operandos.
                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Faltan operandos para " + op.symbol);
                        }
                        double b = stack.pop();
                        double a = stack.pop();
                        result = op.apply(a, b);
                    } else if (op.operands == 1) {
                        // Operador unario: requiere un operando.
                        if (stack.isEmpty()) {
                            throw new IllegalArgumentException("Falta operando para " + op.symbol);
                        }
                        double a = stack.pop();
                        result = op.apply(a);
                    } else {
                        throw new IllegalStateException("Número de operandos no soportado: " + op.operands);
                    }
                    // Apilar el resultado de la operación.
                    stack.push(result);
                }

                default -> throw new IllegalArgumentException("Token inesperado: " + token);
            }
        }
        
        // Validar que quedó exactamente un resultado en la pila.
        if (stack.size() != 1) {
            throw new IllegalStateException("Expresión inválida, quedaron operandos sin usar: " + stack);
        }

        return stack.pop();
    }
}
