#include "PalindromePermutation.h"
#include <algorithm>
#include <iostream>
#include <vector>

using namespace ctci;

void PalindromePermutation::description() {
    std::cout << R"(Arrays and Strings: Palindrome Permutation
    Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards.
    A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    Example:
        Input: Tact Coa
        Output: True (permutations: "taco cat", "atco e t a " , etc.))" << std::endl;
}

bool PalindromePermutation::isPalindromePermutation(std::string input) {
    auto result = true;
    input.erase(remove(input.begin(), input.end(), ' '), input.end());
    transform(input.begin(), input.end(), input.begin(), [](unsigned char c) { return tolower(c); });
    // ASCII char set is 128
    auto charSetSize = 128;
    std::vector<int> count(charSetSize, 0);
    for (int index = 0; index < input.length(); index++) {
        count[input[index]]++;
    }
    auto oddFound = false;
    for (auto value: count) {
        if (value % 2 == 1) {
            if (oddFound) {
                result = false;
                break;
            }
            oddFound = true;
        }
    }
    return result;
}
