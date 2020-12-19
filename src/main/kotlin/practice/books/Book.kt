package practice.books

open class Book(val title: String, val author: String) {
    private var currentPage = 1
    open fun readPage() {
        currentPage += 1
    }
}

class Ebook(title: String, author: String, var format: String = "text"): Book(title, author) {
    private var wordCount = 1
    override fun readPage() {
        super.readPage()
        wordCount += 250
    }
}