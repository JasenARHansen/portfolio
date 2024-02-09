#pragma clang diagnostic push
#pragma ide diagnostic ignored "UnusedParameter"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_3_STACKS_AND_QUEUES_ANIMAL_SHELTER
#define CTCI_CH_3_STACKS_AND_QUEUES_ANIMAL_SHELTER

#include <string>
#include <queue>
#include <utility>

using namespace std;

class AnimalShelter {
private:
    struct Animal {
        string name;
        int age;

        Animal() : age(0) {}

        explicit Animal(string name, int age) : name(std::move(name)), age(age) {}
    };

    struct Cat : Animal {
        explicit Cat(string name, int age) : Animal(std::move(name), age) {}
    };

    struct Dog : Animal {
        explicit Dog(string name, int age) : Animal(std::move(name), age) {}
    };

    enum Code {
        EDog,
        ECat,
        EError,
    };

    static Code hashIt(string input);

public:
    static void description();

    AnimalShelter();

    void enqueue(string type, const string &name);

    void enqueueCat(const string &name);

    void enqueueDog(const string &name);

    string dequeue();

    string dequeueCat();

    string dequeueDog();

    [[nodiscard]] string peek();

    [[nodiscard]] string peekCat();

    [[nodiscard]] string peekDog();

    [[nodiscard]] bool empty() const;

    [[nodiscard]] bool emptyCat() const;

    [[nodiscard]] bool emptyDog() const;

    [[nodiscard]] int size() const;

    [[nodiscard]] int sizeCat() const;

    [[nodiscard]] int sizeDog() const;

private:
    int counter = 0;
    queue<Cat *> cat;
    queue<Dog *> dog;
};

#endif
#pragma clang diagnostic pop