package pl.venustus.OlxPriceScraper.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.venustus.OlxPriceScraper.Domain.OlxStatistics;
import pl.venustus.OlxPriceScraper.Service.OlxService;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class OlxControllerTest {


    private final OlxController olxController = Mockito.mock(OlxController.class);

    private final OlxService olxService = Mockito.mock(OlxService.class);

    private final String olxlink = "https://www.olx.pl";

    private final String myHtml = "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" class=\"fixed breakword promoted-list ad_idELwyD\" summary=\"Og�oszenie\" data-id=\"602376167\">\n" +
            "                                            <tbody>\n" +
            "                                            <tr>\n" +
            "                                                <td width=\"150\" rowspan=\"2\" class=\"photo-cell\"> <a class=\"thumb vtop inlblk rel tdnone linkWithHash scale4 detailsLinkPromoted \" href=\"https://www.olx.pl/oferta/kawalerka-29m2-w-centrum-warszawy-CID3-IDELwyD.html#c6686b4fc6\" title=\"\"> <img class=\"fleft\" src=\"https://ireland.apollo.olxcdn.com:443/v1/files/j1qvgnik4vig3-PL/image;s=644x461\" alt=\"Kawalerka 29m2 w centrum Warszawy\"> <span class=\"inlblk icon paid type2 abs zi2\" title=\"Og�oszenie wyr�nione\"></span> </a> </td>\n" +
            "                                                <td valign=\"top\" class=\"title-cell \">\n" +
            "                                                    <div class=\"space rel\">\n" +
            "                                                        <h3 class=\"lheight22 margintop5\"> <a href=\"https://www.olx.pl/oferta/kawalerka-29m2-w-centrum-warszawy-CID3-IDELwyD.html#c6686b4fc6;promoted\" class=\"marginright5 link linkWithHash detailsLinkPromoted\" data-cy=\"listing-ad-title\"> <strong>Kawalerka 29m2 w centrum Warszawy</strong> </a> </h3>\n" +
            "                                                        <p class=\"offer-path color-9 lheight16 margintop5\"> <small class=\"breadcrumb x-normal\"> Mieszkania � Wynajem </small> </p>\n" +
            "                                                    </div> </td>\n" +
            "                                                <td width=\"200\" class=\"wwnormal tright td-price\" valign=\"top\">\n" +
            "                                                    <div class=\"space inlblk rel\">\n" +
            "                                                        <p class=\"price\"> <strong>2 300 z�</strong> </p> <span class=\"normal inlblk pdingtop5 lheight16 color-2\">Do negocjacji</span>\n" +
            "                                                    </div> </td>\n" +
            "                                            </tr>\n" +
            "                                            <tr>\n" +
            "                                                <td valign=\"bottom\" class=\"bottom-cell\">\n" +
            "                                                    <div class=\"space rel\">\n" +
            "                                                        <p class=\"lheight16\"> <small class=\"breadcrumb x-normal\"> <span><i data-icon=\"location-filled\"></i>Warszawa, �r�dmie�cie</span> </small> <small class=\"breadcrumb x-normal\"> <span><i data-icon=\"clock\"></i>25 sie</span> </small> </p>\n" +
            "                                                    </div> </td>\n" +
            "                                                <td width=\"85\" class=\"tright\" valign=\"bottom\">\n" +
            "                                                    <div class=\"rel\">\n" +
            "                                                        <div class=\"rel observelinkinfo inlblk zi3\"> <a href=\"#\" class=\"{id:602376167} observe-link inlblk lheight16 tdnone tcenter margintop5 vishid \" data-statkey=\"ad.observed.list\"> <span class=\"icon inlblk observe2 observed-602376167\" data-icon=\"star\"></span> <span class=\"link x-small gray2 block lheight14\"> <span> </span> </span> </a>\n" +
            "                                                            <div class=\"suggesttitleright small top abs zi2 br4 hidden\">\n" +
            "                                                                <p></p>\n" +
            "                                                            </div>\n" +
            "                                                        </div>\n" +
            "                                                    </div> </td>\n" +
            "                                            </tr>\n" +
            "                                            </tbody>\n" +
            "                                        </table>\n" +
            "                                    </div> </td>\n" +
            "                            </tr>\n" +
            "                            <tr class=\"wrap\" rel=\"external\" data-features=\"[]\">\n" +
            "                                <td class=\"offer promoted \">\n" +
            "                                    <div class=\"offer-wrapper\">\n" +
            "                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" class=\"fixed breakword promoted-list ad_idAPbYS\" summary=\"Og�oszenie\" data-id=\"544148882\">\n" +
            "                                            <tbody>\n" +
            "                                            <tr>\n" +
            "                                                <td width=\"150\" rowspan=\"2\" class=\"photo-cell\"> <a class=\"thumb vtop inlblk rel tdnone linkWithHash scale4 detailsLinkPromoted \" href=\"https://www.otodom.pl/oferta/apartament-2-pokojowy-w-centrum-warszawy-wola-45m2-ID41DlP.html?\" title=\"\" target=\"_blank\"> <img class=\"fleft\" src=\"https://ireland.apollo.olxcdn.com:443/v1/files/q3kjr6tv7s2k3-PL/image;s=644x461\" alt=\"Apartament 2 pokojowy w centrum Warszawy,Wola 45m2\"> <span class=\"inlblk icon paid type2 abs zi2\" title=\"Og�oszenie wyr�nione\"></span> </a> </td>\n" +
            "                                                <td valign=\"top\" class=\"title-cell \">\n" +
            "                                                    <div class=\"space rel\">\n" +
            "                                                        <h3 class=\"lheight22 margintop5\"> <a href=\"https://www.otodom.pl/oferta/apartament-2-pokojowy-w-centrum-warszawy-wola-45m2-ID41DlP.html?;promoted\" class=\"marginright5 link linkWithHash detailsLinkPromoted\" target=\"_blank\" data-cy=\"listing-ad-title\"> <strong>Apartament 2 pokojowy w centrum Warszawy,Wola 45m2</strong> </a> </h3>\n" +
            "                                                        <p class=\"offer-path color-9 lheight16 margintop5\"> <small class=\"breadcrumb x-normal\"> Mieszkania � Wynajem </small> </p>\n" +
            "                                                    </div> </td>\n" +
            "                                                <td width=\"200\" class=\"wwnormal tright td-price\" valign=\"top\">\n" +
            "                                                    <div class=\"space inlblk rel\">\n" +
            "                                                        <p class=\"price\"> <strong>2 300 z�</strong> </p>\n" +
            "                                                    </div> </td>\n" +
            "                                            </tr>\n" +
            "                                            <tr>";


    @Test
    void getOlxPriceDetails() throws URISyntaxException, IOException {
        Document doc = Jsoup.parseBodyFragment(myHtml, "https://www.olx.pl");
        Elements elements = doc.select("p.price");
        for (Element element : elements) {
            System.out.println(element.text());

        }

        OlxStatistics olxStatistics = new OlxStatistics(olxlink, 5600.00, 2, 2300.00, 2300.00, 2300.00, 2300.00);

        //when(olxService.getOlxPriceDetails(olxlink)).thenReturn(olxStatistics);
        when(olxController.getOlxPriceDetails(olxlink)).thenReturn(olxStatistics);

        Assert.assertEquals(java.util.Optional.ofNullable(5600.0), java.util.Optional.ofNullable(olxController.getOlxPriceDetails(olxlink).getSum()));
    }
}