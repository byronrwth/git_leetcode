import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/

import CtCILibrary.AssortedMethods;

public class crack_1_4_char_array {
    

    public crack_1_4_char_array() {
    }

    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        
        if (length == 0 || string == null ) 
            return 0;
            
        int spaceCount = 0, index, i, true_length = 0;
        
        for (i = 0; i < length; i++) {
            if (string[i] == ' ') {
                spaceCount++;
            }
        }
        
        index = length + spaceCount * 2;
        
        true_length = index;
        
        //string[index] = '\0';
        /*
?
java.lang.ArrayIndexOutOfBoundsException: 25
    at crack_1_4_char_array.replaceBlank(crack_1_4_char_array.java:44)
    at crack_1_4_char_array.main(crack_1_4_char_array.java:77)

        */
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
        
        return true_length;
    }




    public static void main(String[] args) {

        crack_1_4_char_array example = new crack_1_4_char_array();

        String str = "asdfas s asdf sds ";

        char[] arr = new char[str.length() + 3 * 2 + 1];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);

            System.out.println("char array arr["+i+"]:"+arr[i]); 
        }

        System.out.println("char array length: "+str.length());

        example.replaceBlank(arr, str.length());   

        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
    }



}