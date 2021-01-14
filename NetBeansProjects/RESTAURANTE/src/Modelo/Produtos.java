package Modelo;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "Produtos")
public class Produtos implements Serializable
{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codProd;
    
    @Column
    private String nomeProd;
    
    @Column
    private double Preco;
    
    @Column
    private String   Foto;
    
    @Column
    private String estado;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produtoCategoria", nullable=false)
    private Categoria categ; 
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prod")
    List<Itens_Produtos>itens;
    
    public Produtos() { }//constructor padrao

    public Produtos(String nomeProd, double Preco, String Foto, Categoria categ,String estado) {
        this.nomeProd = nomeProd;
        this.Preco = Preco;
        this.Foto = Foto;
        this.categ = categ;
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public Integer getCodProd() {
        return codProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public Categoria getCateg() {
        return categ;
    }

    public void setCateg(Categoria categ) {
        this.categ = categ;
    }

    public List<Itens_Produtos> getItens() {
        return itens;
    }

    public void setItens(List<Itens_Produtos> itens) {
        this.itens = itens;
    }


   
}
