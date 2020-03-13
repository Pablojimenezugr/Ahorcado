package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Pablo Jj
 */
public class Imagen extends JPanel {

    private final ImageIcon img;

    public Imagen(String url_img) {
        
        img = new ImageIcon(url_img);
        
        this.setSize(img.getIconWidth()/2, img.getIconHeight()/2);
    
    }

    @Override
    public void paint(Graphics g) {
        Dimension d = getSize();

        g.drawImage(img.getImage(), 0, 0, d.width, d.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
