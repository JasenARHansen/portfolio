#include "Section3Functions.h"

string Section3Functions::menuSelection(const int selection) {
    switch (selection) {
        case 1:
            return "Adding a record.";
        case 2:
            return "Deleting a record.";
        case 3:
            return "Viewing a record.";
        case 4:
            return "Searching a record.";
        case 5:
            return "Quiting.";
        default:
            return "Invalid option, quitting.";
    }
}
