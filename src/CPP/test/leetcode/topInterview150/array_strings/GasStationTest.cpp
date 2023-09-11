#ifndef LEETCODE_TOP_INTERVIEW_150_GAS_STATION_TEST
#define LEETCODE_TOP_INTERVIEW_150_GAS_STATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/GasStation.cpp"

TEST(GasStationTest, description) {
    testing::internal::CaptureStdout();
    GasStation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(GasStationTest, canCompleteCircuit_1) {
    auto expected = 3;
    vector<int> gas{1, 2, 3, 4, 5};
    vector<int> cost{3, 4, 5, 1, 2};
    auto result = GasStation::canCompleteCircuit(gas, cost);
    EXPECT_EQ(expected, result);
}

TEST(GasStationTest, canCompleteCircuit_2) {
    auto expected = -1;
    vector<int> gas{2, 3, 4};
    vector<int> cost{3, 4, 3};
    auto result = GasStation::canCompleteCircuit(gas, cost);
    EXPECT_EQ(expected, result);
}

TEST(GasStationTest, canCompleteCircuit_3) {
    auto expected = -1;
    vector<int> gas{4, 5, 2, 6, 5, 3};
    vector<int> cost{3, 2, 7, 3, 2, 9};
    auto result = GasStation::canCompleteCircuit(gas, cost);
    EXPECT_EQ(expected, result);
}

TEST(GasStationTest, canCompleteCircuit_4) {
    auto expected = -1;
    vector<int> gas{4, 0, 1};
    vector<int> cost{3, 2, 1};
    auto result = GasStation::canCompleteCircuit(gas, cost);
    EXPECT_EQ(expected, result);
}

TEST(GasStationTest, canCompleteCircuit_5) {
    auto expected = 0;
    vector<int> gas{4};
    vector<int> cost{4};
    auto result = GasStation::canCompleteCircuit(gas, cost);
    EXPECT_EQ(expected, result);
}

TEST(GasStationTest, canCompleteCircuit_fail_1) {
    // gas.size() == cost.size();
    auto size = 1;
    vector<int> gas(size);
    vector<int> cost(size + 1);
    EXPECT_EXIT(GasStation::canCompleteCircuit(gas, cost), ::testing::ExitedWithCode(3), "");
}

TEST(GasStationTest, canCompleteCircuit_fail_2) {
    // 1 ≤ gas.length
    auto size = 0;
    vector<int> gas(size);
    vector<int> cost(size);
    EXPECT_EXIT(GasStation::canCompleteCircuit(gas, cost), ::testing::ExitedWithCode(3), "");
}

TEST(GasStationTest, canCompleteCircuit_fail_3) {
    // gas.length ≤ 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> gas(size);
    vector<int> cost(size);
    EXPECT_EXIT(GasStation::canCompleteCircuit(gas, cost), ::testing::ExitedWithCode(3), "");
}

TEST(GasStationTest, canCompleteCircuit_fail_4) {
    // 0 ≤ gas[i]
    auto value = 0 - 1;
    vector<int> gas{1, 2, value, 4, 5};
    vector<int> cost{3, 4, 5, 1, 2};
    EXPECT_EXIT(GasStation::canCompleteCircuit(gas, cost), ::testing::ExitedWithCode(3), "");
}

TEST(GasStationTest, canCompleteCircuit_fail_5) {
    // gas[i] ≤ 10^4
    auto value = (int) pow(10, 4) + 1;
    vector<int> gas{1, 2, value, 4, 5};
    vector<int> cost{3, 4, 5, 1, 2};
    EXPECT_EXIT(GasStation::canCompleteCircuit(gas, cost), ::testing::ExitedWithCode(3), "");
}

TEST(GasStationTest, canCompleteCircuit_fail_6) {
    // 0 ≤ cost[i]
    auto value = 0 - 1;
    vector<int> gas{1, 2, 3, 4, 5};
    vector<int> cost{3, 4, value, 1, 2};
    EXPECT_EXIT(GasStation::canCompleteCircuit(gas, cost), ::testing::ExitedWithCode(3), "");
}

TEST(GasStationTest, canCompleteCircuit_fail_7) {
    //cost[i] ≤ 10^4
    auto value = (int) pow(10, 4) + 1;
    vector<int> gas{1, 2, 3, 4, 5};
    vector<int> cost{3, 4, value, 1, 2};
    EXPECT_EXIT(GasStation::canCompleteCircuit(gas, cost), ::testing::ExitedWithCode(3), "");
}

#endif