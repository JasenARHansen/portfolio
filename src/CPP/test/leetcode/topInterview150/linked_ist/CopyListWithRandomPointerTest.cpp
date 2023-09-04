#ifndef LEETCODE_TOP_INTERVIEW_150_COPY_LIST_WITH_RANDOM_POINTER_TEST
#define LEETCODE_TOP_INTERVIEW_150_COPY_LIST_WITH_RANDOM_POINTER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/CopyListWithRandomPointer.cpp"

TEST(CopyListWithRandomPointerTest, description) {
    testing::internal::CaptureStdout();
    CopyListWithRandomPointer::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CopyListWithRandomPointerTest, copyRandomList_1) {
    vector<pair<int, string>> expected{{7,  "null"},
                                       {13, "0"},
                                       {11, "4"},
                                       {10, "2"},
                                       {1,  "0"}};
    auto head = CopyListWithRandomPointer::deserialize(expected);
    auto copy = CopyListWithRandomPointer::copyRandomList(head);
    auto result = CopyListWithRandomPointer::serialize(head);
    auto foo = CopyListWithRandomPointer::serialize(head);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index].first, result[index].first);
        EXPECT_EQ(expected[index].second, result[index].second);
    }
    CopyListWithRandomPointer::deleteList(&head);
    CopyListWithRandomPointer::deleteList(&copy);
}

TEST(CopyListWithRandomPointerTest, copyRandomList_2) {
    vector<pair<int, string>> expected{{1, "1"},
                                       {2, "1"}};
    auto head = CopyListWithRandomPointer::deserialize(expected);
    auto copy = CopyListWithRandomPointer::copyRandomList(head);
    auto result = CopyListWithRandomPointer::serialize(copy);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index].first, result[index].first);
        EXPECT_EQ(expected[index].second, result[index].second);
    }
    CopyListWithRandomPointer::deleteList(&head);
    CopyListWithRandomPointer::deleteList(&copy);
}

TEST(CopyListWithRandomPointerTest, copyRandomList_3) {
    vector<pair<int, string>> expected{{3, "null"},
                                       {3, "0"},
                                       {3, "null"}};
    auto head = CopyListWithRandomPointer::deserialize(expected);
    auto copy = CopyListWithRandomPointer::copyRandomList(head);
    auto result = CopyListWithRandomPointer::serialize(copy);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index].first, result[index].first);
        EXPECT_EQ(expected[index].second, result[index].second);
    }
    CopyListWithRandomPointer::deleteList(&head);
    CopyListWithRandomPointer::deleteList(&copy);
}

TEST(CopyListWithRandomPointerTest, copyRandomList_fail_1) {
    // n <= 1000
    auto size = 1000 + 1;
    vector<pair<int, string>> values(size);
    EXPECT_EXIT(CopyListWithRandomPointer::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(CopyListWithRandomPointerTest, copyRandomList_fail_2) {
    // -10^4 <= Node.val
    auto size = (int) -pow(10, 4) - 1;
    vector<pair<int, string>> values{{size, "null"}};
    EXPECT_EXIT(CopyListWithRandomPointer::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(CopyListWithRandomPointerTest, copyRandomList_fail_3) {
    // Node.val <= 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<pair<int, string>> values{{size, "null"}};
    EXPECT_EXIT(CopyListWithRandomPointer::deserialize(values), ::testing::ExitedWithCode(3), "");
}

#endif