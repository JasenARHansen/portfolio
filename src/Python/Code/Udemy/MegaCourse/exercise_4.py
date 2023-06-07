#!/usr/bin/env python3

# Create a program that does the following:
# 1. Prompts the user to input the country they are from.
# 2. If the user enters the word USA, the program prints out Hello.
# 3. If the user enters the word India, the program prints out Namaste.
# 4. If the user enters the word Germany, the program prints out Hallo.
# Note: Strings are case-sensitive in Python, meaning germany and Germany are treated as two different strings.

# Set variables
user_prompt = "What country are you from?\t"
data = input(user_prompt).strip()
match data.lower():
    case "usa":
        print("Hello")
    case "india":
        print("Namaste")
    case "germany":
        print("Hallo")
    case other:
        print(f"I am sorry, I do not have a greeting for: {data}")
