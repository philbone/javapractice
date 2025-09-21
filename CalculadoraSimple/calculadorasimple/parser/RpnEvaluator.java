package calculadorasimple.parser;

import java.util.*;

public class RpnEvaluator
{

    public double evaluate(List<Token> rpnTokens) {
        Deque<Double> stack = new ArrayDeque<>();

        for (Token token : rpnTokens) {
            switch (token.getType()) {
                case NUMBER -> stack.push(Double.parseDouble(token.getValue()));

                case OPERATOR -> {
                    Operator op = OperatorRegistry.get(token.getValue());
                    if (op == null) {
                        throw new IllegalArgumentException("Operador desconocido: " + token.getValue());
                    }

                    double result;
                    if (op.operands == 2) {
                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Faltan operandos para " + op.symbol);
                        }
                        double b = stack.pop();
                        double a = stack.pop();
                        result = op.apply(a, b);
                    } else if (op.operands == 1) {
                        if (stack.isEmpty()) {
                            throw new IllegalArgumentException("Falta operando para " + op.symbol);
                        }
                        double a = stack.pop();
                        result = op.apply(a);
                    } else {
                        throw new IllegalStateException("Número de operandos no soportado: " + op.operands);
                    }

                    stack.push(result);
                }

                default -> throw new IllegalArgumentException("Token inesperado: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Expresión inválida, quedaron operandos sin usar: " + stack);
        }

        return stack.pop();
    }
}
