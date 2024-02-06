#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>
#include <cmath>

using namespace std;

class JimAndTheSkyscrapers {
public:
    static void description() {
        cout << R"(Stacks: Jim and the Skyscrapers
    Jim has invented a new flying object called HZ42.
    HZ42 is like a broom and can only fly horizontally, independent of the environment.
    One day, Jim started his flight from Dubai's highest skyscraper, traveled some distance and landed
     on another skyscraper of same height!
    So much fun! But unfortunately, new skyscrapers have been built recently.
    Let us describe the problem in one dimensional space.
    We have in total N skyscrapers aligned from left to right.
    The ith skyscraper has a height of hi.
    A flying route can be described as (i, j) with i ≠ j, which means, Jim starts his HZ42 at the top of
     the skyscraper i and lands on the skyscraper j.
    Since HZ42 can only fly horizontally, Jim will remain at the height hi only.
    Thus the path (i, j) can be valid, only if each of the skyscrapers i, i+ 1, ..., j -1, j is not strictly
     greater than h1 and if the height of the skyscraper he starts from and arrives on have the same height.
    Formally,(i, j) is valid iff Ak ∈ |i,j| : hk > hi and hi = hj.
    Help Jim in counting the number of valid paths represented by ordered pairs (i, j).
    Input Format:
        The first line contains N, the number of skyscrapers.
        The next line contains N space separated integers representing the heights of the skyscrapers.
    Output Format:
        Print an integer that denotes the number of valid routes.
    Constraints:
        1 ≤ N ≤ 3 * 10^5
        1 ≤ h[i] ≤ 10^6 no skyscraper will have height greater than 10^6 and less than 1.
    Sample Input 0:
        6
        3 2 1 2 3 3
    Sample Output 0:
        8
    Explanation:
        (1, 5), (1, 6) (5, 6) and (2, 4) and the routes in the opposite directions are the only valid routes.
    Sample Input 1:
        3
        1 1000 1
    Sample Output 1:
        0
    Explanation:
        (1, 3) and (3, 1) could have been valid, if there wasn't a big skyscraper with height 1000 between them.)" << endl;
    }

    static unsigned long long  solve(const vector<int>& arr) {
        unsigned long long result = 0;
        stack<pair<int,int>> heights;
        for (int height : arr) {
            // If stack is empty, add height
            // If index height is less than stack height, add height
            if (heights.empty() or (height < heights.top().first)) {
                heights.emplace(height, 1);
            } else {
                // As long as index height is greater than stack height, pop stack height and process pairs
                while ((!heights.empty()) and (heights.top().first < height)) {
                    result += calculatePairs(heights.top().second);
                    heights.pop();
                }
                // If stack height is equal to index height, add index to height list
                if ((!heights.empty()) and (heights.top().first == height)) {
                    heights.top().second++;
                }
                else{
                    // If index height is lower than stack height, add height
                    heights.emplace(height, 1);
                }
            }
        }
        // While there are unprocessed heights on the stack, pop and process pairs
        while (!heights.empty()) {
            result += calculatePairs(heights.top().second);
            heights.pop();
        }
        return result;
    }

private:
    static unsigned long long calculatePairs(int values) {
        // n(n-1)/2 is the formula for finding numbers of pairs
        // Any pair goes both ways so if (1, 2) is valid, so is (2, 1) so multiply by 2
        unsigned long long n = (unsigned long long) values;
        return n * (n - 1);
        // 2147483647
        //22731434672
    }
};

#pragma clang diagnostic pop