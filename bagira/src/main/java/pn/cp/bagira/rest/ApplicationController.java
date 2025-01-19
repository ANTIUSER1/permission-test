package pn.cp.bagira.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pn.cp.bagira.db.ApplicationRepository;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.Comp;
import pn.cp.bagira.srv.ApplicationService;

@RestController
@RequestMapping("/app")
@Slf4j
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationRepository appRepository;


    @GetMapping("/new/{name}")
    public Application createComp(@PathVariable String name){
        Application c = applicationService.create(name);
        appRepository.save(c);
        log.info("COMP CREATED {}", c);
        return c;
    }
}
