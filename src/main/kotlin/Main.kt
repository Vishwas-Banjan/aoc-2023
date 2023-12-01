import day1.Trebuchet

fun main(args: Array<String>) {
    day1()
}

private fun day1() {
    val value = Trebuchet.processCalibrationValue(DAY_1_INPUT)
    println("sum of all of the calibration values $value")
}
