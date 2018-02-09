package net.lustenauer.snake.screen.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import net.lustenauer.snake.SimpleSnakeGame;

/**
 * Created by Patric Hollenstein on 03.02.18.
 *
 * @author Patric Hollenstein
 */
public class GameScreen extends ScreenAdapter {

    /*
     * ATTRIBUTES
     */
    private final SimpleSnakeGame game;
    private final AssetManager assetManager;

    private GameRenderer renderer;
    private GameController controller;


    /*
     * CONSTRUCTORS
     */
    public GameScreen(SimpleSnakeGame game) {
        this.game = game;
        this.assetManager = game.getAssetManager();
    }

    /*
     * PUBLIC METHODES
     */

    @Override
    public void show() {
        controller = new GameController();
        renderer = new GameRenderer(game.getBatch(), game.getAssetManager(), controller);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
