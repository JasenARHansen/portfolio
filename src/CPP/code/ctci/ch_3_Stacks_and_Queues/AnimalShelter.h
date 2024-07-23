#pragma clang diagnostic push
#pragma ide diagnostic ignored "UnusedParameter"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_3_STACKS_AND_QUEUES_ANIMAL_SHELTER
#define CTCI_CH_3_STACKS_AND_QUEUES_ANIMAL_SHELTER

#include <string>
#include <queue>

namespace ctci {
    class AnimalShelter {
    private:
        struct Animal {
            std::string name;
            int age;

            Animal() : age(0) {}

            explicit Animal(std::string name, int age) : name(std::move(name)), age(age) {}
        };

        struct Cat : Animal {
            explicit Cat(std::string name, int age) : Animal(std::move(name), age) {}
        };

        struct Dog : Animal {
            explicit Dog(std::string name, int age) : Animal(std::move(name), age) {}
        };

        enum Code {
            EDog,
            ECat,
            EError,
        };

        static Code hashIt(std::string input);

    public:
        static void description();

        AnimalShelter();

        void enqueue(std::string type, const std::string &name);

        void enqueueCat(const std::string &name);

        void enqueueDog(const std::string &name);

        std::string dequeue();

        std::string dequeueCat();

        std::string dequeueDog();

        [[nodiscard]] std::string peek();

        [[nodiscard]] std::string peekCat();

        [[nodiscard]] std::string peekDog();

        [[nodiscard]] bool empty() const;

        [[nodiscard]] bool emptyCat() const;

        [[nodiscard]] bool emptyDog() const;

        [[nodiscard]] int size() const;

        [[nodiscard]] int sizeCat() const;

        [[nodiscard]] int sizeDog() const;

    private:
        int counter = 0;
        std::queue<Cat *> cat;
        std::queue<Dog *> dog;
    };
}
#endif
#pragma clang diagnostic pop