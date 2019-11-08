package ru.java.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Lesson2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //
        String fullName2 = reader.readLine();
        fullName2 = fullName2.toUpperCase();
        System.out.print(fullName2.charAt(0));
        System.out.print(".");
        for (int i = 1; i < fullName2.length(); i++) {
            if (fullName2.charAt(i-1) == ' ' || fullName2.charAt(i-1) == '.' + ' ' ) {
                System.out.print(fullName2.charAt(i));
                System.out.print(".");
            }
            else
                continue;
        }


    }

}
