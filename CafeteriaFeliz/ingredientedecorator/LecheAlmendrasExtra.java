package ingredientedecorator;

/**
 * Ingrediente extra específico: Leche de Almendras.
 * Añade leche de almendras a la bebida con un costo adicional.
 */
public class LecheAlmendrasExtra extends IngredienteExtra
{
    /**
     * Constructor para crear ingrediente extra de leche de almendras.
     * @param bebida la bebida a decorar con leche de almendras
     */
    public LecheAlmendrasExtra(Bebida bebida) {
        super(bebida, 800, "Leche de Almendras");
    }
}