import day1.Trebuchet
import day2.CubeConundrum
import day2.DAY_2_INPUT
import day2.DAY_2_TEST_INPUT

fun main(args: Array<String>) {
    day2()
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