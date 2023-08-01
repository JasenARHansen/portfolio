#include "Section5Arrays.h"

void Section5Arrays::incrementArrayPointer(const int size, int *pInt) {
    for (int i = 0; i < size; i++) {
        pInt[i]++;
    }
}
