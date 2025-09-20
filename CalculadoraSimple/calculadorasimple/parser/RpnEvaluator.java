package calculadorasimple.parser;

import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

/**
 * Evaluador de una expresión en RPN.
 */
public class RpnEvaluator
{
    private static final Map<String, Operator> OPERATORS = ShuntingYardParser.OPERATORS;

    public static double eval(List<Token> rpnTokens) {
        Deque<Double> stack = new ArrayDeque<>();

        for (Token token : rpnTokens) {
            switch (token.type) {
                case NUMBER -> stack.push(Double.parseDouble(token.value));
                case OPERATOR -> {
                    Operator op = OPERATORS.get(token.value);
                    if (stack.size() < op.operands) {
                        throw new IllegalArgumentException("Operandos insuficientes para " + token.value);
                    }
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = switch (op.symbol) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> a / b;
                        default -> throw new UnsupportedOperationException("Operador no soportado: " + op.symbol);
                    };
                    stack.push(result);
                }
                default -> throw new IllegalArgumentException("Token inesperado: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Expresión inválida");
        }

        return stack.pop();
    }
}