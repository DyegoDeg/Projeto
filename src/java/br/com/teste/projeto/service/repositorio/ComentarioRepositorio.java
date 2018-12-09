/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.service.repositorio;

import br.com.teste.projeto.entidade.Comentario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Dyego
 */
public class ComentarioRepositorio extends BasicRepository<Comentario> {
    
    public ComentarioRepositorio(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Comentario getComentario(int id) {
        return getEntity(Comentario.class, id);
    }

    public Comentario setComentario(Comentario comentario) {
        return setEntity(Comentario.class, comentario);
    }
    
    public Comentario addComentario(Comentario comentario) {
        return addEntity(Comentario.class, comentario);
    }
    
    public void removeComentario(Comentario comentario) {
        removeEntity(comentario);
    }
    
    public List<Comentario> getComentarios(int id) {
        return getPureList(Comentario.class,"select c from Comentario c where c.produto.cdProduto = ?1 Order By c.cdComentario", id);
    }
}
