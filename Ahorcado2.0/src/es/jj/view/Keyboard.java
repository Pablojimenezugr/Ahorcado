package es.jj.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Pablo Jj
 */
public class Keyboard extends javax.swing.JPanel {

    private static ArrayList<JButton> keys;

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

    public void resetTeclas() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(3, 10));
    }// </editor-fold>//GEN-END:initComponents

    void correct(String l, JButton evt) {
        evt.setBackground(Color.GREEN);
        evt.setOpaque(true);
        evt.setBorderPainted(false);
    }

    void incorrect(String l, JButton evt) {
        evt.setBackground(Color.RED);
        evt.setOpaque(true);
        evt.setBorderPainted(false);
    }

    void resetKeyboard() {
        keys.forEach((b) -> {
            b.setBackground(null);
            b.setOpaque(false);
            b.setBorderPainted(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
