package com.egg.servicio;

import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarTodos();
    }

    public Cliente buscarClientePorCodigo(int codigoCliente) {
        return clienteDAO.buscarPorCodigo(codigoCliente);
    }

    public List<Cliente> buscarClientePorNombre(String nombreCliente) {
        return clienteDAO.buscarPorNombre(nombreCliente);
    }


    public void crearCliente(int codigoCliente,
                             String nombreCliente,
                             String nombreContacto,
                             String apellidoContacto,
                             String ciudad,
                             String codigoPostal,
                             String pais,
                             String region,
                             String telefono,
                             String fax
                             ) {
        try {
            Cliente clienteNuevo = new Cliente();
            clienteNuevo.setCodigoCliente(codigoCliente);
            clienteNuevo.setNombreCliente(nombreCliente);
            clienteNuevo.setNombreContacto(nombreContacto);
            clienteNuevo.setApellidoContacto(apellidoContacto);
            clienteNuevo.setCiudad(ciudad);
            clienteNuevo.setCodigoPostal(codigoPostal);
            clienteNuevo.setPais(pais);
            clienteNuevo.setRegion(region);
            clienteNuevo.setTelefono(telefono);
            clienteNuevo.setFax(fax);

            clienteDAO.guardar(clienteNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el nuevo cliente de manera correcta");
        }
    }
}
