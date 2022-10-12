package Command;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

public class receiverCommand extends JFrame {
	JTextPane textArea;
	JFrame frame;
	UndoManager undoManager = new UndoManager();
	

	
	
	public void setTextArea(JTextPane textArea) {
		this.textArea = textArea;
	}
	public void setJFrame(JFrame frame) {
		this.frame = frame;
	}
	public void Cut(){
		textArea.cut();
	}
	public void Copy(){
		textArea.copy();
	}
	public void Paste() {
		textArea.paste();
	}
	public void Save() {
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
	
	public void Print() {
		try {
			// print the file
			textArea.print();
		}
		catch (Exception evt) {
			JOptionPane.showMessageDialog(frame, evt.getMessage());
		}
	}
	public void Open() {
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
	public void New() {
		textArea.setText("");
	}
	public void Close() {
		frame.setVisible(false);
	}
	public void ScrollBar() {
		textArea.setAutoscrolls(true);
//		JScrollPane pane = new JScrollPane(t, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		f.add(pane);
	}
	public void Undo() {
		
	}
}
