package org.oursight.neyao.java.advanced.leetcode;

/**
 * Created by DellPC on 2017/4/16.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        int counter = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(isLeft(aChar)) {
                counter++;
            }
        }
    }

    private boolean isLeft(char c) {
        if ('{' == c)
            return true;

        if ('[' == c)
            return true;

        if ('(' == c)
            return true;

        return false;
    }

    private boolean isRight(char c) {
        if ('}' == c)
            return true;

        if ('' == c)
            return true;

        if ('(' == c)
            return true;

        return false;
    }
}
