package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Pablo Jj [trabajosdejj@gmail.com]
 */
public class Juego {
    
    private ArrayList<String> figuras;
    private ArrayList<Character> posibles;
    private ArrayList<Character> falladas;
    private static String palabra;
    private char[] palabra_cifrada;
    private boolean ganado, perdido;
    
    
    public Juego(final String palabra) {
        this.palabra = palabra.toUpperCase();
        this.figuras = new ArrayList<>();
        this.posibles = new ArrayList<>(Arrays.asList(
            'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G',
               'H','J','K','L','Ñ','Z','X','C','V','B','N','M'
        ));
        
        this.falladas = new ArrayList<>();
        this.cifrar();
        this.ganado = this.perdido = false;
        this.CrearFiguras();
    }
    
    private void CrearFiguras() {
        figuras.add("            +---+\n"
                + "                     |\n"
                + "                     |\n"
                + "                     |\n"
                + "                     |\n"
                + "                     |\n"
                + "=========\n");
        
        figuras.add("            +---+\n"
                + "             |       |\n"
                + "             O       |\n"
                + "                     |\n"
                + "                     |\n"
                + "                     |\n"
                + "=========\n");
        
        figuras.add("            +---+\n"
                + "             |       |\n"
                + "             O       |\n"
                + "             |       |\n"
                + "                     |\n"
                + "                     |\n"
                + "=========\n");
        
        figuras.add("            +---+\n"
                + "             |       |\n"
                + "             O       |\n"
                + "            /|       |\n"
                + "                     |\n"
                + "                     |\n"
                + "=========\n");
        
        figuras.add("            +---+\n"
                + "             |       |\n"
                + "             O       |\n"
                + "            /|\\     |\n"
                + "                     |\n"
                + "                     |\n"
                + "=========\n");
        
        figuras.add("            +---+\n"
                + "             |       |\n"
                + "             O       |\n"
                + "            /|\\     |\n"
                + "            /        |\n"
                + "                     |\n"
                + "=========\n");
        
        figuras.add("            +---+\n"
                + "             |       |\n"
                + "             O       |\n"
                + "            /|\\     |\n"
                + "            / \\     |\n"
                + "                     |\n"
                + "=========\n");
    }

    private void cifrar() {
        palabra_cifrada = new char[palabra.length()];
     
        for(int i=0; i<palabra.length(); i++) {
            palabra_cifrada[i] = '_';
        }
        
    }
    
    private boolean letraYaFallada(char c) {
        return falladas.contains(c);
    }

    private boolean palabraDescubierta() {
        for(int i=0; i<palabra_cifrada.length; i++)
        {
            if(palabra_cifrada[i] == '_')
                return false;
        }
        
        return true;
    }
    
    public boolean ganador() {
        return ganado;
    }
    
    public boolean perdido() {
        return perdido;
    }

    /**
     * Comprieba si <c> está en la palabra, si está lo pone en la palabra. 
     * @param c
     * @return 
     */
    private boolean adivinar(char c) {
        boolean salida = false;
        
        for(int i=0; i<palabra.length(); i++)
            if(palabra.charAt(i) == c) {
                salida = true;
                palabra_cifrada[i] = c;
            }
                  
            
        return salida;
    }
    
    public boolean finalJuego() {
        
        ganado = palabraDescubierta();
        System.out.println("Ganado = " + ganado);
        perdido = falladas.size() == 6;
        
        return ganado || perdido;
    }
    
    public String getFigura() {
        return figuras.get( falladas.size() );
    }
    
    public int getIndiceFigura() {
        return falladas.size();
    }
        
    public String getPalabra_cifrada() {
        String salida="";
        for(char i : palabra_cifrada) {
            salida += i + " ";
        }
        return salida;
    }
    
    public boolean sigPaso(char c) {
        
        c = Character.toUpperCase(c);
        
        boolean esta = falladas.contains(c);
        boolean adivinada = adivinar(c);
        
        if(!esta && !adivinada)   falladas.add(c);
        
        return esta || adivinada;
    }

    public String getPalabra() {
        return palabra;
    }
    
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
    
    
    public ArrayList getPosibles() {
        return (ArrayList) posibles.clone();
    }
}