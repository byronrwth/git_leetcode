public class crack_1_4{

    public static String replaceSpaces (String str) {
        int len = str.length();
        char a[] = str.toCharArray();
        for(int i = len - 1; i >= 0; i--) {
            if(a[i] == ' '){
                a[i] = 0;
            }
            else
                break;
        }
        String str2 = new String(a);
        return str2.replaceAll(" ", "%20").trim();
    }
        
    public static void main(String args[]) {
        String s1 = "Mr John Smith    ";
        System.out.println(replaceSpaces(s1));
    }
}