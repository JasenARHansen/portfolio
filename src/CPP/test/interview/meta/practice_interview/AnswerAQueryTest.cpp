#ifndef INTERVIEW_META_PREPARATION_PRACTICE_INTERVIEW_ANSWER_A_QUERY_TEST
#define INTERVIEW_META_PREPARATION_PRACTICE_INTERVIEW_ANSWER_A_QUERY_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/practice_interview/AnswerAQuery.cpp"

TEST(PracticeInterviewFirstTest, description) {
    testing::internal::CaptureStdout();
    AnswerAQuery::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(AnswerAQueryTest, answerQueries_1) {
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