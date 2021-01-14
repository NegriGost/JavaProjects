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
@Table(name = "Pedidos")
public class Compras implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idPedido;
 
    @Column
     private String codigoVenda;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column
     private Date data;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="Cliente", nullable=true)
    private Clientes clientes;
    
   @Column
   private String estadoVenda;
   
   @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
   @JoinColumn(name="Mesas", nullable=true)
   private Mesas mesa;
   
   @Column
   private String totalPedido;
   
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "pedidos")
    private List<Itens_Produtos>itens;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="func", nullable=true)
    private Funcionarios func;
   
    public Compras() { }

    public Compras(String codigoVenda, Date data, Clientes clientes, String estadoVenda, Mesas mesa,String total,Funcionarios func) {
        this.codigoVenda = codigoVenda;
        this.data = data;
        this.clientes = clientes;
        this.estadoVenda = estadoVenda;
        this.mesa = mesa;
        this.totalPedido=total;
        this.func=func;
    }
    
     public Compras(String codigoVenda, Date data,Clientes cliente,String estadoVenda,String total,Funcionarios func) {
        this.codigoVenda = codigoVenda;
        this.data = data;
        this.clientes=cliente;
        this.estadoVenda = estadoVenda;
        this.totalPedido=total;
        this.func=func;
    }

    public Funcionarios getFunc() {
        return func;
    }

    public void setFunc(Funcionarios func) {
        this.func = func;
    }

    
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public String getEstadoVenda() {
        return estadoVenda;
    }

    public void setEstadoVenda(String estadoVenda) {
        this.estadoVenda = estadoVenda;
    }

    public Mesas getMesa() {
        return mesa;
    }

    public void setMesa(Mesas mesa) {
        this.mesa = mesa;
    }

    public List<Itens_Produtos> getItens() {
        return itens;
    }

    public void setItens(List<Itens_Produtos> itens) {
        this.itens = itens;
    }

    public String getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(String totalPedido) {
        this.totalPedido = totalPedido;
    }
    
    
    
}