#!/usr/bin/env python3

# Set variables
user_prompt = "Enter a ToDo (type exit to stop):\t"
todo_list = []
text = ""
# Populate list
while True:
    text = input(user_prompt)
    if text.lower() == "exit":
        break
    todo_list.append(text)
# Print list
for number in range(len(todo_list)):
    print(f"{number + 1}: {todo_list[number]}")
