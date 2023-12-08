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
            println("seedRange: $seedRange")
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

    private fun MutableMap<LongRange, LongRange>.getValueForCustomKey(key: Long): Long {
        val range = this.keys.find { keyRange ->
            keyRange.contains(key)
        } ?: return key
        val offset = key - range.first
        val valueRange = this[range]!!
        return valueRange.first + offset
    }

    private fun createExpandedMap(srcToDestMap: List<List<Long>>): MutableMap<LongRange, LongRange> {
        return mutableMapOf<LongRange, LongRange>().apply {
            srcToDestMap.forEach {
                val destStart = it[0]
                val srcStart = it[1]
                val range = it[2] - 1

                this[LongRange(srcStart, srcStart + range)] = LongRange(destStart, destStart + range)
            }
        }
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
}
