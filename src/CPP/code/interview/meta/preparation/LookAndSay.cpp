#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include<vector>

using namespace std;

class LookAndSay {
public:
    static void description() {
        cout << R"(Question 2: Look and Say
    Implement a function that outputs the Look and Say sequence:
        https://en.wikipedia.org/wiki/Look-and-say_sequence

    Example 1:
        Input: 1
        Output:
            1

    Example 2:
        Input: 4
        Output:
            1
            11
            21
            1211

    Example 3:
        Input: 10
        Output:
            1
            11
            21
            1211
            111221
            312211
            13112221
            1113213211
            31131211131221
            13211311123113112211)" << endl;
    }

    static vector<string> lookAndSay(const int iterations) {
        // initialize vector so the spaces are available
        vector<string> result;
        if (0 < iterations) {
            result.emplace_back("1");
        }
        int index = 0;
        while (index < iterations - 1) {
            string working;
            int count = 0;
            char last = result[result.size() - 1].at(0);
            for (char character: result.at(result.size() - 1)) {
                if (last == character) {
                    count++;
                } else {
                    working += to_string(count) + last;
                    last = character;
                    count = 1;
                }
            }
            working += to_string(count) + last;
            result.push_back(working);
            index++;
        }
        return result;
    }
};

#pragma clang diagnostic pop