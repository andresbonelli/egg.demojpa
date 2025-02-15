package com.egg.servicio;

import com.egg.entidades.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarClientes();

    Cliente buscarClientePorCodigo(int codigoCliente);

   List<Cliente> buscarClientePorNombre(String nombreCliente);

    void crearCliente(int codigoCliente,
                             String nombreCliente,
                             String nombreContacto,
                             String apellidoContacto,
                             String ciudad,
                             String codigoPostal,
                             String pais,
                             String region,
                             String telefono,
                             String fax
    );
}
