#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
struct sides {
    long long a;
    long long b;
    long long c;
};

class BalancedSplit {
public:
    static void description() {
        cout << R"(Balanced Split
    Given an array of integers (which may include repeated integers), determine if there's a way to split
     the array into two subsequences A and B such that the sum of the integers in both arrays is the same,
     and all of the integers in A are strictly smaller than all of the integers in B.
    Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
    Signature:
        bool balancedSplitExists(int[] arr)
    Input:
        All integers in array are in the range [0, 1, 000, 000, 000].
    Output:
        Return true if such a split is possible, and false otherwise.
    Example 1:
        arr = [1, 5, 7, 1]
        output = true
        We can split the array into A = [1, 1, 5] and B = [7].
    Example 2:
        arr = [12, 7, 6, 7, 6]
        output = false
        We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the
         requirement that all integers in A are smaller than all integers in B.)" << endl;
    }

    static bool balancedSplitExists(vector<int> &arr) {
        auto result = false;
        if (1 < arr.size()) {
            vector<int> processing;
            copy(arr.begin(), arr.end(), back_inserter(processing));
            sort(processing.begin(), processing.end());
            auto leftIndex = 0;
            auto left = processing.at(leftIndex);
            auto rightIndex = processing.size() - 1;
            auto right = processing.at(rightIndex);
            while (1 < (rightIndex - leftIndex)) {
                if (left < right) {
                    left += processing.at(++leftIndex);
                } else {
                    right += processing.at(--rightIndex);
                }
            }
            result = (left == right) && (processing.at(leftIndex) < processing.at(rightIndex));
        }
        return result;
    }
};

#pragma clang diagnostic pop