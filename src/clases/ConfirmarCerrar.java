/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ConfirmarCerrar {
    // metodo para el confirmar el cierre 
        public void Cerrar(String Mensaje){
        String botones []={"Cerrar","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(null, Mensaje,"Confirmar",
                    0,0,null,botones,this);
        if(eleccion==JOptionPane.YES_OPTION)
          {
          System.exit(0);
          }
        else if(eleccion==JOptionPane.NO_OPTION)
          {
          Toolkit.getDefaultToolkit().beep();// enviar un sonido indicando que no se permite
          }
    }
}
