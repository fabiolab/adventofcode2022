package day02

import Day

val game: Map<String, Int> = mapOf("A X" to 4, "B X" to 1, "C X" to 7,"A Y" to 8, "B Y" to 5, "C Y" to 2,"A Z" to 3, "B Z" to 9, "C Z" to 6)

val gameWithEndings: Map<String, Int> = mapOf("A A" to 4, "A B" to 8, "A C" to 3,"B A" to 1, "B B" to 5, "B C" to 9,"C A" to 7, "C B" to 2, "C C" to 6)
val getLoose: Map<Char, Char> = mapOf('A' to 'C', 'B' to 'A', 'C' to 'B')
val getWin:  Map<Char, Char> = mapOf('C' to 'A', 'A' to 'B', 'B' to 'C')
val getDraw:  Map<Char, Char> = mapOf('A' to 'A', 'B' to 'B', 'C' to 'C')

val getResult: Map<Char, Map<Char, Char>> = mapOf(
    'X' to getLoose, 'Y' to getDraw, 'Z' to getWin
)

class Day02(override var dayNumber: Int, override var data: String) : Day {
    override fun resolveFirstStar(): Int {
        return data.split("\n").sumOf { game[it] ?: 0 }
    }

    override fun resolveSecondStar(): Int {
        return data.split("\n").filter { el -> el != "" }.map{ el -> "${el[0]} ${getResult[el[2]]?.get(el[0])}" }.sumOf { gameWithEndings[it] ?: 0 }
    }
}