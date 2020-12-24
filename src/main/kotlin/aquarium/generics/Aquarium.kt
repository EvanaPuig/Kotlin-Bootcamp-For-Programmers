package aquarium.generics

fun main() {
    genericExample()
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if(waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }

        println("adding water from $waterSupply")
    }

    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    /*
    val aquarium2 = Aquarium("string")
    println(aquarium2.waterSupply)

    val aquarium3 = Aquarium(null)
    println(aquarium3.waterSupply)

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()
     */

    val aquarium5 = Aquarium(TapWater())
    addItemTo(aquarium5)
    aquarium.addWater(cleaner)
    isWaterClean(aquarium5)
    println(aquarium5.hasWaterSupplyOfType<TapWater>()) //true
    println(aquarium5.waterSupply.isOfType<LakeWater>()) // false
}