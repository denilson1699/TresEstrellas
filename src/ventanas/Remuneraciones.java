
package ventanas;
import clases.CeldasTablaDatos;
import clases.CeldasTablaResultados;
import clases.ColorCeldaResultado;
import clases.GestionEncabezadoTabla;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// grfico circular

import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
// JFREECHART
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class Remuneraciones extends javax.swing.JInternalFrame {
  DefaultTableModel model1= new DefaultTableModel();
    DefaultTableModel model2= new DefaultTableModel();
    
    CeldasTablaDatos MensajeroFilaDatos= new CeldasTablaDatos();
    CeldasTablaResultados MensajeroFilaResultados= new CeldasTablaResultados();
    GestionEncabezadoTabla MensajeroEcabezadoTabla= new GestionEncabezadoTabla(); 
    ColorCeldaResultado MensajeroColorFila= new ColorCeldaResultado();
  
  
    Double  Sueldo, Vacaciones, Hrs_extra, Comisiones;
    String Tipo_AFP;
    boolean bandera=false;
    String nombre="Denilson"; 
    int Fila;//Login.Nombre;
      Double TOTALSUELDOS=0.0, TOTALVACACIONES=0.0,TOTALCOMICIONES=0.0;

      String fecha="";

    public Remuneraciones() {
        initComponents();
             boton_totales.setEnabled(false);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// no haga nada al precionar el boton de cierre
        getContentPane().setBackground(new Color(153,153,153));
           // metodo calendario para la fecha y hora de ingreso
        Calendar calendario = Calendar.getInstance();
        String mes = Integer.toString(calendario.get(Calendar.MONTH) + 1);
        String año= Integer.toString(calendario.get(Calendar.YEAR));
      
        switch(mes){
            case "1":
                fecha="Ene-"+año; break;
            case "2":
                fecha="Feb-"+año; break;
            case "3":
                fecha="Mar-"+año; break;
            case "4":
                fecha="Abr-"+año; break;
            case "5":
                fecha="May-"+año; break;
            case "6":
                fecha="Jun-"+año; break;
            case "7":
                fecha="Jul-"+año; break;
            case "8":
                fecha="Ago-"+año; break;
            case "9":
                fecha="Set-"+año; break;
            case "10":
                fecha="Oct-"+año; break;
            case "11":
                fecha="Nov-"+año; break;
            case "12":
                fecha="Dic-"+año; break;
        }
          
      // TABLA DE RESULTADOS DE REMUNERACIONES
      model2.addColumn("DNI");
      model2.addColumn(label_total.getText());
      model2.addColumn(label_5tacategoria.getText());
      model2.addColumn(label_afp_onp.getText());
      model2.addColumn(label_totalDes.getText());
      model2.addColumn(label_NetoPagar.getText());
      model2.addColumn(label_essalud.getText());
      
     //AGREGAR COLOR A LAS FILAS
      for(int i=0;i<(Tabla_Resultado.getColumnCount());i++)
       {Tabla_Resultado.getColumnModel().getColumn(i).setCellRenderer(MensajeroFilaResultados);}
      //AGREGAR COLOR A ENCABEZADO DE LA TABLA
      for(int i=0;i<(Tabla_Resultado.getColumnCount());i++)
        {
        Tabla_Resultado.getColumnModel().getColumn(i).setHeaderRenderer(MensajeroEcabezadoTabla);
        }
      
    //****************[ AGREGAMOS DATOS A LA TABLA ]******************************
      model1.addColumn("Mes");
        model1.addColumn("Nombre");
        model1.addColumn("DNI");
        model1.addColumn("Cargo");
        model1.addColumn("Sueldo");
        model1.addColumn("Vacaciones");
        model1.addColumn("Hrs extra");
        model1.addColumn("Comisiones");
        model1.addColumn("Tipo AFP");
        model1.addColumn("AFP");
        model1.addColumn("ONP");
     
       model1.addRow(new Object[]{fecha,"Angelica Mercedes Callirgos Pagares"   ,"09235128","Contadora"             ,20000.00    ,0.00   ,10000.00   ,0.00    ,"-"          ,"-"    ,"Si"});
       model1.addRow(new Object[]{fecha,"Fernando Jesús López de Castilla Elías","40235457","Gerente de ventas"     ,15000.00    ,0.00   ,0.00   ,0.00    ,"habitat"    ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Sandra Lucía Carrillo Massa"           ,"40230893","Gerente General"       ,7500.00    ,0.00   ,0.00   ,0.00    ,"habitat"     ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Luis Emilio Vasquez Tolentino"         ,"45239737","Seguridad"             ,6500.80     ,0.00   ,254.20 ,0.00  ,"Profuturo"    ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Ledy Agustina Jaramillo Castillo"      ,"47774073","Asistente contable"    ,3500.00    ,0.00   ,0.00   ,0.00   ,"habitat"      ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Wendy Fiorella Fiol Bulnes"            ,"10325532","Directora de Consulting Food & Beverage"   ,1000.00    ,0.00   ,0.00,141.40,"Profuturo","Si","-"});
       model1.addRow(new Object[]{fecha,"Fernando José Rodriguez Larrain Luna"  ,"10810917","Gerente comercial"     ,300.00    ,0.00   ,0.00   ,177.23 ,"Profuturo"     ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Mikela Acosta Becerra"                 ,"77340488","Consulting coordinator",1750.00     ,1000.00   ,0.00   ,622.20 ,"Prima"       ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Stephanie Karoline Mejía Spillmann"    ,"36738400","Brand Manager"         ,1750.00    ,0.00   ,0.00   ,622.20 ,"habitat"      ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Kimberly Gabriela Pella Murgueytio"    ,"35335353","Coodinadora Financiero",1350.00    ,0.00   ,0.00   ,2133.68,"Prima"        ,"Si"   ,"-"});
       model1.addRow(new Object[]{fecha,"Tania Marisol Toribio Olivares"        ,"32941632","Coodinadora comercial" ,1000.00    ,0.00   ,0.00   ,170.00 ,"Integra"      ,"Si"   ,"-"});
  
       Tabla_Datos.setModel(model1);
       
       Tabla_Datos.getColumnModel().getColumn(0).setMaxWidth(100);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(1).setPreferredWidth(300);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(2).setPreferredWidth(100);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(3).setPreferredWidth(200);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(4).setMaxWidth(80);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(5).setMaxWidth(80);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(6).setMaxWidth(80);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(7).setMaxWidth(80);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(8).setMaxWidth(100);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(9).setMaxWidth(50);//dimensionar columna 0
       Tabla_Datos.getColumnModel().getColumn(10).setMaxWidth(50);//dimensionar columna 0
      bandera = true;
      repaint();
       //AGREGAR COLOR A LAS FILAS
       for(int i=0;i<(Tabla_Datos.getColumnCount());i++)
       {Tabla_Datos.getColumnModel().getColumn(i).setCellRenderer(MensajeroFilaDatos);}
       for(int y=0;y<(Tabla_Datos.getColumnCount());y++)
      {
      Tabla_Datos.getColumnModel().getColumn(y).setHeaderRenderer(MensajeroEcabezadoTabla);
      }
       //crreamos metodo para el EVENTO de la TABLA
        Tabla_Datos.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e){
            Fila=Tabla_Datos.rowAtPoint(e.getPoint());
            Sueldo= Double.parseDouble(Tabla_Datos.getValueAt(Fila,4).toString());
            Vacaciones= Double.parseDouble(Tabla_Datos.getValueAt(Fila,5).toString());
            Hrs_extra= Double.parseDouble(Tabla_Datos.getValueAt(Fila,6).toString());
            Comisiones= Double.parseDouble(Tabla_Datos.getValueAt(Fila,7).toString());
            Tipo_AFP= (Tabla_Datos.getValueAt(Fila,8).toString());
            CalculoRemineraciones(Sueldo, Vacaciones, Hrs_extra, Comisiones, Tipo_AFP);
               
         bandera = true;
         repaint();
           }  
        });
        
 
    }
 // CREAMOS METODO PARA EL CALUCLOS DE REMUNERACIONES
    public void CalculoRemineraciones(Double sueldo,Double vacaciones,Double horasExtra,Double comisiones, String tipoAFP){
        // CALCULAMOS EL TOTAL   
           Double Total= sueldo+vacaciones+horasExtra+comisiones;
           txt_total.setText(String.valueOf(Total));
            
       //CALCULAMOS LA QUINTA CATEGORIA
          DecimalFormat decimal= new DecimalFormat("#.00");// 00 = 2 decimales
          Double quinta=(Total*14)-(7*4300);
          String MontoString;
           Double montoQuinta = 0.0;
           if(quinta<=0 ){
                txt_5taCategoria.setText(String.valueOf("0"));
           }else if(quinta<21500 ){
                montoQuinta=(quinta*0.08)/12;
                MontoString=decimal.format(montoQuinta);
                txt_5taCategoria.setText(MontoString);
           }
           else if(quinta>21500 && quinta<=86000){
                montoQuinta=((21500*0.08)+(quinta-21500)*0.14)/12;
                MontoString=decimal.format(montoQuinta);
                txt_5taCategoria.setText(MontoString);
           }
           else if(quinta>86000 && quinta<=150500){
               montoQuinta=((21500*0.08)+((86000-21500)*0.14)+((quinta-86000)*0.17))/12;
                MontoString=decimal.format(montoQuinta);
                txt_5taCategoria.setText(MontoString);
           }
           else if(quinta>150500 && quinta<=193500){
               montoQuinta=((21500*0.08)+((86000-21500)*0.14)+((150500-86000)*0.17)+((quinta-150500)*0.20))/12;
                MontoString=decimal.format(montoQuinta);
                txt_5taCategoria.setText(MontoString);
           }
           else if(quinta>193500){
               montoQuinta=((21500*0.08)+((86000-21500)*0.14)+((150500-86000)*0.17)+((193500-150500)*0.20)+((quinta-193500)*0.30))/12;
                MontoString=decimal.format(montoQuinta);
                txt_5taCategoria.setText(MontoString);
           }
           
          // CALCULAMOS EN MONTO DE AFP /ONP
           String AFP_ONPString;
           Double AFP_ONP=0.00;
           String t_AFP=tipoAFP;
           if(t_AFP.equalsIgnoreCase("habitat")){
               label_afp_onp.setText("AFP");
               if(Total<9788){
               AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0038);
                AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
               }else{
               AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0038;
               AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
           }    
           }
           else if(t_AFP.equalsIgnoreCase("Profuturo")){
                  label_afp_onp.setText("AFP");
               if(Total<9788){
               AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0067);
                   AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
          }else{
               AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0067;
                   AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
            }
           }
           else if(t_AFP.equalsIgnoreCase("Prima")){
                  label_afp_onp.setText("AFP");
               if(Total<9788){
               AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0018);
                    AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
           }else{
               AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0018;
                  AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
            }
          }
           else  if(t_AFP.equalsIgnoreCase("Integra")){
               label_afp_onp.setText("AFP");
               if(Total<9788){
               AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0);
                 AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
             }else{
               AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0;
                  AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
            }
           }
           else if(t_AFP.equalsIgnoreCase("-")){
               label_afp_onp.setText("ONP"); 
               AFP_ONP=Total*0.13;
               AFP_ONPString=decimal.format(AFP_ONP);
               txt_AFP_ONP.setText(AFP_ONPString);
           }
           
           // CALCULAMOS EL DESCUENTO TOTAL
           Double DescuentoTotal=AFP_ONP+montoQuinta;
           String DescuentoTotalString;
           DescuentoTotalString=decimal.format(DescuentoTotal);
          txt_TotalDescuento.setText(DescuentoTotalString);
           
           // CALCULAMOS EL NETO A PAGAR
           Double NetoPagar=Total-DescuentoTotal;
           String NetoPagarString;
           NetoPagarString=decimal.format(NetoPagar);
           txt_netoPagar.setText(NetoPagarString);
           
           // CALCULAMOS EL MONTO PARA ESSALUD
           Double MontoEsSalud=Total*0.09;
           String esSaludString;
           esSaludString=decimal.format(MontoEsSalud);
           txt_esSauld.setText(esSaludString);
    }
    
