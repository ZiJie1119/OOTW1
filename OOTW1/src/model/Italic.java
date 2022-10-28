package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Italic extends FontStyleDecorator {
    public Italic( FontStyleComponent fontStyleComponent){
        super(fontStyleComponent);
    }

    @Override
    public void setStyle(ActionEvent event){
        fontStyleComponent.setStyle(event);
        new StyledEditorKit.ItalicAction().actionPerformed(event);
    }

}
