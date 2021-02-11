package es.jj.controller;

import es.jj.view.MainFrame;
import es.jj.view.StartedWindow;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Ahorcado;

/**
 *
 * @author Pablo Jj
 */
public class MainController {
    
    private static Ahorcado juego;
    private static MainFrame m;
    private static StartedWindow s;
    private static boolean firstTime = true;
    
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
    
    public static void reedLetter(String l, JButton evt) {
        System.out.println(l);
        boolean b = juego.siguientePaso(l.charAt(0));
        if (b)  m.correct(l, evt);
        else    m.incorrect(l, evt);
        
        m.setWord(juego.getPalabraCifrada());
        if(juego.finalJuego()) endGame();
    }
    
    public static void newGame() {
        m.resetKeyboard();
        play();
    }
    
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
        
        JOptionPane.showMessageDialog(
            m,
            mensaje,
            "Fin de la partida",
            JOptionPane.INFORMATION_MESSAGE,
            icono
        );
        
        m.blockAllKeyboard();
    }
    
}
