package com.ecom.onlineproductcatalog.core;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Utilities {
    public static Map<String,Object> getResponseFieldMap(String k,Object v)
    {
        Map<String,Object> m = new HashMap<>();
        m.put(k,v);
        return m;
    }
    public static void putResponseFieldMap(Map<String,Object> m,String k,String v)
    {
        m.put(k,v);
    }
    public static  String getSku()
    {
        UUID uuid  = UUID.randomUUID();
        return uuid.toString().substring(0,5);
    }
}
