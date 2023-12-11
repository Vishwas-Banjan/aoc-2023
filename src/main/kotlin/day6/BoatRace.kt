package day6

object BoatRace {
    fun getNumOfWays(input: String): Long {
        var total = 1L
        val timeToDistanceMap = parseInputToMap(input)
        timeToDistanceMap.map { (time, distance) ->
            total *= findNumOfWays(time, distance)
        }
        return total
    }

    private fun findNumOfWays(time: Long, distanceToBeat: Long): Long {
        var count: Long = 0
        val halfTime: Long = time / 2
        for (i in halfTime downTo 0) {
            if (i * (time - i) > distanceToBeat) count++
            else break
        }
        val totalWays = (count * 2L)
        val adjustedTotal = if (isOdd(time)) totalWays else totalWays - 1
        return adjustedTotal
    }

    private fun isOdd(number: Long): Boolean {
        return number % 2 != 0L
    }

    private fun parseInputToMap(input: String): Map<Long, Long> {
        val lines = input.lines()
        val time = lines[0].substringAfter("Time:").split(" ").filter { it.isNotBlank() }.map { it.toLong() }
        val distance = lines[1].substringAfter("Distance:").split(" ").filter { it.isNotBlank() }.map { it.toLong() }
        return time.zip(distance).toMap()
    }

}