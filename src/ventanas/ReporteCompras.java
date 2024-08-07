/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.ColorCeldaTabla;
import clases.ColorTablaVentas;
import clases.Conexion;
import clases.GestionEncabezadoTabla;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import static ventanas.ListaProductos.codigo_productoTabla;
import static ventanas.ListaUsuarios.dni_usuarioTabla;


import com.itextpdf.text.Document; 
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ventanas.Ventana_Administrador.jDesktop;
/**
 *
 * @author Usuario
 */
public class ReporteCompras extends javax.swing.JInternalFrame {

    // metodo para el color de celas
     ColorCeldaTabla MensajeroColorFila= new ColorCeldaTabla();
     //metodo para el color del encabezado de tabla
     GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla();
     ColorTablaVentas mensajeroColorVentas= new ColorTablaVentas();
     ///metodo para agregar radioboton a la tabla
    DefaultTableModel model1= new DefaultTableModel(){// conexion con la tabla y generar clic
    // este metodo permite que la tabla sea editada
          @Override
          public boolean isCellEditable(int row, int column) {
          if(column==2)
          { 
           return true;
          }else
          {
           return false;
          }
          }
         };
    
    DefaultTableModel model2= new DefaultTableModel();
   //Variables globales
        String RUC_ProveedorTabla, razon_ProveedorTabla,FechaActual,dia,mes,year;
        int eliminarFila;
        
