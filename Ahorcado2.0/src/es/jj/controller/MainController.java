package es.jj.controller;

import es.jj.view.MainFrame;
import es.jj.view.StartedWindow;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import es.jj.model.Ahorcado;
import java.awt.Color;

/**
 * It is the main controller, who has the responsability to guide
 * de app into the user requirements.
 * 
 * @author pablojj
 */
public class MainController {
    
    private static Ahorcado juego;
    private static MainFrame m;
    private static StartedWindow s;
    private static boolean firstTime = true;
    
    /**
     * Starts the game, creates the main screen and the set up screen, it is
     * also called when we want to restart. In those casede main screen is reused.
     */
    public static void play() {
        if(firstTime) {
            m = new MainFrame();
            firstTime = false;
        } else {
            m.unlockKeyboard();
            m.resetPicture();
        }
        s = new StartedWindow(m, true);
        String word = s.getWord();
        juego = new Ahorcado(word);
        m.setWord(juego.getPalabraCifrada());
        
    }
    
    /**
     * It is invoked from the keyboard listener and need to modify the gui 
     * with the new letters.
     * @param l The character clicked.
     * @param evt The keyboard buttomn.
     */
    public static void reedLetter(String l, JButton evt) {
        boolean b = juego.siguientePaso(l.charAt(0));
        Color color;
        if (b)  color = Color.GREEN;
        else    color = Color.RED;
        
        m.mark(l, evt, color);
        m.setWord(juego.getPalabraCifrada());
        if(juego.finalJuego()) endGame();
    }
    
    /**
     * Starts the second game
     */
    public static void newGame() {
        m.resetKeyboard();
        play();
    }
    
    /**
     * It is called when the game is finished. It is in charge of show a message 
     * with the results.
     */
    public static void endGame() {
        String mensaje;
        ImageIcon icono;
        
        if(juego.ganador()) {
            mensaje = "¡Has ganado!";
            icono = new ImageIcon("/Users/pablojj/projects/Ahorcado/Ahorcado2.0/src/es/jj/view/data/ganador.png");
        } else {
            mensaje = "¡Has perdido!\nLa palabra era: " + juego.getPalabra();
            icono = new ImageIcon("/Users/pablojj/projects/Ahorcado/Ahorcado2.0/src/es/jj/view/data/perdedor.png");
        }
        
        m.showFinalMessageDialog(mensaje, icono);
        m.blockAllKeyboard();
    }
    
}
