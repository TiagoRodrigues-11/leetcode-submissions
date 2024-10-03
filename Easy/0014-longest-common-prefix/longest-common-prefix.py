class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        res = ""
        min_size = min(map(len, strs))

        for i in range(len(strs[0])):
            if i == min_size:
                return res

            char = strs[0][i]

            for str_ in strs:
                if char != str_[i]:
                    return res

            res += char


        return res