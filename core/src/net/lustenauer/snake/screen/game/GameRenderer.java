package net.lustenauer.snake.screen.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.lustenauer.snake.config.GameConfig;
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

        //test code
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeRenderer.ShapeType.Line);

        renderer.circle(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y, 4, 30);

        renderer.end();

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
    private void renderDebug(){
        ViewportUtils.drawGrid(viewport,renderer);
    }
}
