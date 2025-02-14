package com.egg.persistencia;

import com.egg.entidades.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDAO extends DAO<Cliente> {

    public Cliente buscarPorCodigo(int codigoCliente) {
        EntityManager em = getEntityManager();
        try {
            return em
                    .createQuery("SELECT c FROM Cliente c WHERE c.codigoCliente = :codigo", Cliente.class)
                    .setParameter("codigo", codigoCliente)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Cliente> buscarPorNombre(String nombreCliente) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.nombreCliente LIKE :nombre", Cliente.class)
                    .setParameter("nombre", "%" + nombreCliente + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
