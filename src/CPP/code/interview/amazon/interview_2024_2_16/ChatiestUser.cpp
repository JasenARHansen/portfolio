#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantParameter"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <utility>
#include <vector>
#include <string>
#include <map>
#include <sstream>

using namespace std;


class ChatiestUser {
public:
    static void description() {
        cout << R"(Get chattiest user:
    You have a chat program, similar to IRC, Skype, Chime etc.
    Write a program to determine the user who messages the most in a channel.
    This is the reference string "<room ID>.<date>.<user ID>: <body>""
    Example: amazoninterview.today.jasen:"Hi Hitesh how are u?"
    Note:  The ':' character is not guarenteed to be unique in teh body
    Note the '.' character is unique in the prefix)" << endl;
    }

    void trackMessage(const string &reference) {
        // I need to split the string, so I have the prefix and the suffix.  It looks like ':' is the split character.
        auto parsedRef = splitOnFirstInstance(reference, ":");
        auto parsedPrefix = splitOnCharacter(parsedRef.first, '.');
        auto userid = parsedPrefix.at(2);
        // Has this user been seen?
        if (this->data.count(userid) == 0) {  // not been seen
            this->data[userid] = {};
            this->data[userid]["count"] = 0;
        }
        this->data[userid]["count"]++;
    }

    string getChatiestUser() {
        string result = "unknown!";
        auto count = 0;
        for (auto user: this->data) { // Looping over maps in this way returns Pair objects.  item.first = key, item.second is value
            if (user.second["count"] > count) {
                count = user.second["count"];
                result = user.first;
            }
        }
        return result;
    }

    string getChatiestUser(const string &reference) {
        // I need to split the string, so I have the prefix and the suffix.  It looks like ':' is the split character.
        auto parsedRef = splitOnFirstInstance(reference, ":");
        auto parsedPrefix = splitOnCharacter(parsedRef.first, '.');
        auto userid = parsedPrefix.at(2);
        // Has this user been seen?
        if (this->data.count(userid) == 0) {
            this->data[userid] = {};
            this->data[userid]["count"] = 0;
        }
        this->data[userid]["count"]++;
        if ((!this->globalQueries.count("largestCount")) or
            (stoi(this->globalQueries.at("largestCount")) < this->data[userid]["count"])) {
            this->globalQueries["largestCount"] = to_string(this->data[userid]["count"]);
            this->globalQueries["chatiestUser"] = userid;
        }
        return this->globalQueries["chatiestUser"];
    }

private:
    static vector<string> splitOnCharacter(const string &input, char split) {
        // returns {"roomID", "date", "userid"}
        vector<string> result;
        string line;
        stringstream ss(input);
        while (getline(ss, line, split)) {
            result.push_back(line);
        }
        return result;
    }

    static pair<string, string> splitOnFirstInstance(const string &input, const string &split) {
        // returns {"roomID.date.userid", "Hi Hitesh how are u?"}
        pair<string, string> result;
        auto pos = input.find(split);
        result.first = input.substr(0, pos);
        result.second = input.substr(pos + 1, string::npos);
        return result;
    }

    map<string, map<string, int >> data = {};

    map<string, string> globalQueries = {};
};

#pragma clang diagnostic pop