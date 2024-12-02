class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        index = len(digits)-1

        while(index >= 0):
            digits[index] += 1

            if digits[index] < 10:
                break
            
            digits[index] = 0
            index -= 1

        if (index == -1):
            digits.insert(0, 1)

        return digits

