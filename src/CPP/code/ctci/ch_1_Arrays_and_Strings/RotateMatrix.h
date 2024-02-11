#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ROTATE_MATRIX
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ROTATE_MATRIX

#include <string>
#include <vector>

namespace ctci {
    class RotateMatrix {
    public:
        static void description();

        static std::vector<std::vector<int>> rotateMatrix(std::vector<std::vector<int>> matrix);

        static void rotateMatrixInPlace(std::vector<std::vector<int>> *matrix);
    };
}
#endif
#pragma clang diagnostic pop