/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.service;

import br.com.teste.projeto.entidade.Comentario;
import br.com.teste.projeto.service.repositorio.ComentarioRepositorio;
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
public class ComentarioService extends BasicService {
    
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext(name="ProjetoPU")
    private EntityManager em;
    private ComentarioRepositorio comentarioRepositorio;
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        comentarioRepositorio = new ComentarioRepositorio(em);
    }
    
    public ComentarioService() {
    
    }
    
    public List<Comentario> getComentarios(int id) {
        return comentarioRepositorio.getComentarios(id);
    }
    
    public Comentario getComentario(int id) {
        return comentarioRepositorio.getComentario(id);
    }
    
    public Comentario addComentario(Comentario c) {
        return comentarioRepositorio.addComentario(c);
    }
    
    public Comentario setComentario(Comentario c) {
        return comentarioRepositorio.setComentario(c);
    }
    
    public void removeComentario(int id) {
        Comentario c = comentarioRepositorio.getComentario(id);
        comentarioRepositorio.removeComentario(c);
    }
    
}
