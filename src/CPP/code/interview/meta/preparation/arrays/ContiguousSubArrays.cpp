#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cmath>
#include <cassert>

using namespace std;

class ContiguousSubArrays {
public:
    static void description() {
        cout << R"(Contiguous Sub-arrays
    You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous sub-arrays that fulfill the following conditions:
        The value at index i must be the maximum element in the contiguous sub-arrays, and
        These contiguous sub-arrays must either start from or end on index i.
    Signature
     int[] countSubArrays(int[] array)
    Input
        Array arr is a non-empty list of unique integers that range between 1 to 1, 000, 000, 000
        Size N is between 1 and 1, 000, 000
    Output
     An array where each index i contains an integer denoting the maximum number of contiguous sub-arrays of arr[i]
    Example:
        array = [3, 4, 1, 6, 2]
        output = [1, 3, 1, 5, 1]
        Explanation:
            For index 0 - [3] is the only contiguous subarray that starts (or ends) at index 0 with the maximum value in the subarray being 3.
            For index 1 - [4], [3, 4], [4, 1]
            For index 2 - [1]
            For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
            For index 4 - [2]
        So, the answer for the above input is [1, 3, 1, 5, 1])" << endl;
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