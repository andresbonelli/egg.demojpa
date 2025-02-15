package com.egg.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class DAO<T> {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final Class<T> clase;

    @SuppressWarnings("unchecked")
    public DAO() {
        this.clase = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<T> listarTodos() {
        EntityManager em = getEntityManager();
        try {
            return em
                    .createQuery("FROM " + clase.getSimpleName(), clase)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void guardar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public T buscarPorId(Class<T> clase, int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(clase, id);
        } finally {
            em.close();
        }
    }

    public void actualizar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void eliminar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
