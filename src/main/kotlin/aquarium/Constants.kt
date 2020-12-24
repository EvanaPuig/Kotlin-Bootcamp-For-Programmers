package aquarium

const val rocks = 3

// value can be determined during program execution
val number = 5

// cannot be used within classes, only at top level and at 'object' classes
// value determined at compile time
const val num = 5

fun main() {
}

fun complexFunctionCall() {}

// this can't be done with const val
val result = complexFunctionCall()

const val CONSTANT = "top-level constant"

object Constants {
    const val CONSTANT2 = "object constant"
}

val foo = Constants.CONSTANT2

class MyClass {
    // Initialized from the static constructor of the containing class
    // Created when the object is created
    // While plain objects are initialized lazily on the first access to that object
    // when they are first used
    companion object {
        const val CONSTANT3 = "constant inside companion"
    }
}