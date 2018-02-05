package net.lustenauer.snake.entity;

import net.lustenauer.snake.config.GameConfig;

/**
 * Created by Patric Hollenstein on 04.02.18.
 *
 * @author Patric Hollenstein
 */
public class SnakeHead extends EntityBase {

    /*
     * ATTRIBUTES
     */
    private Direction direction = Direction.RIGHT;

    /*
     * CONSTRUCTORS
     */
    public SnakeHead() {
        setSize(GameConfig.SNAKE_SIZE, GameConfig.SNAKE_SIZE);
    }

    /*
     * PUBLIC METHODES
     */
    public void move() {
        if (direction.isRight()) {
            updateX(GameConfig.SNAKE_SPEED);
        } else if (direction.isLeft()) {
            updateX(-GameConfig.SNAKE_SPEED);
        } else if (direction.isUp()) {
            updateY(GameConfig.SNAKE_SPEED);
        } else if (direction.isDown()) {
            updateY(-GameConfig.SNAKE_SPEED);
        }
    }

    public void updateX(float amount) {
        x += amount;
        updateBounds();
    }

    public void updateY(float amount) {
        y += amount;
        updateBounds();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
