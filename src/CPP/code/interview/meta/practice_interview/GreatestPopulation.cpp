#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <map>
#include <queue>

using namespace std;


struct Person {
    int birth;
    int death;
};

class GreatestPopulation {
public:
    static void description() {
        cout << R"(Question 4:
    Given a list of people with their birth and death years, find the year with the highest population
    Input:
        people = {{2000, 2010}, {1975, 2005}, {1975, 2003}, {1803, 1809}, {1750, 1869}, {1840, 1935}, {1803, 1921}, {1894, 1921}};
    Output:
        1803)" << endl;
    }

    static int findGreatestPopulation(vector<Person> people) {
        priority_queue<int, vector<int>, greater<>> birthMinHeap;
        priority_queue<int, vector<int>, greater<>> deathMinHeap;
        // Map all the births and deaths to the years
        for (auto person: people) {
            birthMinHeap.push(person.birth);
            deathMinHeap.push(person.death);
        }
        // If the records are old, there may be some people that we have death dates but no birth records
        while (!deathMinHeap.empty() && (deathMinHeap.top() < birthMinHeap.top())) {
            deathMinHeap.pop();
        }
        // process years
        auto result = birthMinHeap.top();
        birthMinHeap.pop();
        auto population = 1;
        auto populationPeak = population;
        while (!birthMinHeap.empty() && !deathMinHeap.empty()) {
            if (birthMinHeap.top() <= deathMinHeap.top()) {
                population++;
                if (population > populationPeak) {
                    populationPeak = population;
                    result = birthMinHeap.top();
                }
                birthMinHeap.pop();
            } else {
                population--;
                deathMinHeap.pop();
            }
        }
        // If the records are modern, there are some people that have not died yet
        while (!birthMinHeap.empty()) {
            population++;
            if (population > populationPeak) {
                populationPeak = population;
                result = birthMinHeap.top();
            }
            birthMinHeap.pop();
        }
        return result;
    }
};

#pragma clang diagnostic pop