#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'Xi Cheng'

'''
leetcode problems from https://leetcode.com/problems/
'''


'''
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
'''
class Solution:
    # @return a list of lists of integers

    def generate(self, numRows):
    	self.numRows = numRows
    	n = 1
    	for n < self.numRows:
    		print "["
    	return None

if __name__=='__main__':
    x=Solution()
    x.generate(5)