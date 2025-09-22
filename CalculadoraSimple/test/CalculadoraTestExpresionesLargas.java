package test;

import calculadorasimple.parser.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Pruebas de expresiones complejas y largas para validar robustez
 * de la calculadora.
 */
public class CalculadoraTestExpresionesLargas {

    private double evaluar(String expr) {
        ShuntingYardParser parser = new ShuntingYardParser();
        List<Token> rpn = parser.toRPN(expr);
        RpnEvaluator evaluator = new RpnEvaluator();
        return evaluator.evaluate(rpn);
    }

    @Test
    public void testExpresionesComplejas() {
        // Combinación de suma, multiplicación y potencias
        assertEquals(45.0, evaluar("3+4*2^3+5*2"), 1e-9); 
        // = 3 + (4*8) + 10 = 45

        // Mezcla de sin, cos, log y constantes
        assertEquals(2.0, evaluar("sin(pi/2)+cos(0)"), 1e-9);
        assertEquals(1.0, evaluar("log(e)"), 1e-9);
        assertEquals(Math.sqrt(2), evaluar("√(sin(pi/2)+cos(0))"), 1e-9);
    }

    @Test
    public void testExpresionesLargas() {
        // Expresión más larga con paréntesis y potencias
        assertEquals(15.0, evaluar("((2+3)*(4-1))^(1)"), 1e-9);
        // = (5*3)^1 = 15^1 = 15

        // Expresión anidada con varias funciones
        double esperado = Math.sin(Math.PI/2) + Math.cos(0) + Math.log(Math.E) + Math.sqrt(16);
        assertEquals(esperado, evaluar("sin(pi/2)+cos(0)+log(e)+√16"), 1e-9);

        // Expresión muy larga con mezcla de operadores
        //double esperado2 = 3 + 4 * 2 / (1 - 5)^2 + Math.sin(Math.PI/2) + Math.sqrt(9) * 2;
        double esperado2 = 3 + 4 * 2 / Math.pow((1 - 5), 2) + Math.sin(Math.PI/2) + Math.sqrt(9) * 2;
        assertEquals(3.0 + 4.0 * 2.0 / Math.pow((1.0 - 5.0), 2.0) + Math.sin(Math.PI/2) + Math.sqrt(9) * 2.0,
                     evaluar("3+4*2/(1-5)^2+sin(pi/2)+√9*2"), 1e-9);
    }
}