package com.heereey.util.MyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 字符串处理工具类
 * 2014年4月22日
 */
public class StringUtil {
	
	/**
	 * 将String转换成list
	 * @param nameStr
	 * @return
	 */
    public static List<String> convertToList(final String nameStr,final String mark) {
        List<String> list=new ArrayList<String>();
        StringTokenizer st=new StringTokenizer(nameStr,mark);
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        return list;
    }
}
