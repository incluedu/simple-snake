package net.lustenauer.snake.screen.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.lustenauer.snake.config.GameConfig;
import net.lustenauer.snake.entity.BodyPart;
import net.lustenauer.snake.entity.Coin;
import net.lustenauer.snake.entity.Snake;
import net.lustenauer.snake.entity.SnakeHead;
import net.lustenauer.snake.util.GdxUtils;
import net.lustenauer.snake.util.ViewportUtils;
import net.lustenauer.snake.util.debug.DebugCameraController;

/**
 * Created by Patric Hollenstein on 03.02.18.
 *
 * @author Patric Hollenstein
 */
public class GameRenderer implements Disposable {

    /*
     * ATTRIBUTES
     */
    private final GameController controller;

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;

    private DebugCameraController debugCameraController;


    /*
     * CONSTRUCTORS
     */

    public GameRenderer(GameController controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        debugCameraController = new DebugCameraController();
        debugCameraController.setStartPosition(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y);
    }

    /*
     * PUBLIC METHODES
     */
    public void render(float delta) {
        debugCameraController.handleDebugInput(delta);
        debugCameraController.applyTo(camera);
        GdxUtils.clearScreen();

        renderDebug();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
        ViewportUtils.debugPixelsPerUnit(viewport);
    }


    @Override
    public void dispose() {
        renderer.dispose();
    }


    /*
     * PRIVATE METHODES
     */
    private void renderDebug() {
        ViewportUtils.drawGrid(viewport, renderer);

        viewport.apply();
        Color oldColor = renderer.getColor().cpy();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);

        drawDebug();

        renderer.end();
        renderer.setColor(oldColor);
    }

    private void drawDebug() {
        renderer.setColor(Color.GREEN);
        Snake snake = controller.getSnake();
        SnakeHead snakeHead = snake.getHead();
        Rectangle headBounds = snakeHead.getBounds();
        renderer.rect(headBounds.x, headBounds.y, headBounds.width, headBounds.height);

        for (BodyPart bodyPart : snake.getBodyParts()) {
            Rectangle bodyPartBounds = bodyPart.getBounds();
            renderer.rect(bodyPartBounds.x, bodyPartBounds.y, bodyPartBounds.width, bodyPartBounds.height);
        }

        renderer.setColor(Color.BLUE);
        Coin coin = controller.getCoin();
        Rectangle coinBounds = coin.getBounds();
        renderer.rect(coinBounds.x, coinBounds.y, coinBounds.width, coinBounds.height);
    }
}
