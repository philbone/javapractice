package calculadorasimple.parser;

/**
 * Representa un token individual.
 */
public class Token
{
    final TokenType type;
    final String value;

    Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
