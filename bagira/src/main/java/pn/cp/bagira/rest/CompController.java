package pn.cp.bagira.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pn.cp.bagira.db.CompRepository;
import pn.cp.bagira.db.UserRepository;
import pn.cp.bagira.entities.Comp;
import pn.cp.bagira.entities.User;
import pn.cp.bagira.srv.CompDataService;

@RestController
@RequestMapping("/comp")
@Slf4j
public class CompController {

    @Autowired
    private CompDataService compDataService;

    @Autowired
    private CompRepository compRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/new/{mac}")
    public Comp createComp(
            @PathVariable String mac,
            @RequestParam String ip
    ) {
        Comp c = compDataService.create(mac, ip);
        compRepository.save(c);
        log.info("COMP CREATED {}", c);
        return c;
    }

    @GetMapping("/adduser")
    public Comp createComp(@RequestParam long cid, long uid) {
        Comp c = compRepository.findById(cid).get();
        User u = userRepository.findById(uid).get();
        if (c != null && u != null) {
            u.setComp(c);
            //compRepository.save(c);
            userRepository.save(u);
            return  c;
        }
        return null;
    }
}
