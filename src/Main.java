import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fish 2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 720);
        frame.setLocationRelativeTo(null);

        DisplayPanel panel = new DisplayPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
