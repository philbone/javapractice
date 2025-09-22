 package test;
 


import calculadorasimple.parser.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la calculadora con soporte de operadores,
 * funciones y constantes.
 */
public class CalculadoraTest {

    private double evaluar(String expr) {
        ShuntingYardParser parser = new ShuntingYardParser();
        List<Token> rpn = parser.toRPN(expr);
        RpnEvaluator evaluator = new RpnEvaluator();
        return evaluator.evaluate(rpn);
    }

    @Test
    public void testBasicoNumeros() {
        assertEquals(3.0, evaluar("1+2"), 1e-9);
        assertEquals(7.0, evaluar("10-3"), 1e-9);
        assertEquals(20.0, evaluar("4*5"), 1e-9);
        assertEquals(2.5, evaluar("5/2"), 1e-9);
    }

    @Test
    public void testPrecedencia() {
        assertEquals(11.0, evaluar("3+4*2"), 1e-9);         // multiplicación antes que suma
        assertEquals(14.0, evaluar("(3+4)*2"), 1e-9);       // paréntesis primero
        assertEquals(3.5, evaluar("3+4*2/(1-5)^2"), 1e-9);  // ejemplo clásico de shunting-yard
    }

    @Test
    public void testPotencia() {
        assertEquals(8.0, evaluar("2^3"), 1e-9);
        assertEquals(512.0, evaluar("2^3^2"), 1e-9); // asociatividad derecha
    }

    @Test
    public void testConstantes() {
        assertEquals(Math.PI, evaluar("pi"), 1e-9);
        assertEquals(Math.E, evaluar("e"), 1e-9);
    }

    @Test
    public void testFunciones() {
        assertEquals(1.0, evaluar("sin(pi/2)"), 1e-9);
        assertEquals(1.0, evaluar("cos(0)"), 1e-9);
        assertEquals(1.0, evaluar("log(e)"), 1e-9);
    }

    @Test
    public void testRaizCuadrada() {
        assertEquals(3.0, evaluar("√9"), 1e-9);
        assertEquals(5.0, evaluar("√(9+16)"), 1e-9);
        assertEquals(19.0, evaluar("√9+16"), 1e-9);
        assertEquals(6.0, evaluar("√9*2"), 1e-9);
        assertEquals(9.0, evaluar("√9^2"), 1e-9); // precedencia √ sobre ^
    }

    @Test
    public void testCombinadas() {
        assertEquals(Math.sqrt(2), evaluar("√(sin(pi/2)+cos(0))"), 1e-9);
        assertEquals(5.0, evaluar("√4+√9"), 1e-9);
        assertEquals(6.0, evaluar("√(4*9)"), 1e-9);
        assertEquals(2.0, evaluar("√16/2"), 1e-9);
        assertEquals(0.5, evaluar("2/√16"), 1e-9);
    }    
}
