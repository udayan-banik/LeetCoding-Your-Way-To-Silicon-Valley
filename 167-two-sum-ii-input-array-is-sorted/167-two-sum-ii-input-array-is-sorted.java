class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int firstIndex = -1;
        int secondIndex = -1;
        int i = 0; 
        int j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                firstIndex = i + 1;
                secondIndex = j + 1;
                break;
            }else if(numbers[i] + numbers[j] < target)
                i++;
            else
                j--;
        }
        return new int[]{firstIndex, secondIndex};
    }
}