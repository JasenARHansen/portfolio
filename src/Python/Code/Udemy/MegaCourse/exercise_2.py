#!/usr/bin/env python3

# Create a program that prompts the user to input their name once.
# Then, the program repeatedly prints out the name with the first letter capitalized.

# Set variables
user_prompt = "Enter your name:\t"
# Populate name
name = input(user_prompt).lower()
user_prompt = "How many times should I print:\t"
# Populate count
count = int(input(user_prompt))

# Print name
while True:
    if count <= 0:
        break
    print(f"Name # {count}: {name.capitalize()}")
    count -= 1
