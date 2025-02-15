package com.egg.rs;

import com.egg.entidades.Cliente;
import com.egg.servicio.ClienteService;
import com.egg.servicio.ClienteServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRS {

    private final ClienteService clienteService;

    @Inject
    public ClienteRS(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GET
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

}
