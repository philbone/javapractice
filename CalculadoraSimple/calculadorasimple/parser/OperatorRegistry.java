package calculadorasimple.parser;

import java.util.*;

/**
 * Registro centralizado de operadores y funciones.
 *
 * <p>
 * Los operadores y funciones matemáticas se registran aquí para que
 * puedan ser reconocidos por el parser y ejecutados por el evaluador.
 * </p>
 */
public class OperatorRegistry
{
    private static final Map<String, Operator> operators = new HashMap<>();

    static {
        // Operadores binarios
        operators.put("+", new Operator("+", 1, Associativity.LEFT, (a, b) -> a + b));
        operators.put("-", new Operator("-", 1, Associativity.LEFT, (a, b) -> a - b));
        operators.put("*", new Operator("*", 2, Associativity.LEFT, (a, b) -> a * b));
        operators.put("/", new Operator("/", 2, Associativity.LEFT, (a, b) -> a / b));
        operators.put("^", new Operator("^", 3, Associativity.RIGHT, Math::pow));

        // Ejemplo de unario (raíz cuadrada)
        operators.put("√", new Operator("√", 4, Associativity.RIGHT, Math::sqrt));
        operators.put("sin", new Operator("sin", 4, Associativity.RIGHT, Math::sin));
        operators.put("cos", new Operator("cos", 4, Associativity.RIGHT, Math::cos));
        operators.put("log", new Operator("log", 4, Associativity.RIGHT, Math::log));
    }
    
    /**
     * Obtiene un operador/función por su símbolo.
    */
    public static Operator get(String symbol) {
        return operators.get(symbol);
    }
    
    /**
     * Verifica si el símbolo corresponde a un operador o función registrado.
     */
    public static boolean isOperator(String symbol) {
        return operators.containsKey(symbol);
    }
}
