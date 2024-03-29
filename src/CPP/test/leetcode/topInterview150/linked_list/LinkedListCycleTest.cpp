#ifndef LEETCODE_TOP_INTERVIEW_150_LINKED_LIST_CYCLE_TEST
#define LEETCODE_TOP_INTERVIEW_150_LINKED_LIST_CYCLE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_list/LinkedListCycle.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_LinkedListCycleTest, description) {
    testing::internal::CaptureStdout();
    LinkedListCycle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_LinkedListCycleTest, hasCycle_1) {
    auto expected = true;
    vector<int> values{3, 2, 0, -4};
    auto pos = 1;
    auto head = LinkedListCycle::deserializeWithCycle(pos, values);
    auto result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(&head);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LinkedListCycleTest, hasCycle_2) {
    auto expected = true;
    vector<int> values{1, 2};
    auto pos = 0;
    auto head = LinkedListCycle::deserializeWithCycle(pos, values);
    auto result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(&head);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LinkedListCycleTest, hasCycle_3) {
    auto expected = false;
    vector<int> values{1};
    auto pos = -1;
    auto head = LinkedListCycle::deserializeWithCycle(pos, values);
    auto result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(&head);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LinkedListCycleTest, hasCycle_4) {
    auto expected = false;
    vector<int> values{};
    auto pos = -1;
    auto head = LinkedListCycle::deserializeWithCycle(pos, values);
    auto result = LinkedListCycle::hasCycle(head);
    LinkedListCycle::deleteList(&head);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LinkedListCycleTest, hasCycle_fail_1) {
    // values.length  ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<int> values(size);
    auto pos = 0;
    EXPECT_EXIT(LinkedListCycle::deserializeWithCycle(pos, values), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_LinkedListCycleTest, hasCycle_fail_2) {
    // -10^5 ≤ Node.val
    auto size = (int) -pow(10, 5) - 1;
    vector<int> values{size};
    auto pos = 0;
    EXPECT_EXIT(LinkedListCycle::deserializeWithCycle(pos, values), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_LinkedListCycleTest, hasCycle_fail_3) {
    // Node.val ≤ 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> values{size};
    auto pos = 0;
    EXPECT_EXIT(LinkedListCycle::deserializeWithCycle(pos, values), ::testing::ExitedWithCode(3), "");
}

#endif