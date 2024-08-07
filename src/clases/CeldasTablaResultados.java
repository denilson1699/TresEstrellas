
package clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CeldasTablaResultados extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {   
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    this.setForeground(Color.black);// color de letra
    this.setFont(new Font( "Verdana",0 ,11 ));// tipo, tamaño y negrita
    this.setHorizontalAlignment(RIGHT);
    
    if(column==0){
    this.setHorizontalAlignment((int) LEFT_ALIGNMENT);
    }
    if(column==1){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==2){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==3){
    this.setHorizontalAlignment(RIGHT);
    }//nn
    if(column==4){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==5){
    this.setHorizontalAlignment(RIGHT);
    }
    return this;
    }
                
    
}
