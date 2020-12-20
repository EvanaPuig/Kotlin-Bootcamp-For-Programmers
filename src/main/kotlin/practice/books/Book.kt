package practice.books

fun main(){
    var book = Book("PAPS", "Evana", 2020)
    val bookTitleAndAuthor = book.getTitleAndAuthor()
    val bookTitleAuthorAndYear = book.getAuthorTitleYear()


    println("Here is your book ${bookTitleAndAuthor.first} by ${bookTitleAndAuthor.second}")

    println("Here is your book ${bookTitleAuthorAndYear.first} " +
            "by ${bookTitleAuthorAndYear.second} written in ${bookTitleAuthorAndYear.third}")

}

open class Book(val title: String, val author: String, val year: Int) {
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
}

class Ebook(title: String, author: String, year: Int, var format: String = "text"): Book(title, author, year) {
    private var wordCount = 1
    override fun readPage() {
        super.readPage()
        wordCount += 250
    }
}

