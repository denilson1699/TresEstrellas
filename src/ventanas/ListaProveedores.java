
package ventanas;

import clases.AgregarRadioBotton;
import clases.ColorCeldaTabla;
import clases.Conexion;
import clases.GestionEncabezadoTabla;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.ListaUsuarios.apellido_update;
import static ventanas.ListaUsuarios.dni_update;
import static ventanas.ListaUsuarios.estado_usuarioTabla;
import static ventanas.ListaUsuarios.nombre_update;
import static ventanas.ListaUsuarios.pass_update;

public class ListaProveedores extends javax.swing.JFrame {
        DefaultTableModel model= new DefaultTableModel(){// conexion con la tabla y generar clic
    // este metodo permite que la tabla sea editada
          @Override
          public boolean isCellEditable(int row, int column) {
          if(column==5)
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
     String ruc_usuarioTabla;
    public ListaProveedores() {
    initComponents();
    setSize(1241, 668);
    getContentPane().setBackground(new Color(255,255,204));
    setResizable(false); // interfas no se mueva
  //setSize(862, 652);
    setLocationRelativeTo(null); // interfaz centrada
  //this.setExtendedState(MAXIMIZED_BOTH); // dimenciones de la interfaz
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Gestión de Usuarios");
      
      
  //recuperados metodo para agregamos datos a la tabla
    agregarDatosTabla();
        
  //crreamos metodo para el EVENTO de la TABLA
    jTableProveedores.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e){
    int fila_poin=jTableProveedores.rowAtPoint(e.getPoint());
    if(fila_poin>-1)
      {
      ruc_usuarioTabla=(String)model.getValueAt(fila_poin,0);
    //recuperamos metodo para  ostrar informacion de celda selecionada
      BuscardorDeProveedores(ruc_usuarioTabla);
      }
    }  
    });
        
