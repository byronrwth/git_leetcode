package enumeration;

/**
 * Created by xicheng on 16/10/3.
 *
 *
 * Find the Nth number in Fibonacci sequence.

 A Fibonacci sequence is defined as follow:

 The first two numbers are 0 and 1.
 The i th number is the sum of i-1 th number and i-2 th number.
 The first ten numbers in Fibonacci sequence is:

 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

 Notice

 The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.

 Have you met this question in a real interview? Yes
 Example
 Given 1, return 0

 Given 2, return 1

 Given 10, return 34


 Note: if recursion then time limit will be exceeded, therefore try use only 2 variables for f(n-1) and f(n-2), then f(n) can be directly calculated  //array to store each f(n), sacrifice space for better time performance

 */
public class Fibonacci {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */

    public int fibonacci(int n) {
        int n1 = 0, n2 = 1;

        if (n<=0) {
            return -1;
        }
        for ( int i=0; i< n-1; i++) {
            int c = n1 + n2;
            n1 = n2;
            n2 = c;
        }
        return n1;
    }
}
