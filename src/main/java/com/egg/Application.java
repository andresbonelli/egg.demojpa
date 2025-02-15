package com.egg;

import com.egg.servicio.OficinaService;


public class Application {

    public static void main(String[] args) {
        OficinaService oficinaServicio = new OficinaService();
        //ClienteService clienteServicio = new ClienteService(new ClienteDAO());
       /* List<Cliente> clientes = clienteServicio.buscarClientePorNombre("jardin");
        for (Cliente c : clientes) {
            System.out.println(c.getNombreCliente());
        }
        System.out.println(clienteServicio.buscarClientePorCodigo(9999).getNombreCliente());*/
       /* clienteServicio.crearCliente(
                9998,
                "Cliente 2",
                "Nombre Contacto 2",
                "Apellido Contacto 2",
                "Corrientes",
                "1425",
                "Argentina",
                "Litoral",
                "11111112",
                "11111112");*/
        //oficinaServicio.crearOficina("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111","CP5000");
    }

    }

