/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigues
 */
@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable
{
     @Id@GeneratedValue(strategy = GenerationType.AUTO)
     private Integer codUsu;
     
     @Column
     private String utilizador;
     
     @Column
     private String senha;
     
     @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
     @JoinColumn(name = "func")
     private Funcionarios func;

     public Usuarios() { }// constructor padrao

    public Usuarios(String utilizador, String senha) {
        this.utilizador = utilizador;
        this.senha = senha;
    }

    public Usuarios(String utilizador, String senha, Funcionarios func) {
        this.utilizador = utilizador;
        this.senha = senha;
        this.func = func;
    }

    

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public Integer getCodUsu() {
        return codUsu;
    }

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionarios getFunc() {
        return func;
    }

    public void setFunc(Funcionarios func) {
        this.func = func;
    }

    
}
