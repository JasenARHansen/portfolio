#ifndef LEETCODE_TOP_INTERVIEW_150_H_INDEX_TEST
#define LEETCODE_TOP_INTERVIEW_150_H_INDEX_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/H_Index.cpp"

TEST(H_IndexTest, description) {
    testing::internal::CaptureStdout();
    H_Index::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(H_IndexTest, hIndex_1) {
    auto expected = 3;
    vector<int> citations{3, 0, 6, 1, 5};
    auto result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_2) {
    auto expected = 1;
    vector<int> citations{1, 3, 1};
    auto result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_3) {
    auto expected = 1;
    vector<int> citations{100};
    auto result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_4) {
    auto expected = 1;
    vector<int> citations{1, 1};
    auto result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_5) {
    auto expected = 2;
    vector<int> citations{4, 4, 0, 0};
    auto result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_6) {
    auto expected = 3;
    vector<int> citations{1, 7, 9, 4};
    auto result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_fail_1) {
    // 1 <= citations.length
    auto size = 0;
    vector<int> citations(size);
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

TEST(H_IndexTest, hIndex_fail_2) {
    // citations.length n <= 5000
    auto size = 5000 + 1;
    vector<int> citations(size);
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

TEST(H_IndexTest, hIndex_fail_3) {
    // 0 <= citations[i]
    auto value = -1;
    vector<int> citations{1, value, 1};
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

TEST(H_IndexTest, hIndex_fail_4) {
    // citations[i] <= 1000
    auto value = 1000 + 1;
    vector<int> citations{1, value, 1};
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

#endif