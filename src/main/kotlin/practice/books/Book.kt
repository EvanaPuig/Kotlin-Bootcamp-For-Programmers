package practice.books

import kotlin.random.Random

fun main(){
    var book = Book("PAPS", "Evana", 2020, 800)
    val bookTitleAndAuthor = book.getTitleAndAuthor()
    val bookTitleAuthorAndYear = book.getAuthorTitleYear()


    println("Here is your book ${bookTitleAndAuthor.first} by ${bookTitleAndAuthor.second}")

    println("Here is your book ${bookTitleAuthorAndYear.first} " +
            "by ${bookTitleAuthorAndYear.second} written in ${bookTitleAuthorAndYear.third}")

    val puppy = Puppy()

    while (book.pageCount >= 0) {
        puppy.playWithBook(book)
        println("page Count: " + book.pageCount)
    }


}

open class Book(val title: String, val author: String, val year: Int, var pageCount: Int) {
    private var currentPage = 1

    open fun readPage() {
        currentPage += 1
    }

    fun getTitleAndAuthor(): Pair<String, String>{
        return title to author
    }

    fun getAuthorTitleYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBurrow(currentNumberOfBooks: Int): Boolean {
        return currentNumberOfBooks < MAX_NUMBER_OF_BORROWABLE_BOOKS
    }

    fun printUrl(nameOfBook: String): String {
        return "$BASE_URL$nameOfBook.html"
    }

    fun tornPages(numberOfTornPages: Int) {
        pageCount -= numberOfTornPages
    }

    companion object  {
        const val MAX_NUMBER_OF_BORROWABLE_BOOKS = 2
        const val BASE_URL = "http://mybook.com/"
    }
}

fun Book.getWeight(): Double {
    return pageCount * 1.5
}

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random.nextInt(12))
    }
}

class Ebook(title: String, author: String, year: Int, var format: String = "text", pageCount: Int): Book(title, author, year, pageCount) {
    private var wordCount = 1
    override fun readPage() {
        super.readPage()
        wordCount += 250
    }
}

