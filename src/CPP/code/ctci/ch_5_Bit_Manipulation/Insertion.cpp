#include "Insertion.h"
#include <iostream>

using namespace ctci;

void Insertion::description() {
    std::cout << R"(Bit Manipulation: Insertion
    You are given two 32-bit numbers, N and M, and two bit positions, i and j.
    Write a method to insert M into N such that M starts at bit j and ends at bit i.
    You can assume that the bits j through i have enough space to fit all of M.
    That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
    You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
    Example:
        Input: N = 10000000000, M = 10011, i = 2, j = 6
        Output: N = 10001001100)" << std::endl;
}

int Insertion::insertion(int base, int insert, int leftIndex, int rightIndex) {
    int result;
    if (((sizeof(base) * CHAR_BIT) < leftIndex) or ((leftIndex - rightIndex) < 0)) {
        result = insert;
    } else {
        auto leftMask = ~0 << (leftIndex + 1);
        auto rightMask = (1 << rightIndex) - 1;
        auto fullMask = leftMask | rightMask;
        auto clearedBase = base & fullMask;
        auto shiftedInsert = insert << rightIndex;
        result = clearedBase | shiftedInsert;
    }
    return result;
}