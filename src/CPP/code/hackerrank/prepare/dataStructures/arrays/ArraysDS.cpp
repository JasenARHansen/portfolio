#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class ArraysDS {
public:
    static void description() {
        cout << R"(Arrays: Arrays DS
    An array is a type of data structure that stores elements of the same type in a contiguous block of memory.
    In an array, A, of size N, each memory location has some unique index, (where 0 ≤ i < N), that can be
     referenced as A[i] or Ai.
    Reverse an array of integers.
    Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.
    Example:
        A = [1, 2, 3]
    Return:
        [3, 2, 1]
    Function Description:
        Complete the function reverseArray in the editor below.
        reverseArray has the following parameter(s):
            int A[n]: the array to reverse
    Returns:
        int[n]: the reversed array
    Input Format:
        The first line contains an integer, N, the number of integers in A.
        The second line contains space-separated integers that make up A.
    Constraints:
        1 ≤ N ≤ 10^3
        1 ≤ A[i] ≤ 10^4, where A[i] is the ith integer in A
    Sample Input 1:
        A = [1, 4, 3, 2]
    Sample Output 1:
        [2, 3, 4, 1])" << endl;
    }

    static vector<int> reverseArray(vector<int> a) {
        vector<int> result;
        for (auto element: a) {
            result.emplace(result.begin(), element);
        }
        return result;
    }
};

#pragma clang diagnostic pop