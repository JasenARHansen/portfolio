#ifndef INTERVIEW_AMAZON_2023_11_16_TEST
#define INTERVIEW_AMAZON_2023_11_16_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/amazon/interview_2023_11_16/Amazon_2023_11_16.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_Amazon_Interview_2023_11_16_Test, description) {
    testing::internal::CaptureStdout();
    Amazon_Interview_2023_11_16::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, constructorBox_1) {
    vector<int> dimensions{1, 2, 3};
    auto *box = new Amazon_Interview_2023_11_16::Box(dimensions);
    EXPECT_NE(nullptr, box);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, constructorBox_2) {
    vector<int> dimensions{1, 2};
    EXPECT_EXIT(new Amazon_Interview_2023_11_16::Box(dimensions), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, constructorItem_1) {
    vector<int> dimensions{1, 2, 3};
    auto *item = new Amazon_Interview_2023_11_16::Item(dimensions);
    EXPECT_NE(nullptr, item);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, constructorItem_2) {
    vector<int> dimensions{1, 2};
    EXPECT_EXIT(new Amazon_Interview_2023_11_16::Item(dimensions), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, isThereABox_unsorted_1) {
    auto expected = true;
    auto *box1 = new Amazon_Interview_2023_11_16::Box(1, 3, 3);
    auto *box2 = new Amazon_Interview_2023_11_16::Box(4, 2, 3);
    auto *box3 = new Amazon_Interview_2023_11_16::Box(8, 8, 8);
    auto *box4 = new Amazon_Interview_2023_11_16::Box(1, 2, 3);
    auto *box5 = new Amazon_Interview_2023_11_16::Box(1, 1, 1);
    vector<Amazon_Interview_2023_11_16::Box *> boxes{box1, box2, box3, box4, box5};
    auto *item = new Amazon_Interview_2023_11_16::Item(6, 5, 4);
    auto result = Amazon_Interview_2023_11_16::isThereABox(item, boxes);
    EXPECT_EQ(expected, result);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, isThereABox_sorted_1) {
    auto expected = false;
    vector<Amazon_Interview_2023_11_16::Box *> boxes{};
    Amazon_Interview_2023_11_16::sortBoxes(boxes);
    auto *item = new Amazon_Interview_2023_11_16::Item(6, 5, 4);
    auto result = Amazon_Interview_2023_11_16::isThereABox(item, boxes);
    EXPECT_EQ(expected, result);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, isThereABox_sorted_2) {
    auto expected = true;
    auto *box1 = new Amazon_Interview_2023_11_16::Box(1, 3, 3);
    auto *box2 = new Amazon_Interview_2023_11_16::Box(4, 2, 3);
    auto *box3 = new Amazon_Interview_2023_11_16::Box(8, 8, 8);
    auto *box4 = new Amazon_Interview_2023_11_16::Box(1, 2, 3);
    auto *box5 = new Amazon_Interview_2023_11_16::Box(1, 1, 1);
    vector<Amazon_Interview_2023_11_16::Box *> boxes{box1, box2, box3, box4, box5};
    Amazon_Interview_2023_11_16::sortBoxes(boxes);
    auto *item = new Amazon_Interview_2023_11_16::Item(6, 5, 4);
    auto result = Amazon_Interview_2023_11_16::isThereABox(item, boxes);
    EXPECT_EQ(expected, result);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, isThereABox_sorted_3) {
    auto expected = false;
    auto *box1 = new Amazon_Interview_2023_11_16::Box(1, 3, 3);
    auto *box2 = new Amazon_Interview_2023_11_16::Box(4, 2, 3);
    auto *box3 = new Amazon_Interview_2023_11_16::Box(8, 8, 8);
    auto *box4 = new Amazon_Interview_2023_11_16::Box(1, 2, 3);
    auto *box5 = new Amazon_Interview_2023_11_16::Box(1, 1, 1);
    vector<Amazon_Interview_2023_11_16::Box *> boxes{box1, box2, box3, box4, box5};
    Amazon_Interview_2023_11_16::sortBoxes(boxes);
    auto *item = new Amazon_Interview_2023_11_16::Item(8, 9, 4);
    auto result = Amazon_Interview_2023_11_16::isThereABox(item, boxes);
    EXPECT_EQ(expected, result);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, getBestBox_1) {
    auto expected = nullptr;
    vector<Amazon_Interview_2023_11_16::Box *> boxes{};
    Amazon_Interview_2023_11_16::sortBoxes(boxes);
    auto *item = new Amazon_Interview_2023_11_16::Item(8, 8, 9);
    auto result = Amazon_Interview_2023_11_16::getBestBox(item, boxes);
    EXPECT_EQ(expected, result);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, getBestBox_2) {
    auto *box1 = new Amazon_Interview_2023_11_16::Box(1, 3, 3);
    auto *box2 = new Amazon_Interview_2023_11_16::Box(4, 2, 3);
    auto *box3 = new Amazon_Interview_2023_11_16::Box(8, 8, 8);
    auto *box4 = new Amazon_Interview_2023_11_16::Box(1, 2, 3);
    auto *box5 = new Amazon_Interview_2023_11_16::Box(1, 1, 1);
    auto expected = box2;
    vector<Amazon_Interview_2023_11_16::Box *> boxes{box1, box2, box3, box4, box5};
    Amazon_Interview_2023_11_16::sortBoxes(boxes);
    auto *item = new Amazon_Interview_2023_11_16::Item(2, 2, 2);
    auto result = Amazon_Interview_2023_11_16::getBestBox(item, boxes);
    EXPECT_EQ(expected, result);
}

TEST(Interview_Amazon_Interview_2023_11_16_Test, getBestBox_3) {
    auto *box1 = new Amazon_Interview_2023_11_16::Box(1, 3, 3);
    auto *box2 = new Amazon_Interview_2023_11_16::Box(4, 2, 3);
    auto *box3 = new Amazon_Interview_2023_11_16::Box(8, 8, 8);
    auto *box4 = new Amazon_Interview_2023_11_16::Box(1, 2, 3);
    auto *box5 = new Amazon_Interview_2023_11_16::Box(1, 1, 1);
    auto expected = nullptr;
    vector<Amazon_Interview_2023_11_16::Box *> boxes{box1, box2, box3, box4, box5};
    Amazon_Interview_2023_11_16::sortBoxes(boxes);
    auto *item = new Amazon_Interview_2023_11_16::Item(8, 8, 9);
    auto result = Amazon_Interview_2023_11_16::getBestBox(item, boxes);
    EXPECT_EQ(expected, result);
}

#endif