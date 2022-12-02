import day01.Day01

fun main() {
	val day = Day01(dayNumber = 1, "")
	var response = day.resolvePuzzle(Star.FIRST_STAR)
	println(response)
	response = day.resolvePuzzle(Star.SECOND_STAR)
	println(response)

}

