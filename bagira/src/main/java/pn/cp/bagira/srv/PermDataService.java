package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Permission;

@Service
public class PermDataService {

    public Permission create(){
        return new Permission();
    }
}
