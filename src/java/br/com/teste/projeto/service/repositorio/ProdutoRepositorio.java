/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.service.repositorio;

import br.com.teste.projeto.entidade.Produto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Dyego
 */
public class ProdutoRepositorio extends BasicRepository<Produto> {
    
    public ProdutoRepositorio(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Produto getProduto(int id) {
        return getEntity(Produto.class, id);
    }
    
    public Produto getProdutoCodigo(int id) {
        try{
            return getPurePojo(Produto.class,"select p from Produto p where p.cdProduto = ?1", id);
        }catch(Exception e){
            return new Produto();
        }
    }

    public Produto setProduto(Produto produto) {
        return setEntity(Produto.class, produto);
    }
    
    public Produto addProduto(Produto produto) {
        return addEntity(Produto.class, produto);
    }
    
    public void removeProduto(Produto produto) {
        removeEntity(produto);
    }
    
    public List<Produto> getProdutos() {
        return getPureList(Produto.class,"select p from Produto p Order By p.cdProduto");
    }
    
}
