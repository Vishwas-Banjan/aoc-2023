package day3

object GearRatios {
    fun sumOfEnginePartsSchematic1(input: String): Int {
        val inputArray = inputTo2DArray(input)
        return getValidPartNumbersSum(inputArray)
    }

    fun sumOfEnginePartsSchematic2(input: String, conditionChar: Char): Int {
        val inputArray = inputTo2DArray(input)
        return getValidPartNumbersSum(inputArray, conditionChar)
    }

    private fun getValidPartNumbersSum(input: Array<CharArray>, conditionChar: Char): Int {
        val partNumCoords = mapPartNumCoords(input)
        var validPartTotal = 0
        input.forEachIndexed { rowIndex, chars ->
            chars.forEachIndexed { columnIndex, c ->
                if (c == conditionChar) {
                    var totalAdjacent = 0
                    var valueTotal = 1
                    val adjacentCoords = getAdjacentCoordinates(rowIndex, columnIndex)

                    adjacentCoords.map { (row, column) ->
                        partNumCoords[row to column]
                    }.distinct().forEach { numberCoords ->
                        if (numberCoords != null) {
                            totalAdjacent++
                            val _row = numberCoords.first
                            val _columnIndexRange = numberCoords.second
                            val numberValue = input[_row].slice(_columnIndexRange).joinToString("").toInt()
                            valueTotal *= numberValue
                        }
                    }
                    if (totalAdjacent == 2) validPartTotal += valueTotal
                }
            }
        }
        return validPartTotal
    }

    private fun getValidPartNumbersSum(input: Array<CharArray>): Int {
        val partNumCoords = mapPartNumCoords(input)

        return partNumCoords.values.distinct().sumOf { (row, columnIndexRange) ->
            if (hasAdjacentSymbols(columnIndexRange, input, row)) {
                input[row].slice(columnIndexRange).joinToString("").toInt()
            } else 0
        }
    }

    private fun mapPartNumCoords(input: Array<CharArray>): MutableMap<Pair<Int, Int>, Pair<Int, IntRange>> {
        val partNumCoords =
            mutableMapOf<Pair<Int, Int>, Pair<Int, IntRange>>() // (row, column) -> (row, columnIndexRange)

        input.forEachIndexed { rowIndex, chars ->
            var startIndex: Int
            var endIndex: Int
            var columnIndex = 0

            while (columnIndex < chars.size) {
                var subColumnIndex = columnIndex
                val char = chars[columnIndex]
                if (char.isDigit()) {
                    startIndex = columnIndex
                    endIndex = columnIndex

                    while (subColumnIndex < chars.size && chars[subColumnIndex].isDigit()) {
                        endIndex = subColumnIndex
                        subColumnIndex++
                    }

                    val columnIndexRange = startIndex..endIndex
                    columnIndexRange.forEach {
                        partNumCoords[rowIndex to it] = rowIndex to columnIndexRange
                    }

                    columnIndex = subColumnIndex
                } else columnIndex++
            }
        }

        return partNumCoords
    }

    private fun hasAdjacentSymbols(indexRange: IntRange, input: Array<CharArray>, rowIndex: Int): Boolean {
        return indexRange.any { columnIndex ->
            input.getValidValues(*getAdjacentCoordinates(rowIndex, columnIndex).toTypedArray())
                .any { !it.isDigit() && it != '.' }
        }
    }

    private fun getAdjacentCoordinates(row: Int, column: Int): List<Pair<Int, Int>> {
        return listOf(
            -1 to -1, -1 to 0, -1 to 1, // top left, top, top right
            0 to -1, 0 to 1, // left, right
            1 to -1, 1 to 0, 1 to 1 // bottom left, bottom, bottom right
        ).map { (rowOffset, columnOffset) -> row + rowOffset to column + columnOffset }
    }

    private fun Array<CharArray>.getValidValues(vararg rowToColumnIndex: Pair<Int, Int>): List<Char> {
        val validValues = mutableListOf<Char>()

        rowToColumnIndex.forEach { (rowIndex, columnIndex) ->
            val value = this.getValidValueOrNull(rowIndex, columnIndex)
            if (value != null) {
                validValues.add(value)
            }
        }

        return validValues
    }

    private fun Array<CharArray>.getValidValueOrNull(row: Int, column: Int): Char? {
        val rows = this.size
        val columns = this[0].size

        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            return null
        }

        return this[row][column]
    }

    private fun inputTo2DArray(input: String): Array<CharArray> {
        val lines = input.lines()
        val rows = lines.size
        val columns = lines[0].length

        // Create a 2D array of characters
        val twoDArray = Array(rows) { CharArray(columns) { ' ' } }

        // Initialize the 2D array with characters from the input string
        for ((i, line) in lines.withIndex()) {
            for ((j, char) in line.withIndex()) {
                twoDArray[i][j] = char
            }
        }

        return twoDArray
    }
}