#include "Section7Static.h"

int Section7Static::count = 0;

Section7Static::Section7Static() {
    count++;
}

int Section7Static::getCount() {
    return count;
}


