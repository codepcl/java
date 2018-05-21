/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entity.Estado;
import entity.Tipo_Usuario;
import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PCHINOL
 */
public class UsuarioDao {
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
     
    public String validar(String name, String pass){
        Usuario us = new Usuario() ;
        String Estado = "";
        try {
            Connection con = new Conexion().obtener();
            PreparedStatement pst = con.prepareStatement("SELECT `idUsuario`, DNI, Nombre, Apellido, Direccion, Telefono, Usuario, Password, tipo_usuario.`idTipo_Usuario`, tipo_usuario.`Tipo_Usuario`, tipo_usuario.`Tipo`, estado.`idEstado`, estado.`Estado` FROM usuario \n" +
"INNER JOIN tipo_usuario ON tipo_usuario.idTipo_Usuario = usuario.Tipo_Usuario \n" +
"INNER JOIN estado  ON estado.idEstado = usuario.Estado \n" +
"WHERE Usuario=? AND Password=?");
           pst.setString(1, name);
           pst.setString(2, pass);
           rs = pst.executeQuery();
          
           while(rs.next()){
           us = new Usuario(rs.getInt("idUsuario"), rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Direccion"),
                       rs.getString("Telefono"), rs.getString("Usuario"), rs.getString("Password"),                 
                       new Tipo_Usuario(rs.getInt("idTipo_Usuario"), rs.getString("Tipo_Usuario"), rs.getInt("Tipo")),
                   new Estado(rs.getInt("idEstado"), rs.getString("Estado"))
               );
           }
           Estado = us.getTipo_usuario().getTipo_Usuario();
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
        return Estado;
    }
    
    public ArrayList<Usuario> arreglo(){
        ArrayList<Usuario> Estado = new ArrayList<Usuario>();
        try {
            Connection con = new Conexion().obtener();
            PreparedStatement pst = con.prepareStatement("SELECT `idUsuario`, DNI, Nombre, Apellido, Direccion, Telefono, Usuario, Password, tipo_usuario.idTipo_Usuario, tipo_usuario.Tipo_Usuario, tipo_usuario.Tipo, estado.idEstado, estado.Estado FROM usuario \n" +
"INNER JOIN tipo_usuario ON tipo_usuario.idTipo_Usuario = usuario.Tipo_Usuario \n" +
"INNER JOIN estado  ON estado.idEstado = usuario.Estado ");
           rs = pst.executeQuery();
           while(rs.next()){
           Estado.add(new Usuario(rs.getInt("idUsuario"), rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Direccion"),
                       rs.getString("Telefono"), rs.getString("Usuario"), rs.getString("Password"),                 
                       new Tipo_Usuario(rs.getInt("idTipo_Usuario"), rs.getString("Tipo_Usuario"), rs.getInt("Tipo")),
                   new Estado(rs.getInt("idEstado"), rs.getString("Estado"))));
           }
        } catch (Exception e) {
            System.out.println("Error2 "+ e.getMessage());
        }
        return Estado;
    }
    
    public Usuario arregloUsuario(String usuario){
        Usuario Estado = null;
        try {
            Connection con = new Conexion().obtener();
            PreparedStatement pst = con.prepareStatement("SELECT `idUsuario`, DNI, Nombre, Apellido, Direccion, Telefono, Usuario, Password, tipo_usuario.idTipo_Usuario, tipo_usuario.Tipo_Usuario, tipo_usuario.Tipo, estado.idEstado, estado.Estado FROM usuario \n" +
"INNER JOIN tipo_usuario ON tipo_usuario.idTipo_Usuario = usuario.Tipo_Usuario \n" +
"INNER JOIN estado  ON estado.idEstado = usuario.Estado WHERE  usuario.Usuario = ? and  tipo_usuario.Tipo = 2 ");
            pst.setString(1, usuario);
           rs = pst.executeQuery();
           while(rs.next()){
           Estado = (new Usuario(rs.getInt("idUsuario"), rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Direccion"),
                       rs.getString("Telefono"), rs.getString("Usuario"), rs.getString("Password"),                 
                       new Tipo_Usuario(rs.getInt("idTipo_Usuario"), rs.getString("Tipo_Usuario"), rs.getInt("Tipo")),
                   new Estado(rs.getInt("idEstado"), rs.getString("Estado"))));
           }
        } catch (Exception e) {
            System.out.println("Error2 "+ e.getMessage());
        }
        return Estado;
    }
    
    public boolean existeUsuario(String usuario){
        boolean Estado = false;
        try {
            Connection con = new Conexion().obtener();
            PreparedStatement pst = con.prepareStatement("SELECT `idUsuario`, DNI, Nombre, Apellido, Direccion, Telefono, Usuario, Password, tipo_usuario.`idTipo_Usuario`, tipo_usuario.`Tipo_Usuario`, tipo_usuario.`Tipo`, estado.`idEstado`, estado.`Estado` FROM usuario \n" +
"INNER JOIN tipo_usuario ON tipo_usuario.idTipo_Usuario = usuario.Tipo_Usuario \n" +
"INNER JOIN estado  ON estado.idEstado = usuario.Estado \n" +
"WHERE Usuario=?");
           pst.setString(1, usuario);
           rs = pst.executeQuery();
           Usuario u = null ;
           while(rs.next()){
           u = new Usuario(rs.getInt("idUsuario"), rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Direccion"),
                       rs.getString("Telefono"), rs.getString("Usuario"), rs.getString("Password"),                 
                       new Tipo_Usuario(rs.getInt("idTipo_Usuario"), rs.getString("Tipo_Usuario"), rs.getInt("Tipo")),
                   new Estado(rs.getInt("idEstado"), rs.getString("Estado"))
               );
           }
           if(u.getDNI().length() > 0){
               Estado = true;
           }
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
        return Estado;
    }
    
        public boolean agregarUsuario(Usuario usuario){
        boolean Estado = false;
        try {
            Connection con = new Conexion().obtener();
            PreparedStatement ps = con.prepareStatement("CALL SP_agregarUsuario(?,?,?,?,?,?,?,?,?);");
            ps.setString(1, usuario.getDNI());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getDireccion());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getUsuario());
            ps.setString(7, usuario.getPassword());
            ps.setInt(8, 2);
            ps.setInt(9, 2);         
            if(ps.executeUpdate()==1){
                Estado = true;
            }
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
        return Estado;
    }
        
        public boolean activarUsuario(int idUsuario){
        boolean Estado = false;
        try {
            Connection con = new Conexion().obtener();
            PreparedStatement ps = con.prepareCall("UPDATE usuario SET Estado = 1 Where idUsuario=?");
            ps.setInt(1, idUsuario);
            if(ps.executeUpdate()==1){
                Estado = true;
            }
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
        return Estado;
    }
        
   public boolean desactivarUsuario(int idUsuario){
        boolean Estado = false;
        try {
            Connection con = new Conexion().obtener();
            PreparedStatement ps = con.prepareCall("UPDATE usuario SET Estado = 2 Where idUsuario=?");
            ps.setInt(1, idUsuario);
            if(ps.executeUpdate()==1){
                Estado = true;
            }
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
        return Estado;
    }
   
   
     
}
