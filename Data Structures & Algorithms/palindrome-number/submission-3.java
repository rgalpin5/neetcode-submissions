class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp = x;
        int n = 0;
        int[] digits;
        while(temp != 0){
            n++;
            temp /=10;
        }
        temp = x;
        digits = new int[n];
        n--;
        while(temp!= 0){
            digits[n] = temp %10; 
            temp/=10;
            n--;      
        }
        int left = 0;
        int right = digits.length - 1;

        while(left<= right){
            if(left == right){
                return true;
            }
            else if(digits.length == 0){
                return true;
            }
            else if(digits[left] == digits[right]){
                digits[left] = 0;
                digits[right] = 0;
            }
            else{
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}