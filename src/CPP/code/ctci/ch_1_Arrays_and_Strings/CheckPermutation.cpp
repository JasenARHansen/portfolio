#include "CheckPermutation.h"
#include <algorithm>
#include <iostream>
#include <vector>

void CheckPermutation::description() {
    cout << R"(Arrays and Strings: Check Permutation
    Given two strings, write a method to decide if one is a permutation of the other.)" << endl;
}

bool CheckPermutation::isPermutation(string first, string second) {
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

bool CheckPermutation::isPermutationCount(const string &first, const string &second) {
    if (first.length() != second.length())
        return false;
    // ASCII char set is 128
    auto charSetSize = 128;
    vector<int> count(charSetSize, 0);
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
