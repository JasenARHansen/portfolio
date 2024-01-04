#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TRIE_CONTACTS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TRIE_CONTACTS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/trei/Contacts.cpp"  // NOLINT : Ignore .cpp import

TEST(ContactsTest, description) {
    testing::internal::CaptureStdout();
    Contacts::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ContactsTest, readUserInput_1) {
    vector<int> expected{2, 0};
    vector<string> inputs{"4",
                          "add hack",
                          "add hackerrank",
                          "find hac",
                          "find hak"};
    string testInput;
    for (const auto &input: inputs) {
        testInput.append(input).append(" ");
    }
    stringstream fakeInput(testInput);
    Contacts contacts = Contacts();
    auto result = contacts.readUserInput(fakeInput);
    EXPECT_EQ(expected, result);
}

TEST(ContactsTest, readUserInput_2) {
    vector<int> expected{3, 2, 0};
    vector<string> inputs{"7",
                          "add ed",
                          "add eddie",
                          "add edward",
                          "find ed",
                          "add edwina",
                          "find edw",
                          "find a"};
    string testInput;
    for (const auto &input: inputs) {
        testInput.append(input).append(" ");
    }
    stringstream fakeInput(testInput);
    Contacts contacts = Contacts();
    auto result = contacts.readUserInput(fakeInput);
    EXPECT_EQ(expected, result);
}

#endif