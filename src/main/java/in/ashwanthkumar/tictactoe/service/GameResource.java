package in.ashwanthkumar.tictactoe.service;

import com.yammer.metrics.annotation.Timed;
import in.ashwanthkumar.utils.collections.Maps;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    @GET
    @Path("ping")
    @Timed
    public Map<String, String> ping() {
        return Maps.of("ok", "true");
    }
}
