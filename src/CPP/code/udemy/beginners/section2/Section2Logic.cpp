#include "Section2Logic.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "LoopDoesntUseConditionVariableInspection"
#pragma ide diagnostic ignored "UnreachableCode"
#pragma ide diagnostic ignored "ConstantConditionsOC"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

void section2Logic::ifStatement() {
    string password = "hello";
    cout << "Enter your password: " << flush;
    string input;
    cin >> input;
    if (password == input) {
        cout << "Password accepted." << endl;
    } else {
        cout << "Access denied." << endl;
    }
}

void section2Logic::ifElseStatement() {
    string password = "hello";
    cout << "Enter your password: " << flush;
    string input;
    cin >> input;
    if (password == input) {
        cout << "Password accepted." << endl;
    } else {
        cout << "Access denied." << endl;
    }
}

void section2Logic::ifElseIfStatement() {
    cout << "1.\tAdd a record." << endl;
    cout << "2.\tDelete a record." << endl;
    cout << "3.\tView a record." << endl;
    cout << "4.\tSearch a record." << endl;
    cout << "5.\tquit." << endl;
    cout << "Enter your selection: " << endl;
    int value;
    cin >> value;
    if (value == 1) {
        cout << "Adding a record." << endl;
    } else if (value == 2) {
        cout << "Deleting a record." << endl;
    } else if (value == 3) {
        cout << "Viewing a record." << endl;
    } else if (value == 4) {
        cout << "Searching a record." << endl;
    } else if (value == 5) {
        cout << "Quiting." << endl;
    } else {
        cout << "Invalid option, quitting." << endl;
    }
}

void section2Logic::switchStatement() {
    cout << "1.\tAdd a record." << endl;
    cout << "2.\tDelete a record." << endl;
    cout << "3.\tView a record." << endl;
    cout << "4.\tSearch a record." << endl;
    cout << "5.\tquit." << endl;
    cout << "Enter your selection: " << endl;
    int value;
    cin >> value;
    switch (value) {
        case 1:
            cout << "Adding a record." << endl;
            break;
        case 2:
            cout << "Deleting a record." << endl;
            break;
        case 3:
            cout << "Viewing a record." << endl;
            break;
        case 4:
            cout << "Searching a record." << endl;
            break;
        case 5:
            cout << "Quiting." << endl;
            break;
        default:
            cout << "Invalid option, quitting." << endl;
    }
}

void section2Logic::conditions() {
    int value1 = 7;
    int value2 = 4;
    if (value1 >= 5) {
        cout << "Condition 1 true." << endl;
    } else {
        cout << "Condition 1 false." << endl;
    }
    if (value1 == 7 && value2 < 3) {
        cout << "Condition 2 true." << endl;
    } else {
        cout << "Condition 2 false." << endl;
    }
    if (value1 == 7 || value2 < 3) {
        cout << "Condition 3 true." << endl;
    } else {
        cout << "Condition 3 false." << endl;
    }
    if (value2 != 8 && value1 == 7 || value1 < 10) {
        cout << "Condition 4 true." << endl;
    } else {
        cout << "Condition 4 false." << endl;
    }
    if ((value2 != 8 && value1 == 10) || value1 < 10) {
        cout << "Condition 5 true." << endl;
    } else {
        cout << "Condition 5 false." << endl;
    }
    bool condition1 = (value2 != 8) && (value1 == 10);
    cout << "Condition 6 " << condition1 << endl;
    bool condition2 = value1 < 10;
    cout << "Condition 7 " << condition2 << endl;
    if (condition1 || condition2) {
        cout << "Condition 8 true." << endl;
    } else {
        cout << "Condition 8 false." << endl;
    }
}

void section2Logic::whileLoop() {
    while (true) {
        cout << "Infinite while loop with break." << endl;
        break;
    }
    cout << "Infinite while loop over." << endl;
    int counter1 = 0;
    while (counter1 < 3) {
        counter1++;
        cout << "While loop execution " << counter1 << endl;
    }
    cout << "While loop over." << endl;
}

void section2Logic::doWhileLoop() {
    const int counter1 = 11;
    do {
        cout << "Do while loop with condition already met" << endl;
    } while (counter1 < 3);
    int counter2 = 0;
    do {
        counter2++;
        cout << "Do while loop execution " << counter2 << endl;
    } while (counter2 < 3);


}

void section2Logic::forLoop() {
    for (;;) {
        cout << "For loop no inputs with a break" << endl;
        break;
    }
    for (int counter = 0;;) {
        cout << "For loop with a break, only counter defined execution " << counter << endl;
        break;
    }
    for (int counter = 0; counter < 3;) {
        counter++;
        cout << "For loop increment in loop execution " << counter << endl;
    }
    for (int counter = 0; counter < 3; counter++) {
        cout << "For loop fully defined execution " << counter << endl;
    }

    for (int counter = 0; counter < 4; counter++) {
        if (counter % 2) {
            continue;
        }
        cout << "For loop mod 2 continue execution " << counter << endl;
    }

    for (int counter = 0; counter < 4; counter++) {
        if (counter % 2) {
            break;
        }
        cout << "For loop mod 2 break execution " << counter << endl;
    }
}

#pragma clang diagnostic pop