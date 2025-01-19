package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Comp;

@Service
public class CompDataService {

    public Comp create(String mac){
        Comp c = new Comp();
        c.setMac(mac);
         return c;
    }
}