//----------------- Imagen del icono del programa ----------------
    
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPanelPrincipal = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Datos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_total = new javax.swing.JTextField();
        label_total = new javax.swing.JLabel();
        label_5tacategoria = new javax.swing.JLabel();
        txt_5taCategoria = new javax.swing.JTextField();
        label_totalDes = new javax.swing.JLabel();
        txt_TotalDescuento = new javax.swing.JTextField();
        label_NetoPagar = new javax.swing.JLabel();
        txt_netoPagar = new javax.swing.JTextField();
        label_essalud = new javax.swing.JLabel();
        txt_esSauld = new javax.swing.JTextField();
        label_afp_onp = new javax.swing.JLabel();
        txt_AFP_ONP = new javax.swing.JTextField();
        Boton_Estatus = new javax.swing.JButton();
        ScrollPane_Grafico = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        boton_eliminar = new javax.swing.JButton();
        boton_agregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Resultado = new javax.swing.JTable();
        boton_resultados = new javax.swing.JButton();
        boton_totales = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        Menu_COLOR_MORADO1 = new javax.swing.JRadioButtonMenuItem();
        Menu_COLOR_ROJO1 = new javax.swing.JRadioButtonMenuItem();
        Menu_COLOR_NEGRO1 = new javax.swing.JRadioButtonMenuItem();
        Menu_nuevoCalculo1 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Planilla De pagos");
        setToolTipText("");
        setAutoscrolls(true);

        ScrollPanelPrincipal.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Tabla_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mes", "Nombre Apellidos", "DNI", "Sueldo", "Vacaiones", "Comisiones", "Total", "Tipo AFP", "AFP", "ONP"
            }
        ));
        Tabla_Datos.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane1.setViewportView(Tabla_Datos);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        txt_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        label_total.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        label_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_total.setText("TOTAL");

        label_5tacategoria.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        label_5tacategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_5tacategoria.setText("5TA CATEGORIA");

        txt_5taCategoria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_5taCategoria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        label_totalDes.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        label_totalDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_totalDes.setText("TOTAL DESCUENTO");

        txt_TotalDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_TotalDescuento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        label_NetoPagar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        label_NetoPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_NetoPagar.setText("NETO PAGAR");

        txt_netoPagar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_netoPagar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        label_essalud.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        label_essalud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_essalud.setText("ESSALUD");

        txt_esSauld.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_esSauld.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        label_afp_onp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        label_afp_onp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_afp_onp.setText("AFP/ONP");

        txt_AFP_ONP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_AFP_ONP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_5taCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_AFP_ONP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_total, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_5tacategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_afp_onp, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_totalDes, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txt_TotalDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_netoPagar)
                    .addComponent(label_NetoPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_esSauld)
                    .addComponent(label_essalud, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_essalud)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(txt_esSauld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_total)
                            .addGap(4, 4, 4)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(label_5tacategoria)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_5taCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_totalDes)
                                .addComponent(label_NetoPagar)
                                .addComponent(label_afp_onp))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_TotalDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AFP_ONP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(txt_netoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        Boton_Estatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Estatus.setForeground(new java.awt.Color(0, 51, 51));
        Boton_Estatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estatus1.png"))); // NOI18N
        Boton_Estatus.setText("Estatus");
        Boton_Estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EstatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        ScrollPane_Grafico.setViewportView(Panel);

        boton_eliminar.setBackground(new java.awt.Color(102, 102, 102));
        boton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eliminar.png"))); // NOI18N
        boton_eliminar.setBorder(null);
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        boton_agregar.setBackground(new java.awt.Color(102, 102, 102));
        boton_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Agregar.png"))); // NOI18N
        boton_agregar.setBorder(null);
        boton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregarActionPerformed(evt);
            }
        });

        Tabla_Resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Total", "5ta Categoria", "AFP/ONP", "Total Descuento", "Neto", "ESSALUD"
            }
        ));
        jScrollPane2.setViewportView(Tabla_Resultado);

        boton_resultados.setText("Resultados");
        boton_resultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_resultadosActionPerformed(evt);
            }
        });

        boton_totales.setText("Totales");
        boton_totales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_totalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(boton_resultados))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(ScrollPane_Grafico))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boton_totales, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(240, 240, 240)))
                .addGap(232, 232, 232))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boton_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(boton_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(Boton_Estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(boton_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_totales, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Boton_Estatus)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ScrollPane_Grafico, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))))
        );

        ScrollPanelPrincipal.setViewportView(jPanel2);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes.png"))); // NOI18N
        jMenu7.setText("Ajustes");

        jMenu5.setText("Opciones");

        jMenu8.setText("Color de Fondo");

        Menu_COLOR_MORADO1.setSelected(true);
        Menu_COLOR_MORADO1.setText("Morado");
        Menu_COLOR_MORADO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_COLOR_MORADO1ActionPerformed(evt);
            }
        });
        jMenu8.add(Menu_COLOR_MORADO1);

        Menu_COLOR_ROJO1.setSelected(true);
        Menu_COLOR_ROJO1.setText("Rojo");
        Menu_COLOR_ROJO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_COLOR_ROJO1ActionPerformed(evt);
            }
        });
        jMenu8.add(Menu_COLOR_ROJO1);

        Menu_COLOR_NEGRO1.setSelected(true);
        Menu_COLOR_NEGRO1.setText("Negro");
        Menu_COLOR_NEGRO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_COLOR_NEGRO1ActionPerformed(evt);
            }
        });
        jMenu8.add(Menu_COLOR_NEGRO1);

        jMenu5.add(jMenu8);

        Menu_nuevoCalculo1.setText("New Calculo");
        Menu_nuevoCalculo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_nuevoCalculo1ActionPerformed(evt);
            }
        });
        jMenu5.add(Menu_nuevoCalculo1);

        jMenu7.add(jMenu5);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_EstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EstatusActionPerformed
        // suma de sueldos

        int ultimaFila=Tabla_Resultado.getRowCount()-1;
        // SACAMOS LA SUMATORIA TOTAL DE SUELDOS, COMICIONES Y VACACIONES

        Double sueldos= Double.parseDouble(model2.getValueAt(ultimaFila,1).toString());
        Double Categ= Double.parseDouble(model2.getValueAt(ultimaFila,2).toString());
        Double afp_onp= Double.parseDouble(model2.getValueAt(ultimaFila,3).toString());
        Double descu= Double.parseDouble(model2.getValueAt(ultimaFila,4).toString());
        Double neto= Double.parseDouble(model2.getValueAt(ultimaFila,5).toString());
        Double essalud= Double.parseDouble(model2.getValueAt(ultimaFila,6).toString());

        DefaultCategoryDataset ds= new DefaultCategoryDataset();
        ds.addValue(sueldos, "Sueldos",String.valueOf(sueldos));
        ds.addValue(Categ, "5ta Catg",String.valueOf(Categ));
        ds.addValue(afp_onp, "AFP/ONP",String.valueOf(afp_onp));
        ds.addValue(descu, "Descuentos",String.valueOf(descu));
        ds.addValue(neto, "Neto",String.valueOf(neto));
        ds.addValue(essalud, "EsSalud",String.valueOf(essalud));

        JFreeChart jf= ChartFactory.createBarChart3D("GRÁFICO DE TOTALES","Totales","Montos",ds, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel= new ChartPanel(jf);
        Panel.setLayout(new java.awt.BorderLayout());
        Panel.add(panel);
        Panel.validate();

    }//GEN-LAST:event_Boton_EstatusActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        // TODO add your handling code here:
        int EliminarFila=Tabla_Datos.getSelectedRow();// CAPTURA LA FILA SELECCIONADA

        if(EliminarFila>=0)
        { model1.removeRow(EliminarFila);  }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila",null, JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void boton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregarActionPerformed
        // TODO add your handling code here:
        model1.addRow(new Object[]{fecha,"","","" ,0.0,0.0,0.0,0.0 ,"","",""});

        Tabla_Datos.setModel(model1);

    }//GEN-LAST:event_boton_agregarActionPerformed

    private void boton_resultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_resultadosActionPerformed
        // TODO add your handling code here:
        DecimalFormat decimal= new DecimalFormat("#.00");// 00 = 2 decimales
        for(int i=0;i<Tabla_Datos.getRowCount();i++)
        {
            Double sueldo,vacaciones,horasExtra,comisiones; String tipoAFP;String Dni;
            Dni= (Tabla_Datos.getValueAt(i,2).toString());
            sueldo= Double.parseDouble(Tabla_Datos.getValueAt(i,4).toString());
            vacaciones= Double.parseDouble(Tabla_Datos.getValueAt(i,5).toString());
            horasExtra= Double.parseDouble(Tabla_Datos.getValueAt(i,6).toString());
            comisiones= Double.parseDouble(Tabla_Datos.getValueAt(i,7).toString());
            tipoAFP= (Tabla_Datos.getValueAt(i,8).toString());

            // CALCULAMOS EL TOTAL
            Double Total= sueldo+vacaciones+horasExtra+comisiones;

            //CALCULAMOS LA QUINTA CATEGORIA
            Double quinta=(Total*14)-(7*4300);
            String MontoString;
            Double montoQuinta = 0.0;
            if(quinta<=0 ){
                montoQuinta=0.0;
            }else if(quinta<21500 ){
                montoQuinta=(quinta*0.08)/12;
            }
            else if(quinta>21500 && quinta<=86000){
                montoQuinta=((21500*0.08)+(quinta-21500)*0.14)/12;
            }
            else if(quinta>86000 && quinta<=150500){
                montoQuinta=((21500*0.08)+((86000-21500)*0.14)+((quinta-86000)*0.17))/12;
            }
            else if(quinta>150500 && quinta<=193500){
                montoQuinta=((21500*0.08)+((86000-21500)*0.14)+((150500-86000)*0.17)+((quinta-150500)*0.20))/12;
            }
            else if(quinta>193500){
                montoQuinta=((21500*0.08)+((86000-21500)*0.14)+((150500-86000)*0.17)+((193500-150500)*0.20)+((quinta-193500)*0.30))/12;
            }

            // CALCULAMOS EN MONTO DE AFP /ONP
            String AFP_ONPString;
            Double AFP_ONP=0.00;
            String t_AFP=tipoAFP;
            if(t_AFP.equalsIgnoreCase("habitat")){
                if(Total<9788){
                    AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0038);
                }else{
                    AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0038;
                }
            }
            else if(t_AFP.equalsIgnoreCase("Profuturo")){
                if(Total<9788){
                    AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0067);
                }else{
                    AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0067;
                }
            }
            else if(t_AFP.equalsIgnoreCase("Prima")){
                if(Total<9788){
                    AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0018);
                }else{
                    AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0018;
                }
            }
            else  if(t_AFP.equalsIgnoreCase("Integra")){
                if(Total<9788){
                    AFP_ONP=(Total*0.0135)+(Total*0.10)+(Total*0.0);
                }else{
                    AFP_ONP=((9788*0.0135)+Total*0.10)+Total*0.0;
                }
            }
            else if(t_AFP.equalsIgnoreCase("-")){
                AFP_ONP=Total*0.13;
            }

            // CALCULAMOS EL DESCUENTO TOTAL
            Double DescuentoTotal=AFP_ONP+montoQuinta;

            // CALCULAMOS EL NETO A PAGAR
            Double NetoPagar=Total-DescuentoTotal;

            // CALCULAMOS EL MONTO PARA ESSALUD
            Double MontoEsSalud=Total*0.09;

            String t_T=decimal.format(Total);
            String m_p=decimal.format(montoQuinta);
            String afp_onp=decimal.format(AFP_ONP);
            String t_d=decimal.format(DescuentoTotal);
            String n_P=decimal.format(NetoPagar);
            String m_es=decimal.format(MontoEsSalud);

            model2.addRow(new Object[]{Dni,t_T,m_p,afp_onp,t_d,n_P,m_es});
            Tabla_Resultado.setModel(model2);

        }
        for(int y=0;y<(Tabla_Resultado.getColumnCount());y++)
        {
            Tabla_Resultado.getColumnModel().getColumn(y).setHeaderRenderer(MensajeroEcabezadoTabla);
        }
        for(int i=0;i<(Tabla_Resultado.getColumnCount());i++)
        {Tabla_Resultado.getColumnModel().getColumn(i).setCellRenderer(MensajeroFilaResultados);}
        boton_totales.setEnabled(true);

    }//GEN-LAST:event_boton_resultadosActionPerformed

    private void boton_totalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_totalesActionPerformed
        // TODO add your handling code here:

        DecimalFormat decimal= new DecimalFormat("#.00");// 00 = 2 decimales

        Double  sueldosT=0.0,QuintaT=0.0,AFP_ONP_T=0.0,DescuentoT=0.0,NetoPagar_T=0.0,MontoEsSalud_T=0.0;

        for(int i=0;i<Tabla_Resultado.getRowCount();i++)
        {
            Double uno= Double.parseDouble(Tabla_Resultado.getValueAt(i,1).toString());
            sueldosT+=uno;

            Double dos= Double.parseDouble(Tabla_Resultado.getValueAt(i,2).toString());
            QuintaT+=dos;

            Double tres= Double.parseDouble(Tabla_Resultado.getValueAt(i,3).toString());
            AFP_ONP_T+=tres;

            Double cuatro= Double.parseDouble(Tabla_Resultado.getValueAt(i,4).toString());
            DescuentoT+=cuatro;

            Double cinco= Double.parseDouble(Tabla_Resultado.getValueAt(i,5).toString());
            NetoPagar_T+=cinco;

            Double seis= Double.parseDouble(Tabla_Resultado.getValueAt(i,6).toString());
            MontoEsSalud_T+=seis;
        }
        String t1=decimal.format(sueldosT);
        String t2=decimal.format(QuintaT);
        String t3=decimal.format(AFP_ONP_T);
        String t4=decimal.format(DescuentoT);
        String t5=decimal.format(NetoPagar_T);
        String t6=decimal.format(MontoEsSalud_T);

        model2.addRow(new Object[]{"","","","","",""});
        model2.addRow(new Object[]{"TOTALES:",t1,t2,t3,t4,t5,t6});
        Tabla_Resultado.setModel(model2);

        for(int y=0;y<(Tabla_Resultado.getColumnCount());y++)
        {
            Tabla_Resultado.getColumnModel().getColumn(y).setHeaderRenderer(MensajeroEcabezadoTabla);
        }

    }//GEN-LAST:event_boton_totalesActionPerformed

    private void Menu_COLOR_MORADO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_COLOR_MORADO1ActionPerformed
        getContentPane().setBackground(new Color(51,0,51));
        jPanel2.setBackground(new Color(51,0,51));
        // menubar.setBackground(new Color(51,0,51));
    }//GEN-LAST:event_Menu_COLOR_MORADO1ActionPerformed

    private void Menu_COLOR_ROJO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_COLOR_ROJO1ActionPerformed
        // TODO add your handling code here
        getContentPane().setBackground(new Color(255,0,0));
        jPanel2.setBackground(new Color(255,0,0));

    }//GEN-LAST:event_Menu_COLOR_ROJO1ActionPerformed

    private void Menu_COLOR_NEGRO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_COLOR_NEGRO1ActionPerformed
        // TODO add your handling code here:
        getContentPane().setBackground(new Color(0,0,0));
        jPanel2.setBackground(new Color(0,0,0));
    }//GEN-LAST:event_Menu_COLOR_NEGRO1ActionPerformed

    private void Menu_nuevoCalculo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_nuevoCalculo1ActionPerformed
        // eliminar todos los datos de una tabla
        int EliminarTodaFila1=Tabla_Datos.getRowCount();
        for(int i=EliminarTodaFila1-1;i>=0;i--){
            model1.removeRow(i);
        }
        int EliminarTodaFila2=Tabla_Resultado.getRowCount();
        for(int i=EliminarTodaFila2-1;i>=0;i--){
            model2.removeRow(i);
        }
        /*  if(boton_agregar.isSelected()==true){
            boton_resultados.setEnabled(true);
        }
        if(boton_resultados.isSelected()==true){
            boton_totales.setEnabled(true);
        }
        if(boton_totales.isSelected()==true){
            Boton_Estatus.setEnabled(true);
        }
        boton_resultados.setEnabled(true);
        boton_totales.setEnabled(false);
        Boton_Estatus.setEnabled(false);
        */
    }//GEN-LAST:event_Menu_nuevoCalculo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Estatus;
    private javax.swing.JRadioButtonMenuItem Menu_COLOR_MORADO1;
    private javax.swing.JRadioButtonMenuItem Menu_COLOR_NEGRO1;
    private javax.swing.JRadioButtonMenuItem Menu_COLOR_ROJO1;
    private javax.swing.JMenuItem Menu_nuevoCalculo1;
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane ScrollPane_Grafico;
    private javax.swing.JScrollPane ScrollPanelPrincipal;
    private javax.swing.JTable Tabla_Datos;
    private javax.swing.JTable Tabla_Resultado;
    private javax.swing.JButton boton_agregar;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_resultados;
    private javax.swing.JButton boton_totales;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_5tacategoria;
    private javax.swing.JLabel label_NetoPagar;
    private javax.swing.JLabel label_afp_onp;
    private javax.swing.JLabel label_essalud;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_totalDes;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField txt_5taCategoria;
    private javax.swing.JTextField txt_AFP_ONP;
    private javax.swing.JTextField txt_TotalDescuento;
    private javax.swing.JTextField txt_esSauld;
    private javax.swing.JTextField txt_netoPagar;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

    public void paint(Graphics g){ // formazamente debe ser paint
     super.paint(g); // 
     if(bandera==true){
         try {
         
         Double TotalSueldos=0.0, TotalVacaiones=0.0,TotalHrsExtra=0.0, TotalComiciones=0.0;
      for(int i=0;i<Tabla_Datos.getRowCount();i++)
      {
      Double uno= Double.parseDouble(Tabla_Datos.getValueAt(i,4).toString());
      TotalSueldos+=uno; 
      
      Double dos= Double.parseDouble(Tabla_Datos.getValueAt(i,5).toString());
      TotalVacaiones+=dos; 
      
      Double tres= Double.parseDouble(Tabla_Datos.getValueAt(i,7).toString());
      TotalComiciones+=tres; 
      Double cuatro= Double.parseDouble(Tabla_Datos.getValueAt(i,6).toString());
      TotalHrsExtra+=cuatro; 
      }
         Double total_totales= TotalSueldos+TotalVacaiones+TotalComiciones+TotalHrsExtra;
     
        Double grados_sueldo=TotalSueldos*360/total_totales;
        Double grados_vacaciones=TotalVacaiones*360/total_totales;
        Double grados_comicones=TotalComiciones*360/total_totales;
        Double grados_hrsextra=TotalHrsExtra*360/total_totales;
       
        DecimalFormat decimal= new DecimalFormat("#");// 00 = 2 decimales
 
        String StringGSuel =decimal.format(grados_sueldo);
        String StringGvac =decimal.format(grados_vacaciones); 
        String StringGcomi =decimal.format(grados_comicones); 
        String StringGhrsExtra =decimal.format(grados_hrsextra); 
        
        int GraSuel    =Integer.parseInt(StringGSuel);
        int GraVacac  =Integer.parseInt(StringGvac);
        int GraComic   =Integer.parseInt(StringGcomi);
        int GraHrsextra =Integer.parseInt(StringGhrsExtra);
        
     // ****COLOR naranja¨¨¨¨¨¨¨¨¨¨
        g.setColor(new Color(255,200,80));
        g.fillArc(870, 320, 150,150,0,GraSuel); // hacer la forma
        g.fillRect(1050, 340, 10, 10);// hacer el cuadrado de leyenda
        g.drawString("Total Sueldos",1065, 350); // el nombre para la leyenda
        g.setColor(new Color(255,255,255));
        g.drawString(TotalSueldos+"s/",1170 ,350);
        
     // ****COLOR verde¨¨¨¨¨¨¨¨¨¨
        g.setColor(new Color(10,130,30));
        g.fillArc(870, 320, 150,150,GraSuel,GraVacac); // hacer la forma
        g.fillRect(1050, 370, 10, 10);// hacer el cuadrado de leyenda
        g.drawString("Total Vacaciones", 1065, 380); // el nombre para la leyenda
        g.setColor(new Color(255,255,255));
        g.drawString(TotalVacaiones+"s/",1170,380);
        
     // ****COLOR rojo¨¨¨¨¨¨¨¨¨¨
        g.setColor(new Color(223,20,55));
        g.fillArc(870, 320, 150,150,(GraSuel+GraVacac),GraComic); // hacer la forma
        g.fillRect(1050, 400, 10, 10);// hacer el cuadrado de leyenda
        g.drawString("Total Comisiones", 1065, 410); // el nombre para la leyenda   
        g.setColor(new Color(255,255,255));
        g.drawString(TotalComiciones+"s/",1170,410);
        
       //
        g.setColor(new Color(23,230,235));
        g.fillArc(870, 320, 150,150,(GraSuel+GraVacac+ GraComic),GraHrsextra); // hacer la forma
        g.fillRect(1050, 430, 10, 10);// hacer el cuadrado de leyenda
        g.drawString("Total Hrs Extra", 1065, 440); // el nombre para la leyenda   
        g.setColor(new Color(255,255,255));
        g.drawString(TotalHrsExtra+"s/",1170,440);
        
        
       } catch (Exception e) {
             System.out.println("erro:"+e);  
       }  
     }    
        
   }
}
