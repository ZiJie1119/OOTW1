package bridge;

import javax.swing.*;
import java.awt.*;

public class Window extends AbstractWindow {
    private static JFrame frame;
    protected Window(WindowImpl windowImpl) {
        super(windowImpl);


        JFrame frame = new JFrame("Window");
        frame.setSize(960,540);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        this.frame =frame;
    }

    @Override
    public void DrawText() {
        this.frame.add(this.windowImpl.DevDrawText());
    }

    @Override
    public void DrawRect() {
        this.frame.add(this.windowImpl.DevDrawRect());
    }
}
