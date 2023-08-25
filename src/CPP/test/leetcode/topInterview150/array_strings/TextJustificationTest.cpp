#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_TEXT_JUSTIFICATION_TEST
#define LEETCODE_TOP_INTERVIEW_150_TEXT_JUSTIFICATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/TextJustification.cpp"

TEST(TextJustificationTest, description) {
    testing::internal::CaptureStdout();
    TextJustification::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(TextJustificationTest, fullJustify_1) {
    vector<string> expected = {"This    is    an", "example  of text", "justification.  "};
    vector<string> words{"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = 16;
    vector<string> result = TextJustification::fullJustify(words, maxWidth);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TextJustificationTest, fullJustify_2) {
    vector<string> expected = {"What   must   be",
                               "acknowledgment  ",
                               "shall be        "};
    vector<string> words{"What", "must", "be", "acknowledgment", "shall", "be"};
    int maxWidth = 16;
    vector<string> result = TextJustification::fullJustify(words, maxWidth);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TextJustificationTest, fullJustify_3) {
    vector<string> expected = {"Science  is  what we",
                               "understand      well",
                               "enough to explain to",
                               "a  computer.  Art is",
                               "everything  else  we",
                               "do                  "};
    vector<string> words{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                         "explain", "to", "a", "computer.", "Art", "is", "everything", "else",
                         "we", "do"};
    int maxWidth = 20;
    vector<string> result = TextJustification::fullJustify(words, maxWidth);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TextJustificationTest, fullJustify_fail_1) {
    // 1 <= words.length;
    int size = 1 - 1;
    vector<string> words(size);
    int maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(TextJustificationTest, fullJustify_fail_2) {
    // words.length <= 300
    int size = 300 + 1;
    vector<string> words(size);
    int maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(TextJustificationTest, fullJustify_fail_3) {
    // 1 <= words[i].length
    int size = 1 - 1;
    string word(size, ' ');
    vector<string> words{word};
    int maxWidth = size + 1;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(TextJustificationTest, fullJustify_fail_4) {
    // words[i].length <= 20
    int size = 20 + 1;
    string word(size, ' ');
    vector<string> words{word};
    int maxWidth = size + 1;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(TextJustificationTest, fullJustify_fail_5) {
    // words[i].length <= maxWidth
    int size = 20;
    string word(size, ' ');
    vector<string> words{word};
    int maxWidth = size - 1;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(TextJustificationTest, fullJustify_fail_6) {
    // 1 <= maxWidth
    int size = 1 - 1;
    vector<string> words{"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(TextJustificationTest, fullJustify_fail_7) {
    // maxWidth <= 100
    int size = 100 + 1;
    vector<string> words{"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}


#endif
#pragma clang diagnostic pop