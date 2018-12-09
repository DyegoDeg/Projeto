/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.facade;

import br.com.teste.projeto.entidade.Comentario;
import br.com.teste.projeto.service.ComentarioService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Dyego
 */

@Path("comentario")
public class ComentarioResource {
    
    @EJB
    private ComentarioService service;
    
    @GET
    @Path(value = "{id}")
    public List<Comentario> findAll(@PathParam(value = "id")int id){
        return service.getComentarios(id);
    };
    
    @POST
    public Comentario persist(Comentario c){
        return service.addComentario(c);
    };
    
    @DELETE
    @Path(value = "{id}")
    public boolean delete(@PathParam(value = "id") int id) {
        Comentario comentario = service.getComentario(id);
        if (comentario != null) {
            service.removeComentario(id);
            return true;
        }
        return false;
    }
    
}
