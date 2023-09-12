#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <bits/stdc++.h>

using namespace std;

class SimplifyPath {

public:

    static void description() {
        cout << R"(71. Simplify Path
    Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
    In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
    The canonical path should have the following format:
        The path starts with a single slash '/'.
        Any two directories are separated by a single slash '/'.
        The path does not end with a trailing '/'.
        The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')

    Return the simplified canonical path.

    Example 1:
        Input: path = "/home/"
        Output: "/home"
        Explanation:
            Note that there is no trailing slash after the last directory name.

    Example 2:
        Input: path = "/../"
        Output: "/"
        Explanation:
            Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

    Example 3:
        Input: path = "/home//foo/"
        Output: "/home/foo"
        Explanation:
            In the canonical path, multiple consecutive slashes are replaced by a single one.

    Constraints:
        1 ≤ path.length ≤ 3000
        path consists of English letters, digits, period '.', slash '/' or '_'.
        path is a valid absolute Unix path.)" << endl;
    }

    static string simplifyPath(string path) {
        assert (!path.empty());
        assert (path.size() <= 3000);
        string result;
        stack<string> processing;
        auto startIndex = 0;
        for (auto index = 1; index < path.size(); index++) {
            if (path.at(index) == '/') {
                if ((index - startIndex) == 1) {
                    startIndex = index;
                } else {
                    processSubstring(path, processing, startIndex, index - startIndex - 1);
                    startIndex = index;
                }
            }
        }
        if ((startIndex != path.size() - 1)) {
            processSubstring(path, processing, startIndex, (int) path.size() - startIndex - 1);
        }
        while (!processing.empty()) {
            result.insert(0, processing.top());
            result.insert(0, "/");
            processing.pop();
        }
        if (result.empty()) {
            result = "/";
        }
        return result;
    }

private:

    static void processSubstring(const string &path, stack<string> &processing, int startIndex, int length) {
        auto substring = path.substr(startIndex + 1, length);
        if (substring == ".") {
            // if string is '.' do nothing
        } else if (substring == "..") {
            // if string is '..' pop 1 item on stack
            if (!processing.empty()) {
                processing.pop();
            }
        } else {
            // else push substring to stack
            processing.push(substring);
        }
    }
};

#pragma clang diagnostic pop