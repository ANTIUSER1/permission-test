package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Application;

@Service
public class AppDataService {

    public Application create(String s) {
        Application app = new Application();
        app.setName(s);
        return app;
    }
}
