#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cstdlib>

using namespace std;

class EditDistance {
public:
    static void description() {
        cout << R"(Question 3: Edit Distance
    Write a function that returns whether two words are exactly "one edit" away using the following signature:
        bool OneEditApart(string s1, string s2);
    An edit is:
        Inserting one character anywhere in the word (including at the beginning and end)
        Removing one character
        Replacing one character

    Examples:
        OneEditApart("cat", "dog") = false
        OneEditApart("cat", "cats") = true
        OneEditApart("cat", "cut") = true
        OneEditApart("cat", "cast") = true
        OneEditApart("cat", "at") = true
        OneEditApart("cat", "act") = false)" << endl;
    }

    static bool oneEditApart(const string &s1, const string &s2) {
        bool result = false;
        if ((s1 != s2) && (abs((int) s1.size() - (int) s2.size()) <= 1)) {
            int index = 0;
            while ((index < min(s1.size(), s2.size())) && (s1.at(index) == s2.at(index))) {
                index++;
            }
            if (s1.size() != s2.size()) {
                index = 0;
                // find the first character that is different
                while ((index < s1.size()) && (index < s2.size()) && (s1.at(index) == s2.at(index))) {
                    index++;
                }
                // Inserting one character in the shorter is equivalent to removing one character from the longer
                result = true;
                int s1Index = index;
                int s2Index = index;
                if (s1.size() > s2.size()) {
                    s1Index++;
                } else {
                    s1Index++;
                }
                // process remainder of string and look for s second point of deviation
                while ((s1Index < s1.size()) && (s2Index < s2.size())) {
                    if (s1.at(s1Index) != s2.at(s2Index)) {
                        result = false;
                        break;
                    }
                    s1Index++;
                    s2Index++;
                }
            } else {
                // Replacing one character
                result = true;
                index = 0;
                bool replaced = false;
                while (index < s1.size()) {
                    if (s1.at(index) != s2.at(index)) {
                        if (replaced) {
                            result = false;
                            break;
                        } else {
                            replaced = true;
                        }
                    }
                    index++;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop