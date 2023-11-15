#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class PairSums {
public:
    static void description() {
        cout << R"(Pair Sums
    Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
    If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.

    Signature
        int numberOfWays(int[] arr, int k)

    Input
        n is in the range [1, 100, 000].

    Each value arr[i] is in the range [1, 1, 000, 000, 000].
        k is in the range [1, 1, 000, 000, 000].

    Output
        Return the number of different pairs of elements which sum to k.

    Example 1
        n = 5
        k = 6
        arr = [1, 2, 3, 4, 3]
        output = 2
        The valid pairs are 2+4 and 3+3.

    Example 2
        n = 5
        k = 6
        arr = [1, 5, 3, 3, 3]
        output = 4
        There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).)"
             << endl;
    }

    static int numberOfWays(vector<int> &arr, int k) {
        auto result = 0;
        unordered_map<int, int> values;
        unordered_set<int> used;
        for (auto value: arr) {
            if (!values.count(value)) {
                values[value] = 0;
            }
            values[value]++;
        }
        for (auto value: values) {
            if (!used.count(value.first)) {
                auto lValue = k - value.first;
                if (value.first == lValue) {
                    auto counter = value.second;
                    while (1 < counter) {
                        result += counter - 1;
                        counter--;
                    }
                } else if (values.count(lValue)) {
                    result += min(value.second, values.at(lValue));
                    used.insert(lValue);
                }
                used.insert(value.first);
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop