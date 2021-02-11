
package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Pablo Jj
 */
public class Ahorcado {
    
    private final Set<Character> falladas;
    private static String palabra;
    private char[] palabra_cifrada;
    private boolean ganado, perdido;

    public Ahorcado(String palabra) {
        this.palabra = palabra.toUpperCase();
        this.falladas = new HashSet<>();
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
        Set vocales = new HashSet<>(Arrays.asList(
                'A', 'E', 'I', 'O', 'U'
        ));
        return vocales.contains(c);
    }

    /**
     * Comprieba si <c> está en la palabra, si está lo pone en la palabra.
     *
     * @param c
     * @return si <c> está en la palabra
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

    /**
     * Elimina las tildes de las vocales (español)
     * @param c vocal con posible tilde.
     * @return vocal sin tilde.
     */
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

    public String getPalabraCifrada() {
        String salida = "";
        for (char i : palabra_cifrada) {
            salida += i + " ";
        }
        return salida;
    }

    public boolean siguientePaso(char c) {
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
}
