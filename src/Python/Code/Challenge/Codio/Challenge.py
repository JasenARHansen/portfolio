class Challenge(object):
    @staticmethod
    def get_description() -> None:
        print("""Challenge 1 - Magic Number (easy)

              Allow a user to enter any number, then double this number,
               add 9 to the result, subtract 3 from the result, then divide by 2,
               finally subtract the number the user entered at the beginning.
              The answer should always be 3.

              https://www.codio.com/blog/five-python-coding-challenges-for-you-and-your-students
              """)

    @staticmethod
    def magic_number(number: int) -> int:
        result = number * 2
        result += 9
        result -= 3 # The above could be combined, but I am following the instrution
        result /= 2
        result -= number
        return result

