package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Comp;

@Service
public class CompDataService {

    public Comp create(String mac, String ip) {
        Comp c = new Comp();
        c.setMac(mac);
        c.setIp(ip);
        return c;
    }
}
