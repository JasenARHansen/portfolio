#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_4_CLASSES_H
#define UDEMY_BEGINNERS_4_CLASSES_H

#include <string>
#include <iostream>

using namespace std;

class Section4Classes {
private:
    string name;
    bool mood;
    int age;
public:
    Section4Classes();

    explicit Section4Classes(const string &name);

    explicit Section4Classes(string name, int age);

    ~Section4Classes();

    [[nodiscard]] string sound() const;

    static string move();

    void setHappy();

    void setUnHappy();

    [[nodiscard]] const string &getName() const;

    void setName(const string &name);

    [[nodiscard]] int getAge() const;
};

#endif
#pragma clang diagnostic pop