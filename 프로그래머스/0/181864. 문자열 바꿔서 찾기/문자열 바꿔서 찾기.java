class Solution {
    public int solution(String myString, String pat) {
        char[] chArr = myString.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == 'A') {
                chArr[i] = 'B';
            } else {
                chArr[i] = 'A';
            }
        }
        myString = String.valueOf(chArr);
        
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            
            String nowString = myString.substring(i, i+pat.length());
            
            if (nowString.equals(pat)) {
                return 1;
            }    
        }
        return 0;
    }
}