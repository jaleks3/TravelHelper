package zad1.Service;

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
    public Map<String, Locale> getCountries() {
        return countries;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}