    jButton_Eliminar.setEnabled(false);
    jButton_actualizar.setEnabled(false);
    
      }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcmb_tipoFiltro = new javax.swing.JComboBox<>();
        txt_BuscarPorFiltro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProveedores = new javax.swing.JTable();
        jButton_actualizar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jButton_agregar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_razonSocial = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcmb_tipoFiltro.setBackground(new java.awt.Color(255, 153, 0));
        jcmb_tipoFiltro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jcmb_tipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "Razon Social", "Direccion", "Telefono" }));
        jcmb_tipoFiltro.setBorder(null);
        jcmb_tipoFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jcmb_tipoFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 220, 30));

        txt_BuscarPorFiltro.setBackground(new java.awt.Color(204, 204, 255));
        txt_BuscarPorFiltro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_BuscarPorFiltro.setForeground(new java.awt.Color(0, 102, 102));
        txt_BuscarPorFiltro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_BuscarPorFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_BuscarPorFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarPorFiltroActionPerformed(evt);
            }
        });
        txt_BuscarPorFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarPorFiltroKeyReleased(evt);
            }
        });
        getContentPane().add(txt_BuscarPorFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 390, 30));

        jTableProveedores.setBackground(new java.awt.Color(0, 255, 0));
        jTableProveedores.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTableProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProveedores.setDragEnabled(true);
        jTableProveedores.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTableProveedores);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 800, 480));

        jButton_actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_actualizar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 280, 35));

        jButton_nuevo.setBackground(new java.awt.Color(153, 153, 255));
        jButton_nuevo.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ticket.png"))); // NOI18N
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, 280, -1));

        jButton_agregar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_agregar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton_agregar.setText("Agregar");
        jButton_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 280, 33));

        jButton_Eliminar.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Eliminar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        jButton_Eliminar.setText("Eliminar ");
        jButton_Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 590, 280, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("RUC:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, -1, -1));

        txt_ruc.setEditable(false);
        txt_ruc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_ruc.setForeground(new java.awt.Color(0, 102, 102));
        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_ruc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_ruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rucKeyTyped(evt);
            }
        });
        getContentPane().add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 210, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Social:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, -1, -1));

        txt_razonSocial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_razonSocial.setForeground(new java.awt.Color(0, 102, 102));
        txt_razonSocial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_razonSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_razonSocial.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_razonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_razonSocialKeyTyped(evt);
            }
        });
        getContentPane().add(txt_razonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, 210, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Correo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, -1, -1));

        txt_correo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_correo.setForeground(new java.awt.Color(0, 102, 102));
        txt_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_correo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_correoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, 210, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Telf Movil:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(0, 102, 102));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, 210, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Direccion:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, -1, -1));

        txt_direccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(0, 102, 102));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, 210, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Razon");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("\"Bodega Tres Estrelas\"");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Registro de Proveedores");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_BuscarPorFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarPorFiltroActionPerformed

    }//GEN-LAST:event_txt_BuscarPorFiltroActionPerformed

    private void txt_BuscarPorFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarPorFiltroKeyReleased

        try
        {// en texto escrito a consultar en la tabla
            String texto="%"+txt_BuscarPorFiltro.getText().trim()+"%";

            // secuberra el tipo de filtro
            String filtroSelec=jcmb_tipoFiltro.getSelectedItem().toString();

            // para el color de celas
            ColorCeldaTabla MensajeroColorFila= new ColorCeldaTabla();
            // para el color del encabezad
            GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla();

            // ETIQUETAS DE EMCABEZADO DE TABLA
            String[] titulos={"RUC", "RAZON SOCIAL", "CORREO", "TELEFONO", "DIRECCIÓN"};
            DefaultTableModel model = new DefaultTableModel(null,titulos)
            {// este metodo permite que la tabla NO sea editada
                @Override
                public boolean isCellEditable(int row, int column)
                {
                    if(column==5)
                    {return true;}
                    else{return false;}
                }
            };

            // FUNCIONES DEPENDIENDO DEL TIPO DE FILTRO ELEGIDO
            switch (filtroSelec)
            {//*********** FILTRO PARA NOMBRE DE CLIENTES ************
                case"RUC":
                Connection cn= Conexion.Conectar();
                PreparedStatement pst= cn.prepareStatement("select *from tabla_proveedores where Ruc_proveedor like"+'"'+texto+'"');
                String[] fila= new String[5];
                ResultSet resul=pst.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                jTableProveedores = new JTable(model);
                jScrollPane2.setViewportView(jTableProveedores);
                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                {jTableProveedores.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                {jTableProveedores.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

             jTableProveedores.getColumnModel().getColumn(0).setPreferredWidth(80);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(2).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(3).setPreferredWidth(70);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(4).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.setRowHeight(18);

                //recuperar valores de BD A LA TABLA
                while(resul.next())
                {
                    fila[0]=resul.getString("Ruc_proveedor");
                    fila[1]=resul.getString("Razon_proveedor");
                    fila[2]=resul.getString("Correo_proveedor");
                    fila[3]=resul.getString("Telf_proveedor");
                    fila[4]=resul.getString("Direccion__proveedor");
                    model.addRow(fila);
                }
                cn.close();

                // EVENTO EN LA TABLA
                jTableProveedores.addMouseListener(new MouseAdapter()
                    {
                        @Override
                        public void mouseClicked(MouseEvent e)
                        {// recuperar celda celecionada
                            int fila_poin=jTableProveedores.rowAtPoint(e.getPoint());
                            if(fila_poin>-1)
                            { //recuperar codigo de la celda celecionda
                                String ruc_proveedor = (String)model.getValueAt(fila_poin,1);
                                // llamar metodo bucar rodctos ára que muestre la infromacion del producto selecionado
                                BuscardorDeProveedores(ruc_proveedor );
                                //IsSeleceted(fila_poin, 5, jTableProductos);
                            }
                        }
                    });
                    break;

                    //********** FILTRO DE APELLIDOS DE CLIENTES **********
                    case"Razon Social":
                    Connection cn1= Conexion.Conectar();
                    PreparedStatement pst1= cn1.prepareStatement("select *from tabla_proveedores where Razon_proveedor like"+'"'+texto+'"');
                    String[] fila1= new String[5];
                    ResultSet resul1=pst1.executeQuery();
                    // AGREGAR ENCABEZADOS A LA TABLA
                    jTableProveedores = new JTable(model);
                    jScrollPane2.setViewportView(jTableProveedores);
                    
                    //AGREGAR COLOR A LAS FILAS
                    for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                    { jTableProveedores.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                    //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                    for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                    { jTableProveedores.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);  }

                    // dimenciones para las columnas
             jTableProveedores.getColumnModel().getColumn(0).setPreferredWidth(80);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(2).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(3).setPreferredWidth(70);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(4).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.setRowHeight(18);

                    //AGREGAR LOS VALORES DE LA BD A LA TABLA
                    while(resul1.next())
                    {
                        fila1[0]=resul1.getString("Ruc_proveedor");
                        fila1[1]=resul1.getString("Razon_proveedor");
                        fila1[2]=resul1.getString("Correo_proveedor");
                        fila1[3]=resul1.getString("Telf_proveedor");
                        fila1[4]=resul1.getString("Direccion__proveedor");
                        model.addRow(fila1);
                    }
                    cn1.close();

                    // EVENTO EN LA TABLA
                    jTableProveedores.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e)
                        {
                            int fila_poin=jTableProveedores.rowAtPoint(e.getPoint());
                            if(fila_poin>-1){
                                String ruc_proveedor = (String)model.getValueAt(fila_poin,1);
                                // llamar metodo bucar rodctos ára que muestre la infromacion del producto selecionado
                                BuscardorDeProveedores(ruc_proveedor );
                            }
                        }
                    });
                    break;
                    
                  //********** FILTRO DE DIRECCION DE CLIENTES **********
                    case"Direccion":
                    Connection cn2= Conexion.Conectar();
                    PreparedStatement pst2= cn2.prepareStatement("select *from tabla_proveedores where Direccion__proveedor like"+'"'+texto+'"');
                    String[] fila2= new String[5];
                    ResultSet resul2=pst2.executeQuery();
                    // AGREGAR ENCABEZADOS A LA TABLA
                    jTableProveedores = new JTable(model);
                    jScrollPane2.setViewportView(jTableProveedores);
                    
                    //AGREGAR COLOR A LAS FILAS
                    for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                    { jTableProveedores.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                    //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                    for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                    { jTableProveedores.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);  }

                    // dimenciones para las columnas
             jTableProveedores.getColumnModel().getColumn(0).setPreferredWidth(80);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(2).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(3).setPreferredWidth(70);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(4).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.setRowHeight(18);
                    //AGREGAR LOS VALORES DE LA BD A LA TABLA
                    while(resul2.next())
                    {
                        fila2[0]=resul2.getString("Ruc_proveedor");
                        fila2[1]=resul2.getString("Razon_proveedor");
                        fila2[2]=resul2.getString("Correo_proveedor");
                        fila2[3]=resul2.getString("Telf_proveedor");
                        fila2[4]=resul2.getString("Direccion__proveedor");
                        model.addRow(fila2);
                    }
                    cn2.close();

                    // EVENTO EN LA TABLA
                    jTableProveedores.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e)
                        {
                            int fila_poin=jTableProveedores.rowAtPoint(e.getPoint());
                            if(fila_poin>-1){
                                String ruc_proveedor = (String)model.getValueAt(fila_poin,1);
                                // llamar metodo bucar rodctos ára que muestre la infromacion del producto selecionado
                                BuscardorDeProveedores(ruc_proveedor );
                            }
                        }
                    });
                    break;
                    
                    //********** FILTRO DE DNI DE CLIENTES **********
                    case"Telefono":
                    Connection cn3= Conexion.Conectar();
                    PreparedStatement pst3= cn3.prepareStatement("select *from tabla_proveedores where Telf_proveedor like"+'"'+texto+'"');
                    String[] fila3= new String[5];
                    ResultSet resul3=pst3.executeQuery();
                    // AGREGAR ENCABEZADOS A LA TABLA
                    jTableProveedores = new JTable(model);
                    jScrollPane2.setViewportView(jTableProveedores);
                    
                    //AGREGAR COLOR A LAS FILAS
                    for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                    { jTableProveedores.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                    //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                    for(int i=0;i<(jTableProveedores.getColumnCount());i++)
                    { jTableProveedores.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);  }

                    // dimenciones para las columnas
             jTableProveedores.getColumnModel().getColumn(0).setPreferredWidth(80);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(2).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(3).setPreferredWidth(70);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(4).setPreferredWidth(100);//dimensionar columna 0
             jTableProveedores.setRowHeight(18);

                    //AGREGAR LOS VALORES DE LA BD A LA TABLA
                    while(resul3.next())
                    {
                        fila3[0]=resul3.getString("Ruc_proveedor");
                        fila3[1]=resul3.getString("Razon_proveedor");
                        fila3[2]=resul3.getString("Correo_proveedor");
                        fila3[3]=resul3.getString("Telf_proveedor");
                        fila3[4]=resul3.getString("Direccion__proveedor");
                        model.addRow(fila3);
                    }
                    cn3.close();

                    // EVENTO EN LA TABLA
                    jTableProveedores.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e)
                        {
                            int fila_poin=jTableProveedores.rowAtPoint(e.getPoint());
                            if(fila_poin>-1){
                                String ruc_proveedor = (String)model.getValueAt(fila_poin,1);
                                // llamar metodo bucar rodctos ára que muestre la infromacion del producto selecionado
                                BuscardorDeProveedores(ruc_proveedor );
                            }
                        }
                    });
                    break;
                }

            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error al filtar Proveedores", "",JOptionPane.ERROR_MESSAGE);
                System.err.println("error al filtar la busqueda: "+e);
            }

    }//GEN-LAST:event_txt_BuscarPorFiltroKeyReleased

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        String ruc_proveedor,razon_social,correo,telf,direcc_proveedor;
        int  contador=0;
      
        // recuperadmos datos de los jtextfield
        correo =txt_correo.getText().trim();
        direcc_proveedor   =txt_direccion.getText().trim();
        ruc_proveedor      =txt_ruc.getText().trim();
        razon_social   =txt_razonSocial.getText().trim();
        telf      =txt_telefono.getText().trim();
        
         // vaidamos que no existan campos en blanco
        if(correo.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar correo");
            txt_correo.requestFocus();
            contador++;
        }
        if(direcc_proveedor.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Dirección");
            txt_direccion.requestFocus();
            contador++;
        }
        if(ruc_proveedor.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Ruc ");
            txt_ruc.requestFocus();
            contador++;
        }
        if(razon_social.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Razon Social ");
            txt_razonSocial.requestFocus();
            contador++;
        }
        if(telf.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Telefono");
            txt_telefono.requestFocus();
            contador++;
        }

        // si todos los campos en llenos
        if(contador==0)
        {  // pregusntar si se desea guar la actualizacion
            int mensaje=JOptionPane.showConfirmDialog(null,"Guardar Cambio  [S/N]:",null,JOptionPane.YES_NO_OPTION);
            if(mensaje==JOptionPane.YES_OPTION)
            {
                try {// actualizar datos en la bse de datos
                    Connection cn=Conexion.Conectar();
                    PreparedStatement pst = cn.prepareStatement("update tabla_proveedores set Razon_proveedor=?, Correo_proveedor=?, "
                        + "Telf_proveedor=?, Direccion__proveedor=? where Ruc_proveedor ='"+ruc_proveedor+"'");
                    pst.setString(1,razon_social);
                    pst.setString(2,correo);
                    pst.setString(3,telf );
                    pst.setString(4,direcc_proveedor);
                    pst.executeUpdate();
                    cn.close();
                    JOptionPane.showMessageDialog(null,"Actualización exitosa");
                     ActualizarVentana();
                }catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "","Error al Actualizar datos Contacte al Administrador",JOptionPane.ERROR_MESSAGE);
                    System.err.println("error al actualizar: "+ex);
                }
            }else
            {// s no se desea actualizar datos
                JOptionPane.showMessageDialog(null, "ACTUALIZACION CANCELADA");
            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed
        // para blanquiar los campos y dejarlos listo para el ingreso de nuevos datos
         // recuperadmos metodo para blanquiar campos
        LimpiarCampos();

        // desavilitamos boton actualizar y eliminar
        jButton_actualizar.setEnabled(false);
        jButton_Eliminar.setEnabled(false);
        // avilitamos jtextfiels codigo producto
        txt_ruc.setEditable(true);

    }//GEN-LAST:event_jButton_nuevoActionPerformed

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        String ruc_proveedor,razon_social,correo,telf,direcc_proveedor;
        int  contador=0;
      
        // recuperadmos datos de los jtextfield
        correo =txt_correo.getText().trim();
        direcc_proveedor   =txt_direccion.getText().trim();
        ruc_proveedor      =txt_ruc.getText().trim();
        razon_social   =txt_razonSocial.getText().trim();
        telf      =txt_telefono.getText().trim();
        
         // vaidamos que no existan campos en blanco
        if(correo.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar correo");
            txt_correo.requestFocus();
            contador++;
        }
        if(direcc_proveedor.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Dirección");
            txt_direccion.requestFocus();
            contador++;
        }
        if(ruc_proveedor.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Ruc ");
            txt_ruc.requestFocus();
            contador++;
        }
        if(razon_social.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Razon Social ");
            txt_razonSocial.requestFocus();
            contador++;
        }
        if(telf.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Falta completar Telefono");
            txt_telefono.requestFocus();
            contador++;
        }

      
        // si todos los campos entan llenos
        if(contador==0)
        {
            try
            {
                String validarRUC;
                Connection cn1= Conexion.Conectar();
                PreparedStatement pst1= cn1.prepareStatement("select Ruc_proveedor from tabla_proveedores where Ruc_proveedor  ='"+ruc_proveedor +"'");
                ResultSet resul1=pst1.executeQuery();
                if(resul1.next())
                {
                    validarRUC=resul1.getString("Ruc_proveedor");
                    // validamos que el codigo o se repita
                    if (ruc_proveedor .equals(validarRUC))
                    {
                        JOptionPane.showMessageDialog(null, "Ruc "+ruc_proveedor+" ya registrado");
                    }
                }else{// valdar s desea guardar producto
                    int mensaje=JOptionPane.showConfirmDialog(null,"¿Guardar nuevo Proveedor?",null,JOptionPane.YES_NO_OPTION);
                    if(mensaje==JOptionPane.YES_OPTION)
                    {
                        try
                        {
                            Connection cn=Conexion.Conectar();
                            PreparedStatement pst= cn.prepareStatement("insert into tabla_proveedores values (?,?,?,?,?,?)");
                            pst.setInt(1,0);
                            pst.setString(2,ruc_proveedor   );
                            pst.setString(3,razon_social );
                            pst.setString(4, correo);
                            pst.setString(5,telf );
                            pst.setString(6,direcc_proveedor);
                            pst.executeUpdate();
                            cn.close();
                            // preguntar si desea generar un nuevo registro
                            int mensaje2=JOptionPane.showConfirmDialog(null,"Registro exitoso ¿continuar?",null,JOptionPane.YES_NO_OPTION);
                            if(mensaje==JOptionPane.YES_OPTION)
                            {// recuperadmos metodo para blanquiar campos
                                LimpiarCampos();
                                ActualizarVentana();
                                // desavilitamos boton actualizar y eliminar
                                jButton_actualizar.setEnabled(false);
                                jButton_Eliminar.setEnabled(false);
                                // avilitamos jtextfiels codigo producto
                                txt_ruc.setEditable(true);

                            }
                        } catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, ""," Error al registrar proveedor, contacte al administrador",JOptionPane.ERROR_MESSAGE);
                            System.err.println("error al registrar nuevo proveedor: "+e);
                        }
                    }else
                    {// si no se desea gabra nuevo producto
                        JOptionPane.showMessageDialog(null, "REGISTRO CANCELADO");
                    }
                }

            }catch (SQLException ex) {}
        }
    }//GEN-LAST:event_jButton_agregarActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
         try {
          int mensaje=JOptionPane.showConfirmDialog(null,"¿Eliminar Proveedor?",null,JOptionPane.YES_NO_OPTION);
          if(mensaje==JOptionPane.YES_OPTION)
          {
            Connection cn=Conexion.Conectar();
            PreparedStatement pst=cn.prepareStatement("delete from tabla_proveedores where Ruc_proveedor =?");
            
            pst.setString(1,txt_ruc.getText().trim());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
             ActualizarVentana();
           }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al eliminar registro, Contacte al Administrador");
            System.err.println("error al eliminar registro: "+e);
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void txt_rucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyTyped
        // ingresar maximo 6 caracteres
        if(txt_ruc.getText().length()>=11){
            evt.consume(); //no permitir ingresar mas letras
            Toolkit.getDefaultToolkit().beep();// enviar un sonido indicando que no se permite
        }
        // ingresar solo numeros
        char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{

        }
    }//GEN-LAST:event_txt_rucKeyTyped

    private void txt_razonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_razonSocialKeyTyped

    }//GEN-LAST:event_txt_razonSocialKeyTyped

    private void txt_correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        // ingresar solo numeros
        char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{

        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionKeyTyped

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
            java.util.logging.Logger.getLogger(ListaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProveedores;
    private javax.swing.JComboBox<String> jcmb_tipoFiltro;
    private javax.swing.JTextField txt_BuscarPorFiltro;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_razonSocial;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables


 //****METODO PARA Limpar ****
 public void LimpiarCampos(){
    txt_ruc.setText("");
    txt_telefono.setText("");
    txt_razonSocial.setText("");
    txt_correo.setText("");
    txt_direccion.setText("");
    
}
 
 //******** METODO PARA RELLENAR TABLA ********
 public void agregarDatosTabla(){
    //GestionCeldas MensajeroGestionCeldas= new GestionCeldas();

    try {
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Ruc_proveedor , Razon_proveedor, Correo_proveedor,"
                    + " Telf_proveedor,Direccion__proveedor from tabla_proveedores");
            ResultSet resul1=pst1.executeQuery();
            
            // AGREGAR ENCABEZADOS A LA TABLA
            jTableProveedores = new JTable(model);
            jScrollPane2.setViewportView(jTableProveedores);
            model.addColumn("RUC");
            model.addColumn("RAZON SOCIAL");
            model.addColumn("CORREO");
            model.addColumn("TELEFONO");
            model.addColumn("DIRECCIÓN");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTableProveedores.getColumnCount());i++)
            {
                jTableProveedores.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTableProveedores.getColumnCount());i++)
            {
                jTableProveedores.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            /*  ////AGREGAR COLOR A celas con la clases gectionCelda
               for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroGestionCeldas);
            }*/
             jTableProveedores.getColumnModel().getColumn(0).setPreferredWidth(80);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(1).setPreferredWidth(200);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(2).setPreferredWidth(80);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(3).setPreferredWidth(60);//dimensionar columna 0
             jTableProveedores.getColumnModel().getColumn(4).setPreferredWidth(200);//dimensionar columna 0
             jTableProveedores.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[5];
                for(int i=0;i<5;i++){
                    fila[i]=resul1.getObject(i+1);
                }
                model.addRow(fila);
            }
            
        
            cn1.close();
        } catch (Exception e) {
            System.err.println("error en  rellenar de proveedores tabla :"+e);
        }
}
 
 // ************** METODO PARA ACTUALIZAR VENTANA ****************
 public void ActualizarVentana(){
     this.setVisible(false);
     ListaProveedores mensajero= new ListaProveedores();
     mensajero.setVisible(true);
 }
 
 
 //*************** metodo buscador de productos ******************
 public void BuscardorDeProveedores(String rucProveedores){
     jButton_Eliminar.setEnabled(true);
     jButton_actualizar.setEnabled(true);
 try {
         Connection cn= Conexion.Conectar();
         PreparedStatement pst= cn.prepareStatement("select Ruc_proveedor, Razon_proveedor, Correo_proveedor, Telf_proveedor, "
                 + "Direccion__proveedor from tabla_proveedores where Ruc_proveedor  ='"+rucProveedores+"'");
         ResultSet resul=pst.executeQuery(); 
         if(resul.next()){
           txt_ruc.setText(resul.getString("Ruc_proveedor"));
           txt_razonSocial.setText(resul.getString("Razon_proveedor"));
           txt_correo.setText(resul.getString("Correo_proveedor"));
           txt_direccion.setText(resul.getString("Direccion__proveedor"));
           txt_telefono.setText(resul.getString("Telf_proveedor"));
           
          cn.close();
          }else{
              JOptionPane.showMessageDialog(null, "Ruc ("+rucProveedores+") no encontrado","ERROR!!!", JOptionPane.WARNING_MESSAGE);
              
         }
        }catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al buscar al Proveedor, contacte al administrador");
            System.err.println("error al buscar cliente de la tabla: "+e);
     }
 }
 

}
