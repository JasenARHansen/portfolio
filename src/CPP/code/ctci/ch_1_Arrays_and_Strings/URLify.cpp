#include "URLify.h"

#include <iostream>

void URLify::description() {
    cout << R"(Arrays and Strings: URLify
    Write a method to replace all spaces in a string with '%20'.
    You may assume that the string has sufficient space at the end to hold the additional characters,
     and that you are given the "true" length of the string.
    (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
    Example:
        Input: "Mr John Smith"
        Output: "Mr%20John%20Smith")" << endl;
}

string URLify::urlify(const string &input) {
    auto result = input;
    auto replacement = "%20";
    for (auto index = 0; index < result.size(); index++) {
        if (result.at(index) == ' ') {
            result.erase(index, 1);
            result.insert(index, replacement);
        }
    }
    return result;
}

void URLify::urlifyInPlace(string *input) {
    auto replacement = "%20";
    for (auto index = 0; index < input->size(); index++) {
        if (input->at(index) == ' ') {
            input->erase(index, 1);
            input->insert(index, replacement);
        }
    }
}
