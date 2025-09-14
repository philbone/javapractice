package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para capuccino.
 * Simula un circuito automatizado con texturizado de leche.
 */
public class PreparacionCapuccino extends PreparacionBase
{
    /**
    * {@inheritDoc}
    */
    public String getNombrePreparacion(){
        return "Capuccino";
    }
    
    /**
    * {@inheritDoc}
    */
    public int getTiempoPreparacion() {
        return 12; // 12 segundos para capuccino
    }
    
    /**
    * {@inheritDoc}
    */
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
}