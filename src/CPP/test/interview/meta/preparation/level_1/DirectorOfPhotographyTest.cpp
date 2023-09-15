#ifndef INTERVIEW_META_PREPARATION_DIRECTOR_OF_PHOTOGRAPHY_CHAPTER_1_TEST
#define INTERVIEW_META_PREPARATION_DIRECTOR_OF_PHOTOGRAPHY_CHAPTER_1_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/level_1/DirectorOfPhotography.cpp"  // NOLINT : Ignore .cpp import

TEST(DirectorOfPhotographyCh1Test, description) {
    testing::internal::CaptureStdout();
    DirectorOfPhotography::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_1) {
    auto expected = 1;
    int n = 5;
    string c = "APABA";
    int x = 1;
    int y = 2;
    auto result = DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y);
    EXPECT_EQ(expected, result);
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_2) {
    auto expected = 0;
    int n = 5;
    string c = "APABA";
    int x = 2;
    int y = 3;
    auto result = DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y);
    EXPECT_EQ(expected, result);
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_3) {
    auto expected = 3;
    int n = 8;
    string c = ".PBAAP.B";
    int x = 1;
    int y = 3;
    auto result = DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y);
    EXPECT_EQ(expected, result);
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_fail_1) {
    // 1 ≤ n
    int n = 1 - 1;
    string c = "APABA";
    int x = 1;
    int y = 2;
    EXPECT_EXIT(DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y), ::testing::ExitedWithCode(3), "");
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_fail_2) {
    // n ≤ 200
    int n = 200 + 1;
    string c = "APABA";
    int x = 1;
    int y = 2;
    EXPECT_EXIT(DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y), ::testing::ExitedWithCode(3), "");
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_fail_3) {
    // 1 ≤ x
    int n = 5;
    string c = "APABA";
    int x = 1 - 1;
    int y = 2;
    EXPECT_EXIT(DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y), ::testing::ExitedWithCode(3), "");
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_fail_4) {
    // x ≤ y
    int n = 5;
    string c = "APABA";
    int x = 2;
    int y = x - 1;
    EXPECT_EXIT(DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y), ::testing::ExitedWithCode(3), "");
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_fail_5) {
    // y ≤ n
    int n = 5;
    string c = "APABA";
    int x = 1;
    int y = n + 1;
    EXPECT_EXIT(DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y), ::testing::ExitedWithCode(3), "");
}

TEST(DirectorOfPhotographyCh1Test, getArtisticPhotographCount_fail_6) {
    // n ≤ 200
    int n = 200 + 1;
    string c = "APABA";
    int x = 1;
    int y = 2;
    EXPECT_EXIT(DirectorOfPhotography::getArtisticPhotographCount(n, c, x, y), ::testing::ExitedWithCode(3), "");
}

#endif