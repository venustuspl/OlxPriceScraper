package pl.venustus.OlxPriceScraper.Controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.venustus.OlxPriceScraper.Domain.OlxStatistics;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class OlxControllerTest {

    private final OlxController olxController = Mockito.mock(OlxController.class);

    private final String olxlink = "https://www.olx.pl";

    @Test
    void shouldReceiveCorrectSumFromOlxStatisticObject() throws URISyntaxException, IOException {
        //Given
        OlxStatistics olxStatistics = new OlxStatistics(olxlink, 5600.00, 2, 2300.00, 2300.00, 2300.00, 2300.00);

        //When
        when(olxController.getOlxPriceDetails(olxlink)).thenReturn(olxStatistics);

        //Then
        Assert.assertEquals(java.util.Optional.ofNullable(5600.0), java.util.Optional.ofNullable(olxController.getOlxPriceDetails(olxlink).getSum()));
    }
}