package aquarium.health

fun main() {
    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")
    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red") // false
    symptoms.contains("red spots") // true

    println(symptoms.subList(4, symptoms.size)) // [belly up]

    listOf(1, 5, 3).sum() // 9

    listOf("a", "b", "cc").sumBy { it.length } // 4

    val cures = mapOf("white spot" to "Ich", "red spots" to "hole disease")
    println(cures["white spot"])
    println(cures.get("white spot"))

    cures.getOrElse("bloating") {"No cure for this"}

    val inventory = mutableMapOf("fishnet" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fishnet")
}