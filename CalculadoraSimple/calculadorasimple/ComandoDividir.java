package calculadorasimple;

import java.util.List;

public class ComandoDividir extends OperacionNOperandos {
    @Override
    public double operar(List<Double> operandos) {
        if (operandos.isEmpty()) return 0;
        double resultado = operandos.get(0);
        for (int i = 1; i < operandos.size(); i++) {
            double divisor = operandos.get(i);
            if (divisor == 0) {
                throw new ArithmeticException("División por cero no permitida.");
            }
            resultado /= divisor;
        }
        return resultado;
    }
}
