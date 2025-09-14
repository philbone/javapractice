package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para café negro.
 */
public class PreparacionCafe extends PreparacionBase
{
    /**
    * {@inheritDoc}
    */
    public String getNombrePreparacion(){
        return "Cafe Negro";
    }
    
    /**
    * {@inheritDoc}
    */
    public int getTiempoPreparacion() {
        return 8;
    }
    
    /**
    * {@inheritDoc}
    */
    public String[] getPasosPreparacion() {
        return new String[] {
            "Calentando agua a 92°C",
            "Moliendo granos de café arábica",
            "Preparando filtro con 15g de café molido",
            "Vertiendo agua caliente en círculos concéntricos",
            "Dejando infusionar por 30 segundos",
            "Completando el vertido",
            "Revolviendo suavemente",
            "Sirviendo en taza precalentada"
        };
    }
}