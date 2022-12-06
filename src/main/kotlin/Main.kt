import day01.Day01
import day02.Day02
import day03.Day03

fun main() {
	val day = Day03(dayNumber = 3, "")
	var response = day.resolvePuzzle(Star.FIRST_STAR)
	println(response)
	response = day.resolvePuzzle(Star.SECOND_STAR)
	println(response)

}

