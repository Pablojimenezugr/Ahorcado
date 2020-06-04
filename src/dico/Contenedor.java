package dico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author pablo
 */
public class Contenedor {
    
    private Set spanish;
    private Set english;
    
    public Contenedor() throws FileNotFoundException {
        spanish = new HashSet<String>();
        english = new HashSet<String>();
        var fe = new File("src/dico/espaniol.txt");
        var fi = new File("src/dico/ingles.txt");
        var br = new Scanner(fe);
        String l = null;
        while(br.hasNextLine()) {
            l = br.nextLine();
            spanish.add(l);
        }
        br.close();
        
        br = new Scanner(fi);
        while(br.hasNextLine()) {
            l = br.nextLine();
            english.add(l);
        }
        br.close();
        
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        new Contenedor();
    }
    
}
