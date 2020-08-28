package pl.venustus.OlxPriceScraper.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.venustus.OlxPriceScraper.Domain.OlxStatistics;
import pl.venustus.OlxPriceScraper.Service.OlxService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class OlxController {

    @Autowired
    private OlxService olxService;

    @RequestMapping(method = RequestMethod.GET, value = "/getolxpricedetails")
    public OlxStatistics getOlxPriceDetails(@RequestParam("olxlink") String olxlink) {
        return olxService.getOlxPriceDetails(olxlink);
    }

}

