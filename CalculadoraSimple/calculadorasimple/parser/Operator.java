package calculadorasimple.parser;

class Operator
{
    final String symbol;
    final int precedence;
    final Associativity associativity;
    final int operands;

    Operator(String symbol, int precedence, Associativity associativity, int operands) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.associativity = associativity;
        this.operands = operands;
    }
}