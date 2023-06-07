#!/usr/bin/env python3

# Create a program that prompts the user to input their name repeatedly.
# Then, the program repeatedly prints out the name with the first letter capitalized.

# Set variables
user_prompt = "Enter your name (type exit to stop):\t"

# Print name
while True:
    # Populate name
    name = input(user_prompt).lower()
    if name == "exit":
        break
    print(f"Name typed: {name.capitalize()}")
