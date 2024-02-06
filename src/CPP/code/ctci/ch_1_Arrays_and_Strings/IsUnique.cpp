#include "IsUnique.h"

using namespace std;

void IsUnique::description() {
    cout << R"(Arrays and Strings: Is Unique
    Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?)" << endl;
}

bool IsUnique::isUniqueChars(const string &str) {
    // ASCII char set is 128
    auto charSetSize = 128;
    if (str.length() > charSetSize) {
        return false;
    }
    vector<bool> charSet(charSetSize);
    for (auto val: str) {
        if (charSet[val]) {
            return false;
        }
        charSet[val] = true;
    }
    return true;
}

bool IsUnique::isUniqueCharsBitvector(const string &str) {
    // ASCII char set is 128
    bitset<128> bits(0);
    for (auto val: str) {
        if (bits.test(val) > 0) {
            return false;
        }
        bits.flip(val);
    }
    return true;
}

bool IsUnique::isUniqueCharsNoDs(string str) {
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