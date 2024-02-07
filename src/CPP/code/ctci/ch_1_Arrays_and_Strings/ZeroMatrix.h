#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ZERO_MATRIX
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ZERO_MATRIX

#include <string>
#include <vector>

using namespace std;

class ZeroMatrix {
public:
    static void description();

    static vector<vector<int>> zeroMatrix(vector<vector<int>> matrix);

    static void zeroMatrixInPlace(vector<vector<int>> *matrix);

private:
};

#endif
#pragma clang diagnostic pop