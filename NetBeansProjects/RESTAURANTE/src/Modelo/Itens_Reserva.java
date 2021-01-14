/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name = "Itens_Reserva")
public class Itens_Reserva implements Serializable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItemReserva;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idReserva",nullable = false)
    private Reserva reserva;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idMesa",nullable = false)
    private Mesas mesa;

    public Itens_Reserva() {
    }

    public Itens_Reserva(Reserva reserva, Mesas mesa) {
        this.reserva = reserva;
        this.mesa = mesa;
    }

    
    public Integer getIdItemReserva() {
        return idItemReserva;
    }
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Mesas getMesa() {
        return mesa;
    }

    public void setMesa(Mesas mesa) {
        this.mesa = mesa;
    }
    
    
    
}
