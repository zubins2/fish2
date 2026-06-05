import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Sprite {
    private int spriteX;
    private int spriteY;
    private String spriteSource;
    private BufferedImage image;
    private ArrayList<String> images;
    private int currentImage;

    public Sprite(String source) {
        spriteX = 0; spriteY = 0;
        spriteSource = source;
        try {
            image = ImageIO.read(new File(source));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        images = new ArrayList<>();
    }

    public Sprite(int x, int y, String source) {
        spriteX = x; spriteY = y;
        spriteSource = source;
        try {
            image = ImageIO.read(new File(source));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        images = new ArrayList<>();
        images.add(source);
        currentImage = 0;
    }

    // add sources so that: e0 is right, e1 is left, e2 is up, e3 is down.
    public void addSource(String newSource){
        images.add(newSource);
    }

    //e0 is right, e1 is left, e2 is up, e3 is down
    public void switchSources(int i) {
        if(i != currentImage) {
            try {
                image = ImageIO.read(new File(images.get(i)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            currentImage = i;
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
