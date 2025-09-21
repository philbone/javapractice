package calculadorasimple.parser;

import java.util.*;

public class OperatorRegistry
{
    private static final Map<String, Operator> operators = new HashMap<>();

    static {
        // Operadores binarios
        operators.put("+", new Operator("+", 1, Associativity.LEFT, (a, b) -> a + b));
        operators.put("-", new Operator("-", 1, Associativity.LEFT, (a, b) -> a - b));
        operators.put("*", new Operator("*", 2, Associativity.LEFT, (a, b) -> a * b));
        operators.put("/", new Operator("/", 2, Associativity.LEFT, (a, b) -> a / b));        

        // Ejemplo de unario (raíz cuadrada)
        operators.put("√", new Operator("√", 3, Associativity.RIGHT, Math::sqrt));
    }

    public static Operator get(String symbol) {
        return operators.get(symbol);
    }

    public static boolean isOperator(String symbol) {
        return operators.containsKey(symbol);
    }
}
