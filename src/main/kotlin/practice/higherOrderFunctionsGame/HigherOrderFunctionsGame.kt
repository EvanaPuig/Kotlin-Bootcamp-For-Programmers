package practice.higherOrderFunctionsGame

fun main() {
    val game = Game()
    /*println(game.path)
    game.north()
    game.east()
    game.south()
    game.west()
    game.end()
    println(game.path)*/

    while(true) {
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
        println(game.path)
    }
}

enum class Direction {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf(Direction.START)

    val north = {
        path.add(Direction.NORTH)
    }

    val south = {
        path.add(Direction.SOUTH)
    }

    val east = {
        path.add(Direction.EAST)
    }

    val west = {
        path.add(Direction.WEST)
    }

    val end = {
        path.add(Direction.END)
        println("Game Over")
        println(path)
        path.clear()
        false
    }

    fun move(where: () -> Boolean) {
        where.invoke()
    }

    fun makeMove(move: String?) {
        if (move == "n") {
            move(north)
        } else if (move == "s") {
            move(south)
        } else if (move == "e") {
            move(east)
        } else if (move == "w") {
            move(west)
        } else {
            move(end)
        }
    }
}

