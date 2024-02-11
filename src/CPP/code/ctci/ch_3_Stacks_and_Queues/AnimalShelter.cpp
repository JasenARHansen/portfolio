#include "AnimalShelter.h"
#include <iostream>
#include <algorithm>
#include <utility>

using namespace ctci;

void AnimalShelter::description() {
    std::cout << R"(Stacks and Queues: Animal Shelter
    An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
    People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they
     can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
    They cannot select which specific animal they would like.
    Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny,
     dequeueDog, and dequeueCat.
    You may use the built-in LinkedList data structure.)" << std::endl;
}

AnimalShelter::AnimalShelter() = default;

AnimalShelter::Code AnimalShelter::hashIt(std::string input) {
    transform(input.begin(), input.end(), input.begin(), ::tolower);
    if (input == "cat") {
        return ECat;
    } else if (input == "dog") {
        return EDog;
    } else {
        return EError;
    }
}

void AnimalShelter::enqueue(std::string type, const std::string &name) {
    switch (hashIt(std::move(type))) {
        case ECat:
            this->cat.emplace(new Cat(name, this->counter++));
            break;
        case EDog:
            this->dog.emplace(new Dog(name, this->counter++));
            break;
        default:
            break;
    }
}

void AnimalShelter::enqueueCat(const std::string &name) {
    enqueue("cat", name);
}

void AnimalShelter::enqueueDog(const std::string &name) {
    enqueue("dog", name);
}

std::string AnimalShelter::dequeue() {
    std::string result = "No Animals available";
    if (!this->cat.empty() and !this->dog.empty()) {
        if (this->cat.front()->age < this->dog.front()->age) {
            result = dequeueCat();
        } else {
            result = dequeueDog();
        }
    } else if (!this->cat.empty()) {
        result = dequeueCat();
    } else if (!this->dog.empty()) {
        result = dequeueDog();
    }
    return result;
}

std::string AnimalShelter::dequeueCat() {
    std::string result = "No Cat available";
    if (!this->cat.empty()) {
        result = cat.front()->name;
        cat.pop();
    }
    return result;
}

std::string AnimalShelter::dequeueDog() {
    std::string result = "No Dog available";
    if (!this->dog.empty()) {
        result = dog.front()->name;
        dog.pop();
    }
    return result;
}

std::string AnimalShelter::peek() {
    std::string result = "No Animals available";
    if (!this->cat.empty() and !this->dog.empty()) {
        if (this->cat.front()->age < this->dog.front()->age) {
            result = peekCat();
        } else {
            result = peekDog();
        }
    } else if (!this->cat.empty()) {
        result = peekCat();
    } else if (!this->dog.empty()) {
        result = peekDog();
    }
    return result;
}

std::string AnimalShelter::peekCat() {
    std::string result = "No Cat available";
    if (!this->cat.empty()) {
        result = cat.front()->name;
    }
    return result;
}

std::string AnimalShelter::peekDog() {
    std::string result = "No Dog available";
    if (!this->dog.empty()) {
        result = dog.front()->name;
    }
    return result;
}

bool AnimalShelter::empty() const {
    return (emptyCat() and emptyDog());
}

bool AnimalShelter::emptyCat() const {
    return this->cat.empty();
}

bool AnimalShelter::emptyDog() const {
    return this->dog.empty();
}

int AnimalShelter::size() const {
    return sizeCat() + (int) sizeDog();
}

int AnimalShelter::sizeCat() const {
    return (int) this->cat.size();
}

int AnimalShelter::sizeDog() const {
    return (int) this->dog.size();
}