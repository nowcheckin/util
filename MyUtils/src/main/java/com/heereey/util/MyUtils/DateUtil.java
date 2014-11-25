package com.heereey.util.MyUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 日期工具类
 * 2014年4月22日
 */
public class DateUtil {

    static final DateFormat YYYYMMDDHHMMSS_FORMAT  = new java.text.SimpleDateFormat(
                                                       "yyyyMMddHHmmss");

    static final DateFormat YYYYMMDDHHMMSSS_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssS");

    static final DateFormat YYYYMMDD_FORMAT        = new java.text.SimpleDateFormat("yyyyMMdd");

    static final DateFormat YYYY_MM_DD_FORMAT      = new java.text.SimpleDateFormat(
                                                       "yyyy-MM-dd HH:mm:ss");

    static final DateFormat CN_TIME_FORMAT         = new java.text.SimpleDateFormat(
                                                       "yyyy年MM月dd日 HH:mm:ss");

    static final DateFormat YYYY_MM_DD             = new java.text.SimpleDateFormat("yyyy-MM-dd");

    static final DateFormat YYYY_MM_DD_HH          = new java.text.SimpleDateFormat(
                                                       "yyyy-MM-dd HH:mm");

    static final DateFormat YYYYMMDD_SLASH_FORMAT  = new java.text.SimpleDateFormat("yyyy/MM/dd");

    static final DateFormat HHMMSS_FORMAT          = new java.text.SimpleDateFormat("hhMMss");

    static final DateFormat TIME_FORMATE           = new java.text.SimpleDateFormat("HHmmss");

    static final DateFormat TIME_FOR_MAT           = new java.text.SimpleDateFormat(
                                                       "yyyy/MM/dd hh:MM:ss");                     //   

    /**
     * yyyy-MM-dd hh:mm:ss  输出格式: 2006-01-01 01:00:00
     * yyyy-MM-dd HH:mm:ss  输出格式: 2006-01-01 13:00:00
     * yyyyMMddhhmmss       输出格式: 20060101000000
     */
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getFormatedDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String getFormatedDate(String pattern) {
        Date date = getCurrentDate();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 字符串生成转换为日期
     *
     * @param strDate
     * <p>
     * 2006-01-01 01:00:00
     * 2006-01-01 13:00:00
     * 2006-01-01 01:00:00
     * </p>
     * @param pattern
     * <p>
     *  yyyyMMddhhmmss
     *  yyyy-MM-dd HH:mm:ss
     *  yyyy-MM-dd hh:mm:ss
     * </p>
     * @return
     */
    public static Date StrToFormatedDate(String strDate, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(strDate);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回指定日期相应位移后的日期
     *
     * @param date
     *            参考日期
     * @param field
     *            位移单位，见 {@link Calendar}
     * @param offset
     *            位移数量，正数表示之后的时间，负数表示之前的时间
     * @return 位移后的日期
     */
    public static Date offsetDate(Date date, int field, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, offset);
        return cal.getTime();
    }

    /**
     * 获取当前日期的字符串表示
     *
     * <pre>
     * type 为下列值对应的日期格式
     *
     * 1.yyyy-MM-dd HH:mm:ss
     * 2.yyyy-MM-dd hh:mm:ss
     * 3.yyyyMMddHHmmss
     * 4.yyyyMMddhhmmss
     * 5.yyyy-MM-dd
     * 6.yyyyMMdd
     *
     * 默认显示：yyyy-MM-dd HH:mm:ss
     * </pre>
     *
     * @param type
     * @return String
     */
    public static String getDate(String type) {
        // 格式对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // yyyy-MM-dd HH:mm:ss
        if ("1".equals(type)) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(new Date());
        }

        // yyyy-MM-dd hh:mm:ss
        if ("2".equals(type)) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return simpleDateFormat.format(new Date());
        }

