package example.decor


/**
 * == is the same as equals() for data classes: both check structural equality.
 * === is for checking referential equality i.e. are we pointing to the same object in memory
 * assigning an object to a variable takes on the reference of the object. if you just want to copy use a=b.copy()
 */
fun makeDecorations() {
    val decoration = Decoration(rocks = "crystal", wood = "wood", diver = "diver")

    val (rocks, _, diver) = decoration

    println(rocks)
    println(diver)

}

data class Decoration(
    val rocks: String,
    val wood: String,
    val diver: String
)

enum class Direction(val degrees: Int) {
    North(0), South(90), East(180), West(270)
}

fun testDirection() {
    println(Direction.East.degrees)
}

fun main() {
    val trip = Triple("head", "shoulder", 2)
    println(trip.toString())
    println("${trip.first} && ${trip.second} are ${trip.third} parts of the human body")
    println("-------------------------------\n")

    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println(numbers.sum())
}


