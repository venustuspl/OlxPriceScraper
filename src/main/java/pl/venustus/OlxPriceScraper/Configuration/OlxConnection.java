package pl.venustus.OlxPriceScraper.Configuration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OlxConnection {
        private Elements elements = new Elements();
    public Elements getHtmlElemnts(String olxlink) throws IOException {

        try {
            Document document = Jsoup.connect(olxlink)
                    .followRedirects(true)
                    .get();
            //System.out.println(document);
            elements = document.select("p.price");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return elements;

    }

}
