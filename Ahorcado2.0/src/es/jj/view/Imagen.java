package es.jj.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Es la clase encargada de gestionar las imagenes típicas del ahorcado. Son 7
 * imágenes lo que significa que se tienen 7 oportunidades.
 * <p> Esta clase se ha reutilizado de su implementación original. </p>
 * <p> 10-08-2019 </p>
 * @author pablojj
 */
public class Imagen extends javax.swing.JPanel {

    private static List rutasImg;
    private static int sig = 0;
    
    /**
     * Establece la imagen inicial en el jPanel y lo hace visible
     */
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
    
    /**
     * Establece la imagen cuya posición es @param
     * @param i estado del juego
     */
    public void ponerImagen(int i) {
        // new ImageIcon(getClass().getResource( rutasImg.get(i).toString() ))
        jLabel1.setIcon(new ImageIcon(rutasImg.get(i).toString()));
    }
    
    /**
     * Establece la imagen siguiente correspondiente al estado del juego, según 
     * número de errores.
     */
    void next() {
        sig++;
        jLabel1.setIcon(new ImageIcon(rutasImg.get(sig).toString()));
    }

    /**
     * Establece la imagen inicial.
     */
    void reset() {
        sig = 0;
        ponerImagen(0);
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
