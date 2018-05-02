# !python3
# -*- coding: utf-8 -*-
"""

"""

class Solution1:
    def twoSum(self, nums, target):
        nums = enumerate(nums)
        nums = sorted(nums, key=lambda x: x[1])
        l, r = 0, len(nums) - 1
        while l < r:
            #print(nums[l], nums[l][0], nums[l][1])
            if nums[l][1] + nums[r][1] == target:
                return sorted([nums[l][0] , nums[r][0] ])
            elif nums[l][1] + nums[r][1] < target:
                l += 1
            else:
                r -= 1

class Solution2:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums == None or len(nums) == 0:
            return None
        else:
            index = 0
            while( index < len(nums)):
                #print("index, " + str(index) + " , nums[index]= "+ str(nums[index]))
                value2 = target - nums[index]
                try:
                    # value of target - nums[index]   also in List nums
                    if index == nums.index(value2):
                        index = index + 1
                    else:
                        if index > nums.index(value2):
                            index1 = nums.index(value2)
                            index2 = index
                        else:
                            index1 = index
                            index2 = nums.index(value2)
                        return [index1, index2]

                except ValueError:
                    index = index + 1;
            return None

# dictionary
class Solution3:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dic = {}
        for i, num in enumerate(nums):
            if target - num in dic:
                return (dic[target - num] , i )
            dic[num] = i