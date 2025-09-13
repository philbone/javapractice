/**
 * Implementación de la estrategia de preparación para capuccino.
 */
public class PreparacionCapuccino implements PreparacionStrategy
{
    /**
     * {@inheritDoc}
     */
    public String preparar() {
        return "Preparando capuccino...";
    }
}