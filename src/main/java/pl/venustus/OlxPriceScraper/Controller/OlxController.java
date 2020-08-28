package pl.venustus.OlxPriceScraper.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.venustus.OlxPriceScraper.Service.OlxService;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class OlxController {

    @Autowired
    private OlxService olxService;

    @RequestMapping(method = RequestMethod.GET, value = "/getolxpricedetails")
    public Map<String, Double> getOlxPriceDetails(@RequestParam("olxlink") String olxlink) {
        return olxService.getOlxPriceDetails(olxlink);
    }

}

