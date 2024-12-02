package pns.tst.cutr_list.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pns.tst.cutr_list.entities.Curruncy;

import java.util.ArrayList;
import java.util.List;

/**
 * service for  adding test data
 */
@Service
@Slf4j
public class AddDataService {

    @Autowired
    private CurrencyService currencyService;

    public List<Curruncy> addCurrencyData(){
        List<Curruncy> result=new ArrayList<>();

        result.add(currencyService.create("AMD"));
        result.add(currencyService.create("RUB"));
        result.add(currencyService.create("TR"));
        result.add(currencyService.create("KZ"));
        result.add(currencyService.create("GB"));
        result.add(currencyService.create("FR"));
        result.add(currencyService.create("USD"));
        result.add(currencyService.create("AMD"));
log.info(" CREATE CURRENCY SET   "+result);

return result;
    }
}
