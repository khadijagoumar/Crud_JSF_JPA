package com.example.crud_jpa_jsf;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;



public class ClienteDAO {
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    // guardar cliente
    public void guardar(Cliente cliente) {
        entity.getTransaction().begin();
        entity.persist(cliente);
        entity.getTransaction().commit();

    }

    // editar cliente
    public void editar(Cliente cliente) {
        entity.getTransaction().begin();
        entity.merge(cliente);
        entity.getTransaction().commit();
    }

    // buscar cliente
    public Cliente buscar(int id) {
        Cliente c = new Cliente();
        c = entity.find(Cliente.class, id);
        return c;
    }

    /// eliminar cliente
    public void eliminar(int id) {
        Cliente c = new Cliente();
        c = entity.find(Cliente.class, id);
        entity.getTransaction().begin();
        entity.remove(c);
        entity.getTransaction().commit();
    }

    // obtener todos los cliente
    public List<Cliente> obtenerClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        Query q = entity.createQuery("SELECT c FROM Cliente c");
        listaClientes = q.getResultList();
        return listaClientes;
    }

}
