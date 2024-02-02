#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <map>

using namespace std;

class SparseArray {
public:
    static void description() {
        cout << R"(Arrays: Sparse Array
    There is a collection of input strings and a collection of query strings.
    For each query string, determine how many times it occurs in the list of input strings.
    Return an array of the results.
    Example:
        stringList = ["ab", "ab", "abc"]
        queries = ["ab", "abc", "bc"]
        There are 2 instances of 'ab', 1 of 'abc' and 0 of 'bc'.
        For each query, add an element to the return array,
        results = [2, 1, 0]
    Function Description:
        Complete the function matchingStrings in the editor below.
        The function must return an array of integers representing the frequency of occurrence of
         each query string in stringList.
        matchingStrings has the following parameters:
            string stringList[n]: an array of strings to search
            string queries[q]: an array of query strings
        Returns:
            int[q]: an array of results for each query
        Input Format:
            The first line contains and integer n, the size of stringList[].
            Each of the next n lines contains a string stringList[i].
            The next line contains q, the size of queries[].
            Each of the next q lines contains a string queries[i].
    Constraints:
        1 ≤ n ≤ 1000
        1 ≤ q ≤ 1000
        1 ≤ |stringList[i], queries[i]| ≤ 20
    Sample Input 1:
        4
        aba
        baba
        aba
        xzxb
        3
        aba
        xzxb
        ab
    Sample Output 1:
        2
        1
        0
    Explanation 1:
        Here, "aba" occurs twice, in the first and third string. The string "xzxb" occurs once in the fourth string, and "ab" does not occur at all.
    Sample Input 2:
        3
        def
        de
        fgh
        3
        de
        lmn
        fgh
    Sample Output 2:
        1
        0
        1
    Sample Input 3:
        13
        abcde
        sdaklfj
        asdjf
        na
        basdn
        sdaklfj
        asdjf
        na
        asdjf
        na
        basdn
        sdaklfj
        asdjf
        5
        abcde
        sdaklfj
        asdjf
        na
        basdn
    Sample Output 3:
        1
        3
        4
        3
        2)" << endl;
    }

    static vector<int> matchingStrings(const vector<string> &stringList, const vector<string> &queries) {
        vector<int> result;
        map<string, int> data;
        for (const auto &element: stringList) {
            data[element]++;
        }
        for (const auto &query: queries) {
            if (data.count(query)) {
                result.push_back(data.at(query));
            } else {
                result.push_back(0);
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop