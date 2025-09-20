package calculadorasimple.parser;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Tokenizador: separa la cadena en números, operadores y paréntesis.
 */
public class Tokenizer
{
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public static List<Token> tokenize(String expr) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c) || c == '.') {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    tokens.add(new Token(TokenType.NUMBER, number.toString()));
                    number.setLength(0);
                }

                if (OPERATORS.contains(String.valueOf(c))) {
                    tokens.add(new Token(TokenType.OPERATOR, String.valueOf(c)));
                } else if (c == '(') {
                    tokens.add(new Token(TokenType.LEFT_PAREN, "("));
                } else if (c == ')') {
                    tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
                } else {
                    throw new IllegalArgumentException("Carácter inesperado: " + c);
                }
            }
        }

        if (number.length() > 0) {
            tokens.add(new Token(TokenType.NUMBER, number.toString()));
        }

        return tokens;
    }
}