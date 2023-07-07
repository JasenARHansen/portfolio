#!/usr/bin/env python3

"""
Note: Please code this exercise in your IDE on your computer since it
 involves a while-loop which the Udemy exercise IDE cannot handle.
 Once you have coded your solution, compare it with the solution in
 the link down at the bottom.

Coding Exercise 2
Create a program that prompts the user to input their name once. Then,
 the program repeatedly prints out the name with the first letter capitalized.
"""

# Set variables
user_prompt = "Enter your name:\t"
text = ""
# Populate name
name = input(user_prompt).lower()

# Print name
for name in range(10):
    print(f"{name.capitalize()}")
