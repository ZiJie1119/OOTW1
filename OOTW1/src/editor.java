import Command.commandCommand;
import Command.copyCommand;
import Command.cutCommand;
import Command.pasteCommand;
import Command.invokerCommand;
import Command.receiverCommand;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
// we could add "Command Pattern"
class editor extends JFrame implements ActionListener {
	// Text component
	JTextArea textArea;

	// Frame
	JFrame frame;

	// Constructor
	editor()
	{
		// Create a frame
		frame = new JFrame("editor");

		try {
			// Set metal look and feel
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			// Set theme to ocean
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		}
		catch (Exception e) {
		}

		// Text component
		textArea = new JTextArea();

		// Create a menubar
		JMenuBar mb = new JMenuBar();

		// Create amenu for menu
		JMenu m1 = new JMenu("File");

		// Create menu items
		JMenuItem mi1 = new JMenuItem("New");
		JMenuItem mi2 = new JMenuItem("Open");
		JMenuItem mi3 = new JMenuItem("Save");
		JMenuItem mi9 = new JMenuItem("Print");

		// Add action listener
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi9.addActionListener(this);

		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi9);

		// Create a menu for menu
		JMenu m2 = new JMenu("Edit");

		// Create menu items
		JMenuItem mi4 = new JMenuItem("cut");
		JMenuItem mi5 = new JMenuItem("copy");
		JMenuItem mi6 = new JMenuItem("paste");

		// Add action listener
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);

		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);

		JMenuItem mc = new JMenuItem("close");

		mc.addActionListener(this);

		mb.add(m1);
		mb.add(m2);
		mb.add(mc);
		
		
		// Create a menu for menu
		JMenu m4= new JMenu("Function");
		// Create menu items
		JMenuItem m4i = new JMenuItem("ScrollBar");
		// Add action listener
		m4i.addActionListener(this);
		m4.add(m4i);
		mb.add(m4);
		
		// Create a menu for menu
		JMenu m5= new JMenu("Style");
		// Create menu items
		JMenuItem m5i = new JMenuItem("zoomIn");
		// Add action listener
		m5i.addActionListener(this);
		m4.add(m5i);
		mb.add(m4);
		
		frame.setJMenuBar(mb);
		frame.add(textArea);
		frame.setSize(500, 500);
		frame.show();
	}

	// If a button is pressed
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		
		receiverCommand receiver = new receiverCommand();
		invokerCommand invoker = new invokerCommand();
		
		
		receiver.setTextArea(textArea);
		receiver.setJFrame(frame);
		switch(s) {
		case "cut":
			commandCommand cut = new cutCommand(receiver);
			invoker.addCommend(cut);
			invoker.execute();
			break;
		case "copy":
			commandCommand copy = new copyCommand(receiver);
			invoker.addCommend(copy);
			invoker.execute();
			break;
		case "zoomIn":
			break;	
		case "paste":
			commandCommand paste = new pasteCommand(receiver);
			invoker.addCommend(paste);
			invoker.execute();
			break;
		case "Save":
			break;
		case "Print":
			break;
		case "Open":
			break;
		case "New":
			break;
		case "close":
			break;
		case "ScrollBar":
			break;
		}
		if (s.equals("cut")) {
//			t.cut();
			
			
		}
		else if(s.equals("zoomIn")){
			System.out.println("Y");
		}
		else if (s.equals("copy")) {
//			textArea.copy();
		}
		else if (s.equals("paste")) {
			textArea.paste();
		}
		else if (s.equals("Save")) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsSaveDialog function to show the save dialog
			int r = j.showSaveDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) {

				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// Create a file writer
					FileWriter wr = new FileWriter(fi, false);

					// Create buffered writer to write
					BufferedWriter w = new BufferedWriter(wr);

					// Write
					w.write(textArea.getText());

					w.flush();
					w.close();
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(frame, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(frame, "the user cancelled the operation");
		}
		else if (s.equals("Print")) {
			try {
				// print the file
				textArea.print();
			}
			catch (Exception evt) {
				JOptionPane.showMessageDialog(frame, evt.getMessage());
			}
		}
		else if (s.equals("Open")) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsOpenDialog function to show the save dialog
			int r = j.showOpenDialog(null);

			// If the user selects a file
			if (r == JFileChooser.APPROVE_OPTION) {
				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// String
					String s1 = "", sl = "";

					// File reader
					FileReader fr = new FileReader(fi);

					// Buffered reader
					BufferedReader br = new BufferedReader(fr);

					// Initialize sl
					sl = br.readLine();

					// Take the input from the file
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}

					// Set the text
					textArea.setText(sl);
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(frame, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(frame, "the user cancelled the operation");
		}
		else if (s.equals("New")) {
			textArea.setText("");
		}
		else if (s.equals("close")) {
			frame.setVisible(false);
		}
		else if(s.equals("ScrollBar")) {
			JScrollPane pane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			frame.add(pane);
		}
	}

	
	
}
