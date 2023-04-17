#!/usr/bin/env python3
import os


# noinspection SpellCheckingInspection,PyTypeChecker
class Chalenge(object):
    """Epiris main class."""

    @staticmethod
    def get_description_alphabetical():
        print("""
              Coding challenge:
                 1. read in text file.
                 2. Reverse characters in line.
                 3. Print to output file.""")

    def __init__(self,
                 input_file="C:\\Users\\jasen\\IdeaProjects\\portfolio\\src\\Code\\Python\\Interview\\AmadaWeldTech\\data\\data.txt"):
        self.input_file = input_file
        self.lines = None

    def read_file(self):
        # Using readlines()
        self.lines = open(self.input_file, 'r')

    def reverse_lines(self,
                      output_file="C:\\Users\\jasen\\IdeaProjects\\portfolio\\src\\Code\\Python\\Interview\\AmadaWeldTech\\data\\line_reverse.txt"):
        # Remove file if it exists
        if os.path.exists(output_file):
            os.remove(output_file)
        # Generate output file
        output = open(output_file, 'w+')
        new_lines = []
        for line in self.lines:
            new_lines.insert(0, line.strip())
        for line in new_lines:
            output.write(f"{line}\n")
        output.close()

    def reverse_character(self,
                          output_file="C:\\Users\\jasen\\IdeaProjects\\portfolio\\src\\Code\\Python\\Interview\\AmadaWeldTech\\data\\character_reverse.txt"):
        # Remove file if it exists
        if os.path.exists(output_file):
            os.remove(output_file)
        # Generate output file
        output = open(output_file, 'w+')
        for line in self.lines:
            new_line = ""
            # Reverse the characters in a line
            for character in line.strip():
                new_line = character + new_line
            output.write(f"{new_line}\n")
        output.close()
