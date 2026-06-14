import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import javax.swing.Timer;

public class DisplayPanel extends JPanel implements MouseListener, KeyListener, ActionListener {

    private int backgroundsIndexR;
    private int backgroundsIndexC;
    private BufferedImage[][] backgrounds;
    private Rectangle castleEntrance;

    private Fish fish1;
    private int fishLives;
    private ArrayList<BufferedImage> fishHearts;
    private boolean vulnerable;
    private int recoveryTime;
    private int currentRecovery;

    private Fish fish2;

    private Sprite hook1;
    private boolean hook1down;
    private Sprite hook2;
    private boolean hook2down;
    private Sprite hook3;
    private boolean hook3down;
    private Sprite hook4;
    private boolean hook4down;
    private Sprite key;
    private boolean isKey;

    private Timer timer;
    private boolean[] pressedKeys;

    public DisplayPanel() {
        backgroundsIndexR = 1;
        backgroundsIndexC = 1;
        pressedKeys = new boolean[128];
        timer = new Timer(10, this);

        castleEntrance = null;

        fish1 = new Fish(100, 300, "src/fish1.png", "fish1", 100, 80);
        fish1.addSource("src/fish1_2.png");
        fishLives = 3;
        fishHearts = new ArrayList<>();
        for(int i = 0; i < fishLives; i++){
            BufferedImage bi;
            try{
                bi = ImageIO.read(new File("src/fish_heart.png"));
                fishHearts.add(bi);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        vulnerable = true;
        recoveryTime = 1000;
        currentRecovery = 1000;

        fish2 = new Fish(700, 100, "src/fish2.png", "fish2", 165, 101);
        fish2.addSource("src/fish2_2.png");
        fish2.switchSources(1);

        hook1 = new Sprite(200, -400, "src/hook.png");
        hook1down = true;
        hook2 = new Sprite(330, -76, "src/hook.png");
        hook2down = true;
        hook3 = new Sprite(460, -248, "src/hook.png");
        hook3down = false;
        hook4 = new Sprite(590, -572, "src/hook.png");
        hook4down = false;
        key = new Sprite(745,230, "src/key_fish2.png");
        isKey = false;

        backgrounds = new BufferedImage[2][3];
        try{
            backgrounds[1][1] = ImageIO.read(new File("src/aquarium.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try{
            backgrounds[1][2] = ImageIO.read(new File("src/falling_hooks.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            backgrounds[1][0] = ImageIO.read(new File("src/castle - Copy.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            backgrounds[0][0] = ImageIO.read(new File("src/castle1_fish2.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            backgrounds[0][1] = ImageIO.read(new File("src/castle2_fish2.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            backgrounds[0][2] = ImageIO.read(new File("src/castle3_fish2.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgrounds[backgroundsIndexR][backgroundsIndexC], 0, 0, null);
        g.drawImage(fish1.getImage(), fish1.getSpriteX(), fish1.getSpriteY(), null);

        if(fishLives > 0){
            for(int i = 0; i < fishLives; i++){
                g.drawImage(fishHearts.get(i), 10 + (i*40), 10, null);
            }
        }
        if(backgroundsIndexR ==0){}
        if(backgroundsIndexR == 1){
            if(backgroundsIndexC == 0){}
            if(backgroundsIndexC == 1){
                g.drawImage(fish2.getImage(), fish2.getSpriteX(), fish2.getSpriteY(), null);
            }
            if(backgroundsIndexC == 2){
                g.drawImage(hook1.getImage(), hook1.getSpriteX(),hook1.getSpriteY(),null);
                g.drawImage(hook2.getImage(), hook2.getSpriteX(),hook2.getSpriteY(),null);
                g.drawImage(hook3.getImage(), hook3.getSpriteX(),hook3.getSpriteY(),null);
                g.drawImage(hook4.getImage(), hook4.getSpriteX(),hook4.getSpriteY(),null);
                if(!isKey) g.drawImage(key.getImage(), key.getSpriteX(), key.getSpriteY(), null);
            }
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    public void moveFish1(){
        if(pressedKeys[KeyEvent.VK_D]) {
            if(fish1.getSpriteX()<815) {
                fish1.incrementSpriteX(5);
            }
            fish1.switchSources(0);
        }

        if(pressedKeys[KeyEvent.VK_A]) {
            if(backgroundsIndexR == 1 && backgroundsIndexC == 0){
                if(fish1.getSpriteX()>450 || isKey) fish1.incrementSpriteX(-5);
            } else {
                if(fish1.getSpriteX()>-15){
                    fish1.incrementSpriteX(-5);
                }

            }
            fish1.switchSources(1);
        }

        if(pressedKeys[KeyEvent.VK_W]) {
            if(fish1.getSpriteY()>-5){
                fish1.incrementSpriteY(-5);
            }
        }

        if(pressedKeys[KeyEvent.VK_S]) {
            if(backgroundsIndexC == 1 && backgroundsIndexR == 1){
                if(fish1.getSpriteY()<545) fish1.incrementSpriteY(5);
            }
            else if(backgroundsIndexC == 0 && backgroundsIndexR == 1){
                if(fish1.getSpriteY()<545) fish1.incrementSpriteY(5);
            }
            else {
                if(fish1.getSpriteY()<655){
                    fish1.incrementSpriteY(5);
                }
            }
        }
        fish1.setObservingRectangle();
    }

    public boolean moveHook(Sprite hook, boolean down){
        if(down) {
            hook.incrementSpriteY(10);
        } else {
            hook.incrementSpriteY(-10);
        }
        if(hook.getSpriteY()>0 || hook.getSpriteY() < -720) return !down;
        else return down;
    }

    public void changeBackground(){
        if(fish1.getSpriteX()>810) {
            if(backgroundsIndexC + 1 < backgrounds[0].length) {
                fish1.setSpriteX(0);
                backgroundsIndexC++;
            }
        }
        if(fish1.getSpriteX()<-10) {
            if(backgroundsIndexC - 1 > -1) {
                fish1.setSpriteX(800);
                backgroundsIndexC--;
            }
        }
        if(backgroundsIndexR == 1 && backgroundsIndexC == 0 && isKey){
            enterCastle();
        }
    }

    public void enterCastle(){
        if(castleEntrance != null && fish1.getObservingRectangle().intersects(castleEntrance)) {
            fish1.setSpriteX(0);
            fish1.setSpriteY(600);
            backgroundsIndexR = 0;
        }
    }

    public void loseLife(){
        if(vulnerable){
            fishLives--;
            fishHearts.removeLast();
            currentRecovery = 0;
        }
    }

    public void recovery(){
        if(vulnerable && currentRecovery < recoveryTime) {
            vulnerable = false;
        }
        if(currentRecovery >= recoveryTime) vulnerable = true;
        currentRecovery += 10;
    }

    private Rectangle hook1Rect(){
        return new Rectangle(hook1.getSpriteX(), hook1.getSpriteY(),40, 720);
    }
    private Rectangle hook2Rect(){
        return new Rectangle(hook2.getSpriteX(), hook2.getSpriteY(),40, 720);
    }
    private Rectangle hook3Rect(){
        return new Rectangle(hook3.getSpriteX(), hook3.getSpriteY(),40, 720);
    }
    private Rectangle hook4Rect(){
        return new Rectangle(hook4.getSpriteX(), hook4.getSpriteY(),40, 720);
    }
    private boolean hookDamage(){
        if(fish1.getObservingRectangle().intersects(hook1Rect())) return true;
        if(fish1.getObservingRectangle().intersects(hook2Rect())) return true;
        if(fish1.getObservingRectangle().intersects(hook3Rect())) return true;
        if(fish1.getObservingRectangle().intersects(hook4Rect())) return true;
        return false;
    }

    private Rectangle keyRect(){
        return new Rectangle(key.getSpriteX(), key.getSpriteY(),75, 40);
    }
    private void getKey(){
        if(keyRect().intersects(fish1.getObservingRectangle())) isKey = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveFish1();
        recovery();
        changeBackground();
        if(backgroundsIndexR == 1 && backgroundsIndexC == 2) {
            hook1down = moveHook(hook1, hook1down);
            hook2down = moveHook(hook2, hook2down);
            hook3down = moveHook(hook3, hook3down);
            hook4down = moveHook(hook4, hook4down);
            if(hookDamage()){
                loseLife();
            }
            getKey();
        }
        if(backgroundsIndexR == 1 && backgroundsIndexC == 0){
            castleEntrance = new Rectangle(35,550,39, 74);
        } else {
            castleEntrance = null;
        }
        repaint();
    }
}
