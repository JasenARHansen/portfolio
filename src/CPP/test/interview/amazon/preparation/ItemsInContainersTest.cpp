#ifndef INTERVIEW_AMAZON_PREPARATION_ITEMS_IN_CONTAINERS_TEST
#define INTERVIEW_AMAZON_PREPARATION_ITEMS_IN_CONTAINERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/amazon/preparation/ItemsInContainers.cpp"  // NOLINT : Ignore .cpp import

TEST(ItemsInContainers_Test, description) {
    testing::internal::CaptureStdout();
    ItemsInContainers::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ItemsInContainers_Test, numberOfItems_1) {
    vector<int> expected{2, 3};
    string s = "|**|*|*";
    vector<int> startIndices{1, 1};
    vector<int> endIndices{5, 6};
    auto result = ItemsInContainers::numberOfItems(s, startIndices, endIndices);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(ItemsInContainers_Test, numberOfItems_2) {
    vector<int> expected{0};
    string s = "*|*|";
    vector<int> startIndices{1};
    vector<int> endIndices{3};
    auto result = ItemsInContainers::numberOfItems(s, startIndices, endIndices);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(ItemsInContainers_Test, numberOfItems_3) {
    vector<int> expected{2};
    string s = "*|*|*|";
    vector<int> startIndices{1};
    vector<int> endIndices{6};
    auto result = ItemsInContainers::numberOfItems(s, startIndices, endIndices);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

#endif