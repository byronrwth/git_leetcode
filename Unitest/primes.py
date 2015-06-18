#!/usr/bin/env python
# -*- coding: utf-8 -*-
def is_prime(number):
    

    for element in range(number):
        if number % element == 0:
            return False
 
    return True
 
def print_next_prime(number):
  
    index = number
    while True:
        index += 1
        if is_prime(index):
            print(index)


