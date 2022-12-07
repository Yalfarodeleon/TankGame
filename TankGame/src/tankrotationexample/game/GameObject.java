package tankrotationexample.game;

import tankrotationexample.Resources;

import java.awt.*;
import java.util.List;

public abstract class GameObject {



    public static GameObject gameObjectFactory(String type, float x, float y){
        return switch (type){
            case "2" -> new Breakable(x,y, Resources.getSprite("break"));
            case "3", "9" -> new Wall(x,y, Resources.getSprite("unbreak"));
            case "4" -> new Speed(x,y, Resources.getSprite("speed"));
            case "5" -> new Health(x,y, Resources.getSprite("health"));
            case "6" -> new Shield(x,y, Resources.getSprite("shield"));
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    public abstract void drawImage(Graphics g);

}



//switch (objectType){
//        case "0" -> {
//
//        }
//        case "2" -> {
//        walls.add(new Breakable(j*30, i*30, Resources.getSprite("break")));
//        }
//        case "3","9" -> {
//        walls.add(new Wall(j*30, i*30, Resources.getSprite("unbreak")));
//
//        }
//        case "4" -> { // health power up
//
//        }
//        case "5" -> { // speed
//
//        }
//        case "6" -> { // shield
//
//        }
//        }