package practice.spices

fun main() {
    val spices = mutableListOf<Spice>()

    spices.filter {
        it.heat <= 5
    }

    var mildCurry = Curry("mild")
    println(mildCurry.color)
}

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {
    val heat: Int
        get() = when(spiciness)  {
            "hot" -> 10
            "mild" -> 5
            else -> 0
        }

    init {
        println("The spice: $name is in hot scale $heat")
    }

    abstract fun prepareSpice()
}

class Curry(spiciness: String, color: SpiceColor = YellowColor):
    Spice("curry", spiciness = spiciness, color),
    Grinder {
        override fun prepareSpice() {
            grind()
        }

        override fun grind() {

        }

}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowColor : SpiceColor {
    override val color = "yellow"
}