#!/usr/bin/env python3

# noinspection SpellCheckingInspection,PyTypeChecker
import inspect
import os


class AmadaWeldTech(object):
    """AmadaWeldTech main class."""

    @staticmethod
    def get_description_alphabetical():
        print("""
              Coding challenge:
                 1. read in text file.
                 2. Reverse characters in lines.
                 3. Print to output file.
              Bonus 1:
                 1. read in text file.
                 2. Reverse lines in file.
                 3. Print to output file.
              Bonus 2:
                 1. read in text file.
                 2. Reverse lines in file.
                 3. Reverse characters in lines.
                 4. Print to output file.""")

    def __init__(self, input_file=None):
        if not input_file:
            # Dynamically generate a file to ./data/data.txt as a default file
            input_file = os.path.dirname(os.path.abspath(__file__))
            input_file = os.path.join(input_file, "data")
            self.input_file = os.path.join(input_file, "data.txt")
        else:
            self.input_file = os.path.abspath(input_file)
        # If the data file does not exist, create one
        if not os.path.exists(self.input_file):
            # Generate output file
            output = open(self.input_file, 'w+')
            output.write(f"File did not exist!!!\n")
            output.write(f"Making default data.\n")
            output.close()
        # Opening file to get the data
        self.lines = None
        with open(self.input_file) as file:
            self.lines = [line.rstrip() for line in file]

    def reverse_lines(self):
        # Generate output file name
        output_file = self.generate_output_name(method=inspect.stack()[0][3])
        # reverse order of lines
        self.reverse_line_order()
        # Generate output file
        self.generate_output_file(output_file)

    def reverse_character(self):
        # Generate output file name
        output_file = self.generate_output_name(method=inspect.stack()[0][3])
        # Edit data to reverse characters in place
        self.reverse_character_order()
        # Generate output file
        self.generate_output_file(output_file)

    def reverse_both(self):
        # Generate output file name
        output_file = self.generate_output_name(method=inspect.stack()[0][3])
        # reverse order of lines
        self.reverse_line_order()
        # Edit data to reverse characters in place
        self.reverse_character_order()
        # Generate output file
        self.generate_output_file(output_file)

    def generate_output_name(self, method=""):
        # Generate output file name
        output_file = os.path.splitext(self.input_file)[0] + "_" + method + \
                      os.path.splitext(self.input_file)[1]
        return output_file

    def generate_output_file(self, output_file):
        # Remove file if it exists
        if os.path.exists(output_file):
            os.remove(output_file)
        # Generate output file
        output = open(output_file, 'w+')
        for line in self.lines:
            output.write(f"{line}\n")
        output.close()

    def reverse_line_order(self):
        # reverse order of lines
        new_lines = []
        for line in self.lines:
            new_lines.insert(0, line)
        self.lines = new_lines

    def reverse_character_order(self):
        # In each line, reverse order of characters
        for index in range(len(self.lines)):
            new_line = ""
            # Reverse the characters in a line
            for character in self.lines[index]:
                new_line = character + new_line
            self.lines[index] = new_line