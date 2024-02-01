#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Contacts {
public:
    static void description() {
        cout << R"(We're going to make our own Contacts application!
    The application must perform two types of operations:
        1: add name, where name is a string denoting a contact name.
            This must store name as a new contact in the application.
        2: find partial, where partial is a string denoting a partial name to search the application for.
            It must count the number of contacts starting with partial and print the count on a new line.
    Given n sequential add and find operations, perform each operation in order.
    Example:
        Operations are requested as follows:
            add ed
            add eddie
            add edward
            find ed
            add edwina
            find edw
            find a
        Three add operations include the names 'ed', 'eddie', and 'edward'.
        Next, 'find ed' matches all 3 names.
        Note that it matches and counts the entire name 'ed'.
        Next, add 'edwina' and then find 'edw'.
        2 names match: 'edward' and 'edwina'.
        In the final operation, there are 0 names that start with 'a'.
        Return the array [3, 2, 0].
    Function Description:
        Complete the contacts function below.
        contacts has the following parameters:
            string queries[n]: the operations to perform
    Returns:
        int[]: the results of each find operation
    Input Format:
        The first line contains a single integer, n, the number of operations to perform (the size of queries[]).
        Each of the following n lines contains a string, queries[i].
    Constraints:
        1 ≤ n ≤ 10^5
        1 ≤ length of name ≤ 21
        1 ≤ length of partial ≤ 21
        name and partial contain lowercase English letters only.
        The input does not have any duplicate name for the add operation.
    Sample Input:
        STDIN           Function
        -----           --------
        4               queries[] size n = 4
        add hack        queries = ['add hack', 'add hackerrank', 'find hac', 'find hak']
        add hackerrank
        find hac
        find hak
    Sample Output:
        2
        0
    Explanation:
        Add a contact named hack.
        Add a contact named hackerrank.
        Find the number of contact names beginning with hac.
        Both name start with hac, add  to the return array.
        Find the number of contact names beginning with hak.
        Neither name starts with hak, add 0 to the return array.)" << endl;
    }

    Contacts() {
        trei = ContactTrei();
    }

    vector<int> readUserInput(istream &std_input) {
        vector<int> results;
        int count;
        std_input >> count;
        string command;
        string word;
        for (int i = 0; i < count; i++) {
            std_input >> command;
            std_input >> word;
            if (command == "add") {
                trei.add(word);
            } else if (command == "find") {
                results.push_back(trei.find(word));
            }
        }
        return results;
    }

private:
    struct Node {
        int count;
        bool end;
        unordered_map<char, Node *> children;

        explicit Node() : count(0), end(false) {}

        void setEnd() {
            this->end = true;
        }

        void incrementCount() {
            this->count++;
        }

        int getCount() const {
            return this->count;
        }

        bool contains(char child) {
            return this->children.find(child) != this->children.end();
        }

        Node *getChild(char child) {
            return this->children.at(child);
        }

        void insert(char child) {
            auto *result = new Node();
            this->children[child] = result;
        }
    };

    class ContactTrei {
    public:
        ContactTrei() {
            this->node = new Node();
        };

        void add(string child) {
            Node *working = this->node;
            working->incrementCount();
            auto index = 0;
            char character;
            while (index < child.size()) {
                character = child[index];
                if (!working->contains(character)) {
                    working->insert(character);
                }
                working = working->getChild(character);
                working->incrementCount();
                index++;
            }
            working->setEnd();
        }

        int find(string child) {
            auto result = 0;
            Node *working = this->node;
            working->incrementCount();
            auto index = 0;
            char character;
            while (index < child.size()) {
                character = child[index];
                if (!working->contains(character)) {
                    break;
                }
                working = working->getChild(character);
                index++;
            }
            if (index == child.size()) {
                result = working->getCount();
            }
            return result;
        }

    private:
        Node *node;
    };

    ContactTrei trei;
};

#pragma clang diagnostic pop