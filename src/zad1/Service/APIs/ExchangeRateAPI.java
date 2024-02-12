package zad1.Service.APIs;

import zad1.Service.Fetcher;
import zad1.Service.Service;

import java.util.Currency;
import java.util.Locale;

public class ExchangeRateAPI {
    private Locale country;
    private Currency baseCurrency;
    public ExchangeRateAPI(Service service) {
        this.country = service.getCountries().get(service.getCountry());

    }
    public Double getRateFor(String currency) throws Exception {
        this.baseCurrency = Currency.getInstance(country);

        String url = "https://api.exchangerate.host/latest?base="+ baseCurrency + "&symbols=" + currency;
        Fetcher.getString(url);

        return Fetcher.getString(url).getJSONObject("rates").getDouble(currency);
    }
}
