package models.dao;

import models.entities.BaseEntity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Chirrag on 15/01/18.
 */
public abstract class BaseDao<T extends BaseEntity> {
    @PersistenceContext
    protected EntityManager em ;

    public T save(T entity) {
        em.persist(entity);
        em.flush();
        return entity ;
    }

    public <T> T edit(T entity) {
        entity = em.merge(entity);
        em.flush();
        return entity;
    }

    public <T> List<T> list(Class<T> entityClass) {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public <T> T find(Class<T> entityClass, Integer primaryKey) {
        try {
            return em.find(entityClass, primaryKey);
        }catch(NoResultException nex){
            return null ;
        }
    }

    public void remove(T entity) {
        em.remove(entity);
        em.flush();
    }

    public void remove(Class<T> entityClass, Integer primaryKey) {
        T entity = em.find(entityClass, primaryKey);
        if (entity != null) {
            em.remove(entity);
        }else
            throw new RuntimeException("Entity not found for id: "+primaryKey);
    }

}
