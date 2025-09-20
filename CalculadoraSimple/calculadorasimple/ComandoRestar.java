package calculadorasimple;

import java.util.List;

public class ComandoRestar extends OperacionNOperandos
{
    @Override
    public double operar(List<Double> operandos) {
        if ( operandos.isEmpty() ) return 0;
        double resultado = operandos.get(0);
        for (int i = 1; i < operandos.size(); i++) {
            resultado -= operandos.get(i);
        }
        return resultado;
    }
}