package stack;

import java.util.Stack;

/**
 * 保证匹配最后栈中的元素不为空才能返回true
 *
 * @author lixw
 * @date created in 11:35 2019/1/18
 */
public class LeetCode20ValidParentheses {
    public static void main(String[] args) {
        String string = "(())((()))({{}})";
        boolean valid = isValid(string);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //左括号才存入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                //取出栈中最顶部的元素 同时 栈中元素减一
                char topChar = stack.pop();
                //将取出的栈顶元素 与 遍历到的那个不是左括号的匹配
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
        }
        //直接return true是错误的，有可能栈里面还有没有匹配的左括号
        // return true;
        return stack.isEmpty();
    }
}
