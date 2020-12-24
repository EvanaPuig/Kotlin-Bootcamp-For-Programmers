package practice.buildings

fun main() {
    val building1 = Building(Wood())
    building1.build()

    isSmallBuilding(Building(Brick()))
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)

class Brick: BaseBuildingMaterial(8)

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>){
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("large building")
}

class Building<T: BaseBuildingMaterial>(private val baseBuildingMaterial: T) {
    private val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded = baseBuildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("This building is made of ${baseBuildingMaterial::class.simpleName} " +
                "and it needs $actualMaterialsNeeded pieces of this material")
    }
}