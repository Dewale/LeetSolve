class Solution {
    public boolean isPalindrome(String s) {
        
        int leftPtr = 0;
        int rightPtr = s.length() - 1;
        
        while (leftPtr < rightPtr) {
            char currentChar = s.charAt(leftPtr);
            char mirrorChar = s.charAt(rightPtr);
            
            if (!Character.isLetterOrDigit(currentChar)) {
                leftPtr++;
                continue;
            }
            
            if (!Character.isLetterOrDigit(mirrorChar)) {
                rightPtr--;
                continue;
            }
            
            if (Character.toLowerCase(currentChar) != Character.toLowerCase(mirrorChar)) {
                return false;
            } 
            
            leftPtr++;
            rightPtr--;
        }
        
        return true;
    }
}

/*
"race a car"
lp=0-1-2c-3e
rp=9-8-7c-6-5


*/