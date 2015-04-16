#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'Byron Cheng'

class Solution:
    # @param a list of integers
    # @return an integer

    def removeDuplicates(self, A):
        self.A = []
        self.A = A
        self.listA = list(self.A)
        self.setA = set(A)
        #self.dictA =dict(A)
        self.tupleA = tuple(self.A)
        self.removeDuplicatesA = list(self.setA)

        #print( "self.A: ", self.A)
        print(self.A)
        print(self.listA)
        print self.setA
        print self.tupleA
        print self.removeDuplicatesA
        #print "self.listA: ", self.listA
        #print "self.setA: ", self.setA 
        #print(self.setA)
        #print "self.tupleA: ", self.tupleA
        #print(self.tupleA) 
        #print "self.removeDuplicatesA: ", self.removeDuplicatesA 
        #print(self.removeDuplicatesA)
        #return (self.setA)
        #return (self.removeDuplicatesA)
        return self.removeDuplicatesA

A=[1,2,3,2,3,2]
x=Solution()
print x.removeDuplicates(A)