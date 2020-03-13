package controlador;

import java.util.Scanner;
import modelo.Juego;

/**
 *
 * @author pablojj
 */
public class Controlador {
    
    private Juego juego;
    private static Scanner in;
    
    public Controlador(Juego j) {
        juego = j;
        in = new Scanner(System.in);
    }
    
    public void juega_terminal() {
        
        while(!juego.finalJuego()) {
            
            System.out.println(juego.getPosibles());
            
            System.out.println(juego.getPalabra_cifrada());
            
            System.out.print("~> ");
            char letra = in.nextLine().charAt(0);
            
            juego.sigPaso(letra);
            
            System.out.println( juego.getFigura() );
            
            
        }
        
       
        
    }
    
    
}
