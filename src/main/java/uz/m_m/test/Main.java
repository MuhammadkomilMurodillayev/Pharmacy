package uz.m_m.test;

public class Main {
    public static void main(String[] args) {

        MySingleTon singleTon1 = MySingleTon.createInstance();
        MySingleTon singleTon2 = MySingleTon.createInstance();
        MySingleTon singleTon3 = MySingleTon.createInstance();
        System.out.println(singleTon1);
        System.out.println(singleTon2);
        System.out.println(singleTon3);

    }
}
