package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Comp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class CompDataService {

    public Comp create(String mac){
        return Comp.builder()
                //.compUserList(new ArrayList<>())
                .mac(mac)
                .build();
    }
}
