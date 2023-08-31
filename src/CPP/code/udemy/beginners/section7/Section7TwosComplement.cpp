#include "Section7TwosComplement.h"


int Section7TwosComplement::performTwosComplement(int input) {
    // Generate bitset to determine bits
    bitset<sizeof(input)*8> data(input);
    std::cout << "input = " << input << " as bits: " << data.to_string() << endl;
    // Perform 1's complement to flip all bits
    for (int index = 0; index < data.size(); index++){
        data.flip(index);
    }
    std::cout << "1's Complement: " << data.to_string() << endl;
    // add 1 to result to get 2's complement
    for (int index = 0; index < data.size(); index++){
        data.flip(index);
        if (data.test(index)){
            break;
        }
    }
    std::cout << "2's Complement: " << data.to_string() << endl;
    return (int)data.to_ulong();
}


