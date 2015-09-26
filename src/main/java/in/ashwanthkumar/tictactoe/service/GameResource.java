package in.ashwanthkumar.tictactoe.service;

import com.yammer.metrics.annotation.Timed;
import in.ashwanthkumar.tictactoe.core.Game;
import in.ashwanthkumar.tictactoe.player.Player;
import in.ashwanthkumar.tictactoe.player.PlayerFactory;
import in.ashwanthkumar.tictactoe.player.RandomPlayer;
import in.ashwanthkumar.utils.collections.Maps;
import in.ashwanthkumar.utils.lang.tuple.Tuple2;

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
    Player player;

    public static final String PLAYER_TYPE = RandomPlayer.NAME;

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
        player = PlayerFactory.create(PLAYER_TYPE, game);
        return Maps.of("ok", "true");
    }

    @GET
    @Path("move")
    @Timed
    public Map<String, String> move(@QueryParam("m") String m) {
        game.doHisMove(m);
        return Maps.of("m", myMove());
    }

    private String myMove() {
        Tuple2<Integer, Integer> myMove = player.nextMove();
        Integer x = myMove._1();
        Integer y = myMove._2();

        game.getBoard().placeMyMove(x, y);
        return String.format("%d|%d", x, y);
    }

    @GET
    @Path("debug")
    @Timed
    public Map<String, Object> debug() {
        Maps.MapBuilder<String, Object> builder = Maps.builder();
        builder.put("status", "ok");
        builder.put("marks", game.getMarks());
        builder.put("game_over", game.isOver());
        builder.put("who_won", game.whoWon());
        builder.put("board", game.prettyPrint());
        return builder.value();
    }
}
