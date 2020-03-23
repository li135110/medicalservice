package com.tk.medical.ids;

import java.util.UUID;

public class UuidUtils {
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
