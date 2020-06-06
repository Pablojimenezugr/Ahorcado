package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Juego;

/**
 *
 * @author pablo
 */
public class Ventana extends javax.swing.JFrame {

    private Juego juego;
    private VentanaInicio inicio;
    private String p = null;

    public Ventana() throws FileNotFoundException, IOException, URISyntaxException {
        initComponents();
        setTitle("Ahorcado ~ Jj");
        setResizable(false);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("data/icon.png"));
        setIconImage(icono.getImage());
        setLocationRelativeTo(null);
        nuevoJuego();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void nuevoJuego() throws FileNotFoundException, IOException, URISyntaxException {
        try {
            inicio = new VentanaInicio(this, true);
            juego = new Juego(inicio.obtenerPalabraParaJuego());
            refrescarPalabraLabel();
            this.setVisible(true);
            teclado1.teclas.forEach((t) -> {
                t.setBackground(null);
            });
        } catch (NullPointerException e) {
            System.exit(0);
        }
    }

    public void setJuego(Juego j) {
        juego = j;
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                    .addComponent(imagen2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teclado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            nuevoJuego();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private class Teclado extends javax.swing.JPanel {

        private List<JButton> teclas;

        public Teclado() {
            initComponents();
            teclas = new ArrayList<>();
            List letras = new ArrayList<>(Arrays.asList(
                    'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G',
                    'H', 'J', 'K', 'L', 'Ñ', 'ç', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', '-', '*'
            ));

            letras.forEach((l) -> {
                JButton b = new JButton(l.toString());
                b.setFont(new Font("Arial", 0, 30));
                b.addActionListener(new EventoTecladoVirtual());
                teclas.add(b);
                add(b);
            });

            this.setVisible(true);
            repaint();
            revalidate();
        }

        public void resetTeclas() {
            teclas.forEach((t) -> {
                t.setBackground(null);
            });
        }

        private class EventoTecladoVirtual implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                boolean correcto = juego.sigPaso(e.getActionCommand().toCharArray()[0]);

                if (correcto) {
                    JButton pulsado = (JButton) e.getSource();
                    pulsado.setBackground(Color.GREEN);
                    pulsado.setOpaque(true);
                    pulsado.setBorderPainted(false);
                } else {
                    JButton pulsado = (JButton) e.getSource();
                    pulsado.setBackground(Color.RED);
                    pulsado.setOpaque(true);
                    pulsado.setBorderPainted(false);
                    imagen2.ponerImagen(juego.getIndiceFigura());
                    imagen2.setVisible(true);
                    imagen2.repaint();
                }
                refrescarPalabraLabel();
                if (juego.finalJuego()) {
                    Icon icono;
                    String sms;
                    if (juego.ganador()) {
                        sms = "¡HAS GANADO!";
                        icono = new ImageIcon(getClass().getResource("data/ganador.png"));
                    } else {
                        sms = "Has perdido!\nLa palabra era: " + juego.getPalabra();
                        icono = new ImageIcon(getClass().getResource("data/perdedor.png"));
                    }

                    JOptionPane.showMessageDialog(new Teclado(), sms, "Fin de la partida", 1, icono);
                    try {
                        nuevoJuego();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.Imagen imagen2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel palabra;
    private Teclado teclado1;
    // End of variables declaration//GEN-END:variables
}
