import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class DisplayPanel extends JPanel implements MouseListener {
    private BufferedImage background;
    private ArrayList<Fish> fishList;

    public DisplayPanel() {
        fishList = new ArrayList<>();
        try{
            background = ImageIO.read(new File("src/aquarium.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        fishList.add(new Fish("fish 1", 0, "src/fish1.png"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(fishList.getFirst().getImage(), 200, 300, null);
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
        while
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
