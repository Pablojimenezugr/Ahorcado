package controlador;

import modelo.Juego;
import vista.Ventana;
import vista.palabrasAleatoriasGUI.VentanaInicio;

/**
 *
 * @author pablojj
 */
public class Controlador {
    
    private Ventana juegoGrafico;
    private VentanaInicio inicio;
    
    public Controlador() {
        
        
    }

    
    public boolean partida() {
        juegoGrafico = new Ventana();
        inicio = new VentanaInicio(juegoGrafico, true);
        
        var j = new Juego(inicio.obtenerPalabraParaJuego());
        juegoGrafico.setJuego(j);
        
        juegoGrafico.setVisible(true);
        return false;
    }
}
