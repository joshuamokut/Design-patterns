package SomeJava;

import java.util.Observable;

public class WeatherData extends Observable {
    private double temperature;
    private double pressure;
    private double humidity;

    public WeatherData() {
    }

    private void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementsChanged();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }
}

