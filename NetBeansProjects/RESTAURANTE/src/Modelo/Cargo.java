
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigues
 */
@Entity
@Table(name = "Perfil")
public class Cargo implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codCargo;
    
    @Column
    private String nomeCargo;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cargo")
    private List<Funcionarios> func;

    public Cargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Cargo() {
    }

    
    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public List<Funcionarios> getFunc() {
        return func;
    }

    public void setFunc(List<Funcionarios> func) {
        this.func = func;
    }

    public Integer getCodCargo() {
        return codCargo;
    }
    
    
}
