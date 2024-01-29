#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

class ProcessLogs {
public:
    static void description() {
        cout << R"(Question 1: processLogs
    Your Amazonian team is responsible for maintaining a monetary transaction service.
    The transactions are tracked in a log file.
    A log file is provided as a string array where each entry represents a transaction to service.
    Each transaction consists of:
        sender_user_id:  Unique identifier for the user that initiated the transaction.
                          It consists of only digits with at most 9 digits.
        recipient_user_id:  Unique identifier for the user that is receiving the transaction.
                             It consists of only digits with at most 9 digits.
        amount_of_transaction:  The amount of the transaction.
                                 It consists of only digits with at most 9 digits.
    The values are separated by a space.
    For example, "sender_user_id recipient_user_id amount_of_transaction".
    Users that perform an excessive amount of transactions might be abusing the service so you have been tasked
     to identify the users that have a number of transactions over a threshold. 
    The list of user ids should be ordered in ascending numeric value.
    Example:
        logs = ["88 99 200", "88 99 300", "99 32 100",  12 12 15"]
        threshold = 2
        The transactions count for each user, regardless of role are:
            ID     Transactions
            --     ------------
            99     3
            88     2
            12     1
            32     1
        There are two users with at least threshold = 2 transactions: 99 and 88.
        In ascending order, the return array is ['88', '99'].
    Note:  In the last log entry, user 12 was on both sides of the transaction.
            This counts as only 1 transaction for user 12.
    Function Description:
        Complete the function processLogs in the editor below.
        The function has the following parameter(s):
            string logs[n]: each logs[i] denotes the ith entry in the logs
            int threshold: the minimum number of transactions that a user must have to be included in the result
        Returns:
            string[]: an array of user id's as strings, sorted ascending by numeric value
    Constraints:
        1 ≤ n ≤ 10^5
        1 ≤ threshold ≤ n
        The sender_user_id, recipient_user_id and amount_of_transaction contain only characters in
         the range ascii['0'-'9'].
        The sender_user_id, recipient_user_id and amount_of_transaction start with a non-zero digit.
        0 < length of sender_user_id, recipient_user_id, amount_of_transaction ≤ 9
        The result will contain at least one element.
    Input Format Format for Custom Testing:
        Input from stdin will be processed as follows and passed to the function.
        The first line contains the integer, n, the size of logs.
        The following n lines contain a string, logs[i].
        The last line contains an integer, threshold.
    Sample Case 0:
        Sample Input:
            STDIN    Function
            -----    --------
            4      → logs[] size n = 4
            1 2 50 → logs = ["1 2 50", "1 7 70", "1 3 20", "2 2 17"]
            1 7 70
            1 3 20
            2 2 17
            2      → threshold = 2
        Sample Output:
            1
            2
        Explanation:
            ID     Transactions
            --     ------------
            1      3
            2      2
            7      1
            3      1
            Only users 1 and 2 have at least threshold = 2 transactions.
            The return array in numerically ascending order is ["1", "2"].
            Note that in the last log entry, the user with id 2 performed both roles in the transaction.
            This is counted as one transaction for the user.
    Sample Case 1:
        Sample Input:
            STDIN    Function
            -----    --------
            4      → logs[] size n = 4
            9 7 50 → logs = ["9 7 50", "22 7 20", "33 7 50", "22 7 30"]
            22 7 20
            33 7 50
            22 7 30
            3      → threshold = 3
        Sample Output:
            7
        Explanation:
            ID     Transactions
            --     ------------
            9      1
            7      4
            22     2
            33     1
            Only user 7 has 3 or more transactions.
            The return array is ["7"].)" << endl;
    }

    static vector<string> processLogs(const vector<string> &logs, int threshold) {
        vector<string> result;
        map<int, int> count;
        for (const string &log: logs) {
            auto data = parseLog(log);
            if (!count.count(data.at(0))) {
                count[data.at(0)] = 0;
            }
            count.at(data.at(0))++;
            if (data.at(0) != data.at(1)) {
                if (!count.count(data.at(1))) {
                    count[data.at(1)] = 0;
                }
                count.at(data.at(1))++;
            }
        }
        for (auto group: count) {
            if (group.second >= threshold) {
                result.push_back(to_string(group.first));
            }
        }
        return result;
    }

private:
    static vector<int> parseLog(const string &text) {
        vector<int> result;
        string line;
        stringstream ss(text);
        while (getline(ss, line, ' ')) {
            result.push_back(stoi(line));
        }
        return result;
    }

};

#pragma clang diagnostic pop