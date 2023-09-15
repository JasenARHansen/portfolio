#ifndef INTERVIEW_META_INTERVIEW_2023_9_14_DEEP_CLONE_TEST
#define INTERVIEW_META_INTERVIEW_2023_9_14_DEEP_CLONE_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_2023_9_14/DeepClone.cpp"  // NOLINT : Ignore .cpp import

TEST(DeepCloneTest, description) {
    testing::internal::CaptureStdout();
    DeepClone::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(DeepCloneTest, clone_1) {
    G g1 = G();
    V v0 = V(Data(0));
    V v1 = V(Data(1));
    V v2 = V(Data(2));
    v0.edges_.push_back(&v1);
    v0.edges_.push_back(&v2);
    V v3 = V(Data(3));
    v2.edges_.push_back(&v3);
    g1.vertices_.push_back(&v0);
    G g2 = G();
    DeepClone::clone(g1, &g2);
    EXPECT_EQ(g1.toString(), g2.toString());
}

#endif