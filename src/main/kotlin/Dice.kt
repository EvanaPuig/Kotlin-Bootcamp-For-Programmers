import java.util.*

fun main() {

}

var rollDice = { numberOfSides: Int ->
    if (numberOfSides == 0) 0
    else Random().nextInt(numberOfSides) + 1
}

val rollDice2: (Int) -> Int = { numberOfSides ->
    if (numberOfSides == 0) 0
    else Random().nextInt(numberOfSides) + 1
}