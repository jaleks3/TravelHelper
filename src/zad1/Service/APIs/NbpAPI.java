package zad1.Service.APIs;

import org.json.JSONArray;
import org.json.JSONObject;
import zad1.Service.Fetcher;
import zad1.Service.Service;

import java.io.IOException;
import java.util.Currency;
import java.util.Locale;

public class NbpAPI {
    private Locale country;
    private Currency baseCurrency;
    public NbpAPI(Service service) {
        this.country = service.getCountries().get(service.getCountry());
    }

    public double getNBPRate() throws IOException {
        this.baseCurrency = Currency.getInstance(country);

        if (country.toString().equals("Poland"))
            return 1;

        String[] abc = {"a","b"};
        StringBuilder content = new StringBuilder();

        for(String s : abc) {
            String url = "http://api.nbp.pl/api/exchangerates/rates/"+ s + "/"+ baseCurrency +"/?format=json";

            content.append(Fetcher.getString(url));
        }
        JSONObject obj = new JSONObject(content.toString());
        JSONArray arr = obj.getJSONArray("rates");

        return arr.getJSONObject(0).getDouble("mid");
    }
}
