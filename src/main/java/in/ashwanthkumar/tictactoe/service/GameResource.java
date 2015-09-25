package in.ashwanthkumar.tictactoe.service;

import com.yammer.metrics.annotation.Timed;
import in.ashwanthkumar.tictactoe.core.Game;
import in.ashwanthkumar.utils.collections.Maps;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    Game game;

    @GET
    @Path("ping")
    @Timed
    public Map<String, String> ping() {
        return Maps.of("ok", "true");
    }

    @GET
    @Path("start")
    @Timed
    public Map<String, String> start(@QueryParam("p") int p, @QueryParam("q") int q) {
        game = new Game(p, q);
        return Maps.of("ok", "true");
    }

    @GET
    @Path("debug")
    @Timed
    public Map<String, Map<String, String>> debug() {
        return game.prettyPrint();
    }
}
