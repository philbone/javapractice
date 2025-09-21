package calculadorasimple.parser;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Operator {
    public final String symbol;
    public final int precedence;
    public final Associativity associativity;
    public final int operands;

    private final BiFunction<Double, Double, Double> binaryOp;
    private final Function<Double, Double> unaryOp;

    // Constructor binario
    public Operator(String symbol, int precedence, Associativity associativity,
                    BiFunction<Double, Double, Double> binaryOp) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.associativity = associativity;
        this.operands = 2;
        this.binaryOp = binaryOp;
        this.unaryOp = null;
    }

    // Constructor unario
    public Operator(String symbol, int precedence, Associativity associativity,
                    Function<Double, Double> unaryOp) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.associativity = associativity;
        this.operands = 1;
        this.binaryOp = null;
        this.unaryOp = unaryOp;
    }

    public double apply(double a, double b) {
        if (binaryOp == null) {
            throw new UnsupportedOperationException("Operador no binario: " + symbol);
        }
        return binaryOp.apply(a, b);
    }

    public double apply(double a) {
        if (unaryOp == null) {
            throw new UnsupportedOperationException("Operador no unario: " + symbol);
        }
        return unaryOp.apply(a);
    }
}
