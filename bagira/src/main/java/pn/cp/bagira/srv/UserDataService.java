package pn.cp.bagira.srv;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.User;

import java.util.ArrayList;

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
}
