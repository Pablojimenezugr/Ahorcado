/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.palabrasAleatoriasGUI;

import dico.Contenedor;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.Ventana;

/**
 *
 * @author pablo
 */
public class VentanaInicio extends javax.swing.JDialog {

    private String palabra = null;
    private Contenedor dico;
    private ModeloOriginalLista modeloOriginal;
    private DefaultListModel modeloBusqueda = null;

    public VentanaInicio(java.awt.Frame parent, boolean modal) throws FileNotFoundException {
        super(parent, modal);
        initComponents();
        dico = new Contenedor();
        
        setTitle("CONFIGURANDO JUGADA");
        
        setLocationRelativeTo(null);
        jTextField2.setText("Buscar palabra...");
        ale.setSelected(true);
        modeloOriginal = new ModeloOriginalLista(dico.getSpanish());
        lista.setModel(modeloOriginal);
        registros.setText(dico.getSetSpanish().size() + " registros cargados.");
        ale.transferFocus();
        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ale = new javax.swing.JCheckBox();
        registros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("Introduce una palabra:");

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista);

        jTextField2.setText("jTextField2");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jButton4.setText("¡DAME UNA ALEATORIA!");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("¡USAR ESTA!");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ale.setText("ver palabra aleatoria");

        registros.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        registros.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(ale))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registros)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(3, 3, 3)
                .addComponent(registros))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        int c = 0;
        String txt = jTextField2.getText();
        var a = dico.getSetSpanish();
        if (txt.trim().length() > 0) {

            modeloBusqueda = new DefaultListModel();
            for (int i = 0; i < a.size(); i++) {

                if (modeloOriginal.getElementAt(i).toLowerCase().contains(txt.toLowerCase())) {
                    modeloBusqueda.addElement(modeloOriginal.getElementAt(i));
                    c++;
                }
            }

            lista.setModel(modeloBusqueda);
            registros.setText(c + " registros cargados.");
        } else {
            lista.setModel(modeloOriginal);
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2FocusGained

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if (!jTextField1.getText().equals("")) {
            palabra = jTextField1.getText();
            boolean c = palabra.contains(" ") || palabra.isBlank() || palabra.isEmpty();
            int t = palabra.toCharArray().length;

            if (t >= 18) {
                JOptionPane.showMessageDialog(rootPane, "No puede tener más de 18 carácteres", "Error palabra secreta", JOptionPane.WARNING_MESSAGE);
            } else if (c) {
                JOptionPane.showMessageDialog(rootPane, "La palabra no es válida", "Error palabra secreta", JOptionPane.WARNING_MESSAGE);
            } else {
                this.dispose();
                System.out.println("hehco el dispose");
            }
            
            this.dispose();
            
        } else if (jTextField1.getText().equals("") && !lista.isSelectionEmpty()) {
            palabra = lista.getSelectedValue();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes escribir o seleccionar una palabra", "Error palabra secreta", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(ale.isSelected()) {
            palabra = dico.palabraAleatoria();
            JOptionPane.showMessageDialog(rootPane, palabra, "Palabra seleccionada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            palabra = dico.palabraAleatoria();
        }
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    public String obtenerPalabraParaJuego() {
        return palabra;
    }

    private class ModeloOriginalLista extends AbstractListModel<String> {

        private String[] strings;

        public ModeloOriginalLista(String[] lista) {
            strings = lista;
        }

        @Override
        public int getSize() {
            return strings.length;
        }

        @Override
        public String getElementAt(int i) {
            return strings[i];
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ale;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JList<String> lista;
    private javax.swing.JLabel registros;
    // End of variables declaration//GEN-END:variables

}
