#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <bits/stdc++.h>
#include <cassert>

using namespace std;


class Amazon_Interview_2023_11_16 {

public:
    static void description() {
        cout << R"(Is there a box that fits?
    Items can ship as-is (no Amazon box).
    In some scenarios, Customers want Amazon to place their items in an Amazon box.
    The problem: Amazon only has a finite set of box types.
    We want to warn the customer if an item they are about to purchase is too big to fit in any box type.
    For this problem there will be 1 item per box.
    Each Item will have its dimensions included.
    Each Box will have its dimensions included in a list sorted smallest to largest.
    The list of boxes will be sorted with the based based on the indexes of the Measurement list
    Create a method to find out if there is a box that fits.
    Create a method to return the box that best fits the item.)" << endl;
    }

    struct Box {
        vector<int> dimensions;

        explicit Box(int length, int width, int height) {
            this->dimensions.push_back(length);
            this->dimensions.push_back(width);
            this->dimensions.push_back(height);
            sort(this->dimensions.begin(), this->dimensions.end(), less<>());
        }

        explicit Box(vector<int> data) {
            assert(data.size() == 3);
            copy(data.begin(), data.end(), back_inserter(this->dimensions));
            sort(this->dimensions.begin(), this->dimensions.end(), less<>());
        }
    };

    struct Item {
        vector<int> dimensions;

        explicit Item(int length, int width, int height) {
            this->dimensions.push_back(length);
            this->dimensions.push_back(width);
            this->dimensions.push_back(height);
            sort(this->dimensions.begin(), this->dimensions.end(), less<>());
        }

        explicit Item(vector<int> data) {
            assert(data.size() == 3);
            copy(data.begin(), data.end(), back_inserter(this->dimensions));
            sort(this->dimensions.begin(), this->dimensions.end(), less<>());
        }
    };

    static void sortBoxes(vector<Box *> &boxes) {
        sort(boxes.begin(), boxes.end(), [](Box *a, Box *b) { return a->dimensions < b->dimensions; });
    }

    static bool isThereABox(Item *item, const vector<Box *> &boxes) {
        // This does not require sorted boxes
        for (int index = (int) boxes.size() - 1; 0 <= index; index--) {
            if ((item->dimensions[0] <= boxes[index]->dimensions[0])
                && (item->dimensions[1] <= boxes[index]->dimensions[1])
                && (item->dimensions[2] <= boxes[index]->dimensions[2])) {
                return true;
            }
        }
        return false;
    }

    static Box *getBestBox(Item *item, const vector<Box *> &boxes) {
        // This requires the Box vector to be sorted
        for (auto box: boxes) {
            if ((item->dimensions[0] <= box->dimensions[0])
                && (item->dimensions[1] <= box->dimensions[1])
                && (item->dimensions[2] <= box->dimensions[2])) {
                return box;
            }
        }
        return nullptr;
    }

};

#pragma clang diagnostic pop