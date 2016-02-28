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
@Path("/code")
public class CodeResource {
    @GET
    @Path("/{httpcode}")
    public Response createCode(@PathParam("httpcode") String httpcode){
        return Response.status(parseHttpCode(httpcode)).build();
    }

    protected int parseHttpCode(String httpCode){
        try {
            return Integer.parseInt(httpCode);
        } catch(NumberFormatException e){
            // Wenn wir den Code nicht parsen können, geben
            // wir ein BAD REQUEST zurück
            return Response.Status.BAD_REQUEST.getStatusCode();
        }
    }
}
