#include "IsUnique.h"
#include <algorithm>
#include <bitset>
#include <iostream>
#include <vector>

using namespace ctci;

void IsUnique::description() {
    std::cout << R"(Arrays and Strings: Is Unique
    Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?)" << std::endl;
}

bool IsUnique::isUniqueChars(const std::string &str) {
    // ASCII char set is 128
    auto charSetSize = 128;
    if (str.length() > charSetSize) {
        return false;
    }
    std::vector<bool> charSet(charSetSize);
    for (auto val: str) {
        if (charSet[val]) {
            return false;
        }
        charSet[val] = true;
    }
    return true;
}

bool IsUnique::isUniqueCharsBitvector(const std::string &str) {
    // ASCII char set is 128
    std::bitset<128> bits(0);
    for (auto val: str) {
        if (bits.test(val) > 0) {
            return false;
        }
        bits.flip(val);
    }
    return true;
}

bool IsUnique::isUniqueCharsNoDs(std::string str) {
    sort(str.begin(), str.end());
    bool noRepeat = true;
    for (auto i = 0; i < str.size() - 1; i++) {
        if (str[i] == str[i + 1]) {
            noRepeat = false;
            break;
        }
    }
    return noRepeat;
}