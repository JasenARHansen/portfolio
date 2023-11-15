#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cmath>
#include <cassert>

using namespace std;

class ReverseToMakeEqual {
public:
    static void description() {
        cout << R"(Reverse to Make Equal
    Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any sub-arrays from array B any number of times.
    Signature
        bool areTheyEqual(int[] arr_a, int[] arr_b)
    Input
        All integers in array are in the range [0, 1, 000, 000, 000].
    Output
        Return true if B can be made equal to A, return false otherwise.
    Example
        A = [1, 2, 3, 4]
        B = [1, 4, 3, 2]
        output = true
        After reversing the subarray of B from indices 1 to 3, array B will equal array A.)" << endl;
    }

    static bool areTheyEqual(vector<int> &arrayA, vector<int> &arrayB) {
        bool result = false;
        if (arrayA.size() == arrayB.size()) {
            // A copy to not mutate inputs
            vector<int> processing;
            copy(arrayB.begin(), arrayB.end(), back_inserter(processing));
            for (auto index = 0; index < arrayA.size(); index++) {
                assert(0 <= arrayA.at(index));
                assert(arrayA.at(index) <= pow(10, 9));
                result = true;
                if (arrayA.at(index) != processing.at(index)) {
                    auto subIndex = index + 1;
                    while ((subIndex < processing.size()) && (arrayA.at(index) != processing.at(subIndex))) {
                        subIndex++;
                    }
                    if (processing.size() <= subIndex) {
                        result = false;
                        break;
                    }
                    // reverse sub array
                    reverseSubArray(processing, index, subIndex);
                }
            }
        }
        return result;
    }

private:
    static void reverseSubArray(vector<int> &processing, int index, int subIndex) {
        int swap;
        while (index < subIndex) {
            swap = processing.at(index);
            processing.at(index) = processing.at(subIndex);
            processing.at(subIndex) = swap;
            index++;
            subIndex--;
        }
    }
};

#pragma clang diagnostic pop