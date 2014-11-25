/**
 * 
 *	平安付
 * Copyright (c) 2013-2014 PingAnFu,Inc.All Rights Reserved.
 */
package com.heereey.util.MyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson工具类
 * 2014年4月22日
 */
public class GsonUtil {
    
	private static Gson gson = new GsonBuilder().setDateFormat("yyyyMMdd")
			.create();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T toObject(String json, Class beanClass) {
		if (json == null) {
			return null;
		}
		if (beanClass == null) {
			return null;
		}
		Object object;
		try {
			object = gson.fromJson(json, beanClass);
		} catch (RuntimeException e) {
			return null;
		}
		return (T) object;
	}

	@SuppressWarnings("rawtypes")
    public static String toJson(Object object, Class beanClass) {
		if (object == null) {
			return null;
		}
		if (beanClass == null) {
			return null;
		}
		return gson.toJson(object, beanClass);
	}

    /**自定义JSON转换，格式化对象内所有日期，按指定格式转换*/
    public static String objectToJsonDateSerializer(Object ts, final String dateformat) {
        String jsonStr = null;
        Gson gson =  new GsonBuilder().setDateFormat(dateformat).create();
        if (gson != null) {
            jsonStr = gson.toJson(ts);
        }
        return jsonStr;
    }
	public static void main(String[] args) {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		list.add(map);
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("11", "1");
		map1.put("2", "2");
		map1.put("3", "3");
		map1.put("4", "4");
		map1.put("5", "5");
		list.add(map1);
		
		System.out.println(GsonUtil.toJson(list, List.class));
	    
	  //  String s="{﻿regionCode:02,policyNo:P023000005688577,payToDate:20141202,planAbbrName:智盈人生,premAmount:5000,clientName:卫锦章,clientBirth:19551108,clientIdType:1,clientIdNo:310224195511085630,clientMobile:12345678901,clientBankName:中国建设银行,clientBankAcctno:1215409980110103895,remainPremTerm:91}";
	    
	    
	}
}
