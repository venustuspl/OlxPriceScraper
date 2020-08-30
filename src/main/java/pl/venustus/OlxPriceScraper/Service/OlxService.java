package pl.venustus.OlxPriceScraper.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import pl.venustus.OlxPriceScraper.Domain.OlxStatistics;

import java.io.IOException;
import java.util.*;

@Service
public class OlxService {

    public OlxStatistics getOlxPriceDetails(String olxlink) {
        Double eachValue;
        String eachResult;
        Double average = 0.00;
        double listSum = 0;
        Integer loop = 0;
        Double maxValue = 0.00;
        Double minValue = 0.00;
        Double median = 0.00;

        List<Double> valuesList = new ArrayList<>();
        Map<String, Double> resultMap = new HashMap<>();
        try {

            Document document = Jsoup.connect(olxlink)
                    .followRedirects(true)
                    .get();
            //System.out.println(document);
            Elements elements = document.select("p.price");
            for (Element element : elements) {
                eachResult = element.text();
                System.out.println(element.ownText());
                eachValue = Double.valueOf(eachResult.substring(0, eachResult.length() - 3).replaceAll(" ", "").replaceAll(",", "."));
                System.out.println(eachValue);
                valuesList.add(eachValue);

            }
            if (!valuesList.isEmpty()) {
                minValue = valuesList.get(0);
            }
            for (Double value : valuesList) {
                listSum = listSum + value;
                loop++;
                if (value > maxValue) {
                    maxValue = value;
                }
                if (value < minValue) {
                    minValue = value;
                }

            }
            listSum = listSum - minValue - maxValue;
            if (loop > 0) {
                average = Double.valueOf(listSum / (loop - 2));
                average = Double.valueOf(Math.round(average / 100));
                average = Double.valueOf(Math.round(average * 100));

            }

            Collections.sort(valuesList);
            if (loop % 2 == 0) {
                median = valuesList.get(Integer.valueOf(loop / 2));
            } else {
                median = valuesList.get(Integer.valueOf(loop / 2) + 1);
            }


            OlxStatistics olxStatistics = new OlxStatistics(olxlink, listSum, loop, average, minValue, maxValue, median);
            resultMap.put("Sum: ", listSum);
            resultMap.put("Number items: ", Double.valueOf(loop));
            resultMap.put("Average price: ", average);
            resultMap.put("Min value: ", minValue);
            resultMap.put("Max value: ", maxValue);
            resultMap.put("Median: ", median);

            for (Map.Entry<String, Double> entry : resultMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }


            return olxStatistics;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
