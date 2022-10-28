package replace;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ReplaceActionListener implements ActionListener {
    JTextPane textPane;

    public ReplaceActionListener(JTextPane p) {
        this.textPane = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog frDialog = new JDialog();
        frDialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                recoverBackgroundColor();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        frDialog.setLayout(new GridLayout(3, 4));

        JTextField txtFind = new JTextField();
        JTextField txtReplace = new JTextField();
        JButton btnFind = new JButton("Find");
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFindWordBackgroundColor(txtFind.getText());
            }
        });
        JButton btnReplace = new JButton("Replace");
        btnReplace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    replaceWord(txtFind.getText(), txtReplace.getText());
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        frDialog.add(new JLabel("Find: "));
        frDialog.add(txtFind);
        frDialog.add(new JLabel(""));
        frDialog.add(btnFind);
        frDialog.add(new JLabel("Replace with: "));
        frDialog.add(txtReplace);
        frDialog.add(new JLabel(""));
        frDialog.add(btnReplace);
        frDialog.add(new JLabel(""));
        frDialog.add(new JLabel(""));
        frDialog.add(new JLabel(""));

        frDialog.pack();
        frDialog.setVisible(true);
    }

    void setFindWordBackgroundColor(String find) {
        String content = textPane.getText().replace("\n", "");
        for (int i = 0; i < content.length() - find.length() + 1; i++) {
            String temp = content.substring(i, i + find.length());
            if (temp.equals(find)) {
                SimpleAttributeSet style = new SimpleAttributeSet();
                StyleConstants.setBackground(style, new Color(37, 150, 190,50));
                textPane.getStyledDocument().setCharacterAttributes(i, find.length(), style, false);
            }
        }
    }

    void recoverBackgroundColor() {
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setBackground(style, Color.white);
        textPane.getStyledDocument().setCharacterAttributes(0, textPane.getText().length(), style, false);
    }

    void replaceWord(String find, String replace) throws BadLocationException {
        String content = textPane.getText().replace("\n", "");
        Document doc = textPane.getDocument();
        int counterOfReplace = 0;

        for (int i = 0; i < content.length() - find.length() + 1; i++) {
            String temp = content.substring(i, i + find.length());
            if (temp.equals(find)) {
                int offset = (find.length() - replace.length()) * counterOfReplace;
                doc.remove(i - offset, find.length());
                doc.insertString(i - offset, replace, new SimpleAttributeSet());
                counterOfReplace++;
            }
        }
    }
}