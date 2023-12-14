package day8

import util.ReadFile

const val DAY_8_TEST_INPUT = "RL\n" +
        "\n" +
        "AAA = (BBB, CCC)\n" +
        "BBB = (DDD, EEE)\n" +
        "CCC = (ZZZ, GGG)\n" +
        "DDD = (DDD, DDD)\n" +
        "EEE = (EEE, EEE)\n" +
        "GGG = (GGG, GGG)\n" +
        "ZZZ = (ZZZ, ZZZ)"

const val DAY_8_TEST_INPUT2 = "LLR\n" +
        "\n" +
        "AAA = (BBB, BBB)\n" +
        "BBB = (AAA, ZZZ)\n" +
        "ZZZ = (ZZZ, ZZZ)"

const val DAY_8_TEST_INPUT3 = "LR\n" +
        "\n" +
        "11A = (11B, XXX)\n" +
        "11B = (XXX, 11Z)\n" +
        "11Z = (11B, XXX)\n" +
        "22A = (22B, XXX)\n" +
        "22B = (22C, 22C)\n" +
        "22C = (22Z, 22Z)\n" +
        "22Z = (22B, 22B)\n" +
        "XXX = (XXX, XXX)"

val DAY_8_INPUT = ReadFile.fileToString("/Users/vishbanjan/IdeaProjects/aoc-2023/src/main/kotlin/day8/input_day8.txt")