package practice.books

fun main() {
    val allBooks = setOf("book 1", "Hamlet", "book 3")

    val library =  allBooks.map {
        it to "Shakespeare"
    }

    println(library.any {
        it.first == "Hamlet"
    })

    val moreBooks = mutableMapOf("book" to "Evi")
    (moreBooks.getOrPut("paps") {"Evi" })
}