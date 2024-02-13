package zad1.Service.APIs;

import org.json.JSONArray;
import org.json.JSONObject;
import zad1.Service.Fetcher;
import zad1.Service.Service;

import java.io.IOException;
import java.util.Currency;
import java.util.Locale;

public class NbpAPI {
    private final Service service;
    public NbpAPI(Service service) {
        this.service = service;
    }

    public double getNBPRate() throws IOException {
        Locale country = service.getCountries().get(service.getCountry());
        Currency baseCurrency = Currency.getInstance(country);

        if (baseCurrency.toString().equals("PLN"))
            return 1;

        String[] abc = {"a","b"};
        JSONObject obj = null;

        for(String s : abc) {
            String url = "https://api.nbp.pl/api/exchangerates/rates/" + s + "/"+ baseCurrency +"/?format=json";
            obj = Fetcher.get(url);
            if(!obj.isEmpty())
                break;
        }
        JSONArray arr = obj.getJSONArray("rates");

        return arr.getJSONObject(0).getDouble("mid");
    }
}
