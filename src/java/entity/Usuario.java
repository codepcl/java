/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author PCHINOL
 */
public class Usuario {
    private int idUsuario;
    private String DNI;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String Usuario;
    private String Password;
    private Estado estado;
    private Tipo_Usuario tipo_usuario;

    public Usuario(int idUsuario, String DNI, String Nombre, String Apellido, String Direccion, String Telefono, String Usuario, String Password,Tipo_Usuario tipo_usuario,  Estado estado) {
        this.idUsuario = idUsuario;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Usuario = Usuario;
        this.Password = Password;
        this.estado = estado;
        this.tipo_usuario = tipo_usuario;
    }

    public Usuario() {
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Tipo_Usuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(Tipo_Usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", Usuario=" + Usuario + ", Password=" + Password + ", estado=" + estado + ", tipo_usuario=" + tipo_usuario + '}';
    }
}
