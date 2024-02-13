package zad1.Service.APIs;

import zad1.Service.Fetcher;
import zad1.Service.Service;

public class OpenWeatherAPI {

    private final Service service;
    private final String apiKey;

    public OpenWeatherAPI(Service service, String apiKey) {
        this.service = service;
        this.apiKey = apiKey;
    }

    public String getWeather(String city) throws Exception {
        String countryCode = service.getCountries().get(service.getCountry()).getDisplayCountry();

        String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+','+ countryCode +"&appid=" + apiKey +"&units=metric";

        return Fetcher.get(url).toString();
    }
}
