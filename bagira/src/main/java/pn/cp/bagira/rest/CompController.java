package pn.cp.bagira.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pn.cp.bagira.db.CompRepository;
import pn.cp.bagira.entities.Comp;
import pn.cp.bagira.srv.CompDataService;

@RestController
@RequestMapping("/comp")
@Slf4j
public class CompController {

    @Autowired
    private CompDataService compDataService;

    @Autowired
    private CompRepository compRepository;

    @GetMapping("/new/{mac}")
    public Comp createComp(@PathVariable  String mac){
        Comp c = compDataService.create(mac);
         compRepository.save(c);
         log.info("COMP CREATED {}", c);
        return c;
    }
}
