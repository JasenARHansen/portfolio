#ifndef INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_ANSWER_A_QUERY_TEST
#define INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_ANSWER_A_QUERY_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_practice/AnswerAQuery.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_PracticeInterviewFirstTest, description) {
    testing::internal::CaptureStdout();
    AnswerAQuery::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_AnswerAQueryTest, answerQueries_1) {
    vector<int> expected{-1, 2, -1, 2};
    vector<Query> queries = {{2, 3},
                             {1, 2},
                             {2, 1},
                             {2, 3},
                             {2, 2}};
    auto n = 5;
    auto result = AnswerAQuery::answerQueries(queries, n);
    EXPECT_EQ(expected, result);
}

#endif