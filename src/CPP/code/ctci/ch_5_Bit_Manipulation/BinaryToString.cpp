#include "BinaryToString.h"
#include <iostream>
#include <sstream>

using namespace ctci;

void BinaryToString::description() {
    std::cout << R"(Bit Manipulation: Binary to String
    Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the
     binary representation.
    If the number cannot be represented accurately in binary with at most 32 characters,
     print "ERROR.
    Note: This is a human readable binary number, not the bit representation the machine uses.)" << std::endl;
}

std::string BinaryToString::binaryToString(double value) {
    std::stringstream result;
    if ((value < 0) or (value > 1)) {
        result << "ERROR";
    } else if (value == 0) {
        result << "0";
    } else if (value == 1) {
        result << "1";
    } else {
        result << "0.";
        while (value != 0) {
            value *= 2;
            if (result.tellp() > 32) {
                result.str(std::string());
                result << "ERROR";
                break;
            } else if (1 <= value) {
                result << "1";
                value -= 1;
            } else {
                result << "0";
            }

        }
    }
    return result.str();
}