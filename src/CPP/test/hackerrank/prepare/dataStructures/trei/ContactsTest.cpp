#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TRIE_CONTACTS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TRIE_CONTACTS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/trei/Contacts.cpp"  // NOLINT : Ignore .cpp import

TEST(ContactsTest, description) {
    testing::internal::CaptureStdout();
    Contacts::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ContactsTest, contacts_1) {
    vector<int> expected{2, 0};
    vector<vector<string>> queries{{"add",  "hack"},
                                   {"add",  "hackerrank"},
                                   {"find", "hac"},
                                   {"find", "hak"}};
    auto result = Contacts::contacts(queries);
    EXPECT_EQ(expected, result);
}

TEST(ContactsTest, contacts_2) {
    vector<int> expected{3, 2, 0};
    vector<vector<string>> queries{{"add",  "ed"},
                                   {"add",  "eddie"},
                                   {"add",  "edward"},
                                   {"find", "ed"},
                                   {"add",  "edwina"},
                                   {"find", "edw"},
                                   {"find", "a"}};
    auto result = Contacts::contacts(queries);
    EXPECT_EQ(expected, result);
}

#endif