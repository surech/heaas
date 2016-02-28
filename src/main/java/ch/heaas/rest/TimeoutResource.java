package ch.heaas.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by surech on 28.02.16.
 */
@Component
@Path("/timeout")
public class TimeoutResource {

    /** Default-Wert für das Timeout ist 5 Minuten */
    private final static long DEFAULT_TIMEOUT = 1000 * 60 * 5;

    /** Default-Code, welcher nach Ablauf des Timeout zurückgegeben wird */
    private final static int DEFAULT_HTTP_CODE = Response.Status.REQUEST_TIMEOUT.getStatusCode();

    @GET
    public Response timeout() throws InterruptedException {
        return this.timeout(DEFAULT_TIMEOUT);
    }

    @GET
    @Path("/{timeout}")
    public Response timeout(@PathParam("timeout") long timeout) throws InterruptedException {
        return timeout(timeout, DEFAULT_HTTP_CODE);
    }

    @GET
    @Path("/{timeout}/{httpcode}")
    public Response timeout(@PathParam("timeout") long timeout, @PathParam("httpcode") int httpcode) throws InterruptedException {
        // Wir legen uns schlafen
        Thread.sleep(timeout);

        return Response.status(httpcode).build();
    }
}
