#!/usr/bin/env python3

"""
Coding Exercise 1

In the coding area, we have defined a country variable.
You should write a match-case block that checks the value of the country variable and:
Prints out Hello if the value of country is "USA".
Prints out Namaste if the value of country is "India".
Prints out Hallo if the value of country is "Germany".
"""

# Set variables
country = "india"

# Print greeting
match country.lower():
    case "usa":
        print("Hello")
    case "india":
        print("Namaste")
    case "germany":
        print("Hallo")
    case other:
        print(f"I am sorry, I do not have a greeting for: {country}")
