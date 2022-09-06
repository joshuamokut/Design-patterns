package example.myapp

import java.lang.Math.PI

open class Aquarium(open var width: Int = 70, open var height: Int = 40, open var length: Int = 100) {

    open val shape = "rectangle";

    open var water: Double = 0.0
        get() = volume * 0.9

    open var volume: Double
        get() = (width * height * length) / 1000.0
        set(value) {
            height = ((value * 1000) / (length * width)).toInt()
        }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1;
        height = (tank / (height * width)).toInt()
    }

    init {
        println("Aquarium is now initializing")
    }

    fun printSize() {
        println(
            "width: $width cm " +
                    "height: $height cm " +
                    "length: $length cm"
        )
        println(
            "Volume: $volume liters " +
                    "Shape: $shape " +
                    "Water: $water litres (${water / volume * 100.0}% full)"
        )

    }
}

class TowerTank(override var height: Int, var diameter: Int) :
    Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Double
        get() = (PI * (width / 2.0) * (length / 2.0) * height) / 1000.0
        set(value) {
            height = (value / (PI * (diameter / 2.0) * (diameter / 2.0))).toInt()
        }

    override val shape: String
        get() = "cylinder"

    override var water: Double = 0.0
        get() = 0.8 * volume
}