package net.lustenauer.snake.screen.game;

import com.badlogic.gdx.utils.Logger;
import net.lustenauer.snake.entity.SnakeHead;

/**
 * Created by Patric Hollenstein on 03.02.18.
 *
 * @author Patric Hollenstein
 */
public class GameController {

    /*
     * constants
     */
    private static final Logger log = new Logger(GameController.class.getName(), Logger.DEBUG);

    /*
     * ATTRIBUTES
     */
    private SnakeHead snakeHead;

    /*
     * CONSTRUCTORS
     */

    public GameController() {
        snakeHead = new SnakeHead();
    }

    /*
     * PUBLIC METHODES
     */
    public void update(float delata) {

    }

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }
}
