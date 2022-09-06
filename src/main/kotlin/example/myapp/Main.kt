package example.myapp

fun buildAquarium() {
    val smallAquarium = Aquarium(width = 5, height = 5, length = 5)
    smallAquarium.printSize()
    println()

    val bigAquarium = Aquarium(width = 100, height = 100, length = 200)
    bigAquarium.printSize()
    println()

    val fishAquarium = Aquarium(30)
    fishAquarium.printSize()
    println()

    fishAquarium.volume = 100.0
    fishAquarium.printSize()
    println()

    val newAquarium = Aquarium(width = 25, length = 25, height = 40)
    newAquarium.printSize()
    println()

    val myTowerTank = TowerTank(height = 45, diameter = 25)
    myTowerTank.printSize()
    println()

}

fun makeFish() {
    val shark = Shark()
    val plecostomus = Plecostomus()

    println("Shark color is ${shark.color}")
    shark.eat()
    println()

    println("Plecostomus color is ${plecostomus.color}")
    plecostomus.eat()
    println()
}

fun testCollections() {
    val arr = Array(10) { it + 1 }
    val (even, odd) = arr.asSequence().partition { it % 2 == 0 }
    println(even.toString())
    println(odd.toString())

    /**
     * use the keyword 'to' to associate a second value in a pair to a first value
     */
    val couple = "Prince" to "Jessica"
    println(couple)
    println("${couple.first} is married to ${couple.second}\n")

    val children = Triple("Mxyzptlk", "Nyxlygsptlnz", "Bryxly")
    println(children.toString())
    println(children.toList())
    println(
        "The children of ${couple.first} and ${couple.second} are ${children.first}, " +
                "${children.second} and ${children.third}"
    )

    val child = Triple("Mxyzpltk", "10", "5")
    println("The first child is ${child.first}. He is ${child.second} years old and he is in grade ${child.third}\n")

    val family = couple to children
    println(
        "I have just created a pair where the first part is a pair and the second is a triple. it links the couple " +
                "${family.first.first} and ${family.first.second} to their children ${family.second.first}," +
                " ${family.second.second} and ${family.second.third}\n"
    )

    val (husband, wife) = couple
    println("This is called destructuring. The husband in $couple is $husband and the wife is $wife\n")


    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(list)
    println(list.sum())

    val list2 = children.toList()
    println(list2.sumBy { it.length })

    for (ch in list.listIterator()) {

        print("$ch ")
    }
    println("\n")

    val location = hashMapOf("Kufre" to "UK", "mommy" to "Nigeria", "Karen" to "US", "Praise" to "Saudi", 1 to 2)

    location[1] = 3
    println(location.getOrElse("john", {}))
    location.put("inzilya", "china")
    println(location)
    println()

    val countries = mutableMapOf(
        "America" to "White house",
        "Russia" to "Kremlin",
        "UK" to "downing street",
        "Nigeria" to "Aso Rock"
    )
    countries.put("germany", "Bundeskanzleramt")
    countries.remove("Nigeria")

    for ((k, v) in countries) {
        println("the seat of the president/prime minister/chancellor of $k is $v")
    }


}

fun String.isPalindrome(): Boolean = if (this.isEmpty()) true else this == this.reversed()

fun main() {
    println("abba".isPalindrome())
//    testCollections();
}