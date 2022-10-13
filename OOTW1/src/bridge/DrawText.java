package bridge;

import javax.swing.*;
import java.awt.*;

public class DrawText extends JPanel {
    private static final int TEXT_X = 10;
    private static final int TEXT_Y = 10;
    private static final int TEXT_WIDTH = 100;
    private static final int TEXT_HEIGHT = 30;
    private String text = "Hello World!";
    DrawText(){

    }
    DrawText(String text){
        this.text=text;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the rectangle here
        g.drawString(this.text,TEXT_X,TEXT_Y);
    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(TEXT_WIDTH + 2 * TEXT_X, TEXT_HEIGHT + 2 * TEXT_Y);
    }

    // create the GUI explicitly on the Swing event thread
    private static void createAndShowGui() {
        DrawText mainPanel = new DrawText();

        JFrame frame = new JFrame("DrawRect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
