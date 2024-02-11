#ifndef CTCI_CH_2_LINKED_LISTS_PALINDROME_TEST
#define CTCI_CH_2_LINKED_LISTS_PALINDROME_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/Palindrome.h"

using namespace ctci;
TEST(CtCI_PalindromeTest, description) {
    testing::internal::CaptureStdout();
    Palindrome::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_PalindromeTest, isPalindrome_1) {
    std::vector<int> expected{true, true, false, true};
    std::vector<std::vector<char>> source{{'1', '1'},
                                          {'1', '2', '1'},
                                          {'1', '2', '3'},
                                          {'1', '2', '2', '1'}};
    for (auto index = 0; index < source.size(); index++) {
        auto list = Palindrome::generateList(source.at(index));
        auto result = Palindrome::isPalindrome(list);
        EXPECT_EQ(expected.at(index), result);
        Palindrome::deleteList(&list);
    }
}

TEST(CtCI_PalindromeTest, isPalindromeRecursive_1) {
    std::vector<int> expected{true, true, false, true};
    std::vector<std::vector<char>> source{{'1', '1'},
                                          {'1', '2', '1'},
                                          {'1', '2', '3'},
                                          {'1', '2', '2', '1'}};
    for (auto index = 0; index < source.size(); index++) {
        auto list = Palindrome::generateList(source.at(index));
        auto result = Palindrome::isPalindromeRecursive(list);
        EXPECT_EQ(expected.at(index), result);
        Palindrome::deleteList(&list);
    }
}

#endif