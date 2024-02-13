package zad1.Service.APIs;

import zad1.Service.Fetcher;
import zad1.Service.Service;

import java.util.Currency;
import java.util.Locale;

public class ExchangeRateAPI {
    private final Service service;
    private final String apiKey;
    public ExchangeRateAPI(Service service,String apiKey) {
        this.service = service;
        this.apiKey = apiKey;
    }
    public Double getRateFor(String currency) throws Exception {
        Locale country = service.getCountries().get(service.getCountry());
        Currency baseCurrency = Currency.getInstance(country);

        String url = "https://api.exchangerate.host/latest?=" + apiKey + "&base=" + baseCurrency + "&symbols=" + currency;

        System.out.println(Fetcher.get(url));

        return Fetcher.get(url).getJSONObject("rates").getDouble(currency);
    }
}
