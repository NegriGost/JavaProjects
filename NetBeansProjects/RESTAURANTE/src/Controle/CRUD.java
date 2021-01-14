/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Cargo;
import Modelo.Clientes;
import Modelo.Compras;
import Modelo.Itens_Produtos;
import Modelo.Itens_Reserva;
import Modelo.Mesas;
import Modelo.Categoria;
import Modelo.Funcionarios;
import Modelo.Produtos;
import Modelo.Usuarios;
import Modelo.Reserva;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Rodrigues
 */
public class CRUD {
    SessionFactory fact = HibernateUtil.getSessionFactory();
    Session sessao;
    
    /**
     *  Cria a sessao a partir do SessionFactory 
     * @return objecto so tipo sessao
     */
    private Session criaSessao() {
        if(sessao == null)
            sessao = fact.openSession();
        return sessao;
    }
    
    
    /**
     *  Salva um objecto na base de dados
     * @param obj
     * @return objecto o objecto gravado se correr tudo bem
     * caso contrario retorna null
     * obj - Um objecto qualquer que represente uma tabela na base de dados
     */
    public Object salvar(Object obj){
        try{
             criaSessao().beginTransaction();
             criaSessao().save(obj);
             criaSessao().getTransaction().commit();
        return obj;
        
        }catch(Throwable ex){
              criaSessao().getTransaction().rollback();  // Em caso da transacao correr mal, todas as operacoes sao canceladas
        } 
        return null;
    }
    
    /**
     *  Actualiza um objecto na base de dados
     * @param obj
     * @return objecto o objecto actualizado se correr tudo bem
     * caso contrario retorna null
     * obj - Um objecto qualquer que represente uma tabela na base de dados
     */
    public Object actualizar(Object obj){
        try{
             criaSessao().getTransaction().begin();
             criaSessao().update(obj);
             criaSessao().getTransaction().commit();
        return obj;
        
        }catch(Throwable ex){
              criaSessao().getTransaction().rollback();  // Em caso da transacao correr mal, todas as operacoes sao canceladas
        } finally {
            //criaSessao().close(); // Fecha a sessao no final das operacoes
        }
        return null;
    }
    
    
    /**
     *  Apaga um objecto na base de dados
     * @param obj
     * @return true se correr tudo bem
     * caso contrario retorna false
     * obj - Um objecto qualquer que represente uma tabela na base de dados
     */
    public boolean excluir(Object obj){
        try{
             criaSessao().getTransaction().begin();
             criaSessao().delete(obj);
             criaSessao().getTransaction().commit();
        return true;
        
        }catch(Throwable ex){
              criaSessao().getTransaction().rollback();  // Em caso da transacao correr mal, todas as operacoes sao canceladas
        } finally {
           // criaSessao().close(); // Fecha a sessao no final das operacoes
        }
        return false;
    }
    
    
     /**
     *  Busca todos Clientes na base de dados
     * @return lista dos clientes encontrados ou uma lista vazia, caso nao encontre
     */

      public List<Clientes> buscaClientess(){
        return criaSessao().createCriteria(Clientes.class).list();
    }
       /**
     *  Busca todos Produtos na base de dados
     * @return lista dos produtos encontrados ou uma lista vazia, caso nao encontre
     */
    public List<Produtos> buscaProduto(){
        return criaSessao().createCriteria(Produtos.class).list();
    }
     /**
     *  Busca todos Mesas na base de dados
     * @return lista dos Mesas encontrados ou uma lista vazia, caso nao encontre
     */
    public List<Mesas> buscaMesas(){
        return criaSessao().createCriteria(Mesas.class).list();
    }
    
     public List<Cargo> buscaCargos(){
        return criaSessao().createCriteria(Cargo.class).list();
    }
     public List<Funcionarios> buscaFunc(){
        return criaSessao().createCriteria(Funcionarios.class).list();
     }
    
     /**
     *  Busca todas as Categorias de produtos na base de dados
     * @return lista dos Categorias de produtos encontrados ou uma lista vazia, caso nao encontre
     */
       public List<Categoria> buscaTipoProdutos(){
        return criaSessao().createCriteria(Categoria.class).list();
    }
   
         /**
     *  Busca todas as Compras na base de dados
     * @return Compras  encontrados ou uma lista vazia, caso nao encontre
     */
    public List<Compras> buscaPedidos(){
        return criaSessao().createCriteria(Compras.class).list();
    }
    
     public List<Reserva> buscaReservas(){
        return criaSessao().createCriteria(Reserva.class).list();
    }
    
     public List<Itens_Reserva> buscaItensReservas(){
        return criaSessao().createCriteria(Itens_Reserva.class).list();
    }
      /**
     *  Busca todos Usuarios na base de dados
     * @return lista dos Usuarios  encontrados ou uma lista vazia, caso nao encontre
     */
     public List<Usuarios> buscaUtilizador(){
        return criaSessao().createCriteria(Usuarios.class).list();
    }
       public List<Itens_Produtos> buscaItens(){
        return criaSessao().createCriteria(Itens_Produtos.class).list();
    }
}
