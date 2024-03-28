package com.example.crud_jpa_jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;

import com.example.crud_jpa_jsf.ClienteDAO;
import com.example.crud_jpa_jsf.Cliente;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {

    public String nuevo() {
        Cliente c= new Cliente();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("cliente", c);
        return  "/faces/nuevo.xhtml";
    }

    public String guardar (Cliente cliente) {
        //guarda la fecha de registro
        Date fechaActual= new Date();
        cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));

        ClienteDAO clienteDAO= new ClienteDAO();
        clienteDAO.guardar(cliente);
        return  "/faces/index.xhtml";
    }

    public List<Cliente> obtenerClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();

        /*
         * List<Cliente> listaClientes = new ArrayList<>(); Cliente c1 = new Cliente();
         * c1.setId(1L); c1.setNombres("Elivar"); c1.setApellidos("Largo");
         * c1.setDireccion("Loja");
         *
         * Cliente c2 = new Cliente(); c2.setId(1L); c2.setNombres("Elivar1");
         * c2.setApellidos("Largo1"); c2.setDireccion("Loja1"); listaClientes.add(c1);
         * listaClientes.add(c2);
         *
         * return listaClientes;
         */
        return clienteDAO.obtenerClientes();
    }

    public String editar(int id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente c = new Cliente();
        c = clienteDAO.buscar(id);
        System.out.println("******************************************");
        System.out.println(c);

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("cliente", c);
        return "/faces/editar.xhtml";
    }

    public String actualizar(Cliente cliente) {
        //guarda la fecha de actualizacion
        Date fechaActual= new Date();
        cliente.setFactualizar(new java.sql.Date(fechaActual.getTime()));

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.editar(cliente);
        return "/faces/index.xhtml";
    }

    // eliminar un cliente
    public String eliminar(int id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.eliminar(id);
        System.out.println("Client eliminado..");
        return "/faces/index.xhtml";
    }

}
