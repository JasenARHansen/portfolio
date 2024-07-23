#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_APOCALYPSE
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_APOCALYPSE

#include <tuple>

namespace ctci {
    class TheApocalypse {
    public:
        static void description();

        static std::tuple<int, int, double> getRatio(int families);
    };
}
#endif
#pragma clang diagnostic pop