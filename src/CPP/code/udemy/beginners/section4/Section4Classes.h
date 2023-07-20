#ifndef PORTFOLIO_SECTION4CLASSES_H
#define PORTFOLIO_SECTION4CLASSES_H

#include <string>
#include <iostream>

using namespace std;

class section4Classes {
private:
    string name;
    bool mood;
public:
    section4Classes();

    explicit section4Classes(const string &name);

    ~section4Classes();

    [[nodiscard]] string sound() const;

    static string move();

    void setHappy();

    void setUnHappy();

    const string &getName() const;

    void setName(const string &name);


};


#endif