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


      for n in range(numRows):
        print "[ %d ", %(n+1), "]"
        n += 1


'''


class Solution:
    # @return a list of lists of integers
    dict = []
    n = 0

    def generate(self, numRows):
        self.numRows = numRows
        self.dict = [1]
        
        #print "numRows: %d" % self.numRows
        #print self.dict

        for n in range(numRows):
            self.dict
            print "[ %s ]" % self.dict
            n += 1
        
        return self.dict

    print "static n: %d" %n
    print "static dict: %s" %dict

if __name__=='__main__':
    x=Solution()
    x.generate(5)