package pl.venustus.OlxPriceScraper.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class OlxServiceTest {

    @Mock
    OlxService olxService = new OlxService();

    @Mock
    OlxConnection olxConnection = new OlxConnection();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getOlxPriceDetails() throws URISyntaxException, IOException {

        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p>     <p class=\"price\"> <strong>2 300 z�</strong> </p> <span class=\"normal inlblk pdingtop5 lheight16 color-2\">Do negocjacji</span>\n" +
                "                                                    </body></html>";
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("p.price");

        String olxlink = "https://www.olx.pl/nieruchomosci/mieszkania/wynajem/warszawa/?search%5Bfilter_enum_furniture%5D%5B0%5D=yes&search%5Bfilter_float_m%3Afrom%5D=38&search%5Bfilter_float_m%3Ato%5D=40&search%5Bfilter_enum_rooms%5D%5B0%5D=two&search%5Bdistrict_id%5D=377";

        when(olxConnection.getHtmlElemnts(olxlink)).thenReturn(elements);
        System.out.println("test1");
        //Then
        olxService.getOlxPriceDetails(olxlink);

    }

    @Test
    void sampleTest() throws IOException {

        String myHtml = "<A HREF=\"junklink\">Junk Info</A>&nbsp;&nbsp;Link Id: A2&nbsp;&nbsp;<A HREF=\"Junk Link></A>";

        Document doc = Jsoup.parseBodyFragment(myHtml, "http://your.baseurl");
        Elements elements = doc.select("a[href]");
        for (Element element : elements) {
            System.out.println(element.ownText());

        }

        //System.out.println(doc.text());

    }
}