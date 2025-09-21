package calculadorasimple.parser;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Felipe M. philbone@focused.cl
 * 
 * Representa un operador matemático (unario o binario) en la calculadora.
 *
 * <p>
 * Cada operador conoce:
 * <ul>
 *   <li>Su símbolo textual (ej: "+", "-", "*", "/").</li>
 *   <li>Su precedencia (entero mayor = más prioridad).</li>
 *   <li>Su asociatividad (izquierda o derecha).</li>
 *   <li>El número de operandos que consume (1 o 2).</li>
 *   <li>La lógica de ejecución correspondiente (función unaria o binaria).</li>
 * </ul>
 * </p>
 *
 * <p>
 * Gracias a este diseño, la lógica de cada operación queda encapsulada en el propio
 * operador, evitando tener que usar estructuras condicionales (como switch o if)
 * en el evaluador.
 * </p>
 */
public class Operator
{
    /** Símbolo textual del operador, ej: "+" o "√". */
    public final String symbol;
    
    /** Nivel de precedencia (mayor valor = más prioridad). */
    public final int precedence;
    
    /** Asociatividad: izquierda o derecha. */    
    public final Associativity associativity;
    
    /** Número de operandos requeridos (1 = unario, 2 = binario). */
    public final int operands;
    
    /** Implementación para operadores binarios. */
    private final BiFunction<Double, Double, Double> binaryOp;
    
    /** Implementación para operadores unarios. */
    private final Function<Double, Double> unaryOp;

    /**
     * Constructor para operadores binarios (ej: +, -, *, /).
     *
     * @param symbol        símbolo textual del operador
     * @param precedence    precedencia del operador
     * @param associativity asociatividad (izquierda o derecha)
     * @param binaryOp      lógica binaria (a, b) -> resultado
     */
    public Operator(String symbol, int precedence, Associativity associativity,
                    BiFunction<Double, Double, Double> binaryOp) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.associativity = associativity;
        this.operands = 2;
        this.binaryOp = binaryOp;
        this.unaryOp = null;
    }

    /**
     * Constructor para operadores unarios (ej: √, negación).
     *
     * @param symbol        símbolo textual del operador
     * @param precedence    precedencia del operador
     * @param associativity asociatividad (izquierda o derecha)
     * @param unaryOp       lógica unaria (a) -> resultado
     */
    public Operator(String symbol, int precedence, Associativity associativity,
                    Function<Double, Double> unaryOp) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.associativity = associativity;
        this.operands = 1;
        this.binaryOp = null;
        this.unaryOp = unaryOp;
    }
    
    /**
     * Aplica un operador binario a dos operandos.
     *
     * @param a primer operando
     * @param b segundo operando
     * @return resultado de aplicar la operación
     * @throws UnsupportedOperationException si el operador no es binario
     */
    public double apply(double a, double b) {
        if (binaryOp == null) {
            throw new UnsupportedOperationException("Operador no binario: " + symbol);
        }
        return binaryOp.apply(a, b);
    }
    
    /**
     * Aplica un operador unario a un operando.
     *
     * @param a operando
     * @return resultado de aplicar la operación
     * @throws UnsupportedOperationException si el operador no es unario
     */
    public double apply(double a) {
        if (unaryOp == null) {
            throw new UnsupportedOperationException("Operador no unario: " + symbol);
        }
        return unaryOp.apply(a);
    }
}
