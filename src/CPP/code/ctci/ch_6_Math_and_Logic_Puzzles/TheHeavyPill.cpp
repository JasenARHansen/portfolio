#include "TheHeavyPill.h"
#include <iostream>
#include <cmath>

using namespace ctci;

void TheHeavyPill::description() {
    std::cout << R"(Math and Logic Puzzles: The Heavy Pill
    You have 20 bottles of pills.
    19 bottles have 1.0 gram pills, but one has pills of weight 1.1 grams.
    Given a scale that provides an exact measurement, how would you find the heavy bottle?
    You can only use the scale once.)" << std::endl;
}

int TheHeavyPill::findHeavy(std::vector<double> pills) {
    auto sum = 0.0;
    for (auto index = 0; index < (int) pills.size(); index++) {
        sum += (index + 1) * pills.at(index);
    }
    auto totalPills = ((int) pills.size() * ((int) pills.size() + 1)) / 2;
    return (int) floor((sum - totalPills) * 10) - 1;
}