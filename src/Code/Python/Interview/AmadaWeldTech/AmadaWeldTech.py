#!/usr/bin/env python3

# noinspection SpellCheckingInspection,PyTypeChecker
import inspect
import os


class AmadaWeldTech(object):
    """AmadaWeldTech main class."""

    @staticmethod
    def get_description():
        print("""
              Coding challenge:
                 1. Read in text file.
                 2. Reverse characters in lines.
                 3. Print to output file.
              Bonus 1:
                 1. Read in text file.
                 2. Reverse lines in file.
                 3. Print to output file.
              Bonus 2:
                 1. Read in text file.
                 2. Reverse lines in file.
                 3. Reverse characters in lines.
                 4. Print to output file.""")

    def __init__(self, input_file=None):
        """Create base class and initialize.
        """
        if not input_file:
            # Dynamically generate a file to ./data/data.txt as a default file
            input_file = os.path.dirname(os.path.abspath(__file__))
            input_file = os.path.join(input_file, "data")
            self.input_file = os.path.join(input_file, "data.txt")
        else:
            self.input_file = os.path.abspath(input_file)
        # Check whether the specified path exists or not. if not, create it
        if not os.path.exists(os.path.dirname(self.input_file)):
            # Create a new directory because it does not exist
            os.makedirs(os.path.dirname(self.input_file))
        # If the data file does not exist, create one
        if not os.path.exists(self.input_file):
            # Generate default data file
            default_data = ["File did not exist!!!", "Making default data."]
            output = open(self.input_file, 'w+')
            for data in default_data:
                output.write(f"{data}\n")
            output.close()
        # Opening file to get the data
        self.lines = None
        with open(self.input_file) as file:
            self.lines = [line.rstrip() for line in file]

    def reverse_lines(self):
        """External call to reverse lines of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(method=inspect.stack()[0][3])
        # Reverse order of lines
        self._reverse_line_order()
        # Generate output file
        self._generate_output_file(output_file)

    def reverse_character(self):
        """External call to reverse characters of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(method=inspect.stack()[0][3])
        # Edit data to reverse characters in place
        self._reverse_character_order()
        # Generate output file
        self._generate_output_file(output_file)

    def reverse_both(self):
        """External call to reverse both lines and characters of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(method=inspect.stack()[0][3])
        # Reverse order of lines
        self._reverse_line_order()
        # Edit data to reverse characters in place
        self._reverse_character_order()
        # Generate output file
        self._generate_output_file(output_file)

    def _generate_output_name(self, method=""):
        """Internal call to dynamically generate name of output file.
        """
        # Generate output file name
        output_file = f"{os.path.splitext(self.input_file)[0]}_{method}{os.path.splitext(self.input_file)[1]}"
        return output_file

    def _generate_output_file(self, output_file):
        """Internal call to generate output file.
        """
        # Remove file if it exists
        if os.path.exists(output_file):
            os.remove(output_file)
        # Generate output file
        output = open(output_file, 'w+')
        for line in self.lines:
            output.write(f"{line}\n")
        output.close()

    def _reverse_line_order(self):
        """Internal call to generate reverse line order in data.
        """
        # Reverse order of lines
        new_lines = []
        for line in self.lines:
            new_lines.insert(0, line)
        self.lines = new_lines

    def _reverse_character_order(self):
        """Internal call to generate reverse character order in data.
        """
        # In each line, reverse order of characters
        for index in range(len(self.lines)):
            new_line = ""
            # Reverse the characters in a line
            for character in self.lines[index]:
                new_line = character + new_line
            self.lines[index] = new_line
