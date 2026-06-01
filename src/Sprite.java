import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Sprite {
    private int spriteX;
    private int spriteY;
    private String spriteSource;
    private BufferedImage image;

    public Sprite(String source) {
        spriteX = 0; spriteY = 0;
        spriteSource = source;
        try {
            image = ImageIO.read(new File(source));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Sprite(int x, int y, String source) {
        spriteX = x; spriteY = y;
        spriteSource = source;
        try {
            image = ImageIO.read(new File(source));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getSpriteX(){return spriteX;}
    public void incrementSpriteX(int x){spriteX += x;}
    public void setSpriteX(int x){spriteX = x;}

    public int getSpriteY(){return spriteY;}
    public void incrementSpriteY(int y){spriteY += y;}
    public void setSpriteY(int y){spriteY = y;}

    public void setSpriteSource(String source){spriteSource = source;}
    public void setImage(String source) {
        setSpriteSource(source);
        try{
            image = ImageIO.read(new File(spriteSource));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BufferedImage getImage() {return image;}
    public String getSpriteSource() {return spriteSource;}
}
