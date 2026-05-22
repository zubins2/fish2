import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class Fish {

    private File fishDirectory;
    private BufferedImage image;
    private String fishName;
    private int fishValue;

    public Fish (String name, int value, String directory){
        fishName = name;
        fishValue = value;
        fishDirectory = new File(directory);
        try {
            image = ImageIO.read(fishDirectory);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BufferedImage getImage(){
        return image;
    }
    public void changeImage(String fileName){
        setFishDirectory(fileName);
        try {
            image = ImageIO.read(fishDirectory);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public File getFishDirectory(){
        return fishDirectory;
    }
    public void setFishDirectory(String fileName){
        fishDirectory = new File(fileName);
    }

    public String getFishName(){
        return fishName;
    }
    public void setFishName(String name){
        fishName = name;
    }

    public int getFishValue(){
        return fishValue;
    }
    public void setFishValue(int val){
        fishValue = val;
    }

}
