/**
 * Ingrediente extra específico: Crema.
 * Añade crema a la bebida con un costo adicional.
 */
public class CremaExtra extends IngredienteExtra
{
    /**
     * Constructor para crear ingrediente extra de crema.
     * @param bebida la bebida a decorar con crema
     */
    public CremaExtra(Bebida bebida) {
        super(bebida, 600, "Crema");
    }
}