package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Juego;

/**
 *
 * @author pablo
 */
public class Ventana extends javax.swing.JFrame {

    private Juego juego;

    public Ventana() {
        initComponents();
        setTitle("Ahorcado ~ Jj");
        setResizable(false);

        nuevaPartida("PALABRA SECRETA");

    }

    private void nuevaPartida(String sms) {
        String seleccion;
        do {
            seleccion = JOptionPane.showInputDialog(
                    this,
                    "Introduce palabra a adivinar",
                    sms,
                    JOptionPane.QUESTION_MESSAGE);
        } while (seleccion.contains(" ") || seleccion.isBlank() || seleccion.isEmpty());

        this.juego = new Juego(seleccion);
        refrescarPalabraLabel();
    }

    private void refrescarPalabraLabel() {
        this.palabra.setText(juego.getPalabra_cifrada());

        repaint();
        revalidate();
    }

    public void matarVentana() {
        System.exit(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teclado1 = new Teclado();
        palabra = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        imagen2 = new vista.Imagen();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        palabra.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        palabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        palabra.setText("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        palabra.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("NUEVO JUEGO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(teclado1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(palabra, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(palabra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teclado1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private class Teclado extends javax.swing.JPanel {

        public Teclado() {
            initComponents();

            var letras = new ArrayList<>(Arrays.asList(
                    'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G',
                    'H', 'J', 'K', 'L', 'Ñ', 'ç', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', '-', '*'
            ));
            System.out.println("dqwd");
            letras.forEach((l) -> {
                var b = new JButton(l.toString());
                b.setFont(new Font("Arial", 0, 30));
                b.addActionListener(new EventoTecladoVirtual());
                add(b);
            });

            System.out.println("creado");
            this.setVisible(true);
            repaint();
            revalidate();
        }

        private class EventoTecladoVirtual implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                var correcto = juego.sigPaso(e.getActionCommand().toCharArray()[0]);

                if (correcto) {
                    JButton pulsado = (JButton) e.getSource();
                    pulsado.setBackground(Color.GREEN);
                } else {
                    JButton pulsado = (JButton) e.getSource();
                    pulsado.setBackground(Color.RED);
                    System.out.println("indice figura: " + juego.getIndiceFigura());
                    imagen2.ponerImagen(juego.getIndiceFigura());
                    imagen2.setVisible(true);
                    imagen2.repaint();
                }
                refrescarPalabraLabel();
                if (juego.finalJuego()) {
                    String sms = (juego.ganador()) ? "¡HAS GANADO!" : "Has perdido";

                    JOptionPane.showMessageDialog(new Teclado(), sms, "Fin de la partida", 1);
                    nuevaPartida("Introduce nueva palabra");
                }
            }

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            setLayout(new java.awt.GridLayout(3, 10));
        }// </editor-fold>                        

        // Variables declaration - do not modify                     
        // End of variables declaration                   
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.Imagen imagen2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel palabra;
    private Teclado teclado1;
    // End of variables declaration//GEN-END:variables
}
