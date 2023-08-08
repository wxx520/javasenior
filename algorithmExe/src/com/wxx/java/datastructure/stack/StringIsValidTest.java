package com.wxx.java.datastructure.stack;

import java.util.Stack;

/**
 * @author wxxstar
 * @create 2023-07-25 21:34
 */
public class StringIsValidTest {

    /**
     * 1、遍历s对应的字符数组
     * 2、初始化一个栈stack
     * 3、如果字符等于('{','(','[')则向栈中push一个匹配的字符
     * 4、如果发现字符不等于('{','(','[')，
     * 4.1 若栈为空，return false
     * 4.2 从栈中pop一个值出来，发现相等则符合条件继续遍历，否则return false
     *
     * @param s 带判断字符串
     * @return boolean 是否是合法字符串
     */
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StringIsValidTest test = new StringIsValidTest();
        System.out.println(test.isValid("(([]){})"));
    }
}
