package calculadorasimple.parser;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Conversor Shunting-yard: de infija a RPN.
 */
public class ShuntingYardParser
{
    protected static final Map<String, Operator> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", new Operator("+", 2, Associativity.LEFT, 2));
        OPERATORS.put("-", new Operator("-", 2, Associativity.LEFT, 2));
        OPERATORS.put("*", new Operator("*", 3, Associativity.LEFT, 2));
        OPERATORS.put("/", new Operator("/", 3, Associativity.LEFT, 2));
        // futuro: ^, %, sqrt, etc.
    }

    public static List<Token> toRPN(List<Token> tokens) {
        List<Token> output = new ArrayList<>();
        Deque<Token> stack = new ArrayDeque<>();

        for (Token token : tokens) {
            switch (token.type) {
                case NUMBER -> output.add(token);
                case FUNCTION -> stack.push(token);
                case OPERATOR -> {
                    Operator o1 = OPERATORS.get(token.value);
                    while (!stack.isEmpty() && stack.peek().type == TokenType.OPERATOR) {
                        Operator o2 = OPERATORS.get(stack.peek().value);
                        if ((o1.associativity == Associativity.LEFT && o1.precedence <= o2.precedence)
                                || (o1.associativity == Associativity.RIGHT && o1.precedence < o2.precedence)) {
                            output.add(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.push(token);
                }
                case LEFT_PAREN -> stack.push(token);
                case RIGHT_PAREN -> {
                    while (!stack.isEmpty() && stack.peek().type != TokenType.LEFT_PAREN) {
                        output.add(stack.pop());
                    }
                    if (stack.isEmpty() || stack.peek().type != TokenType.LEFT_PAREN) {
                        throw new IllegalArgumentException("Paréntesis desbalanceados");
                    }
                    stack.pop(); // quitar "("
                    if (!stack.isEmpty() && stack.peek().type == TokenType.FUNCTION) {
                        output.add(stack.pop());
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            Token t = stack.pop();
            if (t.type == TokenType.LEFT_PAREN || t.type == TokenType.RIGHT_PAREN) {
                throw new IllegalArgumentException("Paréntesis desbalanceados");
            }
            output.add(t);
        }

        return output;
    }
}