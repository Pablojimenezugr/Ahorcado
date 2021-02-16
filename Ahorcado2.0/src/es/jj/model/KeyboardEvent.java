
package es.jj.model;

import es.jj.controller.MainController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Models the behavior that the virtual keyboard keys should have.
 *
 * @author Pablo Jj
 */
public class KeyboardEvent implements ActionListener {

    private static String letter;
    private static JButton pulsado;
    
    /**
     * Empty constructor.
     */
    public KeyboardEvent() {  }

    /**
     * Get the source of the clicked button and calls the controller to notify
     * the corresponding key
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        pulsado = (JButton) e.getSource();
        letter = pulsado.getText();
        MainController.reedLetter(letter, pulsado);
    }
    
    /**
     * 
     * @return the letter clicked.
     */
    public static String getLetterClicked() {
        return letter;
    }
}
