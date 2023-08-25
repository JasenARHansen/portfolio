#pragma clang diagnostic push
#pragma ide diagnostic ignored "UnusedValue"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class TextJustification {

public:

    static void description() {
        cout << R"(68. Text Justification
    Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
    For the last line of text, it should be left-justified, and no extra space is inserted between words.
    Note:
        A word is defined as a character sequence consisting of non-space characters only.
        Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
        The input array words contains at least one word.

    Example 1:
        Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
        Output:
        [
           "This    is    an",
           "example  of text",
           "justification.  "
        ]

    Example 2:
        Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
        Output:
        [
          "What   must   be",
          "acknowledgment  ",
          "shall be        "
        ]
        Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
        Note that the second line is also left-justified because it contains only one word.

    Example 3:
        Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
        Output:
        [
          "Science  is  what we",
          "understand      well",
          "enough to explain to",
          "a  computer.  Art is",
          "everything  else  we",
          "do                  "
        ]
    Constraints:
        1 <= words.length <= 300
        1 <= words[i].length <= 20
        words[i] consists of only English letters and symbols.
        1 <= maxWidth <= 100
        words[i].length <= maxWidth)" << endl;
    }

    static vector<string> fullJustify(vector<string> &words, int maxWidth) {
        assert (!words.empty());
        assert (words.size() <= 300);
        assert (1 <= maxWidth);
        assert (maxWidth <= 100);
        vector<string> result = {};
        int currentWords = 0;
        int currentCharacters = 0;
        int startIndex = 0;
        int stopIndex;
        bool last;
        bool generate;
        for (int index = 0; index < words.size(); index++) {
            assert (words[index].size() <= maxWidth);
            assert (!words[index].empty());
            assert (words[index].size() <= 20);
            if ((currentCharacters + words[index].size() + currentWords) <= maxWidth) {
                currentCharacters += words[index].size();
                // special justification if the last word is included
                if (index == words.size() - 1) {
                    last = true;
                    generate = true;
                }
                currentWords++;
                stopIndex = index;
            } else {
                generate = true;
            }
            if (generate) {
                // Process the data
                string line;
                int process = startIndex;
                line.append(words[process++]);
                if (last) {
                    for (; process <= stopIndex; process++) {
                        line.append(" ");
                        line.append(words[process]);
                    }
                    // add padding
                    if (line.size() < maxWidth) {
                        string padding(maxWidth - line.size(), ' ');
                        line.append(padding);
                    }
                } else {
                    --currentWords;
                    int filler = maxWidth - currentCharacters;
                    int paddingLength = filler;
                    int excess;
                    if (currentWords) {
                        paddingLength = filler / currentWords;
                        excess = filler - (paddingLength * currentWords);
                    }
                    int offset;
                    if (currentWords) {
                        for (; process <= stopIndex; process++) {
                            if (excess > 0) {
                                excess--;
                                offset = paddingLength + 1;
                            } else {
                                offset = paddingLength;
                            }
                            string padding(offset, ' ');
                            line.append(padding);
                            line.append(words[process]);
                        }
                    } else {
                        // add padding
                        if (line.size() < maxWidth) {
                            string padding(maxWidth - line.size(), ' ');
                            line.append(padding);
                        }
                    }
                }
                result.push_back(line);
                if (!last) {
                    // resetting index pointer
                    startIndex = index;
                    stopIndex = index;
                    index--;
                    currentWords = 0;
                    currentCharacters = 0;
                    generate = false;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop