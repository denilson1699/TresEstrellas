
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
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.table.TableCellRenderer;

public class ListaUsuarios extends javax.swing.JFrame {
      public static String dni_usuarioTabla,nombre_update, apellido_update,dni_update,pass_update,estado_usuarioTabla;

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

     // METODO CONSTRUCTOR 
    public ListaUsuarios() {
    initComponents();  
    getContentPane().setBackground(new Color(255,255,204));
      setResizable(false); // interfas no se mueva
        setSize(862, 652);
      setLocationRelativeTo(null); // interfaz centrada
      //this.setExtendedState(MAXIMIZED_BOTH); // dimenciones de la interfaz
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Usuarios");
      
     
        // recuperados metodo para agregamos datos a la tabla
       agregarDatosTabla();
        
        //crreamos metodo para el EVENTO de la TABLA
        jTableUsuarios.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
         int fila_poin=jTableUsuarios.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            dni_usuarioTabla=(String) model.getValueAt(fila_poin,0);
            estado_usuarioTabla=(String) model.getValueAt(fila_poin,5);
            // recuperamos metodo para  ostrar informacion de celda selecionada
                System.out.println("dni 1 "+dni_usuarioTabla);
             BuscardorDeProductos(dni_usuarioTabla);
            
            if(estado_usuarioTabla.equals("DESACTIVO"))
            {
              txt_stockBuscar.setText("Sin acceso");
              txt_stockBuscar.setForeground(Color.red);
            }else
            {
              txt_stockBuscar.setText("Con acceso");
              txt_stockBuscar.setForeground(new Color(0,153,0));
            }
            
            }
         }  
        });
        
        jButton_Eliminar.setEnabled(false);
        jButton_actualizar.setEnabled(false);
     jButton_RestaurarContraseña.setEnabled(false);
    
          }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_agregar = new javax.swing.JButton();
        cmb_cargo = new javax.swing.JComboBox<>();
        txt_pass = new javax.swing.JTextField();
        jButton_nuevo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton_actualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_RestaurarContraseña = new javax.swing.JButton();
        txt_dni = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmb_estado = new javax.swing.JComboBox<>();
        cmb_sexo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txt_apellidos = new javax.swing.JTextField();
        jButton_Eliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        txt_codBuscarUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton_productoBuscar = new javax.swing.JButton();
        txt_stockBuscar = new javax.swing.JTextField();

        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_agregar.setBackground(new java.awt.Color(102, 102, 255));
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
        getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 170, 40));

        cmb_cargo.setBackground(new java.awt.Color(255, 204, 153));
        cmb_cargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmb_cargo.setForeground(new java.awt.Color(0, 153, 153));
        cmb_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ADMINISTRADOR", "VENDEDOR" }));
        cmb_cargo.setBorder(null);
        getContentPane().add(cmb_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 120, -1));

        txt_pass.setEditable(false);
        txt_pass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(0, 102, 102));
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passKeyTyped(evt);
            }
        });
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, 170, 30));

        jButton_nuevo.setBackground(new java.awt.Color(102, 102, 255));
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
        getContentPane().add(jButton_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 170, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Cargo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Correo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        jButton_actualizar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_actualizar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, 170, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DNI (user):");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

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
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 170, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Telf Movil:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Sexo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));

        jButton_RestaurarContraseña.setBackground(new java.awt.Color(102, 102, 255));
        jButton_RestaurarContraseña.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_RestaurarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RestaurarContraseña.setText("Cambiar Contraseña");
        jButton_RestaurarContraseña.setBorder(null);
        jButton_RestaurarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_RestaurarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarContraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestaurarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 190, 40));

        txt_dni.setEditable(false);
        txt_dni.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_dni.setForeground(new java.awt.Color(0, 102, 102));
        txt_dni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_dni.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dniKeyTyped(evt);
            }
        });
        getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 170, 30));

        txt_nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(0, 102, 102));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Apellidos:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        cmb_estado.setBackground(new java.awt.Color(255, 204, 153));
        cmb_estado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmb_estado.setForeground(new java.awt.Color(0, 153, 153));
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ACTIVO", "DESACTIVO" }));
        cmb_estado.setBorder(null);
        getContentPane().add(cmb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 120, -1));

        cmb_sexo.setBackground(new java.awt.Color(255, 204, 153));
        cmb_sexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmb_sexo.setForeground(new java.awt.Color(0, 153, 153));
        cmb_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "M", "F" }));
        cmb_sexo.setBorder(null);
        getContentPane().add(cmb_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 120, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Pass:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, -1));

        txt_apellidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_apellidos.setForeground(new java.awt.Color(0, 102, 102));
        txt_apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_apellidos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyTyped(evt);
            }
        });
        getContentPane().add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 170, 30));

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
        getContentPane().add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 170, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Estado:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

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
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 170, 30));

        jTableUsuarios.setBackground(new java.awt.Color(0, 255, 0));
        jTableUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableUsuarios.setDragEnabled(true);
        jTableUsuarios.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTableUsuarios);
        if (jTableUsuarios.getColumnModel().getColumnCount() > 0) {
            jTableUsuarios.getColumnModel().getColumn(0).setMinWidth(18);
            jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableUsuarios.getColumnModel().getColumn(0).setMaxWidth(16);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 794, 172));

        txt_codBuscarUser.setBackground(new java.awt.Color(204, 204, 255));
        txt_codBuscarUser.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_codBuscarUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codBuscarUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_codBuscarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 240, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("CODIGO USUARIO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 34, 120, 20));

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
        getContentPane().add(jButton_productoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 29, 90, 30));

        txt_stockBuscar.setEditable(false);
        txt_stockBuscar.setBackground(new java.awt.Color(255, 255, 102));
        txt_stockBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_stockBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_stockBuscar.setBorder(null);
        getContentPane().add(txt_stockBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 80, 150, 23));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_productoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_productoBuscarActionPerformed
        
    // buscamos una un valores en la tabla
    // recuperamos valor ingreado en el txt para la consulta
    String valorBscado = (txt_codBuscarUser.getText().trim()).toUpperCase();
        for (int i = 0; i < jTableUsuarios.getRowCount(); i++) 
        {
          if (jTableUsuarios.getValueAt(i, 0).equals(valorBscado)) 
          {
            jTableUsuarios.changeSelection(i, 0, false, false);  
            //remplazamos valor ingresado por el correcto 
            String RemplazarValorBuscado=(String) jTableUsuarios.getValueAt(i,0);
            txt_codBuscarUser.setText(RemplazarValorBuscado); 
          }
        }

     // recuperamos metodo que devuelve infromacion del valor buscado en la tabla
     BuscardorDeProductos(valorBscado);
        System.out.println("valor buscado "+valorBscado);
        
    }//GEN-LAST:event_jButton_productoBuscarActionPerformed
 
    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
     try {
          int mensaje=JOptionPane.showConfirmDialog(null,"Eliminar Usuario  [S/N]:",null,JOptionPane.YES_NO_OPTION);
          if(mensaje==JOptionPane.YES_OPTION)
          {
            Connection cn=Conexion.Conectar();
            PreparedStatement pst=cn.prepareStatement("delete from tabla_user where Dni_user=?");
            
            pst.setString(1,txt_dni.getText().trim());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
             ActualizarVentana();
           }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se pudo concretar eliminacion contacte al administrador");
            System.err.println("error al eliminar registro: "+e);
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        String dni,nombre,apellidos,correo, telefono, sexo, cargo,estado, pass; int  contador=0;
        dni    =txt_dni.getText().trim().toUpperCase();
        nombre =txt_nombre.getText().trim().toUpperCase();
        apellidos =txt_apellidos.getText().trim().toUpperCase();
        correo =txt_correo.getText().trim().toLowerCase();
        telefono =txt_telefono.getText().trim();
        sexo =(String) cmb_sexo.getSelectedItem();
        cargo =(String) cmb_cargo.getSelectedItem();
        estado =(String) cmb_estado.getSelectedItem();
        pass=txt_pass.getText().trim();
        
        // validamos qiue no encuentren campos en blanco
        if(dni.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar DNI");
         txt_dni.requestFocus();
         contador++;
        }
        if(nombre.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar Nombre");
         txt_nombre.requestFocus();
         contador++;
        }
        if(apellidos.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar Apellidos");
         txt_apellidos.requestFocus();
         contador++;
        }
        if(correo.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar Correo");
         txt_telefono.requestFocus();
         contador++;
        }
        if(telefono.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar Telefono");
         txt_correo.requestFocus();
         contador++;
        }
        if(pass.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar la Contraseña");
         txt_pass.requestFocus();
         contador++;
        }
        if(sexo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar Sexo");
         contador++;
        }
        if(sexo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar Cargo");
         contador++;
        }
        if(sexo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar Estado");
         contador++;
        }
        
        // si todos los campos entan llenos
     if(contador==0)
     {
      try 
      {
          String valCodigo;
          Connection cn1= Conexion.Conectar();
          PreparedStatement pst1= cn1.prepareStatement("select Dni_user from tabla_user where Dni_user ='"+dni+"'");
          ResultSet resul1=pst1.executeQuery();
          if(resul1.next())
          {
          valCodigo=resul1.getString("Dni_user");
          // validamos que el codigo o se repita
          if (dni.equals(valCodigo))
             {
             JOptionPane.showMessageDialog(null, ""+dni+" ya  existe ");
             }
          }else{// valdar s desea guardar producto
              int mensaje=JOptionPane.showConfirmDialog(null,"Guardar nuevo usuario  [S/N]:",null,JOptionPane.YES_NO_OPTION);
              if(mensaje==JOptionPane.YES_OPTION)
               {
               try 
                 {
                 Connection cn2=Conexion.Conectar();
                 PreparedStatement pst2= cn2.prepareStatement("insert into tabla_user values (?,?,?,?,?,?,?,?,?)");
                 
                 pst2.setString(1,dni );
                 pst2.setString(2,pass );
                 pst2.setString(3, nombre);
                 pst2.setString(4,apellidos);
                 pst2.setString(5,correo );
                 pst2.setString(6,cargo );
                 pst2.setString(7,estado );
                 pst2.setString(8,telefono );
                 pst2.setString(9,sexo);
                 pst2.executeUpdate();
                 cn2.close();
                 // preguntar si desea generar un nuevo registro
                 int mensaje2=JOptionPane.showConfirmDialog(null,"Registro exitoso continuar [S/N]:",null,JOptionPane.YES_NO_OPTION);
                 if(mensaje==JOptionPane.YES_OPTION)
                   { // para blanquiar los campos y dejarlos listo para el ingreso de nuevos datos
                       
                        // recuperadmos metodo para blanquiar campos
                        LimpiarCampos();

                        // desavilitamos boton actualizar y eliminar
                        jButton_actualizar.setEnabled(false);
                        jButton_Eliminar.setEnabled(false);
                        // avilitamos jtextfiels codigo producto
                        txt_dni.setEditable(true);

                     }
                 } catch (Exception e) 
                 {
                 JOptionPane.showMessageDialog(null, "no se pudo registrar nuevo usuario","",JOptionPane.ERROR_MESSAGE);
                 System.err.println("error al registrar nuevo usuario: "+e);
                 }
                 }else
                    {// si no se desea grabar nuevo usuario
                     JOptionPane.showMessageDialog(null, "CANCELADO");
                    }
                }
                
        }catch (SQLException ex) {}
        }

    }//GEN-LAST:event_jButton_agregarActionPerformed
    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed
      // para blanquiar los campos y dejarlos listo para el ingreso de nuevos datos
         // recuperadmos metodo para blanquiar campos
      LimpiarCampos();
      
      // desavilitamos boton actualizar y eliminar
      jButton_actualizar.setEnabled(false);
      jButton_Eliminar.setEnabled(false);
      jButton_RestaurarContraseña.setEnabled(false);
      // avilitamos jtextfiels codigo producto
      txt_dni.setEditable(true);
      txt_pass.setEditable(true);

    
    }//GEN-LAST:event_jButton_nuevoActionPerformed
    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
      String dni,nombre,apellidos,correo, telefono, sexo, cargo,estado, pass; int  contador=0;
        dni    =txt_dni.getText().trim().toUpperCase();
        nombre =txt_nombre.getText().trim().toUpperCase();
        apellidos =txt_apellidos.getText().trim().toUpperCase();
        correo =txt_correo.getText().trim().toLowerCase();
        telefono =txt_telefono.getText().trim();
        sexo =(String) cmb_sexo.getSelectedItem();
        cargo =(String) cmb_cargo.getSelectedItem();
        estado =(String) cmb_estado.getSelectedItem();
        pass=txt_pass.getText().trim();
        
        // validamos qiue no encuentren campos en blanco
        if(dni.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar DNI");
         txt_dni.requestFocus();
         contador++;
        }
        if(nombre.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar Nombre");
         txt_nombre.requestFocus();
         contador++;
        }
        if(apellidos.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar apellidos");
         txt_apellidos.requestFocus();
         contador++;
        }
        if(correo.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar correo");
         txt_telefono.requestFocus();
         contador++;
        }
        if(telefono.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar telefono");
         txt_correo.requestFocus();
         contador++;
        }
        if(pass.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar la contraseña");
         txt_pass.requestFocus();
         contador++;
        }
        if(sexo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar sexo");
         contador++;
        }
        if(sexo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar cargo");
         contador++;
        }
        if(sexo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar esatado");
         contador++;
        }
        
        System.out.println("contado: "+contador);
        // si todos los campos en llenos
      if(contador==0)
      {  // pregusntar si se desea guar la actualizacion
        int mensaje=JOptionPane.showConfirmDialog(null,"Guardar Cambios  [S/N]:",null,JOptionPane.YES_NO_OPTION);
        if(mensaje==JOptionPane.YES_OPTION)
        {
        try {// actualizar datos en la bse de datos
            Connection cn=Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement("update tabla_user set Pass_user=?, Nombre_user=?, Apellidos_user=?, Sexo_user=?,Cargo_user=?,Correo_user=?, Telf_user=?, Estado_user=? where Dni_user ='"+dni+"'");
            pst.setString(1,pass );
            pst.setString(2,nombre);
            pst.setString(3,apellidos);
            pst.setString(4,sexo);
            pst.setString(5,cargo);
            pst.setString(6,correo );
            pst.setString(7,telefono);
            pst.setString(8,estado);
            
            pst.executeUpdate();
            cn.close();
            JOptionPane.showMessageDialog(null,"Actualización exitosa");
            ActualizarVentana();
            }catch (SQLException e) 
            {
            JOptionPane.showMessageDialog(null, "no se pudo actualizar datos","",JOptionPane.ERROR_MESSAGE);
            System.err.println("error al actualizar: "+e);
            }
        }else
        {// s no se desea actualizar datos
        JOptionPane.showMessageDialog(null, "ACTUALIZACÓN CANCELADA");
        }
     }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
       // ingresar solo numeros
        char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{
            
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped

    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
      // ingresar maximo 6 caracteres
        if(txt_dni.getText().length()>=8){
           evt.consume(); //no permitir ingresar mas letras
            Toolkit.getDefaultToolkit().beep();// enviar un sonido indicando que no se permite
       }
         // ingresar solo numeros
        char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{
            
        }
    }//GEN-LAST:event_txt_dniKeyTyped

    private void txt_correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoKeyTyped

    private void txt_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyTyped

    }//GEN-LAST:event_txt_apellidosKeyTyped

    private void jButton_RestaurarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarContraseñaActionPerformed
        RestaurarPass restaurarPass= new RestaurarPass();
        restaurarPass.setVisible(true);
        
    }//GEN-LAST:event_jButton_RestaurarContraseñaActionPerformed

    private void txt_passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passKeyTyped


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
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_cargo;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JComboBox<String> cmb_sexo;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_RestaurarContraseña;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JButton jButton_productoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_codBuscarUser;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_stockBuscar;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables


 

 //****METODO PARA Limpar ****
 public void LimpiarCampos(){
    txt_dni.setText("");
    txt_telefono.setText("");
    txt_nombre.setText("");
    txt_apellidos.setText("");
    txt_correo.setText("");
    txt_pass.setText("");
    cmb_cargo.setSelectedIndex(0);
    cmb_estado.setSelectedIndex(0);
    cmb_sexo.setSelectedIndex(0);
}
 
 //******** METODO PARA RELLENAR TABLA ********
 public void agregarDatosTabla(){
    //GestionCeldas MensajeroGestionCeldas= new GestionCeldas();

    try {
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Dni_user , Nombre_user, Apellidos_user,"
                    + " Cargo_user,Telf_user,Estado_user from tabla_user");
            ResultSet resul1=pst1.executeQuery();
            // AGREGAR ENCABEZADOS A LA TABLA
            jTableUsuarios = new JTable(model);
            jScrollPane2.setViewportView(jTableUsuarios);
            model.addColumn("DNI");
            model.addColumn("NOMBRE");
            model.addColumn("APELLIDOS");
            model.addColumn("CARGO");
            model.addColumn("TELF");
            model.addColumn("ESTADO");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTableUsuarios.getColumnCount())-1;i++)
            {
                jTableUsuarios.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTableUsuarios.getColumnCount());i++)
            {
                jTableUsuarios.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            /*  ////AGREGAR COLOR A celas con la clases gectionCelda
               for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroGestionCeldas);
            }*/
             jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(60);//dimensionar columna 0
             jTableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(100);//dimensionar columna 0
             jTableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(200);//dimensionar columna 0
             jTableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(70);//dimensionar columna 0
             jTableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(60);//dimensionar columna 0
             jTableUsuarios.getColumnModel().getColumn(5).setMaxWidth(60);//dimensionar columna 0
          
             jTableUsuarios.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[6];
                for(int i=0;i<6;i++){
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
     ListaUsuarios mensajero= new ListaUsuarios();
     mensajero.setVisible(true);
 }
 
 //*************** metodo buscador de productos ******************
 public void BuscardorDeProductos(String dniUsuario){
     jButton_Eliminar.setEnabled(true);
     jButton_actualizar.setEnabled(true);
     jButton_RestaurarContraseña.setEnabled(true);
 try {
         Connection cn= Conexion.Conectar();
         PreparedStatement pst= cn.prepareStatement("select Dni_user, Pass_user, Nombre_user, Apellidos_user, "
                 + "Correo_user, Telf_user, Cargo_user, Sexo_user, Estado_user from tabla_user where Dni_user='"+dniUsuario+"'");
         ResultSet resul=pst.executeQuery(); 
         if(resul.next()){
           txt_dni.setText(resul.getString("Dni_user"));
           txt_pass.setText(resul.getString("Pass_user"));
           txt_nombre.setText(resul.getString("Nombre_user"));
           txt_apellidos.setText(resul.getString("Apellidos_user"));
           txt_correo.setText(resul.getString("Correo_user"));
           txt_telefono.setText(resul.getString("Telf_user"));
           
           
        nombre_update = txt_nombre.getText().trim();
        apellido_update= txt_apellidos.getText().trim();
        dni_update=txt_dni.getText().trim();
        pass_update=txt_pass.getText().trim();
           
           String cargo=resul.getString("Cargo_user");
           if(cargo.equals("ADMINISTRADOR")){
               cmb_cargo.setSelectedIndex(1);
           }
           if(cargo.equals("VENDEDOR")){
               cmb_cargo.setSelectedIndex(2);
           }
           
            String sexo=resul.getString("Sexo_user");
           if(sexo.equals("M")){
               cmb_sexo.setSelectedIndex(1);
           }
           if(sexo.equals("F")){
               cmb_sexo.setSelectedIndex(2);
           }
           
            String estado=resul.getString("Estado_user");
           if(estado.equals("ACTIVO")){
               cmb_estado.setSelectedIndex(1);
           }
           if(estado.equals("DESACTIVO")){
               cmb_estado.setSelectedIndex(2);
           }

          cn.close();
          }else{
              JOptionPane.showMessageDialog(null, "codigo ("+dniUsuario+") no encontrado","ERROR!!!", JOptionPane.WARNING_MESSAGE);
              txt_codBuscarUser.requestFocus();
              
         }
        }catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al buscar el productos contacte al administrador");
            System.err.println("error al buscar usuario de la tabla: "+e);
     }
 }
 

 
}
