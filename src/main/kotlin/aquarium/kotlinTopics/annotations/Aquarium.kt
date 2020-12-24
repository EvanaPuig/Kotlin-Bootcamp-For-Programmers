package aquarium.kotlinTopics.annotations

fun main() {
    reflections()
}

@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}
}

annotation class ImAPlant

fun reflections() {
    val classObj = Plant::class

    /*
    for (method in classObj.members) {
        println(method.name)
    }
     */

    // print all annotations
    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
    }

    // find one annotation, or null
    // val annotated = classObj.findAnnotation<ImpAPlant>
}