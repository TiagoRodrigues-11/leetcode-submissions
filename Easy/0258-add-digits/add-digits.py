class Solution:
    def addDigits(self, num: int) -> int:

        while (num >= 10):
            log10 = int(math.log10(num))
            digit = num // pow(10, log10)

            num = (num % pow(10, log10)) + digit

        return num
        