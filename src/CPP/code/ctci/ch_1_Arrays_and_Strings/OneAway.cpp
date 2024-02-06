#include "OneAway.h"

using namespace std;

void OneAway::description() {
    cout << R"(Arrays and Strings: One Away
    There are three types of edits that can be performed on strings:
        insert a character
        remove a character
        replace a character
    Given two strings, write a function to check if they are one edit (or zero edits) away.
    Example:
        pale, bale -> true
        pale, pales -> true
        pales , pale -> true
        pale, bake -> false)" << endl;
}

bool OneAway::isOneAway(const string &left, const string &right) {
    auto result = true;
    if (left.size() == right.size()) {
        // Only 1 replace possible
        auto edited = false;
        for (auto index = 0; index < left.size(); index++) {
            if (left.at(index) != right.at(index)) {
                if (edited) {
                    result = false;
                    break;
                }
                edited = true;
            }
        }
    } else if (abs((int) left.size() - (int) right.size()) == 1) {
        // Only add or delete available
        // Advance until first difference
        auto index = 0;
        while ((index < min(left.size(), right.size())) and (left.at(index) == right.at(index))) {
            index++;
        }
        auto leftIndex = index;
        auto rightIndex = index;
        if (left.size() < right.size()) {
            rightIndex++;
        } else {
            leftIndex++;
        }
        while ((leftIndex < left.size()) and (rightIndex < right.size())) {
            if (left.at(leftIndex) != right.at(rightIndex)) {
                result = false;
                break;
            }
            leftIndex++;
            rightIndex++;
        }
    }
    return result;
}
