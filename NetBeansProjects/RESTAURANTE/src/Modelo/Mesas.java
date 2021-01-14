package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Mesas")
public class Mesas implements Serializable
{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codMesa;
    
    @Column
     private int lugares;
    
    @Column
     private int tamanho;
    
    @Column 
    private String nomeMesa;
    
     @Column
     private String estado;

    @OneToMany(mappedBy ="mesa",cascade = CascadeType.ALL)
    private List<Compras>pedidos;

    @OneToMany(mappedBy ="mesa",cascade = CascadeType.ALL)
    private List<Itens_Reserva>itens_Reservas;

    public Mesas() {  }//constructor padrao

    public Mesas(int lugares, int tamanho, String nomeMesa, String estado) {
        this.lugares = lugares;
        this.tamanho = tamanho;
        this.nomeMesa = nomeMesa;
        this.estado = estado;
    }

    public Mesas(String txt) {
        this.nomeMesa=txt;
    }
    
    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getNomeMesa() {
        return nomeMesa;
    }

    public void setNomeMesa(String nomeMesa) {
        this.nomeMesa = nomeMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Compras> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Compras> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Itens_Reserva> getItens_Reservas() {
        return itens_Reservas;
    }

    public void setItens_Reservas(List<Itens_Reserva> itens_Reservas) {
        this.itens_Reservas = itens_Reservas;
    }

    public Integer getCodMesa() {
        return codMesa;
    }

    @Override
    public String toString() {
        return  nomeMesa;
    }
    
    
}
