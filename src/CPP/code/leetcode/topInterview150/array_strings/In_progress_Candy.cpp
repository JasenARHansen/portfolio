#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>
#include<numeric>

using namespace std;

class Candy {

public:

    static void description() {
        cout << R"(135. Candy
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    You are giving candies to these children subjected to the following requirements:
        Each child must have at least one candy.
        Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.

    Example 1:
        Input: ratings = [1,0,2]
        Output: 5
        Explanation:
            You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

    Example 2:
        Input: ratings = [1,2,2]
        Output: 4
        Explanation:
            You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
            The third child gets 1 candy because it satisfies the above two conditions.

    Constraints:
        n == ratings.length
        1 <= n <= 2 * 10^4
        0 <= ratings[i] <= 2 * 10^4)" << endl;
    }

    static int candy(vector<int> &ratings) {
        assert (!ratings.empty());
        assert (ratings.size() <= pow(10, 4));
        vector<int> candies(ratings.size(), -1);
        // Try to short circuit operation
        // Local minimums will be 1:  3, 2, 3 would have the middle value be 1 regardless of that the others are
        // When there are 3, or more, of the same value ( not counting vector endpoints, the middle values will be
        // 1 candy:  3, 3, 3 would have the middle get 1 candy
        for (int index = 1; index < ratings.size() - 1; index++) {
            int difference = ratings[index] - ratings[index - 1];
            // 3 same in a row
            if ((ratings[index - 1] == ratings[index]) && (ratings[index] == ratings[index + 1])) {
                candies[index] = 1;
            }
                // local minimum, the vally can be more than a single item
            else if ((ratings[index - 1] > ratings[index]) && (ratings[index] <= ratings[index + 1])) {
                int offset = 0;
                // find out length of local minimum
                while (((index + offset) < ratings.size() - 1) && (ratings[index] == ratings[index + offset])) {
                    offset++;
                }
                for (int i = 0; i < offset; i++) {
                    candies[index + i] = 1;
                }
                index += offset;
            }
        }

        // 3 regions to process defined by index 0 to left index. left index to right index, right index to end point:

        //     !---!------!---!
        // find the left side to start processing.  This is the first non '1' value, after a '1' has been found.
        int leftIndex = 1;
        while (leftIndex < ratings.size()) {
            if (candies[leftIndex] == 1) {
                break;
            }
            leftIndex++;
        }
        while (leftIndex < ratings.size()) {
            if (candies[leftIndex] != 1) {
                break;
            }
            leftIndex++;
        }
        // find the right side to start processing.  This is the first non '1' value, after a '1' has been found.
        int rightIndex = ratings.size() - 1;
        while (0 < rightIndex) {
            if (candies[rightIndex] == 1) {
                break;
            }
            rightIndex--;
        }
        while (0 < rightIndex) {
            if (candies[rightIndex] != 1) {
                break;
            }
            rightIndex--;
        }
        // process left section

        // process right section

        // process middle section

        int tempIndex = leftIndex;
        while (leftIndex < rightIndex) {
            while ((tempIndex < rightIndex) && (-1 == candies[tempIndex])) {
                tempIndex++;
            }

            leftIndex = tempIndex;
        }

        return accumulate(candies.begin(), candies.end(), 0);
    }
};

#pragma clang diagnostic pop