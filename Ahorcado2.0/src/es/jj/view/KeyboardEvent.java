
package es.jj.view;

import es.jj.controller.MainController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Pablo Jj
 */
public class KeyboardEvent implements ActionListener {

    private static String letter;
    private static JButton pulsado;
    
    public KeyboardEvent() {  }

    @Override
    public void actionPerformed(ActionEvent e) {
        pulsado = (JButton) e.getSource();
        letter = pulsado.getText();
        MainController.reedLetter(letter, pulsado);
    }
    
    public static String getLetterClicked() {
        return letter;
    }
}
