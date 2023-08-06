package zad1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Service {
    private String country;
    private final Map<String, Locale> countries = new HashMap<>();

    public Service(String country) {
        this.country = country;
        Locale locale = new Locale("en");

        for (Locale l : Locale.getAvailableLocales()) {
            String countryCode = l.getCountry();
            if (countryCode.equals("")) continue;
            String kraj = l.getDisplayCountry(locale);
            countries.put(kraj,l);
        }
    }

    public String getWeather(String city) throws Exception {
        String weatherApiKey = "5efd8a6a73bfe2466e143d90fe263ce1";
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+','+countries.get(country).getDisplayCountry()+"&appid=" + weatherApiKey +"&units=metric";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        con.disconnect();

        JSONObject obj = new JSONObject(content.toString());
        return obj.toString();
    }

    public Double getRateFor(String currency) throws Exception {

        String url = "https://api.exchangerate.host/latest?base="+ Currency.getInstance(countries.get(country)) + "&symbols=" + currency;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        con.disconnect();

        JSONObject obj = new JSONObject(content.toString());
        return obj.getJSONObject("rates").getDouble(currency);
    }
    public double getNBPRate() throws IOException {
        if (country.equals("Poland"))
            return 1;

        String[] abc = {"a","b"};
        StringBuilder content = new StringBuilder();

        for(String s : abc) {
            String url = "http://api.nbp.pl/api/exchangerates/rates/"+ s + "/"+Currency.getInstance(countries.get(country)) +"/?format=json";
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
                in.close();
                con.disconnect();
            }
            catch (FileNotFoundException e) {
                continue;
            }
        }
        JSONObject obj = new JSONObject(content.toString());
        JSONArray arr = obj.getJSONArray("rates");

        return arr.getJSONObject(0).getDouble("mid");
    }
    public void setCountry(String country) {
        this.country = country;
    }
}