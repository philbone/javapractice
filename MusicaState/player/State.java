package player;

/**
 * Patrón State aplicado a una máquina de música.
 * 
 * El reproductor tiene tres estados:
 *  - Reproduciendo (Playing)
 *  - Pausado (Paused)
 *  - Detenido (Stopped)
 * 
 * Cada estado define cómo responder a las acciones:
 *  - play()
 *  - pause()
 *  - stop()
 *
 * El objetivo es que el comportamiento cambie dinámicamente
 * según el estado actual, evitando if/else anidados.
 */

interface State
{
    void play(MusicPlayer player);
    void pause(MusicPlayer player);
    void stop(MusicPlayer player);
}