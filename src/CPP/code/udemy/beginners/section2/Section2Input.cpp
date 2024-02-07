#include "Section2Input.h"
#include <string>
#include <iostream>

using namespace std;

void Section2Input::input() {
    cout << "Enter your name: " << flush;
    string name;
    cin >> name;
    cout << "You entered: " << name << endl;
    cout << "Enter your age: " << flush;
    int age;
    cin >> age;
    cout << "You entered: " << name << endl;
}
