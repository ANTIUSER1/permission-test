package pn.cp.bagira.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pn.cp.bagira.db.CompRepository;
import pn.cp.bagira.db.UserRepository;
import pn.cp.bagira.entities.Comp;
import pn.cp.bagira.entities.User;
import pn.cp.bagira.srv.UserDataService;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompRepository compRepository;

    @PostMapping("/new")
    public User create(@RequestBody String compJson) throws JsonProcessingException {

   log.info("JSON:\n {}", compJson);
   ObjectMapper mapper=new ObjectMapper();

        Comp c = mapper.readValue(compJson, Comp.class) ;
        log.info("FROM COMP {} ", c);
   //    log.info("UU USER WIL BE CREATED from {}", c);
//        User u = userDataService.create(c);
//        log.info(
//                "USER CREATED: {} \n FROM {}", u, c
//        );

        return null;
    }

}
