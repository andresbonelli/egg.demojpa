package com.egg.config;

import javax.ws.rs.ApplicationPath;

import com.egg.servicio.ClienteService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")  // Base path for REST endpoints
public class JAXRSConfig extends ResourceConfig {
    public JAXRSConfig() {
        // Register packages for scanning
        packages("com.egg.rs", "com.egg.service");

        // Manually bind services
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ClienteService.class).to(ClienteService.class);
            }
        });
    }

}

