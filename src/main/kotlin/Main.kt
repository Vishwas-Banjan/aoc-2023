import day1.Trebuchet
import day2.CubeConundrum
import day2.DAY_2_INPUT
import day3.DAY_3_INPUT
import day3.DAY_3_TEST_INPUT
import day3.GearRatios

fun main(args: Array<String>) {
    day3()
}

private fun day1() {
    val value = Trebuchet.processCalibrationValue(DAY_1_INPUT)
    println("sum of all of the calibration values $value")
}

private fun day2(){
    val value =  CubeConundrum.sumGameIDs(DAY_2_INPUT, "12 red cubes, 13 green cubes, 14 blue")
    println("sum of all of the game IDs $value")

    val part2 = CubeConundrum.sumPowerSets(DAY_2_INPUT)
    println("sum of all of the power sets $part2")
}

private fun day3(){
    val value = GearRatios.sumOfEnginePartsSchematic1(DAY_3_INPUT)
    println("Part 1: sum of all of the engine parts $value")
    val part2 = GearRatios.sumOfEnginePartsSchematic2(DAY_3_INPUT, '*')
    println("Part 2: sum of all of the engine parts $part2")
}