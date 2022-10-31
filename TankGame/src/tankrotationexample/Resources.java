package tankrotationexample;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resources {

   private static Map<String, BufferedImage> sprites = new HashMap<>(); // better than having list of variable
   private static Map<String, Clip> sounds = new HashMap<>(); // for the sounds
   private static Map<String, List<BufferedImage>> animations = new HashMap<>(); // list of images for animations

    private static void initSprites() {
       // Resources.sprites.put("tank1", );  // <---- example resource vid (40:00)
    }

    private static void initSounds(){

    }

    private static void initAnimations(){

    }

    public static void loadResources() {
        initSprites();
        initSounds();
        initAnimations();
    }

    public static BufferedImage getSprite(String key){
        return Resources.sprites.get(key);
    }

}
