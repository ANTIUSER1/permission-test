package pn.cp.bagira.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pn.cp.bagira.db.ApplicationRepository;
import pn.cp.bagira.db.UserRepository;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.User;
import pn.cp.bagira.srv.AppDataService;
import pn.cp.bagira.srv.UserDataService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
@Slf4j
public class ApplicationController {

    @Autowired
    private AppDataService applicationService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/new/{name}")
    public Application createComp(@PathVariable String name){
        Application c = applicationService.create(name);
        applicationRepository.save(c);
        log.info("COMP CREATED {}", c);
        return c;
    }

    @GetMapping("/join-app/")
    public void joinApp(@RequestParam Long  uid, @RequestParam Long aid) throws JsonProcessingException {
        User u=userRepository.getById(uid);
        log.info(
                "\n   UUU: \n{} ", u
        );
        Application a= applicationRepository.getById(aid);
        log.info(
                "\n   APP: \n{} ", a
        );
        a.getUserList().add(u);
        userDataService.addAppPermission(u,a);
        Map<User,Application> mp=new HashMap<>();
        mp.put(u,a);
        applicationRepository.save(a);

        ObjectMapper mapper=new ObjectMapper();
    }

    @GetMapping("/uapp/")
    public void addAllAppToUser(@RequestParam Long  uid ) throws JsonProcessingException {
        User u=userRepository.getById(uid);
        log.info(
                "\n   UUU: \n{} ", u
        );
        List<Application> alist= (List<Application>) applicationRepository.findAll();
        for(Application a:alist){
            log.info(
                    "\n   APP: \n{} ", a
            );
            userDataService.addAppPermission(u,a);}
        applicationRepository.saveAll(alist);
    }

    @GetMapping("/au/")
    public void addAllAppToAllUser(  ) throws JsonProcessingException {

        List<User> uList= (List<User>) userRepository.findAll();
        for( User u : uList) {
            log.info(
                    "\n   UUU: \n{} ", u
            );
            List<Application> alist = (List<Application>) applicationRepository.findAll();
            for (Application a : alist) {
                log.info(
                        "\n   APP: \n{} ", a
                );
                userDataService.addAppPermission(u, a);
            }
            applicationRepository.saveAll(alist);
        }

    }
}
