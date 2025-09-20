package calculadorasimple.comandos;

import terminalmenu.Comando;
import calculadorasimple.parser.*;

import java.util.*;

public class ComandoResolverExpresion implements Comando
{

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa una expresión (ej: 3 + 5 * (2 - 1)): ");
        String input = sc.nextLine().trim();

        try {
            // 1. Tokenizar
            List<Token> tokens = Tokenizer.tokenize(input);

            // 2. Convertir a RPN con shunting-yard
            List<Token> rpn = ShuntingYardParser.toRPN(tokens);

            // 3. Evaluar la expresión en RPN
            double resultado = RpnEvaluator.eval(rpn);

            System.out.println("\n" + input + " = " + resultado);

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
