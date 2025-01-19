package pn.cp.bagira.srv;

import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.Comp;
import pn.cp.bagira.entities.User;

import java.util.ArrayList;

@Service
public class UserDataService {

    public User create( ) {
      return  new User();
    }

    public User addAppPermission(User user, Application app){
        if(user.getApplicationList()==null)
            user.setApplicationList(new ArrayList<>());
        user.getApplicationList().add(app);
        return user;
    }
}
