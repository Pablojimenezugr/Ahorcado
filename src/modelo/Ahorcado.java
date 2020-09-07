package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pablo Jj [trabajosdejj@gmail.com]
 */
public class Ahorcado {

    private final ArrayList<Character> posibles;
    private final ArrayList<Character> falladas;
    private static String palabra;
    private char[] palabra_cifrada;
    private boolean ganado, perdido;

    public Ahorcado(final String palabra) {
        this.palabra = palabra.toUpperCase();

        this.posibles = new ArrayList<>(Arrays.asList(
                'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G',
                'H', 'J', 'K', 'L', 'Ñ', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'
        ));

        this.falladas = new ArrayList<>();
        this.cifrar();
        this.ganado = this.perdido = false;
    }

    private void cifrar() {
        palabra_cifrada = new char[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            palabra_cifrada[i] = '_';
        }

    }


    private boolean palabraDescubierta() {
        for (int i = 0; i < palabra_cifrada.length; i++) {
            if (palabra_cifrada[i] == '_') {
                return false;
            }
        }

        return true;
    }

    public boolean ganador() {
        return ganado;
    }

    public boolean perdido() {
        return perdido;
    }

    private boolean esVocal(char c) {
        List vocales = new ArrayList<>(Arrays.asList(
                'A', 'E', 'I', 'O', 'U'
        ));

        return vocales.contains(c);
    }

    /**
     * Comprieba si <c> está en la palabra, si está lo pone en la palabra.
     *
     * @param c
     * @return
     */
    private boolean adivinar(char c) {
        boolean salida = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == c) {
                salida = true;
                palabra_cifrada[i] = c;
            } else if (esVocal(c)) {
                if (palabra.charAt(i) == mod(c)) {
                    salida = true;
                    palabra_cifrada[i] = c;
                }
            }
        }

        return salida;
    }

    private char mod(char c) {
        Map equivalencia = new HashMap<Character, Character>();
        equivalencia.put('A', 'Á');
        equivalencia.put('E', 'É');
        equivalencia.put('I', 'Í');
        equivalencia.put('O', 'Ó');
        equivalencia.put('U', 'Ú');
        return (char) equivalencia.get(c);
    }

    public boolean finalJuego() {

        ganado = palabraDescubierta();
        System.out.println("Ganado = " + ganado);
        perdido = falladas.size() == 6;

        return ganado || perdido;
    }

    public int getIndiceFigura() {
        return falladas.size();
    }

    public String getPalabra_cifrada() {
        String salida = "";
        for (char i : palabra_cifrada) {
            salida += i + " ";
        }
        return salida;
    }

    public boolean sigPaso(char c) {

        c = Character.toUpperCase(c);

        boolean esta = falladas.contains(c);
        boolean adivinada = adivinar(c);

        if (!esta && !adivinada) {
            falladas.add(c);
        }

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
