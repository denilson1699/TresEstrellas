
package ventanas;


import clases.AgregarRadioBotton;
import clases.ColorCeldaTabla;
import clases.Conexion;
import clases.GestionEncabezadoTabla;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static ventanas.Ventana_Administrador.jDesktop;

public class ReportesPedidos extends javax.swing.JInternalFrame {

   DefaultTableModel modelTodosPedidos= new DefaultTableModel();// conexion con la tabla y generar clic
 DefaultTableModel modelCleintesMasivos= new DefaultTableModel();// conexion con la tabla y generar clic
 DefaultTableModel modelCleintesRuc= new DefaultTableModel();// conexion con la tabla y generar clic
 
// para la tabra de reportes de los porcentajes
  DefaultTableModel modelPorcentajesClienteDni= new DefaultTableModel(); 
  DefaultTableModel modelPorcentajesClienteRuc= new DefaultTableModel(); 
  
// metodo para el color de celas
  ColorCeldaTabla MensajeroColorFila= new ColorCeldaTabla();
 //metodo para el color del encabezado de tabla
  GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla();
 //metodo para agregar radioboton a la tabla
  AgregarRadioBotton MensajeroAgegarRadioBotton= new AgregarRadioBotton(); 

 String dia, me,mes, año;int di,m2,y3;
     public ReportesPedidos() {
     initComponents();
          // metodo calendario para la fecha
     Calendar calendario= Calendar.getInstance();
     dia=Integer.toString(calendario.get(Calendar.DATE));
     me= Integer.toString(calendario.get(Calendar.MONTH)+1);
     año= Integer.toString(calendario.get(Calendar.YEAR));
     
   
              TablaPorcentajesClienteDni.setVisible(false);
              TablaPorcentajesClienteRUC.setVisible(false);
//___________________________ TABLA DE PRODUCTOS  POR FECHA DE ONGRESO ____________________


    try {    String Mensaje="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select doc_Ident_cliente,Tipo,Serie_venta, Numero_Venta,codigo_producto,Descripcion_pro, cantidad_pro,Precio_uni,Monto_generado,"
                    + "Dia_pedido,Mes_pedido,Año_pedido from detalle_pedidos");
            ResultSet resul1=pst1.executeQuery();
           if(resul1.next())
          {
          String DIA= resul1.getString("Dia_pedido");
          String MES= resul1.getString("Mes_pedido");
          String AÑO= resul1.getString("Año_pedido");
            
                 Mensaje=DIA+"/"+MES+"/"+AÑO;
            
          }
         //  
            tablaDeVentas = new JTable(modelTodosPedidos);
            jScrollPane2.setViewportView(tablaDeVentas);
            modelTodosPedidos.addColumn("DOC. CLIENTE");
            modelTodosPedidos.addColumn("DOC. VENTA");
            modelTodosPedidos.addColumn("N. Venta");
            modelTodosPedidos.addColumn("COD. PRODUCTO");
            modelTodosPedidos.addColumn("DESCRIPCION");
            modelTodosPedidos.addColumn("CANTIDAD");
            modelTodosPedidos.addColumn("PRECIO");
            modelTodosPedidos.addColumn("MONTO");
            modelTodosPedidos.addColumn("FECHA");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
            {
                tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
            {
                tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            
             tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
             tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
             tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
             tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
             tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
             tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
             tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
             tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
          
             tablaDeVentas.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[9];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   fila[2]= resul1.getObject(3)+" "+resul1.getObject(4);
                   fila[3]= resul1.getObject(5);
                   fila[4]= resul1.getObject(6);
                   fila[5]= resul1.getObject(7);
                   fila[6]= "S/."+resul1.getObject(8);
                   fila[7]= "S/."+resul1.getObject(9);
                   fila[8]= Mensaje;
                   modelTodosPedidos.addRow(fila);
                }
                cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla DE PEDIDOS "+e);
        }
    
    
//________________________________[VENTAS POR FECHA]________________________________
     //*********************** HOY *****************
      try {   String codigoPro,categ_pro=""; 
              int abarrotes=0,Bebidas=0,Cervezas=0,Comida_Masc=0,Dulces=0,Frutas_Verdu=0,Lact_Huev=0,Prod_Limp=0,Panaderia_pastel=0,Alimen_Congel=0;
          Connection cn1= Conexion.Conectar();
          PreparedStatement pst1= cn1.prepareStatement("select codigo_producto from detalle_pedidos where Fecha_pedido='"+dia+"/"+me+"/"+año+"'");
          ResultSet resul1 = pst1.executeQuery();
          while(resul1.next())
          {
          codigoPro= resul1.getString("codigo_producto");
           try {
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select Categoria_pro from tabla_productos where Codigo_pro='" + codigoPro +"'");
                ResultSet resul2 = pst2.executeQuery();
                if(resul2.next())
                {
                categ_pro= resul2.getString("Categoria_pro");
                if(categ_pro.equalsIgnoreCase("Abarrotes")){
                    abarrotes++;
                }
                if(categ_pro.equalsIgnoreCase("Bebidas")){
                    Bebidas++;
                }
                if(categ_pro.equalsIgnoreCase("Cervezas")){
                    Cervezas++;
                }
                if(categ_pro.equalsIgnoreCase("Comida Mascotas")){
                    Comida_Masc++;
                }
                if(categ_pro.equalsIgnoreCase("Dulces")){
                    Dulces++;
                }
                if(categ_pro.equalsIgnoreCase("Frutas y Verduras")){
                    Frutas_Verdu++;
                }
                if(categ_pro.equalsIgnoreCase("Lacteos y Huevos")){
                    Lact_Huev++;
                }
                if(categ_pro.equalsIgnoreCase("Productos de Limpieza")){
                    Prod_Limp++;
                }
                if(categ_pro.equalsIgnoreCase("Panaderia y pasteleria")){
                    Panaderia_pastel++;
                }
                if(categ_pro.equalsIgnoreCase("Alimentos Congelados")){
                    Alimen_Congel++;
                }
                }
           } catch (Exception e) {System.err.println("error en  recuperar categoria de producto :"+e);  }
   
           }
          cn1.close();
                GrficoBarrasCategoriaPro(abarrotes, Bebidas, Dulces, Prod_Limp, Cervezas, Comida_Masc, Frutas_Verdu, Lact_Huev, Panaderia_pastel, Alimen_Congel);
       
          } catch (Exception e) { System.err.println("error en  recuperar codigo de producto :"+e); }
    
      
      
 //________________________llenado de tablas cliente masivo_____________________________
     try {
        String nom_apell="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Dni_cliente, Nombre_cliente, Apellidos_cliente from tabla_clientes");
            ResultSet resul1=pst1.executeQuery();
            
            // AGREGAR ENCABEZADOS A LA TABLA
            tabla_clientesMasivos = new JTable(modelCleintesMasivos);
            jScrollPane_clientesMasivos.setViewportView(tabla_clientesMasivos);
            modelCleintesMasivos.addColumn("DNI");
            modelCleintesMasivos.addColumn("Nonmbre Apellidos");
             
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(tabla_clientesMasivos.getColumnCount());i++)
            {   tabla_clientesMasivos.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);    }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(tabla_clientesMasivos.getColumnCount());i++)
            {   tabla_clientesMasivos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);            }

             tabla_clientesMasivos.getColumnModel().getColumn(0).setPreferredWidth(40);//dimensionar columna 0
             tabla_clientesMasivos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             tabla_clientesMasivos.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
             while (resul1.next()) {
                Object[] fila= new Object[2];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2)+" "+resul1.getObject(3);
                   modelCleintesMasivos.addRow(fila);
                }
            
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla de clientes masivos :"+e);
        }
     //crreamos metodo para el EVENTO de la TABLA
        tabla_clientesMasivos.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
         int fila_poin=tabla_clientesMasivos.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            String DNI_clienteTabla=(String)modelCleintesMasivos.getValueAt(fila_poin,0);
            String NombreClienteTabla=(String)modelCleintesMasivos.getValueAt(fila_poin,1);
            // recuperamos metodo para  ostrar informacion de celda selecionada
                GrficoBarrascClienteDNI(DNI_clienteTabla,NombreClienteTabla);
                
            }
         }  
        });
        
 //________________________llenado de tablas cliente RUC_____________________________
      try {
        String razon;
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Ruc_cliente , Razon_cliente from tabla_clientesruc");
            ResultSet resul1=pst1.executeQuery();
            
            // AGREGAR ENCABEZADOS A LA TABLA
            tabla_clienteRUC = new JTable(modelCleintesRuc);
            jScrollPane_clientesRuc.setViewportView(tabla_clienteRUC);
            modelCleintesRuc.addColumn("RUC");
            modelCleintesRuc.addColumn("Razón Social");
             
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(tabla_clienteRUC.getColumnCount());i++)
            {
                tabla_clienteRUC.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(tabla_clienteRUC.getColumnCount());i++)
            {
                tabla_clienteRUC.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }

             tabla_clienteRUC.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
             tabla_clienteRUC.getColumnModel().getColumn(1).setPreferredWidth(250);//dimensionar columna 0
             tabla_clienteRUC.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
             while (resul1.next()) {
                Object[] fila= new Object[2];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   modelCleintesRuc.addRow(fila);
                }
            
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla de clientes Ruc :"+e);
        }
     //crreamos metodo para el EVENTO de la TABLA
        tabla_clienteRUC.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
         int fila_poin=tabla_clienteRUC.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            String RUC_clienteTabla=(String)modelCleintesRuc.getValueAt(fila_poin,0);
            String RAZONClienteTabla=(String)modelCleintesRuc.getValueAt(fila_poin,1);
            // recuperamos metodo para  optener informacion de celda selecionada
            GrficoBarrascClienteRUC(RUC_clienteTabla, RAZONClienteTabla); }
            }  
        });
        
     
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        VentasRegistradas = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDeVentas = new javax.swing.JTable();
        txt_filtroCodigo = new javax.swing.JTextField();
        cmb_FiltarPedidos = new javax.swing.JComboBox<>();
        hoy = new javax.swing.JDesktopPane();
        PANEL_HOY = new javax.swing.JPanel();
        cmb_dia = new javax.swing.JComboBox<>();
        cmb_año = new javax.swing.JComboBox<>();
        cmb_mes = new javax.swing.JComboBox<>();
        boton_estatus = new javax.swing.JButton();
        Ventas_por_cliente = new javax.swing.JTabbedPane();
        clienteRUC = new javax.swing.JDesktopPane();
        jScrollPane_clientesMasivos = new javax.swing.JScrollPane();
        tabla_clientesMasivos = new javax.swing.JTable();
        Panel_clienteDNI = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPorcentajesClienteDni = new javax.swing.JTable();
        botonActualizarClienteDni = new javax.swing.JButton();
        cmb_clienteDni = new javax.swing.JComboBox<>();
        txt_filtroClienteDNI = new javax.swing.JTextField();
        ClienteMasivo = new javax.swing.JDesktopPane();
        jScrollPane_clientesRuc = new javax.swing.JScrollPane();
        tabla_clienteRUC = new javax.swing.JTable();
        Panel_clienteRUC = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaPorcentajesClienteRUC = new javax.swing.JTable();
        botonActualizarClienteruc = new javax.swing.JButton();
        cmb_clienteRuc = new javax.swing.JComboBox<>();
        txt_filtroClienteRUC = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estadistica de pedidos");
        setInheritsPopupMenu(true);

        jTabbedPane2.setBackground(new java.awt.Color(0, 153, 153));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        tablaDeVentas.setBackground(new java.awt.Color(0, 255, 0));
        tablaDeVentas.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        tablaDeVentas.setForeground(new java.awt.Color(102, 102, 102));
        tablaDeVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDeVentas.setDragEnabled(true);
        tablaDeVentas.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(tablaDeVentas);

        txt_filtroCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txt_filtroCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_filtroCodigo.setForeground(new java.awt.Color(153, 0, 0));
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

        cmb_FiltarPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Documento Identidad Cliente", "Documento de Venta ", "Numero de Venta", "Codigo de Producto", "Descripcion", "Cantidad", "Precio", "Monto", "Fecha" }));

        VentasRegistradas.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        VentasRegistradas.setLayer(txt_filtroCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        VentasRegistradas.setLayer(cmb_FiltarPedidos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout VentasRegistradasLayout = new javax.swing.GroupLayout(VentasRegistradas);
        VentasRegistradas.setLayout(VentasRegistradasLayout);
        VentasRegistradasLayout.setHorizontalGroup(
            VentasRegistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentasRegistradasLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(cmb_FiltarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(txt_filtroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentasRegistradasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        VentasRegistradasLayout.setVerticalGroup(
            VentasRegistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentasRegistradasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(VentasRegistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_filtroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_FiltarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("-Ventas Registradas-", VentasRegistradas);

        javax.swing.GroupLayout PANEL_HOYLayout = new javax.swing.GroupLayout(PANEL_HOY);
        PANEL_HOY.setLayout(PANEL_HOYLayout);
        PANEL_HOYLayout.setHorizontalGroup(
            PANEL_HOYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PANEL_HOYLayout.setVerticalGroup(
            PANEL_HOYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cmb_dia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_dia.setForeground(new java.awt.Color(102, 102, 0));
        cmb_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmb_dia.setBorder(null);

        cmb_año.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_año.setForeground(new java.awt.Color(102, 102, 0));
        cmb_año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2019" }));
        cmb_año.setBorder(null);

        cmb_mes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_mes.setForeground(new java.awt.Color(102, 102, 0));
        cmb_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Marzo", "Abril", "Mayo", "junio", "Julio", "Agosto", "septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cmb_mes.setBorder(null);

        boton_estatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estatus1.png"))); // NOI18N
        boton_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_estatusActionPerformed(evt);
            }
        });

        hoy.setLayer(PANEL_HOY, javax.swing.JLayeredPane.DEFAULT_LAYER);
        hoy.setLayer(cmb_dia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        hoy.setLayer(cmb_año, javax.swing.JLayeredPane.DEFAULT_LAYER);
        hoy.setLayer(cmb_mes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        hoy.setLayer(boton_estatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout hoyLayout = new javax.swing.GroupLayout(hoy);
        hoy.setLayout(hoyLayout);
        hoyLayout.setHorizontalGroup(
            hoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hoyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PANEL_HOY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(hoyLayout.createSequentialGroup()
                        .addGap(0, 915, Short.MAX_VALUE)
                        .addComponent(cmb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_año, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(boton_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        hoyLayout.setVerticalGroup(
            hoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hoyLayout.createSequentialGroup()
                        .addGroup(hoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PANEL_HOY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(hoyLayout.createSequentialGroup()
                        .addComponent(boton_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 427, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("-Ventas Por Fecha-", hoy);

        Ventas_por_cliente.setBackground(new java.awt.Color(0, 204, 204));
        Ventas_por_cliente.setForeground(new java.awt.Color(255, 255, 255));
        Ventas_por_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tabla_clientesMasivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "DNI", "Nombre Apellidos"
            }
        ));
        jScrollPane_clientesMasivos.setViewportView(tabla_clientesMasivos);

        javax.swing.GroupLayout Panel_clienteDNILayout = new javax.swing.GroupLayout(Panel_clienteDNI);
        Panel_clienteDNI.setLayout(Panel_clienteDNILayout);
        Panel_clienteDNILayout.setHorizontalGroup(
            Panel_clienteDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        Panel_clienteDNILayout.setVerticalGroup(
            Panel_clienteDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        TablaPorcentajesClienteDni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Categorias", "Porcentaje", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaPorcentajesClienteDni);

        botonActualizarClienteDni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonActualizarClienteDni.setForeground(new java.awt.Color(153, 0, 0));
        botonActualizarClienteDni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        botonActualizarClienteDni.setBorder(null);
        botonActualizarClienteDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarClienteDniActionPerformed(evt);
            }
        });

        cmb_clienteDni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "Nombre" }));

        txt_filtroClienteDNI.setBackground(new java.awt.Color(204, 204, 204));
        txt_filtroClienteDNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_filtroClienteDNI.setForeground(new java.awt.Color(153, 0, 0));
        txt_filtroClienteDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_filtroClienteDNI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_filtroClienteDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_filtroClienteDNIActionPerformed(evt);
            }
        });
        txt_filtroClienteDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroClienteDNIKeyReleased(evt);
            }
        });

        clienteRUC.setLayer(jScrollPane_clientesMasivos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        clienteRUC.setLayer(Panel_clienteDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        clienteRUC.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        clienteRUC.setLayer(botonActualizarClienteDni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        clienteRUC.setLayer(cmb_clienteDni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        clienteRUC.setLayer(txt_filtroClienteDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout clienteRUCLayout = new javax.swing.GroupLayout(clienteRUC);
        clienteRUC.setLayout(clienteRUCLayout);
        clienteRUCLayout.setHorizontalGroup(
            clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteRUCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clienteRUCLayout.createSequentialGroup()
                        .addComponent(cmb_clienteDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_filtroClienteDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane_clientesMasivos, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(Panel_clienteDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clienteRUCLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addComponent(botonActualizarClienteDni, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(clienteRUCLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        clienteRUCLayout.setVerticalGroup(
            clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteRUCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clienteRUCLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_clienteDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_filtroClienteDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane_clientesMasivos, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(clienteRUCLayout.createSequentialGroup()
                        .addComponent(botonActualizarClienteDni, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(clienteRUCLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Panel_clienteDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        Ventas_por_cliente.addTab("Clientes Masivos", clienteRUC);

        tabla_clienteRUC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "RUC", "Razón Social"
            }
        ));
        jScrollPane_clientesRuc.setViewportView(tabla_clienteRUC);

        javax.swing.GroupLayout Panel_clienteRUCLayout = new javax.swing.GroupLayout(Panel_clienteRUC);
        Panel_clienteRUC.setLayout(Panel_clienteRUCLayout);
        Panel_clienteRUCLayout.setHorizontalGroup(
            Panel_clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        Panel_clienteRUCLayout.setVerticalGroup(
            Panel_clienteRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        TablaPorcentajesClienteRUC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Categorias", "Porcentaje", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaPorcentajesClienteRUC);

        botonActualizarClienteruc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonActualizarClienteruc.setForeground(new java.awt.Color(153, 0, 0));
        botonActualizarClienteruc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        botonActualizarClienteruc.setBorder(null);
        botonActualizarClienteruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarClienterucActionPerformed(evt);
            }
        });

        cmb_clienteRuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "Razon Social" }));

        txt_filtroClienteRUC.setBackground(new java.awt.Color(204, 204, 204));
        txt_filtroClienteRUC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_filtroClienteRUC.setForeground(new java.awt.Color(153, 0, 0));
        txt_filtroClienteRUC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_filtroClienteRUC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_filtroClienteRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_filtroClienteRUCActionPerformed(evt);
            }
        });
        txt_filtroClienteRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroClienteRUCKeyReleased(evt);
            }
        });

        ClienteMasivo.setLayer(jScrollPane_clientesRuc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ClienteMasivo.setLayer(Panel_clienteRUC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ClienteMasivo.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ClienteMasivo.setLayer(botonActualizarClienteruc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ClienteMasivo.setLayer(cmb_clienteRuc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ClienteMasivo.setLayer(txt_filtroClienteRUC, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout ClienteMasivoLayout = new javax.swing.GroupLayout(ClienteMasivo);
        ClienteMasivo.setLayout(ClienteMasivoLayout);
        ClienteMasivoLayout.setHorizontalGroup(
            ClienteMasivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClienteMasivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClienteMasivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_clientesRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ClienteMasivoLayout.createSequentialGroup()
                        .addComponent(cmb_clienteRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_filtroClienteRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(Panel_clienteRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ClienteMasivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizarClienteruc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        ClienteMasivoLayout.setVerticalGroup(
            ClienteMasivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClienteMasivoLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(ClienteMasivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_clienteRUC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClienteMasivoLayout.createSequentialGroup()
                        .addGroup(ClienteMasivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_clienteRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_filtroClienteRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane_clientesRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(ClienteMasivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonActualizarClienteruc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Ventas_por_cliente.addTab("Clientes Ruc", ClienteMasivo);

        jTabbedPane2.addTab("Ventas Por Cliente", Ventas_por_cliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        //******** METODO PARA RELLENAR TABLA ********
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void boton_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_estatusActionPerformed
        dia=cmb_dia.getSelectedItem().toString();
      me=cmb_mes.getSelectedItem().toString();
      año=cmb_año.getSelectedItem().toString();
     
     if(me.equalsIgnoreCase("enero")){
         mes="1";
     }
     if(me.equalsIgnoreCase("febrero")){
         mes="2";
     }
     if(me.equalsIgnoreCase("marzo")){
         mes="3";
     }
     if(me.equalsIgnoreCase("abril")){
         mes="4";
     }
     if(me.equalsIgnoreCase("mayo")){
        mes="5"; 
     }
     if(me.equalsIgnoreCase("junio")){
         mes="6";
     }
     if(me.equalsIgnoreCase("julio")){
         mes="7";
     }
     if(me.equalsIgnoreCase("agosto")){
         mes="8";
     }
     if(me.equalsIgnoreCase("septiembre")){
         mes="9";
     }
     if(me.equalsIgnoreCase("octubre")){
         mes="10";
     }
     if(me.equalsIgnoreCase("noviembre")){
         mes="11";
     }
     if(me.equalsIgnoreCase("diciembre")){
         mes="12";
     }
         try {   String codigoPro,categ_pro=""; 
              int abarrotes=0,Bebidas=0,Cervezas=0,Comida_Masc=0,Dulces=0,Frutas_Verdu=0,Lact_Huev=0,Prod_Limp=0,Panaderia_pastel=0,Alimen_Congel=0;
          Connection cn1= Conexion.Conectar();
          PreparedStatement pst1= cn1.prepareStatement("select codigo_producto from detalle_pedidos where Fecha_pedido='"+dia+"/"+mes+"/"+año+"'");
          ResultSet resul1 = pst1.executeQuery();
          while(resul1.next())
          {
          codigoPro= resul1.getString("codigo_producto");
           try {
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select Categoria_pro from tabla_productos where Codigo_pro='" + codigoPro +"'");
                ResultSet resul2 = pst2.executeQuery();
                if(resul2.next())
                {
                categ_pro= resul2.getString("Categoria_pro");
                if(categ_pro.equalsIgnoreCase("Abarrotes")){
                    abarrotes++;
                }
                if(categ_pro.equalsIgnoreCase("Bebidas")){
                    Bebidas++;
                }
                if(categ_pro.equalsIgnoreCase("Cervezas")){
                    Cervezas++;
                }
                if(categ_pro.equalsIgnoreCase("Comida Mascotas")){
                    Comida_Masc++;
                }
                if(categ_pro.equalsIgnoreCase("Dulces")){
                    Dulces++;
                }
                if(categ_pro.equalsIgnoreCase("Frutas y Verduras")){
                    Frutas_Verdu++;
                }
                if(categ_pro.equalsIgnoreCase("Lacteos y Huevos")){
                    Lact_Huev++;
                }
                if(categ_pro.equalsIgnoreCase("Productos de Limpieza")){
                    Prod_Limp++;
                }
                if(categ_pro.equalsIgnoreCase("Panaderia y pasteleria")){
                    Panaderia_pastel++;
                }
                if(categ_pro.equalsIgnoreCase("Alimentos Congelados")){
                    Alimen_Congel++;
                }
                }
           } catch (Exception e) {System.err.println("error en  recuperar categoria de producto :"+e);  }
   
              }
          cn1.close();
            GrficoBarrasCategoriaPro(abarrotes, Bebidas, Dulces, Prod_Limp, Cervezas, Comida_Masc, Frutas_Verdu, Lact_Huev, Panaderia_pastel, Alimen_Congel);
        
          } catch (Exception e) { System.err.println("error en  recuperar codigo de producto :"+e); }
    
        
       
    }//GEN-LAST:event_boton_estatusActionPerformed

    private void botonActualizarClienteDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarClienteDniActionPerformed
        ActualizarVentana();
    }//GEN-LAST:event_botonActualizarClienteDniActionPerformed

    private void botonActualizarClienterucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarClienterucActionPerformed
        ActualizarVentana();
    }//GEN-LAST:event_botonActualizarClienterucActionPerformed

    private void txt_filtroClienteRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroClienteRUCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroClienteRUCActionPerformed

    private void txt_filtroClienteRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroClienteRUCKeyReleased
              //cuando el usuario teclee en el buscador
        try
        {// en texto escrito a consultar en la tabla
            String texto="%"+txt_filtroClienteRUC.getText().trim()+"%";

            // secuberra el tipo de filtro
            String filtroSelec=cmb_clienteRuc.getSelectedItem().toString();

            // ETIQUETAS DE EMCABEZADO DE TABLA
            String[] titulos={"RUC","RAZÓN SOCIAL"};
            modelCleintesRuc=new DefaultTableModel(null,titulos)
            {// este metodo permite que la tabla NO sea editada
                @Override
                public boolean isCellEditable(int row, int column)
                {
                    if(column==2)
                    {return true;}
                    else{return false;}
                }
            };

            // FUNCIONES DEPENDIENDO DEL TIPO DE FILTRO ELEGIDO
            switch (filtroSelec)
            {//*********** FILTRO PARA CODIGO DE Documento Identidad Cliente ************
                case"RUC":
                Connection cn= Conexion.Conectar();
                PreparedStatement pst= cn.prepareStatement("select *from tabla_clientesruc where Ruc_cliente like"+'"'+texto+'"');
                String[] fila= new String[2];
                ResultSet resul=pst.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tabla_clienteRUC = new JTable(modelCleintesRuc);
                jScrollPane_clientesRuc.setViewportView(tabla_clienteRUC);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tabla_clienteRUC.getColumnCount());i++)
                {tabla_clienteRUC.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tabla_clienteRUC.getColumnCount());i++)
                {tabla_clienteRUC.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tabla_clienteRUC.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tabla_clienteRUC.getColumnModel().getColumn(1).setPreferredWidth(250);//dimensionar columna 0
                tabla_clienteRUC.setRowHeight(18);
 
                //recuperar valores de BD A LA TABLA
                while(resul.next())
                {
                    fila[0]=resul.getString("Ruc_cliente");
                    fila[1]=resul.getString("Razon_cliente");
                     modelCleintesRuc.addRow(fila);
                }
                cn.close();
          //crreamos metodo para el EVENTO de la TABLA
        tabla_clienteRUC.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
         int fila_poin=tabla_clienteRUC.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            String RUC_clienteTabla=(String)modelCleintesRuc.getValueAt(fila_poin,0);
            String RAZONClienteTabla=(String)modelCleintesRuc.getValueAt(fila_poin,1);
            // recuperamos metodo para  optener informacion de celda selecionada
            GrficoBarrascClienteRUC(RUC_clienteTabla, RAZONClienteTabla); }
            }  
        });
                
                
                break;
                
               //***********  FILTRAR POR NOMBRE DE CLIENTEe ************
                case"Razon Social":
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select *from tabla_clientesruc where Razon_cliente like"+'"'+texto+'"');
                String[] fila2= new String[2];
                ResultSet resul2=pst2.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tabla_clienteRUC = new JTable(modelCleintesRuc);
                jScrollPane_clientesRuc.setViewportView(tabla_clienteRUC);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tabla_clienteRUC.getColumnCount());i++)
                {tabla_clienteRUC.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tabla_clienteRUC.getColumnCount());i++)
                {tabla_clienteRUC.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                   tabla_clienteRUC.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tabla_clienteRUC.getColumnModel().getColumn(1).setPreferredWidth(250);//dimensionar columna 0
                tabla_clienteRUC.setRowHeight(18);
 
                //recuperar valores de BD A LA TABLA
                while(resul2.next())
                {
                    fila2[0]=resul2.getString("Ruc_cliente");
                    fila2[1]=resul2.getString("Razon_cliente");
                     modelCleintesRuc.addRow(fila2);
                }
                cn2.close();
            //crreamos metodo para el EVENTO de la TABLA
        tabla_clienteRUC.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
         int fila_poin=tabla_clienteRUC.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            String RUC_clienteTabla=(String)modelCleintesRuc.getValueAt(fila_poin,0);
            String RAZONClienteTabla=(String)modelCleintesRuc.getValueAt(fila_poin,1);
            // recuperamos metodo para  optener informacion de celda selecionada
            GrficoBarrascClienteRUC(RUC_clienteTabla, RAZONClienteTabla); }
            }  
        });
                break;
           

           
            }

            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error al filtar!!!, contacte al Administrador","",JOptionPane.ERROR_MESSAGE);
                System.err.println("error al filtar la busqueda: "+e);
            }

    }//GEN-LAST:event_txt_filtroClienteRUCKeyReleased

    private void txt_filtroClienteDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroClienteDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroClienteDNIActionPerformed

    private void txt_filtroClienteDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroClienteDNIKeyReleased
         //cuando el usuario teclee en el buscador
        try
        {// en texto escrito a consultar en la tabla
            String texto="%"+txt_filtroClienteDNI.getText().trim()+"%";

            // secuberra el tipo de filtro
            String filtroSelec=cmb_clienteDni.getSelectedItem().toString();

            // ETIQUETAS DE EMCABEZADO DE TABLA
            String[] titulos={"DNI","NOMBRE Y APELLIDOS"};
            modelCleintesMasivos=new DefaultTableModel(null,titulos)
            {// este metodo permite que la tabla NO sea editada
                @Override
                public boolean isCellEditable(int row, int column)
                {
                    if(column==2)
                    {return true;}
                    else{return false;}
                }
            };

            // FUNCIONES DEPENDIENDO DEL TIPO DE FILTRO ELEGIDO
            switch (filtroSelec)
            {//*********** FILTRO PARA CODIGO DE Documento Identidad Cliente ************
                case"DNI":
                Connection cn= Conexion.Conectar();
                PreparedStatement pst= cn.prepareStatement("select *from tabla_clientes where Dni_cliente like"+'"'+texto+'"');
                String[] fila= new String[2];
                ResultSet resul=pst.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tabla_clientesMasivos = new JTable(modelCleintesMasivos);
                jScrollPane_clientesMasivos.setViewportView(tabla_clientesMasivos);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tabla_clientesMasivos.getColumnCount());i++)
                {tabla_clientesMasivos.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tabla_clientesMasivos.getColumnCount());i++)
                {tabla_clientesMasivos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tabla_clientesMasivos.getColumnModel().getColumn(0).setPreferredWidth(40);//dimensionar columna 0
                tabla_clientesMasivos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
                tabla_clientesMasivos.setRowHeight(18);
 
                //recuperar valores de BD A LA TABLA
                while(resul.next())
                {
                    fila[0]=resul.getString("Dni_cliente");
                    fila[1]=resul.getString("Nombre_cliente")+" "+resul.getString("Apellidos_cliente");
                     modelCleintesMasivos.addRow(fila);
                }
                cn.close();
                         //crreamos metodo para el EVENTO de la TABLA
             tabla_clientesMasivos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
               int fila_poin=tabla_clientesMasivos.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            String DNI_clienteTabla=(String)modelCleintesMasivos.getValueAt(fila_poin,0);
            String NombreClienteTabla=(String)modelCleintesMasivos.getValueAt(fila_poin,1);
            // recuperamos metodo para  ostrar informacion de celda selecionada
                GrficoBarrascClienteDNI(DNI_clienteTabla,NombreClienteTabla);
                
            }
            }  
            });
                break;
                
               //***********  FILTRAR POR NOMBRE DE CLIENTEe ************
                case"Nombre":
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select *from tabla_clientes where Nombre_cliente like"+'"'+texto+'"');
                String[] fila2= new String[2];
                ResultSet resul2=pst2.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tabla_clientesMasivos = new JTable(modelCleintesMasivos);
                jScrollPane_clientesMasivos.setViewportView(tabla_clientesMasivos);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tabla_clientesMasivos.getColumnCount());i++)
                {tabla_clientesMasivos.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tabla_clientesMasivos.getColumnCount());i++)
                {tabla_clientesMasivos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tabla_clientesMasivos.getColumnModel().getColumn(0).setPreferredWidth(40);//dimensionar columna 0
                tabla_clientesMasivos.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
                tabla_clientesMasivos.setRowHeight(18);
 
                //recuperar valores de BD A LA TABLA
                while(resul2.next())
                {
                    fila2[0]=resul2.getString("Dni_cliente");
                    fila2[1]=resul2.getString("Nombre_cliente")+" "+resul2.getString("Apellidos_cliente");
                     modelCleintesMasivos.addRow(fila2);
                }
                cn2.close();
                     //crreamos metodo para el EVENTO de la TABLA
             tabla_clientesMasivos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
               int fila_poin=tabla_clientesMasivos.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            String DNI_clienteTabla=(String)modelCleintesMasivos.getValueAt(fila_poin,0);
            String NombreClienteTabla=(String)modelCleintesMasivos.getValueAt(fila_poin,1);
            // recuperamos metodo para  ostrar informacion de celda selecionada
                GrficoBarrascClienteDNI(DNI_clienteTabla,NombreClienteTabla);
                
            }
            }  
            });
           break;
           

           
            }

            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error al filtar!!!, contacte al Administrador","",JOptionPane.ERROR_MESSAGE);
                System.err.println("error al filtar la busqueda: "+e);
            }

    }//GEN-LAST:event_txt_filtroClienteDNIKeyReleased

    private void txt_filtroCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroCodigoKeyReleased
        //cuando el usuario teclee en el buscador
        try
        {// en texto escrito a consultar en la tabla
            String texto="%"+txt_filtroCodigo.getText().trim()+"%";

            // secuberra el tipo de filtro
            String filtroSelec=cmb_FiltarPedidos.getSelectedItem().toString();

            // ETIQUETAS DE EMCABEZADO DE TABLA
            String[] titulos={"DOC. CLIENTE","DOC. VENTA","N. Venta","COD. PRODUCTO","DESCRIPCION","CANTIDAD","PRECIO","MONTO","FECHA"};
            modelTodosPedidos=new DefaultTableModel(null,titulos)
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
            {//*********** FILTRO PARA CODIGO DE Documento Identidad Cliente ************
                case"Documento Identidad Cliente":
                Connection cn= Conexion.Conectar();
                PreparedStatement pst= cn.prepareStatement("select *from detalle_pedidos where doc_Ident_cliente like"+'"'+texto+'"');
                String[] fila= new String[9];
                ResultSet resul=pst.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul.next())
                {
                    fila[0]=resul.getString("doc_Ident_cliente");
                    fila[1]=resul.getString("Tipo");
                    fila[2]=resul.getString("Numero_Venta");
                    fila[3]=resul.getString("codigo_producto");
                    fila[4]=resul.getString("Descripcion_pro");
                    fila[5]=resul.getString("cantidad_pro");
                    fila[6]="s/."+resul.getString("Precio_uni");
                    fila[7]="s/."+resul.getString("Monto_generado");
                    fila[8]=resul.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila);
                }
                cn.close();
                break;
                //*********** FILTRO PARA CODIGO DE Documento Identidad Cliente ************
                case"Documento de Venta ":
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select *from detalle_pedidos where Tipo like"+'"'+texto+'"');
                String[] fila2= new String[9];
                ResultSet resul2=pst2.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul2.next())
                {
                    fila2[0]=resul2.getString("doc_Ident_cliente");
                    fila2[1]=resul2.getString("Tipo");
                    fila2[2]=resul2.getString("Serie_venta")+" "+resul2.getString("Numero_Venta");
                    fila2[3]=resul2.getString("codigo_producto");
                    fila2[4]=resul2.getString("Descripcion_pro");
                    fila2[5]=resul2.getString("cantidad_pro");
                    fila2[6]="s/."+resul2.getString("Precio_uni");
                    fila2[7]="s/."+resul2.getString("Monto_generado");
                    fila2[8]=resul2.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila2);
                }
                cn2.close();
                break;
                //*********** FILTRO PARA CODIGO DE Documento Identidad Cliente ************
                case"Numero de Venta":
                Connection cn3= Conexion.Conectar();
                PreparedStatement pst3= cn3.prepareStatement("select *from detalle_pedidos where Numero_Venta like"+'"'+texto+'"');
                String[] fila3= new String[9];
                ResultSet resul3=pst3.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul3.next())
                {
                    fila3[0]=resul3.getString("doc_Ident_cliente");
                    fila3[1]=resul3.getString("Tipo");
                    fila3[2]=resul3.getString("Serie_venta")+" "+resul3.getString("Numero_Venta");
                    fila3[3]=resul3.getString("codigo_producto");
                    fila3[4]=resul3.getString("Descripcion_pro");
                    fila3[5]=resul3.getString("cantidad_pro");
                    fila3[6]="s/."+resul3.getString("Precio_uni");
                    fila3[7]="s/."+resul3.getString("Monto_generado");
                    fila3[8]=resul3.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila3);
                }
                cn3.close();
                break;

                //*********** FILTRO PARA CODIGO DE PRODUCTOS ************
                case"Codigo de Producto":
                Connection cn4= Conexion.Conectar();
                PreparedStatement pst4= cn4.prepareStatement("select *from detalle_pedidos where codigo_producto like"+'"'+texto+'"');
                String[] fila4= new String[9];
                ResultSet resul4=pst4.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul4.next())
                {
                    fila4[0]=resul4.getString("doc_Ident_cliente");
                    fila4[1]=resul4.getString("Tipo");
                    fila4[2]=resul4.getString("Serie_venta")+" "+resul4.getString("Numero_Venta");
                    fila4[3]=resul4.getString("codigo_producto");
                    fila4[4]=resul4.getString("Descripcion_pro");
                    fila4[5]=resul4.getString("cantidad_pro");
                    fila4[6]="s/."+resul4.getString("Precio_uni");
                    fila4[7]="s/."+resul4.getString("Monto_generado");
                    fila4[8]=resul4.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila4);
                }
                cn4.close();
                break;

                //*********** FILTRO PARA CDESCRIPCION DE PRODUCTO ************
                case"Descripcion":
                Connection cn5= Conexion.Conectar();
                PreparedStatement pst5= cn5.prepareStatement("select *from detalle_pedidos where Descripcion_pro like"+'"'+texto+'"');
                String[] fila5= new String[9];
                ResultSet resul5=pst5.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul5.next())
                {
                    fila5[0]=resul5.getString("doc_Ident_cliente");
                    fila5[1]=resul5.getString("Tipo");
                    fila5[2]=resul5.getString("Serie_venta")+" "+resul5.getString("Numero_Venta");
                    fila5[3]=resul5.getString("codigo_producto");
                    fila5[4]=resul5.getString("Descripcion_pro");
                    fila5[5]=resul5.getString("cantidad_pro");
                    fila5[6]="s/."+resul5.getString("Precio_uni");
                    fila5[7]="s/."+resul5.getString("Monto_generado");
                    fila5[8]=resul5.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila5);
                }
                cn5.close();
                break;

                //*********** FILTRO PARA Cantidad ************
                case"Cantidad":
                Connection cn6= Conexion.Conectar();
                PreparedStatement pst6= cn6.prepareStatement("select *from detalle_pedidos where cantidad_pro like"+'"'+texto+'"');
                String[] fila6= new String[9];
                ResultSet resul6=pst6.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul6.next())
                {
                    fila6[0]=resul6.getString("doc_Ident_cliente");
                    fila6[1]=resul6.getString("Tipo");
                    fila6[2]=resul6.getString("Serie_venta")+" "+resul6.getString("Numero_Venta");
                    fila6[3]=resul6.getString("codigo_producto");
                    fila6[4]=resul6.getString("Descripcion_pro");
                    fila6[5]=resul6.getString("cantidad_pro");
                    fila6[6]="s/."+resul6.getString("Precio_uni");
                    fila6[7]="s/."+resul6.getString("Monto_generado");
                    fila6[8]=resul6.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila6);
                }
                cn6.close();
                break;

                //*********** FILTRO PARA CPRECIO ************
                case"Precio":
                Connection cn7= Conexion.Conectar();
                PreparedStatement pst7= cn7.prepareStatement("select *from detalle_pedidos where Precio_uni like"+'"'+texto+'"');
                String[] fila7= new String[9];
                ResultSet resul7=pst7.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul7.next())
                {
                    fila7[0]=resul7.getString("doc_Ident_cliente");
                    fila7[1]=resul7.getString("Tipo");
                    fila7[2]=resul7.getString("Serie_venta")+" "+resul7.getString("Numero_Venta");
                    fila7[3]=resul7.getString("codigo_producto");
                    fila7[4]=resul7.getString("Descripcion_pro");
                    fila7[5]=resul7.getString("cantidad_pro");
                    fila7[6]="s/."+resul7.getString("Precio_uni");
                    fila7[7]="s/."+resul7.getString("Monto_generado");
                    fila7[8]=resul7.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila7);
                }
                cn7.close();
                break;

                //*********** FILTRO PARA MONTO ************
                case"Monto":
                Connection cn8= Conexion.Conectar();
                PreparedStatement pst8= cn8.prepareStatement("select *from detalle_pedidos where Monto_generado like"+'"'+texto+'"');
                String[] fila8= new String[9];
                ResultSet resul8=pst8.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul8.next())
                {
                    fila8[0]=resul8.getString("doc_Ident_cliente");
                    fila8[1]=resul8.getString("Tipo");
                    fila8[2]=resul8.getString("Serie_venta")+" "+resul8.getString("Numero_Venta");
                    fila8[3]=resul8.getString("codigo_producto");
                    fila8[4]=resul8.getString("Descripcion_pro");
                    fila8[5]=resul8.getString("cantidad_pro");
                    fila8[6]="s/."+resul8.getString("Precio_uni");
                    fila8[7]="s/."+resul8.getString("Monto_generado");
                    fila8[8]=resul8.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila8);
                }
                cn8.close();
                break;

                //*********** FILTRO PARA CPRECIO ************
                case"Fecha":
                Connection cn9= Conexion.Conectar();
                PreparedStatement pst9= cn9.prepareStatement("select *from detalle_pedidos where Fecha_pedido like"+'"'+texto+'"');
                String[] fila9= new String[9];
                ResultSet resul9=pst9.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                tablaDeVentas = new JTable(modelTodosPedidos);
                jScrollPane2.setViewportView(tablaDeVentas);

                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(tablaDeVentas.getColumnCount());i++)
                {tablaDeVentas.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                tablaDeVentas.getColumnModel().getColumn(0).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(1).setMaxWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(2).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(3).setPreferredWidth(120);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(4).setPreferredWidth(450);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(5).setPreferredWidth(90);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(6).setMinWidth(100);//dimensionar columna 0
                tablaDeVentas.getColumnModel().getColumn(7).setPreferredWidth(100);//dimensionar columna 0
                tablaDeVentas.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul9.next())
                {
                    fila9[0]=resul9.getString("doc_Ident_cliente");
                    fila9[1]=resul9.getString("Tipo");
                    fila9[2]=resul9.getString("Serie_venta")+" "+resul9.getString("Numero_Venta");
                    fila9[3]=resul9.getString("codigo_producto");
                    fila9[4]=resul9.getString("Descripcion_pro");
                    fila9[5]=resul9.getString("cantidad_pro");
                    fila9[6]="s/."+resul9.getString("Precio_uni");
                    fila9[7]="s/."+resul9.getString("Monto_generado");
                    fila9[8]=resul9.getString("Fecha_pedido");
                    modelTodosPedidos.addRow(fila9);
                }
                cn9.close();
                break;
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al filtar!!!, contacte al Administrador","",JOptionPane.ERROR_MESSAGE);
            System.err.println("error al filtar la busqueda: "+e);
        }
    }//GEN-LAST:event_txt_filtroCodigoKeyReleased

    private void txt_filtroCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane ClienteMasivo;
    private javax.swing.JPanel PANEL_HOY;
    private javax.swing.JPanel Panel_clienteDNI;
    private javax.swing.JPanel Panel_clienteRUC;
    private javax.swing.JTable TablaPorcentajesClienteDni;
    private javax.swing.JTable TablaPorcentajesClienteRUC;
    private javax.swing.JDesktopPane VentasRegistradas;
    private javax.swing.JTabbedPane Ventas_por_cliente;
    private javax.swing.JButton botonActualizarClienteDni;
    private javax.swing.JButton botonActualizarClienteruc;
    private javax.swing.JButton boton_estatus;
    private javax.swing.JDesktopPane clienteRUC;
    private javax.swing.JComboBox<String> cmb_FiltarPedidos;
    private javax.swing.JComboBox<String> cmb_año;
    private javax.swing.JComboBox<String> cmb_clienteDni;
    private javax.swing.JComboBox<String> cmb_clienteRuc;
    private javax.swing.JComboBox<String> cmb_dia;
    private javax.swing.JComboBox<String> cmb_mes;
    private javax.swing.JDesktopPane hoy;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane_clientesMasivos;
    private javax.swing.JScrollPane jScrollPane_clientesRuc;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tablaDeVentas;
    private javax.swing.JTable tabla_clienteRUC;
    private javax.swing.JTable tabla_clientesMasivos;
    private javax.swing.JTextField txt_filtroClienteDNI;
    private javax.swing.JTextField txt_filtroClienteRUC;
    private javax.swing.JTextField txt_filtroCodigo;
    // End of variables declaration//GEN-END:variables

    // METODO QUE PERMITE GRAFICAR LAS CATEGORIAS DE LOS PRODUCTOS POR FECHA
