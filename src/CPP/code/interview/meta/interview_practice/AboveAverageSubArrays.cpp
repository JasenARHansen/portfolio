#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class AboveAverageSubArrays {
public:
    static void description() {
        cout << R"(Above-Average Sub-arrays
You are given an array A containing N integers. Your task is to find all sub-arrays whose average sum is greater than the average sum of the remaining array elements. You must return the start and end index of each subarray in sorted order.
A subarray that starts at position L1 and ends at position R1 comes before a subarray that starts at L2 and ends at R2 if L1 < L2, or if L1 = L2 and R1 ≤ R2.
Note that we'll define the average sum of an empty array to be 0, and we'll define the indices of the array (for the purpose of output) to be 1 through N. A subarray that contains a single element will have L1 = R1.

Signature
    Subarray[] aboveAverageSubArrays(int[] A)

Input
    1 ≤ N ≤ 2, 000
    1 ≤ A[i] ≤ 1, 000, 000
    Output
    A Subarray is an object with two integer fields, left and right, defining the range that a given subarray covers. Return a list of all above-average sub-arrays sorted as explained above.

Example 1
    A = [3, 4, 2]
    output = [[1, 2], [1, 3], [2, 2]]
    The above-average sub-arrays are [3, 4], [3, 4, 2], and [4].)" << endl;
    }

    static vector<vector<int>> aboveAverageSubArrays(const vector<int> &arr) {
        vector<vector<int>> result;
        int sumSub;
        int averageSub;
        int averageRemainder;
        auto sum = sumSubArray(arr, 0, (int) arr.size());
        int length;
        for (int indexLeft = 0; indexLeft < arr.size(); indexLeft++) {
            for (int indexRight = indexLeft; indexRight < arr.size(); indexRight++) {
                length = indexRight - indexLeft + 1;
                sumSub = sumSubArray(arr, indexLeft, indexRight + 1);
                averageSub = sumSub / length;
                if (arr.size() != length) {
                    averageRemainder = (sum - sumSub) / (int) (arr.size() - length);
                    if (averageSub > averageRemainder) {
                        result.push_back({indexLeft + 1, indexRight + 1});
                    }
                } else {
                    result.push_back({indexLeft + 1, indexRight + 1});
                }
            }
        }
        return result;
    }

private:
    static int sumSubArray(vector<int> arr, int indexLeft, int indexRight) {
        int sum = 0;
        for (auto index = indexLeft; index < indexRight; index++) {
            sum += arr.at(index);
        }
        return sum;
    }
};

#pragma clang diagnostic pop