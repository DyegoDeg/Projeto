/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.facade;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Dyego
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends javax.ws.rs.core.Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
//        resources.add(UsuarioResource.class);
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.teste.projeto.facade.ComentarioResource.class);
        resources.add(br.com.teste.projeto.facade.ProdutoResource.class);
    }
    
}
