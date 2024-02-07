#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class DownToZeroII {
public:
    static void description() {
        cout << R"(Queues: Down to Zero II
    You are given Q queries.
    Each query consists of a single number N.
    You can perform any of the 2 operations on N in each move:
        1: If we take 2 integers a and b where N = a * b (a ≠ 1, b ≠ 1), then we can change N = max(a, b)
        2: Decrease the value of by N by 1.
    Determine the minimum number of moves required to reduce the value of N to 0.
    Input Format:
        The first line contains the integer Q.
        The next Q lines each contain an integer, N.
    Constraints:
        1 ≤ Q ≤ 10^3
        0 ≤ N ≤ 10^6
    Output Format:
        Output Q lines.
        Each line containing the minimum number of moves required to reduce the value of N to 0.
    Sample Input:
        2
        3
        4
    Sample Output:
        3
        3
    Explanation:
        For test case 1, we only have one option that gives the minimum number of moves.
        Follow 3 → 2 → 1 → 0.
        Hence, 3 moves.
        For the case 2, we can either go 4 → 3 → 2 → 1 → 0 or 4 → 2 → 1 → 0.
        The 2nd option is more optimal.
        Hence, 3 moves.)" << endl;
    }

    static vector<int> generateRange(int max) {
        vector<int> range(max + 1);
        iota(range.begin(), range.end(), 0);
        int currentValue;
        int previousValue;
        int multiple;
        int initializeValue;
        for (auto index = 2; index < range.size(); index++) {
            currentValue = range.at(index);
            previousValue = range.at(index - 1);
            // Check for the decrement by 1 path values
            if (currentValue > (previousValue + 1)) {
                range[index] = previousValue + 1;
                currentValue = range[index];
            }
            // handle the division path values
            for (auto value = 2; value < index + 1; value++) {
                multiple = index * value;
                if (multiple > max) {
                    break;
                }
                initializeValue = range.at(multiple);
                // If the value at the calculated index is greater than the current value +1, reassign
                if (initializeValue > currentValue + 1) {
                    range[multiple] = currentValue + 1;
                }
            }
        }
        return range;
    }

    static int downToZeroPreCompute(int n, vector<int> range) {
        // I would only use this logic when there will be many queries against the dataset.
        // For single queries the Dynamic implementation is better.
        return range.at(n);
    }

    static int downToZeroDynamic(int n) {
        map<int, int> previouslyProcessed;
        return downToZero(n, &previouslyProcessed);
    }

private:
    static vector<pair<int, int>> getFactors(int n) {
        // This will not return the trivial factors of 1 and N
        vector<pair<int, int>> result;
        for (int factor = 2; factor <= sqrt(n); factor++) {
            if (n % factor == 0) {
                result.emplace_back(factor, n / factor);
            }
        }
        return result;
    }

    static int downToZero(int n, map<int, int> *previouslyProcessed) {
        auto result = INT_MAX;
        if (previouslyProcessed->count(n)) {
            result = previouslyProcessed->at(n);
        } else if (n > 0) {
            // path 1: 1: If we take 2 integers a and b where N = a * b (a ≠ 1, b ≠ 1), then we can change N = max(a, b)
            auto factors = getFactors(n);
            if (!factors.empty()) {
                for (auto factor: factors) {
                    auto toExecute = max(factor.first, factor.second);
                    auto factorResult = downToZero(toExecute, previouslyProcessed) + 1;
                    if (factorResult < result) {
                        result = factorResult;
                    }
                }
            }
            // path 2: Decrease the value of by N by 1.
            auto toExecute = n - 1;
            auto decrementResult = downToZero(toExecute, previouslyProcessed) + 1;
            if (decrementResult < result) {
                result = decrementResult;
            }
            if (!previouslyProcessed->count(n) or (result < previouslyProcessed->at(n))) {
                previouslyProcessed->operator[](n) = result;
            }
        } else {
            result = 0;
        }
        return result;
    }
};

#pragma clang diagnostic pop