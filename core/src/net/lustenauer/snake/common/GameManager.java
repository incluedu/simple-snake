package net.lustenauer.snake.common;

/**
 * Created by Patric Hollenstein on 08.02.18.
 *
 * @author Patric Hollenstein
 */
public class GameManager {

    /*
     * CONSTANTS
     */
    public static final GameManager INSTANCE = new GameManager();

    /*
     * ATTRIBUTES
     */
    private GameState state = GameState.READY;

    /*
     * CONSTRUCTORS
     */
    private GameManager() {
    }

    /*
     * PUBLIC METHODES
     */
    public boolean isReady() {
        return state.isReady();
    }

    public boolean isPlaying() {
        return state.isPlaying();
    }

    public boolean isGameOver() {
        return state.isGameOver();
    }

    public void setPlaying() {
        state = GameState.PLAYING;
    }

    public void setGameOver() {
        state = GameState.GAME_OVER;
    }
}
