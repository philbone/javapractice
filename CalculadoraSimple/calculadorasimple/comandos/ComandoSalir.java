package calculadorasimple.comandos;

import terminalmenu.Comando;

public class ComandoSalir implements Comando
{

    @Override
    public void ejecutar() {
        System.out.println("\n¡Hasta pronto!");
        System.exit(0);
    }
}
