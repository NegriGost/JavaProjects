/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigues
 */
@Entity
@Table(name = "Clientes")
public class Clientes implements Serializable
{
    
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codCliente;
    
    @Column(name = "Nome",nullable = false)
    private String nomeCli;
    
    @Column
     private String apelidoCli;
    
    @Column
     private String moradaCli;
    
    @Column
     private String contactoCli;
    
     @Column
     private String emailCli;
    
     @Column
     private String trabalhoCli;
     
     @Column
     private String estado;
     
     @OneToMany(fetch=FetchType.LAZY, mappedBy="clientes")
     public List<Compras> compras;

     @OneToMany(fetch=FetchType.LAZY, mappedBy="clientes")
     public List<Reserva> reservas;

    public Clientes() {
    }

    public Clientes(String nomeCli, String apelidoCli, String moradaCli, String contactoCli, String emailCli, String trabalhoCli,String estado) {
        this.nomeCli = nomeCli;
        this.apelidoCli = apelidoCli;
        this.moradaCli = moradaCli;
        this.contactoCli = contactoCli;
        this.emailCli = emailCli;
        this.trabalhoCli = trabalhoCli;
        this.estado=estado;
    }

    public Clientes(String text) {
        this.nomeCli=text;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getApelidoCli() {
        return apelidoCli;
    }

    public void setApelidoCli(String apelidoCli) {
        this.apelidoCli = apelidoCli;
    }

    public String getMoradaCli() {
        return moradaCli;
    }

    public void setMoradaCli(String moradaCli) {
        this.moradaCli = moradaCli;
    }

    public String getContactoCli() {
        return contactoCli;
    }

    public void setContactoCli(String contactoCli) {
        this.contactoCli = contactoCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getTrabalhoCli() {
        return trabalhoCli;
    }

    public void setTrabalhoCli(String trabalhoCli) {
        this.trabalhoCli = trabalhoCli;
    }

    public List<Compras> getCompras() {
        return compras;
    }

    public void setCompras(List<Compras> compras) {
        this.compras = compras;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}
