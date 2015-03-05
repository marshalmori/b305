/*
 * Autor: Marshal Mori Cavalheiro
 * email: marshalmori@gmail.com
 * Projeto: B 305
 */


package Utilitarios;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author marshal
 */
public class TeclasPermitidasComVirgula extends PlainDocument{
    
     @Override
    public void insertString (int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^0-9 |^,]",""), attr);
    }
    
    
    public void replace (int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^0-9 |^,]",""), attr);
    }
    
}
