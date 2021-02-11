package es.jj.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author pablojj
 */
public class Imagen extends javax.swing.JPanel {

    private static List rutasImg;
    private static int sig = 0;
    
    public Imagen() {
        initComponents();
        jLabel1.setText("");
        rutasImg = new ArrayList<String>();
        for (int i = 1; i <= 7; i++) {
            //"/Users/pablojj/projects/Ahorcado/Ahorcado2.0/src/es/jj/view/data/1.jpg"
            //rutasImg.add("/view/data/" + i + ".jpg");
            rutasImg.add("/Users/pablojj/projects/Ahorcado/Ahorcado2.0/src/es/jj/view/data/" + i + ".jpg");
        }       
        
        jLabel1.setIcon(new ImageIcon((String) rutasImg.get(0)));
        this.setVisible(true);
    }
    
    public void ponerImagen(int i) {
        // new ImageIcon(getClass().getResource( rutasImg.get(i).toString() ))
        jLabel1.setIcon(new ImageIcon(rutasImg.get(i).toString()));
    }
    
    void next() {
        sig++;
        jLabel1.setIcon(new ImageIcon(rutasImg.get(sig).toString()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    
}
