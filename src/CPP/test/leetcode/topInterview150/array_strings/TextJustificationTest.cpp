#ifndef LEETCODE_TOP_INTERVIEW_150_TEXT_JUSTIFICATION_TEST
#define LEETCODE_TOP_INTERVIEW_150_TEXT_JUSTIFICATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/TextJustification.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_TextJustificationTest, description) {
    testing::internal::CaptureStdout();
    TextJustification::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_TextJustificationTest, fullJustify_1) {
    vector<string> expected{"This    is    an", "example  of text", "justification.  "};
    vector<string> words{"This", "is", "an", "example", "of", "text", "justification."};
    auto maxWidth = 16;
    auto result = TextJustification::fullJustify(words, maxWidth);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_TextJustificationTest, fullJustify_2) {
    vector<string> expected{"What   must   be",
                            "acknowledgment  ",
                            "shall be        "};
    vector<string> words{"What", "must", "be", "acknowledgment", "shall", "be"};
    auto maxWidth = 16;
    auto result = TextJustification::fullJustify(words, maxWidth);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_TextJustificationTest, fullJustify_3) {
    vector<string> expected{"Science  is  what we",
                            "understand      well",
                            "enough to explain to",
                            "a  computer.  Art is",
                            "everything  else  we",
                            "do                  "};
    vector<string> words{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                         "explain", "to", "a", "computer.", "Art", "is", "everything", "else",
                         "we", "do"};
    auto maxWidth = 20;
    auto result = TextJustification::fullJustify(words, maxWidth);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_TextJustificationTest, fullJustify_fail_1) {
    // 1 ≤ words.length;
    auto size = 1 - 1;
    vector<string> words(size);
    auto maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TextJustificationTest, fullJustify_fail_2) {
    // words.length ≤ 300
    auto size = 300 + 1;
    vector<string> words(size);
    auto maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TextJustificationTest, fullJustify_fail_3) {
    // 1 ≤ words[i].length
    auto size = 1 - 1;
    string word(size, ' ');
    vector<string> words{word};
    auto maxWidth = size + 1;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TextJustificationTest, fullJustify_fail_4) {
    // words[i].length ≤ 20
    auto size = 20 + 1;
    string word(size, ' ');
    vector<string> words{word};
    auto maxWidth = size + 1;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TextJustificationTest, fullJustify_fail_5) {
    // words[i].length ≤ maxWidth
    auto size = 20;
    string word(size, ' ');
    vector<string> words{word};
    auto maxWidth = size - 1;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TextJustificationTest, fullJustify_fail_6) {
    // 1 ≤ maxWidth
    auto size = 1 - 1;
    vector<string> words{"This", "is", "an", "example", "of", "text", "justification."};
    auto maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TextJustificationTest, fullJustify_fail_7) {
    // maxWidth ≤ 100
    auto size = 100 + 1;
    vector<string> words{"This", "is", "an", "example", "of", "text", "justification."};
    auto maxWidth = size;
    EXPECT_EXIT(TextJustification::fullJustify(words, maxWidth), ::testing::ExitedWithCode(3), "");
}

#endif