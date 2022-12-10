package tankrotationexample;

import tankrotationexample.game.GameWorld;
import tankrotationexample.game.Sound;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class Resources {

    private static final Map<String, BufferedImage> sprites = new HashMap<>(); // better than having list of variable
    private static final Map<String, Sound> sounds = new HashMap<>(); // for the sounds
    private static final Map<String, List<BufferedImage>> animations = new HashMap<>(); // list of images for animations

    private static BufferedImage loadSprite(String path) throws IOException {
        return ImageIO.read(Objects.
                requireNonNull(GameWorld
                        .class
                        .getClassLoader()
                        .getResource(path)));
    }

//    private static Sound loadSound(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//        AudioInputStream as = AudioSystem.getAudioInputStream(
//                Objects.requireNonNull(Resources.class.getClassLoader().getResource(path)));
//        Clip clip = null;
//        clip = AudioSystem.getClip();
//        clip.open(as);
//        Sound s = new Sound(clip);
//        //s.setVolumeOfClip(2f);
//        return s;
//    }


    private static void initSprites() {
        try {
            Resources.sprites.put("tank1", loadSprite("tank/tank1.png"));
            Resources.sprites.put("tank2", loadSprite("tank/tank2.png"));
            Resources.sprites.put("bullet", loadSprite("bullet/bullet.jpg"));
            Resources.sprites.put("rocket1", loadSprite("bullet/rocket1.png"));
            Resources.sprites.put("rocket2", loadSprite("bullet/rocket2.png"));
            Resources.sprites.put("floor", loadSprite("floor/Background.bmp"));
            Resources.sprites.put("break", loadSprite("walls/break1.jpg"));
            Resources.sprites.put("break2", loadSprite("walls/break2.jpg"));
            Resources.sprites.put("unbreak", loadSprite("walls/unbreak.jpg"));
            Resources.sprites.put("shield", loadSprite("powerups/shield.png"));
            Resources.sprites.put("speed", loadSprite("powerups/speed.png"));
            Resources.sprites.put("health", loadSprite("powerups/health.png"));
            Resources.sprites.put("menu", loadSprite("menu/title.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    private static void initSounds() {
        AudioInputStream audioStream;
        Clip c;
        Sound s;

        try {
            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/Music.mid")
            );
            c = AudioSystem.getClip();
            c.open(audioStream);
            s = new Sound(c);
            Resources.sounds.put("bg", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/pickup.wav")
            );
            c = AudioSystem.getClip();
            c.open(audioStream);
            s = new Sound(c);
            Resources.sounds.put("powerup", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/shotfiring.wav")
            );
            c = AudioSystem.getClip();
            c.open(audioStream);
            s = new Sound(c);
            Resources.sounds.put("shoot", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/shotexplosion.wav")
            );
            c = AudioSystem.getClip();
            c.open(audioStream);
            s = new Sound(c);
            Resources.sounds.put("bullethit", s);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e){
            e.printStackTrace();
        }
    }

    private static void initAnimations() {
        try {
            String base = "animations/bullet/expl_08_%04d.png";
            List<BufferedImage> temp = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                String fName = String.format(base, i);
                temp.add(loadSprite(fName));
            }
            Resources.animations.put("shoot", temp);
            base = "animations/nuke/expl_01_%04d.png";
            temp = new ArrayList<>();
            for (int i = 0; i < 24; i++) {
                String fName = String.format(base, i);
                temp.add(loadSprite(fName));
            }
            Resources.animations.put("collide", temp);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(-3);
        }
    }

    public static void loadResources() {
        initSprites();
        initSounds();
        initAnimations();
    }

    public static BufferedImage getSprite(String key) {
        if (!Resources.sprites.containsKey(key)) {
            System.out.println(key + " resource not found");
            System.exit(-2);
        }
        return Resources.sprites.get(key);
    }

    public static Sound getSound(String key) {
        if (!Resources.sounds.containsKey(key)) {
            System.out.println(key + " sound not found");
            System.exit(-2);
        }
        return Resources.sounds.get(key);
    }

    public static List<BufferedImage> getAnimation(String key) {
        if (!Resources.animations.containsKey(key)) {
            System.out.println(key + " sound not found");
            System.exit(-2);
        }
        return Resources.animations.get(key);
    }
}
