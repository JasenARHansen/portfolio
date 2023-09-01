#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_5_NAMESPACE_TEST
#define UDEMY_BEGINNERS_5_NAMESPACE_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Classes.h"
#include "../../../../code/udemy/beginners/section5/Section5Namespace.h"

TEST(Section5NamespaceTest, getName) {
    string expected_1 = "Default";
    auto result_1 = Section5Classes::createObject();
    EXPECT_EQ(expected_1, result_1->getName());
    Section5Classes::deleteObject(&result_1);
    EXPECT_EQ(nullptr, result_1);
    string expected_2 = "Section5Namespace";
    auto result_2 = jsn::Section5Namespace::createObject();
    EXPECT_EQ(expected_2, result_2->getName());
    jsn::Section5Namespace::deleteObject(&result_2);
    EXPECT_EQ(nullptr, result_2);
}

#endif
#pragma clang diagnostic pop