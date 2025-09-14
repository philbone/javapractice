package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para té.
 */
public class PreparacionTe extends PreparacionBase
{
    /**
    * {@inheritDoc}
    */
    public String getNombrePreparacion(){
        return "Té";
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
             "Calentando agua a 80°C (óptimo para té)",
            "Seleccionando hojas de té de alta calidad",
            "Precalentando la tetera de cerámica",
            "Colocando hojas de té en el infusor",
            "Vertiendo agua sobre las hojas suavemente",
            "Dejando infusionar por 3 minutos exactos",
            "Retirando el infusor en el punto perfecto",
            "Sirviendo en taza con aroma delicado"
        };
    }
}