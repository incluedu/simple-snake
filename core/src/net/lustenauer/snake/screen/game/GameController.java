package net.lustenauer.snake.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Logger;
import net.lustenauer.snake.config.GameConfig;
import net.lustenauer.snake.entity.Direction;
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
    private float timer;

    /*
     * CONSTRUCTORS
     */

    public GameController() {
        snakeHead = new SnakeHead();
    }

    /*
     * PUBLIC METHODES
     */
    public void update(float delta) {
        queryInput();

        timer += delta;
        if (timer >= GameConfig.MOVE_TIME) {
            timer = 0;
            snakeHead.move();

            checkOutOfBounds();
        }
    }


    public SnakeHead getSnakeHead() {
        return snakeHead;
    }

    /*
     * PRIVATE METHODES
     */
    private void queryInput() {
        boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if (leftPressed) {
            snakeHead.setDirection(Direction.LEFT);
        } else if (rightPressed) {
            snakeHead.setDirection(Direction.RIGHT);
        } else if (upPressed) {
            snakeHead.setDirection(Direction.UP);
        } else if (downPressed) {
            getSnakeHead().setDirection(Direction.DOWN);
        }
    }

    private void checkOutOfBounds() {
        // check x bounds (left, right)
        if (snakeHead.getX() > GameConfig.WORLD_WIDTH) {
            snakeHead.setX(0);
        } else if (snakeHead.getX() < 0) {
            snakeHead.setX(GameConfig.WORLD_WIDTH - GameConfig.SNAKE_SPEED);
        }

        // check y bounds ()up, down)
        if (snakeHead.getY() >= GameConfig.WORLD_HEIGHT) {
            snakeHead.setY(0);
        } else if (snakeHead.getY() < 0) {
            snakeHead.setY(GameConfig.WORLD_HEIGHT - GameConfig.SNAKE_SPEED);
        }
    }

}
