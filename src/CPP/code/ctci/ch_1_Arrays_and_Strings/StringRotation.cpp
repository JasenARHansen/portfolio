#include "StringRotation.h"
#include <iostream>

void StringRotation::description() {
    cout << R"(Arrays and Strings: String Rotation
    Assume you have a method isSubstring which checks if one word is a substring of another.
    Given two strings, s1 and s2, write code to check if s2 is a rotation of si using only one call to
     isSubstring [e.g., "waterbottle " is a rotation of "erbottlewat").)" << endl;
}

string StringRotation::rotate(const string &input, int spaces) {
    string result;
    result += input.substr(spaces);
    result += input.substr(0, spaces);
    return result;
}

bool StringRotation::isRotation(const string &s1, const string &s2) {
    auto result = true;
    if (s1.length() != s2.length()) {
        result = false;
    }
    std::string concatS1 = s1 + s1;
    if (concatS1.find(s2) == std::string::npos) {
        result = false;
    }
    return result;
}
