#include "TheEggDropProblem.h"
#include <iostream>

using namespace ctci;

void TheEggDropProblem::description() {
    std::cout << R"(Math and Logic Puzzles: The Egg Drop Problem
    There is a building of 100 floors.
    If an egg drops from the Nth floor or above, it will break.
    If it's dropped from any floor below, it will not break.
    You're given two eggs.
    Find N, while minimizing the number of drops for the worst case.)" << std::endl;
}

int TheEggDropProblem::eggDrop(int first) {
    auto result = 0;
    return result;
}