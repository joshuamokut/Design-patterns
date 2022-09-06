package SomeJava;

import example.DisplayElement;
import org.jetbrains.annotations.NotNull;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private double humidity;
    private double temperature;

    public CurrentConditionsDisplay(@NotNull Observable o) {
        observable = o;
        o.addObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Temperature is currently %s and humidity is %s %n%n", temperature, humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData weatherData) {
            this.humidity = weatherData.getHumidity();
            this.temperature = weatherData.getTemperature();
            display();
        }
    }
}

