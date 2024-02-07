#include "Section2Variables.h"
#include <iostream>

string Section2Variables::numAnimals() {
    int numberCats = 5;
    int numberDogs = 7;
    int numberAnimals = numberCats + numberDogs;
    string cats = "Number of cats: " + std::to_string(numberCats);
    string dogs = "Number of dogs: " + std::to_string(numberDogs);
    string animals = "Total number of animals: " + std::to_string(numberAnimals);
    string newDog = "New dog acquired";
    numberDogs = numberDogs + 1;
    string dogsNew = "Number of dogs: " + std::to_string(numberDogs);
    return cats + "\n" + dogs + "\n" + animals + "\n" + newDog + "\n" + dogsNew;
}

void Section2Variables::numAnimalsOut() {
    int numberCats = 5;
    int numberDogs = 7;
    int numberAnimals = numberCats + numberDogs;
    cout << "Number of cats: " << numberCats << std::endl;
    cout << "Number of dogs: " << numberDogs << std::endl;
    cout << "Total number of animals: " << numberAnimals << std::endl;
    cout << "New dog acquired" << std::endl;
    numberDogs = numberDogs + 1;
    cout << "Number of dogs: " << numberDogs << std::endl;
}
