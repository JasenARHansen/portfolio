#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class Waiter {
public:
    static void description() {
        cout << R"(Stacks: Waiter
    You are a waiter at a party.
    There is a pile of numbered plates.
    Create an empty answers array.
    At each iteration, i, remove each plate from the top of the stack in order.
    Determine if the number on the plate is evenly divisible by the ith prime number.
    If it is, stack it in pile Bi.
    Otherwise, stack it in stack Ai.
    Store the values in Bi from top to bottom in answers.
    In the next iteration, do the same with the values in stack Ai.
    Once the required number of iterations is complete, store the remaining values in Ai in answers, again
     from top to bottom.
    Return the answers array.
    Example:
        A = [2, 3, 4, 5, 6, 7]
        q = 3
        An abbreviated list of primes is [2, 3, 5, 7, 11, 13].
        Stack the plates in reverse order.
        A0 = [2, 3, 4, 5, 6, 7]
        answers = []
        Begin iterations.
        On the first iteration, check if items are divisible by 2.
        A1 = [7, 5, 3]
        B1 = [6, 4, 2]
        Move B1 elements to answers.
        answers = [2, 4, 6]
        On the second iteration, test if A1 elements are divisible by 3.
        A2 = [7, 5]
        B2 = [3]
        Move B2 elements to answers.
        answers = [2, 4, 6, 3]
        And on the third iteration, test if A3 elements are divisible by 5.
        A3 = [7]
        B3 = [5]
        Move B2 elements to answers.
        answers = [2, 4, 6, 3, 5]
        All iterations are complete, so move the remaining elements in A3, from top to bottom, to answers.
        answers = [2, 4, 6, 3, 5, 7]
        Return this list.
    Function Description:
        Complete the waiter function in the editor below.
        waiter has the following parameters:
            int number[n]: the numbers on the plates
            int q: the number of iterations
        Returns:
            int[n]: the numbers on the plates after processing
    Input Format:
        The first line contains two space separated integers, n and q.
        The next line contains n space separated integers representing the initial pile of plates, i.e., A.
    Constraints:
        1 ≤ n ≤ 5 * 10^5
        2 ≤ number[i] ≤ 5 * 10^4
        1 ≤ q ≤ 1200
    Sample Input 0:
        5 1
        3 4 7 6 5
    Sample Output 0:
        4
        6
        3
        7
        5
    Explanation 0:
        Initially:
        A = [3, 4, 7, 6, 5] ← TOP
        After 1 iteration (divide by 2, the 1st prime number):
        A1 = [5, 7, 3] ← TOP
        B1 = [6, 4] ← TOP
        Move B1 elements to answers.
        answers = [4, 6]
        All iterations are complete, so move A1 elements to answers.
        answers = [4, 6, 3, 7, 5]
        Sample Input 1:
            5 2
            3 3 4 4 9
    Sample Output 1:
        4
        4
        9
        3
        3
    Explanation 1:
        Initially:
        A = [3, 3, 4, 4, 9] ← TOP
        After 1st iteration (divide by 2):
        A1 = [9, 3, 3] ← TOP
        B1 = [4, 4] ← TOP
        Move B1 to answers.
        answers = [4, 4]
        After 2nd iteration (divide by 3):
        A2 = [] ←  TOP
        B2 = [3, 3, 9] ← TOP
        Move B2 elements to answers.
        answers = [4, 4, 9, 3, 3]
        There are no values remaining in A2.)" << endl;
    }

    static vector<int> waiter(const vector<int> &number, int q) {
        vector<int> answers;
        auto prime = 1;
        stack<int> *A;
        stack<int> *processing;
        stack<int> evenA;
        stack<int> oddA;
        stack<int> B;
        for (auto value: number) {
            oddA.push(value);
        }
        for (auto index = 0; (index < q) and (!evenA.empty() or !oddA.empty()); index++) {
            if (index % 2) {
                A = &evenA;
                processing = &oddA;
            } else {
                A = &oddA;
                processing = &evenA;
            }
            prime = nextPrime(prime);
            while (!A->empty()) {
                if (A->top() % prime) {
                    processing->push(A->top());
                } else {
                    B.push(A->top());
                }
                A->pop();
            }
            while (!B.empty()) {
                answers.push_back(B.top());
                B.pop();
            }
        }
        if (!evenA.empty() or !oddA.empty()) {
            if (evenA.empty()) {
                A = &oddA;
            } else {
                A = &evenA;
            }
            while (!A->empty()) {
                answers.push_back(A->top());
                A->pop();
            }
        }
        return answers;
    }

private:
    static int nextPrime(int value) {
        if ((value == 1) or (value == 2)) {
            return value + 1;
        }
        auto result = value;
        while (true) {
            result++;
            auto valid = true;
            for (auto test = 2; test <= result / 2; test++) {
                if (!(result % test)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                break;
            }
        }
        return result;
    }

};

#pragma clang diagnostic pop