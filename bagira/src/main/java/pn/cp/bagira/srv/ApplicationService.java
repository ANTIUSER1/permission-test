package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Application;

@Service
public class ApplicationService {

    public Application create(String s){
        return Application.builder()
                .name(s)
                .build();
    }
}
