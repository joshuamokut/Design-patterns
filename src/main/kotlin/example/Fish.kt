package example

data class Fish(val name: String)

fun fishExamples() {
    val splashy = Fish("splashy")
    myWith(splashy.name) {
        println(capitalize())
    }
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun main() {
    fishExamples()
}