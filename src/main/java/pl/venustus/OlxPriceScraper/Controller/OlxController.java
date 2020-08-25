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
            Document document = Jsoup.connect("https://www.pracuj.pl/praca/junior%20java%20developer;kw/warszawa;wp").get();
            Elements elements = document.select("a[class=offer-details__title-link]");
            for (Element element : elements) {
                result.add(element.ownText() + " - " + "https://pracuj.pl" + element.attr("href"));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}