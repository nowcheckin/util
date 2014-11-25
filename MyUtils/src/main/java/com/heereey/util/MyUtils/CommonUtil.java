package com.heereey.util.MyUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * 
 */

public class CommonUtil {

    /** 分割符 */
    public static final String separatorPro = "_";

    /**
     * 直接获取获取验证码id
     */
    public static String getCaptchaCenterId() {
        return getCaptchaCenterUid();
    }

    /**
     * 生成验证码uuid
     */
    private static String getCaptchaCenterUid() {
        return urlFilter(UUID.randomUUID().toString());
    }

    /**
     * 过滤掉url中的特殊字符
     */
    private static String urlFilter(String s) {
        return s.replaceAll("[+? /%#&=]", "");
    }

    // 生成随机数字和字母,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 获得交易流水号
     * @return
     */
    public static String getTransSeriNo() {
        String todayTimstamp = DateUtil.getDate("7");
        String randCode = getStringRandom(8);
        return randCode + todayTimstamp;
    }

    /**
     * 得到4位随机码
     * 
     * @param min
     * @param max
     * @return
     */
    public static String nextInt(final int min, final int max) {
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        int randTemp = tmp % (max - min + 1) + min;
        return String.valueOf(randTemp);
    }

    /**
     * [定期理财]计算预付金额
     * @param diffDay	投资天数
     * @param incomeRate	收益率
     * @param policyPrice	续保金额
     * @param increasingMoney 递增金额
     * @return
     */
    public static BigDecimal getPrePayPrice(int diffDay, String incomeRate, double policyPrice,BigDecimal invesmentMoney,BigDecimal increasingMoney) {
        //计算收益日=优惠到期日
        //预期收益=(保单金额*预期收益率/365)*天数。
        double beforePayPolicyPrice = (Double.valueOf(policyPrice) * Double.valueOf(incomeRate) / 365)
                                      * diffDay;
       //预付金额=保单金额-预期收益
        double prepayPriceTemp = Double.valueOf(policyPrice) - beforePayPolicyPrice;
        BigDecimal beforePriceTemp = new BigDecimal(prepayPriceTemp).setScale(2,
            BigDecimal.ROUND_HALF_UP);
        //计算份额
        int count = (beforePriceTemp.subtract(invesmentMoney)).divide(increasingMoney).setScale(0,BigDecimal.ROUND_HALF_UP).intValue();
        if(count <=0){
            return new BigDecimal(0);
        }else{
            return invesmentMoney.add(increasingMoney.multiply(BigDecimal.valueOf(count+1)).setScale(0,BigDecimal.ROUND_HALF_UP));
        }
    }
    
    /**
     * [活期理财]计算预付金额
     * @param diffDay   投资天数
     * @param incomeRate    收益率
     * @param policyPrice   续保金额
     * @return
     */
    public static BigDecimal getPrePayPrice(int diffDay, String incomeRate, double policyPrice) {
        //计算收益日=优惠到期日
        //预期收益=(保单金额*预期收益率/365)*天数。
        //预付金额=保单金额-预期收益
        double beforePayPolicyPrice = (Double.valueOf(policyPrice) * Double.valueOf(incomeRate) / 365)
                                      * diffDay;
        double prepayPriceTemp = Double.valueOf(policyPrice) - beforePayPolicyPrice;
        BigDecimal beforePriceTemp = new BigDecimal(prepayPriceTemp).setScale(2,
            BigDecimal.ROUND_HALF_UP);
        return beforePriceTemp;
    }


    /**
     * 将BigDecimal转化为String，若val为null，则采用defaultVal
     * 
     * @param val
     * @param defaultVal
     * @return
     */
    public static String BigDecimalToString(BigDecimal val, BigDecimal defaultVal) {
        if (val == null) {
            val = defaultVal;
        }
        if (val == null)
            return "";
        else
            return val.toString();

    }

    /**
     * 将字符串截断到指定的字节长度
     * 用于保证存储长字符串时保证不会超过数据库字段定义字节长度
     * 可能会导致最后一个汉字被截断显示为乱码
     * 
     * @param source
     * @param byteLen
     * @return 截断后的字符串
     */
    public static String trancate(String source, int byteLen) {
        if (source == null || source.getBytes().length <= byteLen)
            return source;
        return new String(Arrays.copyOf(source.getBytes(), byteLen - 2)); // -2 保证 new String 后字节长度仍然不会超过charLen
    }

    /**
     * 得到连接后的字符串
     * 
     * @param totalLength
     * @param appendStr
     * @return
     */
    public static String getLastAppendStr(String oldStr, int totalLength, String appendStr) {
        if(oldStr != null){
            if (oldStr.length() < totalLength) {
                for (int i = 0; i < totalLength; i++) {
                    oldStr += appendStr;
                }
            }
        }
        return oldStr;
    }
    
    /**
     * 得到连接后的字符串
     * 
     * @param totalLength
     * @param appendStr
     * @return
     */
    public static String getAppendStr(String oldStr, int totalLength, String appendStr) {
        int length = 0;
        if(oldStr != null){
            byte[] array;
            try {
                array = oldStr.getBytes("gbk");
                length = array.length;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (length < totalLength) {
                for (int i = length; i < totalLength; i++) {
                    oldStr += appendStr;
                }
            }
        }else{
            String blankStr = getLastAppendStr("", totalLength , " ");
            oldStr = blankStr;
        }
        return oldStr;
    }
    
    /**
     * 字符串前面补0
     * 
     * @param totalLength
     * @param appendStr
     * @return
     */
    public static String addZeros(String oldStr, int len) {
        if (oldStr.length() >= len) return oldStr;
        len -= oldStr.length();
        StringBuilder sb = new StringBuilder();
        while (len-- > 0) {
            sb.append('0');
        }
        sb.append(oldStr);
        return sb.toString();
    }

    /**
     * 获取Exception的堆栈新息。用于显示出错来源时使用。
     * @param e
     *            Exception对象
     * @param length
     *            需要的信息长度，如果 <=0,表示全部信息
     * @return String 返回该Exception的堆栈新息
     * @author yuquanquan
    */
    public static String getErrorStack(Exception e, int length) {
        String error = null;
        if (e != null) {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                e.printStackTrace(ps);
                error = baos.toString();
                if (length > 0) {
                    if (length > error.length()) {
                        length = error.length();
                    }
                    error = error.substring(0, length);
                }
                baos.close();
                ps.close();
            } catch (Exception e1) {
                error = e.toString();
            }
        }
        return error;
    }
    
    /**
     * 得到两位英文随机码
     * @return
     */
    public static String smsCode(){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] c = s.toCharArray();
        Random random = new Random();
        String smsCode = "";
        for (int i = 0; i < 2; i++) {
        	smsCode += String.valueOf(c[random.nextInt(c.length)]);
        }
        return smsCode;
    }

    public static void main(String args[]) {
        String transSeriNo = getTransSeriNo();
        System.out.println(transSeriNo);

        System.out.println("###### test trancate:");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            sb.append("s");
        }
        for (int i = 0; i < 100; i++) {
            sb.append("我");
        }
        String result = sb.toString();
        System.out.println("before trancate, string = " + result);
        System.out.println("before trancate, string byte len = " + result.getBytes().length);
        result = trancate(sb.toString(), 200);
        System.out.println("after trancate to 200, string = " + result);
        System.out.println("after trancate to 200, string byte len =  " + result.getBytes().length);
        System.out.println("end test trancate ######");
        
        String s = addZeros("1230000000", 15);
        System.out.println(s);
        
        String memo = getAppendStr(null, 20, " ");
        System.out.println(memo);
        
    }


}
