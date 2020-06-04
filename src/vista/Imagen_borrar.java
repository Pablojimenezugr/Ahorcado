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
 * @note Imagen sigue el modelo de diseño singleton
 * @author Pablo Jj
 */
public class Imagen_borrar {
    
    private String[] foto;
    private static int indice;
    private static Imagen_borrar instance;
    
    static {
        instance = null;
        indice = 0;
    }
    
    private Imagen_borrar() throws FileNotFoundException, IOException {
        
        foto = new String[7];
        
        for(int i=0; i<=6; i++) {
            FileReader fr = new FileReader("src/vista/data/" + i + ".dat");
            BufferedReader bf = new BufferedReader(fr);
            String linea="";
            String all = "";
            while((linea = bf.readLine()) != null) {
                all += linea + "\n";
            }
            foto[i] = all;
        }
    }
    
    public static void createInstance() throws IOException {
        if(instance == null) {
            instance = new Imagen_borrar();
            System.err.println("Creando instancia");
        }
            
    }
    
    public static Imagen_borrar getInstance() {
        return instance;
    }
    
    public String getFoto() {
        indice++;
        return foto[indice-1];
    }
    
}
