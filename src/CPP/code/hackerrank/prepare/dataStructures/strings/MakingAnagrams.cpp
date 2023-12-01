#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>

using namespace std;


class MakingAnagrams {

public:
    static void description() {
        cout << R"(Strings: Making Anagrams:
    A student is taking a cryptography class and has found anagrams to be very useful.
    Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string.
    In other words, both strings must contain the same exact letters in the same exact frequency.
    For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

    The student decides on an encryption scheme that involves two large strings.
    The encryption is dependent on the minimum number of character deletions required to make the two strings anagrams.
    Determine this number.

    Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character
     deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.

    Example:
        a = cde
        b = dcf
        Delete e from a and f from b so that the remaining strings are and which are anagrams.
        This takes 2 character deletions.

    Function Description:
        Complete the makeAnagram function in the editor below.
            makeAnagram has the following parameter(s):
                string a: a string
                string b: another string
            Returns:
                int: the minimum total characters that must be deleted
            Input Format:
                The first line contains a single string, a.
                The second line contains a single string, b.
            Constraints:
                1 ≤ |a|, |b| ≤ 10^4
                The strings a and b consist of lowercase English alphabetic letters, ascii[a-z].

    Sample Input:
        cde
        abc

    Sample Output:
        4

    Explanation:
        Delete the following characters from the strings make them anagrams:
            Remove d and e from cde to get c.
            Remove a and b from abc to get c.

        It takes 4 deletions to make both strings anagrams.)" << endl;
    }

    static int makeAnagram(const string &a, const string &b) {
        auto result = 0;
        map<char, int> countA = processString(a);
        map<char, int> countB = processString(b);
        set<char> keys;
        // Retrieve all keys
        for (std::map<char, int>::iterator it = countA.begin(); it != countA.end(); ++it) {
            keys.insert(it->first);
        }
        for (std::map<char, int>::iterator it = countB.begin(); it != countB.end(); ++it) {
            keys.insert(it->first);
        }
        for (auto key: keys) {
            auto aCount = 0;
            if (countA.count(key)) {
                aCount = countA.at(key);
            }
            auto bCount = 0;
            if (countB.count(key)) {
                bCount = countB.at(key);
            }
            result += abs(aCount - bCount);
        }
        return result;
    }

private:
    static map<char, int> processString(const string &input) {
        map<char, int> result;
        for (char character: input) {
            if (result.count(character)) {
                result.at(character)++;
            } else {
                result[character] = 1;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop