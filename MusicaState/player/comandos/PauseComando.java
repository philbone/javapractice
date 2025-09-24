package player.comandos;

import player.MusicPlayer;

public class PauseComando implements terminalmenu.Comando
{
    private MusicPlayer player;
    
    public PauseComando(MusicPlayer player){
        this.player = player;
    }
    
    public void ejecutar(){
        player.pause();
    }
}