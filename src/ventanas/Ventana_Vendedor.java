
package ventanas;

import clases.AgregarImagen;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.AsistenciaEmpleados.DNI;
import static ventanas.AsistenciaEmpleados.F_Ingreso;
import static ventanas.Login.FechaDeIngreso;
import static ventanas.Login.H_Ingreso;

public class Ventana_Vendedor extends javax.swing.JFrame {

    public static String Nombre,Apellidos,Cargo,DNI,H_Ingreso,FechaDeIngreso,estado;

    public Ventana_Vendedor() {
        initComponents();
           setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// no haga nada al precionar el boton de cierre
     this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//impide que finalize el programa al cerrar esta interfas
        getContentPane().setBackground(new Color(153,204,255));
    // Recuperar datos de el login
        Nombre=Login.Nombre;
        Apellidos=Login.Apellidos;
        Cargo=Login.Cargo;
        DNI=Login.DNI;
        FechaDeIngreso=Login.FechaDeIngreso;
        H_Ingreso=Login.H_Ingreso;
        estado=Login.estado;
        jLabel_FechaAsistencia.setText(FechaDeIngreso);
        

    // enviamos los datos a los label
    jLabel_Nombre.setText(Nombre.toLowerCase()+" "+Apellidos.toLowerCase());
    jLabel_Cargo.setText(Cargo.toLowerCase()); ;
    jLabel_Dni.setText(DNI.toLowerCase());
    jLabel_Estado.setText(estado.toLowerCase());
    }       
    
