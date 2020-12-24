package aquarium

// Extension functions are a substitute to what we usually do in util functions
// Allows you to add functions to an existing class without having access to it's source code
fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}

fun extensionsExample() {
    "Does it have spaces?".hasSpaces() // true
}

open class AquariumPlant(var color: String, private val size: Int)

// Extension functions are declared outside of the class they extend
// they don't get access to private variables
fun AquariumPlant.isRed() = color == "red"

class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)

fun AquariumPlant.print() = println("Aquarium Plant")
fun GreenLeafyPlant.print() = println("Green Leafy Plant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print() // Green Leafy Plant

    val aquariumPlant: AquariumPlant = plant
    // Extension function is resolved statically
    aquariumPlant.print() // Aquarium Plant
}

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    plant.isGreen // true
}

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull() // ok
}