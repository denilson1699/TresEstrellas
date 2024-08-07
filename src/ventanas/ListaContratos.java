
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
import static ventanas.Login.FechaDeIngreso;

public class ListaContratos extends javax.swing.JFrame {
      public static String codContrato_Tabla,nombre_update, apellido_update,dni_update,pass_update,estado_usuarioTabla;

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
     String dia, mes, year;
     // METODO CONSTRUCTOR 
    public ListaContratos() {
    initComponents();
      setResizable(false); // interfas no se mueva
        setSize(862, 652);
      setLocationRelativeTo(null); // interfaz centrada
      //this.setExtendedState(MAXIMIZED_BOTH); // dimenciones de la interfaz
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Usuarios");
      //metodo calendario para la fecha y hora de ingreso
        Calendar calendario = Calendar.getInstance();
        dia = Integer.toString(calendario.get(Calendar.DATE));
        mes = Integer.toString(calendario.get(Calendar.MONTH) + 1);
        year= Integer.toString(calendario.get(Calendar.YEAR));
        
        txt_dia1.setText(String.valueOf(dia));
        txt_mes.setText(String.valueOf(mes));
        txt_year.setText(String.valueOf(year));
      
       //recuperados metodo para agregamos datos a la tabla
       agregarDatosTabla();
        
        //crreamos metodo para el EVENTO de la TABLA
        jTableContratos.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
         int fila_poin=jTableContratos.rowAtPoint(e.getPoint());
            if(fila_poin>-1)
            {
            codContrato_Tabla=(String) model.getValueAt(fila_poin,0);
            // recuperamos metodo para  ostrar informacion de celda selecionada
   
                BuscardorDeContratos(codContrato_Tabla);
         
            
            }
         }  
        });
        
        jButton_Eliminar.setEnabled(false);
        jButton_actualizar.setEnabled(false);
    
                //------------ imagend e fondo --------------------------
        ImageIcon imagenFondo= new ImageIcon("src/images/imagenFondo.jpg");
        Icon iconoFondo=new ImageIcon(imagenFondo.getImage().getScaledInstance(
        jLabel_fondo.getWidth(),jLabel_fondo.getHeight(),Image.SCALE_DEFAULT));
        jLabel_fondo.setIcon(iconoFondo);
        this.repaint(); 
        }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_agregar = new javax.swing.JButton();
        jButton_nuevo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton_actualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_hora_ingreso = new javax.swing.JTextField();
        txt_codigoContrato = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmb_DiaDescanso = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txt_year = new javax.swing.JTextField();
        jButton_Eliminar = new javax.swing.JButton();
        txt_sueldo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContratos = new javax.swing.JTable();
        txt_codBuscarUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton_productoBuscar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txt_dia1 = new javax.swing.JTextField();
        txt_mes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_hora_salida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel_fondo = new javax.swing.JLabel();

        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_agregar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_agregar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Agregar.png"))); // NOI18N
        jButton_agregar.setText("Agregar");
        jButton_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 170, 40));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Dni del Colaborador:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Horario de Trabajo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

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
        jLabel3.setText("Codigo Contrato:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        txt_hora_ingreso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_hora_ingreso.setForeground(new java.awt.Color(0, 102, 102));
        txt_hora_ingreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hora_ingreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_hora_ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_hora_ingreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hora_ingresoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_hora_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 50, 20));

        txt_codigoContrato.setEditable(false);
        txt_codigoContrato.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_codigoContrato.setForeground(new java.awt.Color(0, 102, 102));
        txt_codigoContrato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContrato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_codigoContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_codigoContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoContratoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_codigoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 170, 30));

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
        getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha del Contrato:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        cmb_DiaDescanso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmb_DiaDescanso.setForeground(new java.awt.Color(0, 153, 153));
        cmb_DiaDescanso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione día", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        cmb_DiaDescanso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(cmb_DiaDescanso, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 170, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Sueldo del Colaborador:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, -1, -1));

        txt_year.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_year.setForeground(new java.awt.Color(0, 102, 102));
        txt_year.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_year.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_year.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_yearKeyTyped(evt);
            }
        });
        getContentPane().add(txt_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 50, 30));

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

        txt_sueldo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_sueldo.setForeground(new java.awt.Color(0, 102, 102));
        txt_sueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sueldo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_sueldo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_sueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sueldoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_sueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 70, 30));

        jTableContratos.setBackground(new java.awt.Color(0, 255, 0));
        jTableContratos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTableContratos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableContratos.setDragEnabled(true);
        jTableContratos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTableContratos);
        if (jTableContratos.getColumnModel().getColumnCount() > 0) {
            jTableContratos.getColumnModel().getColumn(0).setMinWidth(18);
            jTableContratos.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableContratos.getColumnModel().getColumn(0).setMaxWidth(16);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 794, 172));

        txt_codBuscarUser.setBackground(new java.awt.Color(204, 204, 255));
        txt_codBuscarUser.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_codBuscarUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codBuscarUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_codBuscarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 240, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código Contratos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, 20));

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
        getContentPane().add(jButton_productoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 90, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Día de Descanso");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        txt_dia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_dia1.setForeground(new java.awt.Color(0, 102, 102));
        txt_dia1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dia1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_dia1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_dia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dia1KeyTyped(evt);
            }
        });
        getContentPane().add(txt_dia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 30, 30));

        txt_mes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_mes.setForeground(new java.awt.Color(0, 102, 102));
        txt_mes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_mes.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_mes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mesKeyTyped(evt);
            }
        });
        getContentPane().add(txt_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 30, 30));

        jLabel2.setText("Mes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        jLabel5.setText("Año");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        jLabel7.setText("Hora de ingreso");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        jLabel8.setText("Día");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));

        txt_hora_salida.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_hora_salida.setForeground(new java.awt.Color(0, 102, 102));
        txt_hora_salida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hora_salida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_hora_salida.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_hora_salida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hora_salidaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_hora_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 50, 20));

        jLabel9.setText("S/.");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 590, -1, -1));

        jLabel12.setText("Hora de Salida");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, -1));
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_productoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_productoBuscarActionPerformed
        
    // buscamos una un valores en la tabla
    // recuperamos valor ingreado en el txt para la consulta
    String valorBscado = (txt_codBuscarUser.getText().trim()).toUpperCase();
        for (int i = 0; i < jTableContratos.getRowCount(); i++) 
        {
          if (jTableContratos.getValueAt(i, 0).equals(valorBscado)) 
          {
            jTableContratos.changeSelection(i, 0, false, false);  
            //remplazamos valor ingresado por el correcto 
            String RemplazarValorBuscado=(String) jTableContratos.getValueAt(i,0);
            txt_codBuscarUser.setText(RemplazarValorBuscado); 
          }
        }

     // recuperamos metodo que devuelve infromacion del valor buscado en la tabla
        BuscardorDeContratos(valorBscado);
        
    }//GEN-LAST:event_jButton_productoBuscarActionPerformed
 
    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
     try {
          int mensaje=JOptionPane.showConfirmDialog(null,"Eliminar Contrato",null,JOptionPane.YES_NO_OPTION);
          if(mensaje==JOptionPane.YES_OPTION)
          {
            Connection cn=Conexion.Conectar();
            PreparedStatement pst=cn.prepareStatement("delete from tabla_contratos where CodigoContrato=?");
            
            pst.setString(1,txt_codigoContrato.getText().trim());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contrato Eliminado");
             ActualizarVentana();
           }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se pudo concretar eliminacion contacte al administrador");
            System.err.println("error al eliminar Contrato: "+e);
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        String codiContrato,dniEmple,diaDesca,diaCont,mesCont, yearCont,hrIngreso, hrSalida, sueldo; int contador=0;
        codiContrato    =txt_codigoContrato.getText().trim().toUpperCase();
        dniEmple =txt_dni.getText().trim();
        yearCont =txt_year.getText().trim();
        mesCont=txt_mes.getText().trim();
        diaCont=txt_dia1.getText().trim();
        hrIngreso =txt_hora_ingreso.getText().trim();
        hrSalida =txt_hora_salida.getText().trim();
        sueldo =txt_sueldo.getText().trim();
        diaDesca =(String) cmb_DiaDescanso.getSelectedItem();
        String fech=diaCont+"/"+mesCont+"/"+yearCont;
                     System.out.println("feeee:"+fech);
        
         //QUE SE INGRESEN 
         int days=Integer.parseInt(txt_dia1.getText().trim());
         int moths=Integer.parseInt(txt_mes.getText().trim());
         int years=Integer.parseInt(txt_year.getText().trim());
         int añosInt;
         añosInt=Integer.parseInt(year);
         if(days>30 || days<=0){
         JOptionPane.showMessageDialog(null, "Ingrese un dia valido de 1 a 30");
         txt_dia1.requestFocus();
         contador++;
         }
         if(moths>12 || moths<=0){
          JOptionPane.showMessageDialog(null, "Ingrese un mes valido de 1 a 12");
         txt_mes.requestFocus();
         contador++;
         }
         if(years>añosInt){
         JOptionPane.showMessageDialog(null, "Ingrese un año <="+year);
         txt_year.requestFocus();
         contador++;
         }
         // QUE SE INGRESEN 2 VALORES PARA DIA Y MES Y 4 VALORES PARA AÑO
         int conterDia= diaCont.length();
         int conterMes= mesCont.length();
         int conterAño= yearCont.length();
         if(conterDia<=1)
         {
         JOptionPane.showMessageDialog(null, "Ejemplo dia: dd/mm/yyyy");
         txt_dia1.requestFocus();
         contador++;
         }  
         if(conterMes<=1)
         {
         JOptionPane.showMessageDialog(null, "Ejemplo Mes: dd/mm/yyyy");
         txt_mes.requestFocus();
         contador++;
         }
         if(conterAño<=3)
         {
         JOptionPane.showMessageDialog(null, "Ejemplo Año: dd/mm/yyyy");
         txt_year.requestFocus();
         contador++;
         }
         
         
         
        // validamos qiue no encuentren campos en blanco
        if(codiContrato.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar Código del Contrato");
         txt_codigoContrato.requestFocus();
         contador++;
        }
        if(dniEmple.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar DNI");
         txt_dni.requestFocus();
         contador++;
        }
        if(yearCont.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar año");
         txt_year.requestFocus();
         contador++;
        }
        if(mesCont.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar mes");
         txt_mes.requestFocus();
         contador++;
        }
        if(diaCont.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar dia");
         txt_dia1.requestFocus();
         contador++;
        }
        if(hrIngreso.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar hora de ingreso");
         txt_hora_ingreso.requestFocus();
         contador++;
        }
        if(hrSalida.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar hora de salida");
         txt_hora_salida.requestFocus();
         contador++;
        }
        if(sueldo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar sueldo");
         txt_sueldo.requestFocus();
         contador++;
        }
        if(diaDesca.equals("Seleccione día"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar un dia de descanso");
         contador++;
        }
        
        // si todos los campos entan llenos
     if(contador==0)
     {
      try 
      {
          String valCodigo, valdni;
          Connection cn1= Conexion.Conectar();
          PreparedStatement pst1= cn1.prepareStatement("select CodigoContrato, Dni_user from tabla_contratos where CodigoContrato ='"+codiContrato+"'");
          ResultSet resul1=pst1.executeQuery();
          
          if(resul1.next())
          {
          valCodigo=resul1.getString("CodigoContrato");
          valdni=resul1.getString("Dni_user");
          // validamos que el codigo o se repita
   
         if(dniEmple.equals(valdni))
            {
             JOptionPane.showMessageDialog(null, ""+dniEmple+" ya  existe ");
            }
         if(codiContrato.equals(valCodigo))
            {
             JOptionPane.showMessageDialog(null, ""+codiContrato+" ya  existe ");

            }
          }
          else{// valdar s desea guardar producto
              int mensaje=JOptionPane.showConfirmDialog(null,"Guardar nuevo Contrato:",null,JOptionPane.YES_NO_OPTION);
              if(mensaje==JOptionPane.YES_OPTION)
               {
               try 
                 {
                 Connection cn2=Conexion.Conectar();
                 PreparedStatement pst2= cn2.prepareStatement("insert into tabla_contratos values (?,?,?,?,?,?,?)");
                
                 pst2.setString(1,codiContrato );
                 pst2.setString(2,dniEmple );
                 pst2.setString(3,fech);
                 pst2.setString(4,hrIngreso);
                 pst2.setString(5,hrSalida);
                 pst2.setString(6,diaDesca );
                 pst2.setString(7,sueldo);
                 pst2.executeUpdate();
                 cn2.close();
                 // preguntar si desea generar un nuevo registro
                 int mensaje2=JOptionPane.showConfirmDialog(null,"Contrato Registrado,continuar [S/N]:",null,JOptionPane.YES_NO_OPTION);
                 if(mensaje==JOptionPane.YES_OPTION)
                   { // para blanquiar los campos y dejarlos listo para el ingreso de nuevos datos
                       
                        // recuperadmos metodo para blanquiar campos
                        LimpiarCampos();
                        // desavilitamos boton actualizar y eliminar
                        jButton_actualizar.setEnabled(false);
                        jButton_Eliminar.setEnabled(false);
                        // avilitamos jtextfiels codigo producto
                        txt_codigoContrato.setEditable(true);

                     }
                 } catch (Exception e) 
                 {
                 JOptionPane.showMessageDialog(null, "no se pudo registrar nuevo contrato","",JOptionPane.ERROR_MESSAGE);
                 System.err.println("error al registrar nuevo Contrato: "+e);
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
      // avilitamos jtextfiels codigo producto
      txt_codigoContrato.setEditable(true);
      txt_dia1.setEditable(true);
        txt_dni.setEditable(true);
        txt_year.setEditable(true);
        txt_mes.setEditable(true);
        txt_codigoContrato.setText("C");


    
    }//GEN-LAST:event_jButton_nuevoActionPerformed
    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
      String codiContrato,dniEmple,diaDesca,diaCont,mesCont, yearCont,hrIngreso, hrSalida, sueldo; int contador=0;
        codiContrato    =txt_codigoContrato.getText().trim().toUpperCase();
        dniEmple =txt_dni.getText().trim();
        yearCont =txt_year.getText().trim();
        mesCont=txt_mes.getText().trim();
        diaCont=txt_dia1.getText().trim();
        hrIngreso =txt_hora_ingreso.getText().trim();
        hrSalida =txt_hora_salida.getText().trim();
        sueldo =txt_sueldo.getText().trim();
        diaDesca =(String) cmb_DiaDescanso.getSelectedItem();
        
         //QUE SE INGRESEN 
         int days=Integer.parseInt(txt_dia1.getText().trim());
         int moths=Integer.parseInt(txt_mes.getText().trim());
         int years=Integer.parseInt(txt_year.getText().trim());
         int añosInt;
         añosInt=Integer.parseInt(year);
         if(days>30 || days<=0){
         JOptionPane.showMessageDialog(null, "Ingrese un dia valido de 1 a 30");
         txt_dia1.requestFocus();
         contador++;
         }
         if(moths>12 || moths<=0){
          JOptionPane.showMessageDialog(null, "Ingrese un mes valido de 1 a 12");
         txt_mes.requestFocus();
         contador++;
         }
         if(years>añosInt){
         JOptionPane.showMessageDialog(null, "Ingrese un año <="+year);
         txt_year.requestFocus();
         contador++;
         }
         // QUE SE INGRESEN 2 VALORES PARA DIA Y MES Y 4 VALORES PARA AÑO
         int conterDia= diaCont.length();
         int conterMes= mesCont.length();
         int conterAño= yearCont.length();
         if(conterDia<=1)
         {
         JOptionPane.showMessageDialog(null, "Ejemplo dia: dd/mm/yyyy");
         txt_dia1.requestFocus();
         contador++;
         }  
         if(conterMes<=1)
         {
         JOptionPane.showMessageDialog(null, "Ejemplo Mes: dd/mm/yyyy");
         txt_mes.requestFocus();
         contador++;
         }
         if(conterAño<=3)
         {
         JOptionPane.showMessageDialog(null, "Ejemplo Año: dd/mm/yyyy");
         txt_year.requestFocus();
         contador++;
         }
         
        
        // validamos qiue no encuentren campos en blanco
        if(codiContrato.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar Código del Contrato");
         txt_codigoContrato.requestFocus();
         contador++;
        }
        if(dniEmple.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta completar DNI");
         txt_dni.requestFocus();
         contador++;
        }
        if(yearCont.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar año");
         txt_year.requestFocus();
         contador++;
        }
        if(mesCont.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar mes");
         txt_mes.requestFocus();
         contador++;
        }
        if(diaCont.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar dia");
         txt_dia1.requestFocus();
         contador++;
        }
        if(hrIngreso.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar hora de ingreso");
         txt_hora_ingreso.requestFocus();
         contador++;
        }
        if(hrSalida.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar hora de salida");
         txt_hora_salida.requestFocus();
         contador++;
        }
        if(sueldo.equals("Seleccione"))
        {
         JOptionPane.showMessageDialog(null, "Falta agregar sueldo");
         txt_sueldo.requestFocus();
         contador++;
        }
        if(diaDesca.equals("Seleccione día"))
        {
         JOptionPane.showMessageDialog(null, "Falta seleccionar un dia de descanso");
         contador++;
        }
        
        // si todos los campos se llenaron
      if(contador==0)
      {  // pregusntar si se desea guar la actualizacion
        int mensaje=JOptionPane.showConfirmDialog(null,"Guardar Cambios  [S/N]:",null,JOptionPane.YES_NO_OPTION);
        if(mensaje==JOptionPane.YES_OPTION)
        {
        try {// actualizar datos en la bse de datos
            Connection cn=Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement("update tabla_contratos set hr_Ingreso=?, hr_Salida=?, "
                    + "Dia_descanso=?, sueldo=? where CodigoContrato='"+codiContrato+"'");
            pst.setString(1,hrIngreso );
            pst.setString(2,hrSalida);
            pst.setString(3,diaDesca);
            pst.setString(4,sueldo);
            pst.executeUpdate();
            cn.close();
            JOptionPane.showMessageDialog(null,"Actualización exitosa");
            
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

    private void txt_sueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sueldoKeyTyped
       // ingresar solo numeros
        char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{
            
        }
    }//GEN-LAST:event_txt_sueldoKeyTyped

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
  char c =evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();{
            
        }
    }//GEN-LAST:event_txt_dniKeyTyped

    private void txt_codigoContratoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoContratoKeyTyped
      // ingresar maximo 6 caracteres
        if(txt_codigoContrato.getText().length()>=9){
           evt.consume(); //no permitir ingresar mas letras
            Toolkit.getDefaultToolkit().beep();// enviar un sonido indicando que no se permite
       }
   
        
    }//GEN-LAST:event_txt_codigoContratoKeyTyped

    private void txt_hora_ingresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hora_ingresoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_ingresoKeyTyped

    private void txt_yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_yearKeyTyped

    }//GEN-LAST:event_txt_yearKeyTyped

    private void txt_dia1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dia1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dia1KeyTyped

    private void txt_mesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mesKeyTyped

    private void txt_hora_salidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hora_salidaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_salidaKeyTyped


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
            java.util.logging.Logger.getLogger(ListaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaContratos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_DiaDescanso;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JButton jButton_productoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_fondo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableContratos;
    private javax.swing.JTextField txt_codBuscarUser;
    private javax.swing.JTextField txt_codigoContrato;
    private javax.swing.JTextField txt_dia1;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_hora_ingreso;
    private javax.swing.JTextField txt_hora_salida;
    private javax.swing.JTextField txt_mes;
    private javax.swing.JTextField txt_sueldo;
    private javax.swing.JTextField txt_year;
    // End of variables declaration//GEN-END:variables


 

 //****METODO PARA Limpar ****
 public void LimpiarCampos(){
    txt_codigoContrato.setText("");
    txt_sueldo.setText("");
    txt_dni.setText("");
    txt_year.setText("");
    txt_hora_ingreso.setText("");
    cmb_DiaDescanso.setSelectedIndex(0);
    txt_dia1.setText("");
    txt_mes.setText("");
    txt_hora_salida.setText("");
}
 
 //******** METODO PARA RELLENAR TABLA ********
 public void agregarDatosTabla(){
    //GestionCeldas MensajeroGestionCeldas= new GestionCeldas();

    try {
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select CodigoContrato , Dni_user , Fecha_contrato,"
                    + " hr_Ingreso,hr_Salida,Dia_descanso,sueldo from tabla_contratos");
            ResultSet resul1=pst1.executeQuery();
            // AGREGAR ENCABEZADOS A LA TABLA
            jTableContratos = new JTable(model);
            jScrollPane2.setViewportView(jTableContratos);
            model.addColumn("CodigoContrato");
            model.addColumn("Dni_user");
            model.addColumn("Fecha_contrato");
            model.addColumn("hr_Ingreso");
            model.addColumn("hr_Salida");
            model.addColumn("Dia_descanso");
            model.addColumn("sueldo");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTableContratos.getColumnCount());i++)
            {
                jTableContratos.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTableContratos.getColumnCount());i++)
            {
                jTableContratos.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            /*  ////AGREGAR COLOR A celas con la clases gectionCelda
               for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroGestionCeldas);
            }*/
             jTableContratos.getColumnModel().getColumn(0).setPreferredWidth(60);//dimensionar columna 0
             jTableContratos.getColumnModel().getColumn(1).setPreferredWidth(100);//dimensionar columna 0
             jTableContratos.getColumnModel().getColumn(2).setPreferredWidth(200);//dimensionar columna 0
             jTableContratos.getColumnModel().getColumn(3).setPreferredWidth(70);//dimensionar columna 0
             jTableContratos.getColumnModel().getColumn(4).setPreferredWidth(60);//dimensionar columna 0
             jTableContratos.getColumnModel().getColumn(5).setMaxWidth(60);//dimensionar columna 0
          
             jTableContratos.setRowHeight(18);
 
            //AGREGAR LOS VALORES DE LA BD A LA TABLA
            while (resul1.next()) {
                Object[] fila= new Object[7];
                for(int i=0;i<7;i++){
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
     ListaContratos mensajero= new ListaContratos();
     mensajero.setVisible(true);
 }
 
 //*************** metodo buscador de productos ******************
 public void BuscardorDeContratos(String codigoContrato){
     jButton_Eliminar.setEnabled(true);
     jButton_actualizar.setEnabled(true);
 try {
         Connection cn= Conexion.Conectar();
         PreparedStatement pst= cn.prepareStatement("select CodigoContrato , Dni_user , Fecha_contrato,"
                    + " hr_Ingreso,hr_Salida,Dia_descanso,sueldo from tabla_contratos where CodigoContrato ='"+codigoContrato+"'");
         ResultSet resul=pst.executeQuery(); 
         if(resul.next()){
           txt_codigoContrato.setText(resul.getString("CodigoContrato"));
           txt_dni.setText(resul.getString("Dni_user"));
           txt_hora_ingreso.setText(resul.getString("hr_Ingreso"));
           txt_hora_salida.setText(resul.getString("hr_Salida"));
           txt_sueldo.setText(resul.getString("sueldo"));
           String SubDia, SubMes, SubYear, fechaContenedor;
           fechaContenedor=resul.getString("Fecha_contrato");
           SubDia= fechaContenedor.substring(0,2 );
           SubMes= fechaContenedor.substring(3,5 );
           SubYear= fechaContenedor.substring(6,10);
           txt_dia1.setText(SubDia);
           txt_mes.setText(SubMes);
           txt_year.setText(SubYear);
           
          
           
           String cargo=resul.getString("Dia_descanso");
           if(cargo.equals("Lunes")){
               cmb_DiaDescanso.setSelectedIndex(1);
           }
           if(cargo.equals("Martes")){
               cmb_DiaDescanso.setSelectedIndex(2);
           }
             if(cargo.equals("Miercoles")){
               cmb_DiaDescanso.setSelectedIndex(3);
           }
           if(cargo.equals("Jueves")){
               cmb_DiaDescanso.setSelectedIndex(4);
           }
                      if(cargo.equals("Viernes")){
               cmb_DiaDescanso.setSelectedIndex(5);
           }
           if(cargo.equals("Sabado")){
               cmb_DiaDescanso.setSelectedIndex(6);
           }
                      if(cargo.equals("Domingo")){
               cmb_DiaDescanso.setSelectedIndex(7);
           }
           
           
           
          cn.close();
          }else{
              JOptionPane.showMessageDialog(null, "contrato ("+codigoContrato+") no encontrado","ERROR!!!", JOptionPane.WARNING_MESSAGE);
              txt_codBuscarUser.requestFocus();
              
         }
        }catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al buscar el Contrato, contacte al administrador");
            System.err.println("error al buscar Contrato de la tabla: "+e);
     }
 }
 

 
}
