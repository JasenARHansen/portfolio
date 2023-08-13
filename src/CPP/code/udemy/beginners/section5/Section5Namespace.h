#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_5_NAMESPACE_H
#define UDEMY_BEGINNERS_5_NAMESPACE_H

#include <string>
#include <iostream>
#include <iomanip>

using namespace std;

namespace jsn {

    class Section5Namespace {
    private:
        string name;

    public:
        Section5Namespace();

        [[nodiscard]] const string &getName() const;

        static Section5Namespace *createObject();

        static void deleteObject(Section5Namespace **pClasses);
    };

}

#endif
#pragma clang diagnostic pop