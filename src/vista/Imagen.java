package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author pablo
 */
public class Imagen extends javax.swing.JPanel {

    private List rutasImg;

    public Imagen() {
        initComponents();

        rutasImg = new ArrayList<String>();
        for (int i = 1; i <= 7; i++) {
            rutasImg.add("/vista/data/" + i + ".jpg");
        }       
        jLabel1.setIcon(new ImageIcon(getClass().getResource( rutasImg.get(0).toString() )));
    }

    public void ponerImagen(int i) {
        jLabel1.setIcon(new ImageIcon(getClass().getResource( rutasImg.get(i).toString() )));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/data/1.jpg"))); // NOI18N
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
