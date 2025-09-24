package player;

/**
 * Estado: Reproduciendo música.
 */
public class PlayingState implements State
{
    @Override
    public void play(MusicPlayer player) {
        System.out.println("Ya estás reproduciendo música 🎵");
    }

    @Override
    public void pause(MusicPlayer player) {
        System.out.println("Pausando la música ⏸️");
        player.setState(new PausedState());
    }

    @Override
    public void stop(MusicPlayer player) {
        System.out.println("Deteniendo la música ⏹️");
        player.setState(new StoppedState());
    }
}