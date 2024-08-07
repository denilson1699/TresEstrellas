
package ventanas;
import clases.AgregarImagen;
import clases.AgregarRadioBotton;
import clases.ColorCeldaTabla;
import java.sql.*;
import clases.Conexion;
import clases.GestionCeldas;
import com.sun.crypto.provider.JceKeyStore;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import clases.GestionEncabezadoTabla;
import com.placeholder.PlaceHolder;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import javax.swing.JRadioButton;
import javax.swing.table.TableCellRenderer;

public class ListaProductos extends javax.swing.JFrame {
      public static int id_codigoProTabla;
      public static String codigo_productoTabla;int stock_productoTabla;
      String selecion, fechaAutomatica;
      String valorBscado,FiltroElegido;
    DefaultTableModel model= new DefaultTableModel(){// conexion con la tabla y generar clic
    // este metodo permite que la tabla sea editada
          @Override
          public boolean isCellEditable(int row, int column) {
          if(column==4)
          { 
           return true;
          }else
          {
           return false;
          }
          }
    };
    // metodo para el color de celas
     ColorCeldaTabla MensajeroColorFila= new ColorCeldaTabla();
     //metodo para el color del encabezado de tabla
     GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla();
     ///metodo para agregar radioboton a la tabla
     AgregarRadioBotton MensajeroAgegarRadioBotton= new AgregarRadioBotton(); 

