
package Utilitarios;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author marshal
 * O objetivo dessa classe é permitir somente a digitação de números em um JTextField
 */
public class TeclasPermitidas extends PlainDocument {
    //esse insertString só permite que se digite letras no JTextField
    //para ter espaço basta acrescentar espaço nos colchetes, não esquecendo de fazer isso no replace tb.
//      @Override
//    public void insertString (int offset, String str, javax.swing.text.AttributeSet attr)
//    throws BadLocationException{
//        super.insertString(offset, str.replaceAll("[^a-z |^A-Z]",""), attr);
//    }
    
    @Override
    public void insertString (int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^0-9]",""), attr);
    }
    
    
    public void replace (int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^0-9]",""), attr);
    }
  
    
}
