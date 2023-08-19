package com.wxx.java.datastructure;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Stack;

/**
 * @author wxxstar
 * @create 2023-08-12 21:01
 */
public class IsNumberTest {

    /**
     * +-首位或e的后面，且只能出现一次
     * .只能有一个，不能是第一个，且不能在e前面
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isE = false;
        boolean isDot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (stack.isEmpty() || stack.peek() == ' ') {
                    continue;
                }
                stack.push(c);
                continue;
            }

            if (c == '+' || c == '-') {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                } else if (stack.peek() == 'e') {
                    stack.push(c);
                    continue;
                } else {
                    return false;
                }
            }

            if (c == 'e' || c == 'E') {
                if (isE || stack.isEmpty() || !(isNumber(stack.peek()))) {
                    return false;
                } else {
                    stack.push('e');
                    isE = true;
                    continue;
                }
            }

            if (c == '.') {
                if (isE || isDot) {
                    return false;
                }
                if (!stack.isEmpty() && (stack.peek() == ' ')) {
                    return false;
                }
                isDot = true;
                stack.push(c);
                continue;
            }

            if (!isNumber(c)) {
                return false;
            }

            if(!stack.isEmpty()&&!isNumber(stack.peek())){
                return false;
            }

            stack.push(c);
        }
        if (stack.isEmpty()) {
            return false;
        } else if (stack.peek() == ' ') {
            stack.pop();
        }
        if (!isE && stack.peek() == '.' && stack.size() > 1) {
            return true;
        }
        return isNumber(stack.peek());
    }

    private boolean isNumber(char c) {
        int gap = c - '0';
        if (gap > 9 || gap < 0) {
            return false;
        } else {
            return true;
        }
    }

    @Test
    public void t1() {
        System.out.println(isNumber("3. "));
        System.out.println(isNumber("1 ."));

        System.out.println(isNumber("0"));
        System.out.println(isNumber("-12e+54"));
        System.out.println(isNumber("e9"));

        System.out.println(isNumber(".1"));
        System.out.println(isNumber(". 1"));
        System.out.println(isNumber(".e1"));
    }

}
