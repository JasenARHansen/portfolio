#ifndef INTERVIEW_META_PREPARATION_CAFETERIA_TEST
#define INTERVIEW_META_PREPARATION_CAFETERIA_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/level_1/Cafeteria.cpp"

TEST(CafeteriaTest, description) {
    testing::internal::CaptureStdout();
    Cafeteria::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_1) {
    auto expected = 3;
    long long n = 10;
    long long k = 1;
    int m = 2;
    vector<long long> s{2, 6};
    auto result = Cafeteria::getMaxAdditionalDinersCount(n, k, m, s);
    EXPECT_EQ(expected, result);
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_2) {
    auto expected = 1;
    long long n = 15;
    long long k = 2;
    int m = 3;
    vector<long long> s{11, 6, 14};
    auto result = Cafeteria::getMaxAdditionalDinersCount(n, k, m, s);
    EXPECT_EQ(expected, result);
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_1) {
    // 1 ≤ n
    long long n = 1 - 1;
    long long k = 1;
    int m = 2;
    vector<long long> s{2, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_2) {
    // n ≤ 10^15
    long long n = (long long) pow(10, 15) + 1;
    long long k = 1;
    int m = 2;
    vector<long long> s{2, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_3) {
    // 1 ≤ k
    long long n = 10;
    long long k = 1 - 1;
    int m = 2;
    vector<long long> s{2, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_4) {
    // k ≤ n
    long long n = 10;
    long long k = n + 1;
    int m = 2;
    vector<long long> s{2, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_5) {
    // 1 ≤ m
    long long n = 10;
    long long k = 1;
    int m = 1 - 1;
    vector<long long> s{2, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_6) {
    // m ≤ 5 * 10^5
    long long n = 10;
    long long k = 1;
    int m = (int) (5 * pow(10, 5) + 1);
    vector<long long> s{2, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_7) {
    // m ≤ 5 * 10^5
    long long n = 10;
    long long k = 1;
    int m = (int) n + 1;
    vector<long long> s{2, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_8) {
    // 1 ≤ si
    long long n = 10;
    long long k = 1;
    int m = 2;
    auto size = 1 - 1;
    vector<long long> s{size, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

TEST(CafeteriaTest, getMaxAdditionalDinersCount_fail_9) {
    // si ≤ n
    long long n = 10;
    long long k = 1;
    int m = 2;
    auto size = n + 1;
    vector<long long> s{size, 6};
    EXPECT_EXIT(Cafeteria::getMaxAdditionalDinersCount(n, k, m, s), ::testing::ExitedWithCode(3), "");
}

#endif