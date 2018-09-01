package com.javaio.basics;

import java.util.Scanner;

public class ReadInputUsingScanner {
    public static void main(String[] args) {
        try{
            Scanner br = new Scanner(System.in);
            System.out.println("Hello "+br.nextLine());
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }
}

