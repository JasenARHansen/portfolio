#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <regex>

using namespace std;

class AlternatingCharacters {
public:
    static void description() {
        cout << R"(Strings: Alternating Characters:
    You are given a string containing characters A and B only.
    Your task is to change it into a string such that there are no matching adjacent characters.
    To do this, you are allowed to delete zero or more characters in the string.
    Your task is to find the minimum number of required deletions.
    Example:
        s = AABAAB
        Remove an A at positions 0 and 3 to make in 2 deletions.
    Function Description:
        Complete the alternatingCharacters function in the editor below:
            alternatingCharacters has the following parameter(s):
                string s: a string
            Returns:
                int: the minimum number of deletions required
    Input Format:
        The first line contains an integer q, the number of queries.
        The next lines each contain a string s to analyze.
    Constraints:
        1 ≤ Q ≤ 10
        1 ≤ lenght of s ≤ 10^5
        Each string will consist only of characters a and b.
    Sample Input:
        5
        AAAA
        BBBBB
        ABABABAB
        BABABA
        AAABBB
    Sample Output:
        3
        4
        0
        0
        4
    Explanation:
        The characters marked IN LOWER CASE are the ones that can be deleted so that the string does not have matching adjacent characters.
            Aaaa → A (3 deletions)
            Bbbbb → B (4 deletions)
            ABABABAB → ABABABAB (0 deletions)
            BABABA → BABABA (0 deletions)
            AaaBbb → AB (4 deletions))" << endl;
    }

    static string ltrim(const string &s) {
        const string nothing;
        return regex_replace(s, std::regex("^\\s+"), nothing);
    }

    static string rtrim(const string &s) {
        const string nothing;
        return regex_replace(s, std::regex("\\s+$"), nothing);
    }

    static int alternatingCharacters(const string &s) {
        auto result = 0;
        auto base = ltrim(s);
        base = rtrim(base);
        auto last = base[0];
        for (auto index = 1; index < base.size(); index++) {
            if (base[index] == last) {
                result++;
            } else {
                last = base[index];
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop