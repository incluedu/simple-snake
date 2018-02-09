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
    private int score;
    private int highScore;
    private int displayScore;
    private int displayHighScore;

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

    public int getDisplayScore() {
        return displayScore;
    }

    public int getDisplayHighScore() {
        return displayHighScore;
    }

    public void incrementScore(int amount) {
        score += amount;

        if (score >= highScore) {
            highScore = score;
        }
    }

    public void reset() {
        setPlaying();
        score = 0;
        displayScore = 0;
    }

    public void updateDisplayScore(float delta) {
        if (displayScore < score) {
            displayScore = Math.min(score, displayScore + (int) (100 * delta));
        }

        if (displayHighScore < highScore) {
            displayHighScore = Math.min(highScore, displayHighScore + (int) (100 * delta));
        }
    }
}
