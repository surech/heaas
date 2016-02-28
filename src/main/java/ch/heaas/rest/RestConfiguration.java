package ch.heaas.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Konfiguration für die REST-Services
 */
//@Configuration
@Component
@ApplicationPath("/errors")
public class RestConfiguration extends ResourceConfig {
    public RestConfiguration() {
        registerEndpoints();
    }

    public void registerEndpoints() {
        register(CodeResource.class);
        register(TimeoutResource.class);
    }
}
