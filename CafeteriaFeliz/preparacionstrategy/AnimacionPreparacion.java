package preparacionstrategy;

public class AnimacionPreparacion
{    
    public static void mostrarAnimacion(String[] pasos, String nombreBebida, int tiempoTotal) {
        System.out.println("⚡ Preparando " + nombreBebida + " (" + tiempoTotal + "s)...");
        esperar(1500); // Espera 1.5 segundos
        
        for (int i = 0; i < pasos.length; i++) {
            System.out.println("   → " + pasos[i]);            
            // Diferentes tiempos de espera según el paso
            int tiempoEspera = 800; // tiempo base
            if (i == 4) { // Paso de infusionar
                tiempoEspera = 3000; // 3 segundos para variar
            } else if (i == 3 || i == 5) { // Pasos alternativos
                tiempoEspera = 1200;
            }            
            esperar(tiempoEspera);
        }
    }
    
    private static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("X Preparación interrumpida!");
        }
    }
}