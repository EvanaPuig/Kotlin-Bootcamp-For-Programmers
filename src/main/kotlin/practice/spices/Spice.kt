package practice.spices

fun main() {
    val spices = mutableListOf<Spice>()

    spices.filter {
        it.heat <= 5
    }

    var mildCurry = Curry("mild")
    println(mildCurry.color)
}

sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {
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
    val color: Color
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);
}

object YellowColor : SpiceColor {
    override val color = Color.YELLOW
}