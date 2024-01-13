#pragma clang diagnostic push
#ifndef INTERVIEW_SNAP_2024_1_12_TEST
#define INTERVIEW_SNAP_2024_1_12_TEST

#include "gtest/gtest.h"
#include "../../../code/interview/snap/Snap_2024_1_12.cpp"  // NOLINT : Ignore .cpp import

TEST(Snap_Interview_2024_1_12_Test, isPathExists_1) {
    auto expected = true;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "bat";
    auto pathFinder = new WordPathFinder(words);
    auto result = pathFinder->isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_2) {
    auto expected = true;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "bat";
    auto pathFinder = WordPathFinder(words);
    auto result = pathFinder.isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_3) {
    auto expected = false;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "care";
    auto pathFinder = new WordPathFinder(words);
    auto result = pathFinder->isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_4) {
    auto expected = false;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "care";
    auto pathFinder = WordPathFinder(words);
    auto result = pathFinder.isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_5) {
    auto expected = true;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "dog";
    auto pathFinder = new WordPathFinder(words);
    auto result = pathFinder->isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_6) {
    auto expected = true;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "dog";
    auto pathFinder = WordPathFinder(words);
    auto result = pathFinder.isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_7) {
    auto expected = false;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "cat";
    auto pathFinder = new WordPathFinder(words);
    auto result = pathFinder->isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_8) {
    auto expected = false;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "cat";
    auto pathFinder = WordPathFinder(words);
    auto result = pathFinder.isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_9) {
    auto expected = false;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "cab";
    auto pathFinder = new WordPathFinder(words);
    auto result = pathFinder->isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_10) {
    auto expected = false;
    set<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "cab";
    auto pathFinder = WordPathFinder(words);
    auto result = pathFinder.isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_11) {
    auto expected = true;
    vector<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot", "car",
                            "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "bat";
    auto pathFinder = new WordPathFinder(words);
    auto result = pathFinder->isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

TEST(Snap_Interview_2024_1_12_Test, isPathExists_12) {
    auto expected = true;
    vector<string> words = {"car", "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot", "car",
                            "cat", "cot", "dog", "bat", "bee", "card", "care", "far", "ear", "cot", "dot"};
    auto a = "cat";
    auto b = "bat";
    auto pathFinder = WordPathFinder(words);
    auto result = pathFinder.isPathExists(a, b);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop