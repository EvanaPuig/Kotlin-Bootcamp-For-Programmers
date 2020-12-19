package aquarium

fun main() {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color $pleco.color")
    pleco.eat()
}

interface FishAction2 {
    fun eat()
}

interface FishColor2 {
    val color: String
}

class Plecostomus2(fishColor2: FishColor2 = GoldColor):
    FishAction2 by PrintingFishAction("a lot of algae"),
    FishColor2 by fishColor2

object GoldColor: FishColor2 {
    override val color = "gold"
}

object RedColor: FishColor2 {
    override val color = "red"
}

class PrintingFishAction(val food: String): FishAction2 {
    override fun eat() {
        println(food)
    }
}
