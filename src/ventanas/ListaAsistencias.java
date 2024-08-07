
package ventanas;

import clases.ColorCeldaTabla;
import clases.Conexion;
import clases.GestionEncabezadoTabla;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ListaAsistencias extends javax.swing.JFrame {
    DefaultTableModel model= new DefaultTableModel();// conexion con la tabla y generar clic
    ColorCeldaTabla MensajeroColorFila= new ColorCeldaTabla();
     //metodo para el color del encabezado de tabla
     GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla();
 
    public ListaAsistencias() {
        initComponents();
        
        
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255,255,204));
        try {
            Connection cn1= Conexion.Conectar();
            PreparedStatement pst1= cn1.prepareStatement("select Dni_user, CodigoContrato,"
                    + " F_asistencia, Hr_ingreso,Hr_salida,Hrs_trabajadas from tabla_asistencias");
            ResultSet resul1=pst1.executeQuery();
            // AGREGAR ENCABEZADOS A LA TABLA
            jTableAsistencias = new JTable(model);
            jScrollPane2.setViewportView(jTableAsistencias);
            model.addColumn("DNI Empleado");
            model.addColumn("Codigo Contrato");
            model.addColumn("F.Ingreso");
            model.addColumn("Hr.Ingreso");
            model.addColumn("Hr.Salida");
            model.addColumn("Hr.Trabajadas");
            
            //AGREGAR COLOR A LAS FILAS
            for(int i=0;i<(jTableAsistencias.getColumnCount());i++)
            {
                jTableAsistencias.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);
            }
            
             //AGREGAR COLOR A ENCABEZADO DE LA TABLA
             for(int i=0;i<(jTableAsistencias.getColumnCount());i++)
            {
                jTableAsistencias.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
            }
            /*  ////AGREGAR COLOR A celas con la clases gectionCelda
               for(int i=0;i<(jTableProductos.getColumnCount())-1;i++)
            {
                jTableProductos.getColumnModel().getColumn(i).setCellRenderer(MensajeroGestionCeldas);
            }*/
            
             jTableAsistencias.getColumnModel().getColumn(0).setPreferredWidth(40);//dimensionar columna 0
             jTableAsistencias.getColumnModel().getColumn(1).setPreferredWidth(60);//dimensionar columna 0
             jTableAsistencias.getColumnModel().getColumn(2).setPreferredWidth(40);//dimensionar columna 0
             jTableAsistencias.getColumnModel().getColumn(3).setPreferredWidth(30);//dimensionar columna 0
             jTableAsistencias.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
             jTableAsistencias.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
          
             jTableAsistencias.setRowHeight(18);
 
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcmb_tipoFiltro = new javax.swing.JComboBox<>();
        txt_filtroCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAsistencias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcmb_tipoFiltro.setBackground(new java.awt.Color(255, 153, 0));
        jcmb_tipoFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcmb_tipoFiltro.setForeground(new java.awt.Color(255, 255, 255));
        jcmb_tipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dni", "Fecha Ingreso" }));
        jcmb_tipoFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcmb_tipoFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_filtroCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txt_filtroCodigo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_filtroCodigo.setForeground(new java.awt.Color(204, 0, 51));
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Reporte de Asistencias");

        jTableAsistencias.setBackground(new java.awt.Color(0, 255, 0));
        jTableAsistencias.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jTableAsistencias.setForeground(new java.awt.Color(255, 255, 51));
        jTableAsistencias.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableAsistencias.setDragEnabled(true);
        jTableAsistencias.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jTableAsistencias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcmb_tipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(txt_filtroCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcmb_tipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_filtroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_filtroCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroCodigoActionPerformed

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
            String[] titulos={"DNI Empleado", "Codigo Contrato", "F.Ingreso", "Hr.Ingreso", "Hr.Salida","Hr.Trabajadas"};
            model=new DefaultTableModel(null,titulos);

            // FUNCIONES DEPENDIENDO DEL TIPO DE FILTRO ELEGIDO
            switch (filtroSelec)
            {//*********** FILTRO PARA dni empleados DE PRODUCTO ************
                case"Dni":
                Connection cn= Conexion.Conectar();
                PreparedStatement pst= cn.prepareStatement("select *from tabla_asistencias where Dni_user like"+'"'+texto+'"');
                String[] fila= new String[6];
                ResultSet resul=pst.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                jTableAsistencias = new JTable(model);
                jScrollPane2.setViewportView(jTableAsistencias);
                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(jTableAsistencias.getColumnCount());i++)
                {jTableAsistencias.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(jTableAsistencias.getColumnCount());i++)
                {jTableAsistencias.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                jTableAsistencias.getColumnModel().getColumn(0).setPreferredWidth(40);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(1).setPreferredWidth(60);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(2).setPreferredWidth(40);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(3).setPreferredWidth(30);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
                jTableAsistencias.setRowHeight(18);// DIMENCION DE ALTURA DEL ENCABEZADO

                //recuperar valores de BD A LA TABLA
                while(resul.next())
                {
                    fila[0]=resul.getString("Dni_user");
                    fila[1]=resul.getString("CodigoContrato");
                    fila[2]=resul.getString("F_asistencia");
                    fila[3]=resul.getString("Hr_ingreso");
                    fila[4]=resul.getString("Hr_salida");
                    fila[5]=resul.getString("Hrs_trabajadas");
                    model.addRow(fila);
                }
                cn.close();

                break;

                case"Fecha Ingreso":
                Connection cn2= Conexion.Conectar();
                PreparedStatement pst2= cn2.prepareStatement("select *from tabla_asistencias where F_asistencia like"+'"'+texto+'"');
                String[] fila2= new String[6];
                ResultSet resul2=pst2.executeQuery();
                // AGREGAR ENCABEZADOS A LA TABLA
                jTableAsistencias = new JTable(model);
                jScrollPane2.setViewportView(jTableAsistencias);
                //AGREGAR COLOR A LAS FILAS
                for(int i=0;i<(jTableAsistencias.getColumnCount());i++)
                {jTableAsistencias.getColumnModel().getColumn(i).setCellRenderer(MensajeroColorFila);}
                //AGREGAR COLOR A ENCABEZADO DE LA TABLA
                for(int i=0;i<(jTableAsistencias.getColumnCount());i++)
                {jTableAsistencias.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);}

                jTableAsistencias.getColumnModel().getColumn(0).setPreferredWidth(40);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(1).setPreferredWidth(60);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(2).setPreferredWidth(40);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(3).setPreferredWidth(30);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(4).setPreferredWidth(30);//dimensionar columna 0
                jTableAsistencias.getColumnModel().getColumn(5).setPreferredWidth(30);//dimensionar columna 0
                jTableAsistencias.setRowHeight(18);// DIMENCION DE ALTURA DEL ENCABEZADO

                //recuperar valores de BD A LA TABLA
                while(resul2.next())
                {
                    fila2[0]=resul2.getString("Dni_user");
                    fila2[1]=resul2.getString("CodigoContrato");
                    fila2[2]=resul2.getString("F_asistencia");
                    fila2[3]=resul2.getString("Hr_ingreso");
                    fila2[4]=resul2.getString("Hr_salida");
                    fila2[5]=resul2.getString("Hrs_trabajadas");
                    model.addRow(fila2);
                }
                cn2.close();

                break;
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al filtrar","",JOptionPane.ERROR_MESSAGE);
            System.err.println("error al filtar la busqueda: "+e);
        }
    }//GEN-LAST:event_txt_filtroCodigoKeyReleased

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
            java.util.logging.Logger.getLogger(ListaAsistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAsistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAsistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAsistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAsistencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAsistencias;
    private javax.swing.JComboBox<String> jcmb_tipoFiltro;
    private javax.swing.JTextField txt_filtroCodigo;
    // End of variables declaration//GEN-END:variables
}
