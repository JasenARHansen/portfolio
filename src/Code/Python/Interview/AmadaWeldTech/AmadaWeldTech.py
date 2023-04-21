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
              Bonus 3:
                 1. Read in text file.
                 2. Rotate characters in file.
                 3. Print to output file.
              Bonus 4:
                 1. Read in text file.
                 2. Rotate lines in file.
                 3. Print to output file.
              Bonus 5:
                 1. Read in text file.
                 2. Perform N user inputted operations on file.
                 3. Print to output file.""")

    def __init__(self, input_file=None, mode=0):
        """Create base class and initialize.
        """
        # If no input file is inputted use a default location and name
        if not input_file:
            # Dynamically generate a file to ./data/data.txt as a default file
            input_file = os.path.dirname(os.path.abspath(__file__))
            input_file = os.path.join(input_file, "../../../../Test/Python/Interview/AmadaWeldTech/data")
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
            default_data = ["1. File did not exist!!!", "2. Making default data.", "3. Giving enough data for testing."]
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
        self._last_operation = None
        self._operation_count = 0

    def process(self, *args):
        # Generate output file base:
        base_name = inspect.stack()[0][3]
        # Process inputs in order received
        for arg in args:
            # Reverse order of lines
            if arg.lower() == "reverse lines":
                operation_suffix = "_rev_lines"
                if self._last_operation == operation_suffix:
                    self._operation_count += 1
                else:
                    if self._operation_count > 1:
                        base_name += f"_x{self._operation_count}"
                    base_name += operation_suffix
                    self._last_operation = operation_suffix
                    self._operation_count = 1
                self._reverse_line_order()
            # Reverse order of characters
            elif arg.lower() == "reverse characters":
                operation_suffix = "_rev_characters"
                if self._last_operation == operation_suffix:
                    self._operation_count += 1
                else:
                    if self._operation_count > 1:
                        base_name += f"_x{self._operation_count}"
                    base_name += operation_suffix
                    self._last_operation = operation_suffix
                    self._operation_count = 1
                self._reverse_character_order()
            elif arg.lower() == "rotate character":
                operation_suffix = "_rot_characters"
                if self._last_operation == operation_suffix:
                    self._operation_count += 1
                else:
                    if self._operation_count > 1:
                        base_name += f"_x{self._operation_count}"
                    base_name += operation_suffix
                    self._last_operation = operation_suffix
                    self._operation_count = 1
                self._rotate_character()
            elif arg.lower() == "rotate lines":
                operation_suffix = "_rot_lines"
                if self._last_operation == operation_suffix:
                    self._operation_count += 1
                else:
                    if self._operation_count > 1:
                        base_name += f"_x{self._operation_count}"
                    base_name += operation_suffix
                    self._last_operation = operation_suffix
                    self._operation_count = 1
                self._rotate_lines()
            else:
                self.lines.insert(0, f"Undefined processing method {arg}, doing nothing.")

        # Generate output file name
        output_file = self._generate_output_name(base_name=base_name)
        # Generate output file
        self._generate_output_file(output_file)

    def reverse_characters(self):
        """External call to reverse characters of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(base_name=inspect.stack()[0][3])
        # Reverse order of characters
        self._reverse_character_order()
        # Generate output file
        self._generate_output_file(output_file)

    def reverse_lines(self):
        """External call to reverse lines of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(base_name=inspect.stack()[0][3])
        # Reverse order of lines
        self._reverse_line_order()
        # Generate output file
        self._generate_output_file(output_file)

    def rotate_character(self):
        """External call to rotate characters of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(base_name=inspect.stack()[0][3])
        # Reverse order of characters
        self._rotate_character()
        # Generate output file
        self._generate_output_file(output_file)

    def rotate_lines(self):
        """External call to rotate lines of data and generate file.
        """
        # Generate output file name
        output_file = self._generate_output_name(base_name=inspect.stack()[0][3])
        # Reverse order of lines
        self._rotate_lines()
        # Generate output file
        self._generate_output_file(output_file)

    def _generate_output_name(self, base_name=""):
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
        # Catches edge case for last operation multiples
        if self._operation_count > 1:
            base_name += f"_x{self._operation_count}"
        # Generate final output file name
        output_file = f"{os.path.splitext(self.input_file)[0]}_{base_name}_{mode}{os.path.splitext(self.input_file)[1]}"
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

    def _reverse_character_order(self):
        """Internal call to reverse character order.
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
            self.lines.insert(0, "Undefined reverse processing method, doing nothing to character order.")

    def _reverse_line_order(self):
        """Internal call to reverse line order.
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
                self.lines[index], self.lines[len(self.lines) - index - 1] = \
                    self.lines[len(self.lines) - index - 1], self.lines[index]
        # Undefined mode, do nothing
        else:
            self.lines.insert(0, "Undefined reverse processing method, doing nothing to line order.")

    def _rotate_character(self):
        """Internal call to rotate character order.
        """
        # In each line, rotate characters by 1 position
        # Mode 0: Uses memory and Constructs a new string character by character
        if self.mode == 0:
            for index in range(len(self.lines)):
                if len(self.lines[index]) > 1:
                    new_line = ""
                    # Rotate the characters in a line
                    for character_index in range(1, len(self.lines[index])):
                        new_line += self.lines[index][character_index]
                    new_line += self.lines[index][0]
                    self.lines[index] = new_line
        # Mode 1: Uses the processor to edit in place as much as the language allows
        elif self.mode == 1:
            for index in range(len(self.lines)):
                if len(self.lines[index]) > 1:
                    self.lines[index] = self.lines[index][1:] + self.lines[index][:1]
        else:
            self.lines.insert(0, "Undefined rotation processing method, doing nothing to rotate characters.")

    def _rotate_lines(self):
        """Internal call to rotate line order.
        """
        # Rotate lines by 1 position
        # Mode 0: Uses memory and Constructs a new string character by character
        if self.mode == 0:
            if len(self.lines) > 1:
                new_lines = []
                for index in range(1, len(self.lines)):
                    new_lines.append(self.lines[index])
                new_lines.append(self.lines[0])
                self.lines = new_lines
        # Mode 1: Uses the processor to edit in place as much as the language allows
        elif self.mode == 1:
            if len(self.lines) > 1:
                self.lines.append(self.lines.pop(0))
        else:
            self.lines.insert(0, "Undefined rotation processing method, doing nothing to rotate lines.")
