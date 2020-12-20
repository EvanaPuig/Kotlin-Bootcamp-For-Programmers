package practice.spices

fun main() {
    val curryContainer = SpiceContainer(Curry("mild"))

    println(curryContainer.label)
}

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}