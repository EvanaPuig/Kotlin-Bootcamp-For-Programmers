import java.util.*

fun main() {
    gamePlay(rollDice2(4))
}

var rollDice = { numberOfSides: Int ->
    if (numberOfSides == 0) 0
    else Random().nextInt(numberOfSides) + 1
}

val rollDice2: (Int) -> Int = { numberOfSides ->
    if (numberOfSides == 0) 0
    else Random().nextInt(numberOfSides) + 1
}

fun gamePlay(diceRoll: Int) {
    println(diceRoll)
}