#include "NextNumber.h"
#include <iostream>
#include <bitset>

using namespace ctci;

void NextNumber::description() {
    std::cout << R"(Bit Manipulation: NextNumber
    Given a positive integer, print the next smallest and the next largest number that have
     the same number of 1 bits in their binary representation.)" << std::endl;
}

std::pair<int, int> NextNumber::nextNumber(int value) {
    std::pair<int, int> result = {0, 0};
    std::bitset<sizeof(value) * CHAR_BIT> bits = value;
    auto ones = 0;
    auto foundOne = false;
    auto foundZero = false;

    for (auto index = 0; index < bits.size(); index++) {
        if ((result.first != 0) and (result.second != 0)) {
            break;
        } else if (bits[index] == 0) {
            if (!foundZero) {
                foundZero = true;
            }
            // for the next larger, I need to find a 1 and then find a 0.  Tracking all 1's until then.
            if ((foundOne) and (result.first == 0)) {
                auto mask = ~0 << (index + 1);
                auto working = value & mask;
                mask = 1 << (index);
                working = working | mask;
                if (ones > 1) {
                    mask = (1 << (ones - 1)) - 1;
                    working = working | mask;
                }
                result.first = working;
            }
        } else if (bits[index] == 1) {
            ones++;
            if (!foundOne) {
                foundOne = true;
            }
            // for next smaller, I need to have found a 0, and then find a 1.  I need to track the 1's in the meantime.
            if ((foundZero) and (result.second == 0)) {
                auto mask = ~0 << (index + 1);
                auto working = value & mask;
                mask = 1 << (index - 1);
                for (auto count = 0; count < ones; count++) {
                    working = working | mask;
                    mask = mask >> 1;
                }
                result.second = working;
            }
        }
    }
    return result;
}