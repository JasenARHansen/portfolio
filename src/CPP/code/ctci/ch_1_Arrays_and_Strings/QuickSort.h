#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_QUICK_SORT
#define CTCI_CH_1_ARRAYS_AND_STRINGS_QUICK_SORT

#include <vector>

namespace ctci {
    class QuickSort {
    public:
        static void description();

        static std::vector<int> quickSort(std::vector<int> input);

        static void quickSortInPlace(std::vector<int> &input);

    private:
        static void quickSortInPlace(std::vector<int> *input, int start, int stop);

    };
}
#endif
#pragma clang diagnostic pop