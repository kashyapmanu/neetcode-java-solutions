class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (isOpenParantheses(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (!isValidParantheses(stack.pop(), c)) {
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
