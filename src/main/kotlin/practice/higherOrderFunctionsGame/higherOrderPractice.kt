package practice.higherOrderFunctionsGame

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    println(numbers.numbersDivisibleBy3 {
        it.rem(3)
    })
}

fun List<Int>.numbersDivisibleBy3(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}