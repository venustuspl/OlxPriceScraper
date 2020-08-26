package pl.venustus.OlxPriceScraper.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class OlxController {

    @GetMapping("/")
    public List<String> getOffersCount() {
        try {
            List<String> result = new ArrayList<>();
            Document document = Jsoup.connect("https://www.olx.pl/nieruchomosci/mieszkania/wynajem/warszawa/?search%5Bfilter_float_m%3Afrom%5D=38&search%5Bfilter_float_m%3Ato%5D=40&search%5Bdistrict_id%5D=377").get();
            Elements elements = document.select("p.price");
            for (Element element : elements) {
                result.add(element.text());
                System.out.println(element.text());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}