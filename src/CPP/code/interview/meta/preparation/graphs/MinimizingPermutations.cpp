#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class MinimizingPermutations {
public:
    static void description() {
        cout << R"(Minimizing Permutations
    In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N,
     denoted as (a_1, a_2, ..., a_N).
    You want to rearrange the elements of the permutation into increasing order, repeatedly making
     the following operation:
        Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
    Your goal is to compute the minimum number of such operations required to return the permutation
     to increasing order.
    Signature:
        int minOperations(int[] arr)
    Input:
        Array arr is a permutation of all integers from 1 to N, N is between 1 and 8
    Output:
        An integer denoting the minimum number of operations required to arrange the permutation in increasing order
    Example:
        Input:  N = 3, and P = (3, 1, 2)
        Output = 2
        We can do the following operations:
        Select (1, 2) and reverse it: P = (3, 2, 1).
        Select (3, 2, 1) and reverse it: P = (1, 2, 3).)" << endl;
    }

    static int minOperations(vector<int> arr) {
        auto left = 1;
        auto result = 0;
        while (left <= arr.size()) {
            // find left
            while ((left <= arr.size()) && (left == arr.at(left - 1))) {
                left++;
            }
            if (left <= arr.size()) {
                reverseSection(arr, left - 1, arr.at(left - 1) - 1);
                result++;
            }
        }
        return result;
    }

private:
    static void reverseSection(vector<int> &arr, int left, int right) {
        int swap;
        while (left < right) {
            swap = arr.at(left);
            arr[left] = arr.at(right);
            arr[right] = swap;
            left++;
            right--;
        }
    }
};

#pragma clang diagnostic pop