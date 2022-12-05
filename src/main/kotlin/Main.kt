import day01.Day01
import day02.Day02

fun main() {
	val day = Day02(dayNumber = 2, "")
	var response = day.resolvePuzzle(Star.FIRST_STAR)
	println(response)
	response = day.resolvePuzzle(Star.SECOND_STAR)
	println(response)

}

