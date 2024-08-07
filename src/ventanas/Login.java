package ventanas;

import clases.AgregarImagen;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import clases.Conexion;
import clases.ConfirmarCerrar;
import java.sql.*;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Login extends javax.swing.JFrame {
    
    public boolean mostrar = true;
    public static String pass, user, Nombre, Apellidos, Cargo, DNI, H_Ingreso, FechaDeIngreso, Email, estado;

    
    // icono de interfas
    public Login() {
        
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// no haga nada al precionar el boton de cierre
      
        requestFocusInWindow();
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setTitle("Iniciar Sesión");
        getContentPane().setBackground(new Color(255,255,255));

        // metodo calendario para la fecha y hora de ingreso
        Calendar calendario = Calendar.getInstance();
        FechaDeIngreso = Integer.toString(calendario.get(Calendar.DATE)) + "/"
                + Integer.toString(calendario.get(Calendar.MONTH) + 1) + "/"
                + Integer.toString(calendario.get(Calendar.YEAR));
        
        H_Ingreso = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) + ":"
                + Integer.toString(calendario.get(Calendar.MINUTE));
        

        // textos 
        txt_passVisible.setVisible(false);
        txt_passOculto.setVisible(true);

        // botones
        jBoton_ver1.setVisible(true);
        jBoton_ocultar.setVisible(true);

        // imagenes para botones
        AgregarImagen imagen = new AgregarImagen();
        jBoton_ver1.setIcon(imagen.agregarImagenBoton("/images/mostrarContra.png", jBoton_ver1));
        jBoton_ocultar.setIcon(imagen.agregarImagenBoton("/images/ocultarContra.png", jBoton_ocultar));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ImagenUser = new javax.swing.JLabel();
        txt_passOculto = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_ingresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBoton_ocultar = new javax.swing.JButton();
        jBoton_ver1 = new javax.swing.JButton();
        txt_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_passVisible = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImagenUser.setBackground(new java.awt.Color(153, 153, 153));
        ImagenUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imagenlogeo.png"))); // NOI18N
        getContentPane().add(ImagenUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 200, 190));

        txt_passOculto.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        txt_passOculto.setForeground(new java.awt.Color(0, 153, 102));
        txt_passOculto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passOculto.setBorder(null);
        txt_passOculto.setCaretColor(new java.awt.Color(255, 153, 0));
        getContentPane().add(txt_passOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 377, 280, 50));

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario:");

        jButton_ingresar.setBackground(new java.awt.Color(204, 0, 51));
        jButton_ingresar.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ingresar.setText("Ingresar");
        jButton_ingresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_ingresar.setBorderPainted(false);
        jButton_ingresar.setFocusPainted(false);
        jButton_ingresar.setFocusable(false);
        jButton_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ingresarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jBoton_ocultar.setBackground(new java.awt.Color(204, 204, 204));
        jBoton_ocultar.setBorder(null);
        jBoton_ocultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton_ocultarActionPerformed(evt);
            }
        });

        jBoton_ver1.setBackground(new java.awt.Color(204, 204, 204));
        jBoton_ver1.setBorder(null);
        jBoton_ver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton_ver1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBoton_ocultar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBoton_ver1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBoton_ocultar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBoton_ver1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        txt_user.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txt_user.setForeground(new java.awt.Color(0, 204, 204));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(null);
        txt_user.setCaretColor(new java.awt.Color(255, 153, 0));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_user, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton_ingresar, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 390, 330));

        txt_passVisible.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txt_passVisible.setForeground(new java.awt.Color(0, 204, 204));
        txt_passVisible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passVisible.setBorder(null);
        getContentPane().add(txt_passVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 379, 280, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBoton_ver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoton_ver1ActionPerformed

        // mostrar contraseña
        if (mostrar) {
            mostrarContraseña();
        } // ocultar la contraseña
        else {
            ocultarContraseña();
        }
        
        jBoton_ocultar.setVisible(true);
        jBoton_ver1.setVisible(false);
    }//GEN-LAST:event_jBoton_ver1ActionPerformed

    private void jBoton_ocultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoton_ocultarActionPerformed

        // mostrar contraseña
        if (mostrar) {
            mostrarContraseña();
        } // ocultar la contraseña
        else {
            ocultarContraseña();
        }
        
        jBoton_ocultar.setVisible(false);
        jBoton_ver1.setVisible(true);
    }//GEN-LAST:event_jBoton_ocultarActionPerformed

    private void jButton_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ingresarActionPerformed
        
        int validador = 0;
        
        user = txt_user.getText().trim();
        pass = txt_passOculto.getText().trim();
        
        if (user.equalsIgnoreCase("")) {
            txt_user.setBackground(Color.red);
            validador++;
        }
        if (pass.equalsIgnoreCase("")) {
            txt_passOculto.setBackground(Color.red);
            validador++;
        }
        
        if (validador == 0) {
            
            try {
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement("select Dni_user, Nombre_user, Apellidos_user, Cargo_user,Correo_user,Estado_user from tabla_user where Dni_user ='" + user + "' and Pass_user='" + pass + "'");
                ResultSet result = pst.executeQuery();
                if (result.next()) {
                    Nombre = result.getString("Nombre_user");
                    Apellidos = result.getString("Apellidos_user");
                    Cargo = result.getString("Cargo_user");
                    DNI = result.getString("Dni_user");
                    Email = result.getString("Correo_user");
                    estado = result.getString("Estado_user");
                    
                    if (!estado.equalsIgnoreCase("ACTIVO")) {
                        JOptionPane.showMessageDialog(null, "USUARIO INACTIVO, contacte al administrador");
                    }
                    
                    if (Cargo.equals("ADMINISTRADOR") && estado.equals("ACTIVO")) {
                        dispose();
                        Ventana_Administrador ventana_administrador = new Ventana_Administrador();
                        ventana_administrador.setVisible(true);
                        
                    } else if (Cargo.equals("VENDEDOR") && estado.equals("ACTIVO")) {
                        dispose();
                        Ventana_Vendedor ventana_vendedor = new Ventana_Vendedor();
                        ventana_vendedor.setVisible(true);
                    }cn.close();
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta ", "error", JOptionPane.ERROR_MESSAGE);                    
                    txt_passOculto.setText("");
                    txt_passVisible.setText("");
                    txt_user.setText("");
                    txt_user.requestFocus();
                }
            } catch (Exception e) {
                System.err.println("error conexion base datos -login- :" + e);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos", "ERROR", JOptionPane.WARNING_MESSAGE);
            //jButton_ingresar.setEnabled(false);
            txt_passOculto.setBackground(Color.WHITE);
            txt_user.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jButton_ingresarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // AL QUERER CERRAR LA APLICACION
        ConfirmarCerrar confirmarCerrar= new ConfirmarCerrar();
        String mensaje="Cerrar Aplicación";
        confirmarCerrar.Cerrar(mensaje);
    }//GEN-LAST:event_formWindowClosing
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenUser;
    private javax.swing.JButton jBoton_ocultar;
    private javax.swing.JButton jBoton_ver1;
    private javax.swing.JButton jButton_ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txt_passOculto;
    private javax.swing.JTextField txt_passVisible;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

    // METODO PARA MOSTRAR CONTRASEÑA****
    public void mostrarContraseña() {
        txt_passVisible.setVisible(true);
        txt_passOculto.setVisible(false);
        txt_passVisible.setText(txt_passOculto.getText().trim());
        txt_passVisible.requestFocus();
        mostrar = false;        
    }

    // METODO PARA OCULTAR CONTRASEÑA
    public void ocultarContraseña() {
        txt_passVisible.setVisible(false);
        txt_passOculto.setVisible(true);
        txt_passOculto.setText(txt_passVisible.getText().trim());
        txt_passOculto.requestFocus();
        mostrar = true;
    }

    /* METODO PARA UN PLACERHOLDER
    
public void txtplaceHolder(){
    PlaceHolder holder;
    holder= new PlaceHolder(txt_user,"ingrese usuario");
    holder=new PlaceHolder(txt_passOculto,"ingrese contraseña");
}*/
    
    // metodo para cerrar y cancelar

}
