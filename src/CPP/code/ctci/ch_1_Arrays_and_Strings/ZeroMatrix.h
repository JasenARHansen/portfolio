#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ZERO_MATRIX
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ZERO_MATRIX

#include <string>
#include <vector>

namespace ctci {
    class ZeroMatrix {
    public:
        static void description();

        static std::vector<std::vector<int>> zeroMatrix(std::vector<std::vector<int>> matrix);

        static void zeroMatrixInPlace(std::vector<std::vector<int>> *matrix);
    };
}
#endif
#pragma clang diagnostic pop