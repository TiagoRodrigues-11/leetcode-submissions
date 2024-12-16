class Solution:
    def letterCombinations(self, digits: str) -> List[str]:

        digitsToLetters = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }

        combinations = []

        for digit in digits:
            if len(combinations) == 0:
                for letter in digitsToLetters[digit]:
                    combinations.append(letter)
                continue
            
            combinationLength = len(combinations)
            for index in range(combinationLength):
                for letter in digitsToLetters[digit]:
                    combinations.append(combinations[index] + letter)
        
        finalCombinations = [ ]
        for combination in combinations:
            if len(combination) == len(digits):
                finalCombinations.append(combination)

        return finalCombinations