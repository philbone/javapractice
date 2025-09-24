package player;

/**
 * Estado: Música detenida.
 */
public class StoppedState implements State
{
    @Override
    public void play(MusicPlayer player) {
        System.out.println("\nIniciando reproducción ▶️");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MusicPlayer player) {
        System.out.println("\nNo puedes pausar, la música está detenida ❌");
    }

    @Override
    public void stop(MusicPlayer player) {
        System.out.println("\nYa está detenida ⏹️");
    }
}