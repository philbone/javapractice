/**
 * Implementación de la estrategia de preparación para chocolate caliente.
 */
public class PreparacionChocolate implements PreparacionStrategy
{
    /**
    * {@inheritDoc}
    */
    public String preparar() {
        return "Preparando chocolate caliente...";
    }
}