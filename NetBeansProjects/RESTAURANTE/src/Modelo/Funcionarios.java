/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigues
 */
@Entity
@Table(name = "Funcionarios")
public class Funcionarios implements Serializable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
     private Integer codFunc;
    
    @Column(name = "Nome",nullable = false)
    private String Nome;
    
    @Column
     private String Apelido;
    
    @Column
     private String Morada;
    
    @Column
     private String Contacto;
    
    @Column
     private String Email;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codCargo")
    private Cargo cargo;
    
    @Column
    private String estado;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "func")
    private List<Usuarios>usu;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "func")
    private List<Compras>compra;
    
    public Funcionarios(String Nome, String Apelido, String Morada, String Contacto, String Email) {
        this.Nome = Nome;
        this.Apelido = Apelido;
        this.Morada = Morada;
        this.Contacto = Contacto;
        this.Email = Email;
    }
    
    public Funcionarios(String Nome, String Apelido, String Morada, String Contacto, String Email, Cargo cargo, String estado) {
        this.Nome = Nome;
        this.Apelido = Apelido;
        this.Morada = Morada;
        this.Contacto = Contacto;
        this.Email = Email;
        this.cargo = cargo;
        this.estado = estado;
    }

    public List<Compras> getCompra() {
        return compra;
    }

    public void setCompra(List<Compras> compra) {
        this.compra = compra;
    }

    
    public Integer getCodFunc() {
        return codFunc;
    }

    public List<Usuarios> getUsu() {
        return usu;
    }

    public void setUsu(List<Usuarios> usu) {
        this.usu = usu;
    }

    
    public Funcionarios() { }//constructor padrao

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    public String getNome() {
        return Nome;
    }

    public Integer getId() {
        return codFunc;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String Apelido) {
        this.Apelido = Apelido;
    }

    public String getMorada() {
        return Morada;
    }

    public void setMorada(String Morada) {
        this.Morada = Morada;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
}
