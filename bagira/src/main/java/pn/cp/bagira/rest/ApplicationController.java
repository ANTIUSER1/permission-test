package pn.cp.bagira.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pn.cp.bagira.db.ApplicationRepository;
import pn.cp.bagira.db.UserRepository;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.User;
import pn.cp.bagira.srv.AppDataService;
import pn.cp.bagira.srv.UserDataService;

@RestController
@RequestMapping("/app")
@Slf4j
public class ApplicationController {

    @Autowired
    private AppDataService applicationService;

    @Autowired
    private ApplicationRepository appRepository;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/new/{name}")
    public Application createComp(@PathVariable String name){
        Application c = applicationService.create(name);
        appRepository.save(c);
        log.info("COMP CREATED {}", c);
        return c;
    }

    @GetMapping("/to-user")
    public User toUser(
        @RequestParam    String uid,
        @RequestParam    String aid){
        User u=userRepository.getById(uid);
        Application a= appRepository.getById(aid);
        log.info(
                "\n   APP: \n{} ", a
        );
     if(u!=null && a!=null)   u=   userDataService.addAppPermission(u ,a);
   appRepository.save(a);
        return u;
    }
}
