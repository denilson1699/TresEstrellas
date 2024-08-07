
package ventanas;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultEditorKit;

public class RestaurarPass extends javax.swing.JFrame {

      public String nombre, apellido,dni,pass_update;
    

    public RestaurarPass() {
        initComponents();
        nombre=ListaUsuarios.nombre_update;
        apellido=ListaUsuarios.apellido_update;
        dni=ListaUsuarios.dni_update;
        pass_update=ListaUsuarios.pass_update;
        setSize(409, 260);
        setResizable(false);
        setTitle("Cambio de Password ");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        txt_nuevoPass.setText(pass_update);
        jLabel_titullo.setText(nombre+" "+apellido);
        //------------ imagend e fondo --------------------------
        ImageIcon imagenFondo= new ImageIcon("src/images/imagenFondo.jpg");
        Icon iconoFondo=new ImageIcon(imagenFondo.getImage().getScaledInstance(
        jLabel_fondo.getWidth(),jLabel_fondo.getHeight(),Image.SCALE_DEFAULT));
        jLabel_fondo.setIcon(iconoFondo);
        this.repaint();    
    }

    //-------------------- imagen de icono interfas -------------------------

         
         @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titullo = new javax.swing.JLabel();
        jLabel_nuevopass = new javax.swing.JLabel();
        txt_nuevoPass = new javax.swing.JTextField();
        jLabel_confirPass = new javax.swing.JLabel();
        txt_confirmarPass = new javax.swing.JTextField();
        jButton_restaurarPassword = new javax.swing.JButton();
        jLabel_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titullo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_titullo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titullo.setText("Cambio de Password");
        getContentPane().add(jLabel_titullo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel_nuevopass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nuevopass.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nuevopass.setText("Nuevo password:");
        getContentPane().add(jLabel_nuevopass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_nuevoPass.setBackground(new java.awt.Color(153, 153, 255));
        txt_nuevoPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nuevoPass.setForeground(new java.awt.Color(255, 255, 255));
        txt_nuevoPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nuevoPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nuevoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        jLabel_confirPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_confirPass.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_confirPass.setText("Confirmar password:");
        getContentPane().add(jLabel_confirPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_confirmarPass.setBackground(new java.awt.Color(153, 153, 255));
        txt_confirmarPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirmarPass.setForeground(new java.awt.Color(255, 255, 255));
        txt_confirmarPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_confirmarPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_confirmarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, -1));

        jButton_restaurarPassword.setBackground(new java.awt.Color(153, 153, 255));
        jButton_restaurarPassword.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_restaurarPassword.setForeground(new java.awt.Color(255, 255, 255));
        jButton_restaurarPassword.setText("Restaurar Password");
        jButton_restaurarPassword.setBorder(null);
        jButton_restaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_restaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_restaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 35));
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_restaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restaurarPasswordActionPerformed
     String nuevoPass, confirmarPass;
     nuevoPass=txt_nuevoPass.getText().trim();
     confirmarPass=txt_confirmarPass.getText().trim();
     
     if(!nuevoPass.equals("")&& !confirmarPass.equals("")){
         if (nuevoPass.equals(confirmarPass)){
             try {
                 Connection cn= Conexion.Conectar();
                 PreparedStatement pst= cn.prepareStatement(
                      "update tabla_user set Pass_user=? where Dni_user='"+dni+"'");
                 pst.setString(1,confirmarPass);
                 pst.executeUpdate();
                 cn.close();
                 txt_nuevoPass.setBackground(Color.GREEN);
                 txt_confirmarPass.setBackground(Color.GREEN);
                 JOptionPane.showMessageDialog(null,"Cambio exitoso");
                 this.dispose();// liberar recurso y cerrar interfas
                 
             } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null,"error al cambiar contraseña, contacte al Administrador");
                 System.err.println("Error al restaurar password");
             }
         } else {
             txt_confirmarPass.setBackground(Color.red);
             JOptionPane.showMessageDialog(null,"Las contrañenas no coinciden");
             txt_nuevoPass.setText("");
             txt_confirmarPass.setText("");
         }
     }else{
         txt_nuevoPass.setBackground(Color.red);
         txt_confirmarPass.setBackground(Color.red);
          JOptionPane.showMessageDialog(null,"complete todos los campos");
         }
        
    }//GEN-LAST:event_jButton_restaurarPasswordActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_restaurarPassword;
    private javax.swing.JLabel jLabel_confirPass;
    private javax.swing.JLabel jLabel_fondo;
    private javax.swing.JLabel jLabel_nuevopass;
    private javax.swing.JLabel jLabel_titullo;
    private javax.swing.JTextField txt_confirmarPass;
    private javax.swing.JTextField txt_nuevoPass;
    // End of variables declaration//GEN-END:variables

}
