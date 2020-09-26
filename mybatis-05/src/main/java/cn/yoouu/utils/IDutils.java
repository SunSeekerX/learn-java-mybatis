package cn.yoouu.utils;

import org.junit.Test;

import java.util.UUID;

// 抑制警告
@SuppressWarnings("all")
public class IDutils {
    public static String genUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
        return uuid;
    }

    @Test
    public void soutUUID(){
        genUUID();
    }
}
