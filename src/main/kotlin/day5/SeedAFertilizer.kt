package day5

object SeedAFertilizer {
    fun getLowestLocationPart1(input: String): Long {

        val rawAlmanacData = parseInputString(input)
        val seeds = rawAlmanacData.seeds
        val seedToSoilMap = createExpandedMap(rawAlmanacData.seedToSoilMap)
        val soilToFertilizerMap = createExpandedMap(rawAlmanacData.soilToFertilizerMap)
        val fertilizerToWaterMap = createExpandedMap(rawAlmanacData.fertilizerToWaterMap)
        val waterToLightMap = createExpandedMap(rawAlmanacData.waterToLightMap)
        val lightToTemperatureMap = createExpandedMap(rawAlmanacData.lightToTemperatureMap)
        val temperatureToHumidityMap = createExpandedMap(rawAlmanacData.temperatureToHumidityMap)
        val humidityToLocationMap = createExpandedMap(rawAlmanacData.humidityToLocationMap)

        return seeds.minOf { seed ->
            val soil = seedToSoilMap.getValueForCustomKey(seed)
            val fertilizer = soilToFertilizerMap.getValueForCustomKey(soil)
            val water = fertilizerToWaterMap.getValueForCustomKey(fertilizer)
            val light = waterToLightMap.getValueForCustomKey(water)
            val temperature = lightToTemperatureMap.getValueForCustomKey(light)
            val humidity = temperatureToHumidityMap.getValueForCustomKey(temperature)
            val location = humidityToLocationMap.getValueForCustomKey(humidity)
            location
        }
    }

    fun getLowestLocationPart2(input: String): Long {
        val rawAlmanacData = parseInputString(input)
        val seeds = createRangedSeedMap(rawAlmanacData.seeds)
        val seedToSoilMap = createExpandedMap(rawAlmanacData.seedToSoilMap)
        val soilToFertilizerMap = createExpandedMap(rawAlmanacData.soilToFertilizerMap)
        val fertilizerToWaterMap = createExpandedMap(rawAlmanacData.fertilizerToWaterMap)
        val waterToLightMap = createExpandedMap(rawAlmanacData.waterToLightMap)
        val lightToTemperatureMap = createExpandedMap(rawAlmanacData.lightToTemperatureMap)
        val temperatureToHumidityMap = createExpandedMap(rawAlmanacData.temperatureToHumidityMap)
        val humidityToLocationMap = createExpandedMap(rawAlmanacData.humidityToLocationMap)

        fun getLocationForSeed(seed: Long): Long {
            val soil = seedToSoilMap.getValueForCustomKey(seed)
            val fertilizer = soilToFertilizerMap.getValueForCustomKey(soil)
            val water = fertilizerToWaterMap.getValueForCustomKey(fertilizer)
            val light = waterToLightMap.getValueForCustomKey(water)
            val temperature = lightToTemperatureMap.getValueForCustomKey(light)
            val humidity = temperatureToHumidityMap.getValueForCustomKey(temperature)
            val location = humidityToLocationMap.getValueForCustomKey(humidity)
            return location
        }

        return seeds.minOf { seedRange ->
            seedRange.minOf { seed ->
                getLocationForSeed(seed)
            }
        }
    }

    private fun createRangedSeedMap(seeds: List<Long>): List<LongRange> {
        return mutableListOf<LongRange>().apply {
            seeds.chunked(2).forEach {
                val start = it[0]
                val range = it[1] - 1
                this.add(LongRange(start, start + range))
            }
        }
    }

    private fun IntervalTree.getValueForCustomKey(key: Long): Long {
        return findValueForKey(key)
    }

    private fun createExpandedMap(srcToDestMap: List<List<Long>>): IntervalTree {
        val intervalTree = IntervalTree()

        srcToDestMap.forEach {
            val destStart = it[0]
            val srcStart = it[1]
            val range = it[2] - 1

            val srcRange = LongRange(srcStart, srcStart + range)
            val destRange = LongRange(destStart, destStart + range)

            intervalTree.insert(srcRange, destRange)
        }

        return intervalTree
    }

