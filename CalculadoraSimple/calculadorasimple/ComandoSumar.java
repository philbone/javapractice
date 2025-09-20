package calculadorasimple;

import java.util.List;

public class ComandoSumar extends OperacionNOperandos
{    
    @Override    
    public double operar(List<Double> operandos) {
        return operandos.stream().mapToDouble(Double::doubleValue).sum();
    }
}