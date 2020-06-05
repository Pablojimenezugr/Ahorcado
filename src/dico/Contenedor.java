package dico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author pablo
 */
public class Contenedor {

    private Set spanish;
    private static Random rdn;
    private List aleatorios;

    public Contenedor() throws FileNotFoundException {
        spanish = new HashSet<String>();
        rdn = new Random();
        aleatorios = new ArrayList<Integer>();
        var fe = new File("src/dico/espaniol.txt");

        var br = new Scanner(fe);
        String l = null;
        while (br.hasNextLine()) {
            l = br.nextLine();
            spanish.add(l);
        }
        br.close();

    }

    public String[] getSpanish() {
        return Arrays.copyOf(spanish.toArray(), spanish.toArray().length, String[].class);
    }

    public Set getSetSpanish() {
        return spanish;
    }

    public String palabraAleatoria() {
        Integer ale = null;
        do {
            ale = rdn.nextInt(spanish.size());
        } while (aleatorios.contains(ale));
        aleatorios.add(ale);
        
        String[] claves = Arrays.copyOf(spanish.toArray(), spanish.toArray().length, String[].class);
        
        return claves[ale];
    }
}
