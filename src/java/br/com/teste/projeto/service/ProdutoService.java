/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.service;

import br.com.teste.projeto.entidade.Comentario;
import br.com.teste.projeto.entidade.Produto;
import br.com.teste.projeto.service.repositorio.ComentarioRepositorio;
import br.com.teste.projeto.service.repositorio.ProdutoRepositorio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dyego
 */

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProdutoService extends BasicService{
    
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext(name="ProjetoPU")
    private EntityManager em;
    private ProdutoRepositorio produtoRepositorio;
    private ComentarioRepositorio comentarioRepositorio;
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        produtoRepositorio = new ProdutoRepositorio(em);
        comentarioRepositorio = new ComentarioRepositorio(em);
    }
    
    public ProdutoService() {
    
    }
    
    public List<Produto> getProdutos() {
        return produtoRepositorio.getProdutos();
    }
    
    public Produto getProduto(int id) {
        return produtoRepositorio.getProduto(id);
    }
    
    public Produto getProdutoCodigo(int id) {
        return produtoRepositorio.getProdutoCodigo(id);
    }
    
    public Produto addProduto(Produto p) {
        return produtoRepositorio.addProduto(p);
    }
    
    public Produto setProduto(Produto p) {
        return produtoRepositorio.setProduto(p);
    }
    
    public void removeProduto(Produto produto) {
        List<Comentario> lista = comentarioRepositorio.getComentarios(produto.getCdProduto());
        for(Comentario c : lista){
            comentarioRepositorio.removeComentario(c);
        }
        Produto p = produtoRepositorio.getProduto(produto.getId());
        produtoRepositorio.removeProduto(p);
    }
    
}
