package com.heereey.util.MyUtils;

import java.util.UUID;

/**
 * UUID生成工具类
 * 2014年4月22日
 */

public class UUIDGenerator {
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();     
        String str = uuid.toString();    
        String temp = str.replaceAll("-", "");
        return temp;  
	}
}
