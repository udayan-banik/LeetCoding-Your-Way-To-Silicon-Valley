class Solution {
    public String reverseWords(String s) {
        int i = 0;
        char[] arr = s.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                reverse(i, j - 1, arr);
                i = j + 1;
            } else if (j == arr.length - 1)  {
                reverse(i, j, arr);
            }
            
        }
        return new String(arr);
    }
    
    void reverse(int start, int end, char[] arr) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}