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
@Table(name = "Itens_Produto")
public class Itens_Produtos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idItens;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedidos")
     private Compras pedidos;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Produtos")
     private Produtos prod;
    
   @Column 
   private int quantidade;
    
   @Column 
   private double precoTotal;
   
    public Itens_Produtos(Compras pedidos, Produtos produtos, int quantidade, double Subtotal) {
        this.pedidos = pedidos;
        this.prod = produtos;
        this.quantidade = quantidade;
        this.precoTotal = Subtotal;
    }

    public Itens_Produtos() { }

    public Integer getIdItens() {
        return idItens;
    }

    public void setIdItens(Integer idItens) {
        this.idItens = idItens;
    }

    public Compras getPedidos() {
        return pedidos;
    }

    public void setPedidos(Compras pedidos) {
        this.pedidos = pedidos;
    }

    public Produtos getProdutos() {
        return prod;
    }

    public void setProdutos(Produtos produtos) {
        this.prod = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
     
    
}
