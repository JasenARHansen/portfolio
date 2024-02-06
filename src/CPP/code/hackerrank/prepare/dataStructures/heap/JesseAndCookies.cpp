#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class JesseAndCookies {
public:
    static void description() {
        cout << R"(Heaps: Jesse and Cookies
    Jesse loves cookies and wants the sweetness of some cookies to be greater than value k.
    To do this, two cookies with the least sweetness are repeatedly mixed.
    This creates a special combined cookie with:
        sweetness = ( 1 * Least sweet cookie + 2 * 2nd least sweet cookie).
    This occurs until all the cookies have a sweetness ≥ k.
    Given the sweetness of a number of cookies, determine the minimum number of operations required.
    If it is not possible, return -1.
    Example:
        k = 9
        A = [2, 7, 3, 6, 4, 6]
        The smallest values are 2, 3.
        Remove them then return 2 + 2 * 3 = 8 to the array.
        Now A = [8, 7, 6, 4, 6].
        Remove 4, 6 and return 4 + 2 * 6 = 14 to the array.
        Now A = [16, 8, 7, 6].
        Remove 6, 7, return 4 + 2 * 7 = 20.
        Now A = [20, 16, 8].
        Finally, remove 8, 16 and return 8 + 2 * 16 = 40 to he array.
        Now A = [39, 20].
        All values are so the process stops after iterations.
        Return 4.
    Function Description:
        Complete the cookies function in the editor below.
        cookies has the following parameters:
            int k: the threshold value
            int A[n]: an array of sweetness values
    Returns:
        int: the number of iterations required or -1
    Input Format:
        The first line has two space-separated integers, n and k, the size of A[] and the minimum required
         sweetness respectively.
        The next line contains n space-separated integers, A[i].
    Constraints:
        1 ≤ n ≤ 10^6
        0 ≤ k ≤ 10^9
        0 ≤ A[i] ≤ 10^6
    Sample Input:
        STDIN               Function
        -----               --------
        6 7                 A[] size n = 6, k = 7
        1 2 3 9 10 12       A = [1, 2, 3, 9, 10, 12]
    Sample Output:
        2
    Explanation:
        Combine the first two cookies to create a cookie with sweetness 1 + 2 * 2 = 5
        After this operation, the cookies are 3, 5, 9, 10, 12.
        Then, combine the cookies with sweetness 3 and sweetness 5, to create a cookie with resulting
         sweetness 3 + 2 * 5 = 13
        Now, the cookies are 9, 10, 12, 13.
        All the cookies have a sweetness ≥ 7.
        Thus, 2operations are required to increase the sweetness.)" << endl;
    }

    static int cookies(int k, const vector<int> &A) {
        auto result = 0;
        priority_queue<int, vector<int>, greater<>> minHeap;
        for (auto cookie: A) {
            minHeap.push(cookie);
        }
        while ((minHeap.size() > 1) and (minHeap.top() < k)) {
            auto first = minHeap.top();
            minHeap.pop();
            auto second = minHeap.top();
            minHeap.pop();
            minHeap.push(first + 2 * second);
            result++;
        }
        return (minHeap.top() >= k) ? result : -1;
    }
};

#pragma clang diagnostic pop