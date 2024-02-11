#pragma clang diagnostic push
#pragma ide diagnostic ignored "LocalValueEscapesScope"

#include "StringCompression.h"
#include <iostream>
#include <string>

using namespace ctci;

void StringCompression::description() {
    std::cout << R"(Arrays and Strings: String Compression
    Implement a method to perform basic string compression using the counts of repeated characters.
    For example, the string aabcccccaaa would become a2blc5a3.
    If the "compressed" string would not become smaller than the original string, your method should return
    the original string.
    You can assume the string has only uppercase and lowercase letters (a - z).)" << std::endl;
}

std::string StringCompression::compress(const std::string &input) {
    std::string result;
    auto count = 0;
    char last = input.at(0);
    for (auto character: input) {
        if (character != last) {
            result.push_back(last);
            result.append(std::to_string(count));
            last = character;
            count = 1;
        } else {
            count++;
        }
    }
    // add last character count to result
    result.push_back(last);
    result.append(std::to_string(count));
    return (result.size() < input.size()) ? result : input;
}

std::string StringCompression::decompress(const std::string &input) {
    std::string result;
    char last;
    for (auto index = 0; index < input.size(); index++) {
        if (isdigit(input.at(index))) {
            auto start = index;
            auto count = 1;
            while ((index < input.size()) and (isdigit(input.at(index)))) {
                count++;
                index++;
            }
            // index is pointing to the next character but the loop will increment again, so I need to decrement
            index--;
            count--;
            std::string number = input.substr(start, count);
            auto append = std::string(stoi(number), last);
            result.append(append);
        } else {
            last = input.at(index);
        }
    }
    return (result.empty()) ? input : result;
}

#pragma clang diagnostic pop