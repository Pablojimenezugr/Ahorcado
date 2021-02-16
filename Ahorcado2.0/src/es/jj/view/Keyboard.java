package es.jj.view;

import es.jj.model.KeyboardEvent;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;

/**
 * Represent the virtual keyboard who is showed in the main screen.
 * 
 * @author Pablo Jj
 */
public class Keyboard extends javax.swing.JPanel {

    private static ArrayList<JButton> keys;

    /**
     * It's build a full spanish keyboard without tildes and with {ç}, {-}, { } space.
     */
    public Keyboard() {
        initComponents();
        keys = new ArrayList();

        List letters = new ArrayList<>(Arrays.asList(
                'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G',
                'H', 'J', 'K', 'L', 'Ñ', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'Ç', '-', ' '
        ));
        letters.forEach((l) -> {
            JButton b = new JButton(l.toString());
            b.setFont(new Font("Arial", 0, 50));
            b.addActionListener(new KeyboardEvent());
            keys.add(b);
            this.add(b);
        });

        this.setVisible(true);
    }

    /**
     * Mark the corresponding key as correct or incorrect
     * @param l
     * @param evt boton seleccionado
     */
    void mark(String l, JButton evt, Color c) {
        evt.setBackground(c);
        evt.setOpaque(true);
        evt.setBorderPainted(false);
        evt.setEnabled(false);
    }

    
    /**
     * Restores the initial keyboard appearance
     */
    void resetKeyboard() {
        keys.forEach((b) -> {
            b.setBackground(null);
            b.setOpaque(false);
            b.setBorderPainted(true);
            b.setEnabled(true);
        });
    }

    /**
     * Locks the keyboard when the game is over
     */
    void blockAllKeyboard() {
        keys.forEach((b) -> b.setEnabled(false) );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(3, 10));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
