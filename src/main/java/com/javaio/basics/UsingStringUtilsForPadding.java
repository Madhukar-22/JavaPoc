package com.javaio.basics;

import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class UsingStringUtilsForPadding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            if (s1.length() < 10 && x < 1000) {
                System.out.printf("%s\n", StringUtils.rightPad(s1, 15) + StringUtils.leftPad(String.valueOf(x), 3, "0"));

            }
        }
        System.out.println("================================");

    }
}

