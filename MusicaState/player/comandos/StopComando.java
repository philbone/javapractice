package player.comandos;

import player.MusicPlayer;

public class StopComando implements terminalmenu.Comando
{
    private MusicPlayer player;
    
    public StopComando(MusicPlayer player){
        this.player = player;
    }
    
    public void ejecutar(){
        player.stop();
    }
}