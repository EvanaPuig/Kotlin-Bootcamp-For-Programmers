fun main() {
    println(whatShouldIDoToday(getMood()))
}

fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {
    return when {
        isGoodDayForOutside(mood, weather) -> "go for a walk"
        isBedDay(mood, weather, temperature) -> "stay in bed"
        isSwimmingDay(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun isGoodDayForOutside(mood: String, weather: String) = mood == "happy" && weather == "Sunny"
fun isBedDay(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isSwimmingDay(temperature: Int) = temperature > 35

fun getMood(): String {
    print("Enter your mood ")
    return readLine()?: "sad"
}