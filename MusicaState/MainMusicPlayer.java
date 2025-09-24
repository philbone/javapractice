import player.MusicPlayer;
import player.comandos.*;
import terminalmenu.Menu;
import terminalmenu.MenuBuilder;

public class MainMusicPlayer
{
    private static Menu menu;
    
    // ejemplo usando lambdas
    public static void lambda_main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        
        menu = new MenuBuilder("🎶 Reproductor de Música 🎶", false)
            .opcion( "Play", () -> player.play() )
            .opcion( "Pause", () -> player.pause() )
            .opcion( "Stop", () -> player.stop() )
            .opcion( "Salir", () -> {
                    System.out.println("\nSaliendo del reproductor...");
                    System.exit(0);
                })
            .build();
        menu.mostrar();
    }
    
    // ejemplo usando la interface Comando
    public static void command_main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        
        menu = new MenuBuilder("🎶🎶 Reproductor de Música 🎶🎶", false)
            .opcion( "Play", new PlayComando(player) )
            .opcion( "Pause", new PauseComando(player) )
            .opcion( "Stop", new StopComando(player) )
            .opcion( "Salir", new ExitComando() )
            .build();
        menu.mostrar();
    }
}