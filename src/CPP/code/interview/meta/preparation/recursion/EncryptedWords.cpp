#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class EncryptedWords {
public:
    static void description() {
        cout << R"(Encrypted Words
    You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way
     that the resulting string is hard to quickly read, but is easy to convert back into the original string.
    When you encrypt a string S, you start with an initially-empty resulting string R and append
     characters to it as follows:
        Append the middle character of S (if S has even length, then we define the middle character
         as the left-most of the two central characters)
        Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
        Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
    For example, to encrypt the string "abc", we first take "b", and then append the encrypted version of
     "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
    If we encrypt "abcxcba" we'll get "xbacbca".
    That is, we take "x" and then append the encrypted version "abc" and then append the encrypted version of "cba".
    Input:
        S contains only lower-case alphabetic characters
        1 <= |S| <= 10, 000
    Output:
        Return string R, the encrypted version of S.
    Example 1:
        S = "abc"
        R = "bac"
    Example 2:
        S = "abcd"
        R = "bacd"
    Example 3:
        S = "abcxcba"
        R = "xbacbca"
    Example 4:
        S = "facebook"
        R = "eafcobok")" << endl;
    }

    static string findEncryptedWord(const string &s) {
        string result;
        if (s.size() <= 1) {
            result = s;
        } else {
            auto index = (s.size() - 1) / 2;
            result += s.at(index);
            result += findEncryptedWord(s.substr(0, index));
            result += findEncryptedWord(s.substr(index + 1, s.size()));
        }
        return result;
    }
};

#pragma clang diagnostic pop