package vista;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Pablo Jj
 */
public class Teclado extends javax.swing.JPanel {

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
//            b.addActionListener(new EventoTecladoVirtual());
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

//    private class EventoTecladoVirtual implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            boolean correcto = juego.sigPaso(e.getActionCommand().toCharArray()[0]);
//
//            if (correcto) {
//                JButton pulsado = (JButton) e.getSource();
//                pulsado.setBackground(Color.GREEN);
//                pulsado.setOpaque(true);
//                pulsado.setBorderPainted(false);
//            } else {
//                JButton pulsado = (JButton) e.getSource();
//                pulsado.setBackground(Color.RED);
//                pulsado.setOpaque(true);
//                pulsado.setBorderPainted(false);
//                imagen2.ponerImagen(juego.getIndiceFigura());
//                imagen2.setVisible(true);
//                imagen2.repaint();
//            }
//            refrescarPalabraLabel();
//            if (juego.finalJuego()) {
//                Icon icono;
//                String sms;
//                if (juego.ganador()) {
//                    sms = "¡HAS GANADO!";
//                    icono = new ImageIcon(getClass().getResource("data/ganador.png"));
//                } else {
//                    sms = "Has perdido!\nLa palabra era: " + juego.getPalabra();
//                    icono = new ImageIcon(getClass().getResource("data/perdedor.png"));
//                }
//
//                JOptionPane.showMessageDialog(new Teclado(), sms, "Fin de la partida", 1, icono);
//                try {
//                    nuevoJuego();
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (URISyntaxException ex) {
//                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
