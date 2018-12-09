
package br.com.teste.projeto.service.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Dyego
 */
abstract class BasicRepository<T> {

    private static final long serialVersionUID = 1L;
    
    private final EntityManager entityManager;

    public BasicRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    protected T addEntity(Class<T> classToCast,Object entity) {
        getEntityManager().persist(entity);
        return (T) entity; 
    }
    
    protected T getEntity(Class<T> classToCast,Serializable pk) {
        return getEntityManager().find(classToCast, pk);
    }
    
    protected T setEntity(Class<T> classToCast,Object entity) {
        Object updatedObj = getEntityManager().merge(entity);
        return (T) updatedObj;
    }
    
    protected void removeEntity(Object entity) {
        Object updateObj = getEntityManager().merge(entity);
        getEntityManager().remove(updateObj);
    }
    
    protected List<T> getPureList(Class<T> classToCast,String query,Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }
    
    protected T getPurePojo(Class<T> classToCast,String query,Object... values) {
        Query qr = createQuery(query, values);
        return (T) qr.getSingleResult();
    }
    
    protected int executeCommand(String query,Object... values) {
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }
    
    private Query createQuery(String query,Object... values) {
        Query qr = getEntityManager().createQuery(query);
        for (int i = 0; i < values.length; i++) {
            qr.setParameter((i+1), values[i]);
        }
        return qr;
    }
    
    
    
    
}
