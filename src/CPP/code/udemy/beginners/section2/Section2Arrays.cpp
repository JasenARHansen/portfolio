#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-sizeof-container"

#include "Section2Arrays.h"

void Section2Arrays::arrays() {
    cout << "Array with individual assignments" << endl;
    int first[3];
    first[0] = 7;
    first[1] = 0;
    first[2] = 3;
    cout << "First array size: " << sizeof(first) << endl;
    cout << "First array element size: " << sizeof(first[0]) << endl;
    for (int i = 0; i < sizeof(first) / sizeof(first[0]); i++) {
        cout << "First index " << i << " has a value of " << first[i] << endl;
    }
    int second[]{3, 0, 1};
    for (int i = 0; i < sizeof(second) / sizeof(second[0]); i++) {
        cout << "Second index " << i << " has a value of " << second[i] << endl;
    }
    double third[]{1.1, 5.55, 1};
    for (int i = 0; i < sizeof(third) / sizeof(third[0]); i++) {
        cout << "Third index " << i << " has a value of " << setprecision(3) << fixed << third[i] << endl;
    }
    string fourth[]{"cat", "dog"};
    cout << "Fourth array size: " << sizeof(fourth) << endl;
    cout << "Fourth array element size: " << sizeof(fourth[0]) << endl;
    for (int i = 0; i < sizeof(fourth) / sizeof(fourth[0]); i++) {
        cout << "Fourth index " << i << " has a value of " << fourth[i] << endl;
    }
    string fifth[3]{"first", "second"};
    for (int i = 0; i < sizeof(fifth) / sizeof(fifth[0]); i++) {
        cout << "Fifth (partial initialization) index " << i << " has a value of " << fifth[i] << endl;
    }
    char text[] = "hello";
    for (int i = 0; i < sizeof(text) - 1; i++) {
        cout << "Character " << i << " is: " << text[i] << endl;
    }
    int k = 0;
    while (true) {
        if (text[k] == 0) {
            cout << endl;
            break;
        }
        cout << text[k] << flush;
        k++;
    }
}

void Section2Arrays::arraysMultiDimensional() {
    string animals[2][3]{{"Fox",   "Cat",      "Dog"},
                         {"Mouse", "Squirrel", "Parrot"}};
    cout << "Animals array size: " << sizeof(animals) << endl;
    cout << "Animals row size: " << sizeof(animals[0]) << endl;
    cout << "Animal size: " << sizeof(animals[0][0]) << endl;
    for (int i = 0; i < sizeof(animals) / sizeof(animals[0]); i++) {
        cout << "Animals Row " << i << ":" << flush;
        for (int j = 0; j < sizeof(animals[0]) / sizeof(animals[0][0]); j++) {
            cout << " " << animals[i][j] << flush;
        }
        cout << endl;
    }
}

#pragma clang diagnostic pop