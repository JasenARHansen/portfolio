#!/usr/bin/env python3

"""
Note: Please code this exercise on your computer IDE.
Coding Exercise 3

Create a program that prompts the user to input their name repeatedly.
 Then, the program repeatedly prints out the name with the first letter capitalized.

In other words, the program should behave as in the screenshot below:

"""

# Set variables
user_prompt = "Enter your name:\t"
text = ""

# Print name
for name in range(10):
    # Populate name
    name = input(user_prompt).lower()
    print(f"{name.capitalize()}")
