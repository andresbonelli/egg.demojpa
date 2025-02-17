package com.egg.rs;

import com.egg.entidades.Cliente;
import com.egg.servicio.ClienteServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRS {

   private final ClienteServiceImpl clienteServiceImpl;

   public ClienteRS() {
       this.clienteServiceImpl = new ClienteServiceImpl();
   }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listarClientes() {
        return clienteServiceImpl.listarClientes();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente buscarClientePorId(@PathParam("id") int id) {
        return clienteServiceImpl.buscarClientePorId(id);
    }

}
