package day1

object Trebuchet {
    fun processCalibrationValue(input: String): Int {
        return input.lines().sumOf { getCalibrationValueForLine(it) }
    }

    private fun getCalibrationValueForLine(input: String): Int {
        val indexOfFirstDigit = input.indexOfFirst { it.isDigit() }
        val firstDigit = (if (indexOfFirstDigit >= 0) input[indexOfFirstDigit] else -1).toString().toInt()
        val findFirstSpelledDigitRes = input.firstSpelledDigitIndexed()

        val indexOfLastDigit = input.indexOfLast { it.isDigit() }
        val lastDigit = (if (indexOfLastDigit >= 0) input[indexOfLastDigit] else -1).toString().toInt()
        val findLastSpelledDigitRes = input.lastSpelledDigitIndexed()

        val firstNum = firstValidPair(indexOfFirstDigit to firstDigit, findFirstSpelledDigitRes).second
        val lastNum = lastValidPair(indexOfLastDigit to lastDigit, findLastSpelledDigitRes).second

        return (firstNum * 10) + lastNum
    }

    private fun firstValidPair(thiz: Pair<Int, Int>, that: Pair<Int, Int>): Pair<Int, Int> {
        return findValidPair(thiz, that) { a, b -> a < b }
    }

    private fun lastValidPair(thiz: Pair<Int, Int>, that: Pair<Int, Int>): Pair<Int, Int> {
        return findValidPair(thiz, that) { a, b -> a > b }
    }

    private fun findValidPair(
        thiz: Pair<Int, Int>,
        that: Pair<Int, Int>,
        compare: (Int, Int) -> Boolean
    ): Pair<Int, Int> {
        return if (that.first < 0 || compare(thiz.first, that.first)) {
            thiz
        } else {
            that
        }
    }

    private val mapOfSpelledDigit = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
        "zero" to 0
    )

    private fun String.firstSpelledDigitIndexed(): Pair<Int, Int> {
        val findRes = this.findAnyOf(mapOfSpelledDigit.keys)
        return (findRes?.first ?: -1) to (mapOfSpelledDigit[findRes?.second] ?: -1)
    }

    private fun String.lastSpelledDigitIndexed(): Pair<Int, Int> {
        val findRes = this.findLastAnyOf(mapOfSpelledDigit.keys, ignoreCase = true)
        return (findRes?.first ?: -1) to (mapOfSpelledDigit[findRes?.second] ?: -1)
    }
}