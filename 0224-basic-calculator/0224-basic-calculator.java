class Solution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int result = 0, sign = 1, num = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num = num * 10 + chars[i] - '0';
            } else if (chars[i] == '+' || chars[i] == '-') {
                result += sign * num;
                sign = stack.peek() * (chars[i] == '+' ? 1 : -1);
                num = 0;
            } else if (chars[i] == '(') {
                stack.push(sign);
            } else if (chars[i] == ')') {
                stack.pop();
            }
        }
        result += sign * num;
        return result;
    }
}