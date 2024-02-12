package zad1.Controller;

import zad1.Service.APIs.ExchangeRateAPI;
import zad1.Service.APIs.NbpAPI;
import zad1.Service.APIs.OpenWeatherAPI;
import zad1.Service.Service;
import zad1.View.SimpleSwingBrowser;

import javax.swing.*;

public class Controller {

    public Controller(Service service, SimpleSwingBrowser simpleSwingBrowser) {
        SwingUtilities.invokeLater(() -> simpleSwingBrowser.setVisible(true));
        NbpAPI nbpAPI = new NbpAPI(service);
        OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI(service,"5efd8a6a73bfe2466e143d90fe263ce1");
        ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI(service);

        simpleSwingBrowser.getButton().addActionListener(e -> {
            try {
                simpleSwingBrowser.loadURL("http://en.wikipedia.org/wiki/"+simpleSwingBrowser.getCityField().getText());
                service.setCountry(simpleSwingBrowser.getCountryField().getText());
                simpleSwingBrowser.getGetWeather().setText(
                        openWeatherAPI.getWeather(simpleSwingBrowser.getCityField().getText())
                );
                simpleSwingBrowser.getGetNBPRate().setText(
                        String.valueOf(nbpAPI.getNBPRate())
                );
                simpleSwingBrowser.getGetRateFor().setText(
                        String.valueOf(exchangeRateAPI.getRateFor(simpleSwingBrowser.getCurrencyField().getText()))
                );
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
