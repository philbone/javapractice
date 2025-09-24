package player.comandos;

import player.MusicPlayer;

public class ExitComando implements terminalmenu.Comando
{    
    public void ejecutar(){        
        System.out.println("\nSaliendo del reproductor...");
        System.exit(0);
    }
}