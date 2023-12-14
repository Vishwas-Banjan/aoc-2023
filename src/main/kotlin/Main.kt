import day1.Trebuchet
import day2.CubeConundrum
import day2.DAY_2_INPUT
import day3.DAY_3_INPUT
import day3.GearRatios
import day4.DAY_4_INPUT
import day4.Scratchcards
import day5.DAY_5_INPUT
import day5.SeedAFertilizer
import day6.*
import day7.CamelCards
import day7.DAY_7_INPUT
import day7.DAY_7_TEST_INPUT
import day8.*

fun main() {
    day8()
}

private fun day1() {
    val value = Trebuchet.processCalibrationValue(DAY_1_INPUT)
    println("sum of all of the calibration values $value")
}

private fun day2() {
    val value = CubeConundrum.sumGameIDs(DAY_2_INPUT, "12 red cubes, 13 green cubes, 14 blue")
    println("sum of all of the game IDs $value")

    val part2 = CubeConundrum.sumPowerSets(DAY_2_INPUT)
    println("sum of all of the power sets $part2")
}

private fun day3() {
    val value = GearRatios.sumOfEnginePartsSchematic1(DAY_3_INPUT)
    println("Part 1: sum of all of the engine parts $value")
    val part2 = GearRatios.sumOfEnginePartsSchematic2(DAY_3_INPUT, '*')
    println("Part 2: sum of all of the engine parts $part2")
}

private fun day4() {
    val value = Scratchcards.calculateScratchcardPrizes(DAY_4_INPUT)
    println("Part 1: sum of all of the scratchcard prizes $value")

    val part2 = Scratchcards.calculateTotalScratchcards(DAY_4_INPUT)
    println("Part 2: sum of all of the scratchcard prizes $part2")
}

private fun day5() {
    val value = SeedAFertilizer.getLowestLocationPart1(DAY_5_INPUT)
    println("Part 1: lowest location $value")

    val part2 = SeedAFertilizer.getLowestLocationPart2(DAY_5_INPUT)
    println("Part 2: lowest location $part2")
}

private fun day6() {
    val value = BoatRace.getNumOfWays(DAY_6_INPUT_PART2)
    println("ways you can beat the record $value")
}

private fun day7() {
    val value = CamelCards.getTotalWinningsPart1(DAY_7_INPUT)
    println("Part1: total winnings $value")

    val part2 = CamelCards.getTotalWinningsPart2(DAY_7_INPUT)
    println("Part2: total winnings $part2")
}

private fun day8() {
    val value = HauntedWasteland.getStepsRequired(DAY_8_INPUT)
    println("Part1: total steps $value")

    val part2 = HauntedWasteland.getStepsRequiredPart2(DAY_8_INPUT)
    println("Part2: total steps $part2")
}