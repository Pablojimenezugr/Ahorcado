package es.jj.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase representa al conjunto de operaciones necesarisa para llevar
 * a cabo el siguimiento y la validación típica del tradicional juego.
 * <p> Prácticamente no se han hecho modifiaciones respecto a la original 
 * implementación. Es por ello que esta parte de la documentación está en español.</p>
 * 
 * <p> 10-08-2019 </p>
 * @author pablojj
 */
public class Ahorcado {
    
    private final Set<Character> falladas;
    private static String palabra;
    private char[] palabra_cifrada;
    private boolean ganado, perdido;

    /**
     * Constructor que crea un juego a partir de una palabra secreta que hay que
     * adivinar.
     * @param palabra a adivinar
     */
    public Ahorcado(String palabra) {
        this.palabra = palabra.toUpperCase();
        this.falladas = new HashSet<>();
        this.cifrar();
        this.ganado = this.perdido = false;
    }

    /**
     * Cifra la palabra para ser mostrada al jugador.
     */
    private void cifrar() {
        palabra_cifrada = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            palabra_cifrada[i] = '_';
        }
    }

    /**
     * Comprueba si la palabra ha sido adivinada por el jugador.
     * @return si la plabara ha sido adivinada.
     */
    private boolean palabraDescubierta() {
        for (int i = 0; i < palabra_cifrada.length; i++) {
            if (palabra_cifrada[i] == '_') {
                return false;
            }
        }
        return true;
    }

    /**
     * Nos indica si se ha adivinado la palabra o no se ha sido capaz.
     * @return si se ha adivinado la palabra
     */
    public boolean ganador() {
        return ganado;
    }

    private boolean esVocal(char c) {
        Set vocales = new HashSet<>(Arrays.asList(
                'A', 'E', 'I', 'O', 'U'
        ));
        return vocales.contains(c);
    }

    /**
     * Comprieba si @param está en la palabra, si está lo pone en la palabra.
     * (visible para el usuario)
     * @param c carater a probar.
     * @return si @param está en la palabra
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

    /**
     * Nos indica si se ha alcanzado el final del juego. Esto es, cuando se ha 
     * descubierto la palabra o nos hemos quedado sin intentos.
     * @return si hemos terminado el juego.
     */
    public boolean finalJuego() {
        ganado = palabraDescubierta();
        perdido = falladas.size() == 6;

        return ganado || perdido;
    }

    
    /**
     * Devueleve la palabra cifrada que tenemos que adivinar.
     * @return devueleve la palabra cifrada que tenemos que adivinar.
     */
    public String getPalabraCifrada() {
        String salida = "";
        for (char i : palabra_cifrada) {
            salida += i + " ";
        }
        return salida;
    }

    /**
     * Vemos si {c} está en la palabra y por tanto hemos acertado una o por el
     * contrario hemos fallado.
     * 
     * @param c posible letra que está en la palabra.
     * @return si @param está en la palabra o no.
     */
    public boolean siguientePaso(char c) {
        c = Character.toUpperCase(c);
        boolean esta = falladas.contains(c);
        boolean adivinada = adivinar(c);

        if (!esta && !adivinada) {
            falladas.add(c);
        }

        return esta || adivinada;
    }

    /**
     * Retorna la palabra original
     * @return palabra original sin cifrar.
     */
    public String getPalabra() {
        return palabra;
    }
}
