#include "JugsOfWater.h"
#include <iostream>

using namespace ctci;

void JugsOfWater::description() {
    std::cout << R"(Math and Logic Puzzles: Jugs of Water
    You have a five-quart jug, a three-quart jug, and an unlimited supply of water (but
     no measuring cups).
    How would you come up with exactly four quarts of water?
    Note that the jugs are oddly shaped, such that filling up exactly "half" of the jug
     would be impossible.
    Similarly, can this be done with a specified amount of water?)" << std::endl;
}

#pragma clang diagnostic push
#pragma ide diagnostic ignored "UnusedValue"

bool JugsOfWater::testAmountOfWater(int quarts) {
    auto result = true;
    auto threeQuart = 0;
    auto fiveQuart = 0;

    if (quarts >= 5) {
        fiveQuart += 5;             // Filled 5 quart
        quarts -= fiveQuart;        // Puled from source
    } else if (quarts < 4) {
        result = false;
    }
    if (result and (fiveQuart == 5)) {
        threeQuart += 3;            // Filled 3 quart
        fiveQuart -= threeQuart;    // 2 quarts remain
    }
    if (result and (fiveQuart == 2) and (threeQuart == 3)) {
        quarts += threeQuart;      // Returned to source
        threeQuart = 0;            // Emptied
        threeQuart += fiveQuart;   // Holding 2 quarts
        fiveQuart = 0;             // Emptied into 3 quart
    }
    if (quarts < 4) {           // Less than the 4 quarts we require
        result = false;
    } else if (quarts > 4) {
        fiveQuart += 5;         // Filled
        quarts -= fiveQuart;    // Pulled from source
    } else {
        fiveQuart += 4;         // Filled with required amount, exactly 4 quarts available, success
        quarts -= fiveQuart;
    }
    if ((result) and (fiveQuart == 5) and (threeQuart == 2)) {
        fiveQuart -= 1;         // Filled remaining space in 3 quart, 4 quarts remain, success
        threeQuart += 1;        // Filled
    }
    if (fiveQuart != 4) {
        result = false;
    }
    return result;
}

#pragma clang diagnostic pop