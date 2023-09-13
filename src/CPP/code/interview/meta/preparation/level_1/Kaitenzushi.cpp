#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>
#include <set>

using namespace std;

class Kaitenzushi {
public:
    static void description() {
        cout << R"(Cafeteria
    There are n dishes in a row on a kaiten belt, with the iTH dish being of type Di. Some dishes may be of the same type as one another.
    You're very hungry, but you'd also like to keep things interesting. The N dishes will arrive in front of you, one after another in order, and for each one you'll eat it as long as it isn't the same type as any of the previous K dishes you've eaten. You eat very fast, so you can consume a dish before the next one gets to you. Any dishes you choose not to eat as they pass will be eaten by others.
    Determine how many dishes you'll end up eating.
    Please take care to write a solution which runs within the time limit.

    Constraints
        1 ≤ N ≤ 500,000
        1 ≤ K ≤ N
        1 ≤ Di ≤ 1,000,000

    Sample test case #1
        N = 6
        D = [1, 2, 3, 3, 2, 1]
        K = 1
        Expected Return Value = 5

    Sample test case #2
        N = 6
        D = [1, 2, 3, 3, 2, 1]
        K = 2
        Expected Return Value = 4

    Sample test case #3
        N = 7
        D = [1, 2, 1, 2, 1, 2, 1]
        K = 2
        Expected Return Value = 2

    Sample Explanation
        In the first case, the dishes have types of [1,2,3,3,2,1] so you'll eat the first 3 dishes, skip the next one as it's another type-3 dish, and then eat the last 2.
        In the second case, you won't eat a dish if it has the same type as either of the previous 2 dishes you've eaten. After eating the first, second, and third dishes, you'll skip the fourth and fifth dishes as they're the same type as the last 2 dishes that you've eaten. You'll then eat the last dish, consuming 44 dishes total.
        In the third case, once you eat the first two dishes you won't eat any of the remaining dishes.)" << endl;
    }

    static int getMaximumEatenDishCount(int n, const vector<int> &d, int k) {
        assert(1 <= n);
        assert(n <= 5 * pow(10, 5));
        assert(1 <= k);
        assert(k <= n);
        int result = 0;
        set<int> eaten;
        for (int dish: d) {
            assert(1 <= dish);
            assert(dish <= pow(10, 6));
            auto insertResult = eaten.insert(dish);
            if (insertResult.second) {
                result++;
                if (eaten.size() > k) {
                    eaten.erase(eaten.begin());
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop