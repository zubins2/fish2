public class Fish extends Sprite {

    private String fishName;

    public Fish(String n, String name){
        super(n);
        fishName = name;
    }
    public Fish(int x, int y, String n, String name){
        super(x,y,n);
        fishName = name;
    }

    public String getFishName(){return fishName;}

}