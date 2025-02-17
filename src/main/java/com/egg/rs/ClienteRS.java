package com.egg.rs;

import com.egg.entidades.Cliente;
import com.egg.servicio.ClienteServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @GET
    @Path("/codigo/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente buscarClientePorCodigo(@PathParam("codigo") int codigo) {
        return clienteServiceImpl.buscarClientePorCodigo(codigo);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response crearCliente(Cliente cliente) {
        clienteServiceImpl.crearCliente(cliente.getCodigoCliente(),
                cliente.getNombreCliente(),
                cliente.getNombreContacto(),
                cliente.getApellidoContacto(),
                cliente.getCiudad(),
                cliente.getCodigoPostal(),
                cliente.getPais(),
                cliente.getRegion(),
                cliente.getTelefono(),
                cliente.getFax());
        return Response
                .status(Response.Status.CREATED)
                .entity("Cliente creado correctamente")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response actualizarCliente(Cliente cliente) {
        clienteServiceImpl.actualizarCliente(cliente);
        return Response
                .status(Response.Status.OK)
                .entity("Cliente actualizado")
                .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response eliminarCliente(Cliente cliente) {
        clienteServiceImpl.eliminarCliente(cliente);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }

}
