package tankrotationexample.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUp extends GameObject{
    float x,y;
    BufferedImage img;

    public PowerUp(float x, float y, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.hitbox = new Rectangle((int)x, (int)y, this.img.getWidth(),this.img.getHeight());
    }

    public void drawImage(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(this.img,(int)x,(int)y,null);
        g2d.setColor(Color.MAGENTA);
        g2d.drawRect((int)x,(int)y,this.img.getWidth(), this.img.getHeight());

    }
}
