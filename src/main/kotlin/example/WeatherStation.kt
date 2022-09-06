package example

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToInt

interface Observer {
    fun update(humidity: Double, temperature: Double, pressure: Double)
}

interface Subject {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

interface DisplayElement {
    fun display()
}

class WeatherData : Subject {
    private val observers = hashSetOf<Observer>()
    private var humidity: Double = 0.0
    private var temperature: Double = 27.5
    private var pressure: Double = 1.0


    private fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(humidity: Double, temperature: Double, pressure: Double) {
        this.humidity = humidity
        this.temperature = temperature
        this.pressure = pressure
        measurementsChanged()
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(humidity, temperature, pressure)
        }
    }
}

class ForecastDisplay(weatherData: Subject) : Observer, DisplayElement {
    init {
        weatherData.addObserver(this)
    }

    private var humidity: Double? = null

    override fun update(humidity: Double, temperature: Double, pressure: Double) {
        this.humidity = humidity
        display()
    }

    override fun display() {
        println(
            "Forecast ${
                humidity?.let {
                    if (humidity!! < 5.0) "Sunny weather ahead"
                    else "Rainy weather ahead"
                } ?: "Weather is unknown yet, awaiting data"
            }")
    }


}

class StatisticsDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var minTemperature: Double? = null
    private var maxTemperature: Double? = null
    private var totalTemperature: Double? = null
    private var temperatureCount = 0

    init {
        weatherData.addObserver(this)
    }

    override fun update(humidity: Double, temperature: Double, pressure: Double) {
        temperatureCount++
        totalTemperature = totalTemperature?.plus(temperature) ?: temperature
        minTemperature = minTemperature?.let { min(it, temperature) } ?: temperature
        maxTemperature = maxTemperature?.let { max(it, temperature) } ?: temperature
        display()
    }

    override fun display() {
        println(
            "min/avg/max temperatures are $minTemperature /" +
                    "${totalTemperature?.div(temperatureCount)?.roundToInt() ?: "Undefined"} /" +
                    "$maxTemperature"
        )
    }

}

class CurrentConditionDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var humidity: Double? = null
    private var temperature: Double? = null

    init {
        weatherData.addObserver(this)
    }

    override fun update(humidity: Double, temperature: Double, pressure: Double) {
        this.humidity = humidity
        this.temperature = temperature
        display()
    }

    override fun display() {
        println(
            "The current conditions are as follows: temperature is $temperature degrees celsius and " +
                    "humidity is $humidity"
        )
    }
}

class HeatIndexDisplayElement(weatherData: Subject) : DisplayElement, Observer {
    init {
        weatherData.addObserver(this)
    }

    private var humidity: Double = 0.0
    private var temperature: Double = 0.0

    override fun update(humidity: Double, temperature: Double, pressure: Double) {
        this.humidity = humidity
        this.temperature = temperature
        display()
    }

    override fun display() {
        println("Heat index is ${calculateHeatIndex()}")
    }

    private fun calculateHeatIndex(): Double {
        return 16.923 + 1.85212 * temperature * 10.0.pow(-1) + humidity.times(5.37941) -
                1.00254 * 10.0.pow(-1) * temperature * humidity + 9.41695 * 10.0.pow(-3) * temperature.pow(2) +
                7.28898 * 10.0.pow(-3) * humidity.pow(2) + 3.45372 * 10.0.pow(-4) * temperature.pow(2.0) *
                humidity - 8.14971 * 10.0.pow(-4) * temperature * humidity.pow(2) + 1.02102 * 10.0.pow(-5) *
                temperature.pow(2) * humidity.pow(2) - 3.8646 * 10.0.pow(-5) * temperature.pow(3) + 2.91583 *
                10.0.pow(-5) * humidity.pow(3) + 1.42721 * 10.0.pow(-6) * temperature.pow(3) * humidity +
                1.97483 * 10.0.pow(-7) * temperature * humidity.pow(3) - 2.18429 * 10.0.pow(-8) *
                temperature.pow(3) * humidity.pow(2) + 8.43296 * 10.0.pow(-10) * temperature.pow(2) *
                humidity.pow(3) - 4.81975 * 10.0.pow(-11) * temperature.pow(3) * humidity.pow(3)
    }
}


fun testWeatherData() {
    val weatherData = WeatherData()
    val currentConditionDisplay: DisplayElement = CurrentConditionDisplay(weatherData)
    val statisticsDisplay: DisplayElement = StatisticsDisplay(weatherData)
    val forecastDisplay: DisplayElement = ForecastDisplay(weatherData)
    val heatIndexDisplayElement: DisplayElement = HeatIndexDisplayElement(weatherData)

    currentConditionDisplay.display()
    statisticsDisplay.display()
    forecastDisplay.display()
    heatIndexDisplayElement.display()

    weatherData.setMeasurements(humidity = 5.0, temperature = 32.0, pressure = 2.0)
    weatherData.setMeasurements(humidity = 2.0, temperature = 28.0, pressure = 4.0)
    weatherData.setMeasurements(humidity = 10.0, temperature = 5.0, pressure = 4.5)
//    currentConditionDisplay.display()
}

fun main() {
    testWeatherData()
}