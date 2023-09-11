#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>

using namespace std;

static unordered_map<char, char> letterMap{{'A', 'B'},
                                           {'B', 'A'}};

class AllWrong {

public:
    static void description() {
        cout << R"(All Wrong
    There's a multiple-choice test with N questions, numbered from 11 to N. Each question has 22 answer options, labelled A and B. You know that the correct answer for the Ith question is the Ith character in the string C, which is either "A" or "B", but you want to get a score of 0 on this test by answering every question incorrectly.
    Your task is to implement the function getWrongAnswers(N, C) which returns a string with N characters, the Ith of which is the answer you should give for question I in order to get it wrong (either "A" or "B").

    Constraints
        1 ≤ N ≤ 100
        Ci∈{'A','B'}

    Sample test case #1
        N = 3
        C = ABA
        Expected Return Value = ABA

    Sample test case #2
        N = 5
        C = BBBBB
        Expected Return Value = AAAAA

    Sample Explanation
        In the first case the correct answers to the 33 questions are A, B, and A, in that order. Therefore, in order to get them all wrong, the 33 answers you should give are B, A, and B, in that order.
        In the second case the correct answers are all B, so you should answer each question with A.)" << endl;
    }

    static string getWrongAnswers(int n, const string &c) {
        assert(1 <= n);
        assert(n <= 100);
        assert(n <= c.size());
        string result;
        for (int index = 0; index < n; index++) {
            assert(letterMap.count(c.at(index)));
            result += letterMap.at(c.at(index));
        }
        return result;
    }

};

#pragma clang diagnostic pop