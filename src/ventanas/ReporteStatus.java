
package ventanas;


import clases.AgregarRadioBotton;
import clases.ColorCeldaTabla;
import clases.Conexion;
import clases.GestionEncabezadoTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReporteStatus extends javax.swing.JInternalFrame {

   DefaultTableModel model= new DefaultTableModel();// conexion con la tabla y generar clic
 DefaultTableModel mode2= new DefaultTableModel();// conexion con la tabla y generar clic
 DefaultTableModel modelALERTADO= new DefaultTableModel();// conexion con la tabla y generar clic
  DefaultTableModel modelBAJA= new DefaultTableModel();// conexion con la tabla y generar clic
 DefaultTableModel modelMEDIANA= new DefaultTableModel();// conexion con la tabla y generar clic
 DefaultTableModel modelNORMAL= new DefaultTableModel();// conexion con la tabla y generar clic
      // metodo para el color de celas
     ColorCeldaTabla MensajeroColorFila= new ColorCeldaTabla();
     //metodo para el color del encabezado de tabla
     GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla();
     ///metodo para agregar radioboton a la tabla
     AgregarRadioBotton MensajeroAgegarRadioBotton= new AgregarRadioBotton(); 

 String fechaAutomatica;
     public ReporteStatus() {
        initComponents();
          // metodo calendario para la fecha
        Calendar calendario= Calendar.getInstance();
        fechaAutomatica=Integer.toString(calendario.get(Calendar.DATE))+"/"+
                Integer.toString(calendario.get(Calendar.MONTH)+1)+"/"+
                Integer.toString(calendario.get(Calendar.YEAR));
     
         
    //****************************** TABLA DE PRODUCTOS  POR FECHA DE ONGRESO *****************


    try {    String Mensaje="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,Formato_pro,"
                    + "Stock_pro,Fecha_ingreso,Fecha_venc,Ruc_proveedor from tabla_productos");
            ResultSet resul1=pst1.executeQuery();
           if(resul1.next())
          {
          String fechaIngreso= resul1.getString("Fecha_ingreso");
            if(fechaIngreso.equalsIgnoreCase(fechaAutomatica)){
                Mensaje="Recien Ingresado";
            }else{
                 Mensaje="Normal";
            }
          }
         //  
            jTableFechaIngreso = new JTable(model);
            jScrollPane2.setViewportView(jTableFechaIngreso);
            model.addColumn("CODIGO");
            model.addColumn("DESCRIPCION");
            model.addColumn("Formato");
            model.addColumn("Stock");
            model.addColumn("F.ingreso");
            model.addColumn("F.venc");
            model.addColumn("Proveedor");
            model.addColumn("Mensaje");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTableFechaIngreso.getColumnCount())-1;i++)
            {
                jTableFechaIngreso.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTableFechaIngreso.getColumnCount());i++)
            {
                jTableFechaIngreso.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            
             jTableFechaIngreso.getColumnModel().getColumn(0).setMaxWidth(80);//dimensionar columna 0
             jTableFechaIngreso.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableFechaIngreso.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             jTableFechaIngreso.getColumnModel().getColumn(3).setMaxWidth(50);//dimensionar columna 0
             jTableFechaIngreso.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
             jTableFechaIngreso.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
          
             jTableFechaIngreso.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[8];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   fila[2]= resul1.getObject(3);
                   fila[3]= resul1.getObject(4);
                   fila[4]= resul1.getObject(5);
                   fila[5]= resul1.getObject(6);
                   fila[6]= resul1.getObject(7);
                   fila[7]= Mensaje;
                   model.addRow(fila);
                }
                cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla de F.NGRESO :"+e);
        }
    
    
    
     //****************************** TABLA DE PRODUCTOS  POR FECHA DE ONGRESO *****************
    try {    String Mensaje="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,Formato_pro,"
                    + "Stock_pro,Fecha_ingreso,Fecha_venc,Ruc_proveedor from tabla_productos");
            ResultSet resul1=pst1.executeQuery();
           if(resul1.next())
          {
          String fechaIngreso= resul1.getString("Fecha_venc");
            if(fechaIngreso.equalsIgnoreCase(fechaAutomatica)){
                Mensaje="Producto Vencido";
            }else{
                 Mensaje="Cituación  Normal";
            }
          }
         //  
            jTableFechaVencimiento = new JTable(mode2);
            jScrollPane3.setViewportView(jTableFechaVencimiento);
            mode2.addColumn("CODIGO");
            mode2.addColumn("DESCRIPCION");
            mode2.addColumn("Formato");
            mode2.addColumn("Stock");
            mode2.addColumn("F.ingreso");
            mode2.addColumn("F.venc");
            mode2.addColumn("Proveedor");
            mode2.addColumn("Mensaje");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTableFechaVencimiento.getColumnCount())-1;i++)
            {
                jTableFechaVencimiento.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTableFechaVencimiento.getColumnCount());i++)
            {
                jTableFechaVencimiento.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            
             jTableFechaVencimiento.getColumnModel().getColumn(0).setMaxWidth(80);//dimensionar columna 0
             jTableFechaVencimiento.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableFechaVencimiento.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             jTableFechaVencimiento.getColumnModel().getColumn(3).setMaxWidth(50);//dimensionar columna 0
             jTableFechaVencimiento.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
             jTableFechaVencimiento.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
          
             jTableFechaVencimiento.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[8];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   fila[2]= resul1.getObject(3);
                   fila[3]= resul1.getObject(4);
                   fila[4]= resul1.getObject(5);
                   fila[5]= resul1.getObject(6);
                   fila[6]= resul1.getObject(7);
                   fila[7]= Mensaje;
                   mode2.addRow(fila);
                }
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla :"+e);
        }
   
    //*************************** TABLA DE STOCK *********************************
    
     //****************************** TABLA DE PRODUCTOS  POR stock Alertado *****************
    try {    String Mensaje="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,Formato_pro,"
                    + "Stock_pro,Fecha_ingreso,Fecha_venc,Ruc_proveedor from tabla_productos where Stock_pro<=5");
            ResultSet resul1=pst1.executeQuery();

            jTable_StokAlertado= new JTable(modelALERTADO);
            jScrollPane5.setViewportView(jTable_StokAlertado);
            modelALERTADO.addColumn("CODIGO");
            modelALERTADO.addColumn("DESCRIPCION");
            modelALERTADO.addColumn("Formato");
            modelALERTADO.addColumn("Stock");
            modelALERTADO.addColumn("F.ingreso");
            modelALERTADO.addColumn("F.venc");
            modelALERTADO.addColumn("Proveedor");
            modelALERTADO.addColumn("Mensaje");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTable_StokAlertado.getColumnCount())-1;i++)
            {
                jTable_StokAlertado.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTable_StokAlertado.getColumnCount());i++)
            {
                jTable_StokAlertado.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            
             jTable_StokAlertado.getColumnModel().getColumn(0).setMaxWidth(80);//dimensionar columna 0
             jTable_StokAlertado.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTable_StokAlertado.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokAlertado.getColumnModel().getColumn(3).setMaxWidth(50);//dimensionar columna 0
             jTable_StokAlertado.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokAlertado.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
          
             jTable_StokAlertado.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[8];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   fila[2]= resul1.getObject(3);
                   fila[3]= resul1.getObject(4);
                   fila[4]= resul1.getObject(5);
                   fila[5]= resul1.getObject(6);
                   fila[6]= resul1.getObject(7);
                   fila[7]= "Alerta Reponer Producto";
                   modelALERTADO.addRow(fila);
                }
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla :"+e);
        }
    
     //****************************** TABLA DE PRODUCTOS  POR stock BAJO *****************
    try {    String Mensaje="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,Formato_pro,"
                    + "Stock_pro,Fecha_ingreso,Fecha_venc,Ruc_proveedor from tabla_productos where Stock_pro>=6 and Stock_pro<=15");
            ResultSet resul1=pst1.executeQuery();

            jTable_StokBajo_= new JTable(modelBAJA);
            jScrollPane6.setViewportView(jTable_StokBajo_);
            modelBAJA.addColumn("CODIGO");
            modelBAJA.addColumn("DESCRIPCION");
            modelBAJA.addColumn("Formato");
            modelBAJA.addColumn("Stock");
            modelBAJA.addColumn("F.ingreso");
            modelBAJA.addColumn("F.venc");
            modelBAJA.addColumn("Proveedor");
            modelBAJA.addColumn("Mensaje");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTable_StokBajo_.getColumnCount())-1;i++)
            {
                jTable_StokBajo_.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTable_StokBajo_.getColumnCount());i++)
            {
                jTable_StokBajo_.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            
             jTable_StokBajo_.getColumnModel().getColumn(0).setMaxWidth(80);//dimensionar columna 0
             jTable_StokBajo_.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTable_StokBajo_.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokBajo_.getColumnModel().getColumn(3).setMaxWidth(50);//dimensionar columna 0
             jTable_StokBajo_.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokBajo_.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
          
             jTable_StokBajo_.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[8];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   fila[2]= resul1.getObject(3);
                   fila[3]= resul1.getObject(4);
                   fila[4]= resul1.getObject(5);
                   fila[5]= resul1.getObject(6);
                   fila[6]= resul1.getObject(7);
                   fila[7]= "Capacidad Baja";
                   modelBAJA.addRow(fila);
                }
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla :"+e);
        }
     //****************************** TABLA DE PRODUCTOS  POR stock Mediado *****************
    try {    String Mensaje="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,Formato_pro,"
                    + "Stock_pro,Fecha_ingreso,Fecha_venc,Ruc_proveedor from tabla_productos where Stock_pro>=16 and Stock_pro<=30");
            ResultSet resul1=pst1.executeQuery();

            jTable_StokMediano= new JTable(modelMEDIANA);
            jScrollPane7.setViewportView(jTable_StokMediano);
            modelMEDIANA.addColumn("CODIGO");
            modelMEDIANA.addColumn("DESCRIPCION");
            modelMEDIANA.addColumn("Formato");
            modelMEDIANA.addColumn("Stock");
            modelMEDIANA.addColumn("F.ingreso");
            modelMEDIANA.addColumn("F.venc");
            modelMEDIANA.addColumn("Proveedor");
            modelMEDIANA.addColumn("Mensaje");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTable_StokMediano.getColumnCount())-1;i++)
            {
                jTable_StokMediano.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTable_StokMediano.getColumnCount());i++)
            {
                jTable_StokMediano.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            
             jTable_StokMediano.getColumnModel().getColumn(0).setMaxWidth(80);//dimensionar columna 0
             jTable_StokMediano.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTable_StokMediano.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokMediano.getColumnModel().getColumn(3).setMaxWidth(50);//dimensionar columna 0
             jTable_StokMediano.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokMediano.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
          
             jTable_StokMediano.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[8];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   fila[2]= resul1.getObject(3);
                   fila[3]= resul1.getObject(4);
                   fila[4]= resul1.getObject(5);
                   fila[5]= resul1.getObject(6);
                   fila[6]= resul1.getObject(7);
                   fila[7]= "Capacidad Estable";
                   modelMEDIANA.addRow(fila);
                }
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla :"+e);
        }
        
     //****************************** TABLA DE PRODUCTOS  POR stock Normal *****************
    try {    String Mensaje="";
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Codigo_pro, Descripcion_pro,Formato_pro,"
                    + "Stock_pro,Fecha_ingreso,Fecha_venc,Ruc_proveedor from tabla_productos where Stock_pro>=31");
            ResultSet resul1=pst1.executeQuery();

            jTable_StokNormal= new JTable(modelNORMAL);
            jScrollPane8.setViewportView(jTable_StokNormal);
            modelNORMAL.addColumn("CODIGO");
            modelNORMAL.addColumn("DESCRIPCION");
            modelNORMAL.addColumn("Formato");
            modelNORMAL.addColumn("Stock");
            modelNORMAL.addColumn("F.ingreso");
            modelNORMAL.addColumn("F.venc");
            modelNORMAL.addColumn("Proveedor");
            modelNORMAL.addColumn("Mensaje");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTable_StokNormal.getColumnCount())-1;i++)
            {
                jTable_StokNormal.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTable_StokNormal.getColumnCount());i++)
            {
                jTable_StokNormal.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            
             jTable_StokNormal.getColumnModel().getColumn(0).setMaxWidth(80);//dimensionar columna 0
             jTable_StokNormal.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTable_StokNormal.getColumnModel().getColumn(2).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokNormal.getColumnModel().getColumn(3).setMaxWidth(50);//dimensionar columna 0
             jTable_StokNormal.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
             jTable_StokNormal.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
          
             jTable_StokNormal.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[8];
                   fila[0]= resul1.getObject(1);
                   fila[1]= resul1.getObject(2);
                   fila[2]= resul1.getObject(3);
                   fila[3]= resul1.getObject(4);
                   fila[4]= resul1.getObject(5);
                   fila[5]= resul1.getObject(6);
                   fila[6]= resul1.getObject(7);
                   fila[7]= "Normal No Reponer";
                   modelNORMAL.addRow(fila);
                }
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar tabla :"+e);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFechaIngreso = new javax.swing.JTable();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFechaVencimiento = new javax.swing.JTable();
        jTable_Estado_stock = new javax.swing.JTabbedPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_StokAlertado = new javax.swing.JTable();
        jDesktopPane6 = new javax.swing.JDesktopPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_StokBajo_ = new javax.swing.JTable();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_StokMediano = new javax.swing.JTable();
        jDesktopPane9 = new javax.swing.JDesktopPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_StokNormal = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estatus Productos");

        jTabbedPane2.setBackground(new java.awt.Color(0, 153, 153));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jTableFechaIngreso.setBackground(new java.awt.Color(0, 255, 0));
        jTableFechaIngreso.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTableFechaIngreso.setForeground(new java.awt.Color(102, 102, 102));
        jTableFechaIngreso.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableFechaIngreso.setDragEnabled(true);
        jTableFechaIngreso.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTableFechaIngreso);

        jDesktopPane3.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Fecha ingreso", jDesktopPane3);

        jTableFechaVencimiento.setBackground(new java.awt.Color(0, 255, 0));
        jTableFechaVencimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTableFechaVencimiento.setForeground(new java.awt.Color(102, 102, 102));
        jTableFechaVencimiento.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableFechaVencimiento.setDragEnabled(true);
        jTableFechaVencimiento.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane3.setViewportView(jTableFechaVencimiento);

        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Fecha Vencimiento", jDesktopPane1);

        jTable_Estado_stock.setBackground(new java.awt.Color(0, 204, 204));
        jTable_Estado_stock.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Estado_stock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTable_StokAlertado.setBackground(new java.awt.Color(0, 255, 0));
        jTable_StokAlertado.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTable_StokAlertado.setForeground(new java.awt.Color(102, 102, 102));
        jTable_StokAlertado.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_StokAlertado.setDragEnabled(true);
        jTable_StokAlertado.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane5.setViewportView(jTable_StokAlertado);

        jDesktopPane2.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTable_Estado_stock.addTab("Alertados", jDesktopPane2);

        jTable_StokBajo_.setBackground(new java.awt.Color(0, 255, 0));
        jTable_StokBajo_.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTable_StokBajo_.setForeground(new java.awt.Color(102, 102, 102));
        jTable_StokBajo_.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_StokBajo_.setDragEnabled(true);
        jTable_StokBajo_.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane6.setViewportView(jTable_StokBajo_);

        jDesktopPane6.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane6Layout = new javax.swing.GroupLayout(jDesktopPane6);
        jDesktopPane6.setLayout(jDesktopPane6Layout);
        jDesktopPane6Layout.setHorizontalGroup(
            jDesktopPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jDesktopPane6Layout.setVerticalGroup(
            jDesktopPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTable_Estado_stock.addTab("Baja Capacidad", jDesktopPane6);

        jTable_StokMediano.setBackground(new java.awt.Color(0, 255, 0));
        jTable_StokMediano.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTable_StokMediano.setForeground(new java.awt.Color(102, 102, 102));
        jTable_StokMediano.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_StokMediano.setDragEnabled(true);
        jTable_StokMediano.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane7.setViewportView(jTable_StokMediano);

        jDesktopPane4.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTable_Estado_stock.addTab("Mediana Capacidad", jDesktopPane4);

        jTable_StokNormal.setBackground(new java.awt.Color(0, 255, 0));
        jTable_StokNormal.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTable_StokNormal.setForeground(new java.awt.Color(102, 102, 102));
        jTable_StokNormal.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_StokNormal.setDragEnabled(true);
        jTable_StokNormal.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane8.setViewportView(jTable_StokNormal);

        jDesktopPane9.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane9Layout = new javax.swing.GroupLayout(jDesktopPane9);
        jDesktopPane9.setLayout(jDesktopPane9Layout);
        jDesktopPane9Layout.setHorizontalGroup(
            jDesktopPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jDesktopPane9Layout.setVerticalGroup(
            jDesktopPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTable_Estado_stock.addTab("Normal", jDesktopPane9);

        jTabbedPane2.addTab("Stok", jTable_Estado_stock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        //******** METODO PARA RELLENAR TABLA ********
    }//GEN-LAST:event_jTabbedPane2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JDesktopPane jDesktopPane6;
    private javax.swing.JDesktopPane jDesktopPane9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableFechaIngreso;
    private javax.swing.JTable jTableFechaVencimiento;
    private javax.swing.JTabbedPane jTable_Estado_stock;
    private javax.swing.JTable jTable_StokAlertado;
    private javax.swing.JTable jTable_StokBajo_;
    private javax.swing.JTable jTable_StokMediano;
    private javax.swing.JTable jTable_StokNormal;
    // End of variables declaration//GEN-END:variables
}
