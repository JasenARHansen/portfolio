#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <vector>
#include <iostream>
#include <cassert>
#include <map>

using namespace std;

class H_Index {
public:
    static void description() {
        cout << R"(274. H-Index
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
    Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
    According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

    Example 1:
        Input: citations = [3, 0, 6, 1, 5]
        Output: 3
        Explanation:
            [3, 0, 6, 1, 5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
            Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

    Example 2:
        Input: citations = [1, 3, 1]
        Output: 1

    Constraints:
        n == citations.length
        1 ≤ n ≤ 5000
        0 ≤ citations[i] ≤ 1000)" << endl;
    }

    static int hIndex(vector<int> &citations) {
        assert (!citations.empty());
        assert (citations.size() <= 5000);
        map<int, int> citations_map;
        for (auto citation: citations) {
            assert (0 <= citation);
            assert (citation <= 1000);
            if (!citations_map.count(citation)) {
                citations_map[citation] = 0;
            }
            citations_map[citation]++;
        }
        auto count = 0;
        auto hIndex = 0;
        for (auto it = citations_map.rbegin(); it != citations_map.rend(); ++it) {
            if (it->first <= 0) {
                break;
            }
            if (it->first < count) {
                break;
            }
            count += it->second;
            hIndex = min(count, it->first);
        }
        return hIndex;
    }
};

#pragma clang diagnostic pop