package calculadorasimple;

import java.util.List;

public class ComandoMultiplicar extends OperacionNOperandos
{
    @Override
    public double operar(List<Double> operandos) {
        return operandos.stream().reduce(1.0, (a, b) -> a * b);
    }    
}