       // icon de intervas
    @Override
    public Image getIconImage(){
        Image retValue=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/iconVentanas.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_BotonesPrincipal = new javax.swing.JPanel();
        jButton_CerrarSesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel_Estado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Dni = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_RegistrarAsistencia = new javax.swing.JButton();
        jLabel_FechaAsistencia = new javax.swing.JLabel();
        jLabel_Cargo = new javax.swing.JLabel();
        jDesktopVendedor = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenu_Gestiones = new javax.swing.JMenu();
        jRadioButtonMenuItem_PRODUCTOS = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1_ClIENTESMASIVOS = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem_CLIENTESRUC = new javax.swing.JCheckBoxMenuItem();
        Menu_Boletas = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        Menu_Facturas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setIconImage(getIconImage());

        jPanel_BotonesPrincipal.setBackground(new java.awt.Color(153, 204, 255));

        jButton_CerrarSesion.setBackground(new java.awt.Color(0, 153, 153));
        jButton_CerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_CerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salir.png"))); // NOI18N
        jButton_CerrarSesion.setText("Cerrar Sesión");
        jButton_CerrarSesion.setBorder(null);
        jButton_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CerrarSesionActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Estado:");

        jLabel_Estado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Estado.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_Estado.setText("asf");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Nombre:");

        jLabel_Nombre.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_Nombre.setText("asf");

        jLabel_Dni.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_Dni.setText("asf");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 89, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImgenUserLogin.png"))); // NOI18N

        jButton_RegistrarAsistencia.setBackground(new java.awt.Color(0, 153, 153));
        jButton_RegistrarAsistencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_RegistrarAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_asistencia.png"))); // NOI18N
        jButton_RegistrarAsistencia.setText("Asistencia");
        jButton_RegistrarAsistencia.setBorder(null);
        jButton_RegistrarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarAsistenciaActionPerformed(evt);
            }
        });

        jLabel_FechaAsistencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_FechaAsistencia.setForeground(new java.awt.Color(0, 153, 153));
        jLabel_FechaAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_FechaAsistencia.setText("00//00/00");

        jLabel_Cargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Cargo.setForeground(new java.awt.Color(0, 153, 153));
        jLabel_Cargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Cargo.setText("asf");

        javax.swing.GroupLayout jPanel_BotonesPrincipalLayout = new javax.swing.GroupLayout(jPanel_BotonesPrincipal);
        jPanel_BotonesPrincipal.setLayout(jPanel_BotonesPrincipalLayout);
        jPanel_BotonesPrincipalLayout.setHorizontalGroup(
            jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BotonesPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
                .addGroup(jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_RegistrarAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jLabel_Cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_CerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jLabel_FechaAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_BotonesPrincipalLayout.setVerticalGroup(
            jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BotonesPrincipalLayout.createSequentialGroup()
                .addGroup(jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_BotonesPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_BotonesPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_RegistrarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_BotonesPrincipalLayout.createSequentialGroup()
                                        .addComponent(jButton_CerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_BotonesPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_FechaAsistencia))))))
                .addContainerGap())
        );

        jDesktopVendedor.setBackground(new java.awt.Color(217, 233, 249));

        javax.swing.GroupLayout jDesktopVendedorLayout = new javax.swing.GroupLayout(jDesktopVendedor);
        jDesktopVendedor.setLayout(jDesktopVendedorLayout);
        jDesktopVendedorLayout.setHorizontalGroup(
            jDesktopVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1227, Short.MAX_VALUE)
        );
        jDesktopVendedorLayout.setVerticalGroup(
            jDesktopVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jMenu.setBackground(new java.awt.Color(255, 0, 0));
        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes.png"))); // NOI18N
        jMenu.setText("Gestiones");
        jMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenu_Gestiones.setText("Gestion");

        jRadioButtonMenuItem_PRODUCTOS.setSelected(true);
        jRadioButtonMenuItem_PRODUCTOS.setText("Productos");
        jRadioButtonMenuItem_PRODUCTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto.png"))); // NOI18N
        jRadioButtonMenuItem_PRODUCTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem_PRODUCTOSActionPerformed(evt);
            }
        });
        jMenu_Gestiones.add(jRadioButtonMenuItem_PRODUCTOS);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuarios.png"))); // NOI18N
        jMenu1.setText("Clientes");

        jCheckBoxMenuItem1_ClIENTESMASIVOS.setSelected(true);
        jCheckBoxMenuItem1_ClIENTESMASIVOS.setText("Clientes Masivos");
        jCheckBoxMenuItem1_ClIENTESMASIVOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1_ClIENTESMASIVOSActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1_ClIENTESMASIVOS);

        jCheckBoxMenuItem_CLIENTESRUC.setSelected(true);
        jCheckBoxMenuItem_CLIENTESRUC.setText("Clientes Ruc");
        jCheckBoxMenuItem_CLIENTESRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_CLIENTESRUCActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem_CLIENTESRUC);

        jMenu_Gestiones.add(jMenu1);

        jMenu.add(jMenu_Gestiones);

        jMenuBar1.add(jMenu);

        Menu_Boletas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ticket.png"))); // NOI18N
        Menu_Boletas.setText("Boletas");
        Menu_Boletas.setToolTipText("Realizar Ventas");
        Menu_Boletas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu_Boletas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu_Boletas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_BoletasMouseClicked(evt);
            }
        });
        Menu_Boletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_BoletasActionPerformed(evt);
            }
        });
        jMenuBar1.add(Menu_Boletas);

        jMenu5.setForeground(new java.awt.Color(153, 153, 153));
        jMenu5.setText("-");
        jMenuBar1.add(jMenu5);

        Menu_Facturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ticket.png"))); // NOI18N
        Menu_Facturas.setText("Facturas");
        Menu_Facturas.setToolTipText("Realizar Ventas");
        Menu_Facturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu_Facturas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu_Facturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_FacturasMouseClicked(evt);
            }
        });
        Menu_Facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_FacturasActionPerformed(evt);
            }
        });
        jMenuBar1.add(Menu_Facturas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_BotonesPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopVendedor)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel_BotonesPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopVendedor)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CerrarSesionActionPerformed
       int Hr_Salida,Hr_Ingreso = 0, horasTrabajadas;
       // hora de salida generada automatcamente 
        try {
               Connection cnx=Conexion.Conectar();
               PreparedStatement pstx= cnx.prepareStatement("select Hr_ingreso from tabla_asistencias where F_asistencia='"+FechaDeIngreso+"'");  
               ResultSet resulx=pstx.executeQuery();
               if(resulx.next()){
               Hr_Ingreso =Integer.parseInt(resulx.getString("Hr_ingreso"));
               }
        }catch (Exception e) {}
               
       Calendar calendario = Calendar.getInstance();
        Hr_Salida =calendario.get(Calendar.HOUR_OF_DAY);
        
        // horas trabajadas durante todo el dia generada automaticamente
        horasTrabajadas = (Hr_Salida - Hr_Ingreso);
        
                
        String botones []={"Cerrar","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(null, "Cerrar Sesión","Titulo",
                    0,0,null,botones,this);
        if(eleccion==JOptionPane.YES_OPTION)
        {   
           try {
               Connection cn2=Conexion.Conectar();
               PreparedStatement pst2= cn2.prepareStatement("update tabla_asistencias set Hr_salida=?, Hrs_trabajadas=? "
                       + "where F_asistencia='"+FechaDeIngreso+"'");  
               pst2.setString(1,String.valueOf(Hr_Salida));
               pst2.setString(2,String.valueOf(horasTrabajadas));
               pst2.executeUpdate();
               cn2.close();
               JOptionPane.showMessageDialog(null,"Se Registro su Hora de Salida");
              }catch (Exception e) 
              {
                  JOptionPane.showMessageDialog(null, "Error, al registrar hora de salida contacte al administrador");
                  System.out.println("error, al registrar hora de salida");
              }
        
           
         this.dispose();
         Login ventanaLongin =new Login();
         ventanaLongin.setVisible(true);
             
        }
        else if(eleccion==JOptionPane.NO_OPTION)
          {
          Toolkit.getDefaultToolkit().beep();// enviar un sonido indicando que no se permite
          }
       
    }//GEN-LAST:event_jButton_CerrarSesionActionPerformed

    private void jRadioButtonMenuItem_PRODUCTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem_PRODUCTOSActionPerformed
