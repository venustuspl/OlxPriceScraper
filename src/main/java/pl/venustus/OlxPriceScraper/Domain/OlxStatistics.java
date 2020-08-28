package pl.venustus.OlxPriceScraper.Domain;

public class OlxStatistics {

    private String url;
    private Double sum;
    private Integer countItem;
    private Double average;
    private Double minValue;
    private Double maxValue;

    public OlxStatistics(String url, Double sum, Integer countItem, Double average, Double minValue, Double maxValue) {
        this.url = url;
        this.sum = sum;
        this.countItem = countItem;
        this.average = average;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getCountItem() {
        return countItem;
    }

    public void setCountItem(Integer countItem) {
        this.countItem = countItem;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "OlxStatistics{" +
                "url='" + url + '\'' +
                ", sum=" + sum +
                ", countItem=" + countItem +
                ", average=" + average +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
