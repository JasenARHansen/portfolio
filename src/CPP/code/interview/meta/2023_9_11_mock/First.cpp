#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>

using namespace std;

class First {
public:
    static void description() {
        cout << R"(Question 1:
    Given a string S consisting of lowercase English characters determine if you can make it a palindrome by removing at most 1 character.
        mom --> True # mom --> mom
        tacocats --> True # tacocats → tacocat
        racercar --> True # racercar --> racecar, racrcar
        baaba --> True # baaba → baab
        abaab --> True # abaab → baab
        abcd → False
        btnnure → False
    Inputs must have at least 1 character
    String has no maximum size)" << endl;
    }

    static bool makePalindromeSubstitution(const string &input) {
        auto result = true;
        assert(!input.empty());
        auto left = 0;
        auto right = (int) input.size() - 1;
        while (left < right) {
            if (input.at(left) != input.at(right)) {
                result = isPalindromeInRange(input, left + 1, right - 1);
                break;
            }
            left++;
            right--;
        }
        return result;
    }

    static bool makePalindromeWithRemove(const string &input) {
        auto result = true;
        assert(!input.empty());
        auto left = 0;
        auto right = (int) input.size() - 1;
        while (left < right) {
            if (input.at(left) != input.at(right)) {
                result = isPalindromeInRange(input, left + 1, right) || isPalindromeInRange(input, left, right - 1);
                break;
            }
            left++;
            right--;
        }
        return result;
    }

private:
    static bool isPalindromeInRange(const string &input, int left, int right) {
        assert(0 <= left);
        assert(left < input.size());
        assert(0 <= right);
        assert(right < input.size());
        auto result = true;
        while (left < right) {
            if (input.at(left) != input.at(right)) {
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;
    }

};

#pragma clang diagnostic pop