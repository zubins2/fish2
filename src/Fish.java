import java.awt.*;

public class Fish extends Sprite {

    private String fishName;
    private int observeDistanceX;
    private int observeDistanceY;
    private Rectangle observingRectangle;


    public Fish(String n, String name){
        super(n);
        fishName = name;
    }
    public Fish(int x, int y, String n, String name){
        super(x,y,n);
        fishName = name;
    }
    public Fish(int x, int y, String n, String name, int o, int od){
        super(x,y,n);
        fishName = name;
        observeDistanceX = o;
        observeDistanceY = od;
        observingRectangle = new Rectangle(x - (int)(o/2), y - (int)(od/2), o, o);
    }

    public void setObservingRectangle(){
        observingRectangle = new Rectangle(getSpriteX() - (int)(observeDistanceX/2), getSpriteY() - (int)(observeDistanceY/2), observeDistanceX, observeDistanceY);
    }

    public String getFishName(){return fishName;}

    @Override
    public void incrementSpriteX(int x){
        setSpriteX(getSpriteX()+x);
        setObservingRectangle();
    }

    public void incrementSpriteY(int y){
        setSpriteY(getSpriteY()+y);
        setObservingRectangle();
    }

}