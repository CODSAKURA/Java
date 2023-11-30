package reverseword5;

public class R2 {
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        System.out.println(len);
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];
        
        // put original string in an array of chars
        palindrome.getChars(0, len, tempCharArray, 0);
        
        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] =
                tempCharArray[len - 1 - j];
            System.out.println(charArray[j]);
        }
        
        String reversePalindrome = new String(charArray);
        System.out.println(reversePalindrome);
    }
    
    //To accomplish the string reversal, the program had to convert the string to an array of characters (first for loop), reverse the array into a second array (second for loop), and then convert back to a string. 
}

