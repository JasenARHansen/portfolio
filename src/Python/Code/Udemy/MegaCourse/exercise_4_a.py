#!/usr/bin/env python3

# Create a program that prompts the user to input their name repeatedly.
# Then, the program repeatedly prints out the name with the first letter capitalized.

# Set variables
user_prompt = "Enter an action option: 1. add, 2. remove, 3. display, 4. exit:\t"
action_prompt = "Enter an action for the list:\t"
remove_prompt = "Element to remove:\t"

action_list = []
# Print name
while True:
    # Populate action
    action = input(user_prompt).strip().lower()
    match action:
        case "1" | "add":
            action = input(action_prompt).lower()
            action_list.append(action)
        case "2" | "remove":
            data = input(remove_prompt).strip()
            if data in action_list:
                action_list.remove(data)
            elif data.isdigit():
                index = int(data)
                if 0 <= index < len(action_list):
                    action_list.pop(index - 1)
            else:
                print(f"Invalid selection: {data}")
        case "3" | "display":
            for number in range(len(action_list)):
                print(f"{number + 1}: {action_list[number].title()}")
        case "4" | "exit":
            print("Good bye")
            break
        case other:
            print(f"Invalid option: {other}")
