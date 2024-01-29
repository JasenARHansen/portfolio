#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <set>
#include <map>

using namespace std;

class Pairs {
public:
    static void description() {
        cout << R"(Search: Arrays: Pairs:
    Given an array of integers and a target value, determine the number of pairs of array elements that
     have a difference equal to the target value.
    Example:
        k = 1
        arr = [1, 2, 3, 4]
        There are three values that differ by k = 1: [2, 1], [3, 2], and [4, 3].
        Return 3.
    Function Description:
        Complete the pairs function below.
        pairs has the following parameter(s):
            int k: an integer, the target difference
            int arr[n]: an array of integers
        Returns:
            int: the number of pairs that satisfy the criterion
    Input Format:
        The first line contains two space-separated integers n and k, the size of arr and the target value.
        The second line contains  space-separated integers of the array.
    Constraints:
        2 ≤ n ≤ 10^5
        0 < k < 10^9
        0 < arr[i] ≤ 2^31 - 1
        each integer arr[i] will be unique
    Sample Input:
        STDIN       Function
        -----       --------
        5 2         arr[] size n = 5, k =2
        1 5 3 4 2   arr = [1, 5, 3, 4, 2]
    Sample Output:
        3
    Explanation:
        There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1].)" << endl;
    }

    static void description_non_unique() {
        cout << R"(Search: Arrays: Pairs:
    Given an array of integers and a target value, determine the number of pairs of array elements that
     have a difference equal to the target value.
    Example:
        k = 1
        arr = [1, 2, 3, 4]
        There are three values that differ by k = 1: [2, 1], [3, 2], and [4, 3].
        Return 3.
    Function Description:
        Complete the pairs function below.
        pairs has the following parameter(s):
            int k: an integer, the target difference
            int arr[n]: an array of integers
        Returns:
            int: the number of pairs that satisfy the criterion
    Input Format:
        The first line contains two space-separated integers n and k, the size of arr and the target value.
        The second line contains  space-separated integers of the array .
    Constraints:
        2 ≤ n ≤ 10^5
        0 < k < 10^9
        0 < arr[i] ≤ 2^31 - 1
    Sample Input 1:
        STDIN       Function
        -----       --------
        5 2         arr[] size n = 5, k =2
        1 5 3 4 2   arr = [1, 5, 3, 4, 2]
    Sample Output 1:
        3
    Explanation 1:
        There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1].
    Sample Input 2:
        STDIN       Function
        -----       --------
        5 2         arr[] size n = 5, k =2
        1 3 1 3 1   arr = [1, 3, 1, 3, 1]
    Sample Output 2:
        6
    Explanation 2:
        There are 6 pairs of integers in the set with a difference of 2: 6 instances of [3,1]
        Explaining using index values for: [1, 3, 1, 3, 1]: [1, 0], [4, 0], [1, 2], [4, 2], [1, 4], [4, 4].)" << endl;
    }

    static int pairs(int k, const vector<int>& arr) {
        auto result = 0;
        set<int> processed(arr.begin(), arr.end());
        for (auto itr: processed) {
            if (processed.count(itr + k)) {
                result++;
            }
        }
        return result;
    }

    static int pairs_non_unique(int k, const vector<int>& arr) {
        auto result = 0;
        map<int, int> data;
        for (auto value: arr) {
            data[value]++;
        }
        for (auto value: data) {
            if (data.count(value.first + k)) {
                result += data[value.first] * data[value.first + k];
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop