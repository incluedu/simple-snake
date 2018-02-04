package net.lustenauer.snake.entity;

import net.lustenauer.snake.config.GameConfig;

/**
 * Created by Patric Hollenstein on 04.02.18.
 *
 * @author Patric Hollenstein
 */
public class SnakeHead extends EntityBase {

    /*
     * CONSTRUCTORS
     */
    public SnakeHead() {
        setSize(GameConfig.SNAKE_SIZE, GameConfig.SNAKE_SIZE);
    }
}
