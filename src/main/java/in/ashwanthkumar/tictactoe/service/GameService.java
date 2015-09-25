package in.ashwanthkumar.tictactoe.service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class GameService extends Service<ServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new GameService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        bootstrap.setName("tictactoe");
    }

    @Override
    public void run(ServiceConfiguration configuration,
                    Environment environment) {
        environment.addResource(new GameResource());
    }

}
