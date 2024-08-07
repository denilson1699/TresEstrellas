
/*CLASE PARA LA CONCEXION CON LA BASE DE DATOS*/

package clases;
import java.sql.*;
public class Conexion {

    public static Connection Conectar(){

        try {
            Connection cn= DriverManager.getConnection ("jdbc:mysql://localhost:3306/bd_tres_estrellas","root","");
            return cn;
            
        } catch (Exception e) {
            System.out.println("error en conexion con la base de datos principal "+e);
        }
        return null;  
    }
/*
        try {
            String url="jdbc:mysql://www.infordeveloper.com:3306/denilson_bd_tres_estrellas";
            String usuario="denilson_wrdp2";	
            String pass="123456";
            Connection cn= DriverManager.getConnection (url,usuario,pass);
            return cn;
            
        } catch (Exception e) {
            System.err.println("error en conexion con la base de datos principal: "+e);
        }
        return null;  
    }
*/
        
}
