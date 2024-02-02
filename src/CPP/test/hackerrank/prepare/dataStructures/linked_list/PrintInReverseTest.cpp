#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_PRINT_IN_REVERSE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_PRINT_IN_REVERSE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/PrintInReverse.cpp"  // NOLINT : Ignore .cpp import

TEST(PrintInReverseTest, description) {
    testing::internal::CaptureStdout();
    PrintInReverse::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PrintInReverseTest, reversePrint_1) {
    auto expected = "3\n"
                    "2\n"
                    "1\n";
    vector<int> source{1, 2, 3};
    auto list = PrintInReverse::createList(source);
    testing::internal::CaptureStdout();
    PrintInReverse::reversePrint(list);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PrintInReverse::deleteList(&list);
}

TEST(PrintInReverseTest, reversePrint_2) {
    auto expected = "5\n"
                    "2\n"
                    "4\n"
                    "12\n"
                    "16\n";
    vector<int> source{16, 12, 4, 2, 5};
    auto list = PrintInReverse::createList(source);
    testing::internal::CaptureStdout();
    PrintInReverse::reversePrint(list);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PrintInReverse::deleteList(&list);
}

TEST(PrintInReverseTest, reversePrint_3) {
    auto expected = "9\n"
                    "3\n"
                    "7\n";
    vector<int> source{7, 3, 9};
    auto list = PrintInReverse::createList(source);
    testing::internal::CaptureStdout();
    PrintInReverse::reversePrint(list);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PrintInReverse::deleteList(&list);
}

TEST(PrintInReverseTest, reversePrint_4) {
    auto expected = "13\n"
                    "3\n"
                    "18\n"
                    "1\n"
                    "5\n";
    vector<int> source{5, 1, 18, 3, 13};
    auto list = PrintInReverse::createList(source);
    testing::internal::CaptureStdout();
    PrintInReverse::reversePrint(list);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PrintInReverse::deleteList(&list);
}

#endif