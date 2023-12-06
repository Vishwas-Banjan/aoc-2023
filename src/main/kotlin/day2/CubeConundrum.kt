package day2


object CubeConundrum {
    fun sumGameIDs(input: String, condition: String): Int {
        val conditionMap = getConditionMap(condition)
        return input.lines().sumOf { processCubes(it, conditionMap) }
    }

    fun sumPowerSets(input: String): Int {
        return input.lines().sumOf { processCubesPower(it) }
    }

    private fun processCubesPower(input: String): Int {
        var power = 1
        // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        val inputSplit = input.split(":")
        getMaxInputColorMap(inputSplit[1]).values.forEach { // [blue: 6, red: 4, green: 2]
            power *= it // 6 * 4 * 2
        }
        return power
    }

    private fun processCubes(input: String, condition: Map<String, Int>): Int {
        // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        val inputSplit = input.split(":")
        val gameID = inputSplit[0].split(" ")[1].toInt() // 1
        val maxInputColorMap = getMaxInputColorMap(inputSplit[1]) // [blue: 6, red: 4, green: 2]
        return if (condition.keys.all { color -> (maxInputColorMap[color] ?: 0) <= (condition[color] ?: 0) }) {
            gameID
        } else {
            0
        }
    }

    private fun getMaxInputColorMap(inputSplit: String): Map<String, Int> {
        val map = mutableMapOf<String, Int>()
        // 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        val cubesList = inputSplit.split(";")  // ["3 blue, 4 red", "1 red, 2 green", "6 blue, 2 green"]
        cubesList.map { shownCubes -> // 3 blue, 4 red
            val showCubesSplit = shownCubes.split(",")
            val cubes = showCubesSplit.map { cube -> cube.trim() } // [3 blue, 4 red]
            cubes.forEach { cube ->
                val cubeSplit = cube.split(" ")
                val count = cubeSplit[0].toInt()
                val color = cubeSplit[1]
                map[color] = maxOf(map[color] ?: 0, count)
            }
        }

        return map.toSortedMap() // [blue: 6, red: 4, green: 2]
    }

    private fun getConditionMap(input: String): Map<String, Int> {
        val map = mutableMapOf<String, Int>()
        // 12 red cubes, 13 green cubes, and 14 blue
        val conditionSplit = input.split(",") // [12 red cubes, 13 green cubes, 14 blue]
        conditionSplit.map { condition ->
            val subConditionSplit = condition.trim().split(" ") // [12, red, cubes]
            val count = subConditionSplit[0].toInt() // 12
            val color = subConditionSplit[1] // red
            map[color] = count
        }
        return map.toSortedMap()
    }

}