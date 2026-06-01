import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import javax.swing.Timer;

public class DisplayPanel extends JPanel implements MouseListener, KeyListener, ActionListener {
    private BufferedImage background;
    private Fish fish1;
    private Timer timer;
    private boolean[] pressedKeys;

    public DisplayPanel() {
        pressedKeys = new boolean[128];
        fish1 = new Fish(100, 300, "src/fish1.png", "fish1");
        try{
            background = ImageIO.read(new File("src/aquarium.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        timer = new Timer(10, this);

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(fish1.getImage(), fish1.getSpriteX(), fish1.getSpriteY(), null);
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
        if(pressedKeys[KeyEvent.VK_D]) fish1.incrementSpriteX(5);
        if(pressedKeys[KeyEvent.VK_A]) fish1.incrementSpriteX(-5);
        if(pressedKeys[KeyEvent.VK_W]) fish1.incrementSpriteY(-5);
        if(pressedKeys[KeyEvent.VK_S]) fish1.incrementSpriteY(5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveFish1();
        repaint();
    }
}
