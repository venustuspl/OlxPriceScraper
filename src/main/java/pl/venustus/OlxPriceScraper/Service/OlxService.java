package pl.venustus.OlxPriceScraper.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OlxService {

    public Double getOlxAveragePrice(String olxlink) {
        Integer eachValue;
        String eachResult;
        Double result = 0.00;
        Integer listSum = 0;
        Integer loop = 0;
        try {
            List<Integer> resultList = new ArrayList<>();
            Document document = Jsoup.connect(olxlink).get();
            Elements elements = document.select("p.price");
            for (Element element : elements) {
                eachResult = element.text();
                eachValue = Integer.valueOf(eachResult.substring(0, eachResult.length() - 3).replaceAll(" ", ""));
                resultList.add(eachValue);

            }
            for (Integer values : resultList) {
                listSum = listSum + values;
                loop++;
            }

            System.out.println(listSum);
            System.out.println(loop);
            listSum = listSum - 400000;
            System.out.println(listSum);
            if (loop > 0) {
                result = Double.valueOf(listSum / loop);
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
