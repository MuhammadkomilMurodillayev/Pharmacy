package uz.m_m.test;

import java.util.Objects;

public class MySingleTon {
    private static MySingleTon instance;


    private MySingleTon() {

    }

    public static MySingleTon createInstance() {
        if (Objects.isNull(instance)) {
            instance = new MySingleTon();
        }
        return instance;
    }
}
