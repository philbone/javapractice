/**
 * Implementación de la estrategia de preparación para té.
 */
public class PreparacionTe implements PreparacionStrategy
{
    /**
     * {@inheritDoc}
     */
    public String preparar() {
        return "Preparando té...";
    }
}