        // yyyyMMddHHmmss
        if ("3".equals(type)) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            return simpleDateFormat.format(new Date());
        }

        // yyyyMMddhhmmss
        if ("4".equals(type)) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
            return simpleDateFormat.format(new Date());
        }

        // yyyy-MM-dd
        if ("5".equals(type)) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date());
        }

        // yyyyMMdd
        if ("6".equals(type)) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            return simpleDateFormat.format(new Date());
        }

        //yyyyMMddHHmmssS
        if ("7".equals(type)) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
            return simpleDateFormat.format(new Date());
        }

        return simpleDateFormat.format(new Date());
    }

    /**
     * 格式化日期函数 内部使用
     *
     * 根据指定格式对当前日期进行格式化
     *
     * @param date 当前日期
     * @param format 需要转化的格式
     * @return String 转换后的字符串格式日期
     */
    public static String parseDate(Date date, String format) {

        SimpleDateFormat dateformat = new SimpleDateFormat(format);

        return dateformat.format(date);
    }

    /**
     * get current date
     *
     * @return java.sql.Date
     */
    public static java.sql.Date getCurDate() {
        // DateFormat.getInstance().format((new java.util.Date()))
        return getDateByTimeStamp(getCurTime());
    }

    public static String getFormatCurDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curdate = getCurDate();
        return formatter.format(curdate);
    }

    /**
     * 获取当前日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getCurrentDateString() {
        return formateDateStr(new Date());
    }

    /**
     * 获取明天日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getTomorrowDateString() {
        return getDateStringDelay(1);
    }

    /**
     * 获取距离今天 delay 天的日期 yyyy-MM-dd
     *
     * @param delay
     * @return
     */
    public static String getDateStringDelay(int delay) {
        return formateDateStr(DateUtil.addDate(new Date(), delay));
    }

    /**
     * get current time
     *
     * @return Timestamp
     */
    public static Timestamp getCurTime() {
        return new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public static String getTime() {
        Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        return time.toString();
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成Date
     *
     * @param dateStr
     * @return
     */
    public static java.util.Date getDateOfStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date da = null;
        try {
            da = df.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return da;
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成Date
     *
     * @param dateStr
     * @return
     */
    public static java.util.Date getDateOfStr(String dateStr, String format) {
        DateFormat df = new java.text.SimpleDateFormat(format);
        java.util.Date da = null;
        try {
            da = df.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return da;
    }

    /**
     * 把yyyyMMdd格式的字符串转换成Date
     *
     * @param dateStr
     * @return
     */
    synchronized public static java.sql.Date getDateOfShortStr(String dateStr) {
        java.sql.Date da = null;
        try {
            da = new java.sql.Date(YYYYMMDD_FORMAT.parse(dateStr).getTime());
        } catch (Exception e) {
            return null;
        }
        return da;
    }

    /**
     * 把  格式的字符串转换成Date
     *
     * @param dateStr
     * @return
     */
    synchronized public static java.sql.Date getDateOfShortStrs(String dateStr) {
        java.sql.Date da = null;
        try {
            da = new java.sql.Date(TIME_FOR_MAT.parse(dateStr).getTime());
        } catch (Exception e) {
            return null;
        }
        return da;
    }

    /**
     * 把日期转换成 yyyyMMdd格式的字符串
     *
     * @param date
     * @return
     */
    synchronized public static String getShortStrDate(java.util.Date date) {
        return YYYYMMDD_FORMAT.format(date);
    }

    /**
     *
     * 把日期转换成 yyyyMMddHHmmss格式的字符串
     *
     * @param date
     * @return
     */
    synchronized public static String getShortStrDateTime(java.util.Date date) {
        return YYYYMMDDHHMMSS_FORMAT.format(date);
    }

    /**
     * 这个方法有问题，请不要使用！！！！！！
     * 把日期转换成 HHmmss格式的字符串
     *
     * @param date
     * @return
     */
    @Deprecated
    synchronized public static String getShortStrTimes(java.util.Date date) {
        return HHMMSS_FORMAT.format(date);
    }

    /**
     * 把yyyyMMdd格式字符串转换成 java.sql.Date
     *
     * @param dateStr
     * @return
     */
    synchronized public static java.sql.Date getSqlDateByShortStr(String dateStr) {
        java.sql.Date da = null;
        try {
            da = new java.sql.Date(YYYYMMDD_FORMAT.parse(dateStr).getTime());
        } catch (Exception e) {
            return null;
        }
        return da;
    }

    /**
     * 把yyyyMMddHHmmss格式字符串转换成 java.sql.Date
     *
     * @param dateStr
     * @return
     */
    public static synchronized java.sql.Date getSqlDateTimeByShortStr(String dateStr) {
        java.sql.Date da = null;
        try {
            da = new java.sql.Date(YYYYMMDDHHMMSS_FORMAT.parse(dateStr).getTime());
        } catch (Exception e) {
            return null;
        }
        return da;
    }

    /**
     * 把yyyyMMdd格式字符串转换成 java.util.Date
     *
     * @param dateStr
     * @return
     */
    synchronized public static java.util.Date getUtilDateByShortStr(String datestr) {
        try {
            return YYYYMMDD_FORMAT.parse(datestr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 把yyyyMMddHHmmss格式字符串转换成 java.util.Date
     *
     * @param dateStr
     * @return
     */
    synchronized public static java.util.Date getUtilDateTimeByShortStr(String datestr) {
        try {
            return YYYYMMDDHHMMSS_FORMAT.parse(datestr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成Timestamp
     *
     * @param dateStr
     * @return Timestamp
     */
    @SuppressWarnings("finally")
    public static Timestamp getTimeOfDateStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(dateStr);
            time = new java.sql.Timestamp(da.getTime());
        } catch (Exception e) {
        } finally {
            return time;
        }
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成Timestamp，且该时间是该天的最后时间
     *
     * @param dateStr
     * @return Timestamp
     */
    @SuppressWarnings("finally")
    public static Timestamp getTimeEndOfDateStr(String dateStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(dateStr);
            time = new java.sql.Timestamp(da.getTime() + 24 * 60 * 60 * 1000 - 1);
        } catch (Exception e) {
        } finally {
            return time;
        }
        /*
         * Date date = Date.valueOf(dateStr); date.setTime(date.getTime() + 24 * 60 * 60 * 1000 - 1); return new
         * Timestamp(date.getTime());
         */
    }

    /**
     * 把yyyy-MM-dd HH:mm:ss.S格式的字符串转换成Timestamp
     *
     * @param timeStr
     * @return Timestamp
     */
    @SuppressWarnings("finally")
    public static Timestamp getTimeOfTimeStr(String timeStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(timeStr);
            time = new java.sql.Timestamp(da.getTime());
        } catch (Exception e) {
        } finally {
            return time;
        }

        /*
         * Timestamp time = Timestamp.valueOf(timeStr); return new Timestamp(time.getTime());
         */
    }

    /**
     * 把yyyy-MM-dd HH:mm:ss.S格式的字符串转换成Date
     *
     * @param timeStr
     * @return Timestamp
     */
    @SuppressWarnings("finally")
    public static Date getDateOfTimeStr(String timeStr) {
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date da = null;
        try {
            da = df.parse(timeStr);
        } catch (Exception e) {
        } finally {
            return da;
        }

        /*
         * Timestamp time = Timestamp.valueOf(timeStr); return new Timestamp(time.getTime());
         */
    }

    /**
     * 把pattern格式的字符串转换成Timestamp
     *
     * @param timeStr
     * @return Timestamp
     */
    @SuppressWarnings("finally")
    public static Timestamp getTimeOfTimeStr(String timeStr, String pattern) {
        DateFormat df = new java.text.SimpleDateFormat(pattern);
        java.sql.Timestamp time = null;
        try {
            java.util.Date da = df.parse(timeStr);
            time = new java.sql.Timestamp(da.getTime());
        } catch (Exception e) {
        } finally {
            return time;
        }
    }

    /**
     * 根据Timestamp获得日期
     *
     * @param time
     * @return java.sql.Date
     */
    public static java.sql.Date getDateByTimeStamp(Timestamp time) {
        return (new java.sql.Date(time.getTime()));
    }

    /**
     * 获得对应时间time的相应field的值。 如获得当前时间的分钟，则调用方式如下 getTimeFieldStr(getCurTime(), Calendar.MINUTE)
     *
     * @param time
     * @param field
     * @return String
     */
    public static String getTimeFieldStr(Timestamp time, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date(time.getTime()));
        int fieldValue = calendar.get(field);
        if (field == Calendar.MONTH)
            fieldValue++;
        return String.valueOf(fieldValue);
    }

    /**
     * 获得时间time对应的中文日期的字符串
     *
     * @param time
     * @return String -- 如 2003年5月12日
     */
    public static String getDateCn(Timestamp time) {
        if (time == null)
            return null;
        String dateCn = getTimeFieldStr(time, Calendar.YEAR) + "年"
                        + getTimeFieldStr(time, Calendar.MONTH) + "月"
                        + getTimeFieldStr(time, Calendar.DATE) + "日";
        return dateCn;
    }

    /**
     * 获得时间time对应的中文日期的字符串
     *
     * @param time
     * @return String -- 如 2003年5月12日12:12:12
     */
    public static String getDateTimeCn() {
        DateFormat f3 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return f3.format(new Date());
    }

    /**
     * 获得时间time对应的中文日期的字符串
     *
     * @param time
     * @return String -- 如 2003-5-12
     */
    public static String getDateString(Timestamp time, String v) {
        String dateCn = getTimeFieldStr(time, Calendar.YEAR) + v
                        + getTimeFieldStr(time, Calendar.MONTH) + v
                        + getTimeFieldStr(time, Calendar.DATE);
        return dateCn;
    }

    /**
     * 获得日期dateStr是星期几，日期格式是“yyyy-MM-dd”
     *
     * @param dateStr
     * @return String -- 如 星期日
     */
    public static String getDayOfWeekCn(String dateStr) {
        Calendar cal = Calendar.getInstance();
        String weekCn = null;
        Timestamp time = getTimeOfDateStr(dateStr);
        if (time != null) {
            cal.setTime(time);
            int day = cal.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case 1:
                    weekCn = "星期日";
                    break;
                case 2:
                    weekCn = "星期一";
                    break;
                case 3:
                    weekCn = "星期二";
                    break;
                case 4:
                    weekCn = "星期三";
                    break;
                case 5:
                    weekCn = "星期四";
                    break;
                case 6:
                    weekCn = "星期五";
                    break;
                case 7:
                    weekCn = "星期六";
                    break;
                default:
                    weekCn = "";
            }
        }
        return weekCn;
    }

    /**
     * 将 Timestamp 对应的日期以 "yyyy-MM-dd" 格式返回一个字符串
     *
     * @param stamp
     * @return
     */
    public static String formatDate(Timestamp stamp) {
        if (stamp == null)
            return "";
        return new java.sql.Date(stamp.getTime()).toString();
    }

    /**
     * 返回前天，昨天，明天，后天等
     *
     * @param diffdate 于今天相差的天数
     * @return
     */
    public static String getCustomDate(int diffdate) {
        String customDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curdate = getCurDate();
        long myTime = curdate.getTime() + 1000L * 3600 * 24 * diffdate;
        curdate.setTime(myTime);
        customDate = formatter.format(curdate);
        return customDate;
    }

    public static String getFormatDate(java.util.Date date) {
        String customDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        customDate = formatter.format(date);
        return customDate;
    }

    /**
     * 返回前天，昨天，明天，后天等 此方法恶心的一比，不知道谁写的，Timestamp转String再转回Timestamp，有毛病啊,不准使用该方法。
     *
     * @param diffdate 于今天相差的天数
     * @return
     */
    @Deprecated
    public static String getCustomExDate(String timeStamp, int diffdate) {
        String customDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp temp = getTimeOfTimeStr(timeStamp);
        long myTime = temp.getTime() + 1000L * 3600 * 24 * diffdate;
        temp.setTime(myTime);
        customDate = formatter.format(temp);
        return customDate;
    }

    public static String formateDate(java.util.Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null)
            return df.format(date);
        return null;
    }

    /**
     * 格式化日期格式返回字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formateDate(java.util.Date date, DateFormat dateFormat) {
        return dateFormat.format(date);
    }

    /**
     * 日期格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    synchronized public static String formateDateString(java.util.Date date) {
        if (null == date) {
            return "";
        }
        return formateDate(date, YYYY_MM_DD_FORMAT);

    }

    /**
     * 日期格式 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    synchronized public static String formateDateStr(java.util.Date date) {
        return formateDate(date, YYYY_MM_DD);

    }

    /**
     * 日期格式 yyyy-MM-dd HH:mm
     *
     * @param date
     * @return
     */
    synchronized public static String formateDateHourStr(java.util.Date date) {
        return formateDate(date, YYYY_MM_DD_HH);

    }

    /**
     * 返回前天，昨天，明天，后天等
     *
     * @param diffdate 于今天相差的天数
     * @return
     */
    public static String getBeforeDay(int diffdate) {
        return getCustomExDate(getTime(), diffdate);
    }

    /**
     * 得到本月的第一天
     *
     * @return
     */
    public static String getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getFormatDate(calendar.getTime());
    }

    /**
     * 得到本月的最后一天
     *
     * @return
     */
    public static String getMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getFormatDate(calendar.getTime());
    }

    public static int getDaysofMonth(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        cld.set(5, 1);
        cld.add(2, 1);
        cld.add(6, -1);
        int days = cld.get(5);
        return days;
    }

    public static int getWeeksofMonth(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        cld.set(5, 1);
        cld.add(2, 1);
        cld.add(6, -1);
        int weeks = cld.get(4);
        return weeks;
    }

    public static boolean isCurrentMonth(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        int currentYear = cld.get(1);
        int currentMonth = cld.get(2);
        cld.setTime(date1);
        int year = cld.get(1);
        int month = cld.get(2);
        boolean currentFlag = false;
        if (currentYear == year && currentMonth == month)
            currentFlag = true;
        return currentFlag;
    }

    public static int getFirstDayofWeek(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        cld.set(5, 1);
        int dayOfFirstSunday = cld.get(7) - 1;
        return dayOfFirstSunday;
    }

    public static int getFirstWeekofMonth(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        cld.set(5, 1);
        int week = cld.get(3);
        return week;
    }

    public static Date getFirstDayofMonth(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        cld.set(5, 1);
        return cld.getTime();
    }

    public static Date getLastDayofMonth(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        cld.set(5, 1);
        return cld.getTime();
    }

    public static int getDayofMonth(Date date1) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        int day = cld.get(5);
        return day;
    }

    public static int getMonth(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        int month = cld.get(2);
        return month;
    }

    public static int getYear(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        int year = cld.get(1);
        return year;
    }

    public static int getDayofWeek(Date date1) throws Exception {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date1);
        int dayOfSunday = cld.get(7);
        return dayOfSunday;
    }

    public static Date getMonday(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 关于DAY_OF_WEEK的说明
        // Field number for get and set indicating
        // the day of the week. This field takes values
        // SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        // and SATURDAY
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    public static int getCurrentDayofMonth() throws Exception {
        Calendar cld = Calendar.getInstance();
        int day = cld.get(5);
        return day;
    }

    /**
     * 日期相加
     *
     * @param date 日期
     * @param day 天数
     * @return 返回相加后的日期
     */
    public static java.util.Date addDate(java.util.Date date, int day) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 日期相减
     *
     * @param date 日期
     * @param day 天数
     * @return 返回相减后的日期
     */
    public static java.util.Date minusDate(java.util.Date date, int day) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) - ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 日期相加
     *
     * @param date 日期
     * @param day 天数
     * @return 返回相加后的日期
     */
    public static java.util.Date addDate(java.util.Date date, double day) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis((long) (getMillis(date) + day * 24 * 3600 * 1000));
        return c.getTime();
    }

    /**
     * 分钟相加
     *
     * @param date
     * @param minite
     * @return
     */
    public static java.util.Date addMinute(java.util.Date date, double minute) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis((long) (getMillis(date) + minute * 60 * 1000));
        return c.getTime();
    }

    public static java.util.Date addSecond(java.util.Date date, long second) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis((long) (getMillis(date) + second * 1000));
        return c.getTime();
    }

    /**
     * 功能描述: <br>
     * 某日期增加n小时
     *
     * @param date
     * @param hours
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static java.util.Date addHours(java.util.Date date, Integer hours) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis((long) (getMillis(date) + hours * 60 * 60 * 1000));
        return c.getTime();
    }

    /**
     * 日期相减
     *
     * @param date 日期
     * @param date1 日期
     * @return 返回相减后的日期
     */
    public static int diffDate(java.util.Date date, java.util.Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

    public static int diffDateToMonth(java.util.Date date, java.util.Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (30 * 24 * 3600 * 1000));
    }

    public static int diffDateToHour(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (1000 * 60 * 60));
    }

    public static int diffDateToMinute(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (1000 * 60));
    }

    /**
     * 功能描述: <br>
     * 两个日期间隔多少秒
     *
     * @param firstDate
     * @param secondDate
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static int diffSeconds(java.util.Date firstDate, java.util.Date secondDate) {
        return (int) ((getMillis(firstDate) - getMillis(secondDate)) / 1000);
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 获取当天日期 字符串形式返回
     *
     * @return
     */
    public static String newDate() {
        // DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = null;
        date = format.format(new java.util.Date());
        return date;
    }

    /**
     * 判断是否同年同月
     *
     * @param t1 日期1
     * @param t2 日期2
     * @return
     */
    public static boolean isSameMonth(Timestamp t1, Timestamp t2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(t1);
        int year1 = cal.get(Calendar.YEAR);
        int month1 = cal.get(Calendar.MONTH);
        //        System.out.println("year1:" + year1 + "month1:" + month1);
        cal.setTime(t2);
        int year2 = cal.get(Calendar.YEAR);
        int month2 = cal.get(Calendar.MONTH);
        //        System.out.println("year2:" + year2 + "month2:" + month2);
        if (year1 == year2 && month1 == month2)
            return true;
        return false;
    }

    /**
     * 根据传入的数据获取星期
     *
     * @param i
     * @return
     */
    public static String getWeek(int i) {
        String result = "";
        switch (i) {
            case 1:
                result = "星期日";
                break;
            case 2:
                result = "星期一";
                break;
            case 3:
                result = "星期二";
                break;
            case 4:
                result = "星期三";
                break;
            case 5:
                result = "星期四";
                break;
            case 6:
                result = "星期五";
                break;
            case 7:
                result = "星期六";
                break;
            default:
                break;
        }
        return result;
    }

    public static String getMonth(int i) {
        String result = "";
        switch (i) {
            case 0:
                result = "1";
                break;
            case 1:
                result = "2";
                break;
            case 2:
                result = "3";
                break;
            case 3:
                result = "4";
                break;
            case 4:
                result = "5";
                break;
            case 5:
                result = "6";
                break;
            case 6:
                result = "7";
                break;
            case 7:
                result = "8";
                break;
            case 8:
                result = "9";
                break;
            case 9:
                result = "10";
                break;
            case 10:
                result = "11";
                break;
            case 11:
                result = "12";
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获取指定格式“星期+月份+日”的字符串
     *
     * @return
     */
    public static String getWeekString(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //        System.out.println(getWeek(week) + "  " + getMonth(month) + " " + day);
        return getWeek(week) + "  " + getMonth(month) + "." + day;
    }

    /*
     * public static void main(String[] args) { getNowWeek(); }
     */

    public static Timestamp dateToTimestamp(java.util.Date date) {
        if (date != null) {
            return new java.sql.Timestamp(date.getTime());
        }
        return null;
    }

    /**
     * 实现将日期转换成制定格式的Timestamp类型
     *
     * @param date
     * @param format
     * @return
     */
    public static Timestamp dateChange(java.util.Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        if (date != null) {
            try {
                return new java.sql.Timestamp(df.parse(df.format(date)).getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 实现日期和天数相加
     *
     * @param date
     * @param days
     * @return 返回相加后的字符串型日期
     */
    public static java.util.Date daysAdd(String date, Double days) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date newDate = null;
        int day = (int) (double) days;
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(format.parse(date));
            if (days >= 0)
                cal.add(Calendar.DAY_OF_YEAR, day);
            else
                return null;
            newDate = cal.getTime();
            // result = format.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /**
     * 实现日期和天数相加
     *
     * @param date
     * @param days
     * @return 返回相加后的字符串型日期
     */
    public static Date daysAdd(Date date, int days) {
        java.util.Date newDate = null;
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        if (days >= 0)
            cal.add(Calendar.DAY_OF_YEAR, days);
        else
            return null;
        newDate = cal.getTime();

        return newDate;
    }

    /**
     * 计算两个日期相减
     *
     * @param s1
     * @param s2
     * @return 返回小时
     */
    public static double getHour(String s1, String s2) {
        double quot = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");// 设定格式
        java.sql.Timestamp dateTime1 = null;
        java.sql.Timestamp dateTime2 = null;
        try {
            java.util.Date timeDate1 = dateFormat.parse(s1);
            java.util.Date timeDate2 = dateFormat.parse(s2);
            dateTime1 = new java.sql.Timestamp(timeDate1.getTime());
            dateTime2 = new java.sql.Timestamp(timeDate2.getTime());
            quot = dateTime2.getTime() - dateTime1.getTime();
            quot = quot / 1000 / 60 / 60;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quot;
    }

    /**
     * 计算两个日期相减 date2-date1
     *
     * @param date1
     * @param date2
     * @return 返回天数
     */
    public static int getDay(java.util.Date date1, java.util.Date date2) {
        Long quot = date2.getTime() - date1.getTime();
        quot = quot / (1000 * 60 * 60 * 24) + 1;
        return quot.intValue();
    }

    /**
     * 将字符串转化为java.sql.Timestamp类型
     *
     * @param str
     * @return
     */
    public static java.sql.Timestamp stringToDate(String str) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp newDate = null;
        if (str != null && str.length() == 10) {
            try {
                newDate = new java.sql.Timestamp(df.parse(str).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return newDate;
    }

    /**
     * 对于日期是否是星期六，星期天的判断，并进行处理，决定是否顺延到下一天
     *
     * @param date
     * @param delieverySaturday
     * @param delieverySunday
     * @return
     */
    /*
     * public static String filterWeekend(java.util.Date date, String delieverySaturday, String delieverySunday) {
     * DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); Calendar cal = Calendar.getInstance(); cal.setTime(date); int
     * i = cal.get(Calendar.DAY_OF_WEEK); if (i == 7) { if ("0".equals(delieverySaturday)) { date =
     * daysAdd(df.format(date), 1.0); if ("0".equals(delieverySunday)) date = daysAdd(df.format(date), 1.0); } } else if
     * (i == 1) { if ("0".equals(delieverySunday)) date = daysAdd(df.format(date), 1.0); } return df.format(date); }
     */
    /**
     * 计算两个日期相减
     *
     * @param time1
     * @param time2
     * @return 返回天数
     */
    public static double getQuot(Timestamp time1, Timestamp time2) {
        if (time1 != null && time2 != null) {
            double quot = 0;
            // SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
            quot = time1.getTime() - time2.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
            return quot;
        } else
            return 0.;
    }

    // 判断时间s1是否在时间s2之前
    public static boolean compDate(String s1, String s2) {
        int day = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date time1;
        java.util.Date time2;
        try {
            time1 = sf.parse(s1);
            time2 = sf.parse(s2);

            day = (int) ((time2.getTime() - time1.getTime()) / 3600 / 24 / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (day > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判段time1是否在time2之前
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean compDate(Date time1, Date time2) {
        int day = 0;
        day = (int) ((time2.getTime() - time1.getTime()) / 3600 / 24 / 1000);
        if (day > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  判断时间s1是否在时间s2之前
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String compareTo(String s1, String s2) {
        int day = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date time1;
        java.util.Date time2;
        try {
            time1 = sf.parse(s1);
            time2 = sf.parse(s2);

            day = (int) ((time2.getTime() - time1.getTime()) / 3600 / 24 / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (day > 0) {
            return s2;
        } else {
            return s1;
        }
    }

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @param dateString 需要转换为timestamp的字符串
     * @return dataTime timestamp
     */
    public static java.sql.Timestamp stringToTime(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");// 设定格式
        java.sql.Timestamp dateTime = null;
        try {
            if (dateString != null && dateString.length() > 0) {
                java.util.Date timeDate = dateFormat.parse(dateString);// util类型
                dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    public static java.util.Date getYesterday() {
        Calendar c = GregorianCalendar.getInstance();
        c.add(Calendar.DATE, -1);
        return getDateByDate(c.getTime());
    }

    public static java.util.Date parseDate(String datestr, String dateFormate) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormate);
        try {
            return df.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回日期，不带有，即时间为00:00:00
     *
     * @param date
     * @return
     */
    public static java.util.Date getDateByDate(java.util.Date date) {
        String datestr = DateUtil.parseDate(date, "yyyyMMdd");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            return df.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 把日期格式化成中文格式
     */
    synchronized public static String parseCnDate(Date date) {
        return CN_TIME_FORMAT.format(date);
    }

    public static Time getTime(Timestamp now) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return Time.valueOf(sdf.format(now));
    }

    /**
     * 把整型转换成时间（如 12345 转换成 01:23:45）
     *
     * @param intValue
     * @return
     */
    public static String parseIntValueToTime(Integer intValue) {
        String str = "00:00:00";
        if (intValue != null) {

            String _str = String.valueOf(intValue);
            switch (_str.length()) {
                case 1:
                    _str = "00000" + _str;
                    break;
                case 2:
                    _str = "0000" + _str;
                    break;
                case 3:
                    _str = "000" + _str;
                    break;
                case 4:
                    _str = "00" + _str;
                    break;
                case 5:
                    _str = "0" + _str;
                    break;
                case 6:
                    break;
                default:
                    _str = "000000";
                    break;
            }
            str = _str.substring(0, 2) + ":" + _str.substring(2, 4) + ":" + _str.substring(4);
        }
        return str;
    }

    /**
     * 返回指定天数的毫秒
     *
     * @param day int类型的天数
     * */
    public static long getMilliSeconds(int day) {
        return (long) day * 24 * 3600 * 1000;
    }

    /**
     * 获取日期的小时
     *
     * @param date 日期
     * @return 小时(24小时制)
     */
    public static int getHourOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 设置当前日期的为指定小时的日期 2011-11-24 14:23:00 ---18---2011-11-24 18:23:00
     *
     * @param date 日期
     * @param hour 小时(24小时)
     * @return
     */
    public static Date setHourOfDate(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }

    /**
     * 返回当前时间的自定义格式String
     *
     * @param dateFormat
     * @return 自定义格式的日期
     *
     *         自定义支持的格式有： yyyy-MM-dd HH:mm:ss yyyy年MM月dd日 HH时mm分ss秒 yyyy年MM月dd日 HH时mm分 yyyy-MM-dd HH:mm yyyyMMddHH:mm:ss
     *         yyyy-MM-dd yyyyMMdd HHmmss yyyy年MM月dd日 HH:mm:ss" HH时mm分ss秒 ......(很多)
     */
    public static String getDefinableTime(String dateFormat) {
        if (null == dateFormat || "".equals(dateFormat.trim())) {
            return "";
        }
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 返回指定时间的自定义格式String
     *
     * @param dateFormat
     * @return 自定义格式的日期
     *
     *         自定义支持的格式有： yyyy-MM-dd HH:mm:ss yyyy年MM月dd日 HH时mm分ss秒 yyyy年MM月dd日 HH时mm分 yyyy-MM-dd HH:mm yyyyMMddHH:mm:ss
     *         yyyy-MM-dd yyyyMMdd HHmmss yyyy年MM月dd日 HH:mm:ss" HH时mm分ss秒 ......(很多)
     */
    public static String getDefinableTime(Date date, String dateFormat) {
        if (null == date || null == dateFormat || "".equals(dateFormat.trim())) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取YYYY/MM/DD字符串
     *
     * @param date 待格式化日期
     * @return YYYY/MM/DD字符串
     */
    synchronized public static String getYYMMDDWidthSlash(Date date) {
        return YYYYMMDD_SLASH_FORMAT.format(date);
    }

    /**
     * 根据传入的日期格式(yyyy-MM-dd HH:mm:ss)返回yyyyMMddHHmmss格式日期
     *
     * @param date(yyyy-MM-dd HH:mm:ss)
     * @return yyyyMMddHHmmss日期
     */
    public static String getDefinableDateStr(String date) {
        if (date == null) {
            return "";
        }
        return getDefinableTime(getDateOfTimeStr(date), "yyyyMMddHHmmss");
    }

    /**
     * 根据传入的日期格式(yyyyMMddHHmmss)返回yyyy-MM-dd HH:mm:ss格式日期
     *
     * @param date(yyyyMMddHHmmss)
     * @return yyyy-MM-dd HH:mm:ss日期
     */
    public static String getDefinableDate(String date) {
        if (date == null) {
            return "";
        }
        return getDefinableTime(getUtilDateTimeByShortStr(date), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 这个方法有问题，请不要使用！！！！！！
     * 根据传入的日期格式(yyyy-MM-dd HH:mm:ss)返回HHmmss格式日期
     *
     * @param date
     * @return hhMMss日期
     */
    @Deprecated
    public static String getShortStrTime(Date date) {
        return HHMMSS_FORMAT.format(date);
    }

    /**
     * 根据传入的日期格式(yyyy-MM-dd HH:mm:ss)返回HHmmss格式日期
     *
     * @param date
     * @return HHmmss日期
     */
    public static String getShortTimeFormate(Date date) {
        return TIME_FORMATE.format(date);
    }

    /** 
     * 根据用户生日计算年龄 
     */
    public static int getAgeByBirthday(Date birthday) {
        if (birthday == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) {
            return 0;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /** 
     * 获取当期日期间隔n年前的日期
     */
    public static String getHistoryDate(int age) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        cal.set(Calendar.YEAR, year - age);
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return dateStr;
    }

    /**
     *
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param date 日期值
     * @param format 指定的日期格式
     * @return 是否是合法的日期格式
     */
    public static boolean checkDate(String date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = df.parse(date);
        } catch (Exception e) {
            // 如果不能转换,肯定是错误格式
            return false;
        }
        String s1 = df.format(d);
        // 转换后的日期再转换回String,如果不等,逻辑错误.如format为"yyyy-MM-dd",date为
        // "2006-02-31",转换为日期后再转换回字符串为"2006-03-03",说明格式虽然对,但日期
        // 逻辑上不对.
        return date.equals(s1);
    }

    /**
     * 获取当前日期间隔为delay天的日期返回 格式为String类型任意
     *
     * @return
     */
    public static String getSpaceDayStringFormat(int delay, String format) {
        return getDateStringDelayFormat(delay, format);
    }

    /**
     * 获取距离今天 delay 天的日期 返回自定义String格式
     *
     * @param delay
     * @return
     */
    public static String getDateStringDelayFormat(int delay, String format) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, delay);
        return getDefinableTime(c.getTime(), format);
    }

    /**
     * 判断两个时间是否为同一天
     *
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (dateFormat.format(date1).equals(dateFormat.format(date2))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //        int min = 10;
        try {

            String str = getShortStrDate(new Date());
            System.out.println(str);
            String birthday = "19791028";
            Date birthDate = YYYYMMDD_FORMAT.parse(birthday);

            System.out.println(birthDate);
            System.out.println("客户年龄" + getAgeByBirthday(birthDate));

            String date1 = getHistoryDate(35);
            System.out.println(date1);
            String date2 = getHistoryDate(25);
            System.out.println(date2);
            //        System.out.println( "客户生日"+YYYY_MM_DD_FORMAT.format(birthDate));
            //        Date date = offsetDate(birthDate, Calendar.YEAR, min);
            //
            //        System.out.println( "当前日期 "+YYYY_MM_DD_FORMAT.format(YYYYMMDD_FORMAT.parse("20140114")));
            //
            //        System.out.println(date.compareTo(YYYYMMDDHHMMSS_FORMAT.parse("20140113000101")));
            //
            //        long a = date.getTime();
            //        long b = YYYYMMDDHHMMSS_FORMAT.parse("20140115000001").getTime();
            //        System.out.println("生日加10岁time="+ a +":::::当前日期time="+b+":::::::::"+getCurDate().getTime());
            //        if(date.getTime() <= YYYYMMDD_FORMAT.parse("20140114").getTime()){
            //            System.out.println("客户大于等于"+min+"岁");
            //        }
        } catch (ParseException e) {
            System.err.println("================");
        }
        //
        //        System.out.println(getCurDate());
        //    try {
        //        String birthday ="20140114";
        //        Date birthDate;
        //        birthDate = YYYYMMDD_FORMAT.parse(birthday);
        //        System.out.println(getCurDate());
        //        if(DateUtil.compDate(getCurDate(),birthDate)){
        //            System.out.println(getCurDate()+"在"+birthDate+"前边");
        //        }else{
        //            System.out.println(getCurDate()+"在"+birthDate+"后边");
        //        }
        //
        //    } catch (ParseException e) {
        //        System.err.println("this - error");
        //    }
        //
        //
    }
}