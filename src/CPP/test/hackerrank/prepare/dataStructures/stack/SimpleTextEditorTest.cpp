#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_SIMPLE_TEXT_EDITOR_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_SIMPLE_TEXT_EDITOR_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stack/SimpleTextEditor.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_SimpleTextEditorTest, description) {
    testing::internal::CaptureStdout();
    SimpleTextEditor::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_SimpleTextEditorTest, SimpleTextEditor_1) {
    vector<string> expected{"f", "g", "d"};
    vector<string> operations{"1, abcde", "1 fg", "3 6", "2 5", "4", "3 7", "4", "3 4"};
    auto result = SimpleTextEditor::textEdits(operations);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_SimpleTextEditorTest, SimpleTextEditor_2) {
    vector<string> expected{"c", "y", "a"};
    vector<string> operations{"1 abc", "3 3", "2 3", "1 xy", "3 2", "4", "4", "3 1"};
    auto result = SimpleTextEditor::textEdits(operations);
    EXPECT_EQ(expected, result);
}

#endif