     // METODO CONSTRUCTOR 
    public ListaProductos() {
    initComponents();  
    getContentPane().setBackground(new Color(255,255,204));
       //setResizable(false); // interfas no se mueva
       setLocationRelativeTo(null); // interfaz centrada
      //this.setExtendedState(MAXIMIZED_BOTH); // dimenciones de la interfaz
        setSize(1214,648);
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      
        // metodo calendario para la fecha
        Calendar calendario= Calendar.getInstance();
        fechaAutomatica=Integer.toString(calendario.get(Calendar.DATE))+"/"+
                Integer.toString(calendario.get(Calendar.MONTH)+1)+"/"+
                Integer.toString(calendario.get(Calendar.YEAR));
     
        txt_fechaIngresoPro.setText(fechaAutomatica);
        txt_fechaVencPor.setText("");
        jDateChooser1.setCalendar(calendario);
      
        // recuperados metodo para agregamos datos a la tabla
       agregarDatosTabla();
        
        //crreamos metodo para el EVENTO de la TABLA
        jTableProductos.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
         int fila_poin=jTableProductos.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            stock_productoTabla=(int) model.getValueAt(fila_poin,3);
            codigo_productoTabla=(String)model.getValueAt(fila_poin,0);
            // recuperamos metodo para  ostrar informacion de celda selecionada
             BuscardorDeProductos(codigo_productoTabla);
             
            if(stock_productoTabla==0)
            {
              txt_stockBuscar.setText("AGOTADO");
              txt_stockBuscar.setForeground(Color.red);
            }
             if(stock_productoTabla>0&&stock_productoTabla<=10)
            {
              txt_stockBuscar.setText("ALERTADO");
              txt_stockBuscar.setForeground(Color.ORANGE);
            }
            if(stock_productoTabla>10)
             {
              txt_stockBuscar.setText("DISPONIBLE");
              txt_stockBuscar.setForeground(new Color(0,153,0));
            }
            }
         }  
        });
    
        //recuperamos  METOdO PARA OCULTAR JTEXTFIELD
       // OcultarJTextField();
        //para que se muestren fecha  deregistro y fecha de vencimiento
        txt_fechaIngresoPro.setVisible(true);
        txt_fechaVencPor.setVisible(true);
        
        //agregamos imagen a botones de edicion
        AgregarImagen imagen = new AgregarImagen();
        boton_editar1.setIcon(imagen.agregarImagenBoton("/images/editar.png", boton_editar1));
        boton_editar2.setIcon(imagen.agregarImagenBoton("/images/editar.png", boton_editar1));
        jButton_Refrescar.setIcon(imagen.agregarImagenBoton("/images/refrescar.png", jButton_Refrescar));
  
           GenerarCodigoProducto();   
     }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_actualizar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jButton_agregar = new javax.swing.JButton();
        txt_stockBuscar = new javax.swing.JTextField();
        txt_codBuscarPro = new javax.swing.JTextField();
        jcmb_tipoFiltro = new javax.swing.JComboBox<>();
        jButton_productoBuscar = new javax.swing.JButton();
        txt_filtroCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jButton_Refrescar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_stockPro = new javax.swing.JTextField();
        txt_precioUni = new javax.swing.JTextField();
        txt_descripcionPro = new javax.swing.JTextField();
        txt_codigoPro = new javax.swing.JTextField();
        cmb_categoriaPro = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        boton_editar1 = new javax.swing.JButton();
        boton_editar2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txt_fechaIngresoPro = new javax.swing.JTextField();
        txt_fechaVencPor = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        cmb_FormatoPro = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_RucProveedor = new javax.swing.JTextField();

        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_actualizar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, -1, 40));

        jButton_nuevo.setBackground(new java.awt.Color(0, 102, 102));
        jButton_nuevo.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Agregar.png"))); // NOI18N
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 550, 120, 40));

        jButton_Eliminar.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Eliminar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eliminar.png"))); // NOI18N
        jButton_Eliminar.setText("Eliminar ");
        jButton_Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1007, 490, 120, 40));

        jButton_agregar.setBackground(new java.awt.Color(0, 102, 102));
        jButton_agregar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        jButton_agregar.setText("Agregar");
        jButton_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1007, 550, 120, 40));

        txt_stockBuscar.setEditable(false);
        txt_stockBuscar.setBackground(new java.awt.Color(255, 255, 204));
        txt_stockBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_stockBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_stockBuscar.setBorder(null);
        getContentPane().add(txt_stockBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 116, 23));

        txt_codBuscarPro.setBackground(new java.awt.Color(204, 204, 255));
        txt_codBuscarPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_codBuscarPro.setForeground(new java.awt.Color(0, 102, 102));
        txt_codBuscarPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codBuscarPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_codBuscarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 250, 30));

        jcmb_tipoFiltro.setBackground(new java.awt.Color(255, 153, 0));
        jcmb_tipoFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcmb_tipoFiltro.setForeground(new java.awt.Color(255, 255, 255));
        jcmb_tipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descripcion", "Codigo" }));
        jcmb_tipoFiltro.setBorder(null);
        jcmb_tipoFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jcmb_tipoFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 30));

        jButton_productoBuscar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_productoBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_productoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_productoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton_productoBuscar.setText("Buscar");
        jButton_productoBuscar.setBorder(null);
        jButton_productoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_productoBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_productoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 82, 29));

        txt_filtroCodigo.setBackground(new java.awt.Color(204, 204, 255));
        txt_filtroCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_filtroCodigo.setForeground(new java.awt.Color(0, 102, 102));
        txt_filtroCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_filtroCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_filtroCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_filtroCodigoActionPerformed(evt);
            }
        });
        txt_filtroCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroCodigoKeyReleased(evt);
            }
        });
        getContentPane().add(txt_filtroCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 250, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("CODIGO PRODUCTO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 120, 20));

        jTableProductos.setBackground(new java.awt.Color(0, 255, 0));
        jTableProductos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTableProductos.setForeground(new java.awt.Color(102, 102, 102));
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductos.setDragEnabled(true);
        jTableProductos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTableProductos);
        if (jTableProductos.getColumnModel().getColumnCount() > 0) {
            jTableProductos.getColumnModel().getColumn(0).setMinWidth(18);
            jTableProductos.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableProductos.getColumnModel().getColumn(0).setMaxWidth(16);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 730, 470));

        jButton_Refrescar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefrescarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Refrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 34, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Código:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Descripción:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("P s/.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Stock:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, 50, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("F. Ingreso:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Categoría:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, -1, -1));

        txt_stockPro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_stockPro.setForeground(new java.awt.Color(0, 153, 153));
        txt_stockPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_stockPro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_stockPro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_stockPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stockProKeyTyped(evt);
            }
        });
        getContentPane().add(txt_stockPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 290, 50, -1));

        txt_precioUni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_precioUni.setForeground(new java.awt.Color(0, 102, 102));
        txt_precioUni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_precioUni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_precioUni.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_precioUni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioUniKeyTyped(evt);
            }
        });
        getContentPane().add(txt_precioUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 290, 60, -1));

        txt_descripcionPro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_descripcionPro.setForeground(new java.awt.Color(0, 102, 102));
        txt_descripcionPro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_descripcionPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_descripcionPro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_descripcionPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descripcionProKeyTyped(evt);
            }
        });
        getContentPane().add(txt_descripcionPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, 180, -1));

        txt_codigoPro.setEditable(false);
        txt_codigoPro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_codigoPro.setForeground(new java.awt.Color(0, 102, 102));
        txt_codigoPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPro.setText("P000000");
        txt_codigoPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_codigoPro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_codigoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoProKeyTyped(evt);
            }
        });
        getContentPane().add(txt_codigoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 180, -1));

        cmb_categoriaPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_categoriaPro.setForeground(new java.awt.Color(0, 153, 153));
        cmb_categoriaPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Categoria", "Abarrotes", "Bebidas ", "Cervezas", "Comida Mascotas", "Dulces", "Frutas y Verduras", "Lacteos y Huevos", "Productos de Limpieza", "Panaderia y pasteleria", "Alimentos Congelados" }));
        cmb_categoriaPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(cmb_categoriaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 342, 190, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("F. Venc:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 60, 30));

        boton_editar1.setBackground(new java.awt.Color(204, 204, 255));
        boton_editar1.setBorder(null);
        boton_editar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, 20, 20));

        boton_editar2.setBackground(new java.awt.Color(204, 204, 255));
        boton_editar2.setBorder(null);
        boton_editar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar2ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_editar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, 20, 20));

        jDateChooser1.setForeground(new java.awt.Color(0, 153, 153));
        jDateChooser1.setEnabled(false);
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 140, 30));

        txt_fechaIngresoPro.setEditable(false);
        txt_fechaIngresoPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fechaIngresoPro.setEnabled(false);
        getContentPane().add(txt_fechaIngresoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 117, 30));

        txt_fechaVencPor.setEditable(false);
        txt_fechaVencPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fechaVencPor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_fechaVencPor.setEnabled(false);
        getContentPane().add(txt_fechaVencPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 440, 117, 30));

        jDateChooser2.setForeground(new java.awt.Color(0, 153, 153));
        jDateChooser2.setEnabled(false);
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 440, 140, 30));

        cmb_FormatoPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_FormatoPro.setForeground(new java.awt.Color(0, 153, 153));
        cmb_FormatoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Formato", "Botella Ml", "Botella Lt", "Barra Gr", "Barra Un", "Bolsa Gr", "Bolsa kg", "Caja Un", "Envase Ml", "Envase Lt", "Venta por Peso Kg", "Venta por Peso Gr", "Unidad ", "Paquete un", "Paquete Gr", "Pack" }));
        cmb_FormatoPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(cmb_FormatoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 180, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Formato:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("\"Bodega Tres Estrelas\"");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Ruc Proveedor");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, -1, -1));

        txt_RucProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_RucProveedor.setForeground(new java.awt.Color(0, 102, 102));
        txt_RucProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_RucProveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_RucProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_RucProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_RucProveedorKeyTyped(evt);
            }
        });
        getContentPane().add(txt_RucProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_productoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_productoBuscarActionPerformed
        
    // buscamos una un valores en la tabla
    // recuperamos valor ingreado en el txt para la consulta
    valorBscado = (txt_codBuscarPro.getText().trim()).toUpperCase();
        for (int i = 0; i < jTableProductos.getRowCount(); i++) 
        {
          if (jTableProductos.getValueAt(i, 0).equals(valorBscado)) 
          {
            jTableProductos.changeSelection(i, 0, false, false);  
            //remplazamos valor ingresado por el correcto 
            String RemplazarValorBuscado=(String) jTableProductos.getValueAt(i,0);
            txt_codBuscarPro.setText(RemplazarValorBuscado); 
          }
        }

     // recuperamos metodo que devuelve infromacion del valor buscado en la tabla
     BuscardorDeProductos(valorBscado);
        
    }//GEN-LAST:event_jButton_productoBuscarActionPerformed
 
    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
     // eliminar celda selecionada
     // for paar eliminar todos los check selecionados
        for(int i=0;i<jTableProductos.getRowCount();i++)
          {// si se encuentra un check seelcionado
          if(IsSeleceted(i,4, jTableProductos))
          {
           int mensaje=JOptionPane.showConfirmDialog(null,"¿Desea eliminar producto?",null,JOptionPane.YES_NO_OPTION);
           if(mensaje==JOptionPane.YES_OPTION)// si desea proceguir con la eliminacion
           { try 
                {
                Connection cn1= Conexion.Conectar();
                PreparedStatement pst= cn1.prepareStatement("delete from tabla_productos where Codigo_pro=?");
                pst.setString(1,codigo_productoTabla);
                pst.executeUpdate();
                cn1.close();
                JOptionPane.showMessageDialog(null, "Producto "+codigo_productoTabla+" eliminado exitosamente");
                ActualizarVentana();
                } catch (Exception e)
                {
                JOptionPane.showMessageDialog(null, "Error al eliminar Producto, Contacte al Administrador","",JOptionPane.ERROR_MESSAGE);
                System.err.println("error al eliminar producto :"+e);
                } 
           }else
           {// si no desea proceguir con la eliminacion
           JOptionPane.showMessageDialog(null, "CANCELADO");
           }
         }
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        String codigo,descripcion,precioUni,categoria, formato,f_Ingreso,f_Venc,stock, ruc_proveedor; int  contador=0;
        // metodo para recuper la fecha selecionada de jdatechooser
        SimpleDateFormat dFormat= new SimpleDateFormat("dd/MM/yyyy");
        
        // recuperadmos la fecha de ingreso selecionada y guardamos en txtfechaIngresopro
        String fechaIngreso=dFormat.format(jDateChooser1.getDate());
        
        // recuperadmos fecha de vencimiento seleconada  y la guardmos en txt fechavencpor
        String fechaVencimiento=dFormat.format(jDateChooser2.getDate());
        
       // recuperamos los valores ingresados en los jtextfield
        codigo      =txt_codigoPro.getText().trim().toUpperCase();
        descripcion =txt_descripcionPro.getText().trim();
        precioUni   =txt_precioUni.getText().trim();
        f_Ingreso   =fechaIngreso;
        f_Venc      =fechaVencimiento;
        stock       =txt_stockPro.getText().trim();
        ruc_proveedor=txt_RucProveedor.getText().trim();
        // recuperamos la categoria selecionada
        categoria   =(String) cmb_categoriaPro.getSelectedItem();
        formato   =(String) cmb_FormatoPro.getSelectedItem();
        
        // validamos qiue no encuentren campos en blanco
        if(codigo.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar codigo ");
         txt_codigoPro.requestFocus();
         contador++;
        }
        if(descripcion.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar descripcion ");
         txt_descripcionPro.requestFocus();
         contador++;
        }
        if(precioUni.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar precio ");
         txt_precioUni.requestFocus();
         contador++;
        }
        if(stock.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar stok ");
         txt_stockPro.requestFocus();
         contador++;
        }
        if(f_Venc.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta fecha vencimiento del producto");
         txt_stockPro.requestFocus();
         contador++;
        }
        if(categoria.equals("Select Categoria"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar una categoria");
         txt_stockPro.requestFocus();
         contador++;
        }
        if(formato.equals("Select Formato"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar una Formato");
         txt_stockPro.requestFocus();
         contador++;
        }
        if(ruc_proveedor.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta Ingresar RUC del proveedor ");
         txt_RucProveedor.requestFocus();
         contador++;
        }
        // si todos los campos entan llenos
     if(contador==0)
     {
      try 
      {
          String valCodigo;
          Connection cn1= Conexion.Conectar();
          PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro from tabla_productos where Codigo_pro ='"+codigo+"'");
          ResultSet resul1=pst1.executeQuery();
          if(resul1.next())
          {
          valCodigo=resul1.getString("Codigo_pro");
          // validamos que el codigo o se repita
          if (codigo.equals(valCodigo))
             {
             JOptionPane.showMessageDialog(null, "Codigo de producto ya registrado");
             }
          }else{// valdar s desea guardar producto
              int mensaje=JOptionPane.showConfirmDialog(null,"Guardar nuevo producto  [S/N]:",null,JOptionPane.YES_NO_OPTION);
              if(mensaje==JOptionPane.YES_OPTION)
               {
               try 
                 {
                 Connection cn=Conexion.Conectar();
                 PreparedStatement pst= cn.prepareStatement("insert into tabla_productos values (?,?,?,?,?,?,?,?,?)");
                 pst.setString(1,codigo );
                 pst.setString(2,descripcion );
                 pst.setString(3,formato );
                 pst.setString(4, precioUni);
                 pst.setString(5,stock );
                 pst.setString(6,categoria);
                 pst.setString(7,f_Ingreso );
                 pst.setString(8,f_Venc );
                 pst.setString(9,ruc_proveedor );
                 pst.executeUpdate();
                 cn.close();
                 // preguntar si desea generar un nuevo registro
                 int mensaje2=JOptionPane.showConfirmDialog(null,"Registro exitoso continuar [S/N]:",null,JOptionPane.YES_NO_OPTION);
                 if(mensaje==JOptionPane.YES_OPTION)
                   {
                        // para blanquiar los campos y dejarlos listo para el ingreso de nuevos datos
                        txt_fechaIngresoPro.setText(fechaAutomatica);

                        // recuperadmos metodo para blanquiar campos
                        LimpiarCampos();

                        // desavilitamos boton actualizar y eliminar
                        jButton_actualizar.setEnabled(false);
                        jButton_Eliminar.setEnabled(false);
                        // avilitamos jtextfiels codigo producto
                        txt_codigoPro.setEditable(true);

                             // boton para editar fecha de ingreso
                        jDateChooser2.setEnabled(true);
                        txt_fechaIngresoPro.setVisible(false);

                             // boton para editar fecha de vencimiento
                        jDateChooser2.setEnabled(true);
                        txt_fechaIngresoPro.setVisible(false);

                      
                   
                   }
                 } catch (Exception e) 
                 {
                 JOptionPane.showMessageDialog(null,"Error!!!, no se registro nuevo producto","",JOptionPane.ERROR_MESSAGE);
                 System.err.println("error al registrar nuevo producto: "+e);
                 }
                 }else
                    {// si no se desea gabra nuevo producto
                     JOptionPane.showMessageDialog(null, "CANCELADO");
                    }
                }
                
        }catch (SQLException ex) {}
        }

    }//GEN-LAST:event_jButton_agregarActionPerformed
    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed
      // para blanquiar los campos y dejarlos listo para el ingreso de nuevos datos
      txt_fechaIngresoPro.setText(fechaAutomatica);
      
      // recuperadmos metodo para blanquiar campos
      LimpiarCampos();
      
      // desavilitamos boton actualizar y eliminar
      jButton_actualizar.setEnabled(false);
      jButton_Eliminar.setEnabled(false);
      // avilitamos jtextfiels codigo producto
      txt_codigoPro.setEditable(true);

           // boton para editar fecha de ingreso
      jDateChooser2.setEnabled(true);
      txt_fechaIngresoPro.setVisible(false);

           // boton para editar fecha de vencimiento
      jDateChooser2.setEnabled(true);
      txt_fechaIngresoPro.setVisible(false);

    }//GEN-LAST:event_jButton_nuevoActionPerformed
    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        String codigo,descripcion,precioUni,categoria,formato, f_Ingreso,f_Venc,stock,ruc_proveedor;
        int  contador=0;   
       // metodo para recuper la fecha selecionada de jdatechooser
        SimpleDateFormat dFormat1= new SimpleDateFormat("dd/MM/yyyy");
        
        // recuperadmos la fecha de ingreso selecionada y guardamos en txtfechaIngresopro
        String fechaIngreso1=dFormat1.format(jDateChooser1.getDate());

        
        // recuperadmos fecha de vencimiento seleconada  y la guardmos en txt fechavencpor
        String fechaVencimiento1=dFormat1.format(jDateChooser2.getDate());

        
        // recuperadmos datos de los jtextfield
        codigo      =txt_codigoPro.getText().trim().toUpperCase();;
        descripcion =txt_descripcionPro.getText().trim();
        precioUni   =txt_precioUni.getText().trim();
         stock      =txt_stockPro.getText().trim();
        categoria   =(String) cmb_categoriaPro.getSelectedItem();
        formato   =(String) cmb_FormatoPro.getSelectedItem();
        ruc_proveedor=txt_RucProveedor.getText().trim();
        
       if(fechaIngreso1==txt_fechaIngresoPro.getText())
        {
          f_Ingreso   =txt_fechaIngresoPro.getText();
        }else{
          f_Ingreso   =fechaIngreso1;
       }
         
       if(fechaVencimiento1==txt_fechaVencPor.getText())
        {
          f_Venc      =txt_fechaVencPor.getText(); 
        }else{
          f_Venc      =fechaVencimiento1;
       }
       
        // vaidamos que no existan campos en blanco
        if(codigo.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar codigo ");
            txt_codigoPro.requestFocus();
            contador++;
        }
        if(descripcion.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar descripcion ");
            txt_descripcionPro.requestFocus();
            contador++;
        }
        if(precioUni.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar precio ");
            txt_precioUni.requestFocus();
            contador++;
        }
        if(stock.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar stok ");
            txt_stockPro.requestFocus();
            contador++;
        }
        
        if(categoria.equals("Select Categoria"))
        {
              JOptionPane.showMessageDialog(null, "Falta seleccionar una categoria");
            txt_stockPro.requestFocus();
            contador++;
        }
            if(formato.equals("Select Formato"))
        {
              JOptionPane.showMessageDialog(null, "Falta seleccionar una fromato");
            txt_stockPro.requestFocus();
            contador++;
        }
      
        if(ruc_proveedor.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta Ingresar RUC del proveedor ");
         txt_RucProveedor.requestFocus();
         contador++;
        }
        // si todos los campos en llenos
      if(contador==0)
      {  // pregusntar si se desea guar la actualizacion
        int mensaje=JOptionPane.showConfirmDialog(null,"¿Guardar Cambios?",null,JOptionPane.YES_NO_OPTION);
        if(mensaje==JOptionPane.YES_OPTION)
        {
        try {// actualizar datos en la bse de datos
            Connection cn=Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement("update tabla_productos set Descripcion_pro=?, Formato_pro=?, "
            + "Precio_pro=?, Stock_pro=?,Categoria_pro=?,Fecha_ingreso=?,Fecha_venc=?,Ruc_proveedor=? where Codigo_pro='"+codigo+"'");
            pst.setString(1,descripcion);
            pst.setString(2,formato);
            pst.setString(3,precioUni);
            pst.setString(4,stock );
            pst.setString(5,categoria);
            pst.setString(6,f_Ingreso);
            pst.setString(7,f_Venc);
            pst.setString(8,ruc_proveedor);
            pst.executeUpdate();
            cn.close();
            JOptionPane.showMessageDialog(null,"Actualización exitosa");
            ActualizarVentana();// actualizamos interfaz       
            }catch (SQLException ex) 
            {
            JOptionPane.showMessageDialog(null, "Error,al actualzar Producto","",JOptionPane.ERROR_MESSAGE);
            System.err.println("error al actualizar: "+ex);
            }
        }else
        {// s no se desea actualizar datos
        JOptionPane.showMessageDialog(null, "ACTUALIZACION CANCELADA");
        }
     }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void txt_filtroCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroCodigoKeyReleased
    //cuando el usuario teclee en el buscador
    try 
    {// en texto escrito a consultar en la tabla
    String texto="%"+txt_filtroCodigo.getText().trim()+"%";
    
    // secuberra el tipo de filtro
    String filtroSelec=jcmb_tipoFiltro.getSelectedItem().toString();
 
    // para el color de celas
    ColorCeldaTabla MensajeroColorFila= new ColorCeldaTabla();
    // para el color del encabezad
    GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla();
 
    // ETIQUETAS DE EMCABEZADO DE TABLA
    String[] titulos={"CODIGO", "DESCRIPCION", "PRECIO", "STOCK", ""};
    model=new DefaultTableModel(null,titulos)
    {// este metodo permite que la tabla NO sea editada
      @Override
      public boolean isCellEditable(int row, int column) 
      {
      if(column==4)
        {return true;}
      else{return false;}
      }
    };

    // FUNCIONES DEPENDIENDO DEL TIPO DE FILTRO ELEGIDO
    switch (filtroSelec)
    {//*********** FILTRO PARA CODIGO DE PRODUCTO ************
    case"Codigo":
       Connection cn= Conexion.Conectar();
       PreparedStatement pst= cn.prepareStatement("select *from tabla_productos where Codigo_pro like"+'"'+texto+'"');
       String[] fila= new String[4];
       ResultSet resul=pst.executeQuery();
       // AGREGAR ENCABEZADOS A LA TABLA
       jTableProductos = new JTable(model);
       jScrollPane2.setViewportView(jTableProductos);
       // AGREGAR CHECH A LA TABLA
       addChechBox(4,jTableProductos);
       //AGREGAR COLOR A LAS FILAS
       for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
       {jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
       //AGREGAR COLOR A ENCABEZADO DE LA TABLA
       for(int i=0;i<(jTableProductos.getColumnCount());i++)
       {jTableProductos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}
          
       jTableProductos.getColumnModel().getColumn(0).setPreferredWidth(60);//dimensionar columna 1
       jTableProductos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 2
       jTableProductos.getColumnModel().getColumn(2).setPreferredWidth(60);//dimensionar columna 3
       jTableProductos.getColumnModel().getColumn(3).setPreferredWidth(60);//dimensionar columna 4
       jTableProductos.getColumnModel().getColumn(4).setMaxWidth(45);//dimensionar columna 5
       jTableProductos.setRowHeight(18);// DIMENCION DE ALTURA DEL ENCABEZADO
       
       //recuperar valores de BD A LA TABLA
       while(resul.next())
       {
       fila[0]=resul.getString("Codigo_pro");
       fila[1]=resul.getString("Descripcion_pro");
       fila[2]=resul.getString("Precio_pro");
       fila[3]=resul.getString("Stock_pro");
       model.addRow(fila);
       }
       cn.close(); 
       
       // EVENTO EN LA TABLA
       jTableProductos.addMouseListener(new MouseAdapter() 
       {
       @Override
       public void mouseClicked(MouseEvent e)
       {// recuperar celda celecionada
         int fila_poin=jTableProductos.rowAtPoint(e.getPoint());
         if(fila_poin>-1)
           { //recuperar codigo de la celda celecionda
           String codigo= (String)model.getValueAt(fila_poin,0);
            stock_productoTabla=(int) model.getValueAt(fila_poin,3);
           
           if(stock_productoTabla==0)
            {
              txt_stockBuscar.setText("AGOTADO");
              txt_stockBuscar.setForeground(Color.red);
            }else
            {
              txt_stockBuscar.setText("DISPONIBLE");
              txt_stockBuscar.setForeground(new Color(0,153,0));
            }
           // llamar metodo bucar rodctos ára que muestre la infromacion del producto selecionado
           BuscardorDeProductos(codigo);
           //IsSeleceted(fila_poin, 5, jTableProductos);
           }
       }  
       });
       break;
    
       
       //********** FILTRO DE DESCRIPCION DE PRODUCTO **********
       case"Descripcion":
           Connection cn1= Conexion.Conectar();
           PreparedStatement pst1= cn1.prepareStatement("select *from tabla_productos where Descripcion_pro like"+'"'+texto+'"');
           String[] fila1= new String[4];
           ResultSet resul1=pst1.executeQuery();
           // AGREGAR ENCABEZADOS A LA TABLA
           jTableProductos = new JTable(model);
           jScrollPane2.setViewportView(jTableProductos);
           // AGREGAR CHECH A LA TABLA
           addChechBox(4,jTableProductos);
           //AGREGAR COLOR A LAS FILAS
           for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
           { jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
           //AGREGAR COLOR A ENCABEZADO DE LA TABLA
           for(int i=0;i<(jTableProductos.getColumnCount());i++)
           { jTableProductos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);  }
           
           // dimenciones para las columnas
           jTableProductos.getColumnModel().getColumn(0).setPreferredWidth(60);//dimensionar columna 0
           jTableProductos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
           jTableProductos.getColumnModel().getColumn(2).setPreferredWidth(60);//dimensionar columna 0
           jTableProductos.getColumnModel().getColumn(3).setPreferredWidth(60);//dimensionar columna 0
           jTableProductos.getColumnModel().getColumn(4).setMaxWidth(45);//dimensionar columna 0
           jTableProductos.setRowHeight(18);
           
           //AGREGAR LOS VALORES DE LA BD A LA TABLA
        
           while(resul1.next())
              {
               fila1[0]=resul1.getString("Codigo_pro");
               fila1[1]=resul1.getString("Descripcion_pro");
               fila1[2]=resul1.getString("Precio_pro");
               fila1[3]=resul1.getString("Stock_pro");
               model.addRow(fila1);
              }
              cn1.close();
              
              
          // EVENTO EN LA TABLA
          jTableProductos.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e)
          {
           int fila_poin=jTableProductos.rowAtPoint(e.getPoint());
           if(fila_poin>-1){
           String codigo= (String)model.getValueAt(fila_poin,0);
           stock_productoTabla=(int) model.getValueAt(fila_poin,3);
           
           if(stock_productoTabla==0)
            {
              txt_stockBuscar.setText("AGOTADO");
              txt_stockBuscar.setForeground(Color.red);
            }else
            {
              txt_stockBuscar.setText("DISPONIBLE");
              txt_stockBuscar.setForeground(new Color(0,153,0));
            }
           BuscardorDeProductos(codigo);
           }
          }  
          });
          break; 
         }
         
     } catch (Exception e) 
       {
       JOptionPane.showMessageDialog(null, "error!! no se puede filtar productos","",JOptionPane.ERROR_MESSAGE);
       System.err.println("error al filtar la busqueda: "+e);
       } 
        
    }//GEN-LAST:event_txt_filtroCodigoKeyReleased

    private void txt_filtroCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroCodigoActionPerformed

    private void txt_precioUniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioUniKeyTyped
       // ingresar solo numeros
     /*   char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{
            
        }*/
    }//GEN-LAST:event_txt_precioUniKeyTyped

    private void txt_descripcionProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionProKeyTyped
      // ingresar solo letras
    /*    char c =evt.getKeyChar();
        if((c<'a'||c>'z')&&(c<'A'||c>'Z') )evt.consume();{
            
        }*/
    }//GEN-LAST:event_txt_descripcionProKeyTyped

    private void txt_stockProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stockProKeyTyped
     // ingresar solo numeros
        char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{
            
        }
    }//GEN-LAST:event_txt_stockProKeyTyped

    private void txt_codigoProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoProKeyTyped
      // ingresar maximo 8 caracteres
        if(txt_codigoPro.getText().length()>=8){
           evt.consume(); //no permitir ingresar mas letras
            Toolkit.getDefaultToolkit().beep();// enviar un sonido indicando que no se permite
       }
    }//GEN-LAST:event_txt_codigoProKeyTyped

    private void boton_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar1ActionPerformed
     // boton para editar fecha de ingreso
      jDateChooser1.setEnabled(true);
      txt_fechaIngresoPro.setVisible(false);

    }//GEN-LAST:event_boton_editar1ActionPerformed

    private void boton_editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar2ActionPerformed
    // boton para editar fecha de vencimiento
     jDateChooser2.setEnabled(true);
     txt_fechaVencPor.setVisible(false);
    }//GEN-LAST:event_boton_editar2ActionPerformed

    private void jButton_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefrescarActionPerformed
        ActualizarVentana();
    }//GEN-LAST:event_jButton_RefrescarActionPerformed

    private void txt_RucProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_RucProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RucProveedorKeyTyped


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_editar1;
    private javax.swing.JButton boton_editar2;
    private javax.swing.JComboBox<String> cmb_FormatoPro;
    private javax.swing.JComboBox<String> cmb_categoriaPro;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_Refrescar;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JButton jButton_productoBuscar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JComboBox<String> jcmb_tipoFiltro;
    private javax.swing.JTextField txt_RucProveedor;
    private javax.swing.JTextField txt_codBuscarPro;
    private javax.swing.JTextField txt_codigoPro;
    private javax.swing.JTextField txt_descripcionPro;
    private javax.swing.JTextField txt_fechaIngresoPro;
    private javax.swing.JTextField txt_fechaVencPor;
    private javax.swing.JTextField txt_filtroCodigo;
    private javax.swing.JTextField txt_precioUni;
    private javax.swing.JTextField txt_stockBuscar;
    private javax.swing.JTextField txt_stockPro;
    // End of variables declaration//GEN-END:variables

    //******METODO PARA AGREGAR CHECHBOX********
 public void addChechBox (int column,JTable table){
   TableColumn tc=table.getColumnModel().getColumn(column);
   tc.setCellEditor(table.getDefaultEditor(Boolean.class));
   tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
   
 }
 
   //******* METODO PARA SABER SI SE SELECCCIONA EL CHECHBOX*****
 public boolean IsSeleceted(int row,int column, JTable table){
     
     return table.getValueAt(row, column)!=null;
     
 }
 //****METODO PARA Limpar ****
 public void LimpiarCampos(){
    txt_precioUni.setText("");
    txt_descripcionPro.setText("");
    txt_stockPro.setText("");
     txt_fechaVencPor.setText("");
     cmb_categoriaPro.setSelectedIndex(0);
     cmb_FormatoPro.setSelectedIndex(0);
    GenerarCodigoProducto();  
}
 
 //******** METODO PARA RELLENAR TABLA ********
 public void agregarDatosTabla(){
    //GestionCeldas MensajeroGestionCeldas= new GestionCeldas();

    try {
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,"
                    + " Precio_pro, Stock_pro from tabla_productos");
            ResultSet resul1=pst1.executeQuery();
            // AGREGAR ENCABEZADOS A LA TABLA
            jTableProductos = new JTable(model);
            jScrollPane2.setViewportView(jTableProductos);
            model.addColumn("CODIGO");
            model.addColumn("DESCRIPCION");
            model.addColumn("P S/.");
            model.addColumn("STOCK");
            model.addColumn("");
           // AGREGAR CHECH A LA TABLA
           addChechBox(4,jTableProductos);
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTableProductos.getColumnCount());i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            /*  ////AGREGAR COLOR A celas con la clases gectionCelda
               for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroGestionCeldas);
            }*/
            
             jTableProductos.getColumnModel().getColumn(0).setPreferredWidth(40);//dimensionar columna 0
             jTableProductos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableProductos.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             jTableProductos.getColumnModel().getColumn(3).setPreferredWidth(30);//dimensionar columna 0
             jTableProductos.getColumnModel().getColumn(4).setMaxWidth(25);//dimensionar columna 0
          
             jTableProductos.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[4];
                for(int i=0;i<4;i++){
                    fila[i]=resul1.getObject(i+1);
                }
                model.addRow(fila);
            }
            
        
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla :"+e);
        }
}
 
 // ************** METODO PARA ACTUALIZAR VENTANA ****************
 public void ActualizarVentana(){
     this.setVisible(false);
     ListaProductos mensajero= new ListaProductos();
     mensajero.setVisible(true);
 }
 
 //*************** metodo buscador de productos ******************
 public void BuscardorDeProductos(String codigoProductoBuscar){
 try {
         String estado;
         Connection cn= Conexion.Conectar();
         PreparedStatement pst= cn.prepareStatement("select Codigo_pro,Descripcion_pro,"
           + " Precio_pro, Stock_pro, Fecha_ingreso, Fecha_venc, Categoria_pro ,Formato_pro,Ruc_proveedor "
                 + "from tabla_productos where Codigo_pro='"+codigoProductoBuscar+"'");
         ResultSet resul=pst.executeQuery(); 
         if(resul.next()){
           txt_codigoPro.setText(resul.getString("Codigo_pro"));
           txt_descripcionPro.setText(resul.getString("Descripcion_pro"));
           txt_precioUni.setText(resul.getString("Precio_pro"));
           txt_stockPro.setText(resul.getString("Stock_pro"));
           txt_fechaVencPor.setText(resul.getString("Fecha_venc"));
           txt_fechaIngresoPro.setText(resul.getString("Fecha_ingreso"));
           txt_RucProveedor.setText(resul.getString("Ruc_proveedor"));
           //jDateChooser1.setDateFormatString(resul.getString("fecha_ingreso"));
           String categoria=resul.getString("Categoria_pro");
           if(categoria.equals("Select Categoria")){
               cmb_categoriaPro.setSelectedIndex(0);
           }
           if(categoria.equals("Abarrotes")){
               cmb_categoriaPro.setSelectedIndex(1);
           }
           if(categoria.equals("Bebidas ")){
               cmb_categoriaPro.setSelectedIndex(2);
           }
           if(categoria.equals("Cervezas")){
               cmb_categoriaPro.setSelectedIndex(3);
           }  
           if(categoria.equals("Comida Mascotas")){
               cmb_categoriaPro.setSelectedIndex(4);
           }
           if(categoria.equals("Dulces")){
               cmb_categoriaPro.setSelectedIndex(5);
           }
           if(categoria.equals("Frutas y Verduras")){
               cmb_categoriaPro.setSelectedIndex(6);
           }
           if(categoria.equals("Lacteos y Huevos")){
               cmb_categoriaPro.setSelectedIndex(7);
           }
           if(categoria.equals("Productos de Limpieza")){
               cmb_categoriaPro.setSelectedIndex(8);
           }           
           if(categoria.equals("Panaderia y pasteleria")){
               cmb_categoriaPro.setSelectedIndex(9);
           }
           if(categoria.equals("Alimentos Congelados")){
               cmb_categoriaPro.setSelectedIndex(10);
           }
           
           
            String formato=resul.getString("Formato_pro");
           if(formato .equals("Select Formato")){
               cmb_FormatoPro.setSelectedIndex(0);
           }
           if(formato .equals("Botella Ml")){
               cmb_FormatoPro.setSelectedIndex(1);
           }
           if(formato .equals("Botella Lt")){
               cmb_FormatoPro.setSelectedIndex(2);
           }
            if(formato .equals("Barra Gr")){
               cmb_FormatoPro.setSelectedIndex(3);
           }
           
            if(formato .equals("Barra Un")){
               cmb_FormatoPro.setSelectedIndex(4);
           }
           if(formato .equals("Bolsa Gr")){
               cmb_FormatoPro.setSelectedIndex(5);
           }
           if(formato .equals("Bolsa kg")){
               cmb_FormatoPro.setSelectedIndex(6);
           }
          if(formato .equals("Caja Un")){
               cmb_FormatoPro.setSelectedIndex(7);
           }
           if(formato .equals("Envase Ml")){
               cmb_FormatoPro.setSelectedIndex(8);
           }
           if(formato .equals("Envase Lt")){
               cmb_FormatoPro.setSelectedIndex(9);
           }
           if(formato .equals("Venta por Peso Kg")){
               cmb_FormatoPro.setSelectedIndex(10);
           }
           if(formato .equals("Venta por Peso Gr")){
               cmb_FormatoPro.setSelectedIndex(11);
           }
           if(formato .equals("Unidad")){
               cmb_FormatoPro.setSelectedIndex(12);
           }
           if(formato .equals("Paquete un")){
               cmb_FormatoPro.setSelectedIndex(13);
           }
           if(formato .equals("Paquete Gr")){
               cmb_FormatoPro.setSelectedIndex(14);
           }
           if(formato .equals("Pack")){
               cmb_FormatoPro.setSelectedIndex(15);
           }
           
            
           // mostramos los botones y los textfield para la edicion
           MostrarJTextField();
          cn.close();
          }else{
              JOptionPane.showMessageDialog(null, "codigo ("+codigoProductoBuscar+") no encontrado","ERROR!!!", JOptionPane.WARNING_MESSAGE);
              txt_codBuscarPro.requestFocus();
              
         }
        }catch (Exception e) {
            System.err.println("error al recuperar productos de la tabla: "+e);
     }
 }
 
 //************ METODO PARA OCULTAR TXTFIELD ******************
 public void OcultarJTextField(){
     txt_codigoPro.setEditable(false);
     txt_descripcionPro.setEditable(false);
     txt_precioUni.setEditable(false);
     txt_stockPro.setEditable(false);
     jButton_agregar.setEnabled(false);
     jButton_actualizar.setEnabled(false);
     jButton_nuevo.setEnabled(false);
     jButton_Eliminar.setEnabled(false);
 }
 
 
 //************ METODO PARA MOSTRAR TXTFIELD ***************
 public void MostrarJTextField(){
     txt_descripcionPro.setEditable(true);
     txt_precioUni.setEditable(true);
     txt_stockPro.setEditable(true);
     jButton_agregar.setEnabled(true);
     jButton_actualizar.setEnabled(true);
     jButton_nuevo.setEnabled(true);
     jButton_Eliminar.setEnabled(true);
 }

  public void GenerarCodigoProducto(){
        // creamos metodo para RECUPERAR LA ULTIMA SERIE
      String codigo="",subcodigo;
        try {
            Connection cn=Conexion.Conectar();
            PreparedStatement pst= cn.prepareStatement("SELECT MAX(Codigo_pro) AS Codigo_pro  FROM tabla_productos");
            ResultSet rs=pst.executeQuery();// recupéramos el ultimo dato agregado en la tabal de DETALLE VENTA
            if (rs.next()){
            codigo=rs.getString(1);
            }
        } catch (Exception e) {
        }
        subcodigo= codigo.substring(1,8 );
         
    // CREAMOS UN METODO PARA AGREGAR LA SERIE
        if(subcodigo==null){
            txt_codigoPro.setText("P0000000");
        }else{
            int increment=Integer.parseInt(subcodigo);
            txt_codigoPro.setText("P000000"+(increment+1));
         }

 
}
}
