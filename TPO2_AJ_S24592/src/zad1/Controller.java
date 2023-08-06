package zad1;

import javax.swing.*;

public class Controller {

    public Controller(Service service, SimpleSwingBrowser simpleSwingBrowser) {
        SwingUtilities.invokeLater(() -> simpleSwingBrowser.setVisible(true));

        simpleSwingBrowser.getButton().addActionListener(e -> {
            try {
                simpleSwingBrowser.loadURL("http://en.wikipedia.org/wiki/"+simpleSwingBrowser.getCityField().getText());
                service.setCountry(simpleSwingBrowser.getCountryField().getText());
                simpleSwingBrowser.getGetWeather().setText(
                        service.getWeather(simpleSwingBrowser.getCityField().getText())
                );
                simpleSwingBrowser.getGetNBPRate().setText(
                        String.valueOf(service.getNBPRate())
                );
                simpleSwingBrowser.getGetRateFor().setText(
                        String.valueOf(service.getRateFor(simpleSwingBrowser.getCurrencyField().getText()))
                );
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
