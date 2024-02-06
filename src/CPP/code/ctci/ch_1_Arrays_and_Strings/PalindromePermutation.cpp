#include "PalindromePermutation.h"

using namespace std;

void PalindromePermutation::description() {
    cout << R"(Arrays and Strings: Palindrome Permutation
    Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards.
    A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    Example:
        Input: Tact Coa
        Output: True (permutations: "taco cat", "atco e t a " , etc.))" << endl;
}

bool PalindromePermutation::isPalindromePermutation(string input) {
    auto result = true;
    input.erase(remove(input.begin(), input.end(), ' '), input.end());
    transform(input.begin(), input.end(), input.begin(), [](unsigned char c) { return tolower(c); });
    // ASCII char set is 128
    auto charSetSize = 128;
    vector<int> count(charSetSize, 0);
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

