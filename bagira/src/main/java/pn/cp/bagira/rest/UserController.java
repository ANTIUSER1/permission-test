package pn.cp.bagira.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pn.cp.bagira.db.UserRepository;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.User;
import pn.cp.bagira.srv.AppDataService;
import pn.cp.bagira.srv.UserDataService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppDataService appService;

    @GetMapping("/new")
    public User create( ) throws JsonProcessingException {
     User u = userDataService.create( );
        log.info(
                "USER CREATED: {} \n ", u
        );
        userRepository.save(u);
        return u;
    }


    @GetMapping("/f/{id}")
    public User  userByID(@PathVariable String id){
        log.info("  U ID {}", id);
        User u = userRepository.findById(id).get() ;
      return u;
    }

    @PostMapping("/add-app")
    public User  addAppPermission(@RequestBody String json, @RequestParam String appName)
            throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User u= mapper.readValue(json, User.class);
        //User  u = userRepository.findById(uid).get();

        log.info("User found {} ", u);
        if(u!=null){
            Application a=appService.create(appName);
        //    a.setUser(user);
          u=  userDataService.addAppPermission(u,a );

        }
        userRepository.save(u);

        return u;
    }
}
