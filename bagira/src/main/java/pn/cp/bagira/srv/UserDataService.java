package pn.cp.bagira.srv;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.Permission;
import pn.cp.bagira.entities.User;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@Slf4j
public class UserDataService {

    public User create( ) {
      return  new User();
    }

    public User addAppPermission(User user, Application app){
        log.info(
                "\n    ADD TO USER APP_LIST \n {}", user.getApplicationList()
        );
        if(user.getApplicationList()==null)
            user.setApplicationList(new ArrayList<>());
        user.getApplicationList().add(app);
        return user;
    }

    public User putAppPermission(User user, Application app, Permission perm){
        if(user.getApplicationPermissionMap()==null)
            user.setApplicationPermissionMap(new HashMap<>());
        user.getApplicationPermissionMap().put(app,perm);
        return user;
    }
}
