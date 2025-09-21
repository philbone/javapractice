package calculadorasimple.parser;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Tokenizador: separa la cadena en números, operadores y paréntesis.
 */
public class Tokenizer
{
    private final String expression;
    private final List<Token> tokens = new ArrayList<>();
    private int pos = 0;

    public Tokenizer(String expression) {
        this.expression = expression.replaceAll("\\s+", ""); // quitar espacios
    }

    public List<Token> tokenize() {
        while (pos < expression.length()) {
            char c = expression.charAt(pos);

            if (Character.isDigit(c) || c == '.') {
                tokens.add(readNumber());
            } else if (c == '(' || c == ')') {
                tokens.add(new Token(Token.Type.PARENTHESIS, String.valueOf(c)));
                pos++;
            } else {
                String symbol = String.valueOf(c);
                if (OperatorRegistry.isOperator(symbol)) {
                    tokens.add(new Token(Token.Type.OPERATOR, symbol));
                    pos++;
                } else {
                    throw new IllegalArgumentException("Símbolo no reconocido: " + c);
                }
            }
        }
        return tokens;
    }

    private Token readNumber() {
        StringBuilder sb = new StringBuilder();
        while (pos < expression.length()) {
            char c = expression.charAt(pos);
            if (Character.isDigit(c) || c == '.') {
                sb.append(c);
                pos++;
            } else {
                break;
            }
        }
        return new Token(Token.Type.NUMBER, sb.toString());
    }
}