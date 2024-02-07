#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class GameOfTwoStacks {
public:
    static void description() {
        cout << R"(Stacks: Game of Two Stacks
    Alexa has two stacks of non-negative integers, stack a[n] and stack b[m] where index 0 denotes the
     top of the stack.
    Alexa challenges Nick to play the following game:
        In each move, Nick can remove one integer from the top of either stack a or stack b.
        Nick keeps a running sum of the integers he removes from the two stacks.
        Nick is disqualified from the game if, at any point, his running sum becomes greater than some
         integer maxSum given at the beginning of the game.
        Nick's final score is the total number of integers he has removed from the two stacks.
    Given a, b, and maxSum for g games, find the maximum possible score Nick can achieve.
    Example:
        maxSum = 12
        a = [1, 2, 3, 4, 5]
        b = [6, 7, 8, 9]
        The maximum number of values Nick can remove is 4.
        There are two sets of choices with this result.
        1. Remove 1, 2, 3, 4 from a with a sum of 10.
        2. Remove 1, 2, 3 from a and 6 from with a sum of 12.
    Function Description:
        Complete the twoStacks function in the editor below.
        twoStacks has the following parameters:
            int maxSum: the maximum allowed sum
            int a[n]: the first stack
            int b[m]: the second stack
        Returns:
            int: the maximum number of selections Nick can make
    Input Format:
    The first line contains an integer, g(the number of games).
    The 3 * g subsequent lines describe each game in the following format:
        The first line contains three space-separated integers describing the respective values of n
         (the number of integers in stack a), m (the number of integers in stack b), and maxSum (the
         number that the sum of the integers removed from the two stacks cannot exceed).
        The second line contains n space-separated integers, the respective values of a[i].
        The third line contains m space-separated integers, the respective values of b[i].
    Constraints:
        1 ≤ g ≤ 50
        1 ≤ n, m ≤ 10^5
        0 ≤ a[i], b[i] ≤ 10^6
        1 ≤ maxSum ≤ 10^6
    Subtasks:
        1 ≤ n, m ≤ 100 for 50% of the maximum score.
    Sample Input 0:
        1
        5 4 10
        4 2 4 6 1
        2 1 8 5
    Sample Output 0:
        4
    Explanation 0:
        The two stacks initially look like this:
            4
            2 2
            4 1
            6 8
            1 5
            A B
        The image below depicts the integers Nick should choose to remove from the stacks.
        We print 4 as our answer, because that is the maximum number of integers that can be removed
         from the two stacks without the sum exceeding maxSum = 10.
           move 1 4     move 2  4   move 3  4   move 4  4
                                  2           2         2 2
                  2 2           2           2 1           1
                  4 1           4 1         4           4
                  6 8           6 8         6 8         6 8
                  1 5           1 5         1 5         1 5
                  A B           A B         A B         A B
        Note: There can be multiple ways to remove the integers from the stack, the above shows just one
         of them.)" << endl;
    }

    static int twoStacks(int maxSum, const vector<int> &a, const vector<int> &b) {
        // Sum of values stored in stacks
        auto sumLeft = 0l;
        auto sumRight = 0l;
        // data structures for processing
        stack<int> sourceLeft;
        stack<int> sourceRight;
        stack<int> useLeft;
        stack<int> useRight;
        // Populate source stacks from source vectors
        for (auto index = (int) a.size() - 1; index >= 0; index--) {
            sourceLeft.push(a.at(index));
        }
        for (auto index = (int) b.size() - 1; index >= 0; index--) {
            sourceRight.push(b.at(index));
        }
        // Set up initial storage
        while ((!sourceLeft.empty()) and ((sumLeft + sourceLeft.top()) <= (long) maxSum)) {
            useLeft.push(sourceLeft.top());
            sourceLeft.pop();
            sumLeft += useLeft.top();
        }
        while ((!sourceRight.empty()) and
               ((sumLeft + sumRight + sourceRight.top()) <= (long) maxSum)) {
            useRight.push(sourceRight.top());
            sourceRight.pop();
            sumRight += useRight.top();
        }
        // First possible permutation with Primary being used first
        auto result = useLeft.size() + useRight.size();
        // Process stacks to find next combination: Removing element that came from Primary and adding elements from Secondary
        while (!useLeft.empty()) {
            sumLeft -= useLeft.top();
            useLeft.pop();
            while ((!sourceRight.empty()) and
                   ((sumLeft + sumRight + sourceRight.top()) <= (long) maxSum)) {
                sumRight += sourceRight.top();
                useRight.push(sourceRight.top());
                sourceRight.pop();
            }
            if (result < (useLeft.size() + useRight.size())) {
                result = useLeft.size() + useRight.size();
            }
        }
        return (int) result;
    }
};

#pragma clang diagnostic pop