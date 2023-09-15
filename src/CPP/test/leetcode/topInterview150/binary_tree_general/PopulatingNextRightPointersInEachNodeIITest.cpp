#ifndef LEETCODE_TOP_INTERVIEW_150_POPULATING_NEXT_RIGHT_POINTERS_IN_EACH_NODE_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_POPULATING_NEXT_RIGHT_POINTERS_IN_EACH_NODE_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/PopulatingNextRightPointersInEachNodeII.cpp"  // NOLINT : Ignore .cpp import

vector<string> serialized(PopulatingNextRightPointersInEachNodeIITreeNode *root) {
    vector<string> result;
    if (root != nullptr) {
        vector<PopulatingNextRightPointersInEachNodeIITreeNode *> oddRow;
        vector<PopulatingNextRightPointersInEachNodeIITreeNode *> evenRow;
        oddRow.push_back(root);
        while (!oddRow.empty() || !evenRow.empty()) {
            if (!oddRow.empty()) {
                for (auto node: oddRow) {
                    if (node->left != nullptr) {
                        evenRow.push_back(node->left);
                    }
                    if (node->right != nullptr) {
                        evenRow.push_back(node->right);
                    }
                }
                PopulatingNextRightPointersInEachNodeIITreeNode *current = oddRow[0];
                while (current->next != nullptr) {
                    result.push_back(to_string(current->val));
                    current = current->next;
                }
                result.push_back(to_string(current->val));
                result.emplace_back("#");
                oddRow.clear();
            } else if (!evenRow.empty()) {
                for (auto node: evenRow) {
                    if (node->left != nullptr) {
                        oddRow.push_back(node->left);
                    }
                    if (node->right != nullptr) {
                        oddRow.push_back(node->right);
                    }
                }
                PopulatingNextRightPointersInEachNodeIITreeNode *current = evenRow[0];
                while (current->next != nullptr) {
                    result.push_back(to_string(current->val));
                    current = current->next;
                }
                result.push_back(to_string(current->val));
                result.emplace_back("#");
                evenRow.clear();
            }
        }
    }
    return result;
}

TEST(PopulatingNextRightPointersInEachNodeIITest, description) {
    testing::internal::CaptureStdout();
    PopulatingNextRightPointersInEachNodeII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PopulatingNextRightPointersInEachNodeIITest, connect_1) {
    vector<string> expected{"1", "#", "2", "3", "#", "4", "5", "7", "#"};
    vector<string> values{"1", "2", "3", "4", "5", "null", "7"};
    auto root = PopulatingNextRightPointersInEachNodeII::deserializeTree(values);
    auto result = PopulatingNextRightPointersInEachNodeII::connect(root);
    auto resultValues = serialized(result);
    EXPECT_EQ(expected, resultValues);
    PopulatingNextRightPointersInEachNodeII::deleteTree(&root);
    PopulatingNextRightPointersInEachNodeII::deleteTree(&result);
}

TEST(PopulatingNextRightPointersInEachNodeIITest, connect_2) {
    vector<string> expected{};
    vector<string> values{};
    auto root = PopulatingNextRightPointersInEachNodeII::deserializeTree(values);
    auto result = PopulatingNextRightPointersInEachNodeII::connect(root);
    auto resultValues = serialized(result);
    EXPECT_EQ(expected, resultValues);
    PopulatingNextRightPointersInEachNodeII::deleteTree(&root);
    PopulatingNextRightPointersInEachNodeII::deleteTree(&result);
}

#endif