    public ReporteCompras() {
        initComponents();
        setSize(1279, 553);
         // recuperamos de fecha de la venta
        Calendar calendario = Calendar.getInstance();
   
   
       dia=Integer.toString(calendario.get(Calendar.DATE));
       mes=Integer.toString(calendario.get(Calendar.MONTH) + 1);
       year= Integer.toString(calendario.get(Calendar.YEAR));
   
        FechaActual = dia+ "-"+mes+"-"+year;
        jLabel_fecha.setText(FechaActual);
  
        //************************ [TABLA DE PROVEEDORES] **************************
   
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(Table_Proveedores.getColumnCount());i++)
            {  Table_Proveedores.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);   }
            //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(Table_Proveedores.getColumnCount());i++)
            { Table_Proveedores.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}
                         
        try {
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Ruc_proveedor, Razon_proveedor from tabla_proveedores");
            ResultSet resul1=pst1.executeQuery();

            // AGREGAR ENCABEZADOS A LA TABLA
            Table_Proveedores = new JTable(model1);
            jScrollPane_t_provedores.setViewportView(Table_Proveedores);
            model1.addColumn("RUC");
            model1.addColumn("RAZON SOCIAL");

            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(Table_Proveedores.getColumnCount());i++)
            {
                Table_Proveedores.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }

            //AGREGAR COLOR A ENCABEZADO DE LA TABLA
            for(int i=0;i<(Table_Proveedores.getColumnCount());i++)
            {
                Table_Proveedores.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            /*  ////AGREGAR COLOR A celas con la clases gectionCelda
            for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroGestionCeldas);
            }*/
            Table_Proveedores.getColumnModel().getColumn(0).setPreferredWidth(150);//dimensionar columna 0
            Table_Proveedores.getColumnModel().getColumn(1).setPreferredWidth(300);//dimensionar columna 0
            Table_Proveedores.setRowHeight(18);

            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[2];
                for(int i=0;i<2;i++){
                    fila[i]=resul1.getObject(i+1);
                }
                model1.addRow(fila);
            }

            cn1.close();

           

        } catch (Exception e) {
            System.err.println("error en  rellenar de proveedores tabla :"+e);
        }
            
        boton_imprimir2.setVisible(false);
        Boton_EliminaFilar.setVisible(false);
        //crreamos metodo para el EVENTO de la TABLA
            Table_Proveedores.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    int fila_poin=Table_Proveedores.rowAtPoint(e.getPoint());
                    if(fila_poin>-1)
                    {
                        RUC_ProveedorTabla=(String)model1.getValueAt(fila_poin,0);
                        razon_ProveedorTabla=(String)model1.getValueAt(fila_poin,1);
                        // recuperamos metodo para  ostrar informacion de celda selecionada
                         jLabel_ruc.setText(RUC_ProveedorTabla);
                         jLabel_Razon.setText(razon_ProveedorTabla);
                        agregarDatosTabla(RUC_ProveedorTabla);
                        
                      boton_imprimir2.setVisible(true);
                     Boton_EliminaFilar.setVisible(true);
                    }
                }
            });   
      
  
            
       //************************** [TABLA DE PRODUCTOS A COMPRAR] ******************************
          
          //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(Tabla_CompraProductos.getColumnCount());i++)
            { Tabla_CompraProductos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}
        
             Tabla_CompraProductos.getColumnModel().getColumn(0).setPreferredWidth(50);//dimensionar columna 0
             Tabla_CompraProductos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             Tabla_CompraProductos.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             Tabla_CompraProductos.getColumnModel().getColumn(3).setPreferredWidth(30);//dimensionar columna 0
           Tabla_CompraProductos.setRowHeight(18);

    
             //crreamos metodo para el EVENTO de la TABLA
            Tabla_CompraProductos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    int fila_poin=Tabla_CompraProductos.rowAtPoint(e.getPoint());
                    if(fila_poin>-1)
                    {
                      eliminarFila=Tabla_CompraProductos.rowAtPoint(e.getPoint());
    
                    }
                }
            });   
    
  
            
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_grupo = new javax.swing.ButtonGroup();
        jScrollPane_t_Com_productos = new javax.swing.JScrollPane();
        Tabla_CompraProductos = new javax.swing.JTable();
        jScrollPane_t_provedores = new javax.swing.JScrollPane();
        Table_Proveedores = new javax.swing.JTable();
        Boton_EliminaFilar = new javax.swing.JButton();
        boton_imprimir2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Razon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_ruc = new javax.swing.JLabel();
        jLabel_fecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Orden de Compra");
        setPreferredSize(new java.awt.Dimension(1279, 567));

        Tabla_CompraProductos.setBackground(new java.awt.Color(0, 255, 0));
        Tabla_CompraProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tabla_CompraProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Producto", "Descripcion", "Cantidad", "Costo", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_CompraProductos.setToolTipText("");
        Tabla_CompraProductos.setDragEnabled(true);
        Tabla_CompraProductos.setGridColor(new java.awt.Color(255, 153, 0));
        Tabla_CompraProductos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane_t_Com_productos.setViewportView(Tabla_CompraProductos);

        Table_Proveedores.setBackground(new java.awt.Color(0, 255, 0));
        Table_Proveedores.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        Table_Proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC", "RAZON SOCIAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Proveedores.setDragEnabled(true);
        Table_Proveedores.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane_t_provedores.setViewportView(Table_Proveedores);
        if (Table_Proveedores.getColumnModel().getColumnCount() > 0) {
            Table_Proveedores.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        Boton_EliminaFilar.setBackground(new java.awt.Color(250, 150, 150));
        Boton_EliminaFilar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_EliminaFilar.setForeground(new java.awt.Color(0, 51, 51));
        Boton_EliminaFilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salir.png"))); // NOI18N
        Boton_EliminaFilar.setText("Eliminar");
        Boton_EliminaFilar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_EliminaFilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EliminaFilarActionPerformed(evt);
            }
        });

        boton_imprimir2.setBackground(new java.awt.Color(250, 150, 150));
        boton_imprimir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_imprimir2.setForeground(new java.awt.Color(0, 51, 51));
        boton_imprimir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Imprimir.png"))); // NOI18N
        boton_imprimir2.setText("Imprimir");
        boton_imprimir2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_imprimir2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        boton_imprimir2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        boton_imprimir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imprimir2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Proveedor:");

        jLabel_Razon.setForeground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Ruc:");

        jLabel_ruc.setForeground(new java.awt.Color(0, 102, 102));

        jLabel_fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fecha.setForeground(new java.awt.Color(0, 102, 102));
        jLabel_fecha.setText("-");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Razon, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane_t_provedores, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_t_Com_productos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_imprimir2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(550, 550, 550)
                        .addComponent(Boton_EliminaFilar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Razon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_fecha, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_t_provedores, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane_t_Com_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_imprimir2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_EliminaFilar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_EliminaFilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminaFilarActionPerformed
      
        if(eliminarFila>=0)
        { model2.removeRow(eliminarFila);  }
        else
        { JOptionPane.showMessageDialog(null,"No hay datos que eliminar"); }

      
     
        // eliminar todos los datos de una tabla
        /*     String pedidoEliminar;
        int EliminarTodaFila=jTable_DetalleVenta.getRowCount();
        System.out.println("eliminar todo; "+EliminarTodaFila);
        for(int i=EliminarTodaFila-1;i>=0;i--){
            TABLA.removeRow(i);

            //  codigo_productoTabla=(String)model.getValueAt(fila_poin,0);

        }*/

    }//GEN-LAST:event_Boton_EliminaFilarActionPerformed

    private void boton_imprimir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imprimir2ActionPerformed
        // evento que guarde e imprima la venta resumida
     
                int mensaje=JOptionPane.showConfirmDialog(null,"¿Imprimir Orden de Compra? :",null,JOptionPane.YES_NO_OPTION);
                if(mensaje==JOptionPane.YES_OPTION)
                {
                    //**********************************************************
                    Document OrdenCompra= new Document();
                    try {
                        String ruta=System.getProperty("user.home"); // ruta de consola
                        PdfWriter.getInstance(OrdenCompra,new FileOutputStream(ruta+"/Desktop/Orden Compra_"+jLabel_ruc.getText()+"_"+jLabel_fecha.getText()+".pdf"));
                        OrdenCompra.open();
                        //DISEÑO DE IMAGENES EN EL PDF
                        com.itextpdf.text.Image header= com.itextpdf.text.Image.getInstance("src/images/logo.png");// ingresar imagenes
                        header.scaleToFit(90, 80);// dimensiones de la imagen
                        header.setAlignment(Chunk.ALIGN_LEFT);// alinear la imagen en el pdf
                        OrdenCompra.add(header);// agregamos la imagen con sus especificaciones al docuemnto pdf

                        // ---DISEÑO DE PARRAFOS EN EL PDF---
                        Paragraph encabezado=new Paragraph();//objeto parrafo
                        encabezado.setAlignment(Paragraph.ALIGN_RIGHT);// alinear el parrafo
                        encabezado.setFont(FontFactory.getFont("Tahoma",16,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
                        encabezado.add("Venta de Abarrotes y Bebidas\n\n ");
                        encabezado.setFont(FontFactory.getFont("Tahoma",18,Font.BOLD, BaseColor.BLACK));
                        encabezado.add("Bodega Tres Estrelas\n ");
                        encabezado.setFont(FontFactory.getFont("Tahoma",35,Font.BOLD, BaseColor.ORANGE));//fuente,tamaño,negrita,color
                        encabezado.add( "________________\n\n");
                        encabezado.setFont(FontFactory.getFont("Tahoma",10,Font.ITALIC, BaseColor.BLACK));//fuente,tamaño,negrita,color
                        encabezado.add("DIREC: Villa María del Triunfo\n");// titulo del pdf
                        OrdenCompra.add(encabezado);// agregamos el parrafo al pdf

                        // ---DISEÑO DE PARRAFOS FECHAS  EN PDF---
                        Paragraph ParrafoFecha=new Paragraph();//objeto parrafo
                        ParrafoFecha.setAlignment(Paragraph.ALIGN_LEFT);// alinear el parrafo
                        ParrafoFecha.setFont(FontFactory.getFont("Tahoma",10,Font.CENTER_BASELINE, BaseColor.BLACK));//fuente,tamaño,negrita,color
                        ParrafoFecha.add(" Fecha: ");
                        ParrafoFecha.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK));
                        ParrafoFecha.add(FechaActual);
                        OrdenCompra.add(ParrafoFecha);// agregamos el parrafo al pdf

                        // ---DISEÑO DE PARRAFOS DATOS EMPRESA Y SERIE EN PDF---
                        Paragraph ParrafoDatos=new Paragraph();//objeto parrafo
                        ParrafoDatos.setAlignment(Paragraph.ALIGN_RIGHT);// alinear el parrafo
                        ParrafoDatos.setFont(FontFactory.getFont("Tahoma",12,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
                        ParrafoDatos.add(" RUC:  1007128889 \n" );
                        ParrafoDatos.setFont(FontFactory.getFont("Tahoma",12,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
                        ParrafoDatos.add(" ORDEN DE COMPRA \n" );
                        OrdenCompra.add(ParrafoDatos);// agregamos el parrafo al pdf

                        // ---DISEÑO DE PARRAFOS DATOS CLIENTE EN PDF---
                        Paragraph ParrafoDatosProveedor=new Paragraph();//objeto parrafo
                        ParrafoDatosProveedor.setAlignment(Paragraph.ALIGN_JUSTIFIED);// alinear el parrafo
                        ParrafoDatosProveedor.setFont(FontFactory.getFont("Tahoma",10,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
                        ParrafoDatosProveedor.add("Ruc   : ");
                        ParrafoDatosProveedor.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK));
                        ParrafoDatosProveedor.add(jLabel_ruc.getText()+" \n" );

                        ParrafoDatosProveedor.setFont(FontFactory.getFont("Tahoma",10,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
                        ParrafoDatosProveedor.add("Razon : ");
                        ParrafoDatosProveedor.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK));
                        ParrafoDatosProveedor.add(jLabel_Razon.getText().trim()+" \n\n\n" );
                         OrdenCompra.add(ParrafoDatosProveedor);// agregamos el parrafo al pdf

                        PdfPTable tabla1= new PdfPTable(3);//Creamos un ovjeto tabla indicando cantidad de columnas
                        tabla1.addCell("Cod. Producto");// cabezera de la tabla
                        tabla1.addCell("Descripción");//
                        tabla1.addCell("Cantidad");//

                        int Fila=Tabla_CompraProductos.getRowCount();
                        for(int i=Fila-1;i>=0;i--)
                        {
                            tabla1.addCell((String)model2.getValueAt(i,0));
                            tabla1.addCell((String)model2.getValueAt(i,1));
                            tabla1.addCell(model2.getValueAt(i,2).toString());
                        }
                        OrdenCompra.add(tabla1);   
                        OrdenCompra.close();
                        JOptionPane.showMessageDialog(null, "Orden de Compra Descargada");
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"Error al Descargar Orden de Compra ","",JOptionPane.ERROR_MESSAGE);
                        System.err.println("error al decargar orden de compra: "+e);
                    }
                }
            
        
    }//GEN-LAST:event_boton_imprimir2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ActualizarVentana();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_EliminaFilar;
    private javax.swing.JTable Tabla_CompraProductos;
    private javax.swing.JTable Table_Proveedores;
    private javax.swing.JButton boton_imprimir2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Razon;
    private javax.swing.JLabel jLabel_fecha;
    private javax.swing.JLabel jLabel_ruc;
    private javax.swing.JScrollPane jScrollPane_t_Com_productos;
    private javax.swing.JScrollPane jScrollPane_t_provedores;
    private javax.swing.ButtonGroup rb_grupo;
    // End of variables declaration//GEN-END:variables


 //******** METODO PARA RELLENAR TABLA ********
 public void agregarDatosTabla(String Rucproveedor){
    //GestionCeldas MensajeroGestionCeldas= new GestionCeldas();
    try {
            Connection cn1= Conexion.Conectar();
            System.out.println("ruc2:"+RUC_ProveedorTabla);
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,"
                    + " Stock_pro,Precio_pro from tabla_productos where Ruc_proveedor='"+Rucproveedor+"' and Stock_pro<=5");
            ResultSet resul1=pst1.executeQuery();
            // AGREGAR ENCABEZADOS A LA TABLA
            Tabla_CompraProductos = new JTable(model2);
            jScrollPane_t_Com_productos.setViewportView(Tabla_CompraProductos);
            model2.addColumn("Cod Producto");
            model2.addColumn("Descripción");
            model2.addColumn("Cantidad");
            model2.addColumn("Costo");
            model2.addColumn("Monto");
            
          //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(Tabla_CompraProductos.getColumnCount())-1;i++)
            {
                Tabla_CompraProductos.getColumnModel().getColumn(i).setCellRenderer(mensajeroColorVentas);
            }
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(Tabla_CompraProductos.getColumnCount());i++)
            { Tabla_CompraProductos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}
        
             Tabla_CompraProductos.getColumnModel().getColumn(0).setPreferredWidth(50);//dimensionar columna 0
             Tabla_CompraProductos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             Tabla_CompraProductos.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             Tabla_CompraProductos.getColumnModel().getColumn(3).setPreferredWidth(30);//dimensionar columna 0
          
             Tabla_CompraProductos.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[4];
                for(int i=0;i<4;i++){
                    fila[i]=resul1.getObject(i+1);
                }
                model2.addRow(fila);
            }
            
        
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla :"+e);
        }

}
 
 // ************** METODO PARA ACTUALIZAR VENTANA ****************
 public void ActualizarVentana(){
     this.setVisible(false);
     ReporteCompras mensajero= new ReporteCompras();
      jDesktop.add(mensajero);
        mensajero.setVisible(true);
      
 }
 
 public void LimpiarCeldas(){
     // eliminar todos los datos de una tabla
         String pedidoEliminar;
        int EliminarTodaFila=Tabla_CompraProductos.getRowCount();
       for(int i=EliminarTodaFila-1;i>=0;i--){
           model2.removeRow(i);
  
       }
 }
}
