package BitManipulation;

/**
 * Created by xicheng on 16/10/3.
 *
 *
 * Count how many 1 in binary representation of a 32-bit integer.

 Have you met this question in a real interview? Yes
 Example
 Given 32, return 1

 Given 5, return 2

 Given 1023, return 9

 */
public class Count1Binary {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int count = 0;

        if (num==0)
            return 0;
        else if (num < 0) {
            double newnum = 2147483648 + num; // 2 power 32 - num
            num = newnum;
        }

        while( num != 2 && num != 1) {


            if ( num % 2 == 1) {
                count++;
            }


            num = num /2 ;
        }
        count++;
        return count;
    }

}
