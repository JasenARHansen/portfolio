#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "misc-no-recursion"

#include "QuickSort.h"
#include <iostream>
#include <algorithm>

using namespace ctci;

void QuickSort::description() {
    std::cout << R"(Arrays and Strings: Zero Matrix
    Implement Quick Sort.)" << std::endl;
}

std::vector<int> QuickSort::quickSort(std::vector<int> input) {
    if (input.size() <= 1) {
        return input;
    } else {
        auto pivot = input.at(0);
        input.erase(input.begin());
        std::vector<int> less;
        std::vector<int> greater;
        while (!input.empty()) {
            if (input.at(0) < pivot) {
                less.push_back(input.at(0));
            } else {
                greater.push_back(input.at(0));
            }
            input.erase(input.begin());
        }
        auto lessSorted = quickSort(less);
        auto greaterSorted = quickSort(greater);
        lessSorted.push_back(pivot);
        std::vector<int> merged(lessSorted.size() + greaterSorted.size());
        // Merge the vectors using the merge function
        merge(lessSorted.begin(), lessSorted.end(), greaterSorted.begin(), greaterSorted.end(),
              merged.begin());
        return merged;
    }
}

void QuickSort::quickSortInPlace(std::vector<int> &input) {
    quickSortInPlace(&input, 0, input.size());
}

void QuickSort::quickSortInPlace(std::vector<int> *input, int start, int stop) {
    if (stop - start > 1) {
        auto pivot = input->at(start);
        auto offset = 0;
        for (auto index = start; index < stop; index++) {
            if (input->at(index) < pivot) {
                input->insert(input->begin() + start, input->at(index));
                input->erase(input->begin() + index + 1);
                offset++;
            }
        }
        // left
        if (offset > 0) {
            quickSortInPlace(input, start, start + offset);
        }
        // right
        if (offset == 0) {
            offset++;
        }
        if (stop - offset > 1) {
            quickSortInPlace(input, start + offset, stop);
        }
    }
}

#pragma clang diagnostic pop