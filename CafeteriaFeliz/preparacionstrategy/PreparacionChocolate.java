package preparacionstrategy;

/**
 * Implementación de la estrategia de preparación para chocolate caliente.
 */
public class PreparacionChocolate extends PreparacionBase
{
    /**
    * {@inheritDoc}
    */
    public String getNombrePreparacion(){
        return "Chocolate Caliente";
    }
    
    /**
    * {@inheritDoc}
    */
    public int getTiempoPreparacion() {
        return 4;
    }
    
    /**
    * {@inheritDoc}
    */
    public String[] getPasosPreparacion() {
        return new String[] {
            "Seleccionando chocolate negro de alta calidad",
            "Picando chocolate en trozos pequeños",
            "Calentando leche a 70°C sin hervir",
            "Derritiendo chocolate al baño María",
            "Incorporando leche caliente lentamente",
            "Batiendo hasta obtener textura sedosa",
            "Espumando la superficie cremosa",
            "Decorando con virutas de chocolate"
        };
    }
}