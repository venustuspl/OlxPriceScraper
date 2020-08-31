package pl.venustus.OlxPriceScraper.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class OlxServiceTest {

    @MockBean
    OlxService olxService = new OlxService();

    @MockBean
    OlxConnection olxConnection = new OlxConnection();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getOlxPriceDetails() throws URISyntaxException, IOException {
        URL path = ClassLoader.getSystemResource("test.html");
        String simpleHTML = new String(Files.readAllBytes(Paths.get(getClass().getResource("/test.html").toURI())));

        //System.out.println(simpleHTML);
        File input = new File(path.toURI());

        //Given
        String olxlink = "http://localhost:8080/test.html";

        Document document = Jsoup.connect("http://localhost:8080/test.html")
                .followRedirects(true)
                .get();
        //System.out.println(document);
        Elements elements = document.select("p.price");

        //When
        when(olxConnection.getHtmlElemnts(olxlink)).thenReturn(elements);
        //Then
        olxService.getOlxPriceDetails(olxlink);

    }
}