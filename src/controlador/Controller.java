package controlador;

import modelo.Ahorcado;
import modelo.Diccionario;
import vista.VentanaInicio;
import vista.VentanaPrincipal;


/**
 *
 * @author Pablo Jj
 */
public class Controller {
    
    private Ahorcado juego;
    private Diccionario aleatoria;
    private VentanaPrincipal gui;
    private VentanaInicio inicio;
    
    public static void main(String[] args) {
        gui = new VentanaPrincipal();
        //inicio = new VentanaInicio(gui, true);
        
    }
}
