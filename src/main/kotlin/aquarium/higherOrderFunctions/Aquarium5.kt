package aquarium.higherOrderFunctions

data class Fish (var name: String)

fun main() {
    fishExamples()
}

fun fishExamples() {
    val fish  = Fish("splashy")

    // without inline an object is created every call to myWith
    myWith(fish.name) {
        capitalize()
    }

    /*
    This is the equivalent of what the code without inline is doing
    myWith(fish.name, object : Function1<String, Unit>  {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })
     */

    // with inline no object is created, and lambda body is inlined here
    // fish.name.capitalize()
    // inline in complex functions does increase the code size

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

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}