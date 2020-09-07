package pl.venustus.OlxPriceScraper.Service;

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
class OlxServiceTest {

    private final OlxService olxService = Mockito.mock(OlxService.class);

    private final String olxlink = "https://www.olx.pl";

    @Test
    void shouldGetCorrectOlxobjectFromOlxService() throws URISyntaxException, IOException {
        //Given
        OlxStatistics olxStatistics = new OlxStatistics(olxlink, 5600.00, 2, 2300.00, 2300.00, 2300.00, 2300.00);

        //When
        when(olxService.getOlxPriceDetails(olxlink)).thenReturn(olxStatistics);

        //Then
        Assert.assertEquals(java.util.Optional.ofNullable(5600.0), java.util.Optional.ofNullable(olxService.getOlxPriceDetails(olxlink).getSum()));
    }
}