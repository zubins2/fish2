public class Player extends Sprite {
    private boolean[] keyboard;

    public Player(int x, int y, String n){
        super(x,y,n);
        keyboard = new boolean[128];
    }

    public boolean getKeyboard(int i){
        return keyboard[i];
    }
    public void toggleKeyboard(int i){
        keyboard[i] = !keyboard[i];
    }


}
