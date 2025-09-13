package ingredientedecorator;

/**
 * Ingrediente extra específico: Leche.
 * Añade leche a la bebida con un costo adicional.
 */
public class LecheExtra extends IngredienteExtra
{
    /**
     * Constructor para crear ingrediente extra de leche.
     * @param bebida la bebida a decorar con leche
     */
     public LecheExtra(Bebida bebida) {
        super(bebida, 500, "Leche");
    }
}