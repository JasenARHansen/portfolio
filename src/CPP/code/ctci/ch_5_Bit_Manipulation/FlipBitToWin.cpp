#include "FlipBitToWin.h"
#include <iostream>
#include <bitset>
#include <vector>

using namespace ctci;

void FlipBitToWin::description() {
    std::cout << R"(Bit Manipulation: Flip Bit to Win
    You have an integer and you can flip exactly one bit from a 0 to a 1.
    Write code to find the length of the longest sequence of Is you could create.
    Example:
        Input: 1775 (or: 11011101111)
        Output: 8)" << std::endl;
}

int FlipBitToWin::flipBitToWin(int value) {
    auto result = 0;
    std::bitset<sizeof(value) * CHAR_BIT> bits = value;
    auto countRight = 0;
    auto countLeft = 0;
    for (auto index = 0; index < bits.size(); index++) {
        if (bits[index] == 1) {
            countRight++;
        } else {
            countLeft = countRight;
            countRight = 0;
        }
        if ((countRight + 1 + countLeft) > result) {
            result = countRight + 1 + countLeft;
        }
    }
    return std::min(result, (int) bits.size());
}