package aquarium.higherOrderFunctions

data class Fish (var name: String)

fun main() {
    fishExamples()
}

fun fishExamples() {
    val fish  = Fish("splashy")

    myWith(fish.name) {
        println(capitalize())
    }

    // run returns the result of executing the lambda
    println(fish.run { name })

    // apply returns the object
    println(fish.apply { name })

    // let returns a copy of the object
    println(fish.let { it.name.capitalize() }
            .let { it + "fish" }
            .let { it.length }
            .let { it + 31 })
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}