package SomeJava;

import example.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private Double currentPressure;
    private Double lastPressure;
    private Observable observable;

    public ForecastDisplay(Observable o) {
        this.observable = o;
        o.addObserver(this);
    }

    @Override
    public void display() {
        if (lastPressure == null) {
            System.out.println("Insufficient data for weather forecast\n");
        } else if (lastPressure > currentPressure) {
            System.out.println("Forecast: Expect a stormy weather ahead\n");
        } else {
            System.out.println("Forecast: Expect a clearer cooler weather ahead\n");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData weatherData) {
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }
}
