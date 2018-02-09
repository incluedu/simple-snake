package net.lustenauer.snake.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Patric Hollenstein on 09.02.18.
 *
 * @author Patric Hollenstein
 */
public class AssetDescriptors {

    /*
     * CONSTANTS
     */
    public static final AssetDescriptor<BitmapFont> UI_FONT =
            new AssetDescriptor<BitmapFont>(AssetsPaths.UI_FONT, BitmapFont.class);

    /*
     * CONSTRUCTORS
     */
    private AssetDescriptors() {
    }
}
