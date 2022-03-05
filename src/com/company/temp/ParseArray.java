package com.company.temp;

import java.util.Arrays;

public class ParseArray {
    public static void main(String[] args) {
        String s = "[1111111, 2222222]";
        String s2 = s.replaceAll("^[\\s]+|[\\s]+$|\\[|\\]","");
        System.out.println(s2);

        String[] arr = s.replace("[","").replace("]","").split(",");
       // System.out.println(Arrays.toString(arr));
    }
}
