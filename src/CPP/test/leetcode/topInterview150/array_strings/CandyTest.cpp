#ifndef LEETCODE_TOP_INTERVIEW_150_RATINGS_STATION_TEST
#define LEETCODE_TOP_INTERVIEW_150_RATINGS_STATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/In_progress_Candy.cpp"

TEST(CandyTest, description) {
    testing::internal::CaptureStdout();
    Candy::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CandyTest, candy_1) {
    auto expected = 5;
    vector<int> ratings{1, 0, 2};
    //auto result = Candy::candy(ratings);
    //EXPECT_EQ(expected, result);
}

TEST(CandyTest, candy_2) {
    auto expected = 4;
    vector<int> ratings{1, 2, 2};
    //auto result = Candy::candy(ratings);
    //EXPECT_EQ(expected, result);
}

TEST(CandyTest, candy_3) {
    auto expected = 6;
    vector<int> ratings{3, 3, 3, 3};
    //auto result = Candy::candy(ratings);
    //EXPECT_EQ(expected, result);
}

TEST(CandyTest, candy_4) {
    auto expected = 6;
    vector<int> ratings{3, 2, 2, 3, 4, 2, 2};
    auto result = Candy::candy(ratings);
    EXPECT_EQ(expected, result);
}

TEST(CandyTest, candy_fail_1) {
    // 1 <= ratings.length
    auto size = 1 - 1;
    vector<int> ratings(size);
    EXPECT_EXIT(Candy::candy(ratings), ::testing::ExitedWithCode(3), "");
}

TEST(CandyTest, candy_fail_2) {
    // ratings.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<int> ratings(size);
    EXPECT_EXIT(Candy::candy(ratings), ::testing::ExitedWithCode(3), "");
}

TEST(CandyTest, candy_fail_3) {
    // 0 <= ratings[i]
    auto value = 0 - 1;
    vector<int> ratings{1, 2, value, 4, 5};
    EXPECT_EXIT(Candy::candy(ratings), ::testing::ExitedWithCode(3), "");
}

TEST(CandyTest, candy_fail_4) {
    // ratings[i] <= 2 * 10^4
    auto value = 2 * (int) pow(10, 4) + 1;;
    vector<int> ratings{1, 2, value, 4, 5};
    EXPECT_EXIT(Candy::candy(ratings), ::testing::ExitedWithCode(3), "");
}

#endif