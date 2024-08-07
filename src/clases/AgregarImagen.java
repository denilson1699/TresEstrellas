
   //***** METODO PARA AGREGAR IMAGENES ****
package clases;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AgregarImagen {
 
    public Icon agregarImagenBoton(String url,JButton boton){
        
        ImageIcon icon_imagen=new ImageIcon(getClass().getResource(url));
        int ancho=boton.getWidth();
        int alto=boton.getHeight();
        ImageIcon imagen=new ImageIcon(icon_imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return imagen;
    
    }
    
    public Icon agregarImagenLabel(String url,JLabel label){
        
        ImageIcon icon_imagen=new ImageIcon(getClass().getResource(url));
        int ancho=label.getWidth();
        int alto=label.getHeight();
        ImageIcon imagen=new ImageIcon(icon_imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return imagen;
    
    }
    
}
