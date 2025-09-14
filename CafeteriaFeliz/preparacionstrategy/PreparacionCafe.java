package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para café negro.
 */
public class PreparacionCafe implements PreparacionStrategy
{   
    public String preparar() {
        AnimacionPreparacion.mostrarAnimacion(
            getPasosPreparacion(),
            getNombrePreparacion(),
            getTiempoPreparacion()
            );        
        return getNombrePreparacion() + " listo! Tiempo: " + getTiempoPreparacion() + "s";
    }
    
    public String getNombrePreparacion(){
        return "Cafe Negro";
    }
    
    public int getTiempoPreparacion() {
        return 8;
    }
    
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
    
    public String getDescripcionBreve() {
        return getNombrePreparacion() + " (Preparación: " + getTiempoPreparacion() + "s)";
    }
}