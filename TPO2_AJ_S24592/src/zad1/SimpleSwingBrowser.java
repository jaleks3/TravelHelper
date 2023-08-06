package zad1;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleSwingBrowser extends JFrame {
    private JTextField currencyField;
    private JTextField countryField;
    private JTextField cityField;
    private JTextField getRateFor;
    private JTextField getNBPRate;
    private JTextField getWeather;
    private JButton button;
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
    private final JPanel panel = new JPanel(new BorderLayout());

    public SimpleSwingBrowser() {
        super();
        initComponents();
    }

    private void initComponents() {
        createScene();

        JPanel inputs = new JPanel();
        JPanel outputs = new JPanel();
        JPanel combined = new JPanel();

        getRateFor = new JTextField(15);
        getRateFor.setEditable(false);

        getNBPRate = new JTextField(15);
        getNBPRate.setEditable(false);

        getWeather = new JTextField(15);
        getWeather.setEditable(false);

        countryField = new JTextField("Country",15);

        cityField = new JTextField("City",15);

        currencyField = new JTextField("Currency code",15);

        inputs.add(countryField,BorderLayout.NORTH);
        inputs.add(cityField,BorderLayout.CENTER);
        inputs.add(currencyField,BorderLayout.SOUTH);

        outputs.add(getWeather,BorderLayout.NORTH);
        outputs.add(getNBPRate,BorderLayout.CENTER);
        outputs.add(getRateFor,BorderLayout.SOUTH);

        button = new JButton("GO");


        combined.add(inputs,BorderLayout.WEST);
        combined.add(outputs,BorderLayout.CENTER);
        combined.add(button,BorderLayout.EAST);

        JPanel topBar = new JPanel(new BorderLayout(5, 0));
        topBar.add(combined,BorderLayout.NORTH);
        topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));

        panel.add(topBar, BorderLayout.NORTH);
        panel.add(jfxPanel, BorderLayout.CENTER);

        getContentPane().add(panel);

        setPreferredSize(new Dimension(1280, 1024));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private void createScene() {

        Platform.runLater(() -> {
            WebView view = new WebView();
            engine = view.getEngine();
            jfxPanel.setScene(new Scene(view));
        });
    }

    public void loadURL(final String url) {
        Platform.runLater(() -> {
            String tmp = toURL(url);

            if (tmp == null) {
                tmp = toURL("http://" + url);
            }

            engine.load(tmp);
        });
    }

    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
            return null;
        }
    }

    public JButton getButton() {
        return button;
    }

    public JTextField getGetWeather() {
        return getWeather;
    }

    public JTextField getCityField() {
        return cityField;
    }

    public JTextField getCurrencyField() {
        return currencyField;
    }

    public JTextField getGetRateFor() {
        return getRateFor;
    }

    public JTextField getGetNBPRate() {
        return getNBPRate;
    }

    public JTextField getCountryField() {
        return countryField;
    }
}