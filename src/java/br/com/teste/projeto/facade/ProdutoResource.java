/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.facade;

import br.com.teste.projeto.entidade.Produto;
import br.com.teste.projeto.service.ProdutoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Dyego
 */
@Path(value = "produto")
public class ProdutoResource {
    
    @EJB
    private ProdutoService service;
    
    @GET
    public List<Produto> findAll(){
        return service.getProdutos();
    };
    
    @GET
    @Path(value = "{id}")
    public Produto find(@PathParam(value = "id")int id){
        return service.getProduto(id);
    };
    
    @GET
    @Path(value = "codigo/{id}")
    public Produto findCodigo(@PathParam(value = "id")int id){
        return service.getProdutoCodigo(id);
    };
    
    @POST
    public Produto persist(Produto p){
        return service.addProduto(p);
    };
    
    @PUT
    public Produto update(Produto p){
        return service.setProduto(p);
    };
    
    @DELETE
    @Path(value = "{id}")
    public int delete(@PathParam(value = "id") int id) {
        Produto produto = service.getProduto(id);
        if (produto != null) {
            service.removeProduto(produto);
            return 1;
        }
        return 0;
    }
    
}