ListaProductos listaProducto=new ListaProductos();
listaProducto.setVisible(true);
      

        
    }//GEN-LAST:event_jRadioButtonMenuItem_PRODUCTOSActionPerformed

    private void jButton_RegistrarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarAsistenciaActionPerformed
       AsistenciaEmpleados asitenciaEmpl= new AsistenciaEmpleados();
       jDesktopVendedor.add(asitenciaEmpl);
       asitenciaEmpl.setVisible(true);
    }//GEN-LAST:event_jButton_RegistrarAsistenciaActionPerformed

    private void jCheckBoxMenuItem1_ClIENTESMASIVOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1_ClIENTESMASIVOSActionPerformed
             ListaClientes listaClientesDNI= new ListaClientes();
         listaClientesDNI.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem1_ClIENTESMASIVOSActionPerformed

    private void jCheckBoxMenuItem_CLIENTESRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_CLIENTESRUCActionPerformed
               ListaClientesRuc listaCliuentesRUC= new ListaClientesRuc();
       listaCliuentesRUC.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem_CLIENTESRUCActionPerformed

    private void Menu_BoletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_BoletasActionPerformed
      ProcesoVentasBoleta boleta= new ProcesoVentasBoleta();
      jDesktopVendedor.add(boleta);
       boleta.setVisible(true);
                    
    }//GEN-LAST:event_Menu_BoletasActionPerformed

    private void Menu_BoletasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_BoletasMouseClicked
        // TODO add your handling code here:
      ProcesoVentasBoleta boleta= new ProcesoVentasBoleta();
      jDesktopVendedor.add(boleta);
       boleta.setVisible(true);

    }//GEN-LAST:event_Menu_BoletasMouseClicked

    private void Menu_FacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_FacturasMouseClicked
        // TODO add your handling code here:
     ProcesoVentasFactura factura= new ProcesoVentasFactura();
      jDesktopVendedor.add(factura);
       factura.setVisible(true);
    }//GEN-LAST:event_Menu_FacturasMouseClicked

    private void Menu_FacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_FacturasActionPerformed
        // TODO add your handling code here:
             ProcesoVentasFactura factura= new ProcesoVentasFactura();
      jDesktopVendedor.add(factura);
       factura.setVisible(true);
    }//GEN-LAST:event_Menu_FacturasActionPerformed

    /**
     * @param args the command line arguments
     */
   

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Vendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu_Boletas;
    private javax.swing.JMenu Menu_Facturas;
    private javax.swing.JButton jButton_CerrarSesion;
    private javax.swing.JButton jButton_RegistrarAsistencia;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1_ClIENTESMASIVOS;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_CLIENTESRUC;
    public static javax.swing.JDesktopPane jDesktopVendedor;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Cargo;
    private javax.swing.JLabel jLabel_Dni;
    private javax.swing.JLabel jLabel_Estado;
    private javax.swing.JLabel jLabel_FechaAsistencia;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_Gestiones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_BotonesPrincipal;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem_PRODUCTOS;
    // End of variables declaration//GEN-END:variables



}
