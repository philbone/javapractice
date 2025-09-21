package calculadorasimple.parser;

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Conversor Shunting-yard: de infija a RPN.
 */
public class ShuntingYardParser
{
    public List<Token> toRPN(String expression) {
        List<Token> output = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        // Aquí delegamos la tokenización
        List<Token> tokens = new Tokenizer(expression).tokenize();

        for (Token token : tokens) {
            switch (token.getType()) {
                case NUMBER -> output.add(token);

                case OPERATOR -> {
                    Operator o1 = OperatorRegistry.get(token.getValue());

                    while (!stack.isEmpty() && OperatorRegistry.isOperator(stack.peek())) {
                        Operator o2 = OperatorRegistry.get(stack.peek());
                        if ((o1.associativity == Associativity.LEFT && o1.precedence <= o2.precedence) ||
                            (o1.associativity == Associativity.RIGHT && o1.precedence < o2.precedence)) {
                            output.add(new Token(Token.Type.OPERATOR, stack.pop()));
                        } else {
                            break;
                        }
                    }
                    stack.push(token.getValue());
                }

                case PARENTHESIS -> {
                    if (token.getValue().equals("(")) {
                        stack.push(token.getValue());
                    } else {
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            output.add(new Token(Token.Type.OPERATOR, stack.pop()));
                        }
                        if (!stack.isEmpty() && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            throw new IllegalArgumentException("Paréntesis desbalanceados");
                        }
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            String op = stack.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new IllegalArgumentException("Paréntesis desbalanceados en la expresión");
            }
            output.add(new Token(Token.Type.OPERATOR, op));
        }

        return output;
    }
}