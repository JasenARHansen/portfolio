#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cmath>
#include <cassert>

using namespace std;

class RotationalCipher {

public:
    static void description() {
        cout << R"(Rotational Cipher
    One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
    For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
    Given a string and a rotation factor, return an encrypted string.

    Signature
        string rotationalCipher(string input, int rotationFactor)

    Input
        1 <= |input| <= 1,000,000
        0 <= rotationFactor <= 1,000,000

    Output
        Return the result of rotating input a number of times equal to rotationFactor.

    Example 1
        input = Zebra-493?
        rotationFactor = 3
        output = Cheud-726?

    Example 2
        input = abcdefghijklmNOPQRSTUVWXYZ0123456789
        rotationFactor = 39
        output = nopqrstuvwxyzABCDEFGHIJKLM9012345678)" << endl;
    }

    static vector<int> countSubArrays(vector<int> array) {
        assert(!array.empty());
        assert(array.size() < pow(10, 6));
        vector<int> result;
        for (auto index = 0; index < array.size(); index++) {
            assert(0 < array.at(index));
            assert(array.at(index) < pow(10, 9));
            int sum = 1;
            auto subIndex = index;
            // look left
            while ((1 <= subIndex) && (array.at(subIndex - 1) < array.at(index))) {
                subIndex--;
            }
            sum += index - subIndex;
            //look right
            subIndex = index;
            while ((subIndex < array.size() - 1) && (array.at(subIndex + 1) < array.at(index))) {
                subIndex++;
            }
            sum += subIndex - index;
            result.push_back(sum);
        }
        return result;
    }

};

#pragma clang diagnostic pop