package Lecture_practice_problems_kunal_kushwaha._58_Karp_rabin;

public class KarpRabin {
    private final int PRIME = 101;

    private double calculateHash(String str){
        double hash = 0;
        for(int i = 0; i < str.length(); i++){
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    // Why divide by prime while removing a character
    /*
        When sliding the window:
        Suppose:
		"abc" → "bcd"

		Old hash:
		hash = a * p^0 + b * p^1 + c * p^2

		Step 1: Remove 'a'
		hash - a

		Now you have:
		b * p^1 + c * p^2

		Step 2: Shift powers down

		But now powers are wrong:
		b should be at p^0, not p^1

		So divide by p:

		(b * p^1 + c * p^2) / p
		= b * p^0 + c * p^1

		👉 This is why / PRIME is needed
     */
    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength){
        double newHash = (prevHash - oldChar) / PRIME;
        newHash += (newChar * Math.pow(PRIME, patternLength - 1));
        return newHash;
    }

    public void search(String text, String pattern){

        int patternLength = pattern.length();
        double textHash = calculateHash(text.substring(0, patternLength));
        double patternHash = calculateHash(pattern);


        for(int i = 0; i <= text.length() - patternLength; i++){
            String str = text.substring(i, i + patternLength);
            if(textHash == patternHash){
                if(str.equals(pattern)){
                    System.out.println("Found pattern at index : " + i);
                    return;
                }
            }
            // we need the next character so we can't go till the last available index so we need to stop one index before
            if(i < text.length() - patternLength) textHash =  updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
        }
        System.out.println("Pattern not found");
    }
}
