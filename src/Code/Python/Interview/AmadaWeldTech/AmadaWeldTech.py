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

    def __init__(self, input_file=None, mode=0):
        """Create base class and initialize.
        """
        # If no input file is inputted use a default location and name
        if not input_file:
            # Dynamically generate a file to ./data/data.txt as a default file
            input_file = os.path.dirname(os.path.abspath(__file__))
            input_file = os.path.join(input_file, "data")
            self.input_file = os.path.join(input_file, "data.txt")
        else:
            self.input_file = os.path.abspath(input_file)
        # Check whether the specified path exists or not. If not, create it
        if not os.path.exists(os.path.dirname(self.input_file)):
            # Create a new directory because it does not exist
            os.makedirs(os.path.dirname(self.input_file))
        # If the data file does not exist, create one
        if not os.path.exists(self.input_file):
            # Generate default data file
            default_data = ["1. File did not exist!!!", "2. Making default data."]
            output = open(self.input_file, 'w+')
            for data in default_data:
                output.write(f"{data}\n")
            output.close()
        # Opening file to get the data
        self.lines = None
        with open(self.input_file) as file:
            self.lines = [line.rstrip() for line in file]
        # Since this is for fun I am doing a bit of over engineering.  I will allow for multiple ways of achieving
        # the same result, controlled by the mode value
        self.mode = mode

    def reverse_lines(self):
        """External call to reverse lines of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(method=inspect.stack()[0][3])
        # Reverse order of lines
        self._reverse_line_order()
        # Generate output file
        self._generate_output_file(output_file)

    def reverse_characters(self):
        """External call to reverse characters of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(method=inspect.stack()[0][3])
        # Edit data to reverse characters in place
        self._reverse_character_order()
        # Generate output file
        self._generate_output_file(output_file)

    def reverse_characters_lines(self):
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
        # Generate output file name based on the calling method
        # Mode 0: Uses memory to store the resulting data until the original data can be replaced
        if self.mode == 0:
            mode = "memory"
        # Mode 1: Uses the processor to edit in place as much as the language allows.
        elif self.mode == 1:
            mode = "processor"
        # Undefined mode value
        else:
            mode = "undefined"
        output_file = f"{os.path.splitext(self.input_file)[0]}_{method}_{mode}{os.path.splitext(self.input_file)[1]}"
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
        # Mode 0: Uses memory to store the resulting data until the original data can be replaced
        if self.mode == 0:
            new_lines = []
            for line in self.lines:
                new_lines.insert(0, line)
            self.lines = new_lines
        # Mode 1: Uses the processor and alters the data in place
        elif self.mode == 1:
            for index in range(int(len(self.lines) / 2)):
                swap = self.lines[index]
                self.lines[index] = self.lines[len(self.lines) - index - 1]
                self.lines[len(self.lines) - index - 1] = swap
        # Undefined mode, do nothing
        else:
            self.lines.insert(0, "Undefined line processing method, doing nothing to line order.")

    def _reverse_character_order(self):
        """Internal call to generate reverse character order in data.
        """
        # In each line, reverse order of characters
        # Mode 0: Uses memory and Constructs a new string character by character
        if self.mode == 0:
            for index in range(len(self.lines)):
                new_line = ""
                # Reverse the characters in a line
                for character in self.lines[index]:
                    new_line = character + new_line
                self.lines[index] = new_line
        # Mode 1: Uses the processor to edit in place as much as the language allows
        elif self.mode == 1:
            for index in range(len(self.lines)):
                # Reverse the characters in a line
                edit_list = list(self.lines[index])
                for character_index in range(int(len(edit_list) / 2)):
                    edit_list[character_index], edit_list[len(edit_list) - character_index - 1] = \
                        edit_list[len(edit_list) - character_index - 1], edit_list[character_index]
                self.lines[index] = ''.join(edit_list)
        # Undefined mode, do nothing
        else:
            self.lines.insert(0, "Undefined character processing method, doing nothing to character order.")
