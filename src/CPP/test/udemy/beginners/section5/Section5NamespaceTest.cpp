#ifndef UDEMY_BEGINNERS_5_NAMESPACE_TEST
#define UDEMY_BEGINNERS_5_NAMESPACE_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Classes.h"
#include "../../../../code/udemy/beginners/section5/Section5Namespace.h"

TEST(Section5NamespaceTest, getName) {
    auto expected1 = "Default";
    auto result1 = Section5Classes::createObject();
    EXPECT_EQ(expected1, result1->getName());
    Section5Classes::deleteObject(&result1);
    EXPECT_EQ(nullptr, result1);
    auto expected2 = "Section5Namespace";
    auto result2 = jsn::Section5Namespace::createObject();
    EXPECT_EQ(expected2, result2->getName());
    jsn::Section5Namespace::deleteObject(&result2);
    EXPECT_EQ(nullptr, result2);
}

#endif