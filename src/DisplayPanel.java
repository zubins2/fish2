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
    private int getBackgroundsIndexC;
    private BufferedImage[][] backgrounds;
    private Fish fish1;
    private Fish fish2;
    private Timer timer;
    private boolean[] pressedKeys;

    public DisplayPanel() {
        backgroundsIndexR = 1;
        getBackgroundsIndexC = 1;
        pressedKeys = new boolean[128];
        timer = new Timer(10, this);

        fish1 = new Fish(100, 300, "src/fish1.png", "fish1", 100, 80);
        fish1.addSource("src/fish1_2.png");
        fish2 = new Fish(700, 100, "src/fish2.png", "fish2", 165, 101);
        fish2.addSource("src/fish2_2.png");
        fish2.switchSources(1);

        backgrounds = new BufferedImage[2][2];
        try{
            backgrounds[backgroundsIndexR][getBackgroundsIndexC] = ImageIO.read(new File("src/aquarium.png"));
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
        g.drawImage(backgrounds[backgroundsIndexR][getBackgroundsIndexC], 0, 0, null);
        g.drawImage(fish1.getImage(), fish1.getSpriteX(), fish1.getSpriteY(), null);
        g.drawImage(fish2.getImage(), fish2.getSpriteX(), fish2.getSpriteY(), null);
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
            fish1.incrementSpriteX(5);
            fish1.switchSources(0);
        }
        if(pressedKeys[KeyEvent.VK_A]) {
            fish1.incrementSpriteX(-5);
            fish1.switchSources(1);
        }
        if(pressedKeys[KeyEvent.VK_W]) {
            fish1.incrementSpriteY(-5);
        }
        if(pressedKeys[KeyEvent.VK_S]) {
            if(fish1.getSpriteY()<545) {
                fish1.incrementSpriteY(5);
            }
        }
        fish1.setObservingRectangle();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveFish1();
        repaint();
        if(fish1.getObservingRectangle().intersects(fish2.getObservingRectangle())){

        }
    }
}
