/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.ColorTablaVentas;
import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static ventanas.Login.Apellidos;
import static ventanas.Login.Cargo;
import static ventanas.Login.DNI;
import static ventanas.Login.Nombre;

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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Usuario
 */
public class ProcesoVentasBoleta extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProcesoVentasBoleta
     */
     int contador=0; 
     String FechaActual,codigo_listPedido,codigo_productolist,cantidad_listPedido,dia, mes, year; 
     int stockTablaProductos; 
     int eliminarFila;
     float precio, monto = 0; int cantidad;
     
        ColorTablaVentas mensajeroColorVentas= new ColorTablaVentas();
    DefaultTableModel TABLA= new DefaultTableModel();
    public ProcesoVentasBoleta() {
        initComponents();
    // enviamos los datos a los label
    jLabel_NombreUser.setText(Nombre.toLowerCase()+" "+Apellidos.toLowerCase());
    jLabel_CargoUser.setText(Cargo.toLowerCase()); ;
    jLabel_DniUser.setText(DNI.toLowerCase());

    // recuperamos de fecha de la venta
   Calendar calendario = Calendar.getInstance();
   
    dia=Integer.toString(calendario.get(Calendar.DATE));
    mes=Integer.toString(calendario.get(Calendar.MONTH) + 1);
    year= Integer.toString(calendario.get(Calendar.YEAR));
   
   FechaActual = dia+ "-"+mes+"-"+year;
  
   jLabel_dia.setText(dia+" /");
   jLabel_mes.setText(mes+" /");
   jLabel_year.setText(year);
  
    // titulos y dimensiones d ela tabla pedidos
    TABLA.addColumn("CANT");
    TABLA.addColumn("DESCRIPCIÓN");
    TABLA.addColumn("P.U");
    TABLA.addColumn("IMPORTE");
    TABLA.addColumn("Cod.Pedido");
    TABLA.addColumn("Cod.Producto");
    this.jTable_DetalleVenta.setModel(TABLA);
    jTable_DetalleVenta.getColumnModel().getColumn(0).setMaxWidth(40);//dimensionar columna 0
    jTable_DetalleVenta.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
    jTable_DetalleVenta.getColumnModel().getColumn(2).setPreferredWidth(20);//dimensionar columna 0
    jTable_DetalleVenta.getColumnModel().getColumn(3).setPreferredWidth(15);//dimensionar columna 0
    jTable_DetalleVenta.getColumnModel().getColumn(4).setPreferredWidth(15);//dimensionar columna 0
    jTable_DetalleVenta.getColumnModel().getColumn(5).setPreferredWidth(15);//dimensionar columna 0
    jTable_DetalleVenta.setRowHeight(16);
 
    txt_codigoPro.requestFocus(true);

    // evento a la tablk de pedidos
    jTable_DetalleVenta.addMouseListener(new MouseAdapter() {
    @Override
     public void mouseClicked(MouseEvent e)
     {
     eliminarFila=jTable_DetalleVenta.rowAtPoint(e.getPoint());
     cantidad_listPedido=(String)TABLA.getValueAt(eliminarFila,0);
     codigo_listPedido=(String)TABLA.getValueAt(eliminarFila,4);
     codigo_productolist=(String)TABLA.getValueAt(eliminarFila,5);
     }  
    });
    
    GenerarSerieBoleta();
  
        
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel_year = new javax.swing.JLabel();
        jLabel_mes = new javax.swing.JLabel();
        jLabel_dia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_numeroVenta = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_direcCliente = new javax.swing.JTextField();
        txt_nombreCliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_dniCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DetalleVenta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_apellidoCliente = new javax.swing.JTextField();
        txt_totalPagar = new javax.swing.JTextField();
        Boton_EliminaFilar = new javax.swing.JButton();
        Boton_BuscarClientes = new javax.swing.JButton();
        boton_Calcular_Total = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel_CargoUser = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel_NombreUser = new javax.swing.JLabel();
        jLabel_DniUser = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel_formato = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel_precio = new javax.swing.JLabel();
        txt_codigoPro = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        boton_buscar = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel_monto = new javax.swing.JLabel();
        jLabel_descripcion = new javax.swing.JLabel();
        jLabel_categoria = new javax.swing.JLabel();
        boton_imprimir = new javax.swing.JButton();
        boton_CaalcularMonto = new javax.swing.JButton();
        boton_Cancelar = new javax.swing.JButton();
        boton_nuevo = new javax.swing.JButton();
        Stock = new javax.swing.JLabel();
        jLabel_stock = new javax.swing.JLabel();
        boton_Agregar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Boletas");

        jScrollPane2.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setRequestFocusEnabled(false);
        jScrollPane2.setWheelScrollingEnabled(false);

        jPanel4.setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Venta de Abarrotes y Bebidas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("\"Bodega Tres Estrelas\"");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Villa María del Triunfo");

        jLabel15.setText("1007128889");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Ruc:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Día");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Mes");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Año");

        jLabel_year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_year.setText("0000");

        jLabel_mes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_mes.setText("00");

        jLabel_dia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_dia.setText("00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BOLETA DE VENTA");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("N°.");

        jLabel_numeroVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_numeroVenta.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_numeroVenta.setText("0000001");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Nombre:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 51));
        jLabel18.setText("Direccion:");

        txt_direcCliente.setBackground(new java.awt.Color(255, 255, 153));
        txt_direcCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_direcCliente.setForeground(new java.awt.Color(0, 0, 153));
        txt_direcCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txt_nombreCliente.setBackground(new java.awt.Color(255, 255, 153));
        txt_nombreCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombreCliente.setForeground(new java.awt.Color(0, 0, 153));
        txt_nombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 51));
        jLabel19.setText("Doc. Ident:");

        txt_dniCliente.setBackground(new java.awt.Color(255, 255, 153));
        txt_dniCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_dniCliente.setForeground(new java.awt.Color(204, 0, 0));
        txt_dniCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dniCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTable_DetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CANT.", "DESCRIPCIÓN", "P.U.", "IMPORTE"
            }
        ));
        jTable_DetalleVenta.setRowHeight(18);
        jTable_DetalleVenta.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(jTable_DetalleVenta);
        if (jTable_DetalleVenta.getColumnModel().getColumnCount() > 0) {
            jTable_DetalleVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_DetalleVenta.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable_DetalleVenta.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable_DetalleVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable_DetalleVenta.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Total:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("Apellidos:");

        txt_apellidoCliente.setBackground(new java.awt.Color(255, 255, 153));
        txt_apellidoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellidoCliente.setForeground(new java.awt.Color(0, 0, 153));
        txt_apellidoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txt_totalPagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_totalPagar.setForeground(new java.awt.Color(51, 51, 0));
        txt_totalPagar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        Boton_BuscarClientes.setBackground(new java.awt.Color(204, 204, 204));
        Boton_BuscarClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_BuscarClientes.setForeground(new java.awt.Color(0, 51, 51));
        Boton_BuscarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        Boton_BuscarClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_BuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_BuscarClientesActionPerformed(evt);
            }
        });

        boton_Calcular_Total.setBackground(new java.awt.Color(255, 153, 0));
        boton_Calcular_Total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_Calcular_Total.setForeground(new java.awt.Color(0, 51, 51));
        boton_Calcular_Total.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calcular.png"))); // NOI18N
        boton_Calcular_Total.setText("Calcular");
        boton_Calcular_Total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Calcular_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Calcular_TotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Boton_EliminaFilar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(boton_Calcular_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_totalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel_dia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_mes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel_year)))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel9)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel_numeroVenta))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(Boton_BuscarClientes)
                                        .addGap(136, 136, 136))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_apellidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                            .addComponent(txt_direcCliente))))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_numeroVenta)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txt_dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Boton_BuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_apellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_direcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_totalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_EliminaFilar)
                            .addComponent(boton_Calcular_Total))
                        .addContainerGap(610, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_year)
                            .addComponent(jLabel_mes)
                            .addComponent(jLabel_dia))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane2.setViewportView(jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel_CargoUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CargoUser.setForeground(new java.awt.Color(0, 102, 102));
        jLabel_CargoUser.setText("-");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 204, 204));
        jLabel16.setText("Cargo:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 204, 204));
        jLabel21.setText("DNI:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 204, 204));
        jLabel23.setText("Nombre:");

        jLabel_NombreUser.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel_NombreUser.setForeground(new java.awt.Color(0, 102, 102));
        jLabel_NombreUser.setText("-");

        jLabel_DniUser.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel_DniUser.setForeground(new java.awt.Color(0, 102, 102));
        jLabel_DniUser.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_NombreUser, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                    .addComponent(jLabel16)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_CargoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_DniUser, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel_NombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel_DniUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel_CargoUser))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("Codigo:");

        jLabel_formato.setForeground(new java.awt.Color(0, 0, 153));
        jLabel_formato.setText("-");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("Precio s/.");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 51));
        jLabel25.setText("Formato:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 0));
        jLabel26.setText("Cantidad:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 51));
        jLabel27.setText("Categoria:");

        jLabel_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_precio.setForeground(new java.awt.Color(0, 0, 153));
        jLabel_precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_precio.setText("00.00");

        txt_codigoPro.setBackground(new java.awt.Color(255, 255, 153));
        txt_codigoPro.setForeground(new java.awt.Color(153, 0, 0));
        txt_codigoPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txt_cantidad.setBackground(new java.awt.Color(255, 255, 102));
        txt_cantidad.setForeground(new java.awt.Color(0, 0, 153));
        txt_cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad.setText("1");
        txt_cantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 0));
        jLabel29.setText("Monto:");

        boton_buscar.setBackground(new java.awt.Color(204, 204, 204));
        boton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        boton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscarActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 51, 51));
        jLabel30.setText("Descripción:");

        jLabel_monto.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel_monto.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_monto.setText("00.00");

        jLabel_descripcion.setForeground(new java.awt.Color(0, 0, 153));
        jLabel_descripcion.setText("-");

        jLabel_categoria.setForeground(new java.awt.Color(0, 0, 153));
        jLabel_categoria.setText("-");

        boton_imprimir.setBackground(new java.awt.Color(255, 153, 0));
        boton_imprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_imprimir.setForeground(new java.awt.Color(255, 255, 255));
        boton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Imprimir.png"))); // NOI18N
        boton_imprimir.setText("Guardar/Imprimir");
        boton_imprimir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imprimirActionPerformed(evt);
            }
        });

        boton_CaalcularMonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calcular.png"))); // NOI18N
        boton_CaalcularMonto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_CaalcularMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_CaalcularMontoActionPerformed(evt);
            }
        });

        boton_Cancelar.setBackground(new java.awt.Color(255, 153, 0));
        boton_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        boton_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelarProceso.png"))); // NOI18N
        boton_Cancelar.setText("Cancelar");
        boton_Cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_Cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_CancelarActionPerformed(evt);
            }
        });

        boton_nuevo.setBackground(new java.awt.Color(255, 153, 0));
        boton_nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        boton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevo2.png"))); // NOI18N
        boton_nuevo.setText("Nuevo");
        boton_nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_nuevoActionPerformed(evt);
            }
        });

        Stock.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Stock.setForeground(new java.awt.Color(0, 51, 51));
        Stock.setText("Stock");

        jLabel_stock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_stock.setForeground(new java.awt.Color(0, 0, 153));
        jLabel_stock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_stock.setText("00.00");

        boton_Agregar.setBackground(new java.awt.Color(0, 102, 102));
        boton_Agregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        boton_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Agregar.png"))); // NOI18N
        boton_Agregar.setText("Agregar");
        boton_Agregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel_formato, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(27, 27, 27)
                                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(boton_CaalcularMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel29)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel_monto))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(Stock)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(boton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(boton_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(boton_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(3, 3, 3)
                                .addComponent(txt_codigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(boton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txt_codigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel_descripcion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel_categoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel_formato))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_precio)
                            .addComponent(jLabel_stock)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(Stock))))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_CaalcularMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel_monto)))
                    .addComponent(boton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_imprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscarActionPerformed
       String valorBscado = (txt_codigoPro.getText().trim()).toUpperCase();
  
        try {
         Connection cn= Conexion.Conectar();
         PreparedStatement pst= cn.prepareStatement("select Codigo_pro, Descripcion_pro,"
           + " Precio_pro,Stock_pro, Categoria_pro,Formato_pro from tabla_productos where Codigo_pro='"+valorBscado+"'");
         ResultSet resul=pst.executeQuery(); 
         if(resul.next()){
           stockTablaProductos=Integer.parseInt(resul.getString("Stock_pro"));
           
           txt_codigoPro.setText(resul.getString("Codigo_pro"));
           jLabel_descripcion.setText(resul.getString("Descripcion_pro"));
           jLabel_precio.setText(resul.getString("Precio_pro"));
           jLabel_stock.setText(resul.getString("Stock_pro"));
           jLabel_categoria.setText(resul.getString("Categoria_pro"));
           jLabel_formato.setText(resul.getString("Formato_pro"));

           // pintar el stok geun la cantidad dispoible
          if(stockTablaProductos>=15){
              jLabel_stock.setForeground(new Color(0,153,51 ));
           }
          if(stockTablaProductos>=5 &&stockTablaProductos<=14){
              jLabel_stock.setForeground(new Color(0,153,153));
           }
          if(stockTablaProductos>=0 &&stockTablaProductos<=4){
              jLabel_stock.setForeground(Color.RED);
           }
           cn.close();
          }else{
              JOptionPane.showMessageDialog(null, "codigo ("+valorBscado+") no encontrado","ERROR!!!", JOptionPane.WARNING_MESSAGE);
              txt_codigoPro.requestFocus();
              
         }
        }catch (Exception e) {
            System.err.println("error al recuperar productos de la tabla: "+e);
            }

    }//GEN-LAST:event_boton_buscarActionPerformed

    private void boton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nuevoActionPerformed
        //limpiar campos de info productos   
        txt_codigoPro.setText("");
           jLabel_descripcion.setText("");
           jLabel_precio.setText("");
           jLabel_stock.setText("");
           jLabel_categoria.setText("");
           jLabel_formato.setText("");
           txt_cantidad.setText("");
            txt_codigoPro.setBackground(new Color(255,255,153));
            txt_cantidad.setBackground(new Color(255,255,153));
            txt_dniCliente.setBackground(new Color(255,255,153));
           jLabel_monto.setText("00.00");
           // limpiar campos cliente
           txt_apellidoCliente.setText("");
           txt_direcCliente.setText("");
           txt_dniCliente.setText("");
           txt_nombreCliente.setText("");
           txt_totalPagar.setText("");
           
           
    }//GEN-LAST:event_boton_nuevoActionPerformed

    private void boton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_CancelarActionPerformed
        int mensaje= JOptionPane.showConfirmDialog(null,"Desea Cancelar Venta","-                        Confirmar     -",JOptionPane.WARNING_MESSAGE);
        if(mensaje==JOptionPane.YES_NO_OPTION){
         LimpiarCampos();
         
            
        }
    }//GEN-LAST:event_boton_CancelarActionPerformed

    private void boton_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AgregarActionPerformed
     
        
      String  codigoPro,descrip,precio1,monto1, dniCliente; int cantidad1, stokRestante = 0, id_ventaIndividual= 0;
      cantidad1=Integer.parseInt(txt_cantidad.getText().trim());
      descrip=jLabel_descripcion.getText();
      precio1=jLabel_precio.getText();
      monto1=jLabel_monto.getText();
      codigoPro=txt_codigoPro.getText().trim();
      dniCliente=txt_dniCliente.getText().trim();
      
      if(codigoPro.equals("")){
        JOptionPane.showMessageDialog(null,"falta ingresar codido producto");
        txt_codigoPro.requestFocus();
        txt_codigoPro.setBackground(new Color(250,150,150));
        contador++;
        }
      if  (txt_cantidad.getText().trim().equals("")){
        JOptionPane.showMessageDialog(null,"falta ingresar cantidad de producto");
        txt_cantidad.requestFocus();
        txt_cantidad.setBackground(new Color(250,150,150));
        contador++;
        }
      if(monto1.equals("00.00")){
        JOptionPane.showMessageDialog(null,"falta calcular monto, precione calcular");
        jLabel_monto.setForeground(Color.red);
        contador++;
        }
        if(dniCliente.equals("")){
        JOptionPane.showMessageDialog(null,"falta ingresar datos del cliente");
        txt_dniCliente.requestFocus();
        txt_dniCliente.setBackground(new Color(250,150,150));
        contador++;
        }
      
        // validar la disponibilidad de stok
        if(cantidad1<=stockTablaProductos){
        stokRestante=stockTablaProductos-cantidad1;
        jLabel_stock.setText(String.valueOf(stokRestante));
        }else{
        JOptionPane.showMessageDialog(null,"Stok no Suficiente");
        txt_cantidad.requestFocus();
        txt_cantidad.setBackground(new Color(250,150,150));
        contador++;
        }
        

      // Agremamos cada uno de los pedido a la tabla de lista_venta_Individual
           try 
                 {
                 Connection cn1=Conexion.Conectar();
                 PreparedStatement pst1= cn1.prepareStatement("insert into detalle_pedidos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                 pst1.setInt(1,0);
                 pst1.setString(2,dniCliente );
                 pst1.setString(3,codigoPro );
                 pst1.setString(4,"BOLETA" );
                 pst1.setString(5,"" );
                 pst1.setString(6,jLabel_numeroVenta.getText() );
                 pst1.setString(7,descrip);
                 pst1.setString(8,String.valueOf(cantidad1));
                 pst1.setString(9,precio1);
                 pst1.setString(10,monto1);
                 pst1.setString(11,dia);
                 pst1.setString(12,mes);
                 pst1.setString(13,year);
                 pst1.setString(14,jLabel_DniUser.getText());
                 pst1.setString(15,dia+"/"+mes+"/"+year);
                 pst1.executeUpdate();
                 cn1.close();
                 }
           catch (Exception e) 
                 {
                 JOptionPane.showMessageDialog(null, "falla al guardar pedido","",JOptionPane.ERROR_MESSAGE);
                 System.err.println("error al guardar pedido individual: "+e);
                 }
           
           
       //agregamos id de la detalle venta individual
       try {
            Connection cnx= Conexion.Conectar();//"select count(*) from listventaindivid "
            PreparedStatement pstx= cnx.prepareStatement("SELECT MAX(Id_Detalle_Pedidos ) AS Id_Detalle_Pedidos  FROM detalle_pedidos");
            ResultSet resulx=pstx.executeQuery();// recupéramos el ultimo dato agregado en la tabal de listaVentaIndividual
           if(resulx.next()){
             id_ventaIndividual= Integer.parseInt(resulx.getString(1));
            cnx.close();
            }
        }catch (Exception e) 
              { System.err.println("error en recuperar id venta individual :"+e);}

    
       //Agregar pedido a la tabla 
      if(contador==0)
        {
                     
           String [] agregarfila= new String[6];
            agregarfila[0]=String.valueOf(cantidad);
            agregarfila[1]= descrip;
            agregarfila[2]= precio1;
            agregarfila[3]= monto1;
            agregarfila[4]= String.valueOf(id_ventaIndividual);
            agregarfila[5]= codigoPro;
            TABLA.addRow(agregarfila);
               //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTable_DetalleVenta.getColumnCount());i++)
            {
                jTable_DetalleVenta.getColumnModel().getColumn(i).setCellRenderer(mensajeroColorVentas);
            }
       
        }else{
            contador=0;
        }
      
      
     // reducimos la cantidad de estok disponible en la tabal productos
        try {// actualizar datos en la bse de datos
            Connection cn3=Conexion.Conectar();
            PreparedStatement pst3 = cn3.prepareStatement("update tabla_productos set Stock_pro=? where Codigo_pro ='"+codigoPro+"'");
            pst3.setString(1,String.valueOf(stokRestante));
            pst3.executeUpdate();
            cn3.close();
            
            }catch (SQLException ex) 
            {
            JOptionPane.showMessageDialog(null,"no se pudo actualizar Stok","",JOptionPane.ERROR_MESSAGE);
            System.err.println("error al actualizar stok de producto: "+ex);
            }

        // actualizar stok en la intefas
        ActualizarStok();
        txt_cantidad.setText("");
    }//GEN-LAST:event_boton_AgregarActionPerformed

    private void Boton_EliminaFilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminaFilarActionPerformed
    if(eliminarFila>=0)
    { TABLA.removeRow(eliminarFila);  }
    else
    { JOptionPane.showMessageDialog(null,"No hay datos que eliminar"); }    
    
    
 // eliminar datos de la base de datos
     try 
       {
       Connection cn1= Conexion.Conectar();
       PreparedStatement pst= cn1.prepareStatement("delete from detalle_pedidos where Id_Detalle_Pedidos=?");
       pst.setString(1,codigo_listPedido);
       pst.executeUpdate();
       cn1.close();  
       JOptionPane.showMessageDialog(null, "Pedido Eliminada");
       } 
    catch (Exception e)
       {
       JOptionPane.showMessageDialog(null, "no se elimino de la Base Datos","",JOptionPane.ERROR_MESSAGE);
       System.err.println("error al eliminar pedido :"+e);
       } 
     
     
     // devolver la cantidad de stok del producto agregado
     // recuperamos stok de la tabla producto
     int devolverStok = 0;
    try {
         Connection cn= Conexion.Conectar();
         PreparedStatement pst= cn.prepareStatement("select Stock_pro from tabla_productos where Codigo_pro ='"+codigo_productolist+"'");
         ResultSet resul=pst.executeQuery(); 
         if(resul.next()){
         devolverStok=Integer.parseInt(resul.getString("Stock_pro"));
         cn.close();
         } 
        }
    catch (Exception e) {  System.err.println("error al recuperar stok actualizado del producto: "+e);   }

            
        // devolvemos la cantidad retirada anteriormente
        int CANT= (Integer.parseInt(cantidad_listPedido)+devolverStok);
    try {
         Connection cnN= Conexion.Conectar();
         PreparedStatement pstN= cnN.prepareStatement("update tabla_productos set Stock_pro=?  where Codigo_pro='"+codigo_productolist+"'");
         pstN.setString(1,String.valueOf(CANT));
         pstN.executeUpdate();
         cnN.close();
         }
    catch (SQLException ex) 
         {
         System.err.println("error al actualizar cantidad del producto: "+ex);
         }

  
     // eliminar todos los datos de una tabla
     /*     String pedidoEliminar;
        int EliminarTodaFila=jTable_DetalleVenta.getRowCount();
        System.out.println("eliminar todo; "+EliminarTodaFila);
       for(int i=EliminarTodaFila-1;i>=0;i--){
           TABLA.removeRow(i);
           
          //  codigo_productoTabla=(String)model.getValueAt(fila_poin,0);
         
       }*/
     
     
      
    }//GEN-LAST:event_Boton_EliminaFilarActionPerformed

    private void boton_CaalcularMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_CaalcularMontoActionPerformed
 
        precio =Float.parseFloat(jLabel_precio.getText());
        cantidad=Integer.parseInt(txt_cantidad.getText().trim());
        monto=cantidad*precio;
        
        if(txt_cantidad.getText().equals(""))
        {
             JOptionPane.showMessageDialog(null, "Falta Ingresar Cantidad");
        }
        else
        {
         jLabel_monto.setText(String.valueOf(monto));
    
        }
    }//GEN-LAST:event_boton_CaalcularMontoActionPerformed

    private void boton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imprimirActionPerformed
    // evento que guarde e imprima la venta resumida 
    int contado=0;
    String numeroVenta,doc_Ident_cliente,dni_empleado, total_venta;
    numeroVenta=jLabel_numeroVenta.getText();
    doc_Ident_cliente=txt_dniCliente.getText().trim();
    total_venta=txt_totalPagar.getText();
    dni_empleado=jLabel_DniUser.getText();
    if(total_venta.equals("")){
        txt_totalPagar.setBackground(new Color(250,150,150));
        JOptionPane.showMessageDialog(null, "¡¡Falta Calcular TOTAL!!");
        contado++;
    }    
    if(doc_Ident_cliente.equals("")){
        txt_dniCliente.setBackground(new Color(250,150,150));
        txt_dniCliente.requestFocus();
        JOptionPane.showMessageDialog(null,"¡¡Falta Ingresar Datos del Cliente!!");
        contado++;
    }
    if(contado==0){
      try {
      Connection cn=Conexion.Conectar();
      PreparedStatement pst= cn.prepareStatement("insert into tabla_venta_boletas values (?,?,?,?,?,?,?,?)");
      pst.setInt(1,0); 
      pst.setString(2,numeroVenta  );
      pst.setString(3,doc_Ident_cliente );
      pst.setString(4,total_venta);
      pst.setString(5,dia);
      pst.setString(6,mes);
      pst.setString(7,year);
      pst.setString(8,dni_empleado);
      pst.executeUpdate();
      cn.close();
      int mensaje=JOptionPane.showConfirmDialog(null,"Venta Registrada, ¿Imprimir? :",null,JOptionPane.YES_NO_OPTION);
        if(mensaje==JOptionPane.YES_OPTION)
        {
        //**********************************************************
         Document BoletaVenta= new Document();
            try {
            String ruta=System.getProperty("user.home"); // ruta de consola  
            PdfWriter.getInstance(BoletaVenta,new FileOutputStream(ruta+"/Desktop/Bv "+FechaActual+" "+txt_nombreCliente.getText().trim()+".pdf"));
            BoletaVenta.open();
            //DISEÑO DE IMAGENES EN EL PDF
            com.itextpdf.text.Image header= com.itextpdf.text.Image.getInstance("src/images/logo.png");// ingresar imagenes
            header.scaleToFit(90, 80);// dimensiones de la imagen
            header.setAlignment(Chunk.ALIGN_LEFT);// alinear la imagen en el pdf
            BoletaVenta.add(header);// agregamos la imagen con sus especificaciones al docuemnto pdf
            
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
            BoletaVenta.add(encabezado);// agregamos el parrafo al pdf 
  
            // ---DISEÑO DE PARRAFOS FECHAS  EN PDF---
            Paragraph ParrafoFecha=new Paragraph();//objeto parrafo
            ParrafoFecha.setAlignment(Paragraph.ALIGN_LEFT);// alinear el parrafo
            ParrafoFecha.setFont(FontFactory.getFont("Tahoma",10,Font.CENTER_BASELINE, BaseColor.BLACK));//fuente,tamaño,negrita,color
            ParrafoFecha.add(" Día  Mes  Año\n ");
            ParrafoFecha.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK)); 
            ParrafoFecha.add(FechaActual); 
            BoletaVenta.add(ParrafoFecha);// agregamos el parrafo al pdf 
  
            // ---DISEÑO DE PARRAFOS DATOS EMPRESA Y SERIE EN PDF---
            Paragraph ParrafoDatos=new Paragraph();//objeto parrafo
            ParrafoDatos.setAlignment(Paragraph.ALIGN_RIGHT);// alinear el parrafo
            ParrafoDatos.setFont(FontFactory.getFont("Tahoma",12,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
            ParrafoDatos.add(" RUC:  1007128889 \n" );
            ParrafoDatos.setFont(FontFactory.getFont("Tahoma",12,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
            ParrafoDatos.add(" BOLETA DE VENTA \n" );
            ParrafoDatos.setFont(FontFactory.getFont("Tahoma",14,Font.ROMAN_BASELINE, BaseColor.RED)); 
            ParrafoDatos.add("Nro. "+jLabel_numeroVenta.getText()); 
            BoletaVenta.add(ParrafoDatos);// agregamos el parrafo al pdf 
  

            // ---DISEÑO DE PARRAFOS DATOS CLIENTE EN PDF---
            Paragraph ParrafoDatosCliente=new Paragraph();//objeto parrafo
            ParrafoDatosCliente.setAlignment(Paragraph.ALIGN_JUSTIFIED);// alinear el parrafo
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",10,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
            ParrafoDatosCliente.add("Doc. Ident : ");
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK));
            ParrafoDatosCliente.add(txt_dniCliente.getText().trim()+" \n" );
            
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",10,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
            ParrafoDatosCliente.add("Nombre     : ");
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK));
            ParrafoDatosCliente.add(txt_nombreCliente.getText().trim()+" \n" );
            
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",10,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
            ParrafoDatosCliente.add("Apellidos  : ");
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK));
            ParrafoDatosCliente.add(txt_apellidoCliente.getText().trim()+" \n" );
            
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",10,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
            ParrafoDatosCliente.add("Direccioón  : ");
            ParrafoDatosCliente.setFont(FontFactory.getFont("Tahoma",12,Font.ROMAN_BASELINE, BaseColor.BLACK));
            ParrafoDatosCliente.add(txt_direcCliente.getText().trim()+" \n\n\n\n" );
            
            BoletaVenta.add(ParrafoDatosCliente);// agregamos el parrafo al pdf 
  
             PdfPTable tabla1= new PdfPTable(4);//Creamos un ovjeto tabla indicando cantidad de columnas
             tabla1.addCell("Cant.");// cabezera de la tabla
             tabla1.addCell("Descripción");//
             tabla1.addCell("P.U");// 
             tabla1.addCell("IMPORTE");
             
              int Fila=jTable_DetalleVenta.getRowCount();
             for(int i=Fila-1;i>=0;i--)
             {
              tabla1.addCell((String)TABLA.getValueAt(i,0));
              tabla1.addCell((String)TABLA.getValueAt(i,1));
              tabla1.addCell((String)TABLA.getValueAt(i,2));
              tabla1.addCell((String)TABLA.getValueAt(i,3));
             }           
             BoletaVenta.add(tabla1);
             
            Paragraph total =new Paragraph();//objeto parrafo
            total.setAlignment(Paragraph.ALIGN_JUSTIFIED);// alinear el parrafo
            total.setFont(FontFactory.getFont("Tahoma",10,Font.BOLD, BaseColor.BLACK));//fuente,tamaño,negrita,color
            total.add(".                           "
                    + "                                "
                    + "                                "
                    + "                                 "
                    + "               TOTAL: ");
            total.setFont(FontFactory.getFont("Tahoma",12,Font.BOLD, BaseColor.BLACK));
            total.add(txt_totalPagar.getText().trim()+" \n\n" );
            BoletaVenta.add(total);// agregamos el parrafo al pdf 
            
            Paragraph Despedida =new Paragraph();//objeto parrafo
            Despedida.setAlignment(Paragraph.ALIGN_CENTER);// alinear el parrafo
            Despedida.setFont(FontFactory.getFont("Tahoma",12,Font.BOLD, BaseColor.ORANGE));//fuente,tamaño,negrita,color
            Despedida.add(" Gracias Por Su Compra¡¡ Vuelva Pronto ");
            BoletaVenta.add(Despedida);// agregamos el parrafo al pdf 
             
            BoletaVenta.close();
            JOptionPane.showMessageDialog(null, "Boleta Descargada");
           }
           catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al Descargar Boleta N."+jLabel_numeroVenta.getText()," ",JOptionPane.ERROR_MESSAGE);
            System.err.println("error al decargar boleta de venta:"+e);
            }
            LimpiarCampos();
         
                       //**************************************************************
          }
        else{
            LimpiarCampos();
            }
            
        }catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null, "no se pudo registrar la venta, contacte al administrador","",JOptionPane.ERROR_MESSAGE);
        System.err.println("error al registrar nuevo venta: "+e);
        }
    }

    }//GEN-LAST:event_boton_imprimirActionPerformed

    private void Boton_BuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BuscarClientesActionPerformed
   String valorDni;
   valorDni= txt_dniCliente.getText().trim();
   if(valorDni.equals("")){
       JOptionPane.showMessageDialog(null, "Ingrese un DNI");
       txt_dniCliente.requestFocus();
   }else{
   try 
      {
      String valDni;
      Connection cn1= Conexion.Conectar();
      PreparedStatement pst1= cn1.prepareStatement("select Dni_cliente from tabla_clientes where Dni_cliente='"+valorDni+"'");
      ResultSet resul1=pst1.executeQuery();
      if(resul1.next())
      {
      valDni=resul1.getString("Dni_cliente");
          
      //RECUPERAR DATOS AL ENCONTRAR DNI EN LA BD
      if (valorDni.equals(valDni))
      {
      Connection cn2= Conexion.Conectar();
      PreparedStatement pst2= cn2.prepareStatement("select  Nombre_cliente, Apellidos_cliente, "
       + "Direccion_cliente from tabla_clientes  where Dni_cliente='"+valorDni+"'");
      ResultSet resul2=pst2.executeQuery();
        if(resul2.next())
        {
        txt_nombreCliente.setText(resul2.getString("Nombre_cliente"));
        txt_apellidoCliente.setText(resul2.getString("Apellidos_cliente"));
        txt_direcCliente.setText(resul2.getString("Direccion_cliente"));
        cn2.close();
        }
      }
      }          
      else
      {//GUARDAR AL CLIENTE NUEVO
         JOptionPane.showMessageDialog(null, "Cliente no Registrado, GUARDAR","", JOptionPane.WARNING_MESSAGE);
         RegistrarClienteNew registrarClienteNew= new RegistrarClienteNew();
         registrarClienteNew.setVisible(true);
      }
      }catch (SQLException ex) {}
   }
    }//GEN-LAST:event_Boton_BuscarClientesActionPerformed

    private void boton_Calcular_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Calcular_TotalActionPerformed
         // suma del total de productos
    double monto=0;
    double total=0;
    for(int i=0;i<jTable_DetalleVenta.getRowCount();i++)
      {
      monto= Double.parseDouble(jTable_DetalleVenta.getValueAt(i,3).toString());
      total+=monto; 
      }
    DecimalFormat decimal= new DecimalFormat("#.00");// 00 = 2 decimales
 
    String StringGSuel =decimal.format(total);
       
    txt_totalPagar.setText(StringGSuel);   
    }//GEN-LAST:event_boton_Calcular_TotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_BuscarClientes;
    private javax.swing.JButton Boton_EliminaFilar;
    private javax.swing.JLabel Stock;
    private javax.swing.JButton boton_Agregar;
    private javax.swing.JButton boton_CaalcularMonto;
    private javax.swing.JButton boton_Calcular_Total;
    private javax.swing.JButton boton_Cancelar;
    private javax.swing.JButton boton_buscar;
    private javax.swing.JButton boton_imprimir;
    private javax.swing.JButton boton_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_CargoUser;
    private javax.swing.JLabel jLabel_DniUser;
    private javax.swing.JLabel jLabel_NombreUser;
    private javax.swing.JLabel jLabel_categoria;
    private javax.swing.JLabel jLabel_descripcion;
    private javax.swing.JLabel jLabel_dia;
    private javax.swing.JLabel jLabel_formato;
    private javax.swing.JLabel jLabel_mes;
    private javax.swing.JLabel jLabel_monto;
    private javax.swing.JLabel jLabel_numeroVenta;
    private javax.swing.JLabel jLabel_precio;
    private javax.swing.JLabel jLabel_stock;
    private javax.swing.JLabel jLabel_year;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_DetalleVenta;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txt_apellidoCliente;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigoPro;
    private javax.swing.JTextField txt_direcCliente;
    private javax.swing.JTextField txt_dniCliente;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_totalPagar;
    // End of variables declaration//GEN-END:variables
 

   // limpiar campos y canbcelar venta
    public void LimpiarCampos(){
                         txt_codigoPro.setText("");
           jLabel_descripcion.setText("");
           jLabel_precio.setText("");
           jLabel_stock.setText("");
           jLabel_categoria.setText("");
           jLabel_formato.setText("");
           txt_cantidad.setText("");
           jLabel_monto.setText("00.00");
        // limpiar campos cliente
           txt_apellidoCliente.setText("");
           txt_direcCliente.setText("");
           txt_dniCliente.setText("");
           txt_nombreCliente.setText("");
           txt_totalPagar.setText("");
           
           int EliminarTodaFila=jTable_DetalleVenta.getRowCount();
            for(int i=EliminarTodaFila-1;i>=0;i--)
            {
            TABLA.removeRow(i);
            }
            GenerarSerieBoleta();
            
    }
   
    public void GenerarSerieBoleta(){
        // creamos metodo para RECUPERAR LA ULTIMA SERIE
      String serie="";
        try {
            Connection cn=Conexion.Conectar();
            PreparedStatement pst= cn.prepareStatement("SELECT MAX(Numero_VentaBol) AS Numero_VentaBol FROM tabla_venta_boletas");
            ResultSet rs=pst.executeQuery();// recupéramos el ultimo dato agregado en la tabal de DETALLE VENTA
            if (rs.next()){
            serie=rs.getString(1);
            //  serie=Integer.parseInt(rs.getString(1)+1);
            }
        } catch (Exception e) {
        }

    
    // CREAMOS UN METODO PARA AGREGAR LA SERIE
        if(serie==null){
            jLabel_numeroVenta.setText("0000001");
        }else{
            int increment=Integer.parseInt(serie);
            jLabel_numeroVenta.setText("000000"+(increment+1));
         }
    }
    
  
    // actualizar stoxk de producto
   public void ActualizarStok(){
       try {
         Connection cn= Conexion.Conectar();
         PreparedStatement pst= cn.prepareStatement("select Stock_pro from tabla_productos where Codigo_pro='"+txt_codigoPro.getText().trim()+"'");
         ResultSet resul=pst.executeQuery(); 
         if(resul.next()){
           stockTablaProductos=Integer.parseInt(resul.getString("Stock_pro"));
           // pintar el stok geun la cantidad dispoible
          if(stockTablaProductos>=15){
              jLabel_stock.setForeground(new Color(0,153,51 ));
           }
          if(stockTablaProductos>=5 &&stockTablaProductos<=14){
              jLabel_stock.setForeground(new Color(0,153,153));
           }
          if(stockTablaProductos>=0 &&stockTablaProductos<=4){
              jLabel_stock.setForeground(Color.RED);
           }
           cn.close();
          }
       
        }catch (Exception e) {
            System.err.println("error al recuperar stok actualizado del producto: "+e);
            }

        }
}
