/**
 * Ingrediente extra específico: Chocolate.
 * Añade chocolate a la bebida con un costo adicional.
 */
class ChocolateExtra extends IngredienteExtra
{
    /**
     * Constructor para crear ingrediente extra de chocolate.
     * @param bebida la bebida a decorar con chocolate
     */
    public ChocolateExtra(Bebida bebida) {
        super(bebida, 700, "Chocolate");
    }
}