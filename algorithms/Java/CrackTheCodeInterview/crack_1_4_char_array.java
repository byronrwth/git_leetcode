import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/

import CtCILibrary.AssortedMethods;

public class crack_1_4_char_array {

    final static int ttime = 30000;//

    public crack_1_4_char_array() {
    }

    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     * Write a method to replace all spaces in a string with %20. The string is given in a characters array, you can assume it has enough space for * replacement and you are given the true length of the string.
     *
     *   true length  means   not counting '\0'  !! 
     */
    public int replaceBlank(char[] string, int length) {

        long begin = System.currentTimeMillis();
        int k = 0 ;
        int spaceCount = 0, index, i, true_length = 0;

        while ( k < ttime) {


            if (length == 0 || string == null ) 
                return 0;

            
            for (i = 0; i < length; i++) {
                if (string[i] == ' ') {
                    spaceCount++;
                }
            }
            
            index = length + spaceCount * 2;  //true length
            
            true_length = index;
            
            // the last character in char array should be '\0',  thoug        
            string[index] = '\0';

            for (i = length - 1; i >= 0; i--) {
                if (string[i] == ' ') {
                    string[index - 1] = '0';
                    string[index - 2] = '2';
                    string[index - 3] = '%';
                    index = index - 3;
                } 
                else {
                    string[index - 1] = string[i];
                    index--;
                }
            }

            k++ ;
        }

        long over = System.currentTimeMillis();

        System.out.println(" String operations " + string.getClass().getName() + " cost time: " + (over - begin) + " m seconds ");

        return true_length;
    }

    public StringBuffer replaceBlankStringBuffer(String input)
    {

        long begin = System.currentTimeMillis();
        int k = 0 ;

        if(input==null)
            return null;

        StringBuffer outputBuffer=new StringBuffer();

        while ( k < ttime) {

            for(int i=0;i<input.length();i++)
            {
                if(input.charAt(i)==' ')
                {
                    outputBuffer.append("%");
                    outputBuffer.append("2");
                    outputBuffer.append("0");
                }
                else {
                    outputBuffer.append(String.valueOf(input.charAt(i)));
                }
            }

        }

        long over = System.currentTimeMillis();

        System.out.println(" String Buffer operations " + input.getClass().getName() + " cost time: " + (over - begin) + " m seconds ");

        return new StringBuffer(outputBuffer);
    }

    public StringBuilder replaceBlankStringBuilder(String input)
    {
        long begin = System.currentTimeMillis();
        int k = 0 ;

        if(input==null)
            return null;

        StringBuilder outputBuilder= new StringBuilder();
        while ( k < ttime) {

            for(int i=0;i<input.length();i++)
            {
                if(input.charAt(i)==' ')
                {
                    outputBuilder.append("%");
                    outputBuilder.append("2");
                    outputBuilder.append("0");
                }
                else {
                    outputBuilder.append(String.valueOf(input.charAt(i)));
                }
            }
        }

        long over = System.currentTimeMillis();

        System.out.println(" String Builder operations " + input.getClass().getName() + " cost time: " + (over - begin) + " m seconds ");


        return new StringBuilder(outputBuilder);
    }


    public static void main(String[] args) {

        // test 1: space in head, space in tail, space in middle, continous spaces 
        //String str = " asdfas s   asdf sds "; // 7 spaces !
        //char[] arr = new char[str.length() + 7 * 2 + 1]; // 5 sspace and if '\0' +1

        // test 2: no space
        //String str = "asdfa" ;
        //char[] arr = new char[str.length() + 1];

        // test 3: str pointer is null,  or 1 space, or continous spaces only
        String str = "   " ;
        char[] arr = new char[str.length() + 3*2 +1];

        crack_1_4_char_array example = new crack_1_4_char_array();


        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);

            //System.out.println("char array arr["+i+"]:"+arr[i]); 
        }

        //System.out.println("char array length: "+str.length());  //true length, no '\0'

        example.replaceBlank(arr, str.length());   

        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");


        StringBuffer outStringBuffer = example.replaceBlankStringBuffer(str);  

        System.out.println("\"" + outStringBuffer + "\"");

        StringBuilder outStringBuilder = example.replaceBlankStringBuilder(str);  

        System.out.println("\"" + outStringBuilder + "\"");

    }



}