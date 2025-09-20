package calculadorasimple;

import java.util.List;
import terminalmenu.Comando;

public abstract class OperacionNOperandos implements Comando
{
    @Override
    public void ejecutar() {
        // Este método no hace nada aquí
        // La ejecución real vendrá desde el parser que pasará operandos
        throw new UnsupportedOperationException("Usar ejecutar(List<Double> operandos)");
    }

    public abstract double operar(List<Double> operandos);
}
