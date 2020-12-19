package practice.spices

fun main() {
    val spices = mutableListOf(
        Spice("curry", "mild"),
        Spice("pepper", "hot"),
        Spice("chilli", "very hot")
    )

    spices.add(makeSalt())

    spices.filter {
        it.heat <= 5
    }
}

fun makeSalt() = Spice("salt", "none")

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() = when(spiciness)  {
            "hot" -> 10
            "mild" -> 5
            else -> 0
        }

    init {
        println("The spice: $name is in hot scale $heat")
    }


}