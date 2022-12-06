package day04

import Day

fun String.getSection(): Section {
    val bounds = split('-').map { it.toInt() }
    return Section(bounds[0], bounds[1])
}

data class Section(val min: Int, val max: Int) {
    fun overlap(section: Section): Boolean {
        return (section.min >= min).and(section.max <= max).or((section.min <= min).and(section.max >= max))
    }

    fun partialOverlap(section: Section): Boolean {
        return (section.min..section.max).contains(min)
            .or((section.min..section.max).contains(max))
            .or((min..max).contains(section.min))
            .or((min..max).contains(section.max))

    }
}

fun overlap(sections: List<Section>): Boolean {
    return sections[0].overlap(sections[1])
}

fun partialOverlap(sections: List<Section>): Boolean {
    return sections[0].partialOverlap(sections[1])
}

class Day04(override var dayNumber: Int = 4, override var data: String) : Day {
    override fun resolveFirstStar(): Int {
        return data.split('\n')
            .filter { it.isNotEmpty() }
            .map { l -> overlap(l.split(',').map { it.getSection() }) }
            .filter { b -> b }.size
    }

    override fun resolveSecondStar(): Int {
        return data.split('\n')
            .filter { it.isNotEmpty() }
            .map { l -> partialOverlap(l.split(',').map { it.getSection() }) }
            .filter { b -> b }.size
    }
}