    private fun parseInputString(input: String): RawAlmanacData {
        val seeds =
            input.substringAfter("seeds:").substringBefore("seed-to-soil map:").trim().split(" ").map { it.toLong() }
        val seedToSoilMap =
            input.substringAfter("seed-to-soil map:").substringBefore("soil-to-fertilizer map:").trim().split("\n")
                .map { it.trim().split(" ").map { it.toLong() } }
        val soilToFertilizerMap =
            input.substringAfter("soil-to-fertilizer map:").substringBefore("fertilizer-to-water map:").trim()
                .split("\n")
                .map { it.trim().split(" ").map { it.toLong() } }
        val fertilizerToWaterMap =
            input.substringAfter("fertilizer-to-water map:").substringBefore("water-to-light map:").trim().split("\n")
                .map { it.trim().split(" ").map { it.toLong() } }
        val waterToLightMap =
            input.substringAfter("water-to-light map:").substringBefore("light-to-temperature map:").trim().split("\n")
                .map { it.trim().split(" ").map { it.toLong() } }
        val lightToTemperatureMap =
            input.substringAfter("light-to-temperature map:").substringBefore("temperature-to-humidity map:").trim()
                .split("\n").map { it.trim().split(" ").map { it.toLong() } }
        val temperatureToHumidityMap =
            input.substringAfter("temperature-to-humidity map:").substringBefore("humidity-to-location map:").trim()
                .split("\n").map { it.trim().split(" ").map { it.toLong() } }
        val humidityToLocationMap = input.substringAfter("humidity-to-location map:").trim().split("\n")
            .map { it.trim().split(" ").map { it.toLong() } }

        return RawAlmanacData(
            seeds,
            seedToSoilMap,
            soilToFertilizerMap,
            fertilizerToWaterMap,
            waterToLightMap,
            lightToTemperatureMap,
            temperatureToHumidityMap,
            humidityToLocationMap
        )
    }

    data class RawAlmanacData(
        val seeds: List<Long>,
        val seedToSoilMap: List<List<Long>>,
        val soilToFertilizerMap: List<List<Long>>,
        val fertilizerToWaterMap: List<List<Long>>,
        val waterToLightMap: List<List<Long>>,
        val lightToTemperatureMap: List<List<Long>>,
        val temperatureToHumidityMap: List<List<Long>>,
        val humidityToLocationMap: List<List<Long>>
    )

    class IntervalTree {
        data class Node(
            val range: LongRange,
            var valueRange: LongRange,
            var left: Node? = null,
            var right: Node? = null
        )

        private var root: Node? = null

        fun insert(range: LongRange, valueRange: LongRange) {
            root = insert(root, range, valueRange)
        }

        private fun insert(node: Node?, range: LongRange, valueRange: LongRange): Node {
            if (node == null) {
                return Node(range, valueRange, null, null)
            }

            val cmp = compareRanges(range, node.range)

            if (cmp < 0) {
                node.left = insert(node.left, range, valueRange)
            } else {
                node.right = insert(node.right, range, valueRange)
            }

            return node
        }

        fun findValueForKey(key: Long): Long {
            return findValueForKey(root, key)
        }

        private fun findValueForKey(node: Node?, key: Long): Long {
            if (node == null) {
                return key
            }

            val cmp = compareKeyToRange(key, node.range)

            return when {
                cmp < 0 -> findValueForKey(node.left, key)
                cmp > 0 -> findValueForKey(node.right, key)
                else -> node.valueRange.first + (key - node.range.first)
            }
        }

        private fun compareRanges(range1: LongRange, range2: LongRange): Int {
            return compareValues(range1.first, range2.first)
        }

        private fun compareKeyToRange(key: Long, range: LongRange): Int {
            val first = range.first
            val last = range.last
            return if (key in first..last) 0 else if (key < first) -1 else 1
        }

        fun printTree() {
            printTree(root)
        }

        private fun printTree(node: Node?) {
            if (node != null) {
                printTree(node.left)
                println("Range: ${node.range}, Value Range: ${node.valueRange}")
                printTree(node.right)
            }
        }
    }

}
