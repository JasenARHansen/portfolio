#ifndef CTCI_CH_2_LINKED_LISTS_INTERSECTION_TEST
#define CTCI_CH_2_LINKED_LISTS_INTERSECTION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/Intersection.h"

TEST(IntersectionTest, description) {
    testing::internal::CaptureStdout();
    Intersection::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(IntersectionTest, intersection_1) {
    vector<int> data1{0, 1, 2, 3, 4, 5, 6};
    vector<int> data2{0, 1, 2, 3, 4, 5, 6};
    auto lists = Intersection::generateList(data1, data2);
    auto result = Intersection::intersection(lists.first, lists.second);
    EXPECT_EQ(nullptr, result);
    Intersection::deleteList(&lists.first, &lists.second);
}

TEST(IntersectionTest, intersection_2) {
    vector<int> data1{0, 1, 2, 3};
    vector<int> data2{0, 1, 2, 3, 4, 5, 6};
    auto lists = Intersection::generateList(data1, data2);
    auto result = Intersection::intersection(lists.first, lists.second);
    EXPECT_NE(nullptr, result);
    Intersection::deleteList(&lists.first, &lists.second);
}

#endif