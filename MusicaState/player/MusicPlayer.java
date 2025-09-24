package player;

/**
 * Clase principal que representa la máquina de música.
 * Mantiene el estado actual y delega el comportamiento a él.
 */
public class MusicPlayer {
    private State state;

    public MusicPlayer() {
        // Estado inicial: detenido
        state = new StoppedState();
    }

    public void setState(State state) {
        this.state = state;
    }

    // Métodos públicos delegados al estado
    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }
}