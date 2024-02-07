#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ROTATE_MATRIX
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ROTATE_MATRIX

#include <string>
#include <vector>

using namespace std;

class RotateMatrix {
public:
    static void description();

    static vector<vector<int>> rotateMatrix(vector<vector<int>> matrix);

    static void rotateMatrixInPlace(vector<vector<int>> *matrix);
};

#endif
#pragma clang diagnostic pop