package test;

import calculadorasimple.parser.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para operadores unarios (+ y -) en la calculadora.
 */
public class CalculadoraTestUnarios {

    private double evaluar(String expr) {
        ShuntingYardParser parser = new ShuntingYardParser();
        List<Token> rpn = parser.toRPN(expr);
        RpnEvaluator evaluator = new RpnEvaluator();
        return evaluator.evaluate(rpn);
    }

    @Test
    public void testNumerosConSignoInicial() {
        assertEquals(-3.0, evaluar("-3"), 1e-9);
        assertEquals(3.0, evaluar("+3"), 1e-9);
        assertEquals(1.0, evaluar("-3+4"), 1e-9);
        assertEquals(7.0, evaluar("+3+4"), 1e-9);
    }

    @Test
    public void testSignoDentroDeExpresion() {
        assertEquals(-6.0, evaluar("2*-3"), 1e-9);
        assertEquals(6.0, evaluar("2*+3"), 1e-9);
        assertEquals(1.0, evaluar("(2-5)+4"), 1e-9);
        assertEquals(9.0, evaluar("(-3)^2"), 1e-9); // (-3)^2 = 9
    }

    @Test
    public void testAnidacionesDeSignos() {
        assertEquals(5.0, evaluar("--5"), 1e-9);   // neg(neg(5)) = 5
        assertEquals(-5.0, evaluar("---5"), 1e-9); // neg(neg(neg(5))) = -5
        assertEquals(5.0, evaluar("+-5+10"), 1e-9); // (+(-5))+10 = 5
    }

    @Test
    public void testCombinadoConFunciones() {
        assertEquals(-1.0, evaluar("-sin(pi/2)"), 1e-9); // -1
        assertEquals(1.0, evaluar("+cos(0)"), 1e-9);     // +1
    }

    @Test
    public void testErroresEsperados() {
        assertThrows(IllegalArgumentException.class, () -> evaluar("-"));
        assertThrows(IllegalArgumentException.class, () -> evaluar("+-"));
    }
}