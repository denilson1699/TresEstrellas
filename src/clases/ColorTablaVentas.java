
package clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ColorTablaVentas extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {   
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if(evularPar(row)){// enviamos comp parametro la fila de la tabla
    this.setBackground(new Color(245,245,255));//color de fondo new Color (51,255,102)
    }
    else{
    this.setBackground(new Color(255,250,255));// Color de fondo new Color(204,255,204)
    }
    this.setForeground(Color.black);// color de letra
    this.setFont(new Font( "Verdana",0 ,11 ));// tipo, tamaño y negrita
    this.setHorizontalAlignment(LEFT);
    
    if(column==3){
    this.setHorizontalAlignment(CENTER);
    }
    if(column==4){
    this.setHorizontalAlignment(CENTER);
    }
    if(column==5){
    this.setHorizontalAlignment(LEFT);
     
    }
    return this;
    
    }
    
    public boolean evularPar(int numero){
        return (numero%2==0);
                
    }
                
    
}
