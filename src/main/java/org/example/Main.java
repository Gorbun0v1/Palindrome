package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(count(line));
    }
    public static String count(String line) { //подсчет
        int max = getMaxCodeASCII(line);
        int[] symbols = new int[max + 1];
        for (int i = 0; i < line.length(); i++) {
            symbols[line.charAt(i)]++;
        }
        StringBuilder result = new StringBuilder();
        int centr = -1;
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] > 1) { //Все буквы которые встречаются больше 1 раза
                for (int j = 0; j < symbols[i] / 2; j++) { //встают первыми в очередь result
                    result.append((char) i);
                }
            }
            if (centr == -1 && symbols[i] % 2 == 1) {
                centr = i;
            }
        }
        if (centr != -1) {
            return result.toString() + (char)centr + result.reverse();
        }
        return result.toString() + result.reverse();
    }
    public static int getMaxCodeASCII(String line) {
        int max = line.charAt(0);
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) > max) {
                max = line.charAt(i);
            }
        }
        return max;
    }
}