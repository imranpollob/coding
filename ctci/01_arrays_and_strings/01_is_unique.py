"""
Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures?

You should first ask your interviewer if the string is an ASCII string or a Unicode string. Asking this question 
will show an eye for detail and a solid foundation in computer science. We'll assume for simplicity the character set is ASCII. 
If this assumption is not val id, we wou ld need to increase the storage size.

One solution is to create an array of boolean values, where the flag at index i indicates whether character 
i in the alphabet is contained in the string. The second time you see this character you can immediately 
return false.

We can also immediately return false if the string length exceeds the number of unique characters in the 
alphabet. After all, you can't form a string of 280 unique characters out of a 1 28-character alphabet.

It's also okay to assume 256 characters. This would be the case in extended ASCII. You should 
clarify your assumptions with your interviewer.

ASCII uses 7 bits and provides 128 characters, Extended ASCII uses 8 bits and extends the character set to 256, 
accommodating a broader range of characters and symbols for various language and application requirements.
"""
import time
import unittest
from collections import defaultdict


# time: O(n) space: O(1)
def is_unique_chars_algorithmic(string):
    # assuming character set is ASCII (128 characters)
    # if string length is more that 128, immediately return false
    if len(string) > 128:
        return False

    # this is a pythonic and faster way to initialize an array with a fixed value.
    # careful though it won't work for a doubly nested array
    # using fixed size array, so the space complexity is O(1)
    bool_map = [False] * 128

    for i in string:
        ascii_value = ord(i)

        # Char already found in string
        if bool_map[ascii_value]:
            return False
        else:
            bool_map[ascii_value] = True

    return True


# time: O(n) space: O(n)
def is_unique_chars_pythonic(string):
    return len(string) == len(set(string))


# time: O(n) space: O(n)
def is_unique_chars_using_dictionary(string):
    bool_map = {}

    for i in string:
        if i in bool_map:
            return False
        bool_map[i] = True

    return True


# time: O(n) space: O(n)
def is_unique_chars_using_set(string):
    bool_map = set()

    for i in string:
        if i in bool_map:
            return False
        bool_map.add(i)

    return True


# time: O(n) space: O(n)
def is_unique_chars_sorting(string):
    sorted_string = sorted(string)
    last_char = None

    for i in sorted_string:
        if i == last_char:
            return False

        last_char = i

    return True


# time: O(nlogn) space: O(1)
# pros: doesn't use extra space
# con: modifies input string
def is_unique_chars_sort(string):
    string = sorted(string)

    for i in range(len(string) - 1):
        if string[i] == string[i + 1]:
            return False

    return True


class Test(unittest.TestCase):
    test_cases = [
        ("abcd", True),
        ("s4fad", True),
        ("", True),
        ("23ds2", False),
        ("hb 627jh=j ()", False),
        ("".join([chr(val) for val in range(128)]), True),  # unique 128 chars
        ("".join([chr(val // 2) for val in range(129)]), False),  # non-unique 129 chars
    ]
    test_functions = [
        is_unique_chars_algorithmic,
        is_unique_chars_pythonic,
        # is_unique_bit_vector,
        is_unique_chars_using_dictionary,
        is_unique_chars_using_set,
        is_unique_chars_sorting,
        is_unique_chars_sort,
    ]

    def test_is_unique_chars(self):
        num_runs = 1000
        function_runtimes = defaultdict(float)

        for _ in range(num_runs):
            for text, expected in self.test_cases:
                for is_unique_chars in self.test_functions:
                    start = time.perf_counter()
                    assert (
                        is_unique_chars(text) == expected
                    ), f"{is_unique_chars.__name__} failed for value: {text}"
                    function_runtimes[is_unique_chars.__name__] += (
                        time.perf_counter() - start
                    ) * 1000

        print(f"\n{num_runs} runs")
        for function_name, runtime in function_runtimes.items():
            print(f"{function_name}: {runtime:.1f}ms")


if __name__ == "__main__":
    unittest.main()
