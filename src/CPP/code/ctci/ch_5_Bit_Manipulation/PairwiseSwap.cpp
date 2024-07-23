#include "PairwiseSwap.h"
#include <iostream>

using namespace ctci;

void PairwiseSwap::description() {
    std::cout << R"(Bit Manipulation: PairwiseSwap
    Given a positive integer, print the next smallest and the next largest number that have
     the same number of 1 bits in their binary representation.)" << std::endl;
}

int PairwiseSwap::pairwiseSwap(int value) {
    // I could have hardcoded the templates, but I wanted to account for Int being different sizes
    // depending on OS or even version
    auto evenMaskTemplate = 2;
    auto evenMask = evenMaskTemplate;
    auto oddMaskTemplate = 1;
    auto oddMask = oddMaskTemplate;
    for (auto count = 1; count < (sizeof(value) * CHAR_BIT) / 2; count++) {
        evenMask <<= 2;
        oddMask <<= 2;
        evenMask |= evenMaskTemplate;
        oddMask |= oddMaskTemplate;
    }
    return ((value & evenMask) >> 1) | ((value & oddMask) << 1);
}