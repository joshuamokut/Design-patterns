package example

interface WeaponBehavior {
    fun useWeapon()
}


/**
 * using a singleton pattern here because there is no need to create different instances of these classes.
 */
object KnifeBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("cutting with knife")
    }
}

object AxeBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("chopping with axe")
    }
}

object BowAndArrowBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("Shooting an arrow with a bow")
    }
}

object SwordBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("Swinging a sword")
    }
}

/**
 * I just thought of the question when do you use an abstract class compared to when you use an interface.
 * One possible answer to this question is this: interfaces represents behavior, a class represents an object.
 * Any other ideas?
 */
abstract class Character(var weaponBehavior: WeaponBehavior) {
    open fun fight() {
        weaponBehavior.useWeapon()
    }
}

class King(weaponBehavior: WeaponBehavior = SwordBehavior) : Character(weaponBehavior) {
    override fun fight() {
        print("The king is fighting:  ")
        super.fight()
    }
}

class Queen(weaponBehavior: WeaponBehavior = BowAndArrowBehavior) : Character(weaponBehavior) {
    override fun fight() {
        print("The queen is fighting: ")
        super.fight()
    }
}

class Knight(weaponBehavior: WeaponBehavior = AxeBehavior) : Character(weaponBehavior) {
    override fun fight() {
        print("The knight is fighting: ")
        super.fight()
    }
}

class Troll(weaponBehavior: WeaponBehavior = KnifeBehavior) : Character(weaponBehavior) {
    override fun fight() {
        print("The Troll is fighting: ")
        super.fight()
    }
}

fun testCharacters() {
    val king: Character = King()
    val queen: Character = Queen()
    val knight: Character = Knight()
    val troll: Character = Troll()

    king.fight()
    queen.fight()
    knight.fight()
    troll.fight()
    println()

    king.weaponBehavior = AxeBehavior
    queen.weaponBehavior = KnifeBehavior
    troll.weaponBehavior = BowAndArrowBehavior
    knight.weaponBehavior = SwordBehavior

    king.fight()
    queen.fight()
    knight.fight()
    troll.fight()
}

fun main() {
    testCharacters()
}



