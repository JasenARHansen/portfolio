#!/usr/bin/env python3

"""
Coding Exercise 2

Create a program that prompts the user to input their name once. Then, the program prints
 out the name once with the first letter capitalized.
"""

# Set variables
user_prompt = "Enter your name:\t"
text = ""
# Populate name
name = input(user_prompt).lower()

# Print name
print(f"{name.capitalize()}")
