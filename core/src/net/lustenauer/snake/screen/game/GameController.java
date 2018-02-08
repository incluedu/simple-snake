package net.lustenauer.snake.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Logger;
import net.lustenauer.snake.config.GameConfig;
import net.lustenauer.snake.entity.*;

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
    private Snake snake;
    private float timer;

    private Coin coin;

    /*
     * CONSTRUCTORS
     */

    public GameController() {
        snake = new Snake();
        coin = new Coin();
    }

    /*
     * PUBLIC METHODES
     */
    public void update(float delta) {
        queryInput();
        queryDebugInput();

        timer += delta;
        if (timer >= GameConfig.MOVE_TIME) {
            timer = 0;
            snake.move();

            checkOutOfBounds();
            checkCollision();
        }

        spawnCoin();
    }

    public Snake getSnake() {
        return snake;
    }

    public Coin getCoin() {
        return coin;
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
            snake.setDirection(Direction.LEFT);
        } else if (rightPressed) {
            snake.setDirection(Direction.RIGHT);
        } else if (upPressed) {
            snake.setDirection(Direction.UP);
        } else if (downPressed) {
            getSnake().setDirection(Direction.DOWN);
        }
    }

    private void queryDebugInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.PLUS)) {
            snake.insertBodyPart();
        }
    }

    private void checkOutOfBounds() {
        SnakeHead head = snake.getHead();

        // check x bounds (left, right)
        if (head.getX() >= GameConfig.WORLD_WIDTH) {
            head.setX(0);
        } else if (head.getX() < 0) {
            head.setX(GameConfig.WORLD_WIDTH - GameConfig.SNAKE_SPEED);
        }

        // check y bounds ()up, down)
        if (head.getY() >= GameConfig.WORLD_HEIGHT) {
            head.setY(0);
        } else if (head.getY() < 0) {
            head.setY(GameConfig.WORLD_HEIGHT - GameConfig.SNAKE_SPEED);
        }
    }

    private void spawnCoin() {
        if (!coin.isAvailable()) {
            float coinX = (int) MathUtils.random(GameConfig.WORLD_WIDTH - GameConfig.COIN_SIZE);
            float coinY = (int) MathUtils.random(GameConfig.WORLD_HEIGHT - GameConfig.COIN_SIZE);
            coin.setAvailable(true);
            coin.setPosition(coinX, coinY);
        }
    }

    private void checkCollision() {
        // head <--> coin collision
        SnakeHead head = snake.getHead();
        Rectangle headBounds = head.getBounds();
        Rectangle coinBounds = coin.getBounds();

        boolean overlaps = Intersector.overlaps(headBounds, coinBounds);

        if (coin.isAvailable() && overlaps) {
            snake.insertBodyPart();
            coin.setAvailable(false);
        }

        // head <--> body parts collision
        for (BodyPart bodyPart : snake.getBodyParts()) {
            if (bodyPart.isJustAdded()) {
                bodyPart.setJustAdded(false);
                continue;
            }

            Rectangle bodyPartBounds = bodyPart.getBounds();
            if (Intersector.overlaps(headBounds, bodyPartBounds)) {
                log.debug("collision with bodyPart");
            }

        }

    }


}
