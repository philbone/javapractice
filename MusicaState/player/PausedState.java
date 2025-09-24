package player;

/**
 * Estado: Música pausada.
 */
public class PausedState implements State
{
    @Override
    public void play(MusicPlayer player) {
        System.out.println("Reanudando la música ▶️");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MusicPlayer player) {
        System.out.println("La música ya está en pausa ⏸️");
    }

    @Override
    public void stop(MusicPlayer player) {
        System.out.println("Deteniendo la música desde pausa ⏹️");
        player.setState(new StoppedState());
    }
}