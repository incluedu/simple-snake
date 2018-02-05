package net.lustenauer.snake.entity;

/**
 * Created by Patric Hollenstein on 05.02.18.
 *
 * @author Patric Hollenstein
 */
public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    public boolean isUp() {
        return this == UP;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isDown() {
        return this == DOWN;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

}
