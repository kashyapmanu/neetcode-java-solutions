class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (isOpenParantheses(c)) {
                stack.push(c);
            } else {
                if (!isValidParantheses(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isOpenParantheses(char c) {
        return (c == '{' || c == '[' || c == '(');
    }

    private boolean isValidParantheses(char open, char close) {
        return ((open == '(' && close == ')') || (open == '[' && close == ']')
            || (open == '{' && close == '}'));
    }
}
