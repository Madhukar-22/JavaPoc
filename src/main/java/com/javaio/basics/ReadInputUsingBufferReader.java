package com.javaio.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInputUsingBufferReader {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Hello " + br.readLine());
        } catch (IOException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}