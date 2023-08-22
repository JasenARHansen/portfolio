#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    int expected = 3;
    vector<int> citations{3, 0, 6, 1, 5};
    int result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_2) {
    int expected = 1;
    vector<int> citations{1, 3, 1};
    int result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_3) {
    int expected = 1;
    vector<int> citations{100};
    int result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_4) {
    int expected = 1;
    vector<int> citations{1, 1};
    int result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_5) {
    int expected = 2;
    vector<int> citations{4,4,0,0};
    int result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_6) {
    int expected = 3;
    vector<int> citations{1,7,9,4};
    int result = H_Index::hIndex(citations);
    EXPECT_EQ(expected, result);
}

TEST(H_IndexTest, hIndex_fail_1) {
    // 1 <= citations.length
    int size = 0;
    vector<int> citations(size);
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

TEST(H_IndexTest, hIndex_fail_2) {
    // citations.length n <= 5000
    int size = 5000 + 1;
    vector<int> citations(size);
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

TEST(H_IndexTest, hIndex_fail_3) {
    // 0 <= citations[i]
    int value = -1;
    vector<int> citations{1, value, 1};
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

TEST(H_IndexTest, hIndex_fail_4) {
    // citations[i] <= 1000
    int value = 1000 + 1;
    vector<int> citations{1, value, 1};
    EXPECT_EXIT(H_Index::hIndex(citations), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop