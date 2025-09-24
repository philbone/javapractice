package player;

/**
 * Estado: Reproduciendo música.
 */
public class PlayingState implements State
{
    @Override
    public void play(MusicPlayer player) {
        System.out.println("\nYa estás reproduciendo música 🎵");
    }

    @Override
    public void pause(MusicPlayer player) {
        System.out.println("\nPausando la música ⏸️");
        player.setState(new PausedState());
    }

    @Override
    public void stop(MusicPlayer player) {
        System.out.println("\nDeteniendo la música ⏹️");
        player.setState(new StoppedState());
    }
}