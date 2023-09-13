#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <map>

using namespace std;

class InterleavingString {
public:
    static void description() {
        cout << R"(97. Interleaving String
    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
    An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
        s = s1 + s2 + ... + sn
        t = t1 + t2 + ... + tm
        |n - m| ≤ 1
        The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.

    Example 1:
        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        Output: true
        Explanation:
            One way to obtain s3 is:
            Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
            Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
            Since s3 can be obtained by interleaving s1 and s2, we return true.

    Example 2:
        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        Output: false
        Explanation:
            Notice how it is impossible to interleave s2 with any other string to obtain s3.

    Example 3:
        Input: s1 = "", s2 = "", s3 = ""
        Output: true

    Constraints:
        0 ≤ s1.length, s2.length ≤ 100
        0 ≤ s3.length ≤ 200
        s1, s2, and s3 consist of lowercase English letters.

    Follow up:
        Could you solve it using only O(s2.length) additional memory space?)" << endl;
    }

    static bool isInterleave(const string &s1, const string &s2, const string &s3) {
        assert (s1.size() <= 100);
        assert (s2.size() <= 100);
        assert (s3.size() <= 200);
        if (s3.size() != (s1.size() + s2.size())) {
            return false;
        }
        map<string, bool> processed;
        return isInterleave(s1, 0, s2, 0, s3, 0, processed);
    }

    static bool isInterleave_2(const string &s1, const string &s2, const string &s3) {
        assert (s1.size() <= 100);
        assert (s2.size() <= 100);
        assert (s3.size() <= 200);
        if (s3.size() != (s1.size() + s2.size())) {
            return false;
        }
        return isInterleave_2(s1, 0, s2, 0, s3, 0);
    }

private:
    static bool
    isInterleave(const string &s1, int s1Index, const string &s2, int s2Index, const string &s3, int s3Index,
                 map<string, bool> &processed) {
        auto key = to_string(s1Index) + "-" + to_string(s2Index) + "-" + s3.substr(s3Index, s3.size() - s3Index);
        if (!processed.count(key)) {
            auto first = false;
            auto second = false;
            // end of all 3 strings: success
            if ((s1Index == s1.size()) && (s2Index == s2.size()) && (s3Index == s3.size())) {
                return true;
            }
                // neither string can move forward
            else if (((s1Index == s1.size()) || ((s1Index < s1.size()) && (s1.at(s1Index) != s3.at(s3Index)))) &&
                     ((s2Index == s2.size()) || ((s2Index < s2.size()) && (s2.at(s2Index) != s3.at(s3Index))))) {
                return false;
            }
                // Si index is less than size, the character of s1 matches s3,
                // s2 can not advance, either because it is at the end of the string or the character does not match.
            else if (((s1Index < s1.size()) && (s1.at(s1Index) == s3.at(s3Index))) &&
                     ((s2Index == s2.size()) || ((s2Index < s2.size()) && (s2.at(s2Index) != s3.at(s3Index))))) {
                first = isInterleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1, processed);
            }
                // S2 index is less than size, the character of s2 matches s3,
                // s1 can not advance, either because it is at the end of the string or the character does not match.
            else if (((s1Index == s1.size()) || ((s1Index < s1.size()) && (s1.at(s1Index) != s3.at(s3Index)))) &&
                     ((s2Index < s2.size()) && (s2.at(s2Index) == s3.at(s3Index)))) {
                second = isInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, processed);
            }
                // both strings can move forward
            else if ((s1Index < s1.size()) && (s1.at(s1Index) == s3.at(s3Index)) &&
                     (s2Index < s2.size()) && (s2.at(s2Index) == s3.at(s3Index))) {
                first = isInterleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1, processed);
                second = isInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, processed);
            }
            processed[key] = first || second;
        }
        return processed.at(key);
    }

    static bool
    isInterleave_2(const string &s1, int s1Index, const string &s2, int s2Index, const string &s3, int s3Index) {
        auto first = false;
        auto second = false;
        // end of all 3 strings: success
        if ((s1Index == s1.size()) && (s2Index == s2.size()) && (s3Index == s3.size())) {
            return true;
        }
            // neither string can move forward
        else if (((s1Index == s1.size()) || ((s1Index < s1.size()) && (s1.at(s1Index) != s3.at(s3Index)))) &&
                 ((s2Index == s2.size()) || ((s2Index < s2.size()) && (s2.at(s2Index) != s3.at(s3Index))))) {
            return false;
        }
            // Si index is less than size, the character of s1 matches s3,
            // s2 can not advance, either because it is at the end of the string or the character does not match.
        else if (((s1Index < s1.size()) && (s1.at(s1Index) == s3.at(s3Index))) &&
                 ((s2Index == s2.size()) || ((s2Index < s2.size()) && (s2.at(s2Index) != s3.at(s3Index))))) {
            first = isInterleave_2(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1);
        }
            // S2 index is less than size, the character of s2 matches s3,
            // s1 can not advance, either because it is at the end of the string or the character does not match.
        else if (((s1Index == s1.size()) || ((s1Index < s1.size()) && (s1.at(s1Index) != s3.at(s3Index)))) &&
                 ((s2Index < s2.size()) && (s2.at(s2Index) == s3.at(s3Index)))) {
            second = isInterleave_2(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1);
        }
            // both strings can move forward
        else if ((s1Index < s1.size()) && (s1.at(s1Index) == s3.at(s3Index)) &&
                 (s2Index < s2.size()) && (s2.at(s2Index) == s3.at(s3Index))) {
            first = isInterleave_2(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1);
            second = isInterleave_2(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1);
        }
        return first || second;
    }
};

#pragma clang diagnostic pop