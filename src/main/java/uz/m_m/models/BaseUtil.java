package uz.m_m.models;

import java.util.UUID;

public abstract class BaseUtil {
    public static String generateUniqueID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
