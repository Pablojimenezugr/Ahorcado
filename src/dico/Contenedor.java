package dico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author pablo
 */
public class Contenedor {

    private Set spanish;
    private static Random rdn;
    private List aleatorios;

    public Contenedor() throws FileNotFoundException, IOException {
        spanish = new HashSet<String>();
        rdn = new Random();
        aleatorios = new ArrayList<Integer>();
       
        InputStream is = Contenedor.class.getClassLoader().getResourceAsStream("dico/espaniol.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        
        String l = null;
        while ((l = reader.readLine()) != null) {
            spanish.add(l);
        }
        reader.close();
        is.close();
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
