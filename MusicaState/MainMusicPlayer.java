import player.MusicPlayer;
import terminalmenu.Menu;
import terminalmenu.MenuBuilder;

public class MainMusicPlayer
{
    private static Menu menu;
    
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        
        menu = new MenuBuilder("🎶 Reproductor de Música", false)
            .opcion( "▶️ Play", () -> player.play() )
            .opcion( "⏸️Pause", () -> player.pause() )
            .opcion( "⏹️ Stop", () -> player.stop() )
            .opcion("🚪 Salir", () -> {
                    System.out.println("\nSaliendo del reproductor...");
                    System.exit(0);
                })
            .build();
        menu.mostrar();
    }
}