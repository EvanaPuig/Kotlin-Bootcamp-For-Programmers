package practice.spices

fun main() {
    val spice = SimpleSpice()
    println(spice.nameOfTheSpice)
    println(spice.levelOfSpiciness)
}

class SimpleSpice {
    var nameOfTheSpice: String = "curry"
    var levelOfSpiciness: String = "mild"

    val heat: Int
        get() = if (levelOfSpiciness == "mild") 5 else 0
}