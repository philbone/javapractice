package player.comandos;

import player.MusicPlayer;

public class PlayComando implements terminalmenu.Comando
{
    private MusicPlayer player;
    
    public PlayComando(MusicPlayer player){
        this.player = player;
    }
    
    public void ejecutar(){
        player.play();
    }
}