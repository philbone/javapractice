package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para capuccino.
 * Simula un circuito automatizado con texturizado de leche.
 */
public class PreparacionCapuccino implements PreparacionStrategy
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
        return "Capuccino";
    }
    
    public int getTiempoPreparacion() {
        return 12; // 12 segundos para capuccino
    }
    
    public String[] getPasosPreparacion() {
        return new String[] {
            "Preparando espresso base",
            "Enfriando vaporizador a 60°C",
            "Texturizando leche entera",
            "Creando microespuma perfecta",
            "Vertiendo leche sobre espresso",
            "Formando corazón en la superficie",
            "Espolvoreando cacao en polvo",
            "Nivelando temperatura a 65°C"
        };
    }
    
    public String getDescripcionBreve() {
        return getNombrePreparacion() + " (Preparación: " + getTiempoPreparacion() + "s)";
    }   
    
}