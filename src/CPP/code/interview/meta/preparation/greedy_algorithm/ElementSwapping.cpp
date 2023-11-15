#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cassert>
#include <cmath>
#include <algorithm>

using namespace std;

class ElementSwapping {
public:
    static void description() {
        cout << R"(Element Swapping
    Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be obtained from it after performing at most k element swaps, each involving a pair of consecutive elements in the sequence.
    Note: A list x is lexicographically smaller than a different equal-length list y if and only if, for the earliest index at which the two lists differ, x's element at that index is smaller than y's element at that index.

    Signature
        int[] findMinArray(int[] arr, int k)

    Input
        n is in the range [1, 1000].
        Each element of arr is in the range [1, 1, 000, 000].
        k is in the range [1, 1000].

    Output
        Return an array of n integers output, the lexicographically smallest sequence achievable after at most k swaps.

    Example 1
        n = 3
        k = 2
        arr = [5, 3, 1]
        output = [1, 5, 3]
        We can swap the 2nd and 3rd elements, followed by the 1st and 2nd elements, to end up with the sequence [1, 5, 3]. This is the lexicographically smallest sequence achievable after at most 2 swaps.

    Example 2
        n = 5
        k = 3
        arr = [8, 9, 11, 2, 1]
        output = [2, 8, 9, 11, 1]
        We can swap [11, 2], followed by [9, 2], then [8, 2].)" << endl;
    }

    static vector<int> findMinArray(const vector<int> &arr, int k) {
        assert(!arr.empty());
        assert(arr.size() <= pow(10, 3));
        assert(1 <= k);
        assert(k <= pow(10, 3));
        vector<int> result;
        copy(arr.begin(), arr.end(), back_inserter(result));
        // find a possible indexStart for starting swapping
        auto indexStart = -1;
        int swapOffset;
        auto kUsed = 0;
        do {
            do {
                indexStart++;
                swapOffset = indexOfMinInRange(result, indexStart, k - kUsed);
            } while (swapOffset == 0);
            if (swapOffset > 0) {
                int swap;
                for (int index = swapOffset; 0 < index; index--) {
                    swap = result.at(indexStart + index);
                    result[indexStart + index] = result.at(indexStart + index - 1);
                    result[indexStart + index - 1] = swap;
                }
            }
            kUsed += swapOffset;
        } while ((kUsed < k) && (indexStart < (result.size() - k + kUsed)));
        return result;
    }

private:
    static int indexOfMinInRange(vector<int> arr, int indexStart, int length) {
        auto result = 0;
        auto min = INT_MAX;
        for (auto index = 0; ((index < length + 1) && ((indexStart + index) < arr.size())); index++) {
            if (arr.at(indexStart + index) < min) {
                min = arr.at(indexStart + index);
                result = index;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop