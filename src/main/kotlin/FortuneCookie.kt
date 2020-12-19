import java.util.*

fun main() {
    var fortune: String
    for (i in 1..10) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break;
    }
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    return when(birthday) {
        1 -> fortunes[6]
        2 -> fortunes[5]
        3 -> fortunes[4]
        4 -> fortunes[3]
        5 -> fortunes[2]
        6 -> fortunes[1]
        7 -> fortunes[0]
        28 -> fortunes[5]
        31 -> fortunes[3]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday ")
    return readLine()?.toIntOrNull() ?: 1
}