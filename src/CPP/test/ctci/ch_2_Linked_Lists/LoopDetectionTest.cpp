#ifndef CTCI_CH_2_LINKED_LISTS_LOOP_DETECTION_TEST
#define CTCI_CH_2_LINKED_LISTS_LOOP_DETECTION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/LoopDetection.h"

using namespace ctci;
TEST(CtCI_LoopDetectionTest, description) {
    testing::internal::CaptureStdout();
    LoopDetection::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_LoopDetectionTest, detectCycle_1) {
    std::vector<int> data{0, 1, 2, 3, 4, 5, 6};
    auto value = 3;
    auto list = LoopDetection::generateList(data);
    LoopDetection::generateCycle(list, value);
    auto result = LoopDetection::detectCycle(list);
    LoopDetection::breakCycle(list);
    EXPECT_NE(nullptr, result);
    LoopDetection::deleteList(&list);
}

TEST(CtCI_LoopDetectionTest, detectCycle_2) {
    std::vector<int> data{0, 1, 2, 3, 4, 5, 6};
    auto value = (int) data.size() + 1;
    auto list = LoopDetection::generateList(data);
    LoopDetection::generateCycle(list, value);
    auto result = LoopDetection::detectCycle(list);
    LoopDetection::breakCycle(list);
    EXPECT_EQ(nullptr, result);
    LoopDetection::deleteList(&list);
}

#endif