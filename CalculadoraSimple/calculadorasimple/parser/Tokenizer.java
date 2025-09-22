package calculadorasimple.parser;

import java.util.*;

/**
 * Convierte una cadena de expresión matemática en una lista de tokens.
 *
 * <p>
 * Soporta:
 * <ul>
 *   <li>Números (enteros o decimales, con signo unario opcional al inicio).</li>
 *   <li>Operadores (+, -, *, /, ^).</li>
 *   <li>Paréntesis ( ) para agrupar expresiones.</li>
 *   <li>Funciones matemáticas unarias (ej: sin, cos, log, √).</li>
 *   <li>Constantes: pi, e.</li>
 * </ul>
 * </p>
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
            } else if (Character.isLetter(c) || c == '√') {
                tokens.add(readIdentifier());
            } else if (c == '(' || c == ')') {
                tokens.add(new Token(Token.Type.PARENTHESIS, String.valueOf(c)));
                pos++;
            } else if (c == '+' || c == '-') {
                handleSign(c);
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

    /**
     * Maneja signos + y - que pueden ser unarios o binarios.
     */
    private void handleSign(char sign) {
        boolean esUnario = tokens.isEmpty()
                || tokens.get(tokens.size() - 1).getType() == Token.Type.OPERATOR
                || tokens.get(tokens.size() - 1).getValue().equals("(");

        if (esUnario) {
            // Agregamos un operador unario explícito
            tokens.add(new Token(Token.Type.OPERATOR, sign == '-' ? "neg" : "pos"));
            pos++;
        } else {
            // Es operador binario normal
            tokens.add(new Token(Token.Type.OPERATOR, String.valueOf(sign)));
            pos++;
        }
    }

    /**
     * Lee un número (soporta decimales).
     */
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

    /**
     * Lee un identificador (función o constante).
     */
    private Token readIdentifier() {
        StringBuilder sb = new StringBuilder();
        while (pos < expression.length() && (Character.isLetter(expression.charAt(pos)) || expression.charAt(pos) == '√')) {
            sb.append(expression.charAt(pos));
            pos++;
        }
        String id = sb.toString().toLowerCase();

        // Constantes → tratadas como NUMBER
        switch (id) {
            case "pi": return new Token(Token.Type.NUMBER, String.valueOf(Math.PI));
            case "e": return new Token(Token.Type.NUMBER, String.valueOf(Math.E));
        }

        // Si no es constante, se asume función/operador unario
        return new Token(Token.Type.FUNCTION, id);
    }
}
