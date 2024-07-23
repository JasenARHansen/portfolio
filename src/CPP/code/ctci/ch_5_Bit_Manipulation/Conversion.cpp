#include "Conversion.h"
#include <iostream>
#include <bitset>

using namespace ctci;

void Conversion::description() {
    std::cout << R"(Bit Manipulation: Conversion
    Given a positive integer, print the next smallest and the next largest number that have
     the same number of 1 bits in their binary representation.)" << std::endl;
}

int Conversion::conversion(int source, int target) {
    auto result = 0;
    std::bitset<sizeof(source) * CHAR_BIT> bitsSource = source;
    std::bitset<sizeof(target) * CHAR_BIT> bitsTarget = target;
    for (auto index = 0; index < bitsSource.size(); index++) {
        if (bitsSource[index] != bitsTarget[index]) {
            result++;
        }
    }
    return result;
}