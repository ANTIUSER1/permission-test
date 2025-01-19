package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Comp;
import pn.cp.bagira.entities.User;

@Service
public class UserDataService {

    public User create(Comp comp) {
        User u=User.builder()
                .comp(comp)
//                .permitionMap(new HashMap<>())
                .build();
        comp.getCompUserList().add(u);
        return u;
    }
}
