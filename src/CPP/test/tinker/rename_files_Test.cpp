#ifndef TINKER_RENAME_TEST
#define TINKER_RENAME_TEST

#include "gtest/gtest.h"
#include "../../code/tinker/rename_files.cpp"  // NOLINT : Ignore .cpp import

TEST(Rename_Test, description) {
    testing::internal::CaptureStdout();
    Rename::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Rename_Test, files) {

    string path = "C:\\Users\\jasen\\Desktop\\Text";
    Rename::files(path);

}

#endif