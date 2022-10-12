import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Memento.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class keyEventListener implements KeyListener {
	boolean enterTyped = false;
	originator originator;
	careTaker careTaker;
	JTextPane jTextPane;
	public keyEventListener(originator originator,careTaker careTaker,JTextPane jTextPane) {
		this.careTaker = careTaker;
		this.originator = originator;
		this.jTextPane = jTextPane;
	}
	
	public void keyTyped(KeyEvent e){}
	@Override
	public void keyPressed(KeyEvent e)
	{
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			enterTyped = true;
			System.out.println("EnterPress = "+enterTyped);
			originator.storeState(jTextPane.getText());
			careTaker.setMemento(originator.setMemento());
		}
		else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
			originator.storeState(jTextPane.getText());
			careTaker.setMemento(originator.setMemento());
		}
		else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V) {
			originator.storeState(jTextPane.getText());
			careTaker.setMemento(originator.setMemento());
		}
		enterTyped = false;	
		
	}
	@Override
	public void keyReleased(KeyEvent e){}
	

}
