#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cstdio>
#include <string>
#include <filesystem>
#include <vector>
#include <sstream> // Required for std::stringstream
#include <format> // For std::format

using namespace std;
namespace fs = std::filesystem;

class Rename {
public:
    static void description() {
        cout << R"(Rename files in directory)" << endl;
    }

    static string new_name(const std::string &original_name) {
        std::vector<std::string> tokens;
        std::string token;
        std::stringstream ss(original_name);
        // Extract tokens separated by whitespace
        while (ss >> token) {
            tokens.push_back(token);
        }
        auto base =  tokens.at(0);
        auto start =  stoi(tokens.at(1));
        auto working =  tokens.at(4);
        std::istringstream tokenEnd(working);
        char delimiter = '_';
        tokens.clear();
        // Read tokens from the stream until the delimiter is encountered
        while (std::getline(tokenEnd, token, delimiter)) {
            tokens.push_back(token);
        }
        working =  tokens.at(2);
        std::istringstream tokenOffset(working);
        delimiter = '.';
        tokens.clear();
        // Read tokens from the stream until the delimiter is encountered
        while (std::getline(tokenOffset, token, delimiter)) {
            tokens.push_back(token);
        }
        auto stop =  stoi(tokens.at(0));
        auto extension =  tokens.at(1);
        return base + " " + to_string(start +  stop - 1) + "." + extension;
    };

    static void files(const std::string &path)
    {
        const std::string extension{ ".html" };
        // iterate through all the files in the directory
        for (const auto& file : std::filesystem::directory_iterator(path))
        {
            if (std::filesystem::is_regular_file(file))
            {
                const std::string currentFileName{file.path().filename().string() };
                if (currentFileName.find('-') != std::string::npos) {
                const std::string newFileName{ new_name(currentFileName) };
                try
                {
                    std::filesystem::rename(path + "\\" + currentFileName, path + "\\" + newFileName);
                }
                catch (std::filesystem::filesystem_error const& error)  // catch the errors(if any)!
                {
                    std::cout << error.code() << "\n" << error.what() << "\n";
                }
            }}
        }
    }

};

#pragma clang diagnostic pop