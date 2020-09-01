package pl.venustus.OlxPriceScraper.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OlxConnection {

        public Elements getHtmlElemnts(String olxlink) throws IOException {
            Document document = Jsoup.connect(olxlink)
                    .followRedirects(true)
                    .get();
            //System.out.println(document);
            Elements elements = document.select("p.price");

            return elements;

        }

}
