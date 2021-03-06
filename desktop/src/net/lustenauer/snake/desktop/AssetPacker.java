package net.lustenauer.snake.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 * Created by Patric Hollenstein on 10.02.18.
 *
 * @author Patric Hollenstein
 */
public class AssetPacker {


    private static final String RAW_ASSETS_PATH = "desktop/assets-raw";
    private static final String ASSETS_PATH = "android/assets";


    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();

        TexturePacker.process(settings,
                RAW_ASSETS_PATH + "/gameplay",
                ASSETS_PATH + "/gameplay",
                "gameplay"
        );

        TexturePacker.process(settings,
                RAW_ASSETS_PATH + "/ui",
                ASSETS_PATH + "/ui",
                "ui"
        );

    }
}
