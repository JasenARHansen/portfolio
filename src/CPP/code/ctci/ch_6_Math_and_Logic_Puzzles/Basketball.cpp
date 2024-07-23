#include "Basketball.h"
#include <iostream>
#include <cmath>

using namespace ctci;

void Basketball::description() {
    std::cout << R"(Math and Logic Puzzles: Basketball
    You have a basketball hoop and someone says that you can play one of two games.
    Game 1: You get one shot to make the hoop.
    Game 2: You get three shots and you have to make two of three shots.
    If p is the probability of making a particular shot, for which values of p should you pick one
     game or the other?)" << std::endl;
}

int Basketball::selectGame(double probability) {
    auto probabilityGame2 = 3 * pow(probability, 2) - 2 * pow(probability, 3);
    return (probability >= probabilityGame2) ? 1 : 2;
}