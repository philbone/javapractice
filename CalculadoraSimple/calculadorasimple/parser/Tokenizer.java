package calculadorasimple.parser;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Convierte una cadena de expresión matemática en una lista de tokens.
 *
 * <p>
 * Soporta:
 * <ul>
 *   <li>Números (enteros o decimales, ej: 3, 2.5).</li>
 *   <li>Operadores (+, -, *, /, ^).</li>
 *   <li>Paréntesis ( ) para agrupar expresiones.</li>
 *   <li>Funciones matemáticas unarias (ej: sin, cos, log).</li>
 *   <li>Constantes: pi, e.</li>
 * </ul>
 * </p>
 *
 * <p>
 * La clase recorre carácter por carácter la expresión de entrada y genera tokens
 * adecuados que luego serán usados por el parser (Shunting-yard).
 * </p>
 */
public class Tokenizer
{
    private final String expression;
    private final List<Token> tokens = new ArrayList<>();
    private int pos = 0;

    public Tokenizer(String expression) {
        // Se eliminan espacios en blanco para simplificar el análisis
        this.expression = expression.replaceAll("\\s+", "");
    }

    /**
     * Realiza el proceso de tokenización de la expresión.
     *
     * @return lista de tokens identificados
     */
    public List<Token> tokenize() {
        while (pos < expression.length()) {
            char c = expression.charAt(pos);

            if (Character.isDigit(c) || c == '.') {
                tokens.add(readNumber());
            } else if (Character.isLetter(c)) {
                tokens.add(readIdentifier());
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
     *
     * @return token de tipo FUNCTION o NUMBER (si es una constante).
     */
    private Token readIdentifier() {
        StringBuilder sb = new StringBuilder();
        while (pos < expression.length() && Character.isLetter(expression.charAt(pos))) {
            sb.append(expression.charAt(pos));
            pos++;
        }
        String id = sb.toString().toLowerCase();

        // Constantes → tratadas como NUMBER con su valor
        switch (id) {
            case "pi": return new Token(Token.Type.NUMBER, String.valueOf(Math.PI));
            case "e": return new Token(Token.Type.NUMBER, String.valueOf(Math.E));
        }

        // Si no es constante, se asume función
        return new Token(Token.Type.FUNCTION, id);
    }
}