public void GrficoBarrasCategoriaPro(int abarrotes,int Bebidas,int Dulces,int Prod_Limp,int Cervezas, int Comida_Masc ,int Frutas_Verdu, int Lact_Huev , int Panaderia_pastel, int Alimen_Congel){
        DefaultCategoryDataset ds= new DefaultCategoryDataset();
        ds.addValue(abarrotes, "Abarrotes",String.valueOf(abarrotes));
        ds.addValue(Bebidas, "Bebidas",String.valueOf(Bebidas));
        ds.addValue(Dulces, "Dulces",String.valueOf(Dulces));
        ds.addValue(Prod_Limp, "Productos Limpieza",String.valueOf(Prod_Limp));
        ds.addValue(Cervezas, "Cervezas",String.valueOf(Cervezas));
        ds.addValue(Comida_Masc, "Comida Mascotas",String.valueOf(Comida_Masc));
        ds.addValue(Frutas_Verdu, "Frutas y Verduras",String.valueOf(Frutas_Verdu));
        ds.addValue(Lact_Huev, "Lacteos y Huevos",String.valueOf(Lact_Huev));
        ds.addValue(Panaderia_pastel, "Panaderia y pasteleria",String.valueOf(Panaderia_pastel));
        ds.addValue(Alimen_Congel, "Alimentos Congelados",String.valueOf(Alimen_Congel));

        JFreeChart jf= ChartFactory.createBarChart3D("Productos Vendidos "+dia+"-"+me+"-"+año+"","Categorías","Cantidad",ds, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel= new ChartPanel(jf);
        PANEL_HOY.setLayout(new java.awt.BorderLayout());
        PANEL_HOY.add(panel);
        PANEL_HOY.validate();
    }

// METODO QUE PERMITE GRAFICAR ES TADO DE CONSUMO DE LOS CLINTES DNI
public void GrficoBarrascClienteDNI(String dniCliente, String NombreClienteTabla){
       try {   String codigoPro,categ_pro=""; 
       
        DecimalFormat decimal= new DecimalFormat("#");// 0 decimales
         double abarrotes=0,Bebidas=0,Cervezas=0,Comida_Masc=0,Dulces=0,Frutas_Verdu=0,Lact_Huev=0,Prod_Limp=0,Panaderia_pastel=0,Alimen_Congel=0;
          Connection cn1= Conexion.Conectar();
          PreparedStatement pst1= cn1.prepareStatement("select codigo_producto from detalle_pedidos where doc_Ident_cliente='"+dniCliente+"'");
          ResultSet resul1 = pst1.executeQuery();
          while(resul1.next())
          {
          codigoPro= resul1.getString("codigo_producto");
           try {
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select Categoria_pro from tabla_productos where Codigo_pro='" + codigoPro +"'");
                ResultSet resul2 = pst2.executeQuery();
                if(resul2.next())
                {
                categ_pro= resul2.getString("Categoria_pro");
                if(categ_pro.equalsIgnoreCase("Abarrotes")){
                    abarrotes++;
                }
                if(categ_pro.equalsIgnoreCase("Bebidas")){
                    Bebidas++;
                }
                if(categ_pro.equalsIgnoreCase("Cervezas")){
                    Cervezas++;
                }
                if(categ_pro.equalsIgnoreCase("Comida Mascotas")){
                    Comida_Masc++;
                }
                if(categ_pro.equalsIgnoreCase("Dulces")){
                    Dulces++;
                }
                if(categ_pro.equalsIgnoreCase("Frutas y Verduras")){
                    Frutas_Verdu++;
                }
                if(categ_pro.equalsIgnoreCase("Lacteos y Huevos")){
                    Lact_Huev++;
                }
                if(categ_pro.equalsIgnoreCase("Productos de Limpieza")){
                    Prod_Limp++;
                }
                if(categ_pro.equalsIgnoreCase("Panaderia y pasteleria")){
                    Panaderia_pastel++;
                }
                if(categ_pro.equalsIgnoreCase("Alimentos Congelados")){
                    Alimen_Congel++;
                }
                }
           } catch (Exception e) {System.err.println("error en  recuperar categoria de producto :"+e);  }
   
           }
          cn1.close();
       double sumaTotal=abarrotes+Bebidas+Dulces+Prod_Limp+Cervezas+Comida_Masc+Frutas_Verdu+Lact_Huev+Panaderia_pastel+Alimen_Congel;
       double porc_barrotes=(abarrotes/sumaTotal)*100;
       double porc_Bebidas=(Bebidas/sumaTotal)*100;
       double porc_Dulces=(Dulces/sumaTotal)*100;
       double porc_Limp =Prod_Limp/sumaTotal*100;
       double porc_Cervezas=(Cervezas/sumaTotal)*100;
       double porc_Comida_Masc=(Comida_Masc/sumaTotal)*100;
       double porc_Frutas_Verdu=(Frutas_Verdu/sumaTotal)*100;
       double porc_Lact_Huev=(Lact_Huev/sumaTotal)*100;
       double porc_Panaderia_pastel=(Panaderia_pastel/sumaTotal)*100;
       double porc_Alimen_Congel=(Alimen_Congel/sumaTotal)*100;
       
       TablaPorcentajesClienteDni.setVisible(true);
                 
        modelPorcentajesClienteDni.addColumn("Categoria");
        modelPorcentajesClienteDni.addColumn("Porcentaje");
        modelPorcentajesClienteDni.addColumn("Cantidad");
        modelPorcentajesClienteDni.addRow(new Object[]{"Abarrotes", decimal.format(porc_barrotes)+"%",decimal.format(abarrotes)});
        modelPorcentajesClienteDni.addRow(new Object[]{"Bebidas ", decimal.format(porc_Bebidas)+"%",decimal.format(Bebidas)});
        modelPorcentajesClienteDni.addRow(new Object[]{"Cervezas", decimal.format(porc_Cervezas)+"%",decimal.format(Cervezas)});
        modelPorcentajesClienteDni.addRow(new Object[]{"C.Mascotas",  decimal.format(porc_Comida_Masc)+"%",decimal.format(Comida_Masc)});
        modelPorcentajesClienteDni.addRow(new Object[]{"Dulces",  decimal.format(porc_Dulces)+"%",decimal.format(Dulces)});
        modelPorcentajesClienteDni.addRow(new Object[]{"Frutas-Verduras", decimal.format(porc_Frutas_Verdu)+"%",decimal.format(Frutas_Verdu)});
        modelPorcentajesClienteDni.addRow(new Object[]{"Lacteos-Huevos",  decimal.format( porc_Lact_Huev)+"%",decimal.format(Lact_Huev)});
        modelPorcentajesClienteDni.addRow(new Object[]{"P.Limpieza",  decimal.format(porc_Limp)+"%",decimal.format(Prod_Limp)});
        modelPorcentajesClienteDni.addRow(new Object[]{"Panaderia-pasteleria", decimal.format( porc_Panaderia_pastel)+"%",decimal.format(Panaderia_pastel)});
        modelPorcentajesClienteDni.addRow(new Object[]{"A.Congelados", decimal.format( porc_Alimen_Congel)+"%",decimal.format(Alimen_Congel)});
        TablaPorcentajesClienteDni.setModel(modelPorcentajesClienteDni);
        
        DefaultCategoryDataset ds= new DefaultCategoryDataset();
        ds.addValue(abarrotes, "Abarrotes",String.valueOf(decimal.format(abarrotes)));
        ds.addValue(Bebidas, "Bebidas",String.valueOf(decimal.format(Bebidas)));
        ds.addValue(Dulces, "Dulces",String.valueOf(decimal.format(Dulces)));
        ds.addValue(Prod_Limp, "Productos Limpieza",String.valueOf(decimal.format(Prod_Limp)));
        ds.addValue(Cervezas, "Cervezas",String.valueOf(decimal.format(Cervezas)));
        ds.addValue(Comida_Masc, "Comida Mascotas",String.valueOf(decimal.format(Comida_Masc)));
        ds.addValue(Frutas_Verdu, "Frutas y Verduras",String.valueOf(decimal.format(Frutas_Verdu)));
        ds.addValue(Lact_Huev, "Lacteos y Huevos",String.valueOf(decimal.format(Lact_Huev)));
        ds.addValue(Panaderia_pastel, "Panaderia y pasteleria",String.valueOf(decimal.format(Panaderia_pastel)));
        ds.addValue(Alimen_Congel, "Alimentos Congelados",String.valueOf(decimal.format(Alimen_Congel)));

        JFreeChart jf= ChartFactory.createBarChart3D("Consumo del Cliente: "+NombreClienteTabla.toLowerCase()+"","Categorías","Cantidad",ds, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel= new ChartPanel(jf);
        Panel_clienteDNI.setLayout(new java.awt.BorderLayout());
        Panel_clienteDNI.add(panel);
        Panel_clienteDNI.validate();
          
          } catch (Exception e) { System.err.println("error en  recuperar codigo de producto :"+e); }
    
    }

// METODO QUE PERMITE GRAFICAR ES TADO DE CONSUMO DE LOS CLINTES RUC
public void GrficoBarrascClienteRUC(String RUCCliente, String RAZONClienteTabla){
       try {   String codigoPro,categ_pro=""; 
       
        DecimalFormat decimal= new DecimalFormat("#");// 0 decimales
         double abarrotes=0,Bebidas=0,Cervezas=0,Comida_Masc=0,Dulces=0,Frutas_Verdu=0,Lact_Huev=0,Prod_Limp=0,Panaderia_pastel=0,Alimen_Congel=0;
          Connection cn1= Conexion.Conectar();
          PreparedStatement pst1= cn1.prepareStatement("select codigo_producto from detalle_pedidos where doc_Ident_cliente='"+RUCCliente+"'");
          ResultSet resul1 = pst1.executeQuery();
          while(resul1.next())
          {
          codigoPro= resul1.getString("codigo_producto");
           try {
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select Categoria_pro from tabla_productos where Codigo_pro='" + codigoPro +"'");
                ResultSet resul2 = pst2.executeQuery();
                if(resul2.next())
                {
                categ_pro= resul2.getString("Categoria_pro");
                if(categ_pro.equalsIgnoreCase("Abarrotes")){
                    abarrotes++;
                }
                if(categ_pro.equalsIgnoreCase("Bebidas")){
                    Bebidas++;
                }
                if(categ_pro.equalsIgnoreCase("Cervezas")){
                    Cervezas++;
                }
                if(categ_pro.equalsIgnoreCase("Comida Mascotas")){
                    Comida_Masc++;
                }
                if(categ_pro.equalsIgnoreCase("Dulces")){
                    Dulces++;
                }
                if(categ_pro.equalsIgnoreCase("Frutas y Verduras")){
                    Frutas_Verdu++;
                }
                if(categ_pro.equalsIgnoreCase("Lacteos y Huevos")){
                    Lact_Huev++;
                }
                if(categ_pro.equalsIgnoreCase("Productos de Limpieza")){
                    Prod_Limp++;
                }
                if(categ_pro.equalsIgnoreCase("Panaderia y pasteleria")){
                    Panaderia_pastel++;
                }
                if(categ_pro.equalsIgnoreCase("Alimentos Congelados")){
                    Alimen_Congel++;
                }
                }
           } catch (Exception e) {System.err.println("error en  recuperar categoria de producto :"+e);  }
   
           }
          cn1.close();
       double sumaTotal=abarrotes+Bebidas+Dulces+Prod_Limp+Cervezas+Comida_Masc+Frutas_Verdu+Lact_Huev+Panaderia_pastel+Alimen_Congel;
       double porc_barrotes=(abarrotes/sumaTotal)*100;
       double porc_Bebidas=(Bebidas/sumaTotal)*100;
       double porc_Dulces=(Dulces/sumaTotal)*100;
       double porc_Limp =Prod_Limp/sumaTotal*100;
       double porc_Cervezas=(Cervezas/sumaTotal)*100;
       double porc_Comida_Masc=(Comida_Masc/sumaTotal)*100;
       double porc_Frutas_Verdu=(Frutas_Verdu/sumaTotal)*100;
       double porc_Lact_Huev=(Lact_Huev/sumaTotal)*100;
       double porc_Panaderia_pastel=(Panaderia_pastel/sumaTotal)*100;
       double porc_Alimen_Congel=(Alimen_Congel/sumaTotal)*100;
       
       TablaPorcentajesClienteRUC.setVisible(true);
                 
        modelPorcentajesClienteRuc.addColumn("Categoria");
        modelPorcentajesClienteRuc.addColumn("Porcentaje");
        modelPorcentajesClienteRuc.addColumn("Cantidad");
        modelPorcentajesClienteRuc.addRow(new Object[]{"Abarrotes", decimal.format(porc_barrotes)+"%",decimal.format(abarrotes)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"Bebidas ", decimal.format(porc_Bebidas)+"%",decimal.format(Bebidas)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"Cervezas", decimal.format(porc_Cervezas)+"%",decimal.format(Cervezas)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"C.Mascotas",  decimal.format(porc_Comida_Masc)+"%",decimal.format(Comida_Masc)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"Dulces",  decimal.format(porc_Dulces)+"%",decimal.format(Dulces)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"Frutas-Verduras", decimal.format(porc_Frutas_Verdu)+"%",decimal.format(Frutas_Verdu)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"Lacteos-Huevos",  decimal.format( porc_Lact_Huev)+"%",decimal.format(Lact_Huev)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"P.Limpieza",  decimal.format(porc_Limp)+"%",decimal.format(Prod_Limp)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"Panaderia-pasteleria", decimal.format( porc_Panaderia_pastel)+"%",decimal.format(Panaderia_pastel)});
        modelPorcentajesClienteRuc.addRow(new Object[]{"A.Congelados", decimal.format( porc_Alimen_Congel)+"%",decimal.format(Alimen_Congel)});
        TablaPorcentajesClienteRUC.setModel(modelPorcentajesClienteRuc);
        
        DefaultCategoryDataset ds= new DefaultCategoryDataset();
        ds.addValue(abarrotes, "Abarrotes",String.valueOf(decimal.format(abarrotes)));
        ds.addValue(Bebidas, "Bebidas",String.valueOf(decimal.format(Bebidas)));
        ds.addValue(Dulces, "Dulces",String.valueOf(decimal.format(Dulces)));
        ds.addValue(Prod_Limp, "Productos Limpieza",String.valueOf(decimal.format(Prod_Limp)));
        ds.addValue(Cervezas, "Cervezas",String.valueOf(decimal.format(Cervezas)));
        ds.addValue(Comida_Masc, "Comida Mascotas",String.valueOf(decimal.format(Comida_Masc)));
        ds.addValue(Frutas_Verdu, "Frutas y Verduras",String.valueOf(decimal.format(Frutas_Verdu)));
        ds.addValue(Lact_Huev, "Lacteos y Huevos",String.valueOf(decimal.format(Lact_Huev)));
        ds.addValue(Panaderia_pastel, "Panaderia y pasteleria",String.valueOf(decimal.format(Panaderia_pastel)));
        ds.addValue(Alimen_Congel, "Alimentos Congelados",String.valueOf(decimal.format(Alimen_Congel)));

        JFreeChart jf= ChartFactory.createBarChart3D("Consumo del Cliente: "+RAZONClienteTabla.toLowerCase()+"","Categorías","Cantidad",ds, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel= new ChartPanel(jf);
        Panel_clienteRUC.setLayout(new java.awt.BorderLayout());
        Panel_clienteRUC.add(panel);
        Panel_clienteRUC.validate();
          
          } catch (Exception e) { System.err.println("error en  recuperar codigo de producto :"+e); }
    
    }
 // ************** METODO PARA ACTUALIZAR VENTANA ****************
 public void ActualizarVentana(){
     this.setVisible(false);
     ReportesPedidos mensajero= new ReportesPedidos();
      jDesktop.add(mensajero);
        mensajero.setVisible(true);
      
 }
}
