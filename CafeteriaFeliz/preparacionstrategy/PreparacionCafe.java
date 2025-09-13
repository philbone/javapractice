package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para café negro.
 */
public class PreparacionCafe implements PreparacionStrategy
{
    /**
     * {@inheritDoc}
     */
    public String preparar(){
        return "Preparando café negro...";
    }
}