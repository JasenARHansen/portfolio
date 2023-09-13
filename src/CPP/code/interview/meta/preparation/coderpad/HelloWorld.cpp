#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class HelloWorld {
public:
    static void description() {
        cout << R"(Welcome to Meta!

     This is just a simple shared plaintext pad, with no execution capabilities.

     When you know what language you would like to use for your interview,
     simply choose it from the dropdown in the left bar.

     Enjoy your interview!)" << endl;
    }

    static void helloWorld() {
        auto words = {"Hello, ", "World!", "\n"};
        for (const char *const &word: words) {
            cout << word;
        }
    }
};

#pragma clang diagnostic pop