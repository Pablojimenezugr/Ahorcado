package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Pablo Jj
 */
public class Imagen {
    
    private String foto;
    
    @SuppressWarnings("empty-statement")
    public Imagen(String nombre_fichero) throws FileNotFoundException, IOException {
        
        foto = "";
        FileReader fr = new FileReader(nombre_fichero);
        BufferedReader bf = new BufferedReader(fr);
        
        String linea;
        while((linea = bf.readLine()) != null) {
            foto += linea + "\n";
        }
        
    }
    
    public String getFoto() {
        return foto;
    }
    
}
