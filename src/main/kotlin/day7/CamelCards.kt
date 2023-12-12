package day7

object CamelCards {

    fun getTotalWinningsPart2(input: String): Int =
        getTotalWinnings(input) { handStr, bid -> getHandTypeRankingPart2(handStr, bid) }

    fun getTotalWinningsPart1(input: String): Int =
        getTotalWinnings(input) { handStr, bid -> getHandTypeRanking(handStr, bid) }

    private fun getTotalWinnings(input: String, processHand: (String, Int) -> ProcessedHand): Int {
        val handToBidMap = parseInput(input)
        val rankingList = mutableListOf<ProcessedHand>()
        var totalWinnings = 0
        handToBidMap.forEach { (hand, bid) ->
            val processedHand = processHand(hand, bid)
            rankingList.add(processedHand)
        }
        rankingList.sortWith(compareBy<ProcessedHand> { it.handType.rank }
            .thenBy { it.labelRankArray[0] }
            .thenBy { it.labelRankArray[1] }
            .thenBy { it.labelRankArray[2] }
            .thenBy { it.labelRankArray[3] }
            .thenBy { it.labelRankArray[4] })
        rankingList.forEachIndexed { index, hand ->
            totalWinnings += (index + 1) * hand.bid
        }
        return totalWinnings
    }

    private fun getHandTypeRankingPart2(hand: String, bid: Int): ProcessedHand {
        val charToCountMap = mutableMapOf<Char, Int>()
        val labelRankArray = IntArray(5)
        hand.forEachIndexed { index, char ->
            val count = charToCountMap[char] ?: 0
            charToCountMap[char] = count + 1
            labelRankArray[index] = labelRankPart2[char] ?: throw IllegalStateException("Invalid label: $char")
        }
        val handType = when (charToCountMap.size) {
            1 -> "Five of a Kind" // AAAAA
            2 -> {
                when {
                    charToCountMap.containsValue(4) && charToCountMap['J'] == 1 -> "Five of a Kind" // AAAAJ
                    charToCountMap.containsValue(4) && charToCountMap['J'] == 4 -> "Five of a Kind" // JJJJA
                    charToCountMap.containsValue(4) -> "Four of a Kind" // AAAAQ
                    charToCountMap.containsValue(3) && charToCountMap['J'] == 2 -> "Five of a Kind" // AAAJJ
                    charToCountMap.containsValue(3) && charToCountMap['J'] == 3 -> "Five of a Kind" // JJJAA
                    else -> "Full House"
                }
            }

            3 -> {
                when {
                    charToCountMap.containsValue(3) && charToCountMap['J'] == 1 -> "Four of a Kind" // AAABJ
                    charToCountMap.containsValue(3) && charToCountMap['J'] == 3 -> "Four of a Kind" // JJJAB
                    charToCountMap.containsValue(3) -> "Three of a Kind" // AAABC
                    charToCountMap.containsValue(2) && charToCountMap['J'] == 1 -> "Full House" // JQQAA
                    charToCountMap.containsValue(2) && charToCountMap['J'] == 2 -> "Four of a Kind" // QQJJB
                    else -> "Two Pair"
                }
            }

            4 -> {
                when {
                    charToCountMap.containsValue(2) && charToCountMap['J'] == 1 -> "Three of a Kind" // AABCJ
                    charToCountMap.containsValue(2) && charToCountMap['J'] == 2 -> "Three of a Kind" // JJBCA
                    else -> "One Pair"
                }
            }

            5 -> {
                when {
                    charToCountMap['J'] == 1 -> "One Pair" // KQT9J
                    else -> "High Card"
                }
            }

            else -> throw IllegalStateException("Invalid hand: $hand")
        }

        val handTypeRank = handRank[handType] ?: throw IllegalStateException("Invalid hand type: $handType")
        return ProcessedHand(hand, ProcessedHand.HandType(handType, handTypeRank), labelRankArray, bid)
    }

    private fun getHandTypeRanking(hand: String, bid: Int): ProcessedHand {
        val charToCountMap = mutableMapOf<Char, Int>()
        val labelRankArray = IntArray(5)
        hand.forEachIndexed { index, char ->
            val count = charToCountMap[char] ?: 0
            charToCountMap[char] = count + 1
            labelRankArray[index] = labelRank[char] ?: throw IllegalStateException("Invalid label: $char")
        }
        val handType = when (charToCountMap.size) {
            1 -> "Five of a Kind"
            2 -> if (charToCountMap.containsValue(4)) "Four of a Kind" else "Full House"
            3 -> if (charToCountMap.containsValue(3)) "Three of a Kind" else "Two Pair"
            4 -> "One Pair"
            5 -> "High Card"
            else -> throw IllegalStateException("Invalid hand: $hand")
        }
        val handTypeRank = handRank[handType] ?: throw IllegalStateException("Invalid hand type: $handType")
        return ProcessedHand(hand, ProcessedHand.HandType(handType, handTypeRank), labelRankArray, bid)
    }

    private val labelRankPart2 = mutableMapOf(
        'A' to 14,
        'K' to 13,
        'Q' to 12,
        'T' to 11,
        '9' to 10,
        '8' to 9,
        '7' to 8,
        '6' to 7,
        '5' to 6,
        '4' to 5,
        '3' to 4,
        '2' to 3,
        'J' to 2,
    )

    private val labelRank = mutableMapOf(
        'A' to 14,
        'K' to 13,
        'Q' to 12,
        'J' to 11,
        'T' to 10,
        '9' to 9,
        '8' to 8,
        '7' to 7,
        '6' to 6,
        '5' to 5,
        '4' to 4,
        '3' to 3,
        '2' to 2
    )

    private val handRank = mutableMapOf(
        "Five of a Kind" to 7,
        "Four of a Kind" to 6,
        "Full House" to 5,
        "Three of a Kind" to 4,
        "Two Pair" to 3,
        "One Pair" to 2,
        "High Card" to 1
    )

    data class ProcessedHand(val value: String, val handType: HandType, val labelRankArray: IntArray, val bid: Int) {
        data class HandType(val type: String, val rank: Int)

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ProcessedHand

            if (value != other.value) return false
            if (handType != other.handType) return false
            if (!labelRankArray.contentEquals(other.labelRankArray)) return false
            if (bid != other.bid) return false

            return true
        }

        override fun hashCode(): Int {
            var result = value.hashCode()
            result = 31 * result + handType.hashCode()
            result = 31 * result + labelRankArray.contentHashCode()
            result = 31 * result + bid
            return result
        }

    }

    private fun parseInput(input: String): Map<String, Int> {
        return input.trim().lines().associate {
            val split = it.split(" ")
            val hand = split[0]
            val bid = split[1].toInt()
            hand to bid
        }
    }
}