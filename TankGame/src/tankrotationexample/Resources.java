package tankrotationexample;

import tankrotationexample.game.GameWorld;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Resources {

    private static Map<String, BufferedImage> sprites = new HashMap<>(); // better than having list of variable
    private static Map<String, Clip> sounds = new HashMap<>(); // for the sounds
    private static Map<String, List<BufferedImage>> animations = new HashMap<>(); // list of images for animations

    private static void initSprites() {
        try {
            Resources.sprites.put("tank1", ImageIO.read(GameWorld.class.getClassLoader().getResource("tank1.png")));
            Resources.sprites.put("tank2", ImageIO.read(GameWorld.class.getClassLoader().getResource("tank2.png")));
            Resources.sprites.put("bullet", ImageIO.read(GameWorld.class.getClassLoader().getResource("bullet.png")));
            //Resources.sprites.put("rocket1", ImageIO.read(GameWorld.class.getClassLoader().getResource("rocket1.png")));

            Resources.sprites.put("menu",ImageIO.read(Resources.class.getClassLoader().getResource("title.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initSounds() {

    }

    private static void initAnimations() {

    }

    public static void loadResources() {
        initSprites();
        initSounds();
        initAnimations();
    }

    public static BufferedImage getSprite(String key) {
        return Resources.sprites.get(key);
    }

}
