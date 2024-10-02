
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        

        i1, i2 = 0, 0
        sortedMergedList = []

        while i1 < len(nums1) or i2 < len(nums2):
            if i1 == len(nums1):
                sortedMergedList.append(nums2[i2])
                i2 += 1
            elif i2 == len(nums2):
                sortedMergedList.append(nums1[i1])
                i1 += 1
            elif nums1[i1] > nums2[i2]:
                sortedMergedList.append(nums2[i2])
                i2 += 1
            elif nums1[i1] < nums2[i2]:
                sortedMergedList.append(nums1[i1])
                i1 += 1
            else:
                sortedMergedList.append(nums1[i1])
                sortedMergedList.append(nums2[i2])
                i1 += 1
                i2 += 1

        if len(sortedMergedList) % 2 == 0:
            i = len(sortedMergedList)/2
            return (sortedMergedList[i] + sortedMergedList[i-1]) / 2.0
        
        return sortedMergedList[len(sortedMergedList)/2]



