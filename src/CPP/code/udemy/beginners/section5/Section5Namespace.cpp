#include "Section5Namespace.h"


namespace jsn {

    Section5Namespace::Section5Namespace() {
        this->name = "Section5Namespace";
    }

    const string &Section5Namespace::getName() const {
        return this->name;
    }

    Section5Namespace *Section5Namespace::createObject() {
        return new Section5Namespace();
    }

    void Section5Namespace::deleteObject(Section5Namespace **pClasses) {
        delete *pClasses;
        *pClasses = nullptr;
    }
}