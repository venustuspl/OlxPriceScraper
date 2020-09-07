package pl.venustus.OlxPriceScraper.Configuration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class OlxConnectionTest {

    private final OlxConnection olxConnection = new OlxConnection();

    private final String olxlink = "https://www.olx.pl/motoryzacja/samochody/";

    @Test
    void shouldGetNotNullElementsList() throws IOException {
        //Given
        Document doc = Jsoup.connect(olxlink)
                .followRedirects(true)
                .get();
        Elements elements = doc.select("p.price");

        //Then
        Assert.assertNotNull(olxConnection.getHtmlElemnts(olxlink));


    }
}