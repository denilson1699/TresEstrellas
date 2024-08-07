
package clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class CeldasTablaDatos extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {   
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    this.setForeground(Color.black);// color de letra
    this.setFont(new Font( "Verdana",0 ,11 ));// tipo, tamaño y negrita
    this.setHorizontalAlignment(LEFT);
    
    if(column==0){
    this.setHorizontalAlignment(CENTER);
    }
    if(column==1){
    this.setHorizontalAlignment(LEFT);
    }
    if(column==2){
    this.setHorizontalAlignment(CENTER);
    }
    if(column==3){
    this.setHorizontalAlignment(LEFT);
    }//nn
    if(column==4){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==5){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==6){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==7){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==8){
    this.setHorizontalAlignment(RIGHT);
    }
    if(column==9){
    this.setHorizontalAlignment(CENTER);
    }
    if(column==10){
    this.setHorizontalAlignment(CENTER);
    }
    return this;
    }
                
    
}
