package calculadorasimple.comandos;

import terminalmenu.Comando;
import calculadorasimple.parser.*;

import java.util.List;
import java.util.Scanner;

public class ComandoResolverExpresion implements Comando
{

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa una expresión (ej: 3+4*2/(1-5)): ");
        String input = sc.nextLine().trim();

        try {
            // 1. Tokenizar
            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = tokenizer.tokenize();

            // 2. Convertir a RPN
            ShuntingYardParser parser = new ShuntingYardParser();
            List<Token> rpn = parser.toRPN(input); // o parser.toRPN(tokens) si tu firma lo requiere

            // 3. Evaluar
            RpnEvaluator evaluator = new RpnEvaluator();
            double resultado = evaluator.evaluate(rpn);

            System.out.println("\n" + input + " = " + resultado);

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
