#ifndef LEETCODE_TOP_INTERVIEW_150_EVALUATE_DIVISION_TEST
#define LEETCODE_TOP_INTERVIEW_150_EVALUATE_DIVISION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/graph_general/in_progress_EvaluateDivision.cpp"

TEST(EvaluateDivisionTest, description) {
    testing::internal::CaptureStdout();
    EvaluateDivision::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(EvaluateDivisionTest, calcEquation_1) {
    vector<double> expected{6.00000, 0.50000, -1.00000, 1.00000, -1.00000};
//    vector<vector<string>> equations{{"a", "b"},
//                                     {"b", "c"}};
//    vector<double> values{2.0, 3.0};
//    vector<vector<string>> queries{{"a", "c"},
//                                   {"b", "a"},
//                                   {"a", "e"},
//                                   {"a", "a"},
//                                   {"x", "x"}};
//    auto result = EvaluateDivision::calcEquation(equations, values, queries);
//    EXPECT_EQ(expected, result);
}

TEST(EvaluateDivisionTest, calcEquation_2) {
    vector<double> expected{360.00000, 0.00833};
    vector<vector<string>> equations{{"x1", "x2"},
                                     {"x2", "x3"},
                                     {"x3", "x4"},
                                     {"x4", "x5"}};
    vector<double> values{3.0, 4.0, 5.0, 6.0};
    vector<vector<string>> queries{{"x1", "x5"},
                                   {"x5", "x2"},};
    auto result = EvaluateDivision::calcEquation(equations, values, queries);
    EXPECT_EQ(expected, result);
}

#endif