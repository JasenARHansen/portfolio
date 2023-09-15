#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class ResizableArray {
public:
    static void description() {
        cout << R"(Question: Resizable Array
    In most languages arrays have fixed length, but sometimes you need to add additional elements.
    Write a class that allows for arrays to grow.)" << endl;
    }

    int count;
    int *items;

    ResizableArray() {
        this->count = 0;
        this->items = new int[this->count];
    }

    [[nodiscard]] int size() const {
        return this->count;
    }

    [[nodiscard]] int *array() const {
        return this->items;
    }

    [[nodiscard]] int get(int index) const {
        return this->items[index];
    }

    void set(int value, int index) {
        if (index + 1 > this->count) {
            increaseSize(index + 1 - this->count);
        }
        this->items[index] = value;
    }

    [[nodiscard]] string print() const {
        string result = "[";
        if ((this->count > 0)) {
            if (this->count > 1) {
                for (int index = 0; index < this->count - 2; index++) {
                    result.append(to_string(this->items[index]));
                    result.append(", ");
                }
            }
            result.append(to_string(this->items[this->count - 1]));
        }
        result.append("]");
        return result;
    }

private:
    void increaseSize(int minimumIncrease) {
        int size;
        if (minimumIncrease > this->count) {
            size = this->count + minimumIncrease;
        } else {
            size = this->count * 2;

        }
        int *replacement = new int[size];
        memcpy(replacement, this->items, this->count * sizeof(int));
        delete[] this->items;
        for (int index = this->count; index < size; index++) {
            replacement[index] = 0;
        }
        this->count = size;
        this->items = replacement;
    }
};

#pragma clang diagnostic pop