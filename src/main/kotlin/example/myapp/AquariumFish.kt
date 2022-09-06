package example.myapp

interface FishColor {
    val color: String
}

interface FishAction {
    fun eat()
}

object GoldColor : FishColor {
    override val color: String
        get() = "Gold"
}

/**
 * when you write val before a constructor parameter it declares a variable inside the class.
 * When you don't write val, the parameter is simply an argument passed onto the primary constructor and can only be
 * used inside the init blocks to initialize other variables.
 */
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Shark : FishColor, FishAction {
    override val color: String
        get() = "gray"

    override fun eat() {
        println("hunt and eat other fish or humans")
    }
}

class Plecostomus(val fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor
