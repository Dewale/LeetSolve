class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letterBank = new HashMap<>();
        
        if (s.length() != t.length()) {
            return false;
        }
        
        for (int i =0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (letterBank.containsKey(currentChar)) {
                letterBank.put(currentChar, letterBank.get(currentChar) + 1);
            } else {
                letterBank.put(currentChar, 1);
            }
        }
        
        
        for (int i=0; i < t.length(); i++) {
            Character currentChar = t.charAt(i);
            if (letterBank.containsKey(currentChar) 
                && letterBank.get(currentChar) >= 1) {
                letterBank.put(currentChar, letterBank.get(currentChar) - 1);
            } else {
                return false;
            }
        }
        
        for (Map.Entry<Character, Integer> entry : letterBank.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        
        return true;
    }
}


