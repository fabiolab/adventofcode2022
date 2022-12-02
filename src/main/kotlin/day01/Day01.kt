package day01

import Day


class Day01(override var dayNumber: Int, override var data: String) : Day {
    override fun resolveFirstStar(): Int {
        return data.split("\n\n").maxOfOrNull { it.split('\n').sumOf { e -> e.toInt() } } ?: 0
    }

    override fun resolveSecondStar(): Int {
        return data.split("\n\n").map { it.split('\n').sumOf { e -> e.toInt() } }.sortedDescending().take(3).sum()
    }
}