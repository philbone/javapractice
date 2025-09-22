package test;

import calculadorasimple.parser.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para raíces cuadradas con signo negativo delante (-√).
 */
public class CalculadoraTestRaizNegativa
{

    private double evaluar(String expr) {
        ShuntingYardParser parser = new ShuntingYardParser();
        List<Token> rpn = parser.toRPN(expr);
        RpnEvaluator evaluator = new RpnEvaluator();
        return evaluator.evaluate(rpn);
    }

    @Test
    public void testRaizNegativaSimple() {
        assertEquals(-3.0, evaluar("-√9"), 1e-9);  // -(√9) = -3
        assertEquals(-2.0, evaluar("-√4"), 1e-9);  // -(√4) = -2
    }

    @Test
    public void testRaizNegativaCombinada() {
        assertEquals(-5.0, evaluar("-√25"), 1e-9);   // -(√25) = -5
        assertEquals(-19.0, evaluar("-√9-16"), 1e-9); // (-(√9)) - 16 = -3-16 = -19
    }

    @Test
    public void testRaizNegativaConMultiplicacion() {
        assertEquals(-6.0, evaluar("-√9*2"), 1e-9);  // (-(√9))*2 = -3*2 = -6
        assertEquals(-6.0, evaluar("2*-√9"), 1e-9);  // 2 * (-(√9)) = 2*-3 = -6
    }

    @Test
    public void testRaizNegativaConPotencia() {
        assertEquals(9.0, evaluar("(-√9)^2"), 1e-9);   // (-3)^2 = 9
        assertEquals(-9.0, evaluar("-(√9)^2"), 1e-9); // -(3^2) = -9
    }

    @Test
    public void testAnidacionConSigno() {
        assertEquals(1.0, evaluar("(-√16)/(-√16)"), 1e-9); // (-4)/(-4)=1
        assertEquals(-2.0, evaluar("-√(√16)"), 1e-9);      // -(√(4))= -(2)= -2
    }
}