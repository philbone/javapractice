package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para té.
 */
public class PreparacionTe implements PreparacionStrategy
{
    /**
     * {@inheritDoc}
     */
    public String preparar() {
        AnimacionPreparacion.mostrarAnimacion(
            getPasosPreparacion(),
            getNombrePreparacion(),
            getTiempoPreparacion()
            );        
        return getNombrePreparacion() + " listo! Tiempo: " + getTiempoPreparacion() + "s";
    }
    
    public String getNombrePreparacion(){
        return "Té";
    }
    
    public int getTiempoPreparacion() {
        return 8;
    }
    
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
    
    public String getDescripcionBreve() {
        return "Té (Preparación: " + getTiempoPreparacion() + "s)";
    }
}