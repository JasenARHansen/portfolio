#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    vector<int> expectedValues{7, 13, 11, 10, 1};
    vector<int> pointerIndexes{-1, 0, 4, 2, 0};
    Node *expected = CopyListWithRandomPointer::generateList(expectedValues);
    // assign the random pointers
    vector<Node *> indexes;
    Node *copy = expected;
    while (copy != nullptr) {
        indexes.push_back(copy);
        copy = copy->next;
    }
    for (int index = 0; index < pointerIndexes.size(); index++) {
        if (pointerIndexes[index] >= 0) {
            indexes[index]->random = indexes[pointerIndexes[index]];
        }
    }
    Node *result = CopyListWithRandomPointer::copyRandomList(expected);
    Node *expectedTest = expected;
    Node *resultTest = result;
    vector<Node *> testindexes{resultTest};
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
        testindexes.push_back(resultTest);
    }
    for (int i = 0; i < pointerIndexes.size(); i++) {
        if (pointerIndexes[i] >= 0) {
            EXPECT_EQ(testindexes[i]->random, testindexes[pointerIndexes[i]]);
        }
    }
    CopyListWithRandomPointer::deleteList(expectedValues.size(), &expected);
    CopyListWithRandomPointer::deleteList(expectedValues.size(), &result);
}

TEST(CopyListWithRandomPointerTest, copyRandomList_2) {
    vector<int> expectedValues{1, 2};
    vector<int> pointerIndexes{1, 1};
    Node *expected = CopyListWithRandomPointer::generateList(expectedValues);
    // assign the random pointers
    vector<Node *> indexes;
    Node *copy = expected;
    while (copy != nullptr) {
        indexes.push_back(copy);
        copy = copy->next;
    }
    for (int index = 0; index < pointerIndexes.size(); index++) {
        if (pointerIndexes[index] >= 0) {
            indexes[index]->random = indexes[pointerIndexes[index]];
        }
    }
    Node *result = CopyListWithRandomPointer::copyRandomList(expected);
    Node *expectedTest = expected;
    Node *resultTest = result;
    vector<Node *> testindexes{resultTest};
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
        testindexes.push_back(resultTest);
    }
    for (int i = 0; i < pointerIndexes.size(); i++) {
        if (pointerIndexes[i] >= 0) {
            EXPECT_EQ(testindexes[i]->random, testindexes[pointerIndexes[i]]);
        }
    }
    CopyListWithRandomPointer::deleteList(expectedValues.size(), &expected);
    CopyListWithRandomPointer::deleteList(expectedValues.size(), &result);
}

TEST(CopyListWithRandomPointerTest, copyRandomList_3) {
    vector<int> expectedValues{3, 3, 3};
    vector<int> pointerIndexes{-1, 0, -1};
    Node *expected = CopyListWithRandomPointer::generateList(expectedValues);
    // assign the random pointers
    vector<Node *> indexes;
    Node *copy = expected;
    while (copy != nullptr) {
        indexes.push_back(copy);
        copy = copy->next;
    }
    for (int index = 0; index < pointerIndexes.size(); index++) {
        if (pointerIndexes[index] >= 0) {
            indexes[index]->random = indexes[pointerIndexes[index]];
        }
    }
    Node *result = CopyListWithRandomPointer::copyRandomList(expected);
    Node *expectedTest = expected;
    Node *resultTest = result;
    vector<Node *> testindexes{resultTest};
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
        testindexes.push_back(resultTest);
    }
    for (int i = 0; i < pointerIndexes.size(); i++) {
        if (pointerIndexes[i] >= 0) {
            EXPECT_EQ(testindexes[i]->random, testindexes[pointerIndexes[i]]);
        }
    }
    CopyListWithRandomPointer::deleteList(expectedValues.size(), &expected);
    CopyListWithRandomPointer::deleteList(expectedValues.size(), &result);
}

TEST(CopyListWithRandomPointerTest, copyRandomList_fail_1) {
    // n <= 1000
    int size = 1000 + 1;
    vector<int> values(size);
    EXPECT_EXIT(CopyListWithRandomPointer::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(CopyListWithRandomPointerTest, copyRandomList_fail_2) {
    // -10^4 <= Node.val
    int size = -pow(10, 4) - 1;
    vector<int> values{size};
    EXPECT_EXIT(CopyListWithRandomPointer::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(CopyListWithRandomPointerTest, copyRandomList_fail_3) {
    // Node.val <= 10^4
    int size = pow(10, 4) + 1;
    vector<int> values{size};
    EXPECT_EXIT(CopyListWithRandomPointer::generateList(values), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop