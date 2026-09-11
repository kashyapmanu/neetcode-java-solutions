class Solution {
    public int[] plusOne(int[] digits) {
        /*
         - Loop through the array of digits from right to left.
         - If the digit is less than 9 add and return immediately.
         - If it is 9 then add and continue the loop.
         - If all the digits become zero we need another array to hold the extra 1 starting elements
         because we can be sure that the input contained purely 9s
        */
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
