package com.xeype;

public class ReverseMethods {

    public static String reverse(String src) {
        String reversedString = "";
        for (int i = src.length() - 1; i >= 0; i--) {
            reversedString = reversedString.concat(String.valueOf(src.charAt(i)));
        }
        return reversedString;
    }

    public static String reverseBySubstring(String src, String sub) {
        String reversedString;
        int indexStart = src.indexOf(sub);
        if (indexStart != -1) {
            String reversedSub = reverse(sub);
            reversedString = src.substring(0, indexStart);
            reversedString = reversedString.concat(reversedSub);
            reversedString = reversedString.concat(src.substring(indexStart + sub.length()));
            return reversedString;
        } else {
            throw new IllegalArgumentException(sub + " not found in " + src);
        }
    }

    public static String reverseByIndexes(String src, int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex < firstIndex || lastIndex > src.length()) {
            throw new IllegalArgumentException("Please enter the correct indexes! \n");
        } else {
            String subStr = src.substring(firstIndex, lastIndex + 1);
            subStr = reverse(subStr);
            String reversedString = src.substring(0, firstIndex);
            reversedString = reversedString.concat(subStr);
            reversedString = reversedString.concat(src.substring(lastIndex + 1));
            return reversedString;
        }
    }
}
