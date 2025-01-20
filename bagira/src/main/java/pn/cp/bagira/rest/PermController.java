package pn.cp.bagira.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pn.cp.bagira.db.ApplicationRepository;
import pn.cp.bagira.db.UserRepository;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.User;
import pn.cp.bagira.srv.PermDataService;
import pn.cp.bagira.srv.UserDataService;

import java.util.List;

@RestController
@RequestMapping("/perm")
@Slf4j
public class PermController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private PermDataService permDataService;

    @GetMapping("/apu/")
    public void addAllAppPermToAllUser() throws JsonProcessingException {

        List<User> uList = (List<User>) userRepository.findAll();
        for (User u : uList) {
            log.info(
                    "\n   UUU: \n{} ", u
            );
            List<Application> alist = (List<Application>) applicationRepository.findAll();
            for (Application a : alist) {
                log.info(
                        "\n   APP: \n{} ", a
                );
                u.getApplicationPermissionMap().put(a, permDataService.create());
            }
        }
        userRepository.saveAll(uList);

    }
}
