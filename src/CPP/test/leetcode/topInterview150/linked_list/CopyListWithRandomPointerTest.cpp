#ifndef LEETCODE_TOP_INTERVIEW_150_COPY_LIST_WITH_RANDOM_POINTER_TEST
#define LEETCODE_TOP_INTERVIEW_150_COPY_LIST_WITH_RANDOM_POINTER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_list/CopyListWithRandomPointer.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_CopyListWithRandomPointerTest, description) {
    testing::internal::CaptureStdout();
    CopyListWithRandomPointer::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_CopyListWithRandomPointerTest, copyRandomList_1) {
    vector<pair<int, string>> expected{{7,  "null"},
                                       {13, "0"},
                                       {11, "4"},
                                       {10, "2"},
                                       {1,  "0"}};
    auto head = CopyListWithRandomPointer::deserializeListRandomPointer(expected);
    auto copy = CopyListWithRandomPointer::copyRandomList(head);
    auto result = CopyListWithRandomPointer::serializeListRandomPointer(head);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index].first, result[index].first);
        EXPECT_EQ(expected[index].second, result[index].second);
    }
    CopyListWithRandomPointer::deleteList(&head);
    CopyListWithRandomPointer::deleteList(&copy);
}

TEST(LeetCode_CopyListWithRandomPointerTest, copyRandomList_2) {
    vector<pair<int, string>> expected{{1, "1"},
                                       {2, "1"}};
    auto head = CopyListWithRandomPointer::deserializeListRandomPointer(expected);
    auto copy = CopyListWithRandomPointer::copyRandomList(head);
    auto result = CopyListWithRandomPointer::serializeListRandomPointer(copy);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index].first, result[index].first);
        EXPECT_EQ(expected[index].second, result[index].second);
    }
    CopyListWithRandomPointer::deleteList(&head);
    CopyListWithRandomPointer::deleteList(&copy);
}

TEST(LeetCode_CopyListWithRandomPointerTest, copyRandomList_3) {
    vector<pair<int, string>> expected{{3, "null"},
                                       {3, "0"},
                                       {3, "null"}};
    auto head = CopyListWithRandomPointer::deserializeListRandomPointer(expected);
    auto copy = CopyListWithRandomPointer::copyRandomList(head);
    auto result = CopyListWithRandomPointer::serializeListRandomPointer(copy);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index].first, result[index].first);
        EXPECT_EQ(expected[index].second, result[index].second);
    }
    CopyListWithRandomPointer::deleteList(&head);
    CopyListWithRandomPointer::deleteList(&copy);
}

TEST(LeetCode_CopyListWithRandomPointerTest, copyRandomList_fail_1) {
    // n ≤ 1000
    auto size = 1000 + 1;
    vector<pair<int, string>> values(size);
    EXPECT_EXIT(CopyListWithRandomPointer::deserializeListRandomPointer(values), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_CopyListWithRandomPointerTest, copyRandomList_fail_2) {
    // -10^4 ≤ Node.val
    auto size = (int) -pow(10, 4) - 1;
    vector<pair<int, string>> values{{size, "null"}};
    EXPECT_EXIT(CopyListWithRandomPointer::deserializeListRandomPointer(values), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_CopyListWithRandomPointerTest, copyRandomList_fail_3) {
    // Node.val ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<pair<int, string>> values{{size, "null"}};
    EXPECT_EXIT(CopyListWithRandomPointer::deserializeListRandomPointer(values), ::testing::ExitedWithCode(3), "");
}

#endif