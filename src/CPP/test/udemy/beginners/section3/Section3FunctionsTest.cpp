#ifndef TEST_UDEMY_BEGINNERS_3_FUNCTIONS_TEST
#define TEST_UDEMY_BEGINNERS_3_FUNCTIONS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section3/Section3Functions.h"

TEST(Section3FunctionsTest, menuSelection) {
    string expected[] = {"Invalid option, quitting.",
                         "Adding a record.",
                         "Deleting a record.",
                         "Viewing a record.",
                         "Searching a record.",
                         "Quiting."};
    for (int i = 0; i < 6; i++) {
        auto result = Section3Functions::menuSelection(i);
        EXPECT_EQ(expected[i], result);
    }
}

#endif