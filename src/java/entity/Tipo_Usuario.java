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
public class Tipo_Usuario {
    private int idTipo_Usuario;
    private String Tipo_Usuario;
    private int Tipo;

    public Tipo_Usuario(int idTipo_Usuario, String Tipo_Usuario, int Tipo) {
        this.idTipo_Usuario = idTipo_Usuario;
        this.Tipo_Usuario = Tipo_Usuario;
        this.Tipo = Tipo;
    }



    public int getIdTipo_Usuario() {
        return idTipo_Usuario;
    }

    public void setIdTipo_Usuario(int idTipo_Usuario) {
        this.idTipo_Usuario = idTipo_Usuario;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }
}
