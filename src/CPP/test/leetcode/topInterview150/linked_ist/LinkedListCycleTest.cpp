#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_LINKED_LIST_CYCLE_TEST
#define LEETCODE_TOP_INTERVIEW_150_LINKED_LIST_CYCLE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/LinkedListCycle.cpp"

TEST(LinkedListCycleTest, description) {
    testing::internal::CaptureStdout();
    LinkedListCycle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LinkedListCycleTest, hasCycle_1) {
    bool expected = true;
    vector<int> values{3, 2, 0, -4};
    int pos = 1;
    ListNode *head = LinkedListCycle::generateListWithCycle(pos, values);
    bool result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(values.size(), &head);
    EXPECT_EQ(expected, result);
}

TEST(LinkedListCycleTest, hasCycle_2) {
    bool expected = true;
    vector<int> values{1, 2};
    int pos = 0;
    ListNode *head = LinkedListCycle::generateListWithCycle(pos, values);
    bool result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(values.size(), &head);
    EXPECT_EQ(expected, result);
}

TEST(LinkedListCycleTest, hasCycle_3) {
    bool expected = false;
    vector<int> values{1};
    int pos = -1;
    ListNode *head = LinkedListCycle::generateListWithCycle(pos, values);
    bool result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(values.size(), &head);
    EXPECT_EQ(expected, result);
}

TEST(LinkedListCycleTest, hasCycle_4) {
    bool expected = false;
    vector<int> values{};
    int pos = -1;
    ListNode *head = LinkedListCycle::generateListWithCycle(pos, values);
    bool result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(values.size(), &head);
    EXPECT_EQ(expected, result);
}

TEST(LinkedListCycleTest, hasCycle_fail_1) {
    // values.length  <= 10^4
    int size = pow(10, 4) + 1;
    vector<int> values(size);
    int pos = 0;
    EXPECT_EXIT(LinkedListCycle::generateListWithCycle(pos, values), ::testing::ExitedWithCode(3), "");
}

TEST(LinkedListCycleTest, hasCycle_fail_2) {
    // -10^5 <= Node.val
    int size = -pow(10, 5) - 1;
    vector<int> values{size};
    int pos = 0;
    EXPECT_EXIT(LinkedListCycle::generateListWithCycle(pos, values), ::testing::ExitedWithCode(3), "");
}

TEST(LinkedListCycleTest, hasCycle_fail_3) {
    // Node.val <= 10^5
    int size = pow(10, 5) + 1;
    vector<int> values{size};
    int pos = 0;
    EXPECT_EXIT(LinkedListCycle::generateListWithCycle(pos, values), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop