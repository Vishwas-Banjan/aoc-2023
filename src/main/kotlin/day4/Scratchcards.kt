package day4

import kotlin.math.pow

object Scratchcards {
    fun calculateScratchcardPrizes(input: String): Int {
        val power = 2.0
        return input.lines().sumOf {
            val count = calculatePrizeForGame(it).second
            val exponent = count - 1.0
            if (count == 0) 0.0 else ((power).pow(exponent))
        }.toInt()
    }

    fun calculateTotalScratchcards(input: String): Int {
        val carNumCount = mutableMapOf<Int, Int>()

        input.lines().forEach {
            val (cardNumber, winningCount) = calculatePrizeForGame(it)
            carNumCount[cardNumber] = carNumCount.getOrDefault(cardNumber, 0) + winningCount
        }

        val totalCount = mutableMapOf<Int, Int>()
        carNumCount.forEach { (cardNum, _) ->
            calculateTotalCards(cardNum, totalCount, carNumCount)
        }

        return totalCount.values.sum()
    }

    private fun calculateTotalCards(
        cardNum: Int,
        totalCount: MutableMap<Int, Int>,
        cardNumCount: MutableMap<Int, Int>
    ) {
        val winningCount = cardNumCount[cardNum] ?: 0
        repeat(winningCount) { countIndex ->
            calculateTotalCards(cardNum + countIndex + 1, totalCount, cardNumCount)
        }
        totalCount[cardNum] = totalCount.getOrDefault(cardNum, 0) + 1
    }


    private fun calculatePrizeForGame(input: String): Pair<Int, Int> {
        // "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"

        val parts = input.split(":")
        val numberParts = parts[1].split("|")

        val cardNumber = parts[0].trim().split(" ").filter { it.isNotBlank() }[1].toInt()
        val winningNumbers = numberParts[0].trim().split(" ").filter { it.isNotBlank() }
        val scratchcardNumbers = numberParts[1].trim().split(" ").filter { it.isNotBlank() }

        val winningScratchCardNumbers = scratchcardNumbers.count { it in winningNumbers }

        return cardNumber to winningScratchCardNumbers
    }
}