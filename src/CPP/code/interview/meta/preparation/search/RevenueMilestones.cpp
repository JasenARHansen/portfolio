#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class RevenueMilestones {
public:
    static void description() {
        cout << R"(Revenue Milestones
    We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue milestones. Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days on which Facebook reached every milestone.

    Signature
        int[] getMilestoneDays(int[] revenues, int[] milestones)

    Input
        revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N). milestones is a length-K array of total revenue milestones.

    Output
        Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue. If the milestone is never met, return -1.

    Example
        revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
        milestones = [100, 200, 500]
        output = [4, 6, 10]
        Explanation
            On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively. Day 6 is the first time that FB has >= $200 of total revenue.)"
             << endl;
    }

    static vector<int> getMilestoneDays(vector<int> revenues, vector<int> milestones) {
        vector<int> result(milestones.size(), -1);
        auto sum = 0;
        for (int revenue = 0; revenue < revenues.size(); revenue++) {
            sum += revenues.at(revenue);
            for (int milestone = 0; milestone < milestones.size(); milestone++) {
                if ((result.at(milestone) == -1) && (sum >= milestones.at(milestone))) {
                    result[milestone] = revenue + 1;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop