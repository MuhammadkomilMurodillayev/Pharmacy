package uz.m_m.utils;

import java.util.Scanner;

import static uz.m_m.utils.Output.print;

public class Input {
    static Scanner sc_num = new Scanner(System.in);
    static Scanner sc_str = new Scanner(System.in);

    public static Integer getNum() {
        return sc_num.nextInt();
    }

    public static Integer getNum(String str) {
        print(str);
        return sc_num.nextInt();
    }

    public static Integer getNum(String color, String str) {
        print(color, str);
        return sc_num.nextInt();
    }

    public static String getStr() {
        return sc_str.nextLine();
    }

    public static String getStr(String str) {
        print(str);
        return sc_str.nextLine();
    }

    public static String getStr(String color, String str) {
        print(color, str);
        return sc_str.nextLine();
    }
}
