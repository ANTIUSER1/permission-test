package pns.tst.cutr_list.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pns.tst.cutr_list.entities.Curruncy;
import pns.tst.cutr_list.repositories.CurrencyRepository;
import pns.tst.cutr_list.services.AddDataService;
import pns.tst.cutr_list.services.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/make")
@Slf4j
public class CurrencyController {

    @Autowired
    private AddDataService addDataService;
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/m")
    public String createData(){
        List<Curruncy> data= addDataService.addCurrencyData();
        currencyRepository.saveAll(data);
      log.info("Data added "+data);
        return "Data added "+data.size();
    }

}
