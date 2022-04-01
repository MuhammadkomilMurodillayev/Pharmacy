package uz.m_m.utils;

import uz.m_m.enums.localization.Language;

import static uz.m_m.utils.Color.RESET;

public class Output {
    public static void print(String color, String str) {
        System.out.print(color + str + RESET);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String color, String str) {
        System.out.println(color + str + RESET);
    }

    public static void println(String str, Language ru) {
        System.out.println(str);
    }
}
