package bridge;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        WindowImpl windowsImpl;
        AbstractWindow window;

        WindowImpl xWindowImpl ;
        System.out.println("OS Name:" +System.getProperty("os.name") );
        System.out.println("OS Version:" + System.getProperty("os.version") );
        System.out.println("OS Architecture:" + System.getProperty("os.arch") );

        if(System.getProperty("os.name").equals("Windows 10")){
            windowsImpl = new WindowsImpl();
            window = new Window(windowsImpl);
        }else{
            xWindowImpl= new XWindowImpl();
            window = new Window(xWindowImpl);
        }

        window.DrawRect();
        window.DrawText();
    }
}
