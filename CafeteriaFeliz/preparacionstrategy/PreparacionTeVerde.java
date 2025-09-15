package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para té.
 */
public class PreparacionTeVerde extends PreparacionBase
{
    /**
    * {@inheritDoc}
    */
    public String getNombrePreparacion(){
        return "Té Verde";
    }
    
    /**
    * {@inheritDoc}
    */
    public int getTiempoPreparacion() {
        return 15;
    }
    
    /**
    * {@inheritDoc}
    */
    public String[] getPasosPreparacion() {
        return new String[] {
            "Calentando agua a 70°C (óptimo para té verde)",
            "Pesando 2.5 gramos de hojas verdes seleccionadas",
            "Precalentando la tetera de cerámica",
            "Agregando las hojas de té en la taza",
            "Vertiendo agua sobre las hojas suavemente",
            "Dejando infusionar por 3 minutos exactos",
            "Retirando las hojas en el punto perfecto",
            "Sirviendo en taza con aroma delicado"
        };
    }
}
