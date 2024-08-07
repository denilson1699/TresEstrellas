
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

public class Ventana_Administrador extends javax.swing.JFrame {

    public static String Nombre,Apellidos,Cargo,DNI,H_Ingreso,FechaDeIngreso,estado;

    public Ventana_Administrador() {
        initComponents();
         setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// no haga nada al precionar el boton de cierre
        this.setExtendedState(MAXIMIZED_BOTH);
       // setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//impide que finalize el programa al cerrar esta interfas
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
        jDesktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenu_Gestiones = new javax.swing.JMenu();
        jRadioButtonMenuItem_USUARIOS = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem_PRODUCTOS = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem_PROVEEDORES = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1_ClIENTESMASIVOS = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem_CLIENTESRUC = new javax.swing.JCheckBoxMenuItem();
        jMenu_Ajustes = new javax.swing.JMenu();
        menu_reporteAsistenciasTodas = new javax.swing.JMenuItem();
        jMenu_Contratos = new javax.swing.JMenuItem();
        Menu_ventas = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        Menu_compras = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Menu_pagos = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        Menu_estatus = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        Menu_reportes = new javax.swing.JMenu();

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

        jDesktop.setBackground(new java.awt.Color(217, 233, 249));

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1227, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jMenu.setBackground(new java.awt.Color(255, 0, 0));
        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N

        jMenu_Gestiones.setText("Gestion");

        jRadioButtonMenuItem_USUARIOS.setSelected(true);
        jRadioButtonMenuItem_USUARIOS.setText("Usuarios");
        jRadioButtonMenuItem_USUARIOS.setBorder(null);
        jRadioButtonMenuItem_USUARIOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuarios.png"))); // NOI18N
        jRadioButtonMenuItem_USUARIOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMenuItem_USUARIOSMouseClicked(evt);
            }
        });
        jRadioButtonMenuItem_USUARIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem_USUARIOSActionPerformed(evt);
            }
        });
        jMenu_Gestiones.add(jRadioButtonMenuItem_USUARIOS);

        jRadioButtonMenuItem_PRODUCTOS.setSelected(true);
        jRadioButtonMenuItem_PRODUCTOS.setText("Productos");
        jRadioButtonMenuItem_PRODUCTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto.png"))); // NOI18N
        jRadioButtonMenuItem_PRODUCTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem_PRODUCTOSActionPerformed(evt);
            }
        });
        jMenu_Gestiones.add(jRadioButtonMenuItem_PRODUCTOS);

        jRadioButtonMenuItem_PROVEEDORES.setSelected(true);
        jRadioButtonMenuItem_PROVEEDORES.setText("Proveedores");
        jRadioButtonMenuItem_PROVEEDORES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ticket.png"))); // NOI18N
        jRadioButtonMenuItem_PROVEEDORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem_PROVEEDORESActionPerformed(evt);
            }
        });
        jMenu_Gestiones.add(jRadioButtonMenuItem_PROVEEDORES);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente.png"))); // NOI18N
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

        jMenu_Ajustes.setBackground(new java.awt.Color(204, 204, 255));
        jMenu_Ajustes.setText("Asistencias");
        jMenu_Ajustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_AjustesActionPerformed(evt);
            }
        });

        menu_reporteAsistenciasTodas.setText("Reporte de Asistencias");
        menu_reporteAsistenciasTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_reporteAsistenciasTodasActionPerformed(evt);
            }
        });
        jMenu_Ajustes.add(menu_reporteAsistenciasTodas);

        jMenu.add(jMenu_Ajustes);

        jMenu_Contratos.setText("Contratos");
        jMenu_Contratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_ContratosActionPerformed(evt);
            }
        });
        jMenu.add(jMenu_Contratos);

        jMenuBar1.add(jMenu);

        Menu_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ticket.png"))); // NOI18N
        Menu_ventas.setText("Ventas");
        Menu_ventas.setToolTipText("Realizar Ventas");
        Menu_ventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu_ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_ventasMouseClicked(evt);
            }
        });
        Menu_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ventasActionPerformed(evt);
            }
        });
        jMenuBar1.add(Menu_ventas);

        jMenu5.setForeground(new java.awt.Color(153, 153, 153));
        jMenu5.setText("-");
        jMenuBar1.add(jMenu5);

        Menu_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.png"))); // NOI18N
        Menu_compras.setText("Compras");
        Menu_compras.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Menu_compras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu_compras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_comprasMouseClicked(evt);
            }
        });
        jMenuBar1.add(Menu_compras);

        jMenu4.setForeground(new java.awt.Color(153, 153, 153));
        jMenu4.setText("-");
        jMenuBar1.add(jMenu4);

        Menu_pagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calcular.png"))); // NOI18N
        Menu_pagos.setText("Pagos");
        Menu_pagos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu_pagos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Menu_pagos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu_pagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_pagosMouseClicked(evt);
            }
        });
        jMenuBar1.add(Menu_pagos);

        jMenu3.setForeground(new java.awt.Color(153, 153, 153));
        jMenu3.setText("-");
        jMenuBar1.add(jMenu3);

        Menu_estatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ayuda.png"))); // NOI18N
        Menu_estatus.setText("Estatus");
        Menu_estatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu_estatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu_estatus.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Menu_estatus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu_estatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_estatusMouseClicked(evt);
            }
        });
        Menu_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_estatusActionPerformed(evt);
            }
        });
        jMenuBar1.add(Menu_estatus);

        jMenu2.setForeground(new java.awt.Color(153, 153, 153));
        jMenu2.setText("-");
        jMenuBar1.add(jMenu2);

        Menu_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/opcreport.png"))); // NOI18N
        Menu_reportes.setText("Reportes");
        Menu_reportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu_reportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu_reportes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Menu_reportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Menu_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_reportesMouseClicked(evt);
            }
        });
        Menu_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_reportesActionPerformed(evt);
            }
        });
        jMenuBar1.add(Menu_reportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_BotonesPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktop)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel_BotonesPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktop)
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

    private void jRadioButtonMenuItem_USUARIOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem_USUARIOSActionPerformed
        ListaUsuarios listUsuarios= new ListaUsuarios();
        listUsuarios.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem_USUARIOSActionPerformed

    private void jRadioButtonMenuItem_PROVEEDORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem_PROVEEDORESActionPerformed
        ListaProveedores listProveedores= new ListaProveedores();
        listProveedores.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem_PROVEEDORESActionPerformed

    private void jRadioButtonMenuItem_USUARIOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem_USUARIOSMouseClicked
       jRadioButtonMenuItem_USUARIOS.setBackground(Color.red);
    }//GEN-LAST:event_jRadioButtonMenuItem_USUARIOSMouseClicked

    private void jButton_RegistrarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarAsistenciaActionPerformed
       AsistenciaEmpleados asitenciaEmpl= new AsistenciaEmpleados();
       jDesktop.add(asitenciaEmpl);
       asitenciaEmpl.setVisible(true);
    }//GEN-LAST:event_jButton_RegistrarAsistenciaActionPerformed

    private void jMenu_ContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_ContratosActionPerformed
        ListaContratos listaContratos= new ListaContratos();
        listaContratos.setVisible(true);
    }//GEN-LAST:event_jMenu_ContratosActionPerformed

    private void jCheckBoxMenuItem1_ClIENTESMASIVOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1_ClIENTESMASIVOSActionPerformed
             ListaClientes listaClientesDNI= new ListaClientes();
         listaClientesDNI.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem1_ClIENTESMASIVOSActionPerformed

    private void jCheckBoxMenuItem_CLIENTESRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_CLIENTESRUCActionPerformed
               ListaClientesRuc listaCliuentesRUC= new ListaClientesRuc();
       listaCliuentesRUC.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem_CLIENTESRUCActionPerformed

    private void Menu_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ventasActionPerformed
      Elegir_BoletaFactura elegirFacturaBoleta= new Elegir_BoletaFactura();
      jDesktop.add(elegirFacturaBoleta);
       elegirFacturaBoleta.setVisible(true);
                    
    }//GEN-LAST:event_Menu_ventasActionPerformed

    private void Menu_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_estatusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Menu_estatusActionPerformed

    private void jMenu_AjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_AjustesActionPerformed

    }//GEN-LAST:event_jMenu_AjustesActionPerformed

    private void Menu_estatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_estatusMouseClicked
        // TODO add your handling code here:
        ReporteStatus reporteStatus= new ReporteStatus();
        jDesktop.add(reporteStatus);
        reporteStatus.setVisible(true);
       
        

     
    }//GEN-LAST:event_Menu_estatusMouseClicked

    private void Menu_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_reportesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Menu_reportesActionPerformed

    private void Menu_reportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_reportesMouseClicked
        // TODO add your handling code here:
        ReportesPedidos reportedeReportes= new ReportesPedidos();
        jDesktop.add(reportedeReportes);
        reportedeReportes.setVisible(true);

    }//GEN-LAST:event_Menu_reportesMouseClicked

    private void Menu_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_ventasMouseClicked
        // TODO add your handling code here:
               Elegir_BoletaFactura elegirFacturaBoleta= new Elegir_BoletaFactura();
      jDesktop.add(elegirFacturaBoleta);
       elegirFacturaBoleta.setVisible(true);
    }//GEN-LAST:event_Menu_ventasMouseClicked

    private void Menu_comprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_comprasMouseClicked
        // TODO add your handling code here:
        ReporteCompras listaCompras= new ReporteCompras();
        jDesktop.add(listaCompras);
        listaCompras.setVisible(true);
    }//GEN-LAST:event_Menu_comprasMouseClicked

    private void Menu_pagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_pagosMouseClicked
        Remuneraciones planilla= new Remuneraciones();
        jDesktop.add(planilla);
        planilla.setVisible(true);
    }//GEN-LAST:event_Menu_pagosMouseClicked

    private void menu_reporteAsistenciasTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_reporteAsistenciasTodasActionPerformed
        // TODO add your handling code here:
     ListaAsistencias listaAsistencias = new ListaAsistencias();
listaAsistencias.setVisible(true);
    }//GEN-LAST:event_menu_reporteAsistenciasTodasActionPerformed

    /**
     * @param args the command line arguments
     */
   

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu_compras;
    private javax.swing.JMenu Menu_estatus;
    private javax.swing.JMenu Menu_pagos;
    private javax.swing.JMenu Menu_reportes;
    private javax.swing.JMenu Menu_ventas;
    private javax.swing.JButton jButton_CerrarSesion;
    private javax.swing.JButton jButton_RegistrarAsistencia;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1_ClIENTESMASIVOS;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_CLIENTESRUC;
    public static javax.swing.JDesktopPane jDesktop;
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_Ajustes;
    private javax.swing.JMenuItem jMenu_Contratos;
    private javax.swing.JMenu jMenu_Gestiones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_BotonesPrincipal;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem_PRODUCTOS;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem_PROVEEDORES;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem_USUARIOS;
    private javax.swing.JMenuItem menu_reporteAsistenciasTodas;
    // End of variables declaration//GEN-END:variables



}
