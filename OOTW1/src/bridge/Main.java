package bridge;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        WindowImpl windowsImpl = new WindowsImpl();
        WindowImpl xWindowImpl = new XWindowImpl();

        AbstractWindow window = new Window(xWindowImpl);

//        AbstractWindow window = new Window(windowsImpl);

        window.DrawRect();
        window.DrawText();
    }
}
