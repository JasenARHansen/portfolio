#include "CheckPermutation.h"
#include <algorithm>
#include <iostream>
#include <vector>

using namespace ctci;

void CheckPermutation::description() {
    std::cout << R"(Arrays and Strings: Check Permutation
    Given two strings, write a method to decide if one is a permutation of the other.)" << std::endl;
}

bool CheckPermutation::isPermutation(std::string first, std::string second) {
    auto result = true;
    if (first.length() != second.length()) {
        result = false;
    } else {
        sort(first.begin(), first.end());
        sort(second.begin(), second.end());
        for (auto index = 0; index < first.length(); index++)
            if (first[index] != second[index]) {
                result = false;
                break;
            }
    }
    return result;
}

bool CheckPermutation::isPermutationCount(const std::string &first, const std::string &second) {
    if (first.length() != second.length())
        return false;
    // ASCII char set is 128
    auto charSetSize = 128;
    std::vector<int> count(charSetSize, 0);
    for (int index = 0; index < first.length(); index++) {
        count[first[index]]++;
    }
    for (int i = 0; i < second.length(); i++) {
        count[second[i]]--;
        if (count[second[i]] < 0)
            return false;
    }
    return true;
}
