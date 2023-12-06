package day2

const val DAY_2_TEST_INPUT = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"

const val DAY_2_INPUT = "Game 1: 4 blue; 1 green, 2 red; 4 blue, 1 green, 6 red\n" +
        "Game 2: 7 red, 1 green, 4 blue; 13 red, 11 blue; 6 red, 2 blue; 9 blue, 9 red; 4 blue, 11 red; 15 red, 1 green, 3 blue\n" +
        "Game 3: 1 blue, 10 green; 4 green, 8 blue; 3 blue, 14 green, 1 red\n" +
        "Game 4: 1 green, 2 blue; 1 blue, 4 green; 8 red, 3 blue, 3 green; 8 red, 2 green, 1 blue; 7 green, 3 blue, 2 red; 1 red, 1 green, 3 blue\n" +
        "Game 5: 3 red, 7 blue, 4 green; 12 blue, 16 red, 4 green; 9 red, 2 green; 1 blue, 1 green, 1 red\n" +
        "Game 6: 15 blue; 15 red, 14 blue, 2 green; 8 red, 2 blue, 2 green; 2 green, 11 blue, 1 red\n" +
        "Game 7: 6 green, 6 red, 2 blue; 1 blue, 2 red, 7 green; 12 red; 5 green, 3 red, 1 blue; 16 red, 10 green\n" +
        "Game 8: 2 green, 10 red, 3 blue; 1 blue, 5 green, 11 red; 6 red, 1 blue, 2 green; 11 red; 4 red, 1 blue, 5 green; 5 green, 3 blue\n" +
        "Game 9: 5 blue, 11 red; 2 blue, 2 green; 11 red, 2 green\n" +
        "Game 10: 3 red, 5 green; 3 blue, 5 green; 3 red, 2 blue, 14 green\n" +
        "Game 11: 1 green, 1 blue, 6 red; 2 blue, 7 red, 2 green; 2 green, 2 red, 3 blue; 10 red; 2 red, 2 blue; 11 red, 3 blue\n" +
        "Game 12: 6 blue, 8 red, 6 green; 15 green, 4 red; 1 red, 10 green, 1 blue; 1 red, 3 blue, 11 green\n" +
        "Game 13: 2 blue, 6 red; 15 red, 6 blue; 20 blue, 10 red, 3 green; 17 blue, 1 red, 4 green\n" +
        "Game 14: 3 green, 7 blue, 7 red; 2 blue; 7 blue, 10 red\n" +
        "Game 15: 3 green, 7 blue; 9 green, 8 blue, 5 red; 6 green, 13 red; 14 red, 2 green, 15 blue; 15 red, 7 green\n" +
        "Game 16: 13 blue; 6 green, 4 blue, 11 red; 15 red, 2 green, 6 blue; 1 green, 13 red, 8 blue; 8 green, 7 blue, 14 red\n" +
        "Game 17: 3 red; 17 red, 4 green; 1 blue, 11 red; 3 blue, 20 red, 3 green\n" +
        "Game 18: 4 red, 2 blue, 3 green; 9 red, 6 green; 11 red, 1 blue\n" +
        "Game 19: 1 green, 4 blue; 1 green, 2 red; 2 blue, 1 green; 4 red, 2 blue\n" +
        "Game 20: 15 blue, 6 green, 6 red; 13 green, 1 blue, 1 red; 13 green, 13 blue, 5 red; 7 red, 16 green, 4 blue\n" +
        "Game 21: 10 blue, 5 green, 8 red; 6 blue, 12 red, 4 green; 2 green, 16 blue, 3 red; 6 red, 12 blue, 3 green; 1 red, 3 green; 7 blue, 6 green, 7 red\n" +
        "Game 22: 3 blue, 3 green, 17 red; 1 green, 18 red; 3 green, 10 red, 5 blue; 2 green, 2 red, 4 blue; 2 blue, 13 red; 1 green, 3 blue, 9 red\n" +
        "Game 23: 4 green, 16 red, 2 blue; 10 red, 10 green, 7 blue; 2 green, 6 red, 13 blue; 1 green, 13 blue, 16 red; 7 green, 16 blue, 9 red\n" +
        "Game 24: 6 blue, 7 red, 4 green; 6 blue, 2 green; 2 green, 6 blue, 2 red; 5 red, 3 green, 11 blue\n" +
        "Game 25: 4 red, 2 green; 1 green; 4 green, 4 blue, 8 red; 5 red, 1 blue\n" +
        "Game 26: 9 red, 4 blue, 13 green; 3 blue, 10 red, 7 green; 13 blue, 5 green, 9 red\n" +
        "Game 27: 1 green, 12 red, 2 blue; 2 blue, 13 red, 2 green; 2 blue, 7 red; 4 green, 9 red, 2 blue; 1 blue, 2 green, 15 red; 3 red, 4 green, 1 blue\n" +
        "Game 28: 1 red, 9 blue, 17 green; 14 green, 15 blue, 2 red; 4 red, 18 green, 13 blue\n" +
        "Game 29: 16 green, 5 blue, 1 red; 6 green, 6 red, 16 blue; 4 red, 9 green, 12 blue; 5 green, 14 blue, 1 red\n" +
        "Game 30: 3 red, 2 blue, 12 green; 13 green, 4 red; 13 green, 2 red, 1 blue; 2 blue, 6 red, 4 green; 3 blue, 13 green, 5 red\n" +
        "Game 31: 3 red; 6 red, 2 green; 5 red; 3 green, 2 red; 1 green, 2 red, 1 blue; 1 blue, 6 red\n" +
        "Game 32: 1 red, 7 green; 9 green, 5 blue; 1 green, 2 red; 4 blue, 2 red, 1 green; 4 blue, 1 green, 3 red\n" +
        "Game 33: 11 green; 12 blue, 2 green; 5 green, 1 blue; 10 green, 3 blue; 4 blue, 1 red, 4 green; 4 green, 5 blue\n" +
        "Game 34: 4 red, 8 blue, 2 green; 8 green, 4 red, 14 blue; 11 green, 6 red, 8 blue; 16 green, 3 blue, 5 red; 3 blue, 3 red, 13 green\n" +
        "Game 35: 7 green, 12 red, 1 blue; 1 red; 13 red; 14 red, 2 blue, 9 green\n" +
        "Game 36: 3 red, 4 green, 1 blue; 3 red, 4 blue; 6 red, 4 blue, 3 green; 3 green, 4 blue, 3 red; 2 blue, 4 green, 7 red\n" +
        "Game 37: 2 green, 1 blue, 5 red; 1 green; 3 blue; 3 blue, 1 green\n" +
        "Game 38: 1 red, 12 blue, 17 green; 4 blue, 2 red, 8 green; 7 blue, 20 green; 6 red, 3 blue; 6 green, 7 red, 6 blue; 10 green, 3 red\n" +
        "Game 39: 3 green, 3 blue, 2 red; 4 blue, 4 red, 4 green; 4 blue, 4 red; 1 blue, 5 green, 2 red; 5 green, 3 blue, 4 red; 4 green, 2 blue\n" +
        "Game 40: 18 green, 1 red; 17 green, 1 blue; 2 green, 1 blue, 1 red; 9 green, 1 blue; 3 green, 1 red; 1 red, 10 green\n" +
        "Game 41: 2 red, 4 blue, 3 green; 8 blue, 2 red; 5 blue; 2 green, 2 red, 3 blue; 1 green, 7 blue\n" +
        "Game 42: 1 green, 2 blue; 9 green, 2 blue, 15 red; 1 green, 4 blue, 9 red\n" +
        "Game 43: 5 blue, 3 red; 2 blue, 8 red, 7 green; 17 red, 4 blue, 7 green\n" +
        "Game 44: 13 red, 3 green, 12 blue; 15 green, 10 blue; 8 green, 11 red, 2 blue; 10 blue, 16 red, 2 green; 12 blue, 5 green, 5 red; 14 green, 8 red, 13 blue\n" +
        "Game 45: 1 red, 3 green; 4 green, 5 blue, 2 red; 6 red, 2 blue, 6 green; 3 blue, 2 green; 5 blue, 3 green, 4 red; 5 red, 5 blue, 6 green\n" +
        "Game 46: 12 red, 2 blue, 3 green; 15 red, 14 blue, 11 green; 6 red, 11 blue, 6 green; 4 red, 1 green; 7 blue, 14 red; 14 red, 18 blue, 6 green\n" +
        "Game 47: 3 blue, 5 red, 4 green; 1 blue, 10 red; 6 blue, 5 green, 7 red; 3 red, 4 green; 2 blue, 2 green, 13 red; 4 blue, 13 red, 2 green\n" +
        "Game 48: 2 green, 3 blue, 7 red; 12 red, 1 green, 2 blue; 5 red, 2 blue; 4 blue, 3 green, 10 red\n" +
        "Game 49: 8 green, 13 blue, 3 red; 14 blue, 1 green; 14 blue, 2 green\n" +
        "Game 50: 1 red, 2 green, 3 blue; 2 green, 2 red; 1 green, 5 blue; 4 green\n" +
        "Game 51: 10 green, 5 red; 10 green, 2 blue, 2 red; 2 blue, 13 red, 1 green; 6 blue, 10 green, 3 red\n" +
        "Game 52: 8 green, 1 blue, 6 red; 4 green, 5 blue; 4 green, 7 red; 3 blue, 6 green, 3 red; 7 red, 6 blue, 7 green; 4 red, 8 green, 4 blue\n" +
        "Game 53: 11 blue, 10 green, 1 red; 6 blue, 1 green, 12 red; 6 green, 12 blue, 13 red; 1 blue, 10 green, 10 red; 11 green, 2 blue; 7 green, 7 red, 5 blue\n" +
        "Game 54: 3 blue, 1 green, 7 red; 18 blue, 3 red, 1 green; 11 blue, 6 red\n" +
        "Game 55: 9 blue, 1 red; 3 blue, 1 green, 2 red; 1 green, 6 blue, 5 red; 1 green, 5 red, 12 blue; 5 red, 3 green, 12 blue; 12 blue\n" +
        "Game 56: 3 red, 1 green, 11 blue; 2 red, 20 blue; 12 blue, 4 red; 3 red, 2 blue, 6 green\n" +
        "Game 57: 1 green, 13 red, 1 blue; 7 green, 2 red, 2 blue; 6 red, 3 blue; 6 blue, 4 red, 3 green; 1 green, 11 red\n" +
        "Game 58: 3 red, 13 blue, 2 green; 6 green, 6 red, 19 blue; 4 blue, 9 green, 1 red; 1 blue, 6 red\n" +
        "Game 59: 11 red, 2 blue, 2 green; 1 blue, 13 red; 12 red, 6 blue\n" +
        "Game 60: 8 blue, 4 red, 11 green; 10 green; 5 blue, 3 red, 8 green; 6 blue, 6 red, 12 green\n" +
        "Game 61: 1 green, 1 blue, 3 red; 1 blue, 2 green, 5 red; 4 red, 1 green, 1 blue; 5 red, 2 green\n" +
        "Game 62: 14 blue, 2 green, 11 red; 11 red, 2 green, 8 blue; 5 blue, 14 red, 5 green; 17 red, 2 blue, 3 green; 2 red, 3 green, 5 blue; 11 blue, 10 red, 3 green\n" +
        "Game 63: 2 blue, 2 green; 9 blue, 3 red; 1 green, 2 red, 12 blue\n" +
        "Game 64: 14 green, 1 blue, 5 red; 4 red, 14 green, 12 blue; 10 blue, 3 red, 10 green\n" +
        "Game 65: 1 green, 6 red, 6 blue; 7 red, 7 blue, 3 green; 14 blue, 5 red\n" +
        "Game 66: 10 blue, 2 red, 7 green; 3 red, 16 blue; 10 green, 7 red, 17 blue; 10 red, 5 green, 5 blue; 13 blue, 10 green, 6 red\n" +
        "Game 67: 9 blue, 6 green; 1 red, 8 blue, 9 green; 3 blue, 1 green, 1 red; 2 blue, 6 green, 1 red\n" +
        "Game 68: 4 green, 9 red, 3 blue; 6 blue, 5 green, 2 red; 6 blue, 9 red, 3 green; 4 red, 2 green; 4 red, 9 green\n" +
        "Game 69: 1 green, 1 blue, 2 red; 2 red, 7 green; 3 red, 1 blue, 5 green; 8 red, 7 green; 2 green, 1 blue; 6 red, 1 blue, 7 green\n" +
        "Game 70: 13 blue, 3 green, 5 red; 1 red, 1 green, 6 blue; 4 red, 11 blue; 14 blue, 5 red, 1 green; 8 red, 16 blue, 1 green\n" +
        "Game 71: 1 blue, 1 green; 6 blue, 2 red; 5 green, 1 red, 4 blue; 4 green, 3 red\n" +
        "Game 72: 4 green, 2 blue, 11 red; 4 red, 7 green, 4 blue; 3 red, 6 green, 14 blue; 4 green, 12 red, 15 blue; 4 blue, 14 red; 6 blue, 13 red, 6 green\n" +
        "Game 73: 4 green, 6 red, 7 blue; 11 red, 4 blue, 6 green; 8 red, 2 blue, 5 green; 3 red, 1 green, 7 blue\n" +
        "Game 74: 5 blue, 10 green; 6 green, 5 blue, 10 red; 4 green, 2 red, 1 blue; 3 blue, 11 green\n" +
        "Game 75: 3 red, 3 green, 15 blue; 6 blue, 3 green, 5 red; 11 blue, 1 red, 3 green; 7 blue, 3 green, 4 red; 9 blue, 1 red, 3 green\n" +
        "Game 76: 11 red; 7 green, 12 red; 2 red, 1 blue, 2 green; 2 red, 1 blue, 6 green; 5 red, 7 green; 1 blue, 8 green\n" +
        "Game 77: 2 blue, 15 green, 1 red; 6 blue, 1 red; 1 green, 5 blue, 1 red; 2 blue, 1 red, 1 green; 15 green, 8 blue, 1 red; 19 green, 5 blue\n" +
        "Game 78: 14 red, 2 green, 7 blue; 2 green, 14 red, 3 blue; 1 blue, 7 red\n" +
        "Game 79: 15 red, 2 green, 1 blue; 3 red, 1 green; 12 red, 2 blue; 12 red, 1 green; 1 blue, 2 red, 1 green\n" +
        "Game 80: 2 red, 1 green, 7 blue; 7 red, 6 blue, 5 green; 6 blue, 6 red; 6 green, 2 blue, 3 red; 5 red, 5 blue, 1 green\n" +
        "Game 81: 10 red, 1 green, 3 blue; 6 green, 13 blue, 3 red; 1 green, 2 red, 10 blue\n" +
        "Game 82: 4 blue, 1 red, 7 green; 4 red, 14 blue, 8 green; 1 red, 11 blue, 6 green\n" +
        "Game 83: 10 red, 3 blue, 9 green; 3 green, 3 red, 1 blue; 4 blue, 11 green, 8 red; 2 blue, 8 green, 2 red; 2 green, 2 red\n" +
        "Game 84: 2 green, 2 blue, 14 red; 7 red, 5 blue, 11 green; 4 red, 6 blue, 5 green; 3 blue, 13 green, 14 red; 6 red, 7 blue, 8 green; 2 blue, 3 red, 18 green\n" +
        "Game 85: 8 green, 14 blue; 6 green, 9 red, 15 blue; 9 red, 12 green, 15 blue; 12 green, 6 red; 9 green, 10 red, 15 blue; 12 blue, 6 green\n" +
        "Game 86: 1 blue, 1 green, 4 red; 6 green, 4 red, 6 blue; 1 red, 4 blue, 4 green; 6 green, 2 blue, 1 red\n" +
        "Game 87: 17 blue, 13 green; 8 blue, 3 red; 16 green, 4 red, 6 blue\n" +
        "Game 88: 11 red, 16 blue, 6 green; 10 red, 2 blue, 1 green; 5 blue, 2 green, 14 red\n" +
        "Game 89: 3 blue, 2 green; 2 red; 9 blue, 8 green, 1 red; 2 green, 2 blue, 3 red; 4 red, 3 green\n" +
        "Game 90: 2 blue, 14 red, 2 green; 6 blue, 2 red, 2 green; 17 red, 1 blue, 6 green; 1 blue, 8 green, 1 red\n" +
        "Game 91: 6 green, 1 blue, 13 red; 10 red, 4 green, 12 blue; 9 green, 17 red, 3 blue; 12 blue, 5 red, 2 green; 2 green, 9 red, 14 blue\n" +
        "Game 92: 2 red, 4 green, 6 blue; 9 blue, 3 green, 6 red; 5 blue, 4 green; 3 blue, 2 green, 7 red; 4 red, 4 green, 11 blue\n" +
        "Game 93: 4 red, 11 blue, 9 green; 10 blue, 3 green, 9 red; 3 green, 11 red, 1 blue\n" +
        "Game 94: 11 green, 3 red, 1 blue; 3 green, 2 red, 6 blue; 2 red, 6 blue, 5 green; 4 blue, 5 green, 5 red; 17 green, 6 red, 6 blue; 5 green, 6 red, 7 blue\n" +
        "Game 95: 1 red, 3 blue, 15 green; 5 green, 6 blue; 11 green, 2 red, 11 blue; 15 green, 5 red, 7 blue\n" +
        "Game 96: 13 red, 3 blue; 3 red, 13 blue; 5 blue, 1 red, 2 green; 7 red, 7 blue; 12 red, 9 blue, 3 green; 8 red, 15 blue, 2 green\n" +
        "Game 97: 4 blue, 9 green, 2 red; 2 red, 5 green, 13 blue; 9 blue, 2 red, 16 green\n" +
        "Game 98: 3 red; 1 green, 10 red; 2 blue, 8 red; 1 green, 11 red, 2 blue\n" +
        "Game 99: 6 red, 14 green; 8 green, 15 red; 1 red, 4 green; 2 blue, 7 green, 13 red; 14 green, 5 red, 1 blue; 1 blue, 5 red, 8 green\n" +
        "Game 100: 9 blue, 18 green, 4 red; 5 green, 10 blue, 11 red; 1 green, 1 red; 16 green, 5 red, 1 blue"