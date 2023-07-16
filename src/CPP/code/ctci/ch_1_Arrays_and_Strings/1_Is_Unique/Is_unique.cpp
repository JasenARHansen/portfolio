#ifndef CTCI_CH_1_IS_UNIQUE
#define CTCI_CH_1_IS_UNIQUE

#include <string>
#include <vector>
#include <iostream>
#include <bitset>
#include <algorithm> // for sort() 

using namespace std;

class ch1_isUnique {
    static bool isUniqueChars(const string &str) {
        if (str.length() > 128) {
            return false;
        }
        vector<bool> char_set(128);
        for (int val: str) {
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    static bool isUniqueChars_bitvector(const string &str) {
        //Reduce space usage by a factor of 8 using bitvector.
        //Each boolean otherwise occupies a size of 8 bits.
        bitset<256> bits(0);
        for (int val: str) {
            if (bits.test(val) > 0) {
                return false;
            }
            bits.set(val);
        }
        return true;
    }

    static bool isUniqueChars_noDS(string str) {

        sort(str.begin(), str.end()); // O(nlogn) sort from <algorithm>

        bool noRepeat = true;
        for (int i = 0; i < str.size() - 1; i++) {
            if (str[i] == str[i + 1]) {
                noRepeat = false;
                break;
            }
        }

        return noRepeat;
    }

    int main() {
        vector<string> words = {"abcde", "hello", "apple", "kite", "padle"};
        for (const auto &word: words) {
            cout << word << string(": ") << boolalpha << isUniqueChars(word) << endl;
        }
        cout << endl << "Using bit vector" << endl;
        for (const auto &word: words) {
            cout << word << string(": ") << boolalpha << isUniqueChars_bitvector(word) << endl;
        }
        cout << endl << "Using no Data Structures" << endl;
        for (const auto &word: words) {
            cout << word << string(": ") << boolalpha << isUniqueChars_noDS(word) << endl;
        }
        return 0;
    }
};

#endif