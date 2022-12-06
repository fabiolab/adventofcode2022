package day03

import Day

fun Char.getItemValue(): Int {
    return if (code < 91) {
        code - 38
    } else {
        code - 96
    }
}

fun getBadge(groupPacks: List<String>) : Char {
    var resultSet: Set<Char> = groupPacks[0].toSet()
    for (pack in groupPacks) {
        resultSet = resultSet.intersect(pack.toSet())
    }
    return resultSet.first()
}

class Day03(override var dayNumber: Int, override var data: String) : Day {
    private fun getPackItem(pack: String) : Int {
        val pack1 = pack.dropLast(pack.length/2)
        val pack2 = pack.drop(pack.length/2)
        return pack1.toSet().intersect(pack2.toSet()).sumOf { it.getItemValue() }
    }
    override fun resolveFirstStar(): Int {
        return data.split('\n').filter { it.isNotEmpty() }.sumOf { getPackItem(it) }
    }

    override fun resolveSecondStar(): Int {
        return data.split('\n').filter { it.isNotEmpty() }.chunked(3).sumOf { getBadge(it).getItemValue() }
    }
}