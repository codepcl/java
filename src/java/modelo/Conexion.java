/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author PCHINOL
 */
public class Conexion {
    private static Connection cnx = null;
   public  Connection obtener() throws Exception, ClassNotFoundException {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            //Colocar el usuario y contraseña de la base de datos
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_login", "root", "");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
   
 
}
