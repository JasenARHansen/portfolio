#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

class MinimumRuntime {
public:
    struct Task {
        string taskId;
        string name;
        int timeSec;
        vector<string> dependsOn;
        int startTime;

        explicit Task(string taskId, string name, int timeSec, vector<string> dependsOn) : taskId(std::move(taskId)),
                                                                                           name(std::move(name)),
                                                                                           timeSec(timeSec),
                                                                                           dependsOn(std::move(
                                                                                                   dependsOn)),
                                                                                           startTime(0) {}

    };

    static void description() {
        cout << R"(Calculate minimum runtime:
    Given a set of tasks, their run times and dependencies between tasks, compute shortest time
     to process tasks in parallel (can’t start task if any of pre-requisites haven’t been finished).
    If there is no valid runtime return -1
    Sample input:
        [
            {
                taskId: "task_1",
                name: "First Task",
                timeSec: 20,
                dependsOn: []
            },
            {
                taskId: "task_2",
                name: "Some Task",
                timeSec: 50,
                dependsOn: []
            },
            {
                taskId: "task_3",
                name: "Some Other Task",
                timeSec: 35,
                dependsOn: ["task_1", "task_2"]
            },
            {
                taskId: "task_4",
                name: "Some Other Task",
                timeSec: 60,
                dependsOn: ["task_2"]
            }
        ]
    Expected output:
        110)" << endl;
    }

/*
    static int calculateRuntime(const vector<MinimumRuntime::Task> &tasks) {
        auto result = INT_MAX;
        map<string, Task> pendingProcessing;
        queue<Task> processing;
        for (auto task: tasks) {
            if (task.dependsOn.empty()) {
                processing.push(task);
            } else {
                pendingProcessing.insert({task.taskId, task});
            }
        }

        while (!processing.empty()) {
            auto working = processing.front();
            processing.pop();
            auto time = working.startTime + working.timeSec;
            if (time < 0){

            }
            result += working.second;
            // update remaining time for execution;
            for (auto & index : processing) {
                index.second -= working.second;
            }

            // check remaining items for processing to update
            stack<string> toRemove;
            for (const auto& element: pendingProcessing) {
                pendingProcessing.at(element.first).dependsOn.erase(
                        remove(pendingProcessing.at(element.first).dependsOn.begin(),
                               pendingProcessing.at(element.first).dependsOn.end(), working.first),
                        pendingProcessing.at(element.first).dependsOn.end());
                if (pendingProcessing.at(element.first).dependsOn.empty()){
                    element.second.startTime;


                    setToProcess(&processing, &pendingProcessing.at(element.first));
                    toRemove.push(element.first);
                }
            }
            while (!toRemove.empty()){
                auto value = toRemove.top();
                toRemove.pop();
                pendingProcessing.erase(value);
            }
        }
        return (pendingProcessing.empty()) ? result :-1;
    }
*/
    static int calculateRuntimeTimeline(const vector<MinimumRuntime::Task> &tasks) {
        auto result = 0;
        map<string, Task> pendingProcessing;
        vector<pair<string, int>> processing;
        for (auto task: tasks) {
            if (task.dependsOn.empty()) {
                setToProcess(&processing, &task);
            } else {
                pendingProcessing.insert({task.taskId, task});
            }
        }
        while (!processing.empty()) {
            auto working = processing.at(0);
            processing.erase(processing.begin());
            result += working.second;
            // update remaining time for execution;
            for (auto &index: processing) {
                index.second -= working.second;
            }
            // check remaining items for processing to update
            stack<string> toRemove;
            for (const auto &element: pendingProcessing) {
                pendingProcessing.at(element.first).dependsOn.erase(
                        remove(pendingProcessing.at(element.first).dependsOn.begin(),
                               pendingProcessing.at(element.first).dependsOn.end(), working.first),
                        pendingProcessing.at(element.first).dependsOn.end());
                if (pendingProcessing.at(element.first).dependsOn.empty()) {
                    setToProcess(&processing, &pendingProcessing.at(element.first));
                    toRemove.push(element.first);
                }
            }
            while (!toRemove.empty()) {
                auto value = toRemove.top();
                toRemove.pop();
                pendingProcessing.erase(value);
            }
        }
        return (pendingProcessing.empty()) ? result : -1;
    }

private:
    static void setToProcess(vector<pair<string, int>> *process, Task *task) {
        if (process->empty()) {
            process->emplace_back(task->taskId, task->timeSec);
        } else {
            auto index = 0;
            while ((index < (int) process->size()) and (process->at(index).second < task->timeSec)) {
                index++;
            }
            process->insert(process->begin() + index, {task->taskId, task->timeSec});
        }
    }
};

#pragma clang diagnostic pop