/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rodrigues
 */
@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;
    
    @Column
    private String codigoReserva;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Clientes",nullable = false)
    private Clientes clientes;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date data;
    
    @Column
    private int numPessoas;
    
    @Column
    private String estado;
    
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "reserva")
   private List<Itens_Reserva>inItens_Reserva;

    public Reserva() {
    }

   
    public Reserva(String codigoReserva, Clientes cliente, Date data, int numPessoas, String estado) {
        this.codigoReserva = codigoReserva;
        this.clientes = cliente;
        this.data = data;
        this.numPessoas = numPessoas;
        this.estado = estado;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Clientes getCliente() {
        return clientes;
    }

    public void setCliente(Clientes cliente) {
        this.clientes = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Itens_Reserva> getInItens_Reserva() {
        return inItens_Reserva;
    }

    public void setInItens_Reserva(List<Itens_Reserva> inItens_Reserva) {
        this.inItens_Reserva = inItens_Reserva;
    }
   
   
}
