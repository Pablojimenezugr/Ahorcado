package es.jj.controller;

import es.jj.view.KeyboardEvent;
import es.jj.view.MainFrame;
import es.jj.view.StartedWindow;
import javax.swing.JButton;
import model.Ahorcado;

/**
 *
 * @author Pablo Jj
 */
public class MainController {
    
    private static Ahorcado juego;
    private static MainFrame m;
    private static StartedWindow s;
    
    public static void play() {
        m = new MainFrame();
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
    }
    
    public static void newGame() {
        m.resetKeyboard();
        play();
    }
    
}
