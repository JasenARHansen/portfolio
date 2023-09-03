#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_PARTITION_LIST_TEST
#define LEETCODE_TOP_INTERVIEW_150_PARTITION_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/PartitionList.cpp"

TEST(PartitionListTest, description) {
    testing::internal::CaptureStdout();
    PartitionList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PartitionListTest, partition_1) {
    vector<int> expectedValues{1,2,2,4,3,5};
    ListNode *expected = PartitionList::generateList(expectedValues);
    vector<int> headValues{1,4,3,2,5,2};
    ListNode *head = PartitionList::generateList(headValues);
    int x = 3;
    ListNode *result = PartitionList::partition(head, x);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    PartitionList::deleteList(expectedValues.size(), &expected);
    PartitionList::deleteList(expectedValues.size(), &result);
}

TEST(PartitionListTest, partition_2) {
    vector<int> expectedValues{1,2};
    ListNode *expected = PartitionList::generateList(expectedValues);
    vector<int> headValues{2,1};
    ListNode *head = PartitionList::generateList(headValues);
    int x = 2;
    ListNode *result = PartitionList::partition(head, x);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    PartitionList::deleteList(expectedValues.size(), &expected);
    PartitionList::deleteList(expectedValues.size(), &result);
}

TEST(PartitionListTest, partition_3) {
    vector<int> expectedValues{1,0,2,2,4,3,5};
    ListNode *expected = PartitionList::generateList(expectedValues);
    vector<int> headValues{1,4,3,0,2,5,2};
    ListNode *head = PartitionList::generateList(headValues);
    int x = 3;
    ListNode *result = PartitionList::partition(head, x);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    PartitionList::deleteList(expectedValues.size(), &expected);
    PartitionList::deleteList(expectedValues.size(), &result);
}

TEST(PartitionListTest, partition_4) {
    vector<int> expectedValues{1,1};
    ListNode *expected = PartitionList::generateList(expectedValues);
    vector<int> headValues{1,1};
    ListNode *head = PartitionList::generateList(headValues);
    int x = 2;
    ListNode *result = PartitionList::partition(head, x);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    PartitionList::deleteList(expectedValues.size(), &expected);
    PartitionList::deleteList(expectedValues.size(), &result);
}

TEST(PartitionListTest, partition_5) {
    vector<int> expectedValues{1,2,3};
    ListNode *expected = PartitionList::generateList(expectedValues);
    vector<int> headValues{1,2,3};
    ListNode *head = PartitionList::generateList(headValues);
    int x = 3;
    ListNode *result = PartitionList::partition(head, x);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    PartitionList::deleteList(expectedValues.size(), &expected);
    PartitionList::deleteList(expectedValues.size(), &result);
}

TEST(PartitionListTest, partition_fail_1) {
    // n <= 200
    int size = 200 + 1;
    vector<int> values(size);
    EXPECT_EXIT(PartitionList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(PartitionListTest, partition_fail_2) {
    // -100 <= Node.val
    int size = -100 - 1;
    vector<int> values{size};
    EXPECT_EXIT(PartitionList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(PartitionListTest, partition_fail_3) {
    // Node.val <= 100
    int size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(PartitionList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(PartitionListTest, partition_fail_4) {
    // -200 <= x
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = PartitionList::generateList(headValues);
    int x = -200 - 1;
    EXPECT_EXIT(PartitionList::partition(head, x), ::testing::ExitedWithCode(3), "");
    PartitionList::deleteList(headValues.size(), &head);
}

TEST(PartitionListTest, partition_fail_5) {
    // x <= 200
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = PartitionList::generateList(headValues);
    int x = 200 + 1;
    EXPECT_EXIT(PartitionList::partition(head, x), ::testing::ExitedWithCode(3), "");
    PartitionList::deleteList(headValues.size(), &head);
}

#endif
#pragma clang diagnostic pop