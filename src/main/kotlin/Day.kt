import java.io.File
import java.io.IOException

enum class Star(val number: Int) {
    FIRST_STAR(1),
    SECOND_STAR(2)
}

interface Day {
    var dayNumber: Int
    var data: String

    fun resolvePuzzle(star: Star): Int {
        loadData(star)
        return if (star == Star.FIRST_STAR) {
            resolveFirstStar()
        } else {
            resolveSecondStar()
        }
    }

    fun resolveFirstStar(): Int

    fun resolveSecondStar(): Int

    private fun loadData(star: Star) {
        try {
            data = File("src/main/resources/data${dayNumber}s${star.number}.txt").readText(Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
