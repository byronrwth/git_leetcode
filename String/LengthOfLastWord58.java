package String;

public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        
        if (str.length == 0) return 0;
        else 
        	return str[str.length-1].length() ;